// Generated from C:/Users/caspa/Qsync/Dokumenter/Skole & Uddannelse/AAU/Software Bachelor/4. Semester/Project/p4-project/grammar\eel.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link eelParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(eelParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#procs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcs(eelParser.ProcsContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#proc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc(eelParser.ProcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(eelParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(eelParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(eelParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(eelParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(eelParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(eelParser.ExprContext ctx);
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
	 * Visit a parse tree produced by {@link eelParser#boolOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperator(eelParser.BoolOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#ctrlStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtrlStrc(eelParser.CtrlStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#selCtrlStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelCtrlStrc(eelParser.SelCtrlStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#ifStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStrc(eelParser.IfStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#ifCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCond(eelParser.IfCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#elseIfStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStrc(eelParser.ElseIfStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#elseStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStrc(eelParser.ElseStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#iterCtrlStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterCtrlStrc(eelParser.IterCtrlStrcContext ctx);
	/**
	 * Visit a parse tree produced by {@link eelParser#repeatStrc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStrc(eelParser.RepeatStrcContext ctx);
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