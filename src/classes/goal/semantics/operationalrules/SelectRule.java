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

import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALAgent;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.syntax.ActionRule;
import goal.syntax.GOALModule.RuleEvaluationOrder;

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
    private PlanLibrary rules = new PlanLibrary();
    /**
     * Determines how the next action to be executed is selected.
     */
    private RuleEvaluationOrder ruleOrder;
    
    public SelectRule() {
    	this.ruleOrder = RuleEvaluationOrder.LINEAR;
    }
    
    public void setModule(GOALModule m) {
    	this.m = m;
    	for (Plan p: m.getRules().getPlans()) {
    		ActionRule cp = (ActionRule) p.clone();
    		cp.apply(m.getModuleSubti());
    		// cp.resetModuleCalls();
    		rules.add(cp);
     	}
    	// rules = m.getRules();
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
        m.setRule(ruleIterator);
    }

	@Override
	public boolean checkPreconditions(AILAgent a) {
        PlanLibrary rules = this.rules.copy();
        for (Plan p: rules.getPlans()) {
        	((ActionRule) p).resetModuleCalls();
        }
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
        	ruleIterator = rules.getAllReactivePlans(a, shufflebases);
        	return ruleIterator.hasNext();
   /*     	for (ActionRule rule : rules) {
                result.merge(new RuleExecutor(rule).run(runState, substitution));
                if (result.isModuleTerminated()) {
                        break;
                }
        	} */
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
