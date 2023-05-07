package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RepeatStructNode extends AbstractNode {
    public ExpressionNode expressionNode;
    @Nullable
    public List<StatementNode> statementNodes;

    public RepeatStructNode(int lineNumber, int colNumber, ExpressionNode expressionNode, @Nullable List<StatementNode> statementNodes) {
        super(lineNumber, colNumber);
        this.expressionNode = expressionNode;
        this.statementNodes = statementNodes;
    }
}
