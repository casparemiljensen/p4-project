package com.eel.AST.nodes;

public class SelCtrlStrcNode extends AbstractNode {

    public ifStrcNode ifStrcNode;

    public com.eel.AST.nodes.ifStrcNode getIfStrcNode() {
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
