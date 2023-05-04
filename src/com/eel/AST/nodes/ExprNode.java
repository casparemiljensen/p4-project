package com.eel.AST.nodes;

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
    public String Name;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public ExprNode(){}

}
