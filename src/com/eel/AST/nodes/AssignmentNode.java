package com.eel.AST.nodes;

import java.beans.Expression;

public class AssignmentNode extends AbstractNode {
    public String assignmentToken;
    public ExpressionNode expressionNode;

    public AssignmentNode(int lineNumber, int colNumber, String assignmentToken, ExpressionNode expressionNode) {
        super(lineNumber, colNumber);
        this.assignmentToken = assignmentToken;
        this.expressionNode = expressionNode;
    }
}
