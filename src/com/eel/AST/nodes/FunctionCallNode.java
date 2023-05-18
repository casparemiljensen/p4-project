package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class FunctionCallNode extends AbstractNode {
    public TerminalNode FUNCTIONS;
    @Nullable
    public ActualParamsNode actualParamsNode;

    public FunctionCallNode(int lineNumber, int colNumber, TerminalNode FUNCTIONS, @Nullable ActualParamsNode actualParamsNode) {
        super(lineNumber, colNumber);
        this.FUNCTIONS = FUNCTIONS;
        this.actualParamsNode = actualParamsNode;
    }
}
