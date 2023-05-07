package com.eel.AST.nodes;

import java.beans.Expression;

public class AssignmentNode extends AbstractNode {
    String assignmentToken;
    ExpressionNode ExpressionNode;

    public AssignmentNode(int lineNumber, int colNumber, String assignmentToken, ExpressionNode _ExpressionNode) {
        super(lineNumber, colNumber);
        this.assignmentToken = assignmentToken;
        this.ExpressionNode = _ExpressionNode;
    }
}
