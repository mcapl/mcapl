// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/eass/parser/antlr/EASS.g4 by ANTLR 4.13.1
package eass.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EASSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EASSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EASSParser#mas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas(EASSParser.MasContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#eassagents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEassagents(EASSParser.EassagentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#eassagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEassagent(EASSParser.EassagentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#capability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapability(EASSParser.CapabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#eass_plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEass_plan(EASSParser.Eass_planContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#eass_deed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEass_deed(EASSParser.Eass_deedContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(EASSParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#gwendolenagents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagents(EASSParser.GwendolenagentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#gwendolenagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagent(EASSParser.GwendolenagentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#initial_goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_goal(EASSParser.Initial_goalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(EASSParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#guard_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard_atom(EASSParser.Guard_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(EASSParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#performative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerformative(EASSParser.PerformativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#deed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeed(EASSParser.DeedContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(EASSParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#waitfor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitfor(EASSParser.WaitforContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(EASSParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#fof_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFof_expr(EASSParser.Fof_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#const_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_var(EASSParser.Const_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOper(EASSParser.OperContext ctx);
	/**
	 * Visit a parse tree produced by {@link EASSParser#agentnameterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentnameterm(EASSParser.AgentnametermContext ctx);
}