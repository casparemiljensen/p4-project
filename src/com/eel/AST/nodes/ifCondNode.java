package com.eel.AST.nodes;

public class ifCondNode extends AbstractNode {
    public String ifToken;
    public ExprNode exprNode;

    public ifCondNode(int lineNumber, int colNumber, String ifToken, ExprNode exprNode) {
        super(lineNumber, colNumber);
        this.ifToken = ifToken;
        this.exprNode = exprNode;
    }

}
