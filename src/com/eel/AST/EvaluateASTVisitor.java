package com.eel.AST;

import com.eel.AST.nodes.*;

public class EvaluateASTVisitor extends AstVisitor<AbstractNode> {

    @Override
    public SelectiveStructNode Visit(ProgramNode node) {
        System.out.print("Got here");
        return null;
    }

    @Override
    public SelectiveStructNode Visit(ProcedureNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(FormalParametersNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(DeclarationNode node) {
        return null;
}


    @Override
    public SelectiveStructNode Visit(StatementNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(ExpressionNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(OperatorNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(BinaryOperatorNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(BooleanOperatorNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(ControlStructNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(IterativeStructNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(SelectiveStructNode node) {
        System.out.print("Got here");
        return null;
    }

    @Override
    public SelectiveStructNode Visit(IfStructNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(IfConditionNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(ElseIfStructNode node) {
        return null;
    }

    @Override
    public SelectiveStructNode Visit(ElseStructNode node) {
        return null;
    }
}
