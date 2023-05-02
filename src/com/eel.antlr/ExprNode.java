package com.eel.antlr;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExprNode extends AbstractNode {

    @Nullable
    public UserValueNode userValueNode;
    @Nullable
    public AssignNode assignNode;
    @Nullable
    public List<OpNode> opNodes;
    @Nullable
    public List<ValueNode> valueNodes;

    @Nullable
    public UserValueNode getUserValueNode() {
        return userValueNode;
    }

    public void setUserValueNode(@Nullable UserValueNode userValueNode) {
        this.userValueNode = userValueNode;
    }

    @Nullable
    public AssignNode getAssignNode() {
        return assignNode;
    }

    public void setAssignNode(@Nullable AssignNode assignNode) {
        this.assignNode = assignNode;
    }

    @Nullable
    public List<OpNode> getOpNodes() {
        return opNodes;
    }

    public void setOpNodes(@Nullable List<OpNode> opNodes) {
        this.opNodes = opNodes;
    }

    @Nullable
    public List<ValueNode> getValueNodes() {
        return valueNodes;
    }

    public void setValueNodes(@Nullable List<ValueNode> valueNodes) {
        this.valueNodes = valueNodes;
    }

    public ExprNode(){}

}
