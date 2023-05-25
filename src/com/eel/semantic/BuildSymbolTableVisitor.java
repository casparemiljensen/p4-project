package com.eel.semantic;

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
                if (node.procedureDeclarationNode.formalParametersNode != null) {
                    node.procedureDeclarationNode.formalParametersNode.accept(this);
                }

                for (StatementNode statementNode : node.StatementNodes) {
                    statementNode.accept(this);
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
            else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(DeclarationNode node) {
        if (node != null) {
            if (symbolTable.CanBeAdded(node.IdToken.toString())) {
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

    public void Visit(FormalParametersNode node) {
        if (node != null) {
            for (TerminalNode t : node.variables) {
                if (symbolTable.CanBeAdded(t.toString())) {
                    node.setType(Type.FormalParam);
                    Attributes attributes = new Attributes(node.getType(), Type.Unresolved);
                    symbolTable.insertParam(t.toString(), attributes);
                } else {
                    errors.addEntry(ErrorType.DUPLICATE_VARIABLE, " cannot add the formal parameter: " + t.toString() + " it is already declared elsewhere", node.getLineNumber(), node.getColumnNumber());
                }
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ReturnNode node) {
        if (node != null) {
            if (symbolTable.CanBeAdded("Return")) {
                node.setType(Type.Return);
                Attributes attributes = new Attributes(Type.Return, Type.Unresolved);
                symbolTable.insertSymbol(node.returnToken.toString(), attributes);
            } else
                errors.addEntry(ErrorType.DUPLICATE_RETURN, "procedure " + symbolTable.currentScope.getScopeName().toString() + " already has a return statement", node.getLineNumber(), node.getColumnNumber());
        } else throw new NullPointerException();
    }


    @Override
    public void defaultVisit(Object o) {
    }
}
