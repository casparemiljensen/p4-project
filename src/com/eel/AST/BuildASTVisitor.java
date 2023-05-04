package com.eel.AST;

import com.eel.AST.nodes.*;
import com.eel.antlr.eelBaseVisitor;
import com.eel.antlr.eelParser;
import com.eel.antlr.eelVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildASTVisitor extends eelBaseVisitor<AbstractNode> implements eelVisitor<AbstractNode> {

//    All return types should be converted to AbstractNode


    @Override
    public AbstractNode visitProg(eelParser.ProgContext ctx) {
        ProcsNode procsNode = (ProcsNode) visit(ctx.procs());
        return new ProgNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), procsNode);
    }

    @Override
    public AbstractNode visitProcs(eelParser.ProcsContext ctx) {
        List<ParseTree> input = ctx.children;
        List<ProcNode> procedures = CreateList(input, ProcNode.class);
        return new ProcsNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), procedures);
    }

    @Override
    public AbstractNode visitProc(eelParser.ProcContext ctx) {
        return new ProcNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public AbstractNode visitIfStrc(eelParser.IfStrcContext ctx) {
        List<ParseTree> input = ctx.children.stream().filter(e -> e instanceof eelParser.ElseIfStrcContext).collect(Collectors.toList());
        List<elseIfStrcNode> elseIfStrcNodes = CreateList(input, elseIfStrcNode.class);
        return new ifStrcNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCond(ctx.ifCond()), "then", visitLines(ctx.lines()), elseIfStrcNodes, visitElseStrc(ctx.elseStrc()));
    }

    @Override
    public ifCondNode visitIfCond(eelParser.IfCondContext ctx) {
        return new ifCondNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "if", visitExpr(ctx.expr()));
    }

    @Override
    public elseIfStrcNode visitElseIfStrc(eelParser.ElseIfStrcContext ctx) {
        return new elseIfStrcNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCond(ctx.ifCond()), visitLines(ctx.lines()));
    }
    @Override
    public elseStrcNode visitElseStrc(eelParser.ElseStrcContext ctx) {
        return new elseStrcNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitLines(ctx.lines()));
    }

    @Override
    public LinesNode visitLines(eelParser.LinesContext ctx) {
        LinesNode linesNode = new LinesNode();
        linesNode.setName("Lines, not implemented");
        return linesNode;
    }

    @Override
    public ExprNode visitExpr(eelParser.ExprContext ctx) {
        ExprNode exprNode = new ExprNode();
        exprNode.setName("Expr, not implemented");
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
