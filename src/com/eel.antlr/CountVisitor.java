package com.eel.antlr;

public class CountVisitor extends eelBaseVisitor<Integer> implements eelVisitor<Integer>{

    @Override
    public Integer visitBinaryOperator(eelParser.BinaryOperatorContext ctx) {
        {
            if(ctx.getText().equals("+"))
                return 1;
            else if(ctx.getText().equals("-"))
                return 1;
            else
                return 0;
        }
    }

    protected Integer aggregateResult(Integer aggregate, Integer nextResult) {
        return Integer.sum(aggregate, nextResult);
    }
    protected Integer defaultResult() {
        return 0;
    }
}
