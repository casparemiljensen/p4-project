package com.eel.AST.nodes;

public class ControlStructNode extends AbstractNode {
    public IterativeStructNode iterativeStructNode;
    public SelectiveStructNode selectiveStructNode;
    public ControlStructNode(int lineNumber, int colNumber, IterativeStructNode IterativeStructNode) {
        super(lineNumber, colNumber);
        this.iterativeStructNode = IterativeStructNode;
    }
    public ControlStructNode(int lineNumber, int colNumber, SelectiveStructNode SelectiveStructNode) {
        super(lineNumber, colNumber);
        this.selectiveStructNode = SelectiveStructNode;
    }

}
