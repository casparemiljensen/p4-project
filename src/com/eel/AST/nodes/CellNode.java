package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class CellNode extends AbstractNode {
    @Nullable
    public TerminalNode SINGLE_CELL;
    @Nullable
    public TerminalNode RANGE;
    @Nullable
    public TerminalNode CELL_METHOD;

    public CellNode(int lineNumber, int colNumber, @Nullable TerminalNode SINGLE_CELL, @Nullable TerminalNode RANGE, @Nullable TerminalNode CELL_METHOD) {
        super(lineNumber,colNumber);
        this.SINGLE_CELL = SINGLE_CELL;
        this.RANGE = RANGE;
        this.CELL_METHOD = CELL_METHOD;
    }
}
