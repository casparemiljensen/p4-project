package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.AbstractNode;
import com.eel.AST.nodes.ProgramNode;
import com.eel.errors.Errors;

public class TypeCheckVisitor extends ReflectiveASTVisitor {

    SymbolTable symbolTable;
    Errors errors;

    public TypeCheckVisitor(SymbolTable symbolTable, Errors errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void Visit(ProgramNode node) {

    }

    @Override
    public void defaultVisit(Object o) {

    }
}
