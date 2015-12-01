package goal.syntax;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.syntax.BeliefBase;
import ail.syntax.CapabilityLibrary;
import ail.syntax.GoalBase;
import ail.syntax.Goal;
import ail.syntax.Message;
import ail.syntax.PlanLibrary;
import ail.syntax.RuleBase;
import ail.syntax.Predicate;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.syntax.NamedEvaluationBase;
import ail.syntax.PredicateTerm;
import ail.syntax.Literal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

public class MentalModel implements AgentMentalState {
	BeliefBase bb;
	BeliefBase percepts = new BeliefBase();
	public Stack<ConjGoalBase> goalbases = new Stack<>();
	RuleBase rb;

	
	public void addBB(BeliefBase b) {
		bb = b;
	}
	
	public void addPerceptBase(BeliefBase b) {
		percepts = b;
	}
	
	public void addGB(ConjGoalBase g) {
		goalbases.push(g);
	}
	
	public void addRB(RuleBase rb) {
		this.rb = rb;
	}
	
	public Iterator<Literal> getPercepts() {
		return percepts.getPercepts();
	}
	
	public void updateGoalState() {
		if (goalbases.isEmpty()) {
			return;
		}
		
        List<ConjGoal> goals = getAttentionSet(true).getAllConjGoals();
        List<ConjGoal> goalsToBeRemoved = new LinkedList<>();
        for (ConjGoal goal : goals) {
        	Guard gb = goal.getAsGuard();
        		
        	if (gb.logicalConsequence(this, new Unifier(), gb.getVarNames(), AILAgent.SelectionOrder.LINEAR).hasNext()) {
        		goalsToBeRemoved.add(goal);
        	}
        }

        for (ConjGoal goal : goalsToBeRemoved) {
        	getAttentionSet(true).remove(goal);
        }
        
	}
	
    protected ConjGoalBase getAttentionSet(boolean use) {
    	return goalbases.peek();
    }
    
    public BeliefBase getBB() {
    	return getBB(new StringTermImpl(""));
    }
    
    public BeliefBase getPerceptBase() {
    	return percepts;
    }
    
    public void adopt(ConjGoal g) {
    	getAttentionSet(true).add(g);
    }

	@Override
	public BeliefBase getBB(StringTerm s) {
		// TODO Auto-generated method stub
		return bb;
	}

	@Override
	public Set<String> getBBList() {
		// TODO Auto-generated method stub
		Set<String> bblist = new HashSet<String>();
		bblist.add("");
		bblist.add("percepts");
		return bblist;
	}

	@Override
	public RuleBase getRuleBase() {
		// TODO Auto-generated method stub
		return rb;
	}

	@Override
	public CapabilityLibrary getCL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getOutbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getInbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalBase getGoalBase(StringTerm s) {
		// TODO Auto-generated method stub
		return goalbases.peek();
	}

	@Override
	public Set<String> getGBList() {
		HashSet<String> bblist = new HashSet<String>();
		bblist.add("");
		return bblist;
	}

	@Override
	public PlanLibrary getPL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void focus(ConjGoalBase newAttentionSet) {
		addGB(newAttentionSet);
	}

	public List<Goal> getGoals() {
		return getAttentionSet().getAll();
	}
	
	ConjGoalBase getAttentionSet() {
		return goalbases.peek();
	}
	
	public void defocus() {
		ConjGoalBase oldAttentionSet = goalbases.pop();
		oldAttentionSet.cleanup();
		updateGoalState();
	}

}
