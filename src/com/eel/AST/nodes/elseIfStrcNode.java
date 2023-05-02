package com.eel.AST.nodes;

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
    public void setIfCondNode(com.eel.AST.nodes.ifCondNode ifCondNode) {
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
