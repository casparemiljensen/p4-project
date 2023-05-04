package com.eel.AST.nodes;

import java.util.List;

public class ElseStructNode extends AbstractNode{
    public List<StatementNode> statementNode;

    public ElseStructNode(int lineNumber, int colNumber, List<StatementNode> statementNode) {
        super(lineNumber, colNumber);
        this.statementNode = statementNode;
    }
}
