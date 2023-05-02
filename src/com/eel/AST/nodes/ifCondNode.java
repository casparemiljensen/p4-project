package com.eel.AST.nodes;

public class ifCondNode extends AbstractNode {
    public String ifToken;
    public String leftParToken;

    public ExprNode exprNode;

    public String rightParToken;


    public String getIfToken() {
        return ifToken;
    }

    public void setIfToken(String ifToken) {
        this.ifToken = ifToken;
    }


    public String getLeftParToken() {
        return leftParToken;
    }

    public void setLeftParToken(String leftParToken) {
        this.leftParToken = leftParToken;
    }


    public ExprNode getExprNode() {
        return exprNode;
    }

    public void setExprNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }

    public String getRightParToken() {
        return rightParToken;
    }

    public void setRightParToken(String rightParToken) {
        this.rightParToken = rightParToken;
    }

    public ifCondNode(){};

}
