package com.eel;

import com.eel.antlr.eelBaseListener;
import com.eel.antlr.eelParser;

public class eelListener extends eelBaseListener {
//    @Override public void enterEveryRule(ParserRuleContext ctx) {
//        System.out.println("Rule entered: " + ctx.getText());
//    }


    @Override
    public void enterProg(eelParser.ProgContext ctx) {
        System.out.println("Prog entered: " + ctx.getText());
    }

    @Override
    public void exitProg(eelParser.ProgContext ctx) {
        System.out.println("Exited prog");
    }
}
