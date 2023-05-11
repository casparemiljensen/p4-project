package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class UnaryExprNode extends AbstractNode {
    public TerminalNode operator;
    public ExpressionNode right;


    public UnaryExprNode(int lineNumber, int colNumber, TerminalNode operator, ExpressionNode right){
        super(lineNumber, colNumber);
        this.operator = operator;
        this.right = right;
    }
}