package com.eel.AST.nodes;

import java.util.List;

public class ProgramNode extends AbstractNode {
    public List<ProcedureNode> procedureNodes;

    public ProgramNode(int lineNumber, int colNumber, List<ProcedureNode> procedureNodes) {
        super(lineNumber, colNumber);
        this.procedureNodes = procedureNodes;
    }
}
