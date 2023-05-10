package com.eel.AST.nodes;

public class UnaryExpressionNode extends ExpressionNode {
    public UnaryExpressionNode(int lineNumber, int colNumber, OperatorNode operatorNode, ExpressionNode right){
        super(lineNumber, colNumber);
        this.operatorNode = operatorNode;
        this.right = right;
    }
}