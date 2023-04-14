// Generated from eel.g4 by ANTLR 4.12.0
// noinspection ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols
import {
	ATN,
	ATNDeserializer,
	CharStream,
	DecisionState, DFA,
	Lexer,
	LexerATNSimulator,
	RuleContext,
	PredictionContextCache,
	Token
} from "antlr4";
export default class eelLexer extends Lexer {
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
	public static readonly EOF = Token.EOF;

	public static readonly channelNames: string[] = [ "DEFAULT_TOKEN_CHANNEL", "HIDDEN" ];
	public static readonly literalNames: string[] = [ null, "'procedure'", 
                                                   "'('", "')'", "'endProcedure'", 
                                                   "','", "'let'", "'+'", 
                                                   "'-'", "'='", "'if'", 
                                                   "'then'", "'endIf'", 
                                                   "'else then'", "'repeat while'", 
                                                   "'endRepeat'" ];
	public static readonly symbolicNames: string[] = [ null, null, null, null, 
                                                    null, null, null, null, 
                                                    null, null, null, null, 
                                                    null, null, null, null, 
                                                    "ID", "FUNCNAME", "BOOLEANOP", 
                                                    "INUM", "STRING", "WS" ];
	public static readonly modeNames: string[] = [ "DEFAULT_MODE", ];

	public static readonly ruleNames: string[] = [
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "ID", "FUNCNAME", 
		"BOOLEANOP", "INUM", "STRING", "WS",
	];


	constructor(input: CharStream) {
		super(input);
		this._interp = new LexerATNSimulator(this, eelLexer._ATN, eelLexer.DecisionsToDFA, new PredictionContextCache());
	}

	public get grammarFileName(): string { return "eel.g4"; }

	public get literalNames(): (string | null)[] { return eelLexer.literalNames; }
	public get symbolicNames(): (string | null)[] { return eelLexer.symbolicNames; }
	public get ruleNames(): string[] { return eelLexer.ruleNames; }

	public get serializedATN(): number[] { return eelLexer._serializedATN; }

	public get channelNames(): string[] { return eelLexer.channelNames; }

	public get modeNames(): string[] { return eelLexer.modeNames; }

