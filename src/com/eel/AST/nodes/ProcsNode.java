package com.eel.AST.nodes;

import java.util.List;

public class ProcsNode extends AbstractNode {
    public List<ProcNode> procList;

    public List<ProcNode> getProcList() {
        return procList;
    }
    public void setProcList(List<ProcNode> procList) {
        this.procList = procList;
    }
    public ProcsNode(List<ProcNode> procedures) {
        this.procList = procedures;
    }
    public ProcsNode(int lineNumber, int colNumber, List<ProcNode> procedures) {
        super(lineNumber, colNumber);
        this.procList = procedures;
    }
}
