package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class OperatorNode extends AbstractNode {
    public BinaryOperatorNode binaryOperatorNode;
    public BooleanOperatorNode booleanOperatorNode;
    public TerminalNode assignment;

    public String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String _symbol) {
        this.symbol = _symbol;
    }

    public OperatorNode(int lineNumber, int colNumber, @Nullable AbstractNode node) {
        super(lineNumber, colNumber);
        if (node instanceof BinaryOperatorNode) this.binaryOperatorNode = (BinaryOperatorNode) node;
        else if (node instanceof BooleanOperatorNode) this.booleanOperatorNode = (BooleanOperatorNode) node;
    }

    public OperatorNode(int lineNumber, int colNumber, TerminalNode assignment) {
        super(lineNumber, colNumber);
        this.assignment = assignment;
    }
}
