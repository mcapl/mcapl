package ail.semantics.planning.prolog_planning;

//----------------------------------------------------------------------------
//Copyright (C) 2016 Louise A. Dennis, and  Michael Fisher 
//
//This file is part of the Agent Infrastructure Layer (AIL)
//
//The AIL is free software; you can redistribute it and/or
//modify it under the terms of the GNU Lesser General Public
//License as published by the Free Software Foundation; either
//version 3 of the License, or (at your option) any later version.
//
//The AIL is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//Lesser General Public License for more details.
//
//You should have received a copy of the GNU Lesser General Public
//License along with the AIL; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
//To contact the authors:
//http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

import junit.framework.Assert;

import org.junit.Test;

import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.Term;
import ail.syntax.VarTerm;

public class SimplePlanningQuickTests {
	@Test public void path_planning_test() {
		PlanningContext pc = new PlanningContext();
		
		//==== INITIAL STATE
		// next_to(a, b)
		Predicate anexttob = new Predicate("next_to");
		anexttob.addTerm(new Predicate("a"));
		anexttob.addTerm(new Predicate("b"));
		pc.add_initial_condition(anexttob);
		
		// next_to(b, c)
		Predicate bnexttoc = new Predicate("next_to");
		bnexttoc.addTerm(new Predicate("b"));
		bnexttoc.addTerm(new Predicate("c"));
		pc.add_initial_condition(bnexttoc);
		
		// at(a)		
		Predicate initial_pos = new Predicate("at");
		initial_pos.addTerm(new Predicate("a"));
		pc.add_initial_condition(initial_pos);
		
		//==== Actions/Capabilities/Moves
		// cap(go(A, B), [at(A), next_to(A, B)], [del(at(A)), add(at(B))])
		Predicate capability = new Predicate("cap");
		VarTerm a = new VarTerm("A");
		VarTerm b = new VarTerm("B");
		
		Predicate go = new Predicate("go");
		go.addTerm(a);
		go.addTerm(b);
		capability.addTerm(go);
		
		ListTerm preconditions = new ListTermImpl();

		Predicate atA = new Predicate("at");
		atA.addTerm(a);
		preconditions.add(atA);
		
		Predicate nextto = new Predicate("next_to");
		nextto.addTerm(a);
		nextto.addTerm(b);
		preconditions.add(nextto);
		
		capability.addTerm(preconditions);
		
		ListTerm postconditions = new ListTermImpl();
		Predicate cap_post_pos = new Predicate("add");
		Predicate atB = new Predicate("at");
		atB.addTerm(b);
		cap_post_pos.addTerm(atB);
		postconditions.add(cap_post_pos);
		
		Predicate cap_post_neg = new Predicate("del");
		Predicate not_atA = new Predicate("at");
		not_atA.addTerm(a);
		cap_post_neg.addTerm(not_atA);
		postconditions.add(cap_post_neg);
		capability.addTerm(postconditions);
		
		pc.addRule(new Rule(capability));
		
		//==== Goal
		// at(c)
		Predicate goal = new Predicate("at");
		goal.addTerm(new Predicate("c"));
		
		pc.addGoal(goal);
		Term plan = pc.plan();
		
		Predicate btoc = new Predicate("go");
		btoc.addTerm(new Predicate("b"));
		btoc.addTerm(new Predicate("c"));
		
		Predicate atob = new Predicate("go");
		atob.addTerm(new Predicate("a"));
		atob.addTerm(new Predicate("b"));
		
		ListTerm moves = new ListTermImpl();
		moves.add(btoc);
		moves.add(atob);
		
		
		Assert.assertTrue(plan.equals(moves));
	}

}
