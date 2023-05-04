package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IfStructNode extends AbstractNode {

    public IfConditionNode IfConditionNode;
    public String thenToken;
    public List<StatementNode> statementNodes;
    @Nullable
    public List<ElseIfStructNode> ElseIfStructNodes;
    @Nullable
    public ElseStructNode ElseStructNode;
    public String endIfToken;
//    public ifStrcNode() {}

    public IfStructNode(int lineNumber, int colNumber, IfConditionNode IfConditionNode, String thenToken, List<StatementNode> statementNodes, @Nullable List<ElseIfStructNode> ElseIfStructNodes, @Nullable ElseStructNode ElseStructNode) {
        super(lineNumber, colNumber);
        this.IfConditionNode = IfConditionNode;
        this.thenToken = thenToken;
        this.statementNodes = statementNodes;
        this.ElseIfStructNodes = ElseIfStructNodes;
        this.ElseStructNode = ElseStructNode;
    }
}
