package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import kotlin.NotImplementedError;

import javax.sound.midi.SysexMessage;

public class SemanticVisitor extends ReflectiveASTVisitor {

    SymbolTable symbolTable;
    Errors errors;

    public SemanticVisitor(SymbolTable symbolTable, Errors errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {
        if (node.procedureNodes != null)
            for (ProcedureNode procedureNode : node.procedureNodes) {
                symbolTable.enterScope(procedureNode.procedureDeclarationNode.procedureToken.toString());
                procedureNode.accept(this);
                symbolTable.leaveScope();
            }
    }

    public void Visit(ProcedureNode node) {
        if (node.StatementNodes != null) {

            for (StatementNode statementNode : node.StatementNodes) {
                statementNode.accept(this);
            }
        }
    }

    public void Visit(StatementNode node) {
        if (node.declarationNode != null) {
            Visit(node.declarationNode);
        } else if (node.controlStructNode != null) {
            node.controlStructNode.accept(this);
        } else if (node.functionCallNode != null) {
            node.functionCallNode.accept(this);
        } else if (node.procedureCallNode != null) {
            node.procedureCallNode.accept(this);
        } else if (node.terminal != null) {
            if (symbolTable.lookupSymbol(node.terminal.toString()) != null) {
                node.assignmentNode.accept(this);
                Attributes attributes = symbolTable.lookupSymbol(node.terminal.toString());
                attributes.setDataType(node.assignmentNode.getType());
            }
        } else if (node.cellNode != null) {
            node.cellNode.accept(this);
            node.assignmentNode.accept(this);
        } else if (node.returnNode != null) {
            node.returnNode.accept(this);
        } else
            throw new NotImplementedError();
    }


    public void Visit(DeclarationNode node) {
        if (node != null) {
            if (node.assignmentNode != null) {
                node.assignmentNode.accept(this);
                Attributes attributes = symbolTable.lookupSymbol(node.IdToken.toString());
                attributes.setDataType(node.assignmentNode.getType());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(AssignmentNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                node.expressionNode.accept(this);
                node.setType(node.expressionNode.getType());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ProcedureCallNode node) {
        if (node != null) {

            if (symbolTable.lookupSymbol(node.PROCEDURE.toString()) != null) {


            } else
                System.out.println("Procedure: " + node.PROCEDURE.toString() + " does not exist...");
        } else
            throw new NullPointerException();
    }

    public void Visit(ExpressionNode node) {
        if (node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
                node.setType(node.parenExprNode.getType());
            } else if (node.unaryExprNode != null) {
            } else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
                node.setType(node.infixExprNode.getType());
            } else if (node.valueExprNode != null) {
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    // Nødvendigt onde at have denne i SemanticVisitor. Vi ville hellere have visit(ParenExprNode) i BSTV, Så vi kun har typeChecking logikken her i SemanticVisitor.
    // Desværre besøger ExpressionNode, som kan besøge InfixExpressionNod, der først får sin type her i SemanticVisitor
    public void Visit(ParenExprNode node) {
        // Hackish char null check
        if (node != null) {
            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
                node.expressionNode.accept(this);
                node.setType(node.expressionNode.getType());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(InfixExprNode node) {
        if (node.left != null && node.operatorNode != null && node.right != null) {
            node.left.accept(this);
            node.operatorNode.accept(this);
            node.right.accept(this);

            Enum<Type> left = node.left.getType();
            Enum<Type> right = node.right.getType();
            String operator = node.operatorNode.getSymbol();

//            if (left == Type.Unresolved) {
//                System.out.println("Nodename: " + node.left.getName());
//
//                if (symbolTable.lookupSymbol(node.left.getName()) != null) {
//                    System.out.println("Nodename: " + node.left.getName());
//                }
//            }
//            if (right == Type.Unresolved) {
//
//            }


            if (left == Type.Variable) {
                if (symbolTable.lookupSymbol(node.left.getName()) != null) {
                    if (symbolTable.lookupSymbol(node.left.getName()).getDataType() == Type.Uninitialized)
                        System.out.println(node.left.getName() + " has not been assigned a VALUE");
                    else if (symbolTable.lookupSymbol(node.left.getName()).getDataType() == Type.Unresolved) {
                        System.out.println("");
                    }
                    left = symbolTable.lookupSymbol(node.left.getName()).getDataType();
                }
            } else {
                // TJEK I PAREN cope hvis nuværende er i eller else if eller else
                System.out.println(node.left.getName() + " has not been DECLARED");
            }


            if (right == Type.Variable) {
                if (symbolTable.lookupSymbol(node.right.getName()) != null) {
                    if (symbolTable.lookupSymbol(node.right.getName()).getDataType() == Type.Uninitialized)
                        System.out.println(node.right.getName() + " has not been assigned a VALUE");
                    right = symbolTable.lookupSymbol(node.right.getName()).getDataType();
                } else {
                    // TJEK I PAREN cope hvis nuværende er i eller else if eller else
                    System.out.println(node.right.getName() + " has not been DECLARED");
                }
            }

            if (left != right) {

                if (operator.equals("+") && (left == Type.String || right == Type.String)) node.setType(Type.String);
                    // Ikke slet!
//                    else if (!operator.equals("+") && (right != Type.Integer || right != Type.Float)) errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "righthand side of expression can only be number", node.getLineNumber(), node.getColumnNumber());
                else if (left == Type.Integer && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
                else
                    errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());
            } else node.setType(node.left.getType());
        }
    }


    @Override
    public void defaultVisit(Object o) {

    }
}
