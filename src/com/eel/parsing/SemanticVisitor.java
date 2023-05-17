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
            node.declarationNode.accept(this);
            node.setType(node.declarationNode.getType());
            System.out.println();
        } else if (node.controlStructNode != null) {
            node.controlStructNode.accept(this);
        } else if (node.functionCallNode != null) {
            node.functionCallNode.accept(this);
        } else if (node.procedureCallNode != null) {
            node.procedureCallNode.accept(this);
        } else if (node.terminal != null && node.assignmentNode != null) {
            // Variable
            node.assignmentNode.accept(this);
            System.out.println();

            if (symbolTable.lookupSymbol(node.terminal.toString()) != null) {
                Attributes attributes = symbolTable.lookupSymbol(node.terminal.toString());
                attributes.setDataType(node.assignmentNode.getType());
                System.out.println(attributes.getDataType());
                symbolTable.insertSymbol(node.terminal.toString(), attributes);
            } else {
                errors.addEntry(ErrorType.UNDECLARED_VARIABLE, "The variable: " + node.terminal.toString() + " has not been declared");
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
                node.setType(node.assignmentNode.getType());

                // If declaration contains an assignmentNode, we want to update the datatype of the dcl to that of the assign...
                if (symbolTable.lookupSymbol(node.IdToken.toString()) != null) {
                    Attributes attributes = symbolTable.lookupSymbol(node.IdToken.toString());
                    attributes.setDataType(node.assignmentNode.getType());
                    symbolTable.insertSymbol(node.IdToken.toString(), attributes);
                }
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

    public void Visit(ExpressionNode node) {
        if (node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
                node.setType(node.parenExprNode.getType());
            } else if (node.unaryExprNode != null) {
                node.setType(node.unaryExprNode.getType());
            } else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
                node.setType(node.infixExprNode.getType());
            } else if (node.valueExprNode != null) {
                node.setType(node.valueExprNode.getType());
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

            if (left == Type.Variable) {
                if (node.left != null) {

                    // Checking if the variable exists in the symbol table.
                    if (symbolTable.lookupSymbol(node.left.valueExprNode.valueNode.VARIABLE.toString()) != null) {
                        if (symbolTable.lookupSymbol(node.left.valueExprNode.valueNode.VARIABLE.toString()).getDataType() == Type.Uninitialized) {
                            System.out.println(node.left.valueExprNode.valueNode.VARIABLE.toString() + " has not been assigned a VALUE");

                            left = symbolTable.lookupSymbol(node.left.valueExprNode.valueNode.VARIABLE.toString()).getDataType();
                        }
                    } else {
                        System.out.println(node.left + " has not been DECLARED");
                    }
                }
            }

            if (right == Type.Variable) {
                if (node.right != null) {

                    // Checking if the variable exists in the symbol table.
                    if (symbolTable.lookupSymbol(node.right.valueExprNode.valueNode.VARIABLE.toString()) != null) {
                        if (symbolTable.lookupSymbol(node.right.valueExprNode.valueNode.VARIABLE.toString()).getDataType() == Type.Uninitialized) {
                            System.out.println(node.right.valueExprNode.valueNode.VARIABLE.toString() + " has not been assigned a VALUE");

                            right = symbolTable.lookupSymbol(node.right.valueExprNode.valueNode.VARIABLE.toString()).getDataType();
                        } else {
                            System.out.println(node.left + " has not been DECLARED");
                        }
                    }
                }
            }

            // Determine what to do when the two sides are not the same type.
            if (left != right) {
//                System.out.println("Operator: " + operator);
//                switch (operator) {
//
//                    case "+":
//                        if (left == Type.String || right == Type.String)
//                            node.setType(Type.String);
//                        else if (left == Type.Integer && right == Type.Float)
//                            node.setType(Type.Float);
//                        else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
//                        else
//                            errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());
//                        break;
//                    default:
//                        break;
//                }

                if (operator.equals("+") && (left == Type.String || right == Type.String)) {
                    node.setType(Type.String);
                }
//                 Ikke slet!
//                    else if (!operator.equals("+") && (right != Type.Integer || right != Type.Float)) errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "righthand side of expression can only be number", node.getLineNumber(), node.getColumnNumber());
                else if (left == Type.Integer && right == Type.Float) {
                    node.setType(Type.Float);


                } else if (left == Type.Float && right == Type.Integer) {
                    node.setType(Type.Float);
                } else
                    errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());
            } else {
                // Fejl i det her, hvis left er int og right er string...
                var commonDataType = symbolTable.lookupSymbol(node.left.valueExprNode.valueNode.VARIABLE.toString()).getDataType();
                node.setType(commonDataType);
            }
        }
    }

    @Override
    public void defaultVisit(Object o) {

    }
}
