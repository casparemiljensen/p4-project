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
    public AbstractNode visitProgram(eelParser.ProgramContext ctx) {
        List<ParseTree> input = ctx.children;
        List<ProcedureNode> procedures = CreateList(input, ProcedureNode.class);
        return new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), procedures);
    }

    @Override
    public AbstractNode visitProcedure(eelParser.ProcedureContext ctx) {
        return new ProcedureNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
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
        return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }


    @Override
    public ControlStructNode visitControlStruct(eelParser.ControlStructContext ctx) {
        return new ControlStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ReturnNode visitReturn(eelParser.ReturnContext ctx) {
        return new ReturnNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "return", visitExpression(ctx.expression()));
    }



    @Override
    public AbstractNode visitIfStruct(eelParser.IfStructContext ctx) {
        List<ParseTree> input1 = ctx.children.stream().filter(e -> e instanceof eelParser.ElseIfStructContext).collect(Collectors.toList());
        List<ElseIfStructNode> ElseIfStructNodes = CreateList(input1, ElseIfStructNode.class);
        List<ParseTree> input2 = ctx.children;
        List<StatementNode> statements = CreateList(input2, StatementNode.class);
        return new IfStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCondition(ctx.ifCondition()), "then", statements, ElseIfStructNodes, visitElseStruct(ctx.elseStruct()));
    }

    @Override
    public IfConditionNode visitIfCondition(eelParser.IfConditionContext ctx) {
        return new IfConditionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "if", visitExpression(ctx.expression()));
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
