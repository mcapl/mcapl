// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/classes/gwendolen/parser/antlr/Gwendolen.g4 by ANTLR 4.7
package gwendolen.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GwendolenParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GwendolenVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#mas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas(GwendolenParser.MasContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#gwendolenagents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagents(GwendolenParser.GwendolenagentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#gwendolenagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagent(GwendolenParser.GwendolenagentContext ctx);
}