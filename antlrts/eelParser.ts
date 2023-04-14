// Generated from eel.g4 by ANTLR 4.12.0
// noinspection ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

import {
	ATN,
	ATNDeserializer, DecisionState, DFA, FailedPredicateException,
	RecognitionException, NoViableAltException, BailErrorStrategy,
	Parser, ParserATNSimulator,
	RuleContext, ParserRuleContext, PredictionMode, PredictionContextCache,
	TerminalNode, RuleNode,
	Token, TokenStream,
	Interval, IntervalSet
} from 'antlr4';
import eelListener from "./eelListener.js";
// for running tests with parameters, TODO: discuss strategy for typed parameters in CI
// eslint-disable-next-line no-unused-vars
type int = number;

export default class eelParser extends Parser {
	public static readonly T__0 = 1;
	public static readonly T__1 = 2;
	public static readonly T__2 = 3;
	public static readonly T__3 = 4;
	public static readonly T__4 = 5;
	public static readonly T__5 = 6;
	public static readonly T__6 = 7;
	public static readonly T__7 = 8;
	public static readonly T__8 = 9;
	public static readonly T__9 = 10;
	public static readonly T__10 = 11;
	public static readonly T__11 = 12;
	public static readonly T__12 = 13;
	public static readonly T__13 = 14;
	public static readonly T__14 = 15;
	public static readonly ID = 16;
	public static readonly FUNCNAME = 17;
	public static readonly BOOLEANOP = 18;
	public static readonly INUM = 19;
	public static readonly STRING = 20;
	public static readonly WS = 21;
	public static readonly FuncCall = 22;
	public static readonly ActualParams = 23;
	public static readonly EOF = Token.EOF;
	public static readonly RULE_prog = 0;
	public static readonly RULE_procs = 1;
	public static readonly RULE_proc = 2;
	public static readonly RULE_formalParams = 3;
	public static readonly RULE_lines = 4;
	public static readonly RULE_dcl = 5;
	public static readonly RULE_stmt = 6;
	public static readonly RULE_expr = 7;
	public static readonly RULE_operator = 8;
	public static readonly RULE_binaryOperator = 9;
	public static readonly RULE_boolOperator = 10;
	public static readonly RULE_ctrlStrc = 11;
	public static readonly RULE_selCtrlStrc = 12;
	public static readonly RULE_ifStrc = 13;
	public static readonly RULE_elseStrc = 14;
	public static readonly RULE_iterCtrlStrc = 15;
	public static readonly RULE_repeatStrc = 16;
	public static readonly RULE_booleanExpr = 17;
	public static readonly RULE_value = 18;
	public static readonly RULE_funcCall = 19;
	public static readonly RULE_actualParams = 20;
	public static readonly literalNames: (string | null)[] = [ null, "'procedure'", 
                                                            "'('", "')'", 
                                                            "'endProcedure'", 
                                                            "','", "'let'", 
                                                            "'+'", "'-'", 
                                                            "'='", "'if'", 
                                                            "'then'", "'endIf'", 
                                                            "'else then'", 
                                                            "'repeat while'", 
                                                            "'endRepeat'" ];
	public static readonly symbolicNames: (string | null)[] = [ null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             null, null, 
                                                             "ID", "FUNCNAME", 
                                                             "BOOLEANOP", 
                                                             "INUM", "STRING", 
                                                             "WS", "FuncCall", 
                                                             "ActualParams" ];
	// tslint:disable:no-trailing-whitespace
	public static readonly ruleNames: string[] = [
		"prog", "procs", "proc", "formalParams", "lines", "dcl", "stmt", "expr", 
		"operator", "binaryOperator", "boolOperator", "ctrlStrc", "selCtrlStrc", 
		"ifStrc", "elseStrc", "iterCtrlStrc", "repeatStrc", "booleanExpr", "value", 
		"funcCall", "actualParams",
	];
	public get grammarFileName(): string { return "eel.g4"; }
	public get literalNames(): (string | null)[] { return eelParser.literalNames; }
	public get symbolicNames(): (string | null)[] { return eelParser.symbolicNames; }
	public get ruleNames(): string[] { return eelParser.ruleNames; }
	public get serializedATN(): number[] { return eelParser._serializedATN; }

