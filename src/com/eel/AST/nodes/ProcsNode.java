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
    public ProcsNode(String name, List<ProcNode> procedures) {
        setName(name);
        this.procList = procedures;
    }
}
