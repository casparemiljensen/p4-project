package com.eel.AST.nodes;

public class elseStrcNode extends AbstractNode{
    public LinesNode linesNode;

    public elseStrcNode(int lineNumber, int colNumber, LinesNode linesNode) {
        super(lineNumber, colNumber);
        this.linesNode = linesNode;
    }
}
