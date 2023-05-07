package com.eel.AST.nodes;

public class IterativeStructNode extends AbstractNode {
    public RepeatStructNode repeatStructNode;
    public IterativeStructNode(int lineNumber, int colNumber, RepeatStructNode repeatStructNode) {
        super(lineNumber, colNumber);
        this.repeatStructNode = repeatStructNode;
    }
}
