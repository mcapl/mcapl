// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package ail.semantics;

import org.junit.Test;
import org.junit.Assert;

import ail.syntax.Literal;
import ail.syntax.VarTerm;
import ail.syntax.Equation;
import ail.syntax.GBelief;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Guard;


/**
 * Various tests for methods in ail.semantics.AILAgent .  These have mostly been created as bugs in the operation of these
 * classes have come to light.  Any alteration to classes in ail.semantics.AILAgent should at a minimum pass these tests before
 * being committed.
 * @author lad
 *
 */
public class AILAgentQuickTests {

	
	/**
	 * Prolog backtracking in Plan Guards.
	 */
	@Test public void prologBacktracking() {
		Literal score1 = new Literal("score");
		score1.addTerm(new VarTerm("R1"));
		score1.addTerm(new VarTerm("N1"));
		
		Literal score2 = new Literal("score");
		score2.addTerm(new VarTerm("R2"));
		score2.addTerm(new VarTerm("N2"));
		
		Equation eq = new Equation(new VarTerm("N1"), Equation.NumericOp.less, new VarTerm("N2"));
			
		AILAgent ag = new AILAgent();
		
		Literal b1 = new Literal("score");
		b1.addTerm(new Predicate("route1"));
		b1.addTerm(new NumberTermImpl(1));
		
		Literal b2 = new Literal("score");
		b2.addTerm(new Predicate("route2"));
		b2.addTerm(new NumberTermImpl(2));
		
		ag.addBel(b2, AILAgent.refertoself());
		ag.addBel(b1, AILAgent.refertoself());
		
		Guard g = new Guard(new GBelief(score1), Guard.GLogicalOp.and, new Guard(new GBelief(score2), Guard.GLogicalOp.and, eq));
		
		Assert.assertTrue(ag.believesyn(g, new Unifier()));

	}

}
