// Generated from Juno.g4 by ANTLR 4.4
package juno.syntax.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JunoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JunoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JunoParser#action_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_rule(@NotNull JunoParser.Action_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JunoParser#belief_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_modifier(@NotNull JunoParser.Belief_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JunoParser#junoAgent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJunoAgent(@NotNull JunoParser.JunoAgentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JunoParser#json_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson_file(@NotNull JunoParser.Json_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JunoParser#fof_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFof_expr(@NotNull JunoParser.Fof_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JunoParser#belief_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_rule(@NotNull JunoParser.Belief_ruleContext ctx);
}