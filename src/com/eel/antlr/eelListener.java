// Generated from C:/Users/runeb/Desktop/hubben/p4-project/out/production/eel\eel.g4 by ANTLR 4.12.0
package com.eel.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link eelParser}.
 */
public interface eelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link eelParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(eelParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(eelParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(eelParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(eelParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(eelParser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(eelParser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(eelParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(eelParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(eelParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(eelParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(eelParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(eelParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(eelParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(eelParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(eelParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(eelParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(eelParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(eelParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(eelParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(eelParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperator(eelParser.BooleanOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperator(eelParser.BooleanOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#controlStruct}.
	 * @param ctx the parse tree
	 */
	void enterControlStruct(eelParser.ControlStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#controlStruct}.
	 * @param ctx the parse tree
	 */
	void exitControlStruct(eelParser.ControlStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#selectiveStruct}.
	 * @param ctx the parse tree
	 */
	void enterSelectiveStruct(eelParser.SelectiveStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#selectiveStruct}.
	 * @param ctx the parse tree
	 */
	void exitSelectiveStruct(eelParser.SelectiveStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#ifStruct}.
	 * @param ctx the parse tree
	 */
	void enterIfStruct(eelParser.IfStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#ifStruct}.
	 * @param ctx the parse tree
	 */
	void exitIfStruct(eelParser.IfStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(eelParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(eelParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#elseIfStruct}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStruct(eelParser.ElseIfStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#elseIfStruct}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStruct(eelParser.ElseIfStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#elseStruct}.
	 * @param ctx the parse tree
	 */
	void enterElseStruct(eelParser.ElseStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#elseStruct}.
	 * @param ctx the parse tree
	 */
	void exitElseStruct(eelParser.ElseStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#iterativeStruct}.
	 * @param ctx the parse tree
	 */
	void enterIterativeStruct(eelParser.IterativeStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#iterativeStruct}.
	 * @param ctx the parse tree
	 */
	void exitIterativeStruct(eelParser.IterativeStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#repeatStruct}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStruct(eelParser.RepeatStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#repeatStruct}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStruct(eelParser.RepeatStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(eelParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(eelParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#staticValue}.
	 * @param ctx the parse tree
	 */
	void enterStaticValue(eelParser.StaticValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#staticValue}.
	 * @param ctx the parse tree
	 */
	void exitStaticValue(eelParser.StaticValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(eelParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(eelParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#userValue}.
	 * @param ctx the parse tree
	 */
	void enterUserValue(eelParser.UserValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#userValue}.
	 * @param ctx the parse tree
	 */
	void exitUserValue(eelParser.UserValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(eelParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(eelParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(eelParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(eelParser.MethodContext ctx);
}