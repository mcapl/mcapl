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

import goal.semantics.GOALAgent;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.MentalModel;
import goal.syntax.MentalState;
import goal.syntax.ModuleCallAction;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Goal;
import ail.syntax.GoalBase;
import ail.syntax.Plan;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;

public class ModuleCallActionExecutor extends ActionExecutor {
	GOALModule action_module;
	Unifier u;

	@Override
	public boolean checkPreconditions(AILAgent a) {
		/* if (module.hasRuleSet()) {
			if ( ! module.getRule().hasNext() ) {
				module.setRule(null);
			}
		} */

		try {
			Deed d = a.getIntention().hdD();
		
			boolean isaction = d.getCategory() == Deed.DAction;
			
			if (isaction) {
				Action action = (Action) d.getContent();
				if (action instanceof ModuleCallAction) {
					action_module = ((ModuleCallAction) action).getModule();
					u = a.getIntention().hdU();
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}

		
		return false;
	}

	@Override
	public void apply(AILAgent a) {
		GOALAgent ag = (GOALAgent) a;
		Unifier moduleSubstitution = getModuleSubti(u);
		// action_module.setModuleSubti(moduleSubstitution);
		
		ConjGoalBase newAttentionSet = getNewFocus(ag.getMentalState(), moduleSubstitution, ag.getFocusGoal());
		/* for (Plan p: action_module.getRules().getPlans()) {
			p.apply(moduleSubstitution);
		} */
		
		
      	//GOALRCStage currentStage = ((GOALRC) a.getReasoningCycle()).getCurrentStage();
      	//if (currentStage instanceof ModuleExecutorStage) {
      	//	((ModuleExecutorStage) currentStage).setExitIfAppropriate(ag);
      	//}
       	
       /*	if (currentStage instanceof ModuleExecutorStage) {
       		GOALModule prevModule = ((ModuleExecutorStage) currentStage).getModule(); 
       		if (prevModule.getType() == GOALModule.ModuleType.ANONYMOUS) {
       			System.err.println("here");
       			//prevModule.setRule(null);
       		}
       	
       	} */
		module.clearRuleItIfNotApplyAll(); 
       	
		if (newAttentionSet != null) {
			ag.getMentalState().focus(newAttentionSet);
		}
		
		ag.setFocusGoal(null);
		GOALRC rc = (GOALRC) ag.getReasoningCycle();
		rc.setCurrentModuleExecuteFully(action_module);
		a.getIntention().tlI(a);


	}

	private ConjGoalBase getNewFocus(MentalState mentalstate,
			Unifier subst, Goal goal) {
        switch (action_module.getFocusMethod()) {
        case NEW:
                // Create new empty goal base to construct a new attention set.
                return new ConjGoalBase();
        case SELECT:
                ConjGoalBase newAttentionSet = new ConjGoalBase();
                newAttentionSet.add(goal);
                return newAttentionSet;
        case FILTER:
                // from the goals that validate the context,
                // choose one randomly
               // return getNewFilterGoals(mentalstate, subst);
        default:
                return null;
        }
	}

	private Unifier getModuleSubti(Unifier un) {
		if (action_module.getType() == GOALModule.ModuleType.ANONYMOUS) {
			return un;
		} else {
			Unifier u = new Unifier();
			for (VarTerm v: action_module.getParams()) {
				if (un.containsVarName(v.getFunctor())) {
					u.unifies(v, u.get(v));
				}
			}
			return u;
		}
	}
	
	/**
	 * Used in testing.
	 * @return
	 */
	public GOALModule getModule() {
		return action_module;
	}

	@Override
	public String getName() {
		return "Module Call Action Executor";
	}

}
