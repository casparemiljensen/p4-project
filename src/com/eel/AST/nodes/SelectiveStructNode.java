package com.eel.AST.nodes;

public class SelectiveStructNode extends AbstractNode {

    public IfStructNode ifStructNode;

    public SelectiveStructNode(int lineNumber, int colNumber, IfStructNode ifStructNode) {
        super(lineNumber, colNumber);
        this.ifStructNode = ifStructNode;
    }

}
