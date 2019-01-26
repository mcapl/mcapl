// Generated from Hera.g4 by ANTLR 4.4
package hera.parser;
import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link HeraParser#pcausesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPcausesfmla(@NotNull HeraParser.PcausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#interventionfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterventionfmla(@NotNull HeraParser.InterventionfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#consequencefmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsequencefmla(@NotNull HeraParser.ConsequencefmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#minusterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusterm(@NotNull HeraParser.MinustermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#subterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubterm(@NotNull HeraParser.SubtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#uterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUterm(@NotNull HeraParser.UtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#mayfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayfmla(@NotNull HeraParser.MayfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#stringfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringfmla(@NotNull HeraParser.StringfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#ifmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfmla(@NotNull HeraParser.IfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#existsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsfmla(@NotNull HeraParser.ExistsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#dbterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbterm(@NotNull HeraParser.DbtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#addterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddterm(@NotNull HeraParser.AddtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#preventsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventsfmla(@NotNull HeraParser.PreventsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull HeraParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#goalfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalfmla(@NotNull HeraParser.GoalfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#drterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrterm(@NotNull HeraParser.DrtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#scausesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScausesfmla(@NotNull HeraParser.ScausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#explainsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainsfmla(@NotNull HeraParser.ExplainsfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#notfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotfmla(@NotNull HeraParser.NotfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#intterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntterm(@NotNull HeraParser.InttermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#forallfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallfmla(@NotNull HeraParser.ForallfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsposfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsposfmla(@NotNull HeraParser.AffectsposfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#geqfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeqfmla(@NotNull HeraParser.GeqfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#mustfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustfmla(@NotNull HeraParser.MustfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#causesfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCausesfmla(@NotNull HeraParser.CausesfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#andfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndfmla(@NotNull HeraParser.AndfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#atomfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomfmla(@NotNull HeraParser.AtomfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#kfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKfmla(@NotNull HeraParser.KfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull HeraParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#meansfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeansfmla(@NotNull HeraParser.MeansfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#gtfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtfmla(@NotNull HeraParser.GtfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsnegfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsnegfmla(@NotNull HeraParser.AffectsnegfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#orfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrfmla(@NotNull HeraParser.OrfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#implfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplfmla(@NotNull HeraParser.ImplfmlaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HeraParser#affectsfmla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsfmla(@NotNull HeraParser.AffectsfmlaContext ctx);
}