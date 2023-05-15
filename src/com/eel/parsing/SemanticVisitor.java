package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.AbstractNode;
import com.eel.AST.nodes.ProgramNode;
import com.eel.errors.Errors;

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
                if (symbolTable.lookupSymbol(procedureNode.procedureDeclarationNode.procedureToken.toString()) == null) {
                    System.out.println("no such symbol exists");
                    // errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Procedure " + procedureNode.procedureDeclarationNode.procedureToken.toString() + "' already exists", node.getColumnNumber(), node.getLineNumber());
                }
                else {
                    symbolTable.enterScope(procedureNode.procedureDeclarationNode.procedureToken.toString());
                    procedureNode.accept(this);
                    symbolTable.leaveScope();
                }
            }
    }

    }

    @Override
    public void defaultVisit(Object o) {

    }
}
