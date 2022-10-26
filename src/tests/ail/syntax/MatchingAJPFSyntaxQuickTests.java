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

import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Predicate;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTermImpl;
import ajpf.psl.ast.Abstract_Formula;
import ajpf.psl.parser.AJPF_PSLVisitor;
import ajpf.psl.parser.A_PSLLexer;
import ajpf.psl.parser.A_PSLParser;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;

/**
 * Various tests for the link between AJPF's syntax of terms and AIL's.
 * @author lad
 *
 */
public class MatchingAJPFSyntaxQuickTests { 

	@Test public void beliefPropertyTest() {
		
		MCAPLPredicate l1 = new MCAPLPredicate("l");
		Literal l2 = new Literal("l");
		
		
		AILAgent a = new AILAgent("agent");
		a.addBel(l2, AILAgent.refertoself());
		
		Assert.assertTrue(a.MCAPLbelieves(l1));
	}

	@Test public void beliefSubTermPropertyTest() {
		
		MCAPLPredicate l1 = new MCAPLPredicate("l");
		MCAPLTermImpl p = new MCAPLTermImpl("p");
		l1.addTerm(p);
		Literal l2 = new Literal("l");
		Predicate p1 = new Predicate("p");
		l2.addTerm(p1);
		
		
		AILAgent a = new AILAgent("agent");
		a.addBel(l2, AILAgent.refertoself());
		
		Assert.assertTrue(a.MCAPLbelieves(l1));
	}
	
	/**
	 * Testing parsing of beliefs with numbers.
	 * @throws Exception
	 */
	@Test public void BeliefsWithNumbersTest() throws Exception {
		String mcaplbelief = "at(0, 1))";
		String inbeliefbase = "at(0, 1)";
		
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(mcaplbelief));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		LogicalFmlasParser pslparser = new LogicalFmlasParser(psltokens);
		ajpf.psl.parser.FOFVisitor psl_visitor = new ajpf.psl.parser.FOFVisitor();
		ail.parser.FOFVisitor ail_visitor = new ail.parser.FOFVisitor();
		try {
			Abstract_Formula p = (Abstract_Formula) psl_visitor.visitFunction(pslparser.function());
			AILAgent a = new AILAgent("ag1");
		
			LogicalFmlasLexer g_lexer = new LogicalFmlasLexer(CharStreams.fromString(inbeliefbase));
			CommonTokenStream g_tokens = new CommonTokenStream(g_lexer);
			LogicalFmlasParser g_parser = new LogicalFmlasParser(g_tokens);
		
			Abstract_Predicate b = (Abstract_Predicate) ail_visitor.visitPred((g_parser.pred()));

			MCAPLPredicate mp = (MCAPLPredicate) p.toMCAPL();
			Predicate gb = b.toMCAPL();
			a.addBel(new Literal(true, new PredicatewAnnotation(gb)), AILAgent.refertoself());
			
			Assert.assertTrue(a.MCAPLbelieves(mp));

		} catch (Exception e) {
			throw e;
		}
		


	}

}
