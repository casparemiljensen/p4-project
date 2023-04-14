// Generated from eel.g4 by ANTLR 4.12.0

import {ParseTreeListener} from "antlr4";


import { ProgContext } from "./eelParser";
import { ProcsContext } from "./eelParser";
import { ProcContext } from "./eelParser";
import { FormalParamsContext } from "./eelParser";
import { LinesContext } from "./eelParser";
import { DclContext } from "./eelParser";
import { StmtContext } from "./eelParser";
import { ExprContext } from "./eelParser";
import { OperatorContext } from "./eelParser";
import { BinaryOperatorContext } from "./eelParser";
import { BoolOperatorContext } from "./eelParser";
import { CtrlStrcContext } from "./eelParser";
import { SelCtrlStrcContext } from "./eelParser";
import { IfStrcContext } from "./eelParser";
import { ElseStrcContext } from "./eelParser";
import { IterCtrlStrcContext } from "./eelParser";
import { RepeatStrcContext } from "./eelParser";
import { BooleanExprContext } from "./eelParser";
import { ValueContext } from "./eelParser";
import { FuncCallContext } from "./eelParser";
import { ActualParamsContext } from "./eelParser";


/**
 * This interface defines a complete listener for a parse tree produced by
 * `eelParser`.
 */
export default class eelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by `eelParser.prog`.
	 * @param ctx the parse tree
	 */
	enterProg?: (ctx: ProgContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.prog`.
	 * @param ctx the parse tree
	 */
	exitProg?: (ctx: ProgContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.procs`.
	 * @param ctx the parse tree
	 */
	enterProcs?: (ctx: ProcsContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.procs`.
	 * @param ctx the parse tree
	 */
	exitProcs?: (ctx: ProcsContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.proc`.
	 * @param ctx the parse tree
	 */
	enterProc?: (ctx: ProcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.proc`.
	 * @param ctx the parse tree
	 */
	exitProc?: (ctx: ProcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.formalParams`.
	 * @param ctx the parse tree
	 */
	enterFormalParams?: (ctx: FormalParamsContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.formalParams`.
	 * @param ctx the parse tree
	 */
	exitFormalParams?: (ctx: FormalParamsContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.lines`.
	 * @param ctx the parse tree
	 */
	enterLines?: (ctx: LinesContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.lines`.
	 * @param ctx the parse tree
	 */
	exitLines?: (ctx: LinesContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.dcl`.
	 * @param ctx the parse tree
	 */
	enterDcl?: (ctx: DclContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.dcl`.
	 * @param ctx the parse tree
	 */
	exitDcl?: (ctx: DclContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.stmt`.
	 * @param ctx the parse tree
	 */
	enterStmt?: (ctx: StmtContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.stmt`.
	 * @param ctx the parse tree
	 */
	exitStmt?: (ctx: StmtContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.expr`.
	 * @param ctx the parse tree
	 */
	enterExpr?: (ctx: ExprContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.expr`.
	 * @param ctx the parse tree
	 */
	exitExpr?: (ctx: ExprContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.operator`.
	 * @param ctx the parse tree
	 */
	enterOperator?: (ctx: OperatorContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.operator`.
	 * @param ctx the parse tree
	 */
	exitOperator?: (ctx: OperatorContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.binaryOperator`.
	 * @param ctx the parse tree
	 */
	enterBinaryOperator?: (ctx: BinaryOperatorContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.binaryOperator`.
	 * @param ctx the parse tree
	 */
	exitBinaryOperator?: (ctx: BinaryOperatorContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.boolOperator`.
	 * @param ctx the parse tree
	 */
	enterBoolOperator?: (ctx: BoolOperatorContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.boolOperator`.
	 * @param ctx the parse tree
	 */
	exitBoolOperator?: (ctx: BoolOperatorContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.ctrlStrc`.
	 * @param ctx the parse tree
	 */
	enterCtrlStrc?: (ctx: CtrlStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.ctrlStrc`.
	 * @param ctx the parse tree
	 */
	exitCtrlStrc?: (ctx: CtrlStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.selCtrlStrc`.
	 * @param ctx the parse tree
	 */
	enterSelCtrlStrc?: (ctx: SelCtrlStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.selCtrlStrc`.
	 * @param ctx the parse tree
	 */
	exitSelCtrlStrc?: (ctx: SelCtrlStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.ifStrc`.
	 * @param ctx the parse tree
	 */
	enterIfStrc?: (ctx: IfStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.ifStrc`.
	 * @param ctx the parse tree
	 */
	exitIfStrc?: (ctx: IfStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.elseStrc`.
	 * @param ctx the parse tree
	 */
	enterElseStrc?: (ctx: ElseStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.elseStrc`.
	 * @param ctx the parse tree
	 */
	exitElseStrc?: (ctx: ElseStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.iterCtrlStrc`.
	 * @param ctx the parse tree
	 */
	enterIterCtrlStrc?: (ctx: IterCtrlStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.iterCtrlStrc`.
	 * @param ctx the parse tree
	 */
	exitIterCtrlStrc?: (ctx: IterCtrlStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.repeatStrc`.
	 * @param ctx the parse tree
	 */
	enterRepeatStrc?: (ctx: RepeatStrcContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.repeatStrc`.
	 * @param ctx the parse tree
	 */
	exitRepeatStrc?: (ctx: RepeatStrcContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.booleanExpr`.
	 * @param ctx the parse tree
	 */
	enterBooleanExpr?: (ctx: BooleanExprContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.booleanExpr`.
	 * @param ctx the parse tree
	 */
	exitBooleanExpr?: (ctx: BooleanExprContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.value`.
	 * @param ctx the parse tree
	 */
	enterValue?: (ctx: ValueContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.value`.
	 * @param ctx the parse tree
	 */
	exitValue?: (ctx: ValueContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.funcCall`.
	 * @param ctx the parse tree
	 */
	enterFuncCall?: (ctx: FuncCallContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.funcCall`.
	 * @param ctx the parse tree
	 */
	exitFuncCall?: (ctx: FuncCallContext) => void;
	/**
	 * Enter a parse tree produced by `eelParser.actualParams`.
	 * @param ctx the parse tree
	 */
	enterActualParams?: (ctx: ActualParamsContext) => void;
	/**
	 * Exit a parse tree produced by `eelParser.actualParams`.
	 * @param ctx the parse tree
	 */
	exitActualParams?: (ctx: ActualParamsContext) => void;
}

