package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class BooleanOperatorNode extends AbstractNode {
    public TerminalNode booleanOperator;

    public BooleanOperatorNode(int lineNumber, int colNumber, TerminalNode booleanOperator) {
        super(lineNumber, colNumber);
        this.booleanOperator = booleanOperator;
    }
}
