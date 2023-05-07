package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExpressionNode extends AbstractNode {
    public ExpressionNode left;
    public OperatorNode operatorNode;
    public ExpressionNode right;

    public ValueNode valueNode;
    public ExpressionNode expressionNode;
    public String minusToken;

    // expr op expr
    public ExpressionNode(int lineNumber, int colNumber, ExpressionNode left, OperatorNode operatorNode, ExpressionNode right){
        super(lineNumber, colNumber);
        this.left = left;
        this.operatorNode = operatorNode;
        this.right = right;
    }

    // value
    public ExpressionNode(int lineNumber, int colNumber, ValueNode valueNode){
        super(lineNumber, colNumber);
        this.valueNode = valueNode;
    }

    // '-' expression
    public ExpressionNode(int lineNumber, int colNumber, String minusToken, ExpressionNode expressionNode){
        super(lineNumber, colNumber);
        this.expressionNode = expressionNode;
        this.minusToken = minusToken;
    }

}
