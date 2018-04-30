// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, and  Michael Fisher 
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

import java.util.Iterator;

import junit.framework.Assert;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ail.parser.FOFVisitor;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.parser.GwendolenProgramVisitor;

public class ReasoningRuleQuickTests {
	
	@Test public void rule_head_test() {
		try {
			Predicate head_rule_pred = predicate_parser("this_is_a_rule(R, R)");
			Rule head_rule = new Rule(head_rule_pred);
			
			Predicate to_check = predicate_parser("this_is_a_rule(rule, R1)");
			
			AILAgent a = new AILAgent("agent");
			a.addRule(head_rule);
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			to_check.apply(iun.next());
			
			Assert.assertTrue(to_check.getTerm(1).getFunctor().equals("rule"));
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void cut_test() {
		// GwendolenParser rule_head_parser = gwendolen_parser_for("a(A)");
		// GwendolenParser rule_body_parser = gwendolen_parser_for("b(B)");
		// GwendolenParser belief1_parser = gwendolen_parser_for("b(b1)");
		// GwendolenParser belief2_parser = gwendolen_parser_for("b(b2)");
		// GwendolenParser to_check_parser = gwendolen_parser_for("a(A1)");
		
		try {
			Predicate rule_head = predicate_parser("a(A)");
			Predicate rule_body = predicate_parser("b(B)");
			Rule rule = new Rule(rule_head, new LogExpr(rule_body, LogExpr.LogicalOp.and, new PrologCut()));
				
			Predicate b1 = predicate_parser("b(b1)");
			Predicate b2 = predicate_parser("b(b2)");
			
			AILAgent a = new AILAgent("agent");
			a.addRule(rule);
			a.addBel(new Literal(true, b1), AILAgent.refertoself());
			a.addBel(new Literal(true, b2), AILAgent.refertoself());
			
			Predicate to_check = predicate_parser("a(A1)");
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			iun.next();
			
			Assert.assertFalse(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void cut_test2() {
		// GwendolenParser rule_head_parser = gwendolen_parser_for("a(A)");
		// GwendolenParser rule_body_parser = gwendolen_parser_for("b(B)");
		GwendolenParser rule2_parser = gwendolen_parser_for("a(A) :- c(A);");
		// GwendolenParser belief1_parser = gwendolen_parser_for("b(b1)");
		// GwendolenParser belief2_parser = gwendolen_parser_for("c(b2)");
		// GwendolenParser to_check_parser = gwendolen_parser_for("a(A1)");
		GwendolenProgramVisitor visitor = new GwendolenProgramVisitor();
		
		try {
			Predicate rule_head = predicate_parser("a(A)");
			Predicate rule_body = predicate_parser("b(B)");
			Rule rule1 = new Rule(rule_head, new LogExpr(rule_body, LogExpr.LogicalOp.and, new PrologCut()));
			Rule rule2 = ((Abstract_Rule) visitor.visitBrule(rule2_parser.brule())).toMCAPL();
				
			Predicate b1 = predicate_parser("b(b1)");
			Predicate b2 = predicate_parser("c(b2)");
			
			AILAgent a = new AILAgent("agent");
			a.addRule(rule1);
			a.addRule(rule2);;
			a.addBel(new Literal(true, b1), AILAgent.refertoself());
			a.addBel(new Literal(true, b2), AILAgent.refertoself());
			
			Predicate to_check = predicate_parser("a(A1)");
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			iun.next();
			
			Assert.assertFalse(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	private Predicate predicate_parser(String s) {
		LogicalFmlasLexer fof_lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(fof_lexer);
		LogicalFmlasParser fof_parser = new LogicalFmlasParser(tokens);
		FOFVisitor fof_visitor = new FOFVisitor();

		return ((Abstract_Predicate) fof_visitor.visitPred(fof_parser.pred())).toMCAPL();
	}

	
	private GwendolenParser gwendolen_parser_for(String s) {
		GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new GwendolenParser(tokens);
	}

}
