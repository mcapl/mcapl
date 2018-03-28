// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ethical_gwen.parser;

import junit.framework.Assert;

import org.junit.Test;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.Rule;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.syntax.StringTermImpl;
import ail.syntax.BeliefBase;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.ListTermImpl;
import ail.syntax.Predicate;

import ethical_gwen.semantics.EthicalGwendolenAgent;

public class ParsingQuickTests {

	
	/*
	 * Test that a variable appearing as a goal gets parsed properly - including converstion to concrete datatypes.
	 */
	@Test public void RulesOverMultipleBBs() {
		EthicalGwendolenLexer rule_lexer = new EthicalGwendolenLexer(new ANTLRStringStream("un_tried_plan :- applicable(P) [applicable_plans], ~ already_tried(P);"));
		rule_lexer.belief_rules = 1;
		CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
		EthicalGwendolenParser rule_parser = new EthicalGwendolenParser(rule_tokens);
		try {
			Abstract_Rule a_rule = rule_parser.brule();
			
			Rule rule = a_rule.toMCAPL();
			
			EthicalGwendolenAgent a = new EthicalGwendolenAgent("agent");
			a.addRule(rule);
			Literal applicable = new Literal("applicable");
			applicable.addTerm(new StringTermImpl("plan"));
			a.addBel(applicable, BeliefBase.TSelf, "applicable_plans");
			
			Assert.assertTrue(a.believesyn(new Guard(new GBelief(new Literal("un_tried_plan"))), new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
 
	/*
	 * Test that a variable appearing as a goal gets parsed properly - including converstion to concrete datatypes.
	 */
	@Test public void listRecursion() {
		EthicalGwendolenLexer rule1_lexer = new EthicalGwendolenLexer(new ANTLRStringStream("better_choice_than(T) :- ethics_in(P, T);"));
		EthicalGwendolenLexer rule2_lexer = new EthicalGwendolenLexer(new ANTLRStringStream("ethics_in(P, [Eth|T]) :- ethics_of(P, Eth) [ethics];"));
		EthicalGwendolenLexer rule3_lexer = new EthicalGwendolenLexer(new ANTLRStringStream("ethics_in(P, [Eth|T]) :- ethics_in(P, T);"));
		EthicalGwendolenLexer rule2a_lexer = new EthicalGwendolenLexer(new ANTLRStringStream("ethics_in(P, [Eth|T]) :- ethics_of(P, Eth) [ethics];"));

		rule1_lexer.belief_rules = 1;
		rule2_lexer.belief_rules = 1;
		rule2a_lexer.belief_rules = 1;
		rule3_lexer.belief_rules = 1;
		CommonTokenStream rule1_tokens = new CommonTokenStream(rule1_lexer);
		EthicalGwendolenParser rule1_parser = new EthicalGwendolenParser(rule1_tokens);
		CommonTokenStream rule2_tokens = new CommonTokenStream(rule2_lexer);
		EthicalGwendolenParser rule2_parser = new EthicalGwendolenParser(rule2_tokens);
		CommonTokenStream rule2a_tokens = new CommonTokenStream(rule2a_lexer);
		EthicalGwendolenParser rule2a_parser = new EthicalGwendolenParser(rule2a_tokens);
		CommonTokenStream rule3_tokens = new CommonTokenStream(rule3_lexer);
		EthicalGwendolenParser rule3_parser = new EthicalGwendolenParser(rule3_tokens);
		try {
			Abstract_Rule a_rule1 = rule1_parser.brule();
			Abstract_Rule a_rule2 = rule2_parser.brule();
			Abstract_Rule a_rule2a = rule2a_parser.brule();
			Abstract_Rule a_rule3 = rule3_parser.brule();
			
			Rule rule1 = a_rule1.toMCAPL();
			Rule rule2 = a_rule2.toMCAPL();
			Rule rule2a = a_rule2a.toMCAPL();
			Rule rule3 = a_rule3.toMCAPL();
			
			EthicalGwendolenAgent a = new EthicalGwendolenAgent("agent");
			a.addRule(rule1);
			a.addRule(rule2);
			a.addRule(rule3);
			
			Literal better_choice = new Literal("better_choice_than");
			ListTermImpl list = new ListTermImpl();
			list.add(new Predicate("e1"));
			list.add(new Predicate("e2"));
			better_choice.addTerm(list);
						
			
			a.believesyn(new Guard(new GBelief(better_choice)), new Unifier());
			Assert.assertTrue(rule2.toString().equals(rule2a.toString()));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
