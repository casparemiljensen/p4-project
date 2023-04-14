// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SampleGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, Number=8, WS=9;
	public static final int
		RULE_program = 0, RULE_additionExp = 1, RULE_multiplyExp = 2, RULE_atomExp = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "additionExp", "multiplyExp", "atomExp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "Number", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SampleGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SampleGrammarVisitor ) return ((SampleGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			additionExp();
			setState(9);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExpContext extends ParserRuleContext {
		public List<MultiplyExpContext> multiplyExp() {
			return getRuleContexts(MultiplyExpContext.class);
		}
		public MultiplyExpContext multiplyExp(int i) {
			return getRuleContext(MultiplyExpContext.class,i);
		}
		public AdditionExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).enterAdditionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).exitAdditionExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SampleGrammarVisitor ) return ((SampleGrammarVisitor<? extends T>)visitor).visitAdditionExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionExpContext additionExp() throws RecognitionException {
		AdditionExpContext _localctx = new AdditionExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_additionExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			multiplyExp();
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__2) {
				{
				setState(16);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(12);
					match(T__1);
					setState(13);
					multiplyExp();
					}
					break;
				case T__2:
					{
					setState(14);
					match(T__2);
					setState(15);
					multiplyExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyExpContext extends ParserRuleContext {
		public List<AtomExpContext> atomExp() {
			return getRuleContexts(AtomExpContext.class);
		}
		public AtomExpContext atomExp(int i) {
			return getRuleContext(AtomExpContext.class,i);
		}
		public MultiplyExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).enterMultiplyExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).exitMultiplyExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SampleGrammarVisitor ) return ((SampleGrammarVisitor<? extends T>)visitor).visitMultiplyExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyExpContext multiplyExp() throws RecognitionException {
		MultiplyExpContext _localctx = new MultiplyExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiplyExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			atomExp();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				setState(26);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(22);
					match(T__3);
					setState(23);
					atomExp();
					}
					break;
				case T__4:
					{
					setState(24);
					match(T__4);
					setState(25);
					atomExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomExpContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(SampleGrammarParser.Number, 0); }
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public AtomExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).enterAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SampleGrammarListener ) ((SampleGrammarListener)listener).exitAtomExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SampleGrammarVisitor ) return ((SampleGrammarVisitor<? extends T>)visitor).visitAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExpContext atomExp() throws RecognitionException {
		AtomExpContext _localctx = new AtomExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atomExp);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(Number);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(T__5);
				setState(33);
				additionExp();
				setState(34);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t\'\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u0011\b\u0001\n\u0001\f\u0001\u0014\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u001b\b\u0002\n\u0002"+
		"\f\u0002\u001e\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003%\b\u0003\u0001\u0003\u0000\u0000\u0004\u0000"+
		"\u0002\u0004\u0006\u0000\u0000\'\u0000\b\u0001\u0000\u0000\u0000\u0002"+
		"\u000b\u0001\u0000\u0000\u0000\u0004\u0015\u0001\u0000\u0000\u0000\u0006"+
		"$\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\n\u0005\u0001"+
		"\u0000\u0000\n\u0001\u0001\u0000\u0000\u0000\u000b\u0012\u0003\u0004\u0002"+
		"\u0000\f\r\u0005\u0002\u0000\u0000\r\u0011\u0003\u0004\u0002\u0000\u000e"+
		"\u000f\u0005\u0003\u0000\u0000\u000f\u0011\u0003\u0004\u0002\u0000\u0010"+
		"\f\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0011\u0014"+
		"\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013"+
		"\u0001\u0000\u0000\u0000\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0012"+
		"\u0001\u0000\u0000\u0000\u0015\u001c\u0003\u0006\u0003\u0000\u0016\u0017"+
		"\u0005\u0004\u0000\u0000\u0017\u001b\u0003\u0006\u0003\u0000\u0018\u0019"+
		"\u0005\u0005\u0000\u0000\u0019\u001b\u0003\u0006\u0003\u0000\u001a\u0016"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001e"+
		"\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u0005\u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001f%\u0005\b\u0000\u0000 !\u0005\u0006\u0000"+
		"\u0000!\"\u0003\u0002\u0001\u0000\"#\u0005\u0007\u0000\u0000#%\u0001\u0000"+
		"\u0000\u0000$\u001f\u0001\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000"+
		"%\u0007\u0001\u0000\u0000\u0000\u0005\u0010\u0012\u001a\u001c$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}