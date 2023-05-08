package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaticValueNode extends AbstractNode{
    public TerminalNode INUMORSTRING;

    public TerminalNode INUM;
    public TerminalNode STRING;
    public FunctionNode FunctionNode;
    public MethodNode methodNode;

    // INUM or STRING
    public StaticValueNode(int lineNumber, int colNumber, @Nullable TerminalNode INUM, @Nullable TerminalNode STRING, MethodNode methodNode) {
        super(lineNumber, colNumber);
        this.INUM = INUM;
        this.STRING = STRING;
        this.methodNode = methodNode;
    }

    // function
    public StaticValueNode(int lineNumber, int colNumber, FunctionNode FunctionNode, @Nullable  MethodNode methodNode) {
        super(lineNumber, colNumber);
        this.FunctionNode = FunctionNode;
        this.methodNode = methodNode;
    }
}
