package com.eel.AST;

import com.eel.AST.nodes.*;

public class PrintASTVisitor extends AstVisitor<AbstractNode> {


    @Override
    public AbstractNode Visit(ProgramNode node) {
        System.out.print("[");
        System.out.print("Program");
        printPosition(node);
        node.procedureNodes.forEach(e -> Visit(e));
        System.out.print("]");
        return null;
    }

//    @Override
//    public AbstractNode Visit(ProcsNode node) {
//        System.out.print("[");
//        System.out.print("Procs");
//        printPosition(node);
//        for (int i = 0; i < node.getProcList().size(); ++i) {
//            Visit(node.getProcList().get(i));
//        }
//        System.out.print("]");
//        return null;
//    }

    @Override
    public AbstractNode Visit(ProcedureNode node) {
        System.out.print("[");
        System.out.print("Procedure");
        printPosition(node);
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(FormalParametersNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(DeclarationNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(StatementNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(ExpressionNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(OperatorNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(BinaryOperatorNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(BooleanOperatorNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(ControlStructNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(IterativeStructNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(SelectiveStructNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(IfStructNode node) {
        System.out.print("[");
        System.out.print("IfStrc");
        printPosition(node);
        Visit(node.IfConditionNode);
        node.statementNodes.forEach(e -> Visit(e));
        node.ElseIfStructNodes.forEach(e -> Visit(e));
        Visit(node.ElseStructNode);
        System.out.print("]");

        return null;
    }

    @Override
    public AbstractNode Visit(IfConditionNode node) {
        System.out.print("[");
        System.out.print("IfCond");
        printPosition(node);
        System.out.print("]");

        return null;
    }

    @Override
    public AbstractNode Visit(ElseIfStructNode node) {
        System.out.print("[");
        System.out.print("ElseIfStrc");
        printPosition(node);
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(ElseStructNode node) {
        System.out.print("[");
        System.out.print("ElseStrc");
        printPosition(node);
        System.out.print("]");
        return null;
    }

    private void printPosition(AbstractNode node) {
        System.out.print("(line:" + node.getLineNumber() + ",col:" + node.getColumnNumber() + ")");
    }
}
