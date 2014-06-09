package gwendolen.parser;

import org.junit.Test;

import junit.framework.Assert;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.syntax.ast.Abstract_Rule;
import ail.syntax.GBelief;
import ail.syntax.Rule;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.semantics.AILAgent;
import ail.syntax.VarTerm;
import ail.syntax.Guard;
import ail.syntax.Unifier;

// import ajpf.util.AJPFLogger;
// import java.util.logging.Level;

import java.util.Iterator;

/**
 * Tests for logical Consequence - should really be elsewhere since it turned out not to be a parser problem.
 * @author louiseadennis
 *
 */
public class ReasoningRuleTests {
	
	/**
	 * 
	 */
	@Test public void ruleUnificationTest() {
//		AJPFLogger.setLevel("ail.syntax.Guard", Level.FINE);
//		AJPFLogger.setLevel("ail.syntax.EvaluationAndRuleBaseIterator", Level.FINE);
		GwendolenLexer rule_lexer = new GwendolenLexer(new ANTLRStringStream("unchecked(Xc, Y) :- square(Xc, Y), ~ at(Xc, Y), ~ empty(Xc, Y), ~ human(Xc, Y);"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		GwendolenParser rule_parser = new GwendolenParser(rule_tokens);
		
		GwendolenLexer rule2_lexer = new GwendolenLexer(new ANTLRStringStream("area_empty :- ~ (square(Xc, Y), ~ empty(Xc, Y));"));
		CommonTokenStream rule2_tokens = new CommonTokenStream(rule2_lexer);
		GwendolenParser rule2_parser = new GwendolenParser(rule2_tokens);
		try {
			Abstract_Rule ast_rule = rule_parser.brule();
			Rule rule = ast_rule.toMCAPL();
			
			Abstract_Rule ast_rule2 = rule2_parser.brule();
			Rule rule2 = ast_rule2.toMCAPL();

			AILAgent ag = new AILAgent();

			Literal square = new Literal("square");
			square.addTerm(new NumberTermImpl("0"));
			square.addTerm(new NumberTermImpl("0"));
			ag.addBel(square, AILAgent.refertoself());

			Literal square2 = new Literal("square");
			square2.addTerm(new NumberTermImpl("0"));
			square2.addTerm(new NumberTermImpl("1"));
			ag.addBel(square2, AILAgent.refertoself());
			
			Literal square3 = new Literal("square");
			square3.addTerm(new NumberTermImpl("1"));
			square3.addTerm(new NumberTermImpl("0"));
			ag.addBel(square3, AILAgent.refertoself());

			Literal square4 = new Literal("square");
			square4.addTerm(new NumberTermImpl("2"));
			square4.addTerm(new NumberTermImpl("0"));
			ag.addBel(square4, AILAgent.refertoself());
			
			Literal empty1 = new Literal("empty");
			empty1.addTerm(new NumberTermImpl("0"));
			empty1.addTerm(new NumberTermImpl("0"));
			ag.addBel(empty1, AILAgent.refertoself());

			Literal empty2 = new Literal("empty");
			empty2.addTerm(new NumberTermImpl("1"));
			empty2.addTerm(new NumberTermImpl("0"));
			ag.addBel(empty2, AILAgent.refertoself());
			
			Literal at = new Literal("at");
			at.addTerm(new NumberTermImpl("2"));
			at.addTerm(new NumberTermImpl("0"));
			ag.addBel(at, AILAgent.refertoself());
			
			ag.addRule(rule);
			ag.addRule(rule2);
			
			Literal unchecked = new Literal("unchecked");
			unchecked.addTerm(new VarTerm("X1"));
			unchecked.addTerm(new VarTerm("Y1"));
			
			Literal atg = new Literal("at");
			atg.addTerm(new VarTerm("X"));
			atg.addTerm(new VarTerm("Y"));
			
			Literal area_empty = new Literal("area_empty");
			
			Guard g = new Guard(new GBelief(atg));
			g.add(new GBelief(area_empty), false);
			g.add(new GBelief(unchecked), true);
			
			Unifier un = new Unifier();
			
			Iterator<Unifier> ui = ag.believes(g, un);
			un = ui.next();
			Assert.assertTrue(un != null);
			unchecked.apply(un);
			Assert.assertTrue(unchecked.isGround());
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Test public void rulesWithNegationTest() {
//		AJPFLogger.setLevel("ail.syntax.Guard", Level.FINE);
//		AJPFLogger.setLevel("ail.syntax.EvaluationAndRuleBaseIterator", Level.FINE);
		GwendolenLexer rule_lexer = new GwendolenLexer(new ANTLRStringStream("in_formation(F) :- ~ ( pos(F, P), ~ agent_at(P));"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		GwendolenParser rule_parser = new GwendolenParser(rule_tokens);
		
		GwendolenLexer rule2_lexer = new GwendolenLexer(new ANTLRStringStream("agent_at(Pos) :-   position(Ag, Pos), maintaining(Ag);"));
		CommonTokenStream rule2_tokens = new CommonTokenStream(rule2_lexer);
		GwendolenParser rule2_parser = new GwendolenParser(rule2_tokens);
		try {
			Abstract_Rule ast_rule = rule_parser.brule();
			Rule rule = ast_rule.toMCAPL();
			
			Abstract_Rule ast_rule2 = rule2_parser.brule();
			Rule rule2 = ast_rule2.toMCAPL();

			AILAgent ag = new AILAgent();

			Literal maintaining = new Literal("maintaining");
			maintaining.addTerm(new Literal("ag"));
			ag.addBel(maintaining, AILAgent.refertoself());

			Literal position = new Literal("position");
			position.addTerm(new Literal("ag"));
			position.addTerm(new Literal("left"));
			ag.addBel(position, AILAgent.refertoself());
			
			Literal pos = new Literal("pos");
			pos.addTerm(new Literal("line"));
			pos.addTerm(new Literal("left"));
			ag.addBel(pos, AILAgent.refertoself());
			
			ag.addRule(rule);
			ag.addRule(rule2);
			
			Literal information = new Literal("in_formation");
			information.addTerm(new Literal("line"));
			
			Guard g = new Guard(new GBelief(information));
			
			Unifier un = new Unifier();
			
			Iterator<Unifier> ui = ag.believes(g, un);
			un = ui.next();
			Assert.assertTrue(un != null);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
