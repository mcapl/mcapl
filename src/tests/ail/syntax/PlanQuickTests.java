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

import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import junit.framework.Assert;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;
import ail.util.AILPrettyPrinter;
import ail.syntax.ast.Abstract_Plan;

/**
 * Regression tests involving plans.
 * @author louiseadennis
 *
 */
public class PlanQuickTests {
	@Test public void planBodyUnification() {
		GwendolenLexer plan_lexer = new GwendolenLexer(CharStreams.fromString("+received(LG): {~B handling(LG)} <- +handling(LG), +!LG [perform], -handling(LG);"));
		CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
		GwendolenParser plan_parser = new GwendolenParser(plan_tokens);
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
		try {
			Plan plan = ((Abstract_Plan) visitor.visitPlan(plan_parser.plan())).toMCAPL();
			
			Literal received = new Literal("received");
			received.addTerm(new Literal("goal"));
			
			Intention i = new Intention(new Event(Event.AILAddition, Event.AILBel, received), AILAgent.refertoself(), new AILPrettyPrinter());
			AILAgent a = new AILAgent("ag");
			a.setIntention(i);
			a.addPlan(plan);
			
			GenerateApplicablePlansIfNonEmpty gplans = new GenerateApplicablePlansIfNonEmpty();
			Assert.assertTrue(gplans.checkPreconditions(a));
			gplans.apply(a);
			
			ApplyApplicablePlans aplans = new ApplyApplicablePlans();
			Assert.assertTrue(aplans.checkPreconditions(a));
			aplans.apply(a);
			// System.err.println(i);
			Deed d = i.deeds().get(1);
			Assert.assertFalse(d.getContent().getVarNames().isEmpty());
			Assert.assertFalse(d.getContent().getVarNames().contains(new VarTerm("LG")));
		

			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
