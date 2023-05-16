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
            node.assignmentNode.accept(this);
        } else if (node.cellNode != null) {
            node.cellNode.accept(this);
            node.assignmentNode.accept(this);
        } else if (node.returnNode != null) {
            node.returnNode.accept(this);
        }  else
            throw new NotImplementedError();
    }




    public void Visit(DeclarationNode node) {
        if(node != null) {
            if(node.assignmentNode != null) {
                node.assignmentNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(AssignmentNode node) {
        if(node != null) {
            if(node.expressionNode != null) {
                node.expressionNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ExpressionNode node) {
        if(node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
            }
            else if (node.unaryExprNode != null) {
                node.unaryExprNode.accept(this);
            }
            else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
            }
            else if (node.valueExprNode != null) {
                node.valueExprNode.accept(this);
            }
            else
                throw new NotImplementedError();
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ParenExprNode node) {
        if(node != null) {
            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
                node.expressionNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(UnaryExprNode node) {
        if(node != null) {
            if (node.right != null && node.operator != null) {
                node.right.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }



    public void Visit(InfixExprNode node) {
            if (node.left != null && node.operatorNode != null && node.right != null) {
                node.left.accept(this);
                node.operatorNode.accept(this);
                node.right.accept(this);
                System.out.println("left: " + node.left.getType() + "| operator: " + node.operatorNode.getSymbol() + "| right: " + node.right.getType());

                if (node.left.getType() != node.right.getType()) {
                    Enum<Type> left = node.left.getType();
                    Enum<Type> right = node.right.getType();
                    String operator = node.operatorNode.getSymbol();

                    if (operator.equals("+") && (left == Type.String || right == Type.String)) node.setType(Type.String);
                    else if(left == Type.Integer && right == Type.Float) node.setType(Type.Float);
                    else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
                    else errors.addEntry(ErrorType.IMPLICIT_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + node.left.getType() + " and " + node.right.getType() + ".", node.getLineNumber(), node.getColumnNumber());
            }
        }
    }



    @Override
    public void defaultVisit(Object o) {

    }
}
