package com.eel.AST;

import com.eel.AST.nodes.*;

public class PrintASTVisitor extends AstVisitor<AbstractNode> {


    @Override
    public AbstractNode Visit(ProgNode node) {
        System.out.print("[");
        System.out.print("Prog");
        printPosition(node);
        Visit(node.getProcs());
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(ProcsNode node) {
        System.out.print("[");
        System.out.print("Procs");
        printPosition(node);
        for (int i = 0; i < node.getProcList().size(); ++i) {
            Visit(node.getProcList().get(i));
        }
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(ProcNode node) {
        System.out.print("[");
        System.out.print("Proc");
        printPosition(node);
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(FormalParamsNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(LinesNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(DclNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(AssignNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(StmtNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(ExprNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(OpNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(BinOpNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(BoolOpNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(CtrlStrcNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(IterCtrlStrcNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(SelCtrlStrcNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(ifStrcNode node) {
        System.out.print("[");
        System.out.print("IfStrc");
        printPosition(node);
        Visit(node.ifCondNode);
        Visit(node.lines);
        node.elseIfStrcNodes.forEach(e -> Visit(e));
        Visit(node.elseStrcNode);
        System.out.print("]");

        return null;
    }

    @Override
    public AbstractNode Visit(ifCondNode node) {
        System.out.print("[");
        System.out.print("IfCond");
        printPosition(node);
        System.out.print("]");

        return null;
    }

    @Override
    public AbstractNode Visit(elseIfStrcNode node) {
        System.out.print("[");
        System.out.print("ElseIfStrc");
        printPosition(node);
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(elseStrcNode node) {
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
