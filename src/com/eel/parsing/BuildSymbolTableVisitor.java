package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import com.eel.helpers.HashCodeGenerator;
import kotlin.NotImplementedError;
import org.antlr.v4.runtime.tree.TerminalNode;

public class BuildSymbolTableVisitor extends ReflectiveASTVisitor {
    SymbolTable symbolTable;
    Errors errors;

    public BuildSymbolTableVisitor(SymbolTable symbolTable, Errors errors) {

        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {
        symbolTable.addScope(symbolTable.globalScope.getScopeName());
        if (node.procedureNodes != null) {
            for (ProcedureNode procedureNode : node.procedureNodes) {
                procedureNode.accept(this);
            }
        }
    }

    public void Visit(ProcedureNode node) {
        if (symbolTable.lookupSymbol(node.procedureDeclarationNode.procedureToken.toString()) == null) {
            node.setType(Type.Procedure);
            Attributes attributes = new Attributes(Type.Procedure, Type.Void);
            symbolTable.insertSymbol(node.procedureDeclarationNode.procedureToken.toString(), attributes);

            if (symbolTable.addScope(node.procedureDeclarationNode.procedureToken.toString())) {
                for (StatementNode statementNode : node.StatementNodes) {
                    statementNode.accept(this);
                }

                if (node.procedureDeclarationNode.formalParametersNode != null) {
                    node.procedureDeclarationNode.formalParametersNode.accept(this);
                }

                symbolTable.leaveScope(node.procedureDeclarationNode.procedureToken.toString());
            } else {
                errors.addEntry(ErrorType.DUPLICATE_PROCEDURE, "Procedure " + node.procedureDeclarationNode.procedureToken.toString() + "' already exists", node.procedureDeclarationNode.getLineNumber(), node.procedureDeclarationNode.getColumnNumber());
            }

        } else {
            errors.addEntry(ErrorType.DUPLICATE_PROCEDURE, "Procedure " + node.procedureDeclarationNode.procedureToken.toString() + "' already exists", node.getLineNumber(), node.getColumnNumber());
        }
    }


    public void Visit(StatementNode node) {
        if (node != null) {
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
        } else
            throw new NullPointerException();
    }

    public void Visit(DeclarationNode node) {
        if (node != null) {
            if (symbolTable.lookupSymbol(node.IdToken.toString()) == null) {
                var type = Type.Uninitialized;
                if (node.assignmentNode != null) {
                    type = Type.Initialized;
                    node.assignmentNode.accept(this);
                }
                Attributes attributes = new Attributes(Type.Variable, type);
                symbolTable.insertSymbol(node.IdToken.toString(), attributes);
            } else {
                errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Variable " + node.IdToken + "' already exists", node.getLineNumber(), node.getColumnNumber());
            }
        }
    }


    public void Visit(ControlStructNode node) {
        if (node != null) {
            if (node.iterativeStructNode != null) {
                node.iterativeStructNode.repeatStructNode.accept(this);
            } else if (node.selectiveStructNode != null) {
                node.selectiveStructNode.ifStructNode.accept(this);
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }







    public void Visit(RepeatStructNode node) {
        if (node != null) {

            String hashedName = HashCodeGenerator.generateHashNameFromObject("repeat", node);
            if (symbolTable.addScope(hashedName)) {

                node.expressionNode.accept(this);

                if (node.statementNodes != null) {
                    node.statementNodes.forEach(s -> s.accept(this));
                }

                symbolTable.leaveScope(hashedName);
            } else {
                errors.addEntry(ErrorType.DUPLICATE_SCOPE, "A scope with the same hashcode already exists : " + node.getLineNumber() + node.getColumnNumber());
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void Visit(IfStructNode node) {
        if (node != null) {

            String hashedName = HashCodeGenerator.generateHashNameFromObject("if", node);
            if (symbolTable.addScope(hashedName)) {

                node.ifConditionNode.expressionNode.accept(this);

                if (node.statementNodes != null) {
                    node.statementNodes.forEach(s -> s.accept(this));
                }

                if (node.elseIfStructNodes != null) {
                    node.elseIfStructNodes.forEach(s -> s.accept(this));
                }
                if (node.elseStructNode != null) {
                    node.elseStructNode.accept(this);
                }

                symbolTable.leaveScope(hashedName);
            } else {
                errors.addEntry(ErrorType.DUPLICATE_SCOPE, "A scope with the same hashcode already exists : " + node.getLineNumber() + node.getColumnNumber());
            }
        } else {
            throw new NullPointerException();
        }
    }


    public void Visit(ElseIfStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("elseif", node);
            if (symbolTable.addScope(hashedName)) {

                node.ifConditionNode.expressionNode.accept(this);
                if (node.statementNodes != null) {
                    node.statementNodes.forEach(s -> s.accept(this));
                }

                symbolTable.leaveScope(hashedName);
            } else {
                errors.addEntry(ErrorType.DUPLICATE_SCOPE, "A scope with the same hashcode already exists : " + node.getLineNumber() + node.getColumnNumber());
            }
        }
    }

    public void Visit(ElseStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("else", node);

            if (symbolTable.addScope(hashedName)) {

                if (node.statementNode != null) {
                    node.statementNode.forEach(s -> s.accept(this));
                }

                symbolTable.leaveScope(hashedName);
            } else {
                errors.addEntry(ErrorType.DUPLICATE_SCOPE, "A scope with the same hashcode already exists : " + node.getLineNumber() + node.getColumnNumber());
            }
        }
    }


    public void Visit(AssignmentNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                node.expressionNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

//    public void Visit(ExpressionNode node) {
//        if (node != null) {
//            if (node.parenExprNode != null) {
//                node.parenExprNode.accept(this);
//                node.setType(node.parenExprNode.getType());
//            } else if (node.unaryExprNode != null) {
//                node.unaryExprNode.accept(this);
//                node.setType(node.unaryExprNode.getType());
//            } else if (node.infixExprNode != null) {
//                node.infixExprNode.accept(this);
//                node.setType(node.infixExprNode.getType());
//            } else if (node.valueExprNode != null) {
//                node.valueExprNode.accept(this);
//                node.setType(node.valueExprNode.getType());
//                node.setName(node.valueExprNode.getName());
//            } else
//                throw new NotImplementedError();
//        } else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ParenExprNode node) {
//        // Hackish char null check
//        if (node != null) {
//            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
//                node.expressionNode.accept(this);
//                node.setType(node.expressionNode.getType());
//            }
//        } else
//            throw new NullPointerException();
//    }

//    public void Visit(UnaryExprNode node) {
//        if (node != null) {
//            if (node.right != null && node.operator != null) {
//                node.right.accept(this);
//                node.setType(node.right.getType());
//            }
//        } else
//            throw new NullPointerException();
//    }

//    public void Visit(InfixExprNode node) {
//        if (node != null) {
//            if (node.left != null && node.operatorNode != null && node.right != null) {
//                node.left.accept(this);
//                node.operatorNode.accept(this);
//                node.right.accept(this);
//            }
//
//        } else
//            throw new NullPointerException();
//    }

//    public void Visit(ValueExprNode node) {
//        if (node != null) {
//            if (node.valueNode != null) {
//                node.valueNode.accept(this);
//                node.setType(node.valueNode.getType());
//                node.setName(node.valueNode.getName());
//            }
//        } else
//            throw new NullPointerException();
//    }

//    public void Visit(ValueNode node) {
//        if (node != null) {
//            if (node.STRING != null) {
//                node.setType(Type.String);
//            } else if (node.INUM != null) {
//                node.setType(Type.Integer);
//            } else if (node.FLOAT != null) {
//                node.setType(Type.Float);
//            } else if (node.VARIABLE != null) {
//                node.setType(Type.Variable);
//                node.setName(node.VARIABLE.toString());
//            } else if (node.BOOLEAN != null) {
//                node.setType(Type.Boolean);
//            } else if (node.cellNode != null) {
//                if (node.cellNode.SINGLE_CELL != null)
//                    node.setType(Type.SingleCell);
//                else if (node.cellNode.RANGE != null)
//                    node.setType(Type.Range);
//                else throw new NotImplementedError();
//
//                // Skal vi stadig sætte de her typer???
//
//                if (node.cellNode.CELL_METHOD != null) {
//                    if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.SINGLE_CELL != null)
//                        node.setType(Type.Integer);
//                    else if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.RANGE != null)
//                        node.setType(Type.Array);
//                    else if (node.cellNode.CELL_METHOD.toString() == "format") node.setType(node.getType());
//                    else throw new NotImplementedError();
//                }
//            }
//            if (node.methodNode != null) {
//                node.methodNode.accept(this);
//            }
//        } else
//            throw new NullPointerException();
//    }

//    public void Visit(OperatorNode node) {
//        if (node != null) {
//            if (node.binaryOperatorNode != null) {
//                node.setSymbol(node.binaryOperatorNode.binaryOperator.toString());
//            } else if (node.booleanOperatorNode != null) {
//                node.setSymbol(node.booleanOperatorNode.booleanOperator.toString());
//            } else if (node.assignment != null) {
//                node.setSymbol("=");
//            } else throw new NotImplementedError();
//        } else
//            throw new NullPointerException();
//    }

    public void Visit(FormalParametersNode node) {
        if (node != null) {

            for (TerminalNode t : node.IDs) {
                if (symbolTable.lookupSymbol(t.toString()) == null) {
                    node.setType(Type.FormalParam);
                    Attributes attributes = new Attributes(node.getType(), Type.Unresolved);
                    symbolTable.insertParam(t.toString(), attributes);
                }
            }

        } else
            throw new NullPointerException();
    }

//    public void Visit(CellNode node) {
//        if (node != null) {
//
//            if (node.SINGLE_CELL != null) {
//                if (symbolTable.lookupSymbol(node.SINGLE_CELL.toString()) == null) {
//                    node.setType(Type.Variable);
//                    Attributes attributes = new Attributes(node.getType(), Type.Initialized, symbolTable.currentScope);
//                    symbolTable.insertSymbol(node.SINGLE_CELL.toString(), attributes);
//                } else {
//                    errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Variable " + node.SINGLE_CELL + "' already exists", node.getLineNumber(), node.getColumnNumber());
//                }
//
//
//            } else if (node.RANGE != null) {
//                if (symbolTable.lookupSymbol(node.RANGE.toString()) == null) {
//                    node.setType(Type.Variable);
//                    Attributes attributes = new Attributes(node.getType(), Type.Initialized, symbolTable.currentScope);
//                    symbolTable.insertSymbol(node.RANGE.toString(), attributes);
//                } else {
//                    errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Variable " + node.RANGE + "' already exists", node.getLineNumber(), node.getColumnNumber());
//                }
//
//            } else
//                throw new NotImplementedError();
//        } else
//            throw new NullPointerException();
//    }
    public void Visit(ReturnNode node) {
        if (node != null) {
            if (symbolTable.lookupSymbol("Return") == null) {
                node.setType(Type.Return);
                Attributes attributes = new Attributes(Type.Return, Type.Unresolved);
                symbolTable.insertSymbol("Return", attributes);
            }
            else errors.addEntry(ErrorType.DUPLICATE_RETURN, "procedure " + symbolTable.currentScope.getScopeName().toString() + " already has a return statement", node.getLineNumber(), node.getColumnNumber());
        } else throw new NullPointerException();
}


    @Override
    public void defaultVisit(Object o) {

    }
}
