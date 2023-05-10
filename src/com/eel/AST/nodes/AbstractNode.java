package com.eel.AST.nodes;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.ReflectiveVisitable;

public abstract class AbstractNode implements ReflectiveVisitable {
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

    public final void accept(ReflectiveASTVisitor v) { v.Visit(this); }

}
