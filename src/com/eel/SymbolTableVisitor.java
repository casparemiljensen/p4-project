package com.eel;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import kotlin.NotImplementedError;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SymbolTableVisitor extends ReflectiveASTVisitor {
    SymbolTable symbolTable;
    Errors errors;

    public SymbolTableVisitor(SymbolTable symbolTable, Errors errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {
        if (node.procedureNodes != null) {
            for (ProcedureNode procedureNode : node.procedureNodes) {
                procedureNode.accept(this);
            }
        }
    }
    public void Visit(ProcedureNode node) {
        if (symbolTable.lookupSymbol(node.IdToken.toString()) != null) {
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Function '" + node.IdToken.toString() + "' already exists", node.getColumnNumber(), node.getLineNumber());
        }
        else {
            //Creates and adds the function to the symbol table
            Attributes attributes = new Attributes("function", node.getType());
            symbolTable.insertSymbol(node.IdToken.toString(), attributes);

            //symbolTable.addScope(node.getNodeHash());
            for (StatementNode statementNode : node.StatementNodes) {
                statementNode.accept(this);
            }
            symbolTable.leaveScope();
        }
    }

    public void Visit(StatementNode node) {
        if(node != null) {
            if (node.declarationNode != null) {
                node.declarationNode.accept(this);
            } else if (node.controlStructNode != null) {
                node.controlStructNode.accept(this);
            } else if (node.callNode != null) {
                node.callNode.accept(this);
            } else if (node.assignmentNode != null) {
                node.assignmentNode.accept(this);
            } else if (node.returnNode != null) {
                node.returnNode.accept(this);
            }

            // And what about the terminalNode?
            else
                throw new NotImplementedError();
        }
        else
            throw new NullPointerException();
    }

    public void Visit(DeclarationNode node) {
        if(node != null) {
            declareNode(node, node.getType());

            if(node.assignmentNode != null) {
                node.assignmentNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }

//
//    public void Visit(DeclarationNode node) {
//        if(node != null) {
//
//            strBlr.append(getIndentation()).append("let ").append(node.IdToken);
//            increaseIndent();
//            if(node.assignmentNode != null) {
//                strBlr.append("=");
//                node.assignmentNode.accept(this);
//            }
//            strBlr.append("\n");
//            decreaseIndent();
//        }
//        else
//            throw new NullPointerException();
//    }

    public void Visit(ControlStructNode node) {
        if(node != null) {
        }
        else
            throw new NullPointerException();
    }

    public void Visit(RepeatStructNode node) {
        if (node != null) {
        } else {
            throw new NullPointerException();
        }
    }

    public void Visit(IfStructNode node) {
        if(node != null) {

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
        // Hackish char null check
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
        if(node != null) {
            if (node.left != null && node.operatorNode != null && node.right != null) {
                node.left.accept(this);
                node.operatorNode.accept(this);
                node.right.accept(this);

                System.out.println("left type: " + node.left.getType());
                if (node.left.getType() != node.right.getType()) errors.addEntry(ErrorType.TYPE_ERROR,"Not same type in infix expression", node.getLineNumber(), node.getColumnNumber());
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ValueExprNode node) {
        if(node != null) {
            if (node.valueNode != null) {
                node.valueNode.accept(this);

            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ValueNode node) {
        if(node != null) {

            if (node.staticValueNode != null) {
                node.staticValueNode.accept(this);
            } else if (node.userValueNode != null) {
                node.userValueNode.accept(this);
            } else
                throw new NotImplementedError();
            System.out.println("value nodes static " + node.staticValueNode.getType());
            node.setType(node.staticValueNode.getType());
        }
        else
            throw new NullPointerException();
    }

    public void Visit(StaticValueNode node) {
        if(node != null) {
            if (node.STRING != null) {
                node.setType(Type.String);
            } else if (node.INUM != null) {
                node.setType(Type.Integer);
            } else if (node.FUNCTION != null) {
                node.setType(Type.Function);
            }
            if (node.methodNode != null) {
                node.methodNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }


    private void declareNode(DeclarationNode node, Enum<Type> type) {
        //Enters if the node is not already in the symbol table
        if (!isDeclared(node)) {
            //Creates and adds the node to the symbol table
            Attributes attribute = new Attributes("dcl", type);
            symbolTable.insertSymbol(node.IdToken.toString(), attribute);
        }

    }

    private boolean isDeclared(DeclarationNode node) {
        if (symbolTable.lookupSymbol(node.IdToken.toString()) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.IdToken.toString() + "' already exists", node.getLineNumber(), node.getColumnNumber());
            // node.type = symbolTable.lookupSymbol(node.IdToken.toString()).getVariableType();

            return true;
        }
        return false;
    }

    public void Visit(UserValueNode node) {
        if(node != null) {
            if (node.ID != null) {
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(OperatorNode node) {
        if(node != null) {
            if (node.binaryOperatorNode != null) {
                node.binaryOperatorNode.accept(this);
            }
            else if (node.booleanOperatorNode != null) {
                node.booleanOperatorNode.accept(this);
            }
            else
                throw new NotImplementedError();
        }
        else
            throw new NullPointerException();
    }

    public void Visit(BinaryOperatorNode node) {
        if(node != null) {
            if (node.binaryOperator != null) {
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(BooleanOperatorNode node) {
        if (node != null) {
            if (node.booleanOperator != null) {
            }
        }
        else
            throw new NullPointerException();
    }

    @Override
    public void defaultVisit(Object o) {

    }
}
