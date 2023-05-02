package com.eel.antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

public class elseIfStrcNode extends AbstractNode {

    public String elseToken;
    public ifCondNode ifCondNode;
    public LinesNode linesNode;
    public String getElseToken() {
        return elseToken;
    }
    public void setElseToken(String elseToken) {
        this.elseToken = elseToken;
    }
    public ifCondNode getIfCondNode() { return ifCondNode; }
    public void setIfCondNode(com.eel.antlr.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }
    public LinesNode getLinesNode() {
        return linesNode;
    }
    public void setLinesNode(LinesNode linesNode) {
        this.linesNode = linesNode;
    }

    public elseIfStrcNode() {}
}
