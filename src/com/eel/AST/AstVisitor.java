package com.eel.AST;

import com.eel.AST.nodes.*;
import com.eel.antlr.eelParser;

public abstract class AstVisitor<T> {
	public abstract T Visit(ProgramNode node, int instructionCode);

	public abstract T Visit(ProcedureNode node, int instructionCode);

	public abstract T Visit(FormalParametersNode node, int instructionCode);

	public abstract T Visit(DeclarationNode node, int instructionCode);

	public abstract T Visit(StatementNode node, int instructionCode);

	public abstract T Visit(ExpressionNode node, int instructionCode);

	public abstract T Visit(OperatorNode node, int instructionCode);

	public abstract T Visit(BinaryOperatorNode node, int instructionCode);

	public abstract T Visit(BooleanOperatorNode node, int instructionCode);

	public abstract T Visit(ControlStructNode node, int instructionCode);

	public abstract T Visit(IterativeStructNode node, int instructionCode);

	public abstract T Visit(SelectiveStructNode node, int instructionCode);

	public abstract T Visit(IfStructNode node, int instructionCode);

	public abstract T Visit(IfConditionNode node, int instructionCode);

	public abstract T Visit(ElseIfStructNode node, int instructionCode);

	public abstract T Visit(ElseStructNode node, int instructionCode);

	public T Visit(T node, int instructionCode) {
		if (node instanceof eelParser.ProgramContext) {
			return Visit((ProgramNode) node, instructionCode);
		} else if (node instanceof eelParser.ProcedureContext) {
			return Visit((ProcedureNode) node, instructionCode);
		} else if (node instanceof eelParser.FormalParamsContext) {
			return Visit((FormalParametersNode) node, instructionCode);
		} else if (node instanceof eelParser.StatementContext) {
			return Visit((StatementNode) node, instructionCode);
		} else if (node instanceof eelParser.DeclarationContext) {
			return Visit((DeclarationNode) node, instructionCode);
		} else if (node instanceof eelParser.StatementContext) {
			return Visit((StatementNode) node, instructionCode);
		} else if (node instanceof eelParser.ExpressionContext) {
			return Visit((ExpressionNode) node, instructionCode);
		} else if (node instanceof eelParser.OperatorContext) {
			return Visit((OperatorNode) node, instructionCode);
		} else if (node instanceof eelParser.BinaryOperatorContext) {
			return Visit((BinaryOperatorNode) node, instructionCode);
		} else if (node instanceof eelParser.BooleanOperatorContext) {
			return Visit((BooleanOperatorNode) node, instructionCode);
		} else if (node instanceof eelParser.ControlStructContext) {
			return Visit((ControlStructNode) node, instructionCode);
		} else if (node instanceof eelParser.IterativeStructContext) {
			return Visit((IterativeStructNode) node, instructionCode);
		} else if (node instanceof eelParser.SelectiveStructContext) {
			return Visit((SelectiveStructNode) node, instructionCode);
		} else if (node instanceof eelParser.IfStructContext) {
			return Visit((IfStructNode) node, instructionCode);
		} else if (node instanceof eelParser.IfConditionContext) {
			return Visit((IfConditionNode) node, instructionCode);
		} else if (node instanceof eelParser.ElseIfStructContext) {
			return Visit((ElseIfStructNode) node, instructionCode);
		} else if (node instanceof eelParser.ElseStructContext) {
			return Visit((ElseStructNode) node, instructionCode);
		} else {
			return null;
		}
	}

}
