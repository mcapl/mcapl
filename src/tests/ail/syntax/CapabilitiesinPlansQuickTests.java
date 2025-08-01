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

package ail.syntax;

import ail.syntax.ast.Abstract_Capability;
import ail.syntax.ast.Abstract_Plan;
import eass.parser.EASSAILVisitor;
import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.parser.GwendolenAILVisitor;
import junit.framework.Assert;

import org.junit.Test;

import ail.semantics.AILAgent;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Regression tests associated with reasoning about capabilities/actions appearing
 * in plans.
 * @author louiseadennis
 *
 */
public class CapabilitiesinPlansQuickTests {
	
	/**
	 * Test to check that we can extract all the plans containing some capability
	 */
	@Test public void getPlansContainingCapTest() {
		EASSLexer plan1_lexer = new EASSLexer(CharStreams.fromString("+!correct_angle(A) [perform] : {True} <- .query(calculate_angle(A)), perf(turn(A)), *turned, remove_shared(turned);"));
		plan1_lexer.pushMode(EASSLexer.PLANS_MODE);
		CommonTokenStream plan1_tokens = new CommonTokenStream(plan1_lexer);
		EASSParser plan1_parser = new EASSParser(plan1_tokens);
		EASSLexer plan2_lexer = new EASSLexer(CharStreams.fromString("+! move(D) [perform] : {True} <- .query(calculate_distance(D)), perf(forward(D)), *moved, remove_shared(moved), +!evaluate_success(pos(X, Y), forward(D), True) [perform];"));
		plan2_lexer.pushMode(EASSLexer.PLANS_MODE);
		CommonTokenStream plan2_tokens = new CommonTokenStream(plan2_lexer);
		EASSParser plan2_parser = new EASSParser(plan2_tokens);

		EASSAILVisitor visitor = new EASSAILVisitor();
		
		try {
			Plan plan1 = ((Abstract_Plan) visitor.visitEass_plan(plan1_parser.eass_plan())).toMCAPL();
			Plan plan2 = ((Abstract_Plan) visitor.visitEass_plan(plan2_parser.eass_plan())).toMCAPL();

			AILAgent a = new AILAgent("ag");
			a.addPlan(plan1);
			a.addPlan(plan2);
			
			Predicate capname = new Predicate("forward");
			capname.addTerm(new VarTerm("F"));
			
			Iterator<Plan> ip = a.getPL().getPlansContainingCap(capname);
			
			Plan p = ip.next();
			Assert.assertTrue(p != null);
			Assert.assertTrue(p.getID() == plan2.getID());
			Assert.assertFalse(ip.hasNext());
			
			
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * A fairly involved test to check identifying an equivalent capability and substituting it into a plan.  This test needs to be visited once we can get non-ground terms to imply each other.
	 */
	/* @Test public void findEquivalentCapabilityTest() {
		EASSLexer cap1_lexer = new EASSLexer(CharStreams.fromString("{pos(X, Y), angle(Theta), target(NX, NY)} forward(D) {pos(NX, NY), angle(Theta)}"));
		CommonTokenStream cap1_tokens = new CommonTokenStream(cap1_lexer);
		cap1_lexer.pushMode(EASSLexer.CAPABILITIES);
		EASSParser cap1_parser = new EASSParser(cap1_tokens);
		EASSLexer cap2_lexer = new EASSLexer(CharStreams.fromString("{target(X, Y)} feedback(X, Y) {pos(X, Y)}"));
		cap2_lexer.pushMode(EASSLexer.CAPABILITIES);
		CommonTokenStream cap2_tokens = new CommonTokenStream(cap2_lexer);
		EASSParser cap2_parser = new EASSParser(cap2_tokens);
		EASSLexer plan_lexer = new EASSLexer(CharStreams.fromString("+! move(D) [perform] : {True} <-  .query(calculate_distance(D)), perf(forward(D)),  *moved, remove_shared(moved), +!evaluate_success(pos(A, B), forward(D1), true) [perform];"));
		plan_lexer.pushMode(EASSLexer.PLANS_MODE);
		CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
		EASSParser plan_parser = new EASSParser(plan_tokens);

		EASSAILVisitor visitor = new EASSAILVisitor();
		// GwendolenAILVisitor gwen_visitor = new GwendolenAILVisitor();
		
		try {
			Capability cap1 = ((Abstract_Capability) visitor.visitCapability(cap1_parser.capability())).toMCAPL();
			Capability cap2 = ((Abstract_Capability) visitor.visitCapability(cap2_parser.capability())).toMCAPL();
			Plan plan = ((Abstract_Plan) visitor.visitEass_plan(plan_parser.eass_plan())).toMCAPL();

			AILAgent a = new AILAgent("ag");
			a.addCap(cap1);
			a.addCap(cap2);
			a.addPlan(plan);
			
			Predicate post = new Predicate("pos");
			post.addTerm(new VarTerm("A"));
			post.addTerm(new VarTerm("B"));
			
			Unifier u = new Unifier();
			Capability c = a.getCL().findEquivalent(cap1, post, a.getRuleBase(), u);
			Assert.assertTrue(c.getCap().unifies(cap2.getCap(), new Unifier()));
			
			cap1.apply(u);
			
			Iterator<Plan> plans = a.getPL().getPlansContainingCap(cap1.getCap());
			while (plans.hasNext()) {
				Plan p = plans.next();
				Plan newplan = (Plan) p.clone();
				
				newplan.replaceCap(cap1.getCap(), c, cap1);
				// newplan.apply(u);
				newplan.resolveVarsClusters();
				ArrayList<Deed> deeds = newplan.getBody();

				Deed target = deeds.get(4);
				Literal tg = (Literal) target.getContent();
				VarTerm notx = (VarTerm) tg.getTerms().get(0);
				Assert.assertFalse(notx.getFunctor().equals("X"));
				Deed feedback = deeds.get(3);
				Action fb = (Action) feedback.getContent();
				VarTerm notx2 = (VarTerm) (fb.getTerms().get(0)).getTerms().get(0);
				Assert.assertTrue(notx.getFunctor().equals(notx2.getFunctor()));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
		
	} */

}
