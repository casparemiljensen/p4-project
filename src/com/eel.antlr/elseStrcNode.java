package com.eel.antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

public class elseStrcNode extends ifStrcNode{

    public String elseToken;
    public String thenToken;
//    public LinesNode Lines;

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

    public elseStrcNode() {}
}
