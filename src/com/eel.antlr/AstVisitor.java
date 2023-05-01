package com.eel.antlr;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class AstVisitor <T> {
        public abstract T Visit(ProgNode node);
        public abstract T Visit(ProcsNode node);
        public abstract T Visit(ProcNode node);
        public abstract T Visit(FormalParamsNode node);
        public abstract T Visit(eelParser.LinesContext node);
        public abstract T Visit(eelParser.DclContext node);
        public abstract T Visit(eelParser.AssignmentContext node);
        public abstract T Visit(eelParser.StmtContext node);
        public abstract T Visit(eelParser.ExprContext node);



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
                return Visit((eelParser.LinesContext) node);
            }
            else if(node instanceof eelParser.DclContext) {
                return Visit((eelParser.DclContext) node);
            }
            else if(node instanceof eelParser.AssignmentContext) {
                return Visit((eelParser.AssignmentContext) node);
            }
            else if(node instanceof eelParser.StmtContext) {
                return Visit((eelParser.StmtContext) node);
            }
            else if(node instanceof eelParser.ExprContext) {
                return Visit((eelParser.ExprContext) node);
            }
            else {
                return null;
            }
        }

}
