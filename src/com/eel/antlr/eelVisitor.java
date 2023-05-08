// Generated from C:/Users/runeb/Desktop/hubben/p4-project/out/production/eel\eel.g4 by ANTLR 4.12.0
package com.eel.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link eelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface eelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link eelParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(eelParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(eelParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(eelParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(eelParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(eelParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(eelParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(eelParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(eelParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(eelParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(eelParser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#booleanOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOperator(eelParser.BooleanOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#controlStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStruct(eelParser.ControlStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#selectiveStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectiveStruct(eelParser.SelectiveStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#ifStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStruct(eelParser.IfStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(eelParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#elseIfStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStruct(eelParser.ElseIfStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#elseStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStruct(eelParser.ElseStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#iterativeStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterativeStruct(eelParser.IterativeStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#repeatStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStruct(eelParser.RepeatStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(eelParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#staticValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticValue(eelParser.StaticValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(eelParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#userValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserValue(eelParser.UserValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(eelParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(eelParser.MethodContext ctx);
}