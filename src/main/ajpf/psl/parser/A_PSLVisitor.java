// Generated from A_PSL.g4 by ANTLR 4.4
package ajpf.psl.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link A_PSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface A_PSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#finallyproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyproperty(@NotNull A_PSLParser.FinallypropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#notproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotproperty(@NotNull A_PSLParser.NotpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#orproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrproperty(@NotNull A_PSLParser.OrpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#trueprop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueprop(@NotNull A_PSLParser.TruepropContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#alwaysproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlwaysproperty(@NotNull A_PSLParser.AlwayspropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#goalproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalproperty(@NotNull A_PSLParser.GoalpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#lastactionproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastactionproperty(@NotNull A_PSLParser.LastactionpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#intentionproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntentionproperty(@NotNull A_PSLParser.IntentionpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#intendtodoproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntendtodoproperty(@NotNull A_PSLParser.IntendtodopropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(@NotNull A_PSLParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#perceptproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerceptproperty(@NotNull A_PSLParser.PerceptpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#impproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpproperty(@NotNull A_PSLParser.ImppropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#subformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubformula(@NotNull A_PSLParser.SubformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#andproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndproperty(@NotNull A_PSLParser.AndpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#beliefproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeliefproperty(@NotNull A_PSLParser.BeliefpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(@NotNull A_PSLParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#untilproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilproperty(@NotNull A_PSLParser.UntilpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition(@NotNull A_PSLParser.PropositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#agentname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentname(@NotNull A_PSLParser.AgentnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull A_PSLParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull A_PSLParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#releaseproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseproperty(@NotNull A_PSLParser.ReleasepropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull A_PSLParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#falseprop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseprop(@NotNull A_PSLParser.FalsepropContext ctx);
}