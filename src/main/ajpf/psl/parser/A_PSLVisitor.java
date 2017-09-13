// Generated from A_PSL.g4 by ANTLR 4.7
package ajpf.psl.parser;
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
	 * Visit a parse tree produced by {@link A_PSLParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(A_PSLParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(A_PSLParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#untilproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilproperty(A_PSLParser.UntilpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#releaseproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseproperty(A_PSLParser.ReleasepropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#impproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpproperty(A_PSLParser.ImppropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#andproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndproperty(A_PSLParser.AndpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#orproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrproperty(A_PSLParser.OrpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#alwaysproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlwaysproperty(A_PSLParser.AlwayspropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#finallyproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyproperty(A_PSLParser.FinallypropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#notproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotproperty(A_PSLParser.NotpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(A_PSLParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition(A_PSLParser.PropositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#beliefproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeliefproperty(A_PSLParser.BeliefpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#goalproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalproperty(A_PSLParser.GoalpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#falseprop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseprop(A_PSLParser.FalsepropContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#intentionproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntentionproperty(A_PSLParser.IntentionpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#lastactionproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastactionproperty(A_PSLParser.LastactionpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#perceptproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerceptproperty(A_PSLParser.PerceptpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#intendtodoproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntendtodoproperty(A_PSLParser.IntendtodopropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#trueprop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueprop(A_PSLParser.TruepropContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#agentname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentname(A_PSLParser.AgentnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link A_PSLParser#fof_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFof_expr(A_PSLParser.Fof_exprContext ctx);
}