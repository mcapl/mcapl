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

public class BuiltInPrologRulesQuickTests {
	
	@Test public void nonvar_test1() {
		LogicalFmlasParser rule_parser = fofparser("a(A) :- nonvar(A);");
		LogicalFmlasParser  to_check_parser = fofparser("a(a1)");
		FOFVisitor fofvisitor = new FOFVisitor();
		
		try {
			Rule rule = ((Abstract_Rule) fofvisitor.visitProlog_rule(rule_parser.prolog_rule())).toMCAPL();
				
				
			AILAgent a = new AILAgent("agent");
			a.addRule(rule);
			
			Predicate to_check = ((Abstract_Predicate) fofvisitor.visitPred(to_check_parser.pred())).toMCAPL();
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			
			//Assert.assertTrue(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void nonvar_test2() {
		LogicalFmlasParser rule_parser = fofparser("a(A) :- nonvar(A);");
		LogicalFmlasParser  to_check_parser = fofparser("a(A)");
		FOFVisitor fofvisitor = new FOFVisitor();
		
		try {
			Rule rule = ((Abstract_Rule) fofvisitor.visitProlog_rule(rule_parser.prolog_rule())).toMCAPL();
				
				
			AILAgent a = new AILAgent("agent");
			a.addRule(rule);
			
			Predicate to_check = ((Abstract_Predicate) fofvisitor.visitPred(to_check_parser.pred())).toMCAPL();
			
			Unifier un = new Unifier();
			Iterator<Unifier> iun = a.believes(new Guard(new GBelief(to_check)), un);
			
			//Assert.assertFalse(iun.hasNext());
			
			
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		
	}

	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}


}
