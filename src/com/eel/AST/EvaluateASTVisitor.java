package com.eel.AST;

import com.eel.AST.nodes.*;

public class EvaluateASTVisitor extends ReflectiveASTVisitor<AbstractNode> {


    public void Visit(ProgramNode node) {
        System.out.println("");
        System.out.println("Program");
        for(ProcedureNode child : node.procedureNodes) {
            child.accept(this);
        }
    }

    public void Visit(ProcedureNode node) {
        System.out.println("Procedure");
        node.StatementNodes.forEach(e -> e.accept(this));

    }

    public void Visit(StatementNode node) {
        System.out.println("Statement");

    }




    @Override
    public void defaultVisit(Object o) {

    }
}
