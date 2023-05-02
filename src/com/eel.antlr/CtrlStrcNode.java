package com.eel.antlr;

public class CtrlStrcNode extends AbstractNode {
    public IterCtrlStrcNode iterStrcNode;

    public IterCtrlStrcNode getIterStrcNode() {
        return iterStrcNode;
    }

    public void setIterStrcNode(IterCtrlStrcNode iterCtrlStrcNode) {
        this.iterStrcNode = iterCtrlStrcNode;
    }

    public SelCtrlStrcNode getSelCtrlStrcNode() {
        return selCtrlStrcNode;
    }

    public void setSelCtrlStrcNode(SelCtrlStrcNode selCtrlStrcNode) {
        this.selCtrlStrcNode = selCtrlStrcNode;
    }

    public SelCtrlStrcNode selCtrlStrcNode;
    public CtrlStrcNode() {}
}
