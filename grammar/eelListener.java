// Generated from eel.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link eelParser}.
 */
public interface eelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link eelParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(eelParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(eelParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#procs}.
	 * @param ctx the parse tree
	 */
	void enterProcs(eelParser.ProcsContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#procs}.
	 * @param ctx the parse tree
	 */
	void exitProcs(eelParser.ProcsContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#proc}.
	 * @param ctx the parse tree
	 */
	void enterProc(eelParser.ProcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#proc}.
	 * @param ctx the parse tree
	 */
	void exitProc(eelParser.ProcContext ctx);
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
	 * Enter a parse tree produced by {@link eelParser#lines}.
	 * @param ctx the parse tree
	 */
	void enterLines(eelParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#lines}.
	 * @param ctx the parse tree
	 */
	void exitLines(eelParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(eelParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(eelParser.DclContext ctx);
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
	 * Enter a parse tree produced by {@link eelParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(eelParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(eelParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(eelParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(eelParser.ExprContext ctx);
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
	 * Enter a parse tree produced by {@link eelParser#boolOperator}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperator(eelParser.BoolOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#boolOperator}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperator(eelParser.BoolOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#ctrlStrc}.
	 * @param ctx the parse tree
	 */
	void enterCtrlStrc(eelParser.CtrlStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#ctrlStrc}.
	 * @param ctx the parse tree
	 */
	void exitCtrlStrc(eelParser.CtrlStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#selCtrlStrc}.
	 * @param ctx the parse tree
	 */
	void enterSelCtrlStrc(eelParser.SelCtrlStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#selCtrlStrc}.
	 * @param ctx the parse tree
	 */
	void exitSelCtrlStrc(eelParser.SelCtrlStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#ifStrc}.
	 * @param ctx the parse tree
	 */
	void enterIfStrc(eelParser.IfStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#ifStrc}.
	 * @param ctx the parse tree
	 */
	void exitIfStrc(eelParser.IfStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#ifCond}.
	 * @param ctx the parse tree
	 */
	void enterIfCond(eelParser.IfCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#ifCond}.
	 * @param ctx the parse tree
	 */
	void exitIfCond(eelParser.IfCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#elseIfStrc}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStrc(eelParser.ElseIfStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#elseIfStrc}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStrc(eelParser.ElseIfStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#elseStrc}.
	 * @param ctx the parse tree
	 */
	void enterElseStrc(eelParser.ElseStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#elseStrc}.
	 * @param ctx the parse tree
	 */
	void exitElseStrc(eelParser.ElseStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#iterCtrlStrc}.
	 * @param ctx the parse tree
	 */
	void enterIterCtrlStrc(eelParser.IterCtrlStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#iterCtrlStrc}.
	 * @param ctx the parse tree
	 */
	void exitIterCtrlStrc(eelParser.IterCtrlStrcContext ctx);
	/**
	 * Enter a parse tree produced by {@link eelParser#repeatStrc}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStrc(eelParser.RepeatStrcContext ctx);
	/**
	 * Exit a parse tree produced by {@link eelParser#repeatStrc}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStrc(eelParser.RepeatStrcContext ctx);
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