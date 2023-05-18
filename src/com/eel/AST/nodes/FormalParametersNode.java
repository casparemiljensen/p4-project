package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class FormalParametersNode extends AbstractNode {
    public List<TerminalNode> variables;
    public FormalParametersNode(int lineNumber, int colNumber, List<TerminalNode> variables) {
        super(lineNumber, colNumber);
        this.variables = variables;
    }
}
