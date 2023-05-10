package com.eel.AST.nodes;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProcedureNode extends AbstractNode {
    public List<StatementNode> statementNodes;
    public TerminalNode idToken;
    @Nullable
    public FormalParametersNode formalParametersNode;


    public ProcedureNode(int lineNumber, int colNumber, TerminalNode idToken, List<StatementNode> statementNodes, @Nullable FormalParametersNode formalParametersNode) {
        super(lineNumber, colNumber);
        this.statementNodes = statementNodes;
        this.idToken = idToken;
        this.formalParametersNode = formalParametersNode;

    }
}
