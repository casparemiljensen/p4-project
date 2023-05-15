package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import kotlin.NotImplementedError;

import java.util.Map;

public class BuildSymbolTableVisitor extends ReflectiveASTVisitor {

    SymbolTable symbolTable;
    Errors errors;

    public BuildSymbolTableVisitor(SymbolTable symbolTable, Errors errors){

        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {
        if (node.procedureNodes != null) {
            for (ProcedureNode procedureNode : node.procedureNodes) {
                if (symbolTable.lookupSymbol(procedureNode.procedureDeclarationNode.procedureToken.toString()) == null) {
                    Attributes attributes = new Attributes("procedure", node.getType());
                    symbolTable.insertSymbol(procedureNode.procedureDeclarationNode.procedureToken.toString(), attributes);
                    symbolTable.addScope(procedureNode.procedureDeclarationNode.procedureToken.toString());
                    procedureNode.accept(this);
                    symbolTable.leaveScope(procedureNode.procedureDeclarationNode.procedureToken.toString()); }
                else {
                    errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Procedure " + procedureNode.procedureDeclarationNode.procedureToken.toString() + "' already exists", node.getColumnNumber(), node.getLineNumber());
                }
            }
        }
        printSymbolTable();
    }
    public void Visit(ProcedureNode node) {
        if (node != null) {
            //Creates and adds the function to the symbol table

            for (StatementNode statementNode : node.StatementNodes) {
                statementNode.accept(this);
            }
        }
    }



    public void Visit(StatementNode node) {
        if(node != null) {
            if (node.declarationNode != null) {
                node.declarationNode.accept(this);
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
                if (symbolTable.lookupSymbol(node.IdToken.toString()) == null) {
                    Attributes attributes = new Attributes("dcl", node.getType());
                    symbolTable.insertSymbol(node.IdToken.toString(), attributes);
                }
                else {
                    errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Procedure " + node.IdToken + "' already exists", node.getColumnNumber(), node.getLineNumber());
                }
            }

            if(node.assignmentNode != null) {
                node.assignmentNode.accept(this);
            }
        }
        else
            throw new NullPointerException();
    }

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
                node.setType(node.parenExprNode.getType());
            }
            else if (node.unaryExprNode != null) {
                node.unaryExprNode.accept(this);
                node.setType(node.unaryExprNode.getType());
            }
            else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
                node.setType(node.infixExprNode.getType());
            }
            else if (node.valueExprNode != null) {
                node.valueExprNode.accept(this);
                node.setType(node.valueExprNode.getType());
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
                node.setType(node.expressionNode.getType());
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(UnaryExprNode node) {
        if(node != null) {
            if (node.right != null && node.operator != null) {
                node.right.accept(this);
                node.setType(node.right.getType());
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

                if (node.left.getType() != node.right.getType()) {
//                    errors.addEntry(ErrorType.IMPLICIT_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + node.left.getType() + " and " + node.right.getType() + ".", node.getLineNumber(), node.getColumnNumber());
                }
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ValueExprNode node) {
        if(node != null) {
            if (node.valueNode != null) {
                node.valueNode.accept(this);
                node.setType(node.valueNode.getType());
            }
        }
        else
            throw new NullPointerException();
    }

    public void Visit(ValueNode node) {
        if(node != null) {
            if (node.STRING != null) {
                node.setType(Type.String);
            }
            else if (node.INUM != null) {
                node.setType(Type.Integer);
            }
            else if(node.FLOAT != null) {
                node.setType(Type.Float);
            }
            else if (node.VARIABLE != null) {
                node.setType(Type.Variable);
            }
            else if (node.BOOLEAN != null) {
                node.setType(Type.Boolean);
            }
            else if (node.cellNode != null) {
                if (node.cellNode.SINGLE_CELL != null)
                    node.setType(Type.SingleCell);
                else if (node.cellNode.RANGE != null)
                    node.setType(Type.Range);
                else throw new NotImplementedError();
                if (node.cellNode.CELL_METHOD != null) {
                    if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.SINGLE_CELL != null) node.setType(Type.Integer);
                    else if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.RANGE != null) node.setType(Type.Array);
                    else if (node.cellNode.CELL_METHOD.toString() == "format") node.setType(node.getType());
                    else throw new NotImplementedError();
                }
            }
            if (node.methodNode != null) {
                node.methodNode.accept(this);
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


    private void printSymbolTable() {
        printScope(symbolTable.globalScope);
    }

    private void printScope(EelScope scope) {
        System.out.println("Scope: " + scope.getScopeName());
        System.out.println("Symbols:");
        for (Map.Entry<String, Attributes> entry : scope.getSymbols().entrySet()) {
            String symbol = entry.getKey();
            Attributes attributes = entry.getValue();
            System.out.println("  Symbol: " + symbol);
            System.out.println("  Attributes:");
            System.out.println("    Type: " + attributes.getKind());
            // Add more attribute printing if needed
            System.out.println();
        }

        for (EelScope childScope : scope.children) {
            printScope(childScope);
        }
    }
}
