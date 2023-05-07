package com.eel.AST.nodes;

import java.util.List;

public class ElseIfStructNode extends AbstractNode {
    public IfConditionNode ifConditionNode;
    public List<StatementNode> statementNodes;

    public ElseIfStructNode(int lineNumber, int colNumber, IfConditionNode ifConditionNode, List<StatementNode> statementNodes) {
        super(lineNumber, colNumber);
        this.ifConditionNode = ifConditionNode;
        this.statementNodes = statementNodes;

    }
}
