// Generated from ActionOnly.g4 by ANTLR 4.7
package actiononly.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ActionOnlyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ActionOnlyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ActionOnlyParser#mas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas(ActionOnlyParser.MasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActionOnlyParser#aoagents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAoagents(ActionOnlyParser.AoagentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActionOnlyParser#aoagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAoagent(ActionOnlyParser.AoagentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActionOnlyParser#capability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapability(ActionOnlyParser.CapabilityContext ctx);
}