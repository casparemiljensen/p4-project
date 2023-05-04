package com.eel.AST.nodes;

public class ProgNode extends AbstractNode {
    public ProcsNode procs;
    public ProcsNode getProcs() {
        return procs;
    }

    public void setProcs(ProcsNode procs) {
        this.procs = procs;
    }

    public ProgNode(ProcsNode procs) {
        this.procs = procs;
    }

    public ProgNode(int lineNumber, int colNumber, ProcsNode procs) {
        super(lineNumber, colNumber);
        this.procs = procs;
    }
}
