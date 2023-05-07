package com.eel.AST.nodes;

import com.eel.antlr.eelParser;

public abstract class AstVisitor <T> {
        public abstract T Visit(ProgramNode node);
        public abstract T Visit(ProcedureNode node);
        public abstract T Visit(FormalParametersNode node);
        public abstract T Visit(DeclarationNode node);
        public abstract T Visit(StatementNode node);
        public abstract T Visit(ExpressionNode node);
        public abstract T Visit(OperatorNode node);
        public abstract T Visit(BinaryOperatorNode node);
        public abstract T Visit(BooleanOperatorNode node);
        public abstract T Visit(ControlStructNode node);
        public abstract T Visit(IterativeStructNode node);
        public abstract T Visit(SelectiveStructNode node);
        public abstract T Visit(IfStructNode node);
        public abstract T Visit(IfConditionNode node);
        public abstract T Visit(ElseIfStructNode node);
        public abstract T Visit(ElseStructNode node);

    public T Visit(T node)
        {
            if (node instanceof eelParser.ProgramContext) {
                return Visit((ProgramNode) node);
            }
            else if (node instanceof eelParser.ProcedureContext) {
                return Visit((ProcedureNode) node);
            }
            else if (node instanceof eelParser.FormalParamsContext) {
                return Visit((FormalParametersNode) node);
            }
            else if(node instanceof eelParser.StatementContext) {
                return Visit((StatementNode) node);
            }
            else if(node instanceof eelParser.DeclarationContext) {
                return Visit((DeclarationNode) node);
            }
            else if(node instanceof eelParser.StatementContext) {
                return Visit((StatementNode) node);
            }
            else if(node instanceof eelParser.ExpressionContext) {
                return Visit((ExpressionNode) node);
            }
            else if(node instanceof eelParser.OperatorContext) {
                return Visit((OperatorNode) node);
            }
            else if(node instanceof eelParser.BinaryOperatorContext) {
                return Visit((BinaryOperatorNode) node);
            }
            else if(node instanceof eelParser.BooleanOperatorContext) {
                return Visit((BooleanOperatorNode) node);
            }
            else if(node instanceof eelParser.ControlStructContext) {
                return Visit((ControlStructNode) node);
            }
            else if(node instanceof eelParser.IterativeStructContext) {
                return Visit((IterativeStructNode) node);
            }
            else if(node instanceof eelParser.SelectiveStructContext) {
                return Visit((SelectiveStructNode) node);
            }
            else if(node instanceof eelParser.IfStructContext) {
                return Visit((IfStructNode) node);
            }
            else if(node instanceof eelParser.IfConditionContext) {
                return Visit((IfConditionNode) node);
            }
            else if(node instanceof eelParser.ElseIfStructContext) {
                return Visit((ElseIfStructNode) node);
            }
            else if(node instanceof eelParser.ElseStructContext) {
                return Visit((ElseStructNode) node);
            }
            else {
                return null;
            }
        }

}
