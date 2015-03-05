package goal.syntax;

import ail.syntax.BeliefBase;
import ail.syntax.GoalBase;
import ail.syntax.Goal;
import ail.syntax.RuleBase;
import ail.syntax.Predicate;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.Unifier;
import ail.syntax.NamedEvaluationBase;
import ail.syntax.PredicateTerm;
import ail.syntax.Literal;

import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class MentalModel {
	BeliefBase bb;
	GoalBase gb;
	RuleBase rb;

	
	public void addBB(BeliefBase b) {
		bb = b;
	}
	
	public void addGB(GoalBase g) {
		gb = g;
	}
	
	public void addRB(RuleBase rb) {
		this.rb = rb;
	}
	
	public Iterator<Literal> getPercepts() {
		return bb.getPercepts();
	}
	
	public void updateGoalState() {
		if (gb.isEmpty()) {
			return;
		}
		
        List<Goal> goals = getAttentionSet(true).getAll();
        List<Goal> goalsToBeRemoved = new LinkedList<>();
        for (Goal goal : goals) {
        		Predicate gterm = goal.getLogicalContent();
        		GBelief gb = new GBelief(gterm);
        		
                if (gb.logicalConsequence(new NamedEvaluationBase<PredicateTerm>(bb, "self"), rb, new Unifier(), gb.getVarNames()).hasNext()) {
                        goalsToBeRemoved.add(goal);
                }
        }

        for (Goal goal : goalsToBeRemoved) {
        	getAttentionSet(true).remove(goal);
        }
        
	}
	
    protected GoalBase getAttentionSet(boolean use) {
    	return gb;
    }
    
    public BeliefBase getBB() {
    	return bb;
    }

}
