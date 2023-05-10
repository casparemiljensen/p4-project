package com.eel.AST.nodes;

public class ControlStructNode extends AbstractNode {
    public IterativeStructNode iterativeStructNode;
    public SelectiveStructNode selectiveStructNode;
    public ControlStructNode(int lineNumber, int colNumber, IterativeStructNode iterativeStructNode) {
        super(lineNumber, colNumber);
        this.iterativeStructNode = iterativeStructNode;
    }
    public ControlStructNode(int lineNumber, int colNumber, SelectiveStructNode selectiveStructNode) {
        super(lineNumber, colNumber);
        this.selectiveStructNode = selectiveStructNode;
    }

}
