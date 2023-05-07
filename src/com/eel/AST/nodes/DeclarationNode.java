package com.eel.AST.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class DeclarationNode extends AbstractNode {
    String letToken;
    TerminalNode IdToken;
    @Nullable
    AssignmentNode AssignmentNode;

    public DeclarationNode(int lineNumber, int colNumber, String letToken, TerminalNode IdToken, @Nullable AssignmentNode AssignmentNode) {
        super(lineNumber, colNumber);
        this.letToken = letToken;
        this.IdToken = IdToken;
        this.AssignmentNode = AssignmentNode;
    }
}
