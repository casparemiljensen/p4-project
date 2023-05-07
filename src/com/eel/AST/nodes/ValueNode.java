package com.eel.AST.nodes;

public class ValueNode extends AbstractNode {
    public StaticValueNode staticValueNode;
    public UserValueNode userValueNode;

    // staticValue
    public ValueNode(int lineNumber, int colNumber, StaticValueNode staticValueNode) {
        super(lineNumber, colNumber);
        this.staticValueNode = staticValueNode;
    }

    // userValue
    public ValueNode(int lineNumber, int colNumber, UserValueNode userValueNode) {
        super(lineNumber, colNumber);
        this.userValueNode = userValueNode;
    }
}