	public static readonly _serializedATN: number[] = [4,0,21,170,6,-1,2,0,
	7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,7,7,7,2,8,7,8,2,9,
	7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,14,2,15,7,15,2,16,7,
	16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,1,0,1,0,1,0,1,0,1,0,1,0,1,0,
	1,0,1,0,1,0,1,1,1,1,1,2,1,2,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,
	1,3,1,3,1,4,1,4,1,5,1,5,1,5,1,5,1,6,1,6,1,7,1,7,1,8,1,8,1,9,1,9,1,9,1,10,
	1,10,1,10,1,10,1,10,1,11,1,11,1,11,1,11,1,11,1,11,1,12,1,12,1,12,1,12,1,
	12,1,12,1,12,1,12,1,12,1,12,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
	1,13,1,13,1,13,1,13,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,
	15,4,15,131,8,15,11,15,12,15,132,1,16,4,16,136,8,16,11,16,12,16,137,1,17,
	1,17,3,17,142,8,17,1,17,1,17,1,17,1,17,3,17,148,8,17,1,18,4,18,151,8,18,
	11,18,12,18,152,1,19,1,19,5,19,157,8,19,10,19,12,19,160,9,19,1,19,1,19,
	1,20,4,20,165,8,20,11,20,12,20,166,1,20,1,20,0,0,21,1,1,3,2,5,3,7,4,9,5,
	11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,13,27,14,29,15,31,16,33,17,35,
	18,37,19,39,20,41,21,1,0,5,2,0,65,90,97,122,2,0,60,60,62,62,1,0,48,57,3,
	0,10,10,13,13,34,34,3,0,9,10,13,13,32,32,177,0,1,1,0,0,0,0,3,1,0,0,0,0,
	5,1,0,0,0,0,7,1,0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,
	0,0,17,1,0,0,0,0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,
	1,0,0,0,0,29,1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,0,0,35,1,0,0,0,0,37,1,0,0,
	0,0,39,1,0,0,0,0,41,1,0,0,0,1,43,1,0,0,0,3,53,1,0,0,0,5,55,1,0,0,0,7,57,
	1,0,0,0,9,70,1,0,0,0,11,72,1,0,0,0,13,76,1,0,0,0,15,78,1,0,0,0,17,80,1,
	0,0,0,19,82,1,0,0,0,21,85,1,0,0,0,23,90,1,0,0,0,25,96,1,0,0,0,27,106,1,
	0,0,0,29,119,1,0,0,0,31,130,1,0,0,0,33,135,1,0,0,0,35,147,1,0,0,0,37,150,
	1,0,0,0,39,154,1,0,0,0,41,164,1,0,0,0,43,44,5,112,0,0,44,45,5,114,0,0,45,
	46,5,111,0,0,46,47,5,99,0,0,47,48,5,101,0,0,48,49,5,100,0,0,49,50,5,117,
	0,0,50,51,5,114,0,0,51,52,5,101,0,0,52,2,1,0,0,0,53,54,5,40,0,0,54,4,1,
	0,0,0,55,56,5,41,0,0,56,6,1,0,0,0,57,58,5,101,0,0,58,59,5,110,0,0,59,60,
	5,100,0,0,60,61,5,80,0,0,61,62,5,114,0,0,62,63,5,111,0,0,63,64,5,99,0,0,
	64,65,5,101,0,0,65,66,5,100,0,0,66,67,5,117,0,0,67,68,5,114,0,0,68,69,5,
	101,0,0,69,8,1,0,0,0,70,71,5,44,0,0,71,10,1,0,0,0,72,73,5,108,0,0,73,74,
	5,101,0,0,74,75,5,116,0,0,75,12,1,0,0,0,76,77,5,43,0,0,77,14,1,0,0,0,78,
	79,5,45,0,0,79,16,1,0,0,0,80,81,5,61,0,0,81,18,1,0,0,0,82,83,5,105,0,0,
	83,84,5,102,0,0,84,20,1,0,0,0,85,86,5,116,0,0,86,87,5,104,0,0,87,88,5,101,
	0,0,88,89,5,110,0,0,89,22,1,0,0,0,90,91,5,101,0,0,91,92,5,110,0,0,92,93,
	5,100,0,0,93,94,5,73,0,0,94,95,5,102,0,0,95,24,1,0,0,0,96,97,5,101,0,0,
	97,98,5,108,0,0,98,99,5,115,0,0,99,100,5,101,0,0,100,101,5,32,0,0,101,102,
	5,116,0,0,102,103,5,104,0,0,103,104,5,101,0,0,104,105,5,110,0,0,105,26,
	1,0,0,0,106,107,5,114,0,0,107,108,5,101,0,0,108,109,5,112,0,0,109,110,5,
	101,0,0,110,111,5,97,0,0,111,112,5,116,0,0,112,113,5,32,0,0,113,114,5,119,
	0,0,114,115,5,104,0,0,115,116,5,105,0,0,116,117,5,108,0,0,117,118,5,101,
	0,0,118,28,1,0,0,0,119,120,5,101,0,0,120,121,5,110,0,0,121,122,5,100,0,
	0,122,123,5,82,0,0,123,124,5,101,0,0,124,125,5,112,0,0,125,126,5,101,0,
	0,126,127,5,97,0,0,127,128,5,116,0,0,128,30,1,0,0,0,129,131,7,0,0,0,130,
	129,1,0,0,0,131,132,1,0,0,0,132,130,1,0,0,0,132,133,1,0,0,0,133,32,1,0,
	0,0,134,136,7,0,0,0,135,134,1,0,0,0,136,137,1,0,0,0,137,135,1,0,0,0,137,
	138,1,0,0,0,138,34,1,0,0,0,139,141,7,1,0,0,140,142,5,61,0,0,141,140,1,0,
	0,0,141,142,1,0,0,0,142,148,1,0,0,0,143,144,5,61,0,0,144,148,5,61,0,0,145,
	146,5,33,0,0,146,148,5,61,0,0,147,139,1,0,0,0,147,143,1,0,0,0,147,145,1,
	0,0,0,148,36,1,0,0,0,149,151,7,2,0,0,150,149,1,0,0,0,151,152,1,0,0,0,152,
	150,1,0,0,0,152,153,1,0,0,0,153,38,1,0,0,0,154,158,5,34,0,0,155,157,8,3,
	0,0,156,155,1,0,0,0,157,160,1,0,0,0,158,156,1,0,0,0,158,159,1,0,0,0,159,
	161,1,0,0,0,160,158,1,0,0,0,161,162,5,34,0,0,162,40,1,0,0,0,163,165,7,4,
	0,0,164,163,1,0,0,0,165,166,1,0,0,0,166,164,1,0,0,0,166,167,1,0,0,0,167,
	168,1,0,0,0,168,169,6,20,0,0,169,42,1,0,0,0,8,0,132,137,141,147,152,158,
	166,1,6,0,0];

	private static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!eelLexer.__ATN) {
			eelLexer.__ATN = new ATNDeserializer().deserialize(eelLexer._serializedATN);
		}

		return eelLexer.__ATN;
	}


	static DecisionsToDFA = eelLexer._ATN.decisionToState.map( (ds: DecisionState, index: number) => new DFA(ds, index) );
}