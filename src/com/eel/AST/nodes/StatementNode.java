package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

public class StatementNode extends AbstractNode {
    @Nullable
    public DeclarationNode declarationNode;
    @Nullable
    public ExpressionNode expressionNode;
    @Nullable
    public ControlStructNode controlStructNode;
    @Nullable
    public ReturnNode returnNode;

    public StatementNode(int lineNumber, int colNumber, @Nullable DeclarationNode declarationNode, @Nullable ExpressionNode expressionNode, @Nullable ControlStructNode controlStructNode, @Nullable ReturnNode returnNode) {
        super(lineNumber, colNumber);
        this.declarationNode = declarationNode;
        this.expressionNode = expressionNode;
        this.controlStructNode = controlStructNode;
        this.returnNode = returnNode;
    }
}
