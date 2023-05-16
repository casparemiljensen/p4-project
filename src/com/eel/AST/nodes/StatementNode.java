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
    public FunctionCallNode functionCallNode;
    @Nullable
    public ProcedureCallNode procedureCallNode;
    @Nullable
    public AssignmentNode assignmentNode;
    @Nullable
    public TerminalNode terminal;
    @Nullable
    public ReturnNode returnNode;
    @Nullable
    public CellNode cellNode;


    public StatementNode(int lineNumber, int colNumber, @Nullable AbstractNode node, @Nullable TerminalNode terminal, @Nullable AssignmentNode assignmentNode) {
        super(lineNumber, colNumber);


            if (node instanceof DeclarationNode) {
                this.declarationNode = (DeclarationNode) node;
            }
            else if (node instanceof ControlStructNode) {
                this.controlStructNode = (ControlStructNode) node;
            }
            else if (node instanceof FunctionCallNode) {
                this.functionCallNode = (FunctionCallNode) node;
            }
            else if (node instanceof ProcedureCallNode) {
                this.procedureCallNode = (ProcedureCallNode) node;
            }
            //Variable+Assignment
            else if (terminal instanceof TerminalNode && assignmentNode instanceof AssignmentNode) {
                this.terminal = terminal;
                this.assignmentNode = assignmentNode;
            }
            //Cell+Assignment
            else if (node instanceof CellNode && assignmentNode instanceof AssignmentNode) {
                this.cellNode = (CellNode) node;
                this.assignmentNode = assignmentNode;
            }
            else if (node instanceof ReturnNode) {
                this.returnNode = (ReturnNode) node;
            }
            else {
                throw new NotImplementedError("Could not find instance of StatementNode");
            }
        }
}
