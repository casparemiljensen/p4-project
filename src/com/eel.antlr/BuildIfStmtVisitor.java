package com.eel.antlr;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class BuildIfStmtVisitor extends eelBaseVisitor<AbstractNode> implements eelVisitor<AbstractNode>{


//    @Override
//    public CtrlStrcNode visitCtrlStrc(eelParser.CtrlStrcContext ctx) {
//        System.out.println("1");
//        CtrlStrcNode node = new CtrlStrcNode();
//
//        if(!ctx.iterCtrlStrc().isEmpty()) {
//            node.setIterStrcNode(visitIterCtrlStrc(ctx.iterCtrlStrc()));
//            return
//        }
//        else if(!ctx.selCtrlStrc().isEmpty()) {
//            node.selCtrlStrcNode = visitSelCtrlStrc(ctx.selCtrlStrc());
//        }
//        return node;
//    }
//    @Override
//    public SelCtrlStrcNode visitSelCtrlStrc(eelParser.SelCtrlStrcContext ctx) {
//
//        SelCtrlStrcNode selCtrlStrcNode = new SelCtrlStrcNode();
//        selCtrlStrcNode.setName("SelCtrl");
//        selCtrlStrcNode.setIfStrcNode(visitIfStrc(ctx.ifStrc()));
//        return selCtrlStrcNode;
//    }

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
//      ifStrcNode.setElseIfStrcNodeList(nodesList);

//       System.out.println(nodesList);
        ifStrcNode.setElseIfStrcNode(visitElseIfStrc(ctx.elseIfStrc(0)));
        ifStrcNode.setElseStrcNode(visitElseStrc(ctx.elseStrc()));

        return ifStrcNode;
    }

    @Override
    public ifCondNode visitIfCond(eelParser.IfCondContext ctx) {
        ifCondNode ifCondNode = new ifCondNode();
        ifCondNode.setName("IfCond");
        ifCondNode.setIfToken("if");
        ifCondNode.setLeftParToken("(");
//        ifCondNode.setExprNode(visitExpr(ctx.expr()));
        ifCondNode.setRightParToken(")");
        return ifCondNode;
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

        return linesNode;
    }

    @Override
    public elseIfStrcNode visitElseIfStrc(eelParser.ElseIfStrcContext ctx) {
        elseIfStrcNode elseIfStrcNode = new elseIfStrcNode();
        elseIfStrcNode.setName("ElseIfStrc");
        elseIfStrcNode.setElseToken("else");
        elseIfStrcNode.setIfCondNode(visitIfCond(ctx.ifCond()));
//        elseIfStrcNode.setLinesNode(visitLines(ctx.lines()));
        return elseIfStrcNode;
    }

    @Override
    public ExprNode visitExpr(eelParser.ExprContext ctx) {
        ExprNode exprNode = new ExprNode();

        return exprNode;
    }

    @Override
    public IterCtrlStrcNode visitIterCtrlStrc(eelParser.IterCtrlStrcContext ctx) {
        throw null;
    }
}
