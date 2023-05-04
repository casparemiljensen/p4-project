package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class StaticValueNode extends AbstractNode{
    public TerminalNode INUMORSTRING;

    public TerminalNode INUM;
    public TerminalNode STRING;
    public FunctionNode FunctionNode;

    // INUM or STRING
    public StaticValueNode(int lineNumber, int colNumber, @Nullable TerminalNode INUM, @Nullable TerminalNode STRING) {
        super(lineNumber, colNumber);
        this.INUM = INUM;
        this.STRING = STRING;
    }

    // function
    public StaticValueNode(int lineNumber, int colNumber, FunctionNode FunctionNode) {
        super(lineNumber, colNumber);
        this.FunctionNode = FunctionNode;
    }
}
