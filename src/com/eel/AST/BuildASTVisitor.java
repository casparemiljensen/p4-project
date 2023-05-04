package com.eel.AST;

import com.eel.AST.nodes.*;
import com.eel.antlr.eelBaseVisitor;
import com.eel.antlr.eelParser;
import com.eel.antlr.eelVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildASTVisitor extends eelBaseVisitor<AbstractNode> implements eelVisitor<AbstractNode> {

    @Override
    public ProgramNode visitProgram(eelParser.ProgramContext ctx) {
        List<ParseTree> input = ctx.children;
        List<ProcedureNode> procedures = CreateList(input, ProcedureNode.class);
        return new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), procedures);
    }

    @Override
    public ProcedureNode visitProcedure(eelParser.ProcedureContext ctx) {
        List<StatementNode> statementNodes = CreateList(ctx.children, StatementNode.class);

        return new ProcedureNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID(), statementNodes, visitFormalParams(ctx.formalParams()));
    }

    @Override
    public FormalParametersNode visitFormalParams(eelParser.FormalParamsContext ctx) {
        if (ctx == null) return null;
        return new FormalParametersNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public AbstractNode visitStatement(eelParser.StatementContext ctx) {
        return new StatementNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine(),
                visitDeclaration(ctx.declaration()),
                visitExpression(ctx.expression()),
                visitControlStruct(ctx.controlStruct()),
                visitReturn(ctx.return_())
            );
    }

    @Override
    public DeclarationNode visitDeclaration(eelParser.DeclarationContext ctx) {
        return new DeclarationNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "let", ctx.ID(), visitAssignment(ctx.assignment()));
    }

    @Override
    public AssignmentNode visitAssignment(eelParser.AssignmentContext ctx) {
        return new AssignmentNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "assign", visitExpression(ctx.expression()));
    }

    @Override
    public ExpressionNode visitExpression(eelParser.ExpressionContext ctx) {
        if (ctx == null) return null;
        // expr op expr
        else if (ctx.left != null)
            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), visitExpression(ctx.right), visitOperator(ctx.operator()));
        // '-' expr
        else if (ctx.value().isEmpty())
            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "-", visitExpression(ctx.expression(0)));
        // value
        else
            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitValueNode(ctx.value()));
    }

    @Override
    public ValueNode visitValueNode (eelParser.ValueContext ctx) {
        // staticValue
        if (ctx.userValue().isEmpty())
            return new ValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitStaticValue(ctx.staticValue()));
        // userValue
        else
            return new ValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitUserValue(ctx.userValue()));
    }

    @Override
    public UserValueNode visitUserValue (eelParser.UserValueContext ctx) {
        return new UserValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID(), visitActualParams(ctx.actualParams()));
    }


    @Override
    public StaticValueNode visitStaticValue (eelParser.StaticValueContext ctx) {
        // INUM or STRING
        if (ctx.function().isEmpty())
          return new StaticValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.INUM(), ctx.STRING());
        // function
        else
            return new StaticValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitFunction(ctx.function()));
    }

    @Override
    public FunctionNode visitFunction (eelParser.FunctionContext ctx) {
        return new FunctionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.FUNCTIONS(), visitActualParams(ctx.actualParams()));
    }

    @Override
    public ActualParamsNode visitActualParams (eelParser.ActualParamsContext ctx) {
        if (ctx == null) return null;
        List<ParseTree> input = ctx.children;
        List<ValueNode> values = CreateList(input, ValueNode.class);
        return new ActualParamsNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), values);
    }

    @Override
    public ControlStructNode visitControlStruct(eelParser.ControlStructContext ctx) {
        if (ctx == null) return null;
        // selectiveStruct
        else if (ctx.iterativeStruct().isEmpty())
            return new ControlStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitSelectiveStruct(ctx.selectiveStruct()));
        // iterativeStruct
        else
            return new ControlStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIterativeStruct(ctx.iterativeStruct()));
    }

    @Override
    public SelectiveStructNode visitSelectiveStruct (eelParser.SelectiveStructContext ctx) {
        return new SelectiveStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfStruct(ctx.ifStruct()));
    }

    @Override
    public ReturnNode visitReturn(eelParser.ReturnContext ctx) {
        if (ctx == null) return null;
        return new ReturnNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "return", visitExpression(ctx.expression()));
    }



    @Override
    public IfStructNode visitIfStruct(eelParser.IfStructContext ctx) {
        List<ParseTree> input2 = ctx.children;
        List<StatementNode> statements = CreateList(input2, StatementNode.class);
        List<ParseTree> input1 = ctx.children.stream().filter(e -> e instanceof eelParser.ElseIfStructContext).collect(Collectors.toList());
        List<ElseIfStructNode> ElseIfStructNodes = CreateList(input1, ElseIfStructNode.class);
        return new IfStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCondition(ctx.ifCondition()), "then", statements, ElseIfStructNodes, visitElseStruct(ctx.elseStruct()));
    }

    @Override
    public IfConditionNode visitIfCondition(eelParser.IfConditionContext ctx) {
        return new IfConditionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "if", visitExpression(ctx.expression()));
    }


    @Override
    public OperatorNode visitOperator(eelParser.OperatorContext ctx) {
        return new OperatorNode(0,0);
    }



    @Override
    public ElseIfStructNode visitElseIfStruct(eelParser.ElseIfStructContext ctx) {
        List<ParseTree> input = ctx.children;
        List<StatementNode> statements = CreateList(input, StatementNode.class);
        return new ElseIfStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCondition(ctx.ifCondition()), statements);
    }

    @Override
    public ElseStructNode visitElseStruct(eelParser.ElseStructContext ctx) {
        List<ParseTree> input = ctx.children;
        List<StatementNode> statements = CreateList(input, StatementNode.class);
        return new ElseStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), statements);
    }



    @Override
    public IterativeStructNode visitIterativeStruct(eelParser.IterativeStructContext ctx) {
        throw null;
    }


    private static <T> Collection<T> nullSafe(Collection<T> c) {
        return (c == null) ? Collections.<T>emptyList() : c;
    }
    private <T1, T2> List<T2> CreateList(Collection<T1> list,Class<T2> type){
        List<T2> result = new ArrayList<T2>();
        for (T1 child : nullSafe(list)) {
            result.add(type.cast(visit((ParseTree) child)));
        }
        return result;
    }
}