	protected createFailedPredicateException(predicate?: string, message?: string): FailedPredicateException {
		return new FailedPredicateException(this, predicate, message);
	}

	constructor(input: TokenStream) {
		super(input);
		this._interp = new ParserATNSimulator(this, eelParser._ATN, eelParser.DecisionsToDFA, new PredictionContextCache());
	}
	// @RuleVersion(0)
	public prog(): ProgContext {
		let localctx: ProgContext = new ProgContext(this, this._ctx, this.state);
		this.enterRule(localctx, 0, eelParser.RULE_prog);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 42;
			this.procs();
			this.state = 43;
			this.match(eelParser.EOF);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public procs(): ProcsContext {
		let localctx: ProcsContext = new ProcsContext(this, this._ctx, this.state);
		this.enterRule(localctx, 2, eelParser.RULE_procs);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 46;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			do {
				{
				{
				this.state = 45;
				this.proc();
				}
				}
				this.state = 48;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			} while (_la===1);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public proc(): ProcContext {
		let localctx: ProcContext = new ProcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 4, eelParser.RULE_proc);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 50;
			this.match(eelParser.T__0);
			this.state = 51;
			this.match(eelParser.ID);
			this.state = 52;
			this.match(eelParser.T__1);
			this.state = 54;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			if (_la===16) {
				{
				this.state = 53;
				this.formalParams();
				}
			}

			this.state = 56;
			this.match(eelParser.T__2);
			this.state = 57;
			this.lines();
			this.state = 58;
			this.match(eelParser.T__3);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public formalParams(): FormalParamsContext {
		let localctx: FormalParamsContext = new FormalParamsContext(this, this._ctx, this.state);
		this.enterRule(localctx, 6, eelParser.RULE_formalParams);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 60;
			this.match(eelParser.ID);
			this.state = 65;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la===5) {
				{
				{
				this.state = 61;
				this.match(eelParser.T__4);
				this.state = 62;
				this.match(eelParser.ID);
				}
				}
				this.state = 67;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public lines(): LinesContext {
		let localctx: LinesContext = new LinesContext(this, this._ctx, this.state);
		this.enterRule(localctx, 8, eelParser.RULE_lines);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 71;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la===6) {
				{
				{
				this.state = 68;
				this.dcl();
				}
				}
				this.state = 73;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 77;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while ((((_la) & ~0x1F) === 0 && ((1 << _la) & 5832704) !== 0)) {
				{
				{
				this.state = 74;
				this.stmt();
				}
				}
				this.state = 79;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 83;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la===10 || _la===14) {
				{
				{
				this.state = 80;
				this.ctrlStrc();
				}
				}
				this.state = 85;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public dcl(): DclContext {
		let localctx: DclContext = new DclContext(this, this._ctx, this.state);
		this.enterRule(localctx, 10, eelParser.RULE_dcl);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 86;
			this.match(eelParser.T__5);
			this.state = 87;
			this.match(eelParser.ID);
			this.state = 91;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while ((((_la) & ~0x1F) === 0 && ((1 << _la) & 263040) !== 0)) {
				{
				{
				this.state = 88;
				this.expr();
				}
				}
				this.state = 93;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public stmt(): StmtContext {
		let localctx: StmtContext = new StmtContext(this, this._ctx, this.state);
		this.enterRule(localctx, 12, eelParser.RULE_stmt);
		try {
			let _alt: number;
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 94;
			this.value();
			this.state = 98;
			this._errHandler.sync(this);
			_alt = this._interp.adaptivePredict(this._input, 7, this._ctx);
			while (_alt !== 2 && _alt !== ATN.INVALID_ALT_NUMBER) {
				if (_alt === 1) {
					{
					{
					this.state = 95;
					this.expr();
					}
					}
				}
				this.state = 100;
				this._errHandler.sync(this);
				_alt = this._interp.adaptivePredict(this._input, 7, this._ctx);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public expr(): ExprContext {
		let localctx: ExprContext = new ExprContext(this, this._ctx, this.state);
		this.enterRule(localctx, 14, eelParser.RULE_expr);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 101;
			this.operator();
			this.state = 102;
			this.value();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public operator(): OperatorContext {
		let localctx: OperatorContext = new OperatorContext(this, this._ctx, this.state);
		this.enterRule(localctx, 16, eelParser.RULE_operator);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 106;
			this._errHandler.sync(this);
			switch (this._input.LA(1)) {
			case 7:
			case 8:
			case 9:
				{
				this.state = 104;
				this.binaryOperator();
				}
				break;
			case 18:
				{
				this.state = 105;
				this.boolOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public binaryOperator(): BinaryOperatorContext {
		let localctx: BinaryOperatorContext = new BinaryOperatorContext(this, this._ctx, this.state);
		this.enterRule(localctx, 18, eelParser.RULE_binaryOperator);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 108;
			_la = this._input.LA(1);
			if(!((((_la) & ~0x1F) === 0 && ((1 << _la) & 896) !== 0))) {
			this._errHandler.recoverInline(this);
			}
			else {
				this._errHandler.reportMatch(this);
			    this.consume();
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public boolOperator(): BoolOperatorContext {
		let localctx: BoolOperatorContext = new BoolOperatorContext(this, this._ctx, this.state);
		this.enterRule(localctx, 20, eelParser.RULE_boolOperator);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 110;
			this.match(eelParser.BOOLEANOP);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public ctrlStrc(): CtrlStrcContext {
		let localctx: CtrlStrcContext = new CtrlStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 22, eelParser.RULE_ctrlStrc);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 114;
			this._errHandler.sync(this);
			switch (this._input.LA(1)) {
			case 14:
				{
				this.state = 112;
				this.iterCtrlStrc();
				}
				break;
			case 10:
				{
				this.state = 113;
				this.selCtrlStrc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public selCtrlStrc(): SelCtrlStrcContext {
		let localctx: SelCtrlStrcContext = new SelCtrlStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 24, eelParser.RULE_selCtrlStrc);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 116;
			this.ifStrc();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public ifStrc(): IfStrcContext {
		let localctx: IfStrcContext = new IfStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 26, eelParser.RULE_ifStrc);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 118;
			this.match(eelParser.T__9);
			this.state = 119;
			this.match(eelParser.T__1);
			this.state = 120;
			this.booleanExpr();
			this.state = 121;
			this.match(eelParser.T__2);
			this.state = 122;
			this.match(eelParser.T__10);
			this.state = 123;
			this.lines();
			this.state = 127;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la===13) {
				{
				{
				this.state = 124;
				this.elseStrc();
				}
				}
				this.state = 129;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 130;
			this.match(eelParser.T__11);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public elseStrc(): ElseStrcContext {
		let localctx: ElseStrcContext = new ElseStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 28, eelParser.RULE_elseStrc);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 132;
			this.match(eelParser.T__12);
			this.state = 133;
			this.lines();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public iterCtrlStrc(): IterCtrlStrcContext {
		let localctx: IterCtrlStrcContext = new IterCtrlStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 30, eelParser.RULE_iterCtrlStrc);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 135;
			this.repeatStrc();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public repeatStrc(): RepeatStrcContext {
		let localctx: RepeatStrcContext = new RepeatStrcContext(this, this._ctx, this.state);
		this.enterRule(localctx, 32, eelParser.RULE_repeatStrc);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 137;
			this.match(eelParser.T__13);
			this.state = 138;
			this.match(eelParser.T__1);
			this.state = 139;
			this.booleanExpr();
			this.state = 140;
			this.match(eelParser.T__2);
			this.state = 141;
			this.lines();
			this.state = 142;
			this.match(eelParser.T__14);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public booleanExpr(): BooleanExprContext {
		let localctx: BooleanExprContext = new BooleanExprContext(this, this._ctx, this.state);
		this.enterRule(localctx, 34, eelParser.RULE_booleanExpr);
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 144;
			this.stmt();
			this.state = 145;
			this.boolOperator();
			this.state = 146;
			this.stmt();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public value(): ValueContext {
		let localctx: ValueContext = new ValueContext(this, this._ctx, this.state);
		this.enterRule(localctx, 36, eelParser.RULE_value);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 148;
			_la = this._input.LA(1);
			if(!((((_la) & ~0x1F) === 0 && ((1 << _la) & 5832704) !== 0))) {
			this._errHandler.recoverInline(this);
			}
			else {
				this._errHandler.reportMatch(this);
			    this.consume();
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public funcCall(): FuncCallContext {
		let localctx: FuncCallContext = new FuncCallContext(this, this._ctx, this.state);
		this.enterRule(localctx, 38, eelParser.RULE_funcCall);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 150;
			this.match(eelParser.FUNCNAME);
			this.state = 151;
			this.match(eelParser.T__1);
			this.state = 153;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			if (_la===23) {
				{
				this.state = 152;
				this.match(eelParser.ActualParams);
				}
			}

			this.state = 155;
			this.match(eelParser.T__2);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}
	// @RuleVersion(0)
	public actualParams(): ActualParamsContext {
		let localctx: ActualParamsContext = new ActualParamsContext(this, this._ctx, this.state);
		this.enterRule(localctx, 40, eelParser.RULE_actualParams);
		let _la: number;
		try {
			this.enterOuterAlt(localctx, 1);
			{
			this.state = 157;
			this.match(eelParser.ID);
			this.state = 162;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la===5) {
				{
				{
				this.state = 158;
				this.match(eelParser.T__4);
				this.state = 159;
				this.match(eelParser.ID);
				}
				}
				this.state = 164;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return localctx;
	}

	public static readonly _serializedATN: number[] = [4,1,23,166,2,0,7,0,2,
	1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,7,7,7,2,8,7,8,2,9,7,9,2,
	10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,14,2,15,7,15,2,16,7,16,2,17,
	7,17,2,18,7,18,2,19,7,19,2,20,7,20,1,0,1,0,1,0,1,1,4,1,47,8,1,11,1,12,1,
	48,1,2,1,2,1,2,1,2,3,2,55,8,2,1,2,1,2,1,2,1,2,1,3,1,3,1,3,5,3,64,8,3,10,
	3,12,3,67,9,3,1,4,5,4,70,8,4,10,4,12,4,73,9,4,1,4,5,4,76,8,4,10,4,12,4,
	79,9,4,1,4,5,4,82,8,4,10,4,12,4,85,9,4,1,5,1,5,1,5,5,5,90,8,5,10,5,12,5,
	93,9,5,1,6,1,6,5,6,97,8,6,10,6,12,6,100,9,6,1,7,1,7,1,7,1,8,1,8,3,8,107,
	8,8,1,9,1,9,1,10,1,10,1,11,1,11,3,11,115,8,11,1,12,1,12,1,13,1,13,1,13,
	1,13,1,13,1,13,1,13,5,13,126,8,13,10,13,12,13,129,9,13,1,13,1,13,1,14,1,
	14,1,14,1,15,1,15,1,16,1,16,1,16,1,16,1,16,1,16,1,16,1,17,1,17,1,17,1,17,
	1,18,1,18,1,19,1,19,1,19,3,19,154,8,19,1,19,1,19,1,20,1,20,1,20,5,20,161,
	8,20,10,20,12,20,164,9,20,1,20,0,0,21,0,2,4,6,8,10,12,14,16,18,20,22,24,
	26,28,30,32,34,36,38,40,0,2,1,0,7,9,3,0,16,16,19,20,22,22,157,0,42,1,0,
	0,0,2,46,1,0,0,0,4,50,1,0,0,0,6,60,1,0,0,0,8,71,1,0,0,0,10,86,1,0,0,0,12,
	94,1,0,0,0,14,101,1,0,0,0,16,106,1,0,0,0,18,108,1,0,0,0,20,110,1,0,0,0,
	22,114,1,0,0,0,24,116,1,0,0,0,26,118,1,0,0,0,28,132,1,0,0,0,30,135,1,0,
	0,0,32,137,1,0,0,0,34,144,1,0,0,0,36,148,1,0,0,0,38,150,1,0,0,0,40,157,
	1,0,0,0,42,43,3,2,1,0,43,44,5,0,0,1,44,1,1,0,0,0,45,47,3,4,2,0,46,45,1,
	0,0,0,47,48,1,0,0,0,48,46,1,0,0,0,48,49,1,0,0,0,49,3,1,0,0,0,50,51,5,1,
	0,0,51,52,5,16,0,0,52,54,5,2,0,0,53,55,3,6,3,0,54,53,1,0,0,0,54,55,1,0,
	0,0,55,56,1,0,0,0,56,57,5,3,0,0,57,58,3,8,4,0,58,59,5,4,0,0,59,5,1,0,0,
	0,60,65,5,16,0,0,61,62,5,5,0,0,62,64,5,16,0,0,63,61,1,0,0,0,64,67,1,0,0,
	0,65,63,1,0,0,0,65,66,1,0,0,0,66,7,1,0,0,0,67,65,1,0,0,0,68,70,3,10,5,0,
	69,68,1,0,0,0,70,73,1,0,0,0,71,69,1,0,0,0,71,72,1,0,0,0,72,77,1,0,0,0,73,
	71,1,0,0,0,74,76,3,12,6,0,75,74,1,0,0,0,76,79,1,0,0,0,77,75,1,0,0,0,77,
	78,1,0,0,0,78,83,1,0,0,0,79,77,1,0,0,0,80,82,3,22,11,0,81,80,1,0,0,0,82,
	85,1,0,0,0,83,81,1,0,0,0,83,84,1,0,0,0,84,9,1,0,0,0,85,83,1,0,0,0,86,87,
	5,6,0,0,87,91,5,16,0,0,88,90,3,14,7,0,89,88,1,0,0,0,90,93,1,0,0,0,91,89,
	1,0,0,0,91,92,1,0,0,0,92,11,1,0,0,0,93,91,1,0,0,0,94,98,3,36,18,0,95,97,
	3,14,7,0,96,95,1,0,0,0,97,100,1,0,0,0,98,96,1,0,0,0,98,99,1,0,0,0,99,13,
	1,0,0,0,100,98,1,0,0,0,101,102,3,16,8,0,102,103,3,36,18,0,103,15,1,0,0,
	0,104,107,3,18,9,0,105,107,3,20,10,0,106,104,1,0,0,0,106,105,1,0,0,0,107,
	17,1,0,0,0,108,109,7,0,0,0,109,19,1,0,0,0,110,111,5,18,0,0,111,21,1,0,0,
	0,112,115,3,30,15,0,113,115,3,24,12,0,114,112,1,0,0,0,114,113,1,0,0,0,115,
	23,1,0,0,0,116,117,3,26,13,0,117,25,1,0,0,0,118,119,5,10,0,0,119,120,5,
	2,0,0,120,121,3,34,17,0,121,122,5,3,0,0,122,123,5,11,0,0,123,127,3,8,4,
	0,124,126,3,28,14,0,125,124,1,0,0,0,126,129,1,0,0,0,127,125,1,0,0,0,127,
	128,1,0,0,0,128,130,1,0,0,0,129,127,1,0,0,0,130,131,5,12,0,0,131,27,1,0,
	0,0,132,133,5,13,0,0,133,134,3,8,4,0,134,29,1,0,0,0,135,136,3,32,16,0,136,
	31,1,0,0,0,137,138,5,14,0,0,138,139,5,2,0,0,139,140,3,34,17,0,140,141,5,
	3,0,0,141,142,3,8,4,0,142,143,5,15,0,0,143,33,1,0,0,0,144,145,3,12,6,0,
	145,146,3,20,10,0,146,147,3,12,6,0,147,35,1,0,0,0,148,149,7,1,0,0,149,37,
	1,0,0,0,150,151,5,17,0,0,151,153,5,2,0,0,152,154,5,23,0,0,153,152,1,0,0,
	0,153,154,1,0,0,0,154,155,1,0,0,0,155,156,5,3,0,0,156,39,1,0,0,0,157,162,
	5,16,0,0,158,159,5,5,0,0,159,161,5,16,0,0,160,158,1,0,0,0,161,164,1,0,0,
	0,162,160,1,0,0,0,162,163,1,0,0,0,163,41,1,0,0,0,164,162,1,0,0,0,13,48,
	54,65,71,77,83,91,98,106,114,127,153,162];

	private static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!eelParser.__ATN) {
			eelParser.__ATN = new ATNDeserializer().deserialize(eelParser._serializedATN);
		}

		return eelParser.__ATN;
	}


	static DecisionsToDFA = eelParser._ATN.decisionToState.map( (ds: DecisionState, index: number) => new DFA(ds, index) );

}

export class ProgContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public procs(): ProcsContext {
		return this.getTypedRuleContext(ProcsContext, 0) as ProcsContext;
	}
	public EOF(): TerminalNode {
		return this.getToken(eelParser.EOF, 0);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_prog;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterProg) {
	 		listener.enterProg(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitProg) {
	 		listener.exitProg(this);
		}
	}
}


export class ProcsContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public proc_list(): ProcContext[] {
		return this.getTypedRuleContexts(ProcContext) as ProcContext[];
	}
	public proc(i: number): ProcContext {
		return this.getTypedRuleContext(ProcContext, i) as ProcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_procs;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterProcs) {
	 		listener.enterProcs(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitProcs) {
	 		listener.exitProcs(this);
		}
	}
}


export class ProcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ID(): TerminalNode {
		return this.getToken(eelParser.ID, 0);
	}
	public lines(): LinesContext {
		return this.getTypedRuleContext(LinesContext, 0) as LinesContext;
	}
	public formalParams(): FormalParamsContext {
		return this.getTypedRuleContext(FormalParamsContext, 0) as FormalParamsContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_proc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterProc) {
	 		listener.enterProc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitProc) {
	 		listener.exitProc(this);
		}
	}
}


export class FormalParamsContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ID_list(): TerminalNode[] {
	    	return this.getTokens(eelParser.ID);
	}
	public ID(i: number): TerminalNode {
		return this.getToken(eelParser.ID, i);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_formalParams;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterFormalParams) {
	 		listener.enterFormalParams(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitFormalParams) {
	 		listener.exitFormalParams(this);
		}
	}
}


export class LinesContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public dcl_list(): DclContext[] {
		return this.getTypedRuleContexts(DclContext) as DclContext[];
	}
	public dcl(i: number): DclContext {
		return this.getTypedRuleContext(DclContext, i) as DclContext;
	}
	public stmt_list(): StmtContext[] {
		return this.getTypedRuleContexts(StmtContext) as StmtContext[];
	}
	public stmt(i: number): StmtContext {
		return this.getTypedRuleContext(StmtContext, i) as StmtContext;
	}
	public ctrlStrc_list(): CtrlStrcContext[] {
		return this.getTypedRuleContexts(CtrlStrcContext) as CtrlStrcContext[];
	}
	public ctrlStrc(i: number): CtrlStrcContext {
		return this.getTypedRuleContext(CtrlStrcContext, i) as CtrlStrcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_lines;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterLines) {
	 		listener.enterLines(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitLines) {
	 		listener.exitLines(this);
		}
	}
}


export class DclContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ID(): TerminalNode {
		return this.getToken(eelParser.ID, 0);
	}
	public expr_list(): ExprContext[] {
		return this.getTypedRuleContexts(ExprContext) as ExprContext[];
	}
	public expr(i: number): ExprContext {
		return this.getTypedRuleContext(ExprContext, i) as ExprContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_dcl;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterDcl) {
	 		listener.enterDcl(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitDcl) {
	 		listener.exitDcl(this);
		}
	}
}


export class StmtContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public value(): ValueContext {
		return this.getTypedRuleContext(ValueContext, 0) as ValueContext;
	}
	public expr_list(): ExprContext[] {
		return this.getTypedRuleContexts(ExprContext) as ExprContext[];
	}
	public expr(i: number): ExprContext {
		return this.getTypedRuleContext(ExprContext, i) as ExprContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_stmt;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterStmt) {
	 		listener.enterStmt(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitStmt) {
	 		listener.exitStmt(this);
		}
	}
}


export class ExprContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public operator(): OperatorContext {
		return this.getTypedRuleContext(OperatorContext, 0) as OperatorContext;
	}
	public value(): ValueContext {
		return this.getTypedRuleContext(ValueContext, 0) as ValueContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_expr;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterExpr) {
	 		listener.enterExpr(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitExpr) {
	 		listener.exitExpr(this);
		}
	}
}


export class OperatorContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public binaryOperator(): BinaryOperatorContext {
		return this.getTypedRuleContext(BinaryOperatorContext, 0) as BinaryOperatorContext;
	}
	public boolOperator(): BoolOperatorContext {
		return this.getTypedRuleContext(BoolOperatorContext, 0) as BoolOperatorContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_operator;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterOperator) {
	 		listener.enterOperator(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitOperator) {
	 		listener.exitOperator(this);
		}
	}
}


export class BinaryOperatorContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_binaryOperator;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterBinaryOperator) {
	 		listener.enterBinaryOperator(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitBinaryOperator) {
	 		listener.exitBinaryOperator(this);
		}
	}
}


export class BoolOperatorContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public BOOLEANOP(): TerminalNode {
		return this.getToken(eelParser.BOOLEANOP, 0);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_boolOperator;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterBoolOperator) {
	 		listener.enterBoolOperator(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitBoolOperator) {
	 		listener.exitBoolOperator(this);
		}
	}
}


export class CtrlStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public iterCtrlStrc(): IterCtrlStrcContext {
		return this.getTypedRuleContext(IterCtrlStrcContext, 0) as IterCtrlStrcContext;
	}
	public selCtrlStrc(): SelCtrlStrcContext {
		return this.getTypedRuleContext(SelCtrlStrcContext, 0) as SelCtrlStrcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_ctrlStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterCtrlStrc) {
	 		listener.enterCtrlStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitCtrlStrc) {
	 		listener.exitCtrlStrc(this);
		}
	}
}


export class SelCtrlStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ifStrc(): IfStrcContext {
		return this.getTypedRuleContext(IfStrcContext, 0) as IfStrcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_selCtrlStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterSelCtrlStrc) {
	 		listener.enterSelCtrlStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitSelCtrlStrc) {
	 		listener.exitSelCtrlStrc(this);
		}
	}
}


export class IfStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public booleanExpr(): BooleanExprContext {
		return this.getTypedRuleContext(BooleanExprContext, 0) as BooleanExprContext;
	}
	public lines(): LinesContext {
		return this.getTypedRuleContext(LinesContext, 0) as LinesContext;
	}
	public elseStrc_list(): ElseStrcContext[] {
		return this.getTypedRuleContexts(ElseStrcContext) as ElseStrcContext[];
	}
	public elseStrc(i: number): ElseStrcContext {
		return this.getTypedRuleContext(ElseStrcContext, i) as ElseStrcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_ifStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterIfStrc) {
	 		listener.enterIfStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitIfStrc) {
	 		listener.exitIfStrc(this);
		}
	}
}


export class ElseStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public lines(): LinesContext {
		return this.getTypedRuleContext(LinesContext, 0) as LinesContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_elseStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterElseStrc) {
	 		listener.enterElseStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitElseStrc) {
	 		listener.exitElseStrc(this);
		}
	}
}


export class IterCtrlStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public repeatStrc(): RepeatStrcContext {
		return this.getTypedRuleContext(RepeatStrcContext, 0) as RepeatStrcContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_iterCtrlStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterIterCtrlStrc) {
	 		listener.enterIterCtrlStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitIterCtrlStrc) {
	 		listener.exitIterCtrlStrc(this);
		}
	}
}


