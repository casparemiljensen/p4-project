package com.eel.AST.nodes;

public class elseIfStrcNode extends AbstractNode {
    public String elseToken;
    public ifCondNode ifCondNode;
    public LinesNode linesNode;

    public elseIfStrcNode(int lineNumber, int colNumber, ifCondNode ifCondNode, LinesNode linesNode) {
        super(lineNumber, colNumber);
        this.ifCondNode = ifCondNode;
        this.linesNode = linesNode;

    }
}
