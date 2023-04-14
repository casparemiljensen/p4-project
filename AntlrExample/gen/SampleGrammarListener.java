// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SampleGrammarParser}.
 */
public interface SampleGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SampleGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SampleGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SampleGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SampleGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SampleGrammarParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(SampleGrammarParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SampleGrammarParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(SampleGrammarParser.AdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SampleGrammarParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(SampleGrammarParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SampleGrammarParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(SampleGrammarParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SampleGrammarParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(SampleGrammarParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SampleGrammarParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(SampleGrammarParser.AtomExpContext ctx);
}