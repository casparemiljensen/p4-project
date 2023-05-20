package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import com.eel.helpers.HashCodeGenerator;
import kotlin.NotImplementedError;

public class VariableDeclarationVisitor extends ReflectiveASTVisitor {

    SymbolTable symbolTable;
    Errors errors;

    public VariableDeclarationVisitor(SymbolTable symbolTable, Errors errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {
        node.procedureNodes.forEach(p -> p.accept(this));
    }

    public void Visit(ProcedureNode node) {
        if (node.StatementNodes != null) {

            symbolTable.enterScope(node.procedureDeclarationNode.procedureToken.toString());
            for (StatementNode statementNode : node.StatementNodes) {
                statementNode.accept(this);
            }
            symbolTable.leaveScope();
        }
    }

    public void Visit(StatementNode node) {
        if (node.declarationNode != null) {
            node.declarationNode.accept(this);
        } else if (node.controlStructNode != null) {
            node.controlStructNode.accept(this);
        } else if (node.functionCallNode != null) {
            node.functionCallNode.accept(this);
        } else if (node.procedureCallNode != null) {
            node.procedureCallNode.accept(this);
        } else if (node.terminal != null) {
            if (symbolTable.lookupSymbol(node.terminal.toString()) == null) {
                errors.addEntry(ErrorType.UNDECLARED_VARIABLE, "The variable " + node.terminal.toString() + " has not been declared", node.getLineNumber(), node.getColumnNumber());
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
            if (symbolTable.lookupSymbol(node.IdToken.toString()) == null) {
                errors.addEntry(ErrorType.UNDECLARED_VARIABLE, "The variable " + node.IdToken.toString() + " has not been declared", node.getLineNumber(), node.getColumnNumber());
            }

        } else
            throw new NullPointerException();
    }


    public void Visit(ValueNode node) {
        if (node != null) {
            if (node.VARIABLE != null) {
                if (symbolTable.lookupSymbol(node.VARIABLE.toString()) == null) {
                    errors.addEntry(ErrorType.UNDECLARED_VARIABLE, "The variable: " + node.VARIABLE.toString() + " has not been declared", node.getLineNumber(), node.getColumnNumber());
                }
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ProcedureCallNode node) {
        if (node != null) {

            if (symbolTable.lookupSymbol(node.PROCEDURE.toString()) != null) {
                // Retrieve procedure information from the symbol table
                // Check count for both
                symbolTable.enterScope(node.PROCEDURE.toString());
                if (node.actualParamsNode != null) {
                    // Making sure that amount of formalParams == actualParams
                    if (symbolTable.currentScope.getParams().size() != node.actualParamsNode.valuesNodes.size()) {
                        errors.addEntry(ErrorType.PARAMETERS_COUNT_MISMATCH, symbolTable.currentScope.getParams().size() + " parameters expected, " + node.actualParamsNode.valuesNodes.size() + " provided", node.getLineNumber(), node.getColumnNumber());
                    } else {
                        // Only visiting if there is some actualParams
                    }
                } else {
                    if (symbolTable.currentScope.getParams().size() > 0) {
                        errors.addEntry(ErrorType.PARAMETERS_COUNT_MISMATCH, symbolTable.currentScope.getParams().size() + " parameter(s) expected, 0 provided", node.getLineNumber(), node.getColumnNumber());
                    }
                }
                symbolTable.leaveScope(node.PROCEDURE.toString());
            } else {
                errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, " A procedure with the name: '" + node.PROCEDURE.toString() + "' does not exist", node.getLineNumber(), node.getColumnNumber());
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
            symbolTable.enterScope(hashedName);
            node.expressionNode.accept(this);
            if (node.statementNodes != null) {
                node.statementNodes.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);
        } else {
            throw new NullPointerException();
        }
    }

    public void Visit(IfStructNode node) {
        if (node != null) {

            String hashedName = HashCodeGenerator.generateHashNameFromObject("if", node);
            symbolTable.enterScope(hashedName);
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
            throw new NullPointerException();
        }
    }

    public void Visit(ElseIfStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("elseif", node);
            symbolTable.enterScope(hashedName);
            node.ifConditionNode.expressionNode.accept(this);
            if (node.statementNodes != null) {
                node.statementNodes.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);

        }
    }

    public void Visit(ElseStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("else", node);
            symbolTable.enterScope(hashedName);
            if (node.statementNode != null) {
                node.statementNode.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);
        }
    }

    @Override
    public void defaultVisit(Object o) {

    }
}