export class RepeatStrcContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public booleanExpr(): BooleanExprContext {
		return this.getTypedRuleContext(BooleanExprContext, 0) as BooleanExprContext;
	}
	public lines(): LinesContext {
		return this.getTypedRuleContext(LinesContext, 0) as LinesContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_repeatStrc;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterRepeatStrc) {
	 		listener.enterRepeatStrc(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitRepeatStrc) {
	 		listener.exitRepeatStrc(this);
		}
	}
}


export class BooleanExprContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public stmt_list(): StmtContext[] {
		return this.getTypedRuleContexts(StmtContext) as StmtContext[];
	}
	public stmt(i: number): StmtContext {
		return this.getTypedRuleContext(StmtContext, i) as StmtContext;
	}
	public boolOperator(): BoolOperatorContext {
		return this.getTypedRuleContext(BoolOperatorContext, 0) as BoolOperatorContext;
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_booleanExpr;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterBooleanExpr) {
	 		listener.enterBooleanExpr(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitBooleanExpr) {
	 		listener.exitBooleanExpr(this);
		}
	}
}


export class ValueContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ID(): TerminalNode {
		return this.getToken(eelParser.ID, 0);
	}
	public INUM(): TerminalNode {
		return this.getToken(eelParser.INUM, 0);
	}
	public STRING(): TerminalNode {
		return this.getToken(eelParser.STRING, 0);
	}
	public FuncCall(): TerminalNode {
		return this.getToken(eelParser.FuncCall, 0);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_value;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterValue) {
	 		listener.enterValue(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitValue) {
	 		listener.exitValue(this);
		}
	}
}


export class FuncCallContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public FUNCNAME(): TerminalNode {
		return this.getToken(eelParser.FUNCNAME, 0);
	}
	public ActualParams(): TerminalNode {
		return this.getToken(eelParser.ActualParams, 0);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_funcCall;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterFuncCall) {
	 		listener.enterFuncCall(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitFuncCall) {
	 		listener.exitFuncCall(this);
		}
	}
}


export class ActualParamsContext extends ParserRuleContext {
	constructor(parser?: eelParser, parent?: ParserRuleContext, invokingState?: number) {
		super(parent, invokingState);
    	this.parser = parser;
	}
	public ID_list(): TerminalNode[] {
	    	return this.getTokens(eelParser.ID);
	}
	public ID(i: number): TerminalNode {
		return this.getToken(eelParser.ID, i);
	}
    public get ruleIndex(): number {
    	return eelParser.RULE_actualParams;
	}
	public enterRule(listener: eelListener): void {
	    if(listener.enterActualParams) {
	 		listener.enterActualParams(this);
		}
	}
	public exitRule(listener: eelListener): void {
	    if(listener.exitActualParams) {
	 		listener.exitActualParams(this);
		}
	}
}
