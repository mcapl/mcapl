// Generated from LogicalFmlas.g4 by ANTLR 4.4
package ajpf.psl.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LogicalFmlasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LogicalFmlasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#multoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultoper(@NotNull LogicalFmlasParser.MultoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#listterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListterm(@NotNull LogicalFmlasParser.ListtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull LogicalFmlasParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#multexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(@NotNull LogicalFmlasParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#subfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubfmla(@NotNull LogicalFmlasParser.SubfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#pred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(@NotNull LogicalFmlasParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(@NotNull LogicalFmlasParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#rulelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulelist(@NotNull LogicalFmlasParser.RulelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#litlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitlist(@NotNull LogicalFmlasParser.LitlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull LogicalFmlasParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull LogicalFmlasParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#numberstring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberstring(@NotNull LogicalFmlasParser.NumberstringContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#notfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotfmla(@NotNull LogicalFmlasParser.NotfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#litlist_poss_empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitlist_poss_empty(@NotNull LogicalFmlasParser.Litlist_poss_emptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull LogicalFmlasParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(@NotNull LogicalFmlasParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#logicalfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalfmla(@NotNull LogicalFmlasParser.LogicalfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#prolog_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog_rule(@NotNull LogicalFmlasParser.Prolog_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#listheads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListheads(@NotNull LogicalFmlasParser.ListheadsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#rulelist_poss_empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulelist_poss_empty(@NotNull LogicalFmlasParser.Rulelist_poss_emptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#stringterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringterm(@NotNull LogicalFmlasParser.StringtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#addoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddoper(@NotNull LogicalFmlasParser.AddoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LogicalFmlasParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#arithexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithexpr(@NotNull LogicalFmlasParser.ArithexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#eqoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqoper(@NotNull LogicalFmlasParser.EqoperContext ctx);
}