package com.eel.AST.nodes;

import kotlin.Function;
import kotlin.NotImplementedError;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;


public class StatementNode extends AbstractNode {
    @Nullable
    public DeclarationNode declarationNode;
    @Nullable
    public ControlStructNode controlStructNode;
    @Nullable
    public CallNode callNode;
    @Nullable
    public AssignmentNode assignmentNode;
    @Nullable
    public TerminalNode terminal;
    @Nullable
    public ReturnNode returnNode;
    @Nullable
    public CellNode cellNode;


    public StatementNode(int lineNumber, int colNumber, @Nullable AbstractNode node, @Nullable TerminalNode terminal) {
        super(lineNumber, colNumber);


            if (node instanceof DeclarationNode) {
                this.declarationNode = (DeclarationNode) node;
            }
            else if (node instanceof ControlStructNode) {
                this.controlStructNode = (ControlStructNode) node;
            }
            else if (node instanceof CallNode) {
                this.callNode = (CallNode) node;
            }
            else if (node instanceof AssignmentNode) {
                this.assignmentNode = (AssignmentNode) node;
            }
            else if (node instanceof ReturnNode) {
                this.returnNode = (ReturnNode) node;
            }
            else {
                throw new NotImplementedError();
            }
        }
}
