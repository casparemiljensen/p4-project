package com.eel.AST.nodes;

public class ParenExprNode extends AbstractNode {

    public char leftPar;
    public char rightPar;
    public ExpressionNode expressionNode;
    public ParenExprNode(int lineNumber, int colNumber, char leftPar, ExpressionNode expressionNode, char rightPar) {
        super(lineNumber, colNumber);
        this.leftPar = leftPar;
        this.expressionNode = expressionNode;
        this.rightPar = rightPar;
    }
}
