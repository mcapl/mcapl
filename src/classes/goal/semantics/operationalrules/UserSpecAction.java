// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.ArrayList;
import java.util.LinkedList;

import ail.semantics.operationalrules.*;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.BeliefBase;
import ail.syntax.Deed;
import ail.syntax.Intention;
import ail.syntax.ApplicablePlan;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.CapabilityLibrary;
import ail.syntax.Unifier;
import ail.semantics.OSRule;
import goal.mas.GoalEnvironment;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.ActionSpec;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;

import java.util.Iterator;

import ail.syntax.Capability;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.vm.Verify;

/**
 * This rules selects a capability to use to achieve the agent's goals.
 * 
 * @author lad
 *
 */
public class UserSpecAction implements OSRule {
	@FilterField
	private final static String name = "Plan with Action Specs";
	
	private Iterator<Unifier> preiterator;
	private Capability action;
	
	GOALModule module;
	
	public UserSpecAction(ModuleExecutorStage mes) {
		module = mes.getModule();
	}
	
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		Deed d = a.getIntention().hdD();
		
		boolean userspecaction = d.getCategory() == Deed.DAction;
		if (!userspecaction) {
			return false;
		}
		
		Predicate cap = (Predicate) d.getContent();
		
		Iterator<Capability> cit = module.getCL().getRelevant(cap);
		action = cit.next();
		
		preiterator = action.getPre().logicalConsequence(a, a.getIntention().hdU(), action.getPre().getVarNames());
		return preiterator.hasNext();

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		// UserSpec should really include whether or not this is an external action.
		try {
			a.getEnv().executeAction(a.getAgName(), new Action(action.getCap(), Action.normalAction));
		} catch (Exception e) {
			
		}
		
		ArrayList<Literal> updates = action.postConditionsToLiterals();
		for (Literal b: updates) {
			if (b.negated()) {
				a.delBel(b);
			} else {
				a.addBel(b, BeliefBase.TSelf);
			}
		}
		
		((GOALAgent) a).getMentalState().updateGoalState();
		
		
	}
}