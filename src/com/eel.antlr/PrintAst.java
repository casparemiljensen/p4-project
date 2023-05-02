package com.eel.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrintAst extends AstVisitor<AbstractNode> {


    @Override
    public AbstractNode Visit(ProgNode node) {
        System.out.print("[");
        System.out.print(node.getName());
        Visit(node.getProcs());
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(ProcsNode node) {
        System.out.print("[");
        System.out.print(node.getName());
        for (int i = 0; i < node.getProcList().size(); ++i) {
            Visit(node.getProcList().get(i));
        }
        System.out.print("]");
        return null;
    }

    @Override
    public AbstractNode Visit(ProcNode node) {
        System.out.print("[");
        System.out.print(node.getName());
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
        return null;
    }

    @Override
    public AbstractNode Visit(ifCondNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(elseIfStrcNode node) {
        return null;
    }

    @Override
    public AbstractNode Visit(elseStrcNode node) {
        return null;
    }
}
