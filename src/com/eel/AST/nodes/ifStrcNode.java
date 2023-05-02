package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ifStrcNode extends AbstractNode {

    public ifCondNode ifCondNode;
    public String thenToken;
    public LinesNode lines;
    @Nullable
    public List<elseIfStrcNode> elseIfStrcNodeList;

    @Nullable
    public elseIfStrcNode elseIfStrcNode;
    @Nullable
    public elseStrcNode elseStrcNode;

    public String endIfToken;


    public com.eel.AST.nodes.ifCondNode getIfCondNode() {
        return ifCondNode;
    }

    public void setIfCondNode(com.eel.AST.nodes.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }
    public String getThenToken() {
        return thenToken;
    }

    public void setThenToken(String thenToken) {
        this.thenToken = thenToken;
    }
    public LinesNode getLines() {
        return lines;
    }
    public void setLines(LinesNode lines) {
        this.lines = lines;
    }
    @Nullable
    public List<elseIfStrcNode> getElseIfStrcNodeList() {
        return elseIfStrcNodeList;
    }

    public void setElseIfStrcNodeList(List<elseIfStrcNode> elseIfStrcNodeList) {
        this.elseIfStrcNodeList = elseIfStrcNodeList;
    }

    @Nullable
    public elseIfStrcNode getElseIfStrcNode() {
        return elseIfStrcNode;
    }

    public void setElseIfStrcNode(com.eel.AST.nodes.elseIfStrcNode elseIfStrcNode) {
        this.elseIfStrcNode = elseIfStrcNode;
    }
    @Nullable
    public elseStrcNode getElseStrcNode() {
        return elseStrcNode;
    }

    public void setElseStrcNode(@Nullable com.eel.AST.nodes.elseStrcNode elseStrcNode) {
        this.elseStrcNode = elseStrcNode;
    }


    public String getEndIfToken() {
        return endIfToken;
    }

    public void setEndIfToken(String endIfToken) {
        this.endIfToken = endIfToken;
    }

    public ifStrcNode(com.eel.AST.nodes.ifCondNode ifCondNode) {
        this.ifCondNode = ifCondNode;
    }

    public ifStrcNode() {
        elseIfStrcNodeList = new ArrayList<elseIfStrcNode>();
    }
}
