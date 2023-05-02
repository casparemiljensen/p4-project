package com.eel.antlr;

import java.util.List;

public class ProgNode extends AbstractNode {
    public ProcsNode procs;
    public ProcsNode getProcs() {
        return procs;
    }

    public void setProcs(ProcsNode procs) {
        this.procs = procs;
    }

    public ProgNode(String name, ProcsNode procs) {
        setName(name);
        this.procs = procs;
    }
}
