package com.eel.AST.nodes;

import com.eel.antlr.eelParser;

public abstract class AstVisitor <T> {
        public abstract T Visit(ProgNode node);
        public abstract T Visit(ProcsNode node);
        public abstract T Visit(ProcNode node);
        public abstract T Visit(FormalParamsNode node);
        public abstract T Visit(LinesNode node);
        public abstract T Visit(DclNode node);
        public abstract T Visit(AssignNode node);
        public abstract T Visit(StmtNode node);
        public abstract T Visit(ExprNode node);
        public abstract T Visit(OpNode node);
        public abstract T Visit(BinOpNode node);
        public abstract T Visit(BoolOpNode node);
        public abstract T Visit(CtrlStrcNode node);
        public abstract T Visit(IterCtrlStrcNode node);
        public abstract T Visit(SelCtrlStrcNode node);
        public abstract T Visit(ifStrcNode node);
        public abstract T Visit(ifCondNode node);
        public abstract T Visit(elseIfStrcNode node);
        public abstract T Visit(elseStrcNode node);

    public T Visit(T node)
        {
            if (node instanceof eelParser.ProgContext) {
                return Visit((ProgNode) node);
            }
            else if (node instanceof eelParser.ProcsContext) {
                return Visit((ProcsNode) node);
            }
            else if (node instanceof eelParser.ProcContext) {
                return Visit((ProcNode) node);
            }
            else if (node instanceof eelParser.FormalParamsContext) {
                return Visit((FormalParamsNode) node);
            }
            else if(node instanceof eelParser.LinesContext) {
                return Visit((LinesNode) node);
            }
            else if(node instanceof eelParser.DclContext) {
                return Visit((DclNode) node);
            }
            else if(node instanceof eelParser.AssignmentContext) {
                return Visit((AssignNode) node);
            }
            else if(node instanceof eelParser.StmtContext) {
                return Visit((StmtNode) node);
            }
            else if(node instanceof eelParser.ExprContext) {
                return Visit((ExprNode) node);
            }
            else if(node instanceof eelParser.OperatorContext) {
                return Visit((OpNode) node);
            }
            else if(node instanceof eelParser.BinaryOperatorContext) {
                return Visit((BinOpNode) node);
            }
            else if(node instanceof eelParser.BoolOperatorContext) {
                return Visit((BoolOpNode) node);
            }
            else if(node instanceof eelParser.CtrlStrcContext) {
                return Visit((CtrlStrcNode) node);
            }
            else if(node instanceof eelParser.IterCtrlStrcContext) {
                return Visit((IterCtrlStrcNode) node);
            }
            else if(node instanceof eelParser.SelCtrlStrcContext) {
                return Visit((SelCtrlStrcNode) node);
            }
            else if(node instanceof eelParser.IfStrcContext) {
                return Visit((ifStrcNode) node);
            }
            else if(node instanceof eelParser.IfCondContext) {
                return Visit((ifCondNode) node);
            }
            else if(node instanceof eelParser.ElseIfStrcContext) {
                return Visit((elseIfStrcNode) node);
            }
            else if(node instanceof eelParser.ElseStrcContext) {
                return Visit((elseStrcNode) node);
            }
//            Capitalize last four methods
            else {
                return null;
            }
        }

}
