package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class DeclarationNode extends AbstractNode {
    String letToken;
    public TerminalNode IdToken;
    @Nullable
    public AssignmentNode assignmentNode;

    public DeclarationNode(int lineNumber, int colNumber, String letToken, TerminalNode IdToken, @Nullable AssignmentNode assignmentNode) {
        super(lineNumber, colNumber);
        this.letToken = letToken;
        this.IdToken = IdToken;
        this.assignmentNode = assignmentNode;
    }
}
