// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/main/ajpf/psl/parser/antlr/LogicalFmlas.g4 by ANTLR 4.13.1
package ajpf.psl.parser;
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
	 * Visit a parse tree produced by {@link LogicalFmlasParser#rulelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulelist(LogicalFmlasParser.RulelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#rulelist_poss_empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulelist_poss_empty(LogicalFmlasParser.Rulelist_poss_emptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#prolog_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog_rule(LogicalFmlasParser.Prolog_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#logicalfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalfmla(LogicalFmlasParser.LogicalfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#notfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotfmla(LogicalFmlasParser.NotfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#subfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubfmla(LogicalFmlasParser.SubfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#litlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitlist(LogicalFmlasParser.LitlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#litlist_poss_empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitlist_poss_empty(LogicalFmlasParser.Litlist_poss_emptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LogicalFmlasParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#pred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(LogicalFmlasParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LogicalFmlasParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(LogicalFmlasParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LogicalFmlasParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LogicalFmlasParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#stringterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringterm(LogicalFmlasParser.StringtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#listterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListterm(LogicalFmlasParser.ListtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#listheads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListheads(LogicalFmlasParser.ListheadsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LogicalFmlasParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#numberstring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberstring(LogicalFmlasParser.NumberstringContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(LogicalFmlasParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#eqoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqoper(LogicalFmlasParser.EqoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#arithexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithexpr(LogicalFmlasParser.ArithexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#multexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(LogicalFmlasParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#addoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddoper(LogicalFmlasParser.AddoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogicalFmlasParser#multoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultoper(LogicalFmlasParser.MultoperContext ctx);
}