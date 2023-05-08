package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class FormalParametersNode extends AbstractNode {
    public List<TerminalNode> IDs;
    public FormalParametersNode(int lineNumber, int colNumber, List<TerminalNode> IDs) {
        super(lineNumber, colNumber);
        this.IDs = IDs;
    }
}
