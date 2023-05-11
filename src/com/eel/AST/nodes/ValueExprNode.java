package com.eel.AST.nodes;

public class ValueExprNode extends AbstractNode {
    public ValueNode valueNode;
    public ValueExprNode(int lineNumber, int colNumber, ValueNode valueNode) {
        super(lineNumber, colNumber);
        this.valueNode = valueNode;
    }
}
