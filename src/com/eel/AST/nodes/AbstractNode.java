package com.eel.AST.nodes;

import com.eel.AST.ReflectiveVisitor;

public abstract class AbstractNode {
    protected int lineNumber, colNumber;
    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return colNumber;
    }

    public AbstractNode() {}
    public AbstractNode(int lineNumber, int colNumber) {
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }

    public final void accept(ReflectiveVisitor v) { v.dispatch(this); }

}
