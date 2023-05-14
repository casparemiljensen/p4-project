package com.eel.AST.nodes;

import kotlin.NotImplementedError;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Nullable;

public class ValueNode extends AbstractNode {

    @Nullable
    public TerminalNode INUM;
    @Nullable
    public TerminalNode FLOAT;
    @Nullable
    public TerminalNode STRING;
    @Nullable
    public TerminalNode VARIABLE;

    @Nullable
    public CellNode cellNode;
    @Nullable
    public FunctionCallNode functionCallNode;
    @Nullable
    public ProcedureCallNode procedureCallNode;
    @Nullable
    public MethodNode methodNode;


    public ValueNode(int lineNumber, int colNumber, @Nullable AbstractNode node, @Nullable TerminalNode terminal, String terminalType, @Nullable MethodNode methodNode) {
        super(lineNumber, colNumber);

        if (terminal instanceof TerminalNode) {
            switch (terminalType) {
                case "INUM": this.INUM = terminal;
                case "FLOAT": this.FLOAT = terminal;
                case "STRING": this.STRING = terminal;
                case "VARIABLE": this.VARIABLE = terminal;
            }
        }
        else if (node instanceof CellNode) {
            this.cellNode = (CellNode) node;
        }
        else if (node instanceof FunctionCallNode) {
            this.functionCallNode = (FunctionCallNode) node;
        }
        else if (node instanceof ProcedureCallNode) {
            this.procedureCallNode = (ProcedureCallNode) node;
        }
        else {
            throw new NotImplementedError();
        }
        if (methodNode != null) {
            this.methodNode = methodNode;
        }
    }

}
