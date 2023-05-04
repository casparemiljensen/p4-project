package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExpressionNode extends AbstractNode {

    @Nullable
    public UserValueNode userValueNode;
    @Nullable
    public AssignNode assignNode;
    @Nullable
    public List<OperatorNode> opNodes;
    @Nullable
    public List<ValueNode> valueNodes;

    public ExpressionNode(int lineNumber, int colNumber){
        super(lineNumber, colNumber);
    }

}
