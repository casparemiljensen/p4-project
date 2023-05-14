package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class MethodNode extends AbstractNode {
    public TerminalNode METHODS;
    @Nullable
    public ActualParamsNode actualParamsNode;
    @Nullable
    public MethodNode methodNode;

    public MethodNode(int lineNumber, int colNumber, TerminalNode METHODS, @Nullable ActualParamsNode actualParamsNode, @Nullable MethodNode methodNode) {
        super(lineNumber, colNumber);
        this.METHODS = METHODS;
        this.actualParamsNode = actualParamsNode;
        this.methodNode = methodNode;
    }
}
