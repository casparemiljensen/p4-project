package com.eel.antlr;

public class selCtrlStrcNode {

    public ifStrcNode ifStrcNode;

    public com.eel.antlr.ifStrcNode getIfStrcNode() {
        return ifStrcNode;
    }

    public void setIfStrcNode(ifStrcNode ifStrcNode) {
        this.ifStrcNode = ifStrcNode;
    }

    public selCtrlStrcNode(){};
    public selCtrlStrcNode(ifStrcNode ifStrcNode) {
        this.ifStrcNode = ifStrcNode;
    }

}
