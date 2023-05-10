package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

public class UserValueNode extends AbstractNode {
    public TerminalNode ID;
    public UserValueNode(int lineNumber, int colNumber, TerminalNode ID) {
        super(lineNumber, colNumber);
        this.ID = ID;
    }
}
