// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, Michael Fisher and Koen Hindriks
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
package goal.syntax;


import ail.syntax.CapabilityLibrary;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.Goal;
import ail.syntax.Plan;
import ail.syntax.GoalBase;
import ail.syntax.RuleBase;
import ail.syntax.PlanLibrary;
import ail.syntax.BeliefBase;
import ail.syntax.Literal;
import ail.syntax.ApplicablePlan;

import java.util.Iterator;
import java.util.List;

public class GOALModule {
	
	ConjGoalBase gb = new ConjGoalBase();
	RuleBase rb = new RuleBase();
	PlanLibrary pl = new PlanLibrary();
	BeliefBase bb = new BeliefBase();
	CapabilityLibrary cl = new CapabilityLibrary();
	
	ModuleType module_type;
	
	boolean is_terminated = false;
	private ExitCondition exitCondition = ExitCondition.ALWAYS;
    /**
     * Rule evaluation order option. By default, order is linear.
     */
    private RuleEvaluationOrder order = RuleEvaluationOrder.LINEAR;
    
    private Iterator<ApplicablePlan> ruleIt;
	
	public static enum ExitCondition {
		NOGOALS,
		NOACTION,
		ALWAYS,
		NEVER;
	}
	
	public static enum ModuleType {
		MAIN,
		EVENT,
		ANONYMOUS,
		INIT
	}
	
    public enum RuleEvaluationOrder {
        /**
         * Of the first rule with a viable instance, one random instance will be
         * applied. A forall-do rule counts as one instance.
         */
        LINEAR,
        /**
         * Of all viable rule instances, one will be applied. A forall-do rule
         * counts as one instance.
         */
        RANDOM,
        /**
         * All rules will be applied, from top to bottom. Instances from within
         * a single rule are applied in random order. Only one instance from
         * each if-then rule will be applied.
         */
        LINEARALL,
        /**
         * All viable rule instances will be applied, but in random order. Only
         * one instance from each if-then rule will be applied.
         */
        RANDOMALL,
        /**
         * The first rule (in linear order) that is applicable will be applied
         * and only the options of this rule are generated. The option that is
         * selected depends on ongoing learning.
         */
        LINEARADAPTIVE,
        /**
         * All rules will be applied in linear order and all options generated.
         * The option that is selected depends on ongoing learning.
         */
        ADAPTIVE;

        /**
         * @return {@code true} iff this {@link RuleEvaluationOrder} is
         *         {@link #LINEAR} or {@link #LINEAR}.
         */
        public boolean isLinear() {
                return this == LINEAR || this == LINEARALL || this == ADAPTIVE;
        }

        /**
         * @return {@code true} iff this {@link RuleEvaluationOrder} is
         *         {@link #LINEARALL} or {@link #RANDOMALL}.
         */
        public boolean applyAll() {
                return this == LINEARALL || this == RANDOMALL || this == ADAPTIVE;
        }

        /**
         * @return {@code true} iff this {@link RuleEvaluationOrder} is
         *         {@link #ADAPTIVE}
         */
        public boolean isAdaptive() {
                return this == ADAPTIVE;
        }
    }


	
	public ExitCondition getExitCondition() {
		return this.exitCondition;
	}
	
	public void setExitCondition(ExitCondition exitCondition) {
		this.exitCondition = exitCondition;
	}

	public GOALModule(ModuleType type) {
		module_type = type;
		if (module_type == ModuleType.MAIN) {
			exitCondition = ExitCondition.NEVER;
		} else {
			exitCondition = ExitCondition.ALWAYS;
		}
	}
	
	public void addGoal(ConjGoal p) {
		gb.add(p);
	};
	
	public void addRule(Rule r) {
		rb.add(r);
	};
	
	public void addActionRule(ActionRule r) {
		pl.add(r);
	};
	
	public void addCap(ActionSpec as) {
		cl.add(as);
	}
	
	public void addFact(Predicate p) {
		bb.add(new Literal(p));
	};
	
	public ModuleType getType() {
		return module_type;
	}
	
	public void setModuleTerminated(boolean value) {
		is_terminated = value;
	}
	
	public boolean isModuleTerminated() {
		return is_terminated;
	}
	
	public PlanLibrary getRules() {
		return pl;
	}
	
	public CapabilityLibrary getCL() {
		return cl;
	}
	
	public BeliefBase getBB() {
		return bb;
	}
	
	public ConjGoalBase getGB() {
		return gb;
	}
	
	public RuleBase getRuleBase() {
		return rb;
	}
	
	public RuleEvaluationOrder getRuleOrder() {
		return order;
	}
	
	public void setRule(Iterator<ApplicablePlan> p) {
		ruleIt = p;
	}
	
	public boolean hasRuleSet() {
		return ruleIt != null;
	}
	
	public Iterator<ApplicablePlan> getRule() {
		return ruleIt;
	}
	
	public void setRuleEvaluationOrder(RuleEvaluationOrder o) {
		order = o;
	}
	
	public boolean isIfThenRule(ApplicablePlan p) {
		ActionRule a = (ActionRule) pl.getPlanbyID(p.getID());
		return (a.isIfThenRule());
	}
}
