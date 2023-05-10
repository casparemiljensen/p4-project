package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class UnaryExprNode extends AbstractNode {
    public ExpressionNode right;
    public TerminalNode operator;

    public UnaryExprNode(int lineNumber, int colNumber, TerminalNode operator, ExpressionNode right){
        super(lineNumber, colNumber);
        this.operator = operator;
        this.right = right;
    }
}