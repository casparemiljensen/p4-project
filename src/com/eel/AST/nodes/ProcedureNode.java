package com.eel.AST.nodes;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProcedureNode extends AbstractNode {
    public List<StatementNode> StatementNodes;
    public TerminalNode IdToken;


    public ProcedureNode(int lineNumber, int colNumber, TerminalNode IdToken,  List<StatementNode> StatementNodes) {
        super(lineNumber, colNumber);
        this.StatementNodes = StatementNodes;
        this.IdToken = IdToken;
    }
}
