// Generated from Gwendolen.g4 by ANTLR 4.4
package gwendolen.parser;
import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link GwendolenParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(@NotNull GwendolenParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#brule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrule(@NotNull GwendolenParser.BruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#performative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerformative(@NotNull GwendolenParser.PerformativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#classpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasspath(@NotNull GwendolenParser.ClasspathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#gwendolenagents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagents(@NotNull GwendolenParser.GwendolenagentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#deed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeed(@NotNull GwendolenParser.DeedContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#agentnameterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentnameterm(@NotNull GwendolenParser.AgentnametermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#environment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment(@NotNull GwendolenParser.EnvironmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#guard_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard_atom(@NotNull GwendolenParser.Guard_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#pn_guard_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPn_guard_atom(@NotNull GwendolenParser.Pn_guard_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#fof_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFof_expr(@NotNull GwendolenParser.Fof_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#gwendolenagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGwendolenagent(@NotNull GwendolenParser.GwendolenagentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(@NotNull GwendolenParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(@NotNull GwendolenParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(@NotNull GwendolenParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#waitfor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitfor(@NotNull GwendolenParser.WaitforContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(@NotNull GwendolenParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link GwendolenParser#mas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas(@NotNull GwendolenParser.MasContext ctx);
}