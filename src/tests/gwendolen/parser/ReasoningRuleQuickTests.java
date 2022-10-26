// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
package gwendolen.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import junit.framework.Assert;

import ail.syntax.ast.Abstract_Rule;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.GBelief;
import ail.syntax.Rule;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.parser.FOFVisitor;
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
public class ReasoningRuleQuickTests {
	 
	/**
	 * 
	 */
	@Test public void ruleUnificationTest() {
		LogicalFmlasLexer rule_lexer = new LogicalFmlasLexer(CharStreams.fromString("unchecked(X, Y) :- square(X, Y), ~ at(X, Y), ~ empty(X, Y), ~ human(X, Y);"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		LogicalFmlasParser rule_parser = new LogicalFmlasParser(rule_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		LogicalFmlasLexer rule_lexer2 = new LogicalFmlasLexer(CharStreams.fromString("area_empty :- ~ (square(Xc, Y), ~ empty(Xc, Y));"));
		CommonTokenStream rule2_tokens = new CommonTokenStream(rule_lexer2);
		LogicalFmlasParser rule2_parser = new LogicalFmlasParser(rule2_tokens);
		
		try {
			Abstract_Rule ast_rule = (Abstract_Rule) visitor.visitProlog_rule(rule_parser.prolog_rule());
			Rule rule = ast_rule.toMCAPL();
			
			Abstract_Rule ast_rule2 = (Abstract_Rule) visitor.visitProlog_rule(rule2_parser.prolog_rule());
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
		LogicalFmlasLexer rule_lexer = new LogicalFmlasLexer(CharStreams.fromString("in_formation(F) :- ~ ( pos(F, P), ~ agent_at(P));"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		LogicalFmlasParser rule_parser = new LogicalFmlasParser(rule_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		LogicalFmlasLexer rule_lexer2 = new LogicalFmlasLexer(CharStreams.fromString("agent_at(Pos) :-   position(Ag, Pos), maintaining(Ag);"));
		CommonTokenStream rule2_tokens = new CommonTokenStream(rule_lexer2);
		LogicalFmlasParser rule2_parser = new LogicalFmlasParser(rule2_tokens);
		
		try {
			Abstract_Rule ast_rule = ((Abstract_Rule) visitor.visitProlog_rule(rule_parser.prolog_rule()));
			Rule rule = ast_rule.toMCAPL();
			
			Abstract_Rule ast_rule2 = ((Abstract_Rule) visitor.visitProlog_rule(rule2_parser.prolog_rule()));
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
	
	@Test public void rulesWithEquationsTest() {
		LogicalFmlasLexer rule_lexer = new LogicalFmlasLexer(CharStreams.fromString("in_formation :- [F < P];"));
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		LogicalFmlasParser rule_parser = new LogicalFmlasParser(rule_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		try {
			Abstract_Rule rule = (Abstract_Rule) visitor.visitProlog_rule(rule_parser.prolog_rule());
			Assert.assertTrue(rule.getBody() instanceof Abstract_Equation);
		} catch (Exception e) {
			Assert.assertFalse(false);
		}

	}

}
