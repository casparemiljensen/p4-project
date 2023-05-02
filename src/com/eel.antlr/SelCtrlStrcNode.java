package com.eel.antlr;

public class SelCtrlStrcNode extends AbstractNode {

    public ifStrcNode ifStrcNode;

    public com.eel.antlr.ifStrcNode getIfStrcNode() {
        return ifStrcNode;
    }

    public void setIfStrcNode(ifStrcNode ifStrcNode) {
        this.ifStrcNode = ifStrcNode;
    }

    public SelCtrlStrcNode(){};
    public SelCtrlStrcNode(ifStrcNode ifStrcNode) {
        this.ifStrcNode = ifStrcNode;
    }

}
