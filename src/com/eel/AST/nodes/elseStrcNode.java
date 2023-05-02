package com.eel.AST.nodes;

public class elseStrcNode extends AbstractNode{

    public String elseToken;
    public String thenToken;
    public LinesNode Lines;

    public String getElseToken() {
        return elseToken;
    }

    public void setElseToken(String elseToken) {
        this.elseToken = elseToken;
    }


    public String getThenToken() {
        return thenToken;
    }

    public void setThenToken(String thenToken) {
        this.thenToken = thenToken;
    }

    public LinesNode getLines() {
        return Lines;
    }

    public void setLines(LinesNode lines) {
        Lines = lines;
    }


    public elseStrcNode() {}
}
