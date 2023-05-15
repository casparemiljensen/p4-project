package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class ProcedureCallNode extends AbstractNode {
    public TerminalNode PROCEDURE;
    @Nullable
    public ActualParamsNode actualParamsNode;

    public ProcedureCallNode(int lineNumber, int colNumber, TerminalNode PROCEDURE, @Nullable ActualParamsNode actualParamsNode) {
        super(lineNumber, colNumber);
        this.PROCEDURE = PROCEDURE;
        this.actualParamsNode = actualParamsNode;
    }
}
