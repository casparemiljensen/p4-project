package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaticValueNode extends AbstractNode{

    public TerminalNode INUM;
    public TerminalNode STRING;
    public TerminalNode FUNCTION;
    public MethodNode methodNode;

    public StaticValueNode(int lineNumber, int colNumber, @Nullable TerminalNode INUM, @Nullable TerminalNode STRING, @Nullable TerminalNode FUNCTION, MethodNode methodNode) {
        super(lineNumber, colNumber);
        this.INUM = INUM;
        this.STRING = STRING;
        this.FUNCTION = FUNCTION;
        this.methodNode = methodNode;
    }
}
