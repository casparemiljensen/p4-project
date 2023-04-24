// Generated from /Users/jacob/IdeaProjects/eel/resources/eel.g4 by ANTLR 4.12.0
package com.eel.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class eelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, FUNCTIONS=20, METHODS=21, BOOLEANOP=22, INUM=23, STRING=24, 
		WS=25, ID=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "FUNCTIONS", "METHODS", "BOOLEANOP", "INUM", "STRING", 
			"WS", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'procedure'", "'('", "')'", "'endProcedure'", "','", "'let'", 
			"'='", "'return'", "'+'", "'-'", "'*'", "'/'", "'then'", "'endIf'", "'if'", 
			"'else'", "'repeat'", "'while'", "'endRepeat'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "FUNCTIONS", "METHODS", 
			"BOOLEANOP", "INUM", "STRING", "WS", "ID"
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


	public eelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "exclude/eel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001a\u00d6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00a1\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00af\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00b3\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00b9\b\u0015"+
		"\u0001\u0016\u0004\u0016\u00bc\b\u0016\u000b\u0016\f\u0016\u00bd\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u00c2\b\u0017\n\u0017\f\u0017\u00c5\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0004\u0018\u00ca\b\u0018\u000b\u0018"+
		"\f\u0018\u00cb\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u00d2\b\u0019\n\u0019\f\u0019\u00d5\t\u0019\u0000\u0000\u001a\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a\u0001\u0000\u0006\u0002\u0000<<>>\u0001\u000009\u0003\u0000"+
		"\n\n\r\r\"\"\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0003\u000009AZaz\u00df"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00015\u0001\u0000\u0000\u0000\u0003?\u0001\u0000\u0000\u0000"+
		"\u0005A\u0001\u0000\u0000\u0000\u0007C\u0001\u0000\u0000\u0000\tP\u0001"+
		"\u0000\u0000\u0000\u000bR\u0001\u0000\u0000\u0000\rV\u0001\u0000\u0000"+
		"\u0000\u000fX\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000\u0000\u0013"+
		"a\u0001\u0000\u0000\u0000\u0015c\u0001\u0000\u0000\u0000\u0017e\u0001"+
		"\u0000\u0000\u0000\u0019g\u0001\u0000\u0000\u0000\u001bl\u0001\u0000\u0000"+
		"\u0000\u001dr\u0001\u0000\u0000\u0000\u001fu\u0001\u0000\u0000\u0000!"+
		"z\u0001\u0000\u0000\u0000#\u0081\u0001\u0000\u0000\u0000%\u0087\u0001"+
		"\u0000\u0000\u0000\'\u00a0\u0001\u0000\u0000\u0000)\u00a2\u0001\u0000"+
		"\u0000\u0000+\u00b8\u0001\u0000\u0000\u0000-\u00bb\u0001\u0000\u0000\u0000"+
		"/\u00bf\u0001\u0000\u0000\u00001\u00c9\u0001\u0000\u0000\u00003\u00cf"+
		"\u0001\u0000\u0000\u000056\u0005p\u0000\u000067\u0005r\u0000\u000078\u0005"+
		"o\u0000\u000089\u0005c\u0000\u00009:\u0005e\u0000\u0000:;\u0005d\u0000"+
		"\u0000;<\u0005u\u0000\u0000<=\u0005r\u0000\u0000=>\u0005e\u0000\u0000"+
		">\u0002\u0001\u0000\u0000\u0000?@\u0005(\u0000\u0000@\u0004\u0001\u0000"+
		"\u0000\u0000AB\u0005)\u0000\u0000B\u0006\u0001\u0000\u0000\u0000CD\u0005"+
		"e\u0000\u0000DE\u0005n\u0000\u0000EF\u0005d\u0000\u0000FG\u0005P\u0000"+
		"\u0000GH\u0005r\u0000\u0000HI\u0005o\u0000\u0000IJ\u0005c\u0000\u0000"+
		"JK\u0005e\u0000\u0000KL\u0005d\u0000\u0000LM\u0005u\u0000\u0000MN\u0005"+
		"r\u0000\u0000NO\u0005e\u0000\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005"+
		",\u0000\u0000Q\n\u0001\u0000\u0000\u0000RS\u0005l\u0000\u0000ST\u0005"+
		"e\u0000\u0000TU\u0005t\u0000\u0000U\f\u0001\u0000\u0000\u0000VW\u0005"+
		"=\u0000\u0000W\u000e\u0001\u0000\u0000\u0000XY\u0005r\u0000\u0000YZ\u0005"+
		"e\u0000\u0000Z[\u0005t\u0000\u0000[\\\u0005u\u0000\u0000\\]\u0005r\u0000"+
		"\u0000]^\u0005n\u0000\u0000^\u0010\u0001\u0000\u0000\u0000_`\u0005+\u0000"+
		"\u0000`\u0012\u0001\u0000\u0000\u0000ab\u0005-\u0000\u0000b\u0014\u0001"+
		"\u0000\u0000\u0000cd\u0005*\u0000\u0000d\u0016\u0001\u0000\u0000\u0000"+
		"ef\u0005/\u0000\u0000f\u0018\u0001\u0000\u0000\u0000gh\u0005t\u0000\u0000"+
		"hi\u0005h\u0000\u0000ij\u0005e\u0000\u0000jk\u0005n\u0000\u0000k\u001a"+
		"\u0001\u0000\u0000\u0000lm\u0005e\u0000\u0000mn\u0005n\u0000\u0000no\u0005"+
		"d\u0000\u0000op\u0005I\u0000\u0000pq\u0005f\u0000\u0000q\u001c\u0001\u0000"+
		"\u0000\u0000rs\u0005i\u0000\u0000st\u0005f\u0000\u0000t\u001e\u0001\u0000"+
		"\u0000\u0000uv\u0005e\u0000\u0000vw\u0005l\u0000\u0000wx\u0005s\u0000"+
		"\u0000xy\u0005e\u0000\u0000y \u0001\u0000\u0000\u0000z{\u0005r\u0000\u0000"+
		"{|\u0005e\u0000\u0000|}\u0005p\u0000\u0000}~\u0005e\u0000\u0000~\u007f"+
		"\u0005a\u0000\u0000\u007f\u0080\u0005t\u0000\u0000\u0080\"\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005w\u0000\u0000\u0082\u0083\u0005h\u0000\u0000"+
		"\u0083\u0084\u0005i\u0000\u0000\u0084\u0085\u0005l\u0000\u0000\u0085\u0086"+
		"\u0005e\u0000\u0000\u0086$\u0001\u0000\u0000\u0000\u0087\u0088\u0005e"+
		"\u0000\u0000\u0088\u0089\u0005n\u0000\u0000\u0089\u008a\u0005d\u0000\u0000"+
		"\u008a\u008b\u0005R\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008d"+
		"\u0005p\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005a"+
		"\u0000\u0000\u008f\u0090\u0005t\u0000\u0000\u0090&\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005S\u0000\u0000\u0092\u0093\u0005U\u0000\u0000\u0093\u00a1"+
		"\u0005M\u0000\u0000\u0094\u0095\u0005A\u0000\u0000\u0095\u0096\u0005V"+
		"\u0000\u0000\u0096\u0097\u0005E\u0000\u0000\u0097\u0098\u0005R\u0000\u0000"+
		"\u0098\u0099\u0005A\u0000\u0000\u0099\u009a\u0005G\u0000\u0000\u009a\u00a1"+
		"\u0005E\u0000\u0000\u009b\u009c\u0005p\u0000\u0000\u009c\u009d\u0005r"+
		"\u0000\u0000\u009d\u009e\u0005i\u0000\u0000\u009e\u009f\u0005n\u0000\u0000"+
		"\u009f\u00a1\u0005t\u0000\u0000\u00a0\u0091\u0001\u0000\u0000\u0000\u00a0"+
		"\u0094\u0001\u0000\u0000\u0000\u00a0\u009b\u0001\u0000\u0000\u0000\u00a1"+
		"(\u0001\u0000\u0000\u0000\u00a2\u00ae\u0005.\u0000\u0000\u00a3\u00a4\u0005"+
		"f\u0000\u0000\u00a4\u00a5\u0005o\u0000\u0000\u00a5\u00a6\u0005r\u0000"+
		"\u0000\u00a6\u00a7\u0005m\u0000\u0000\u00a7\u00a8\u0005a\u0000\u0000\u00a8"+
		"\u00af\u0005t\u0000\u0000\u00a9\u00aa\u0005c\u0000\u0000\u00aa\u00ab\u0005"+
		"o\u0000\u0000\u00ab\u00ac\u0005u\u0000\u0000\u00ac\u00ad\u0005n\u0000"+
		"\u0000\u00ad\u00af\u0005t\u0000\u0000\u00ae\u00a3\u0001\u0000\u0000\u0000"+
		"\u00ae\u00a9\u0001\u0000\u0000\u0000\u00af*\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b2\u0007\u0000\u0000\u0000\u00b1\u00b3\u0005=\u0000\u0000\u00b2\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005=\u0000\u0000\u00b5\u00b9\u0005"+
		"=\u0000\u0000\u00b6\u00b7\u0005!\u0000\u0000\u00b7\u00b9\u0005=\u0000"+
		"\u0000\u00b8\u00b0\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9,\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bc\u0007\u0001\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0001\u0000\u0000\u0000\u00be.\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c3\u0005\"\u0000\u0000\u00c0\u00c2\b\u0002\u0000\u0000\u00c1\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0005\"\u0000\u0000\u00c70\u0001\u0000\u0000\u0000\u00c8\u00ca\u0007"+
		"\u0003\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0006"+
		"\u0018\u0000\u0000\u00ce2\u0001\u0000\u0000\u0000\u00cf\u00d3\u0007\u0004"+
		"\u0000\u0000\u00d0\u00d2\u0007\u0005\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d44\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\t\u0000\u00a0\u00ae\u00b2\u00b8"+
		"\u00bd\u00c3\u00cb\u00d3\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}