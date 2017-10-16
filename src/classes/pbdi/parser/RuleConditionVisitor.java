// Generated from RuleCondition.g4 by ANTLR 4.4
package pbdi.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleConditionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RuleConditionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RuleConditionParser#not_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_expr(@NotNull RuleConditionParser.Not_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleConditionParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(@NotNull RuleConditionParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleConditionParser#rule_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_condition(@NotNull RuleConditionParser.Rule_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleConditionParser#belief_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_expression(@NotNull RuleConditionParser.Belief_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleConditionParser#dot_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_expr(@NotNull RuleConditionParser.Dot_exprContext ctx);
}