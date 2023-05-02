package com.eel.antlr;

import jdk.jshell.spi.ExecutionControl;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BuildIfStmtVisitor extends eelBaseVisitor<AbstractNode> implements eelVisitor<AbstractNode>{

//    All return types should be converted to AbstractNode


    @Override
    public AbstractNode visitProg(eelParser.ProgContext ctx) {
        ProcsNode procsNode = (ProcsNode) visit(ctx.procs());
        return new ProgNode("prog", procsNode);
    }

    @Override
    public AbstractNode visitProcs(eelParser.ProcsContext ctx) {
        List<ParseTree> input = ctx.children;
        List<ProcNode> procedures = CreateList(input, ProcNode.class);

        return new ProcsNode("procs", procedures);
    }

    @Override
    public AbstractNode visitProc(eelParser.ProcContext ctx) {
        return new ProcNode("proc");
    }

    @Override
    public ifStrcNode visitIfStrc(eelParser.IfStrcContext ctx) {

        ifStrcNode ifStrcNode = new ifStrcNode();
        ifStrcNode.setName("IfStrc");
        ifStrcNode.setIfCondNode(visitIfCond(ctx.ifCond()));
        ifStrcNode.setThenToken("then");
        ifStrcNode.setLines(visitLines(ctx.lines()));

//        List<elseIfStrcNode> nodesList = new ArrayList<>();
//        for(eelParser.ElseIfStrcContext innerCtx : ctx.elseIfStrc()) {
//            nodesList.add(visitElseIfStrc(innerCtx));
//        }
//        ifStrcNode.setElseIfStrcNodeList(nodesList);

        List<ParseTree> input = ctx.children;
        List<elseIfStrcNode> elseIfNodes = CreateList(input, elseIfStrcNode.class);

        ifStrcNode.setElseIfStrcNodeList(elseIfNodes);
        ifStrcNode.setElseStrcNode(visitElseStrc(ctx.elseStrc()));

        return ifStrcNode;
    }

    @Override
    public ifCondNode visitIfCond(eelParser.IfCondContext ctx) {
        ifCondNode ifCondNode = new ifCondNode();
        ifCondNode.setName("IfCond");
        ifCondNode.setIfToken("if");
        ifCondNode.setLeftParToken("(");
        ifCondNode.setExprNode(visitExpr(ctx.expr()));
        ifCondNode.setRightParToken(")");
        return ifCondNode;
    }

    @Override
    public elseIfStrcNode visitElseIfStrc(eelParser.ElseIfStrcContext ctx) {
        elseIfStrcNode elseIfStrcNode = new elseIfStrcNode();
        elseIfStrcNode.setName("ElseIfStrc");
        elseIfStrcNode.setElseToken("else");
        elseIfStrcNode.setIfCondNode(visitIfCond(ctx.ifCond()));
        elseIfStrcNode.setLinesNode(visitLines(ctx.lines()));
        return elseIfStrcNode;
    }
    @Override
    public elseStrcNode visitElseStrc(eelParser.ElseStrcContext ctx) {
        elseStrcNode elseStrcNode = new elseStrcNode();
        elseStrcNode.setName("ElseStrc");
        elseStrcNode.setElseToken("else");
        elseStrcNode.setThenToken("then");

//        elseStrcNode.setLines(visitLines(ctx.lines()));

        return elseStrcNode;
    }

    @Override
    public LinesNode visitLines(eelParser.LinesContext ctx) {
        LinesNode linesNode = new LinesNode();
        linesNode.setName("Lines");
        return linesNode;
    }

    @Override
    public ExprNode visitExpr(eelParser.ExprContext ctx) {
        ExprNode exprNode = new ExprNode();
        exprNode.setName("Expr");
        return exprNode;
    }

    @Override
    public IterCtrlStrcNode visitIterCtrlStrc(eelParser.IterCtrlStrcContext ctx) {
        throw null;
    }

    private static <T> Collection<T> nullSafe(Collection<T> c) {
        return (c == null) ? Collections.<T>emptyList() : c;
    }
    private <T1, T2> List<T2> CreateList(Collection<T1> list,Class<T2> type){
        List<T2> result = new ArrayList<T2>();
        for (T1 child : nullSafe(list)) {
            result.add(type.cast(visit((ParseTree) child)));
        }
        return result;
    }
}
