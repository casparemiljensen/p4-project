package com.eel.AST.nodes;

public class ControlStructNode extends AbstractNode {
    public IterativeStructNode iterStrcNode;
    public SelectiveStructNode selCtrlStrcNode;
    public ControlStructNode(int lineNumber, int colNumber) {
        super(lineNumber, colNumber);
    }
}
