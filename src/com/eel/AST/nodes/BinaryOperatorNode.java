package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class BinaryOperatorNode extends AbstractNode {
    public TerminalNode binaryOperator;

    public BinaryOperatorNode(int lineNumber, int colNumber, TerminalNode binaryOperator) {
        super(lineNumber, colNumber);
        this.binaryOperator = binaryOperator;
    }
}
