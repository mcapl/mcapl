// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.parser;

import org.junit.Test;
import org.junit.Assert;

import eass.EASSMASBuilder;
import eass.verification.leo.LEOVerificationEnvironment;

import mcaplantlr.runtime.*;

import ajpf.MCAPLcontroller;
import ajpf.psl.ast.Abstract_MCAPLTerm;
import ail.mas.MAS;
import ail.mas.DefaultEnvironment;
import ail.semantics.AILAgent;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.ListTermImpl;
import ail.syntax.BeliefBase;
import ajpf.psl.ast.Abstract_AgBelief;
import ajpf.psl.ast.Abstract_LastAction;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.ast.Abstract_Or;
import ajpf.psl.MCAPLAgBelief;


public class PSLParserTests {
	
	/*
	 * Test that literal hashes and equality are behaving sensible.
	 */
	@Test public void numberintermTest() throws Exception {
		
		String propertystring = "win(300)";
		
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		try {
			@SuppressWarnings("unused")
			Abstract_MCAPLTerm fmla = pslparser.formula();
		} catch (Exception e) {
			throw e;
		}
		
	}

	/*
	 * Test it is handling terms and formulas correclty;
	 */
	@Test public void termsandformulasTest() throws Exception {
		
		String propertystring = "B(ag3, win)";
		
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		try {
			@SuppressWarnings("unused")
			Abstract_AgBelief b = pslparser.beliefproperty();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test public void listTermTest() throws Exception {
		String propertystring = "B (executive, better_choice_than([doNotCollideAircraft, doNotCollidePeople]))";
		
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		try {
			Abstract_AgBelief b = pslparser.beliefproperty();
			MAS mas = new MAS();
			mas.setEnv(new DefaultEnvironment());
			
			AILAgent executive = new AILAgent("executive");
			ListTermImpl ethics = new ListTermImpl();
			ethics.add(new Predicate("doNotCollidePeople"));
			ethics.add(new Predicate("doNotCollideAircraft"));
			Literal better = new Literal("better_choice_than");
			better.addTerm(ethics);
			executive.addBel(better, BeliefBase.TSelf);
			
			mas.addAg(new AILAgent("executive"));
			MCAPLcontroller mccontrol = new MCAPLcontroller(mas, propertystring, 1);
			MCAPLAgBelief cb = (MCAPLAgBelief) b.toMCAPL(mas, mccontrol);
			Assert.assertTrue(executive.MCAPLbelieves(cb.getBel()));
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/*
	 * Test it is handling actions correctly
	 */
	@Test public void lastActionTest() throws Exception {
		
		String propertystring = "D(ag1, query(get_close_to(middle, plan_middle)))";
		
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		Abstract_LastAction a = pslparser.lastactionproperty();
    	String filename = "/src/examples/eass/verification/leo/satellite_middle_line.eass";
    	String abs_filename = MCAPLcontroller.getAbsFilename(filename);

		MAS mas = (new EASSMASBuilder(abs_filename, true)).getMAS();
		LEOVerificationEnvironment env = new LEOVerificationEnvironment();
		mas.setEnv(env);
		MCAPLcontroller mccontrol = new MCAPLcontroller(mas, propertystring, 1);
		a.toMCAPL(mas, mccontrol);
		
	} 
	
	@Test public void complexExpressionTest() throws Exception {
		String propertystring = "(  [] ( D(ag1, query(get_close_to(middle, _))) -> <> B(ag1, have_plan(middle, plan_middle)) )\n     &     [] ( D(ag1, perf(execute(plan_middle))) ->  <> B(ag1, in_position(middle))  )    ) \n ->     <> B(ag1, something_false)";
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		Abstract_Property p = pslparser.property();
		Abstract_Property np = p.toNormalForm();
		Assert.assertTrue(np instanceof Abstract_Or);
		
	}
}
