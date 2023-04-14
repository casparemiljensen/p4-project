// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SampleGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SampleGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SampleGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SampleGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SampleGrammarParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(SampleGrammarParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SampleGrammarParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(SampleGrammarParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SampleGrammarParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(SampleGrammarParser.AtomExpContext ctx);
}