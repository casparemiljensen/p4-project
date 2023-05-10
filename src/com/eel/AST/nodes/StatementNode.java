package com.eel.AST.nodes;

import kotlin.NotImplementedError;
import org.jetbrains.annotations.Nullable;


public class StatementNode extends AbstractNode {
    @Nullable
    public DeclarationNode declarationNode;
    @Nullable
    public ControlStructNode controlStructNode;
    @Nullable
    public AssignmentNode assignmentNode;
    @Nullable
    public FunctionNode functionNode;
    @Nullable
    public ReturnNode returnNode;

    public StatementNode(int lineNumber, int colNumber, AbstractNode node) {
        super(lineNumber, colNumber);
        if (terminal instanceof TerminalNode) {
            this.terminal = terminal;
            if (node instanceof DeclarationNode) {
                this.declarationNode = (DeclarationNode) node;
            } else if (node instanceof ControlStructNode) {
                this.controlStructNode = (ControlStructNode) node;
            } else if (node instanceof AssignmentNode) {
                this.assignmentNode = (AssignmentNode) node;
            } else if (node instanceof FunctionNode) {
                this.functionNode = (FunctionNode) node;
            } else if (node instanceof ReturnNode) {
                this.returnNode = (ReturnNode) node;
            } else {
                throw new NotImplementedError();
            }
        }
    }
}
