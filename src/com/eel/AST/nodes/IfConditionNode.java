package com.eel.AST.nodes;

public class IfConditionNode extends AbstractNode {
    public String ifToken;
    public ExpressionNode expressionNode;

    public IfConditionNode(int lineNumber, int colNumber, String ifToken, ExpressionNode expressionNode) {
        super(lineNumber, colNumber);
        this.ifToken = ifToken;
        this.expressionNode = expressionNode;
    }

}
