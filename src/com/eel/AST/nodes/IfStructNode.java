package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IfStructNode extends AbstractNode {

    public IfConditionNode ifConditionNode;
    public String thenToken;
    public List<StatementNode> statementNodes;
    @Nullable
    public List<ElseIfStructNode> elseIfStructNodes;
    @Nullable
    public ElseStructNode elseStructNode;
    public String endIfToken;

    public IfStructNode(int lineNumber, int colNumber, IfConditionNode ifConditionNode, String thenToken, List<StatementNode> statementNodes, @Nullable List<ElseIfStructNode> elseIfStructNodes, @Nullable ElseStructNode elseStructNode) {
        super(lineNumber, colNumber);
        this.ifConditionNode = ifConditionNode;
        this.thenToken = thenToken;
        this.statementNodes = statementNodes;
        this.elseIfStructNodes = elseIfStructNodes;
        this.elseStructNode = elseStructNode;
    }
}
