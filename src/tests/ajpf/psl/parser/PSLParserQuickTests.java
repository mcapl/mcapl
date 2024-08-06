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

import java.util.Set;

import org.junit.Test;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Assert;

import eass.EASSMASBuilder;
import eass.verification.leo.LEOVerificationEnvironmentASEPaper;
import mcaplantlr.runtime.*;
import pbdi.parser.Python3Lexer;
import ajpf.MCAPLcontroller;
import ajpf.psl.ast.Abstract_MCAPLTerm;
import ail.mas.MAS;
import ail.mas.DefaultEnvironment;
import ail.semantics.AILAgent;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.ListTermImpl;
import ail.syntax.BeliefBase;
import ail.util.AILConfig;
import ajpf.psl.ast.Abstract_AgBelief;
import ajpf.psl.ast.Abstract_Formula;
import ajpf.psl.ast.Abstract_LastAction;
import ajpf.psl.ast.Abstract_MCAPLStringTermImpl;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.ast.Abstract_TermImpl;
import ajpf.psl.ast.Abstract_Or;
import ajpf.psl.MCAPLAgBelief;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.Proposition;

/**
 * Regression tests for parsing properties.
 * @author louiseadennis
 *
 */
public class PSLParserQuickTests {
	
	/*
	 * Test that literal hashes and equality are behaving sensible.
	 */
	@Test public void numberintermTest() throws Exception {
		
		String propertystring = "win(300)";
		
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		LogicalFmlasParser pslparser = new LogicalFmlasParser(psltokens);
		ajpf.psl.parser.FOFVisitor visitor = new ajpf.psl.parser.FOFVisitor();
		try {
			@SuppressWarnings("unused")
			Abstract_MCAPLTerm fmla = (Abstract_MCAPLTerm) visitor.visitFunction(pslparser.function());
		} catch (Exception e) {
			throw e;
		}
		
	}

	/*
	 * Test it is handling terms and formulas correclty;
	 */
	@Test public void termsandformulasTest() throws Exception {
		
		String propertystring = "B(ag3, win)";
		
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		try {
			@SuppressWarnings("unused")
			Abstract_AgBelief b = (Abstract_AgBelief) visitor.visitBeliefproperty(pslparser.beliefproperty());
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test public void listTermTest() throws Exception {
		String propertystring = "B (executive, better_choice_than([doNotCollideAircraft, doNotCollidePeople]))";
		
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		try {
			Abstract_AgBelief b = (Abstract_AgBelief) visitor.visitBeliefproperty(pslparser.beliefproperty());
			MAS mas = new MAS();
			mas.setEnv(new DefaultEnvironment());
			
			AILAgent executive = new AILAgent("executive");
			ListTermImpl ethics = new ListTermImpl();
			ethics.add(new Predicate("doNotCollideAircraft"));
			ethics.add(new Predicate("doNotCollidePeople"));
			Literal better = new Literal("better_choice_than");
			better.addTerm(ethics);
			executive.addBel(better, BeliefBase.TSelf);
			
			mas.addAg(new AILAgent("executive"));
			MCAPLcontroller mccontrol = new MCAPLcontroller(new AILConfig(), "");
			mccontrol.setMAS(mas);
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
		
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_LastAction a = (Abstract_LastAction) visitor.visitLastactionproperty(pslparser.lastactionproperty());
    	String filename = "/src/examples/eass/verification/leo/satellite_middle_line.eass";
    	String abs_filename = MCAPLcontroller.getAbsFilename(filename);

		MAS mas = (new EASSMASBuilder(abs_filename, true)).getMAS();
		LEOVerificationEnvironmentASEPaper env = new LEOVerificationEnvironmentASEPaper();
		mas.setEnv(env);
		MCAPLcontroller mccontrol = new MCAPLcontroller(new AILConfig(), "");
		mccontrol.setMAS(mas);
		a.toMCAPL(mas, mccontrol);
		
	} 
	
	@Test public void lastActionDotTest() throws Exception {
		
		String propertystring = "D(ag1, pi2go.forward(20))";
		
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_LastAction a = (Abstract_LastAction) visitor.visitLastactionproperty(pslparser.lastactionproperty());
		
		Abstract_TermImpl term = (Abstract_TermImpl) a.getAction();
		String functor = term.getFunctor();
		Assert.assertTrue(functor.equals("pi2go.forward"));
		
	} 

	@Test public void complexExpressionTest() throws Exception {
		String propertystring = "(  [] ( D(ag1, query(get_close_to(middle, _))) -> <> B(ag1, have_plan(middle, plan_middle)) )\n     &     [] ( D(ag1, perf(execute(plan_middle))) ->  <> B(ag1, in_position(middle))  )    ) \n ->     <> B(ag1, something_false)";
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_Property p = visitor.visitProperty(pslparser.property());
		Abstract_Property np = p.toNormalForm();
		Assert.assertTrue(np instanceof Abstract_Or);
		
	}
	
	@Test public void longConjuctionTest() throws Exception {
		String propertystring = "G(ag1, platoon_m(ag1, follower1)) & ItD(ag1, send(leader, 1, message(ag1, 1, follower1)))  &B(ag1, join_agreement(ag1, follower1)) &D(ag1, perf(join_ok(1))) & B(ag1, changed_lane) &D(ag1, perf(speed_controller(1))) &B(ag1, initial_distance) &D(ag1, perf(steering_controller(1))) &ItD(ag1, send(leader, 1, message(ag1, 2)))  &B(ag1, platoon_m) &B(ag1, platoon_ok) &G(ag2, set_spacing(17)) &ItD(ag1, send(leader, 1, set_spacing_from(ag1)))  &B(ag1, ack_spacing(17)) &B(ag1, spacing) &D(ag1, perf(speed_controller(0))) &D(ag1, perf(steering_controller(0))) &D(ag1, perf(join_ok(0)))";
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_Property p = visitor.visitSpec(pslparser.spec());
		Abstract_Property np = p.toNormalForm();
		MCAPLProperty prop = np.toMCAPLNative();
		Set<Proposition> props = prop.getProps();
		Assert.assertTrue(props.size() == 18);
	}
	
	@Test public void stringTermTest() throws Exception {
		String propertystring = "D(agent,print('Going Forward'))";
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
        
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_Property p = visitor.visitSpec(pslparser.spec());
		Assert.assertTrue(p instanceof Abstract_LastAction);
		Abstract_LastAction a = (Abstract_LastAction) p;
		Abstract_Formula print = a.getAction();
		Assert.assertTrue(print instanceof Abstract_MCAPLTerm);
		Abstract_MCAPLTerm s = ((Abstract_TermImpl) print).getTerm(0);
		Assert.assertTrue(s instanceof Abstract_MCAPLStringTermImpl);
	}
}
