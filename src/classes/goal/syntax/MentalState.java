package goal.syntax;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.syntax.CapabilityLibrary;
import ail.syntax.Goal;
import ail.syntax.Message;
import ail.syntax.Literal;
import ail.syntax.PlanLibrary;
import ail.syntax.Predicate;
import ail.syntax.BeliefBase;
import ail.syntax.GoalBase;
import ail.syntax.RuleBase;
import ail.syntax.StringTerm;
import ail.syntax.Unifier;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MentalState {
	MentalModel ownModel = new MentalModel();
	
	public void updateGoalState() {
		ownModel.updateGoalState();
	};
	
	public void addMessage(Message m){};
	
	public Iterator<Literal> getPercepts() {
		return ownModel.getPercepts();
	};
	
	public void addPercepts(Set<Predicate> ps) {
		ownModel.getPerceptBase().addPercepts(ps);
	};
	
	public void removePercepts() {
		ownModel.getPerceptBase().removePercepts();
	};
	
	public void addBB(BeliefBase b) {
		ownModel.addBB(b);
	}
	
	public void addPerceptBase(BeliefBase b) {
		ownModel.addPerceptBase(b);
	}
	
	public void addGB(ConjGoalBase g) {
		ownModel.addGB(g);
	}
	
	public void addRB(RuleBase r) {
		ownModel.addRB(r);
	}
	
	public void adopt(ConjGoal g) {
		if (! g.getAsGuard().logicalConsequence(ownModel, new Unifier(), g.getVarNames(), AILAgent.SelectionOrder.LINEAR).hasNext()) {
			ownModel.adopt(g);
		}
	}

	public void focus(ConjGoalBase newAttentionSet) {
		ownModel.focus(newAttentionSet);
	}

	public MentalModel getOwnModel() {
		return ownModel;
	}

	public List<Goal> getGoals() {
		return ownModel.getGoals();
	}

	public void defocus() {
		ownModel.defocus();
	}


	
}
