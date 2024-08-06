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
import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

public class ReasoningRuleQuickTests {
	
	@Test public void rule_head_test() {
		LogicalFmlasParser rule_head_parser = fofparser("this_is_a_rule(R, R)");
		LogicalFmlasParser to_check_parser = fofparser("this_is_a_rule(rule, R1)");
		FOFVisitor fofvisitor = new FOFVisitor();
		
		try {
			Predicate head_rule_pred = ((Abstract_Predicate) fofvisitor.visitPred(rule_head_parser.pred())).toMCAPL();
			Rule head_rule = new Rule(head_rule_pred);
			
			Predicate to_check = ((Abstract_Predicate) fofvisitor.visitPred(to_check_parser.pred())).toMCAPL();
			
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
		LogicalFmlasParser rule_head_parser = fofparser("a(A)");
		LogicalFmlasParser rule_body_parser = fofparser("b(B)");
		LogicalFmlasParser belief1_parser = fofparser("b(b1)");
		LogicalFmlasParser belief2_parser = fofparser("b(b2)");
		LogicalFmlasParser to_check_parser = fofparser("a(A1)");
		FOFVisitor fofvisitor = new FOFVisitor();
		
		try {
			Predicate rule_head = ((Abstract_Predicate) fofvisitor.visitPred(rule_head_parser.pred())).toMCAPL(); 
			Predicate rule_body = ((Abstract_Predicate) fofvisitor.visitPred(rule_body_parser.pred())).toMCAPL();
			Rule rule = new Rule(rule_head, new LogExpr(rule_body, LogExpr.LogicalOp.and, new PrologCut()));
				
			Predicate b1 = ((Abstract_Predicate) fofvisitor.visitPred(belief1_parser.pred())).toMCAPL();
			Predicate b2 = ((Abstract_Predicate) fofvisitor.visitPred(belief2_parser.pred())).toMCAPL();
			
			AILAgent a = new AILAgent("agent");
			a.addRule(rule);
			a.addBel(new Literal(true, b1), AILAgent.refertoself());
			a.addBel(new Literal(true, b2), AILAgent.refertoself());
			
			Predicate to_check = ((Abstract_Predicate) fofvisitor.visitPred(to_check_parser.pred())).toMCAPL();
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			iun.next();
			
			Assert.assertFalse(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void cut_test2() {
		LogicalFmlasParser  rule_head_parser = fofparser("a(A)");
		LogicalFmlasParser  rule_body_parser = fofparser("b(B)");
		LogicalFmlasParser rule2_parser = fofparser("a(A) :- c(A);");
		LogicalFmlasParser  belief1_parser = fofparser("b(b1)");
		LogicalFmlasParser  belief2_parser = fofparser("c(b2)");
		LogicalFmlasParser  to_check_parser = fofparser("a(A1)");
		FOFVisitor fofvisitor = new FOFVisitor();
		
		try {
			Predicate rule_head = ((Abstract_Predicate) fofvisitor.visitPred(rule_head_parser.pred())).toMCAPL();
			Predicate rule_body = ((Abstract_Predicate) fofvisitor.visitPred(rule_body_parser.pred())).toMCAPL();
			Rule rule1 = new Rule(rule_head, new LogExpr(rule_body, LogExpr.LogicalOp.and, new PrologCut()));
			Rule rule2 = ((Abstract_Rule) fofvisitor.visitProlog_rule(rule2_parser.prolog_rule())).toMCAPL();
				
			Predicate b1 = ((Abstract_Predicate) fofvisitor.visitPred(belief1_parser.pred())).toMCAPL();
			Predicate b2 = ((Abstract_Predicate) fofvisitor.visitPred(belief2_parser.pred())).toMCAPL();
			
			AILAgent a = new AILAgent("agent");
			a.addRule(rule1);
			a.addRule(rule2);;
			a.addBel(new Literal(true, b1), AILAgent.refertoself());
			a.addBel(new Literal(true, b2), AILAgent.refertoself());
			
			Predicate to_check = ((Abstract_Predicate) fofvisitor.visitPred(to_check_parser.pred())).toMCAPL();
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			iun.next();
			
			Assert.assertFalse(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	

	private GwendolenParser gwendolen_parser_for(String s) {
		GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		return parser;
	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}


}
