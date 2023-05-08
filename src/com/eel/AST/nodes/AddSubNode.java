package com.eel.AST.nodes;

public class AddSubNode extends ExpressionNode {
    public ExpressionNode leftChild;
    public ExpressionNode rightChild;
    public AddSubNode(int lineNumber, int colNumber, ExpressionNode leftChild, ExpressionNode rightChild) {
        super(lineNumber, colNumber);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
