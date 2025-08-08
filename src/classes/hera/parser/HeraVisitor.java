// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/hera/parser/antlr/Hera.g4 by ANTLR 4.13.1
package hera.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HeraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HeraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HeraParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(HeraParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#atomfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomfmla(HeraParser.AtomfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#notfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotfmla(HeraParser.NotfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#andfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndfmla(HeraParser.AndfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#orfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrfmla(HeraParser.OrfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#implfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplfmla(HeraParser.ImplfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsfmla(HeraParser.AffectsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsnegfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsnegfmla(HeraParser.AffectsnegfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsposfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsposfmla(HeraParser.AffectsposfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#ifmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfmla(HeraParser.IfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#goalfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalfmla(HeraParser.GoalfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#meansfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeansfmla(HeraParser.MeansfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#causesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCausesfmla(HeraParser.CausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#pcausesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPcausesfmla(HeraParser.PcausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#scausesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScausesfmla(HeraParser.ScausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#explainsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainsfmla(HeraParser.ExplainsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#preventsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventsfmla(HeraParser.PreventsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#interventionfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterventionfmla(HeraParser.InterventionfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#existsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsfmla(HeraParser.ExistsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#forallfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallfmla(HeraParser.ForallfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#gtfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtfmla(HeraParser.GtfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#geqfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeqfmla(HeraParser.GeqfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#mustfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustfmla(HeraParser.MustfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#mayfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayfmla(HeraParser.MayfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#kfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKfmla(HeraParser.KfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#consequencefmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsequencefmla(HeraParser.ConsequencefmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#stringfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringfmla(HeraParser.StringfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(HeraParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#uterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUterm(HeraParser.UtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#drterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrterm(HeraParser.DrtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#dbterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbterm(HeraParser.DbtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#minusterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusterm(HeraParser.MinustermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#subterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubterm(HeraParser.SubtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#addterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddterm(HeraParser.AddtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#intterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntterm(HeraParser.InttermContext ctx);
}