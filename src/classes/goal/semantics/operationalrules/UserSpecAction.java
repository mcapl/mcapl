// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.ArrayList;
import java.util.HashSet;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.BeliefBase;
import ail.syntax.Deed;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import goal.syntax.ActionSpec;
import goal.syntax.GOALModule;
import goal.syntax.ModuleCallAction;
import goal.semantics.GOALAgent;

import java.util.Iterator;

import ail.syntax.Capability;
import gov.nasa.jpf.annotation.FilterField;

/**
 * This rules selects a capability to use to achieve the agent's goals.
 * 
 * @author lad
 *
 */
public class UserSpecAction extends ActionExecutor {
	@FilterField
	private final static String name = "Plan with Action Specs";
	
	private Iterator<Unifier> preiterator;
	private ActionSpec action;
			
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

		Action act = (Action) d.getContent();
		if (act instanceof ModuleCallAction) {
			return false;
		}
		
		Predicate cap = (Predicate) d.getContent().clone();

		Iterator<Capability> cit = ((GOALAgent) a).getCL().getRelevant(cap, AILAgent.SelectionOrder.LINEAR);
		action = (ActionSpec) cit.next().clone();
		
		Unifier u = a.getIntention().hdU();
		cap.apply(u);
		System.err.println(a.getAgName() + " attempting " + cap);
		Unifier newu = new Unifier();
		cap.standardise_apart(action, newu, new HashSet<String>());
		cap.unifies(action.getCap(), newu);
		AILAgent.SelectionOrder order = AILAgent.SelectionOrder.LINEAR;
		if (module.getRuleOrder() == GOALModule.RuleEvaluationOrder.RANDOM) {
			order = AILAgent.SelectionOrder.RANDOM;
		}
		// Think his is always random but check!!!
		preiterator = action.getPre().logicalConsequence(a, newu, action.getPre().getVarNames(), AILAgent.SelectionOrder.RANDOM);
		if (preiterator.hasNext()) {
			return true;
		} else {
			// abort the intention and back track over rule selection.
			// But what if there was more than one deed on the intention?
			a.setIntention(null);
			return false;
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		super.apply(a);
		// UserSpec should really include whether or not this is an external action.
		try {
			action.apply(preiterator.next());
			if (! action.isInternalAction()) {
				a.getEnv().executeAction(a.getAgName(), new Action(action.getCap(), Action.normalAction));
			} else {
				a.getEnv().notifyListeners();
			}
		} catch (Exception e) {
			
		}
		
		ArrayList<Literal> updates = action.postConditionsToLiterals();
		for (Literal b: updates) {
			if (b.negated()) {
				b.setNegated(false);
				a.delBel(b);
			} else {
				a.addBel(b, BeliefBase.TSelf);
			}
		}
		
		((GOALAgent) a).getMentalState().updateGoalState();
		a.getIntention().tlI(a);

	}
}