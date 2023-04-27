package com.eel.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import static java.lang.Integer.parseInt;

public class EelBuildASTVisitor extends eelBaseVisitor<AST> {
    private eelParser parser;

    public EelBuildASTVisitor(eelParser parser) {
        this.parser = parser;
    }

    @Override
    public AST visitProg(eelParser.ProgContext ctx) {
//        printVertices(ctx.children);
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);
        ast.addChild(visit(ctx.procs()));
        System.out.print("]");
        return ast;
    }

//    private void printVertices(List<ParseTree> parseTreeList) {
//        for(ParseTree pt : parseTreeList)
//        switch (pt.getChildCount()) {
//            case 1:
//                System.out.println("|");
//            case 2:
//                System.out.println("/" + "\\");
//            case 3:
//                System.out.println("/" + "|" + "\\");
//            default:
//                System.out.println("Can't do this!");
//        }
//    }

    @Override
    public AST visitProcs(eelParser.ProcsContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        List<eelParser.ProcContext> procsList = ctx.proc();
        for (eelParser.ProcContext proc : procsList) {
            ast.addChild(visit(proc));
        }
        System.out.print("]");
        return ast;
    }

    @Override
    public AST visitProc(eelParser.ProcContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        ast.addChild(visit(ctx.ID()));

        if (ctx.formalParams() != null) {
            ast.addChild(visit(ctx.formalParams()));
        }
        ast.addChild(visit(ctx.lines()));
        System.out.print("]");
        return ast;
    }

    @Override
    public AST visitFormalParams(eelParser.FormalParamsContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        //Something fishy about the ctx.ID(int i) - method, I do not know why it expects an integer param...

        for (TerminalNode paramNode : ctx.ID()) {
            String paramName = paramNode.getText();
            int tokenId = parseInt(paramName);
            ast.addChild(visit(ctx.ID(tokenId)));
        }
        System.out.print("]");
        return ast;
    }

    @Override
    public AST visitLines(eelParser.LinesContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        for(int i = 0; i<ctx.children.size(); i++) {
            visit(ctx.children.get(i));
        }

//        System.out.println("Child: " + var);
//
//        switch (ctx.getText()) {
//
//            case "dcl":
//                System.out.println("dcl");
//                break;
//            case "stmt":
//                System.out.println("stmt");
//                break;
//            case "ctrlStrc":
//                System.out.println("ctrlStrc");
//                break;
//
//            default:
//                // code block
//                System.out.println("No match");
//
//        }
        System.out.print("]");
        return ast;
    }

    @Override
    public AST visitDcl(eelParser.DclContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        System.out.print("]");

        return null;
    }


    @Override
    public AST visitStmt(eelParser.StmtContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        System.out.print("]");

        return null;
    }

    @Override
    public AST visitCtrlStrc(eelParser.CtrlStrcContext ctx) {
        AST ast = new AST();
        String ruleName = parser.ruleNames[ctx.getRuleIndex()];
        System.out.print("[" + ruleName);

        System.out.print("]");

        return null;
    }

}
