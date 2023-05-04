package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class FunctionNode extends AbstractNode {
    public TerminalNode FUNCTION;
    public ActualParamsNode ActualParamsNode;
    public FunctionNode(int lineNumber, int colNumber, TerminalNode FUNCTION, ActualParamsNode ActualParamsNode) {
        super(lineNumber, colNumber);
        this.FUNCTION = FUNCTION;
        this.ActualParamsNode = ActualParamsNode;
    }
}
