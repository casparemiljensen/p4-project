package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReturnNode extends AbstractNode {
    public String returnToken;
    @Nullable
    public ExpressionNode expressionNode;

    public ReturnNode(int lineNumber, int colNumber, String returnToken, @Nullable ExpressionNode expressionNode) {
        super(lineNumber, colNumber);
        this.returnToken = returnToken;
        this.expressionNode = expressionNode;
    }
}
