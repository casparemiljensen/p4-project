package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class CallNode extends AbstractNode {

    public TerminalNode function;

    public TerminalNode procedure;

    public CallNode(int lineNumber, int colNumber, @Nullable TerminalNode function, @Nullable TerminalNode procedure) {
        super(lineNumber, colNumber);
        this.function = function;
        this.procedure = procedure;
    }
}
