package com.eel.AST.nodes;

import java.util.List;

public class ActualParamsNode extends AbstractNode {
    public List<ValueNode> valuesNodes;
    public ActualParamsNode(int lineNumber, int colNumber, List<ValueNode> valuesNodes) {
        super(lineNumber, colNumber);
        this.valuesNodes = valuesNodes;
    }
}
