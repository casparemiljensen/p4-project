package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ProcedureDeclarationNode extends AbstractNode{
    public TerminalNode procedureToken;
    public FormalParametersNode formalParametersNode;

    public ProcedureDeclarationNode (int lineNumber, int colNumber, TerminalNode procedureToken, FormalParametersNode formalParametersNode) {
        super(lineNumber, colNumber);
        this.procedureToken = procedureToken;
        this.formalParametersNode = formalParametersNode;
    }
}
