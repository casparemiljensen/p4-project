package com.eel.AST.nodes;

public class InfixExpressionNode extends ExpressionNode {
    public InfixExpressionNode(int lineNumber, int colNumber, ExpressionNode left, OperatorNode operatorNode, ExpressionNode right){
        super(lineNumber, colNumber);
        this.left = left;
        this.operatorNode = operatorNode;
        this.right = right;
    }
}
