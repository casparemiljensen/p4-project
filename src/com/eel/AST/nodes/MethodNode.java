package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class MethodNode extends AbstractNode {
    public TerminalNode method;
    public ActualParamsNode actualParamsNode;
    public MethodNode methodNode;

    public MethodNode(int lineNumber, int colNumber, TerminalNode method, ActualParamsNode actualParamsNode, @Nullable MethodNode methodNode) {
        super(lineNumber, colNumber);
        this.method = method;
        this.actualParamsNode = actualParamsNode;
        this.methodNode = methodNode;
    }

}
