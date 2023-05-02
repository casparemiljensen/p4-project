package com.eel.antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

public class PrintAst extends AstVisitor<SelCtrlStrcNode> {
    // Should be Abstract Node
    @Override
    public SelCtrlStrcNode Visit(ProgNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ProcsNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ProcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(FormalParamsNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(LinesNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(DclNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(AssignNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(StmtNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ExprNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(OpNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(BinOpNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(BoolOpNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(CtrlStrcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(IterCtrlStrcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ifStrcNode node) {
        System.out.print("[");
        System.out.print(node.getName());
        Visit(node.ifCondNode);
        Visit(node.elseStrcNode);
        System.out.print("]");
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ifCondNode node) {
        System.out.print("[");
        System.out.print(node.getName());
        System.out.print("]");
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(elseIfStrcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(elseStrcNode node) {
        System.out.print("[");
        System.out.print(node.getName());
        System.out.print("]");
        return null;
    }

}
