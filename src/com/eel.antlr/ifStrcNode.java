package com.eel.antlr;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ifStrcNode extends selCtrlStrcNode {

    public ifCondNode ifCondNode;
    public String thenToken;

    //    public Lines lines;
    @Nullable
    public List<elseIfStrcNode> elseIfStrcNodeList;

    @Nullable
    public elseStrcNode elseStrcNode;

    public String endIfToken;


    public com.eel.antlr.ifCondNode getIfCondNode() {
        return ifCondNode;
    }

    public void setIfCondNode(com.eel.antlr.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }
    public String getThenToken() {
        return thenToken;
    }

    public void setThenToken(String thenToken) {
        this.thenToken = thenToken;
    }


    @Nullable
    public List<elseIfStrcNode> getElseIfStrcNodeList() {
        return elseIfStrcNodeList;
    }

    public void setElseIfStrcNodeList(@Nullable List<elseIfStrcNode> elseIfStrcNodeList) {
        this.elseIfStrcNodeList = elseIfStrcNodeList;
    }
    @Nullable
    public com.eel.antlr.elseStrcNode getElseStrcNode() {
        return elseStrcNode;
    }

    public void setElseStrcNode(@Nullable com.eel.antlr.elseStrcNode elseStrcNode) {
        this.elseStrcNode = elseStrcNode;
    }

    public String getEndIfToken() {
        return endIfToken;
    }

    public void setEndIfToken(String endIfToken) {
        this.endIfToken = endIfToken;
    }

    public ifStrcNode(com.eel.antlr.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }

    public ifStrcNode() {}
}
