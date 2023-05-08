package com.eel.AST.nodes;

import kotlin.NotImplementedError;
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

    public StatementNode(int lineNumber, int colNumber, AbstractNode node) {
        super(lineNumber, colNumber);
        if(node instanceof DeclarationNode) {
            this.declarationNode = (DeclarationNode) node;
        }
         else if(node instanceof  ExpressionNode) {
            this.expressionNode = (ExpressionNode) node;
        }
         else if(node instanceof  ControlStructNode) {
            this.controlStructNode = (ControlStructNode) node;
        }
         else if(node instanceof ReturnNode) {
            this.returnNode = (ReturnNode) node;
         }
         else {
            throw new NotImplementedError();
         }
    }
}
