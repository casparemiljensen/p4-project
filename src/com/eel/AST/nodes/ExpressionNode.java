package com.eel.AST.nodes;


import kotlin.NotImplementedError;

public class ExpressionNode extends AbstractNode {
    public ParenExprNode parenExprNode;
    public UnaryExprNode unaryExprNode;
    public InfixExprNode infixExprNode;
    public ValueExprNode valueExprNode;

    public ExpressionNode(int lineNumber, int colNumber, AbstractNode node){
        super(lineNumber, colNumber);
        if (node instanceof ParenExprNode) this.parenExprNode = (ParenExprNode) node;
        else if (node instanceof UnaryExprNode) this.unaryExprNode = (UnaryExprNode) node;
        else if (node instanceof InfixExprNode) this.infixExprNode = (InfixExprNode) node;
        else if (node instanceof ValueExprNode) this.valueExprNode = (ValueExprNode) node;
        else throw new NotImplementedError();
    }


}
