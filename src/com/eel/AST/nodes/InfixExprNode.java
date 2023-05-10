package com.eel.AST.nodes;

public class InfixExprNode extends AbstractNode {
    public ExpressionNode left;
    public OperatorNode operatorNode;
    public ExpressionNode right;
    public InfixExprNode(int lineNumber, int colNumber, ExpressionNode left, OperatorNode operatorNode, ExpressionNode right){
        super(lineNumber, colNumber);
        this.left = left;
        this.operatorNode = operatorNode;
        this.right = right;
    }
}
