package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class UserValueNode extends AbstractNode {
    public TerminalNode ID;
    public ActualParamsNode actualParamsNode;
    public UserValueNode(int lineNumber, int colNumber, TerminalNode ID, ActualParamsNode actualParamsNode) {
        super(lineNumber, colNumber);
        this.ID = ID;
        this.actualParamsNode = actualParamsNode;
    }
}
