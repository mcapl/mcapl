// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis,  Michael Fisher and Koen Hindriks
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

import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALAgent;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.syntax.ActionRule;
import goal.syntax.GOALModule.RuleEvaluationOrder;
import goal.syntax.ActionCombo;
import goal.syntax.MentalState;
import goal.syntax.GOALModule;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.BeliefBase;
import ail.syntax.GoalBase;
import ail.syntax.Unifier;
import ail.syntax.Plan;
import ail.syntax.PlanLibrary;
import ail.syntax.ApplicablePlan;

public class SelectRule implements OSRule {
	GOALModule m;
	Iterator<ApplicablePlan> ruleIterator;
	
    /**
     * The set of rules in this container.
     */
    private PlanLibrary rules;
    /**
     * Determines how the next action to be executed is selected.
     */
    private RuleEvaluationOrder ruleOrder;
    
    public SelectRule() {
    	this.ruleOrder = RuleEvaluationOrder.LINEAR;
    }
    
    public void setModule(GOALModule m) {
    	this.m = m;
    	rules = m.getRules();
    	ruleOrder = m.getRuleOrder();
    }
    
    public void setRules(List<Plan> plans) {
    	for (Plan p: plans) {
    		rules.add((ActionRule) p);
    	}
    }

    public SelectRule(PlanLibrary rules, RuleEvaluationOrder ruleOrder) {
            this.rules = rules;
            this.ruleOrder = ruleOrder;
    }
		
    
    public void apply(AILAgent ag) {
        m.setRule(ruleIterator.next());
    }

	@Override
	public boolean checkPreconditions(AILAgent a) {
        PlanLibrary rules = this.rules.copy();
        boolean shufflebases = false;

        switch (this.ruleOrder) {
        case ADAPTIVE:
        case LINEARADAPTIVE:
        	// Stuff not handling yet
        	break;
        case RANDOM:
        	rules.shuffle();
        	shufflebases = true;
         case LINEAR:
        	ruleIterator = rules.getAllReactivePlans(a, shufflebases);
        	return ruleIterator.hasNext();
        case RANDOMALL:
        	rules.shuffle();
        	shufflebases = true;
        case LINEARALL:
        // Continue evaluating and applying rule as long as there are more,
        // and no {@link ExitModuleAction} has been performed.
   /*     	for (ActionRule rule : rules) {
                result.merge(new RuleExecutor(rule).run(runState, substitution));
                if (result.isModuleTerminated()) {
                        break;
                }
        	} */
        	break;
        default:
        	break;
        }
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Rule Selection";
	}



}
