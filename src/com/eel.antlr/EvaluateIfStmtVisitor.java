package com.eel.antlr;

public class EvaluateIfStmtVisitor extends AstVisitor<AbstractNode> {

    @Override
    public SelCtrlStrcNode Visit(ProgNode node) {
        System.out.print("Got here");
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
    public AbstractNode Visit(SelCtrlStrcNode node) {
        System.out.print("Got here");
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ifStrcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(ifCondNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(elseIfStrcNode node) {
        return null;
    }

    @Override
    public SelCtrlStrcNode Visit(elseStrcNode node) {
        return null;
    }
}
