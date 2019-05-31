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

package ail.semantics;

import org.junit.Test;
import org.junit.Assert;

import ail.syntax.Literal;
import ail.syntax.VarTerm;
import ail.util.AILPrettyPrinter;
import ail.syntax.GBelief;
import ail.syntax.Unifier;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Goal;
import ail.syntax.Event;
import ail.semantics.operationalrules.HandleAddAchieveTestGoalwEvent;
import ail.semantics.operationalrules.HandleDropGeneralGoal;
import ail.syntax.Deed;

import java.util.LinkedList;

/**
 * Various tests for methods in ail.semantics.AILAgent .  These have mostly been created as bugs in the operation of these
 * classes have come to light.  Any alteration to classes in ail.semantics.AILAgent should at a minimum pass these tests before
 * being committed.
 * @author lad
 *
 */
public class DroppingNonGroundGoalQuickTests {

	
	/**
	 * Prolog backtracking in Plan Guards.
	 */
	@Test public void DropGeneralGoalRuleSimple() {
		VarTerm v1 = new VarTerm("V1");
		
		Goal l1 = new Goal("goal", Goal.achieveGoal);
		Goal l2 = new Goal("goal", Goal.achieveGoal);
		
		l1.addTerm(v1);
		l2.addTerm(new Literal("term"));
		
		
		Intention i = new Intention(l1, AILAgent.refertoself(), new AILPrettyPrinter());
		AILAgent a = new AILAgent("ag");
		a.setIntention(i);
		HandleAddAchieveTestGoalwEvent addgoal = new HandleAddAchieveTestGoalwEvent();
		addgoal.checkPreconditions(a);
		addgoal.apply(a);
		
		Unifier u = new Unifier();
		Literal lclone = l1.clone();
		u.unifies(lclone, l2);
		i.compose(u);
		
		i.iCons(new Event(Event.AILAddition, l1), new Deed(Deed.AILDeletion, l2), new Guard(new GBelief()), u);
		
		HandleDropGeneralGoal dropgoal = new HandleDropGeneralGoal(new LinkedList<Integer>());
		dropgoal.checkPreconditions(a);
		dropgoal.apply(a);
		
		
		Assert.assertTrue(i.empty());

	}
	
	@Test public void DropGeneralGoalRuleNonGroundDropper() {
		VarTerm v1 = new VarTerm("V1");
		
		Goal l1 = new Goal("goal");
		Goal l2 = new Goal("goal");
		Goal l3 = new Goal("goal");
		l3.addTerm(new Literal("term"));
		
		l1.addTerm(v1);
		l2.addTerm(new VarTerm("V2"));
		
		
		Intention i = new Intention(l1, AILAgent.refertoself(), new AILPrettyPrinter());
		AILAgent a = new AILAgent("ag");
		a.setIntention(i);
		HandleAddAchieveTestGoalwEvent addgoal = new HandleAddAchieveTestGoalwEvent();
		addgoal.checkPreconditions(a);
		addgoal.apply(a);
		
		Unifier u = new Unifier();
		Literal lclone = l1.clone();
		u.unifies(lclone, l3);
		i.compose(u);
		
		i.iCons(new Event(Event.AILAddition, l1), new Deed(Deed.AILDeletion, l2), new Guard(new GBelief()), u);
		
		HandleDropGeneralGoal dropgoal = new HandleDropGeneralGoal(new LinkedList<Integer>());
		dropgoal.checkPreconditions(a);
		dropgoal.apply(a);
		
		
		Assert.assertTrue(i.empty());

	}
	
	@Test public void DropGeneralGoalBothNonGroundInitial() {
		VarTerm v1 = new VarTerm("V1");
		
		Goal l1 = new Goal("goal");
		Goal l2 = new Goal("goal");
		
		l1.addTerm(v1);
		l2.addTerm(new VarTerm("V2"));
		
		
		Intention i = new Intention(l1, AILAgent.refertoself(), new AILPrettyPrinter());
		AILAgent a = new AILAgent("ag");
		a.setIntention(i);
		HandleAddAchieveTestGoalwEvent addgoal = new HandleAddAchieveTestGoalwEvent();
		addgoal.checkPreconditions(a);
		addgoal.apply(a);
		
		Unifier u = new Unifier();
		
		i.iCons(new Event(Event.AILAddition, l1), new Deed(Deed.AILDeletion, l2), new Guard(new GBelief()), u);
		
		HandleDropGeneralGoal dropgoal = new HandleDropGeneralGoal(new LinkedList<Integer>());
		dropgoal.checkPreconditions(a);
		dropgoal.apply(a);
		
		
		Assert.assertTrue(i.empty());

	}


	/**
	 * Think this is a test for some situation where a predicate is ground but capitalised???
	 */
	@Test public void DropGeneralGoalNeitherGround() {
		VarTerm v1 = new VarTerm("V1");
		
		Goal l1 = new Goal("goal");
		Goal l2 = new Goal("goal");
		
		l1.addTerm(v1);
		l2.addTerm(new Literal("V2"));
		
		
		Intention i = new Intention(l1, AILAgent.refertoself(), new AILPrettyPrinter());
		AILAgent a = new AILAgent("ag");
		a.setIntention(i);
		HandleAddAchieveTestGoalwEvent addgoal = new HandleAddAchieveTestGoalwEvent();
		addgoal.checkPreconditions(a);
		addgoal.apply(a);
		
		Unifier u = new Unifier();
		
		i.iCons(new Event(Event.AILAddition, l1), new Deed(Deed.AILDeletion, l2), new Guard(new GBelief()), u);
		
		HandleDropGeneralGoal dropgoal = new HandleDropGeneralGoal(new LinkedList<Integer>());
		dropgoal.checkPreconditions(a);
		dropgoal.apply(a);
		
		
		Assert.assertFalse(i.empty());

	}

}
