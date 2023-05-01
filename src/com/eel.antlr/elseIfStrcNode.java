package com.eel.antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

public class elseIfStrcNode extends ifStrcNode {

    public String elseToken;
    public ifCondNode ifCondNode;
//    public LinesNode linesNode;

    public String getElseToken() {
        return elseToken;
    }

    public void setElseToken(String elseToken) {
        this.elseToken = elseToken;
    }

    @Override
    public com.eel.antlr.ifCondNode getIfCondNode() {
        return ifCondNode;
    }

    @Override
    public void setIfCondNode(com.eel.antlr.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }

    public elseIfStrcNode() {}
}
