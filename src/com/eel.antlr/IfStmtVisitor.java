package com.eel.antlr;

import java.util.ArrayList;
import java.util.List;

public class IfStmtVisitor extends eelBaseVisitor<selCtrlStrcNode> implements eelVisitor<selCtrlStrcNode>{

    public eelParser myParser;

    public IfStmtVisitor(eelParser parser) {
        myParser = parser;
    }

    @Override
    public selCtrlStrcNode visitSelCtrlStrc(eelParser.SelCtrlStrcContext ctx) {
        System.out.print("[");
        var ruleName = myParser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(ruleName);
        selCtrlStrcNode selCtrlStrcNode = new selCtrlStrcNode();
        selCtrlStrcNode.setIfStrcNode(visitIfStrc(ctx.ifStrc()));
        System.out.print("]");

        return selCtrlStrcNode;
    }

    @Override
    public ifStrcNode visitIfStrc(eelParser.IfStrcContext ctx) {
        System.out.print("[");
        var ruleName = myParser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(ruleName);

        ifStrcNode ifStrcNode = new ifStrcNode();
        ifStrcNode.setIfCondNode(visitIfCond(ctx.ifCond()));
        ifStrcNode.setThenToken("then");
//        ifStrcNode.setLines

        List<elseIfStrcNode> list = new ArrayList<>();
        for(eelParser.ElseIfStrcContext var : ctx.elseIfStrc()) {
            elseIfStrcNode elseIfStrcNode = visitElseIfStrc(var);
            list.add(elseIfStrcNode);
        }
        ifStrcNode.setElseIfStrcNodeList(list);

        elseStrcNode elseStrcNode = new elseStrcNode();
        ifStrcNode.setElseStrcNode(visitElseStrc(ctx.elseStrc()));
        System.out.print("]");
        return ifStrcNode;
    }

    @Override
    public ifCondNode visitIfCond(eelParser.IfCondContext ctx) {
        System.out.print("[");
        var ruleName = myParser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(ruleName);

        ifCondNode ifCondNode = new ifCondNode();
        ifCondNode.setIfToken("if");
        ifCondNode.setLeftParToken("(");
//        ifCondNode.setExprNode();
        ifCondNode.setRightParToken(")");
        System.out.println("]");
        return ifCondNode;
    }

    public elseStrcNode visitElseStrc(eelParser.ElseStrcContext ctx) {
        System.out.print("[");
        var ruleName = myParser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(ruleName);

        elseStrcNode elseStrcNode = new elseStrcNode();
        elseStrcNode.setElseToken("else");
        elseStrcNode.setThenToken("then");
//        elseStrcNode.setLines();
        System.out.println("4");

        return elseStrcNode;
    }

    public elseIfStrcNode visitElseIfStrc(eelParser.ElseIfStrcContext ctx) {
        System.out.print("[");
        var ruleName = myParser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(ruleName);

        elseIfStrcNode elseIfStrcNode = new elseIfStrcNode();
        elseIfStrcNode.setElseToken("else");
        elseIfStrcNode.setThenToken("then");
//        elseIfStrcNode.setLines();
        System.out.println("]");
        return elseIfStrcNode;
    }

}
