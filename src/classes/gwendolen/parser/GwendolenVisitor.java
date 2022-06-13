// Generated from Gwendolen.g4 by ANTLR 4.7
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
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(GwendolenParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#guard_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard_atom(GwendolenParser.Guard_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(GwendolenParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(GwendolenParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#performative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerformative(GwendolenParser.PerformativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#deed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeed(GwendolenParser.DeedContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#waitfor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitfor(GwendolenParser.WaitforContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(GwendolenParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#environment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment(GwendolenParser.EnvironmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#classpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasspath(GwendolenParser.ClasspathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(GwendolenParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#agentnameterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentnameterm(GwendolenParser.AgentnametermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#fof_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFof_expr(GwendolenParser.Fof_exprContext ctx);
}