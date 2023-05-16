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
            if(symbolTable.lookupSymbol(node.IdToken.toString()) != null) {
                errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Variable '" + node.IdToken.toString() + "' already exists", node.getLineNumber(), node.getColumnNumber());
                node.type = symbolTable.lookupSymbol(node.IdToken.toString()).getVariableType();
            }
            if(node.assignmentNode != null) {
                node.assignmentNode.accept(this);
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
                if (node.left.getType() != node.right.getType()) {
                    errors.addEntry(ErrorType.IMPLICIT_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + node.left.getType() + " and " + node.right.getType() + ".", node.getLineNumber(), node.getColumnNumber());
            }
        }
    }



    @Override
    public void defaultVisit(Object o) {

    }
}
