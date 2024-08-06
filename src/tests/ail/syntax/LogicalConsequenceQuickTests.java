// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax;

import java.util.ArrayList;
import java.util.Iterator;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;
import org.junit.Assert;

import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.util.AJPFLogger;

/**
 * Regression tests involving Logical Consequence.
 * @author louiseadennis
 *
 */
public class LogicalConsequenceQuickTests {
	
	@Test public void sentMessages() {
		AILAgent ag = new AILAgent();
		Message msg = new Message(1, "s", "r", new Literal("message"));
		ag.newSentMessage(msg);
		 
				
		GMessage gm = new GMessage(DefaultAILStructure.AILSent, 1, new StringTermImpl("s"), new StringTermImpl("r"), new Literal("message"));
		Assert.assertTrue(ag.believesyn(new Guard(gm), new Unifier()));
	}
	
	@Test public void prologMembershipTest() {
		try {
			AILAgent agent = new AILAgent("ag");

			Predicate nil_rule_hd = ruleHead("member_test(X, [])");
			LogExpr nil_rule_body = ruleBody("false");
			agent.addRule(new Rule(nil_rule_hd, nil_rule_body));
			
			Predicate cons_hd_rule = ruleHead("member_test(H, [H | T])");
			// LogExpr cons_rule_body = ruleBody("true");
			agent.addRule(new Rule(cons_hd_rule, Predicate.PTrue));
			
			Predicate cons_tl_rule_hd = ruleHead("member_test(H, [X | T])");
			LogExpr cons_tl_rule_body = ruleBody("member_test(H, T)");
			agent.addRule(new Rule(cons_tl_rule_hd, cons_tl_rule_body));
			
			ListTermImpl list = parser_for("[a, b, c]").listterm().toMCAPL();
			
			Literal member = new Literal("member_test");
			member.addTerm(new VarTerm("X"));
			member.addTerm(list);
			GBelief gb = new GBelief(member);
			Guard g = new Guard(gb);
			Unifier un = new Unifier();
			Iterator<Unifier> iun = agent.believes(g, un);
			
			Assert.assertTrue(iun.hasNext());
			Assert.assertTrue(iun.next().unifies(new VarTerm("X"), new Predicate("a")));
			Assert.assertTrue(iun.hasNext());
			Assert.assertTrue(iun.next().unifies(new VarTerm("X"), new Predicate("b")));
			Assert.assertTrue(iun.hasNext());
			Assert.assertTrue(iun.next().unifies(new VarTerm("X"), new Predicate("c")));
			Assert.assertFalse(iun.hasNext());
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
	}
	
	@Test public void capabilityPreconditionTest() {
		Predicate on1 = new Predicate("on");
		on1.addTerm(new Predicate("b2"));
		on1.addTerm(new Predicate("b3"));
		
		Predicate ontable = new Predicate("on");
		ontable.addTerm(new Predicate("b3"));
		ontable.addTerm(new Predicate("table"));
		
		Predicate cleartable = new Predicate("clear");
		cleartable.addTerm(new Predicate("table"));
		
		GOALParser nbliterals = parser_for("on(X, _), not( on(_, X) ).");
		try {
			ArrayList<Abstract_LogicalFormula> nbls = nbliterals.no_bracket_literals();
			Abstract_Predicate hd = new Abstract_Predicate("clear");
			hd.addTerm(new Abstract_VarTerm("X"));
			Abstract_Rule arule = new Abstract_Rule(hd, nbls);
			Rule rule = arule.toMCAPL();
			
			AILAgent agent = new AILAgent("ag");
			
			agent.addRule(rule);
			agent.addBel(new Literal(on1), AILAgent.refertoself());
			agent.addBel(new Literal(ontable), AILAgent.refertoself());
			agent.addBel(new Literal(cleartable), AILAgent.refertoself());
			
			Predicate testpred = new Predicate("clear");
			testpred.addTerm(new Predicate("b3"));
			Assert.assertFalse(agent.believesyn(new Guard(new GBelief(testpred)), new Unifier()));
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	public Predicate ruleHead(String s) throws Exception {
		GOALParser parser = parser_for(s);
		return (parser.declarationOrCallWithTerms()).toMCAPL();
	}
	
	public LogExpr ruleBody(String s) throws Exception {
		GOALParser parser = parser_for(s);
		ArrayList<Abstract_LogicalFormula> rule_a = (parser.no_bracket_literals());
		boolean first = true;
		LogExpr rule_body = new LogExpr();
		for (Abstract_LogicalFormula alf: rule_a) {
			if (first) {
				rule_body = new LogExpr(LogExpr.LogicalOp.none, alf.toMCAPL());
				first = false;
			} else {
				rule_body = new LogExpr(rule_body, LogExpr.LogicalOp.and, alf.toMCAPL());
			}
			
		}
		return rule_body;
		
	}
	
	public GOALParser parser_for(String s) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GOALParser parser = new GOALParser(tokens);
		return parser;
	}
	
}
