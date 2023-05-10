package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class MultDivNode extends ExpressionNode {
    public ExpressionNode leftChild;
    public TerminalNode operatorNode;
    public ExpressionNode rightChild;
    public MultDivNode(int lineNumber, int colNumber, ExpressionNode leftChild, TerminalNode operatorNode, ExpressionNode rightChild) {
        super(lineNumber, colNumber);
        this.leftChild = leftChild;
        this.operatorNode = operatorNode;
        this.rightChild = rightChild;
    }
}