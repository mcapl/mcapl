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

import java.util.Iterator;

public class ReasoningRuleTests {
	
	/**
	 * 
	 */
	@Test public void ruleUnificationTest() {
		GwendolenLexer rule_lexer = new GwendolenLexer(new ANTLRStringStream("unchecked(Xc, Y) :- (square(Xc, Y), (~ (at(Xc, Y)), ( ~ (empty(Xc, Y)), ~ (human(Xc, Y)))));"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		GwendolenParser rule_parser = new GwendolenParser(rule_tokens);
		try {
			Abstract_Rule ast_rule = rule_parser.brule();
			Rule rule = ast_rule.toMCAPL();
			
			AILAgent ag = new AILAgent();
			Literal square = new Literal("square");
			square.addTerm(new NumberTermImpl("1"));
			square.addTerm(new NumberTermImpl("2"));
			ag.addBel(square, AILAgent.refertoself());
			ag.addRule(rule);
			
			Literal unchecked = new Literal("unchecked");
			unchecked.addTerm(new VarTerm("A"));
			unchecked.addTerm(new VarTerm("B"));
			
			Unifier un = new Unifier();
			
			Iterator<Unifier> ui = ag.believes(new Guard(new GBelief(unchecked)), un);
			un = ui.next();
			unchecked.apply(un);
			Assert.assertTrue(unchecked.isGround());
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
