package com.eel.AST.nodes;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProcedureNode extends AbstractNode {

    public ProcedureDeclarationNode procedureDeclarationNode;
    @Nullable
    public List<StatementNode> StatementNodes;



    public ProcedureNode(int lineNumber, int colNumber, ProcedureDeclarationNode procedureDeclarationNode, @Nullable List<StatementNode> StatementNodes) {
        super(lineNumber, colNumber);
        this.StatementNodes = StatementNodes;
        this.procedureDeclarationNode = procedureDeclarationNode;
    }
}
