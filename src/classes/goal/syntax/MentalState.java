package goal.syntax;

import ail.syntax.Message;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.BeliefBase;
import ail.syntax.GoalBase;
import ail.syntax.RuleBase;

import java.util.Iterator;
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
		ownModel.getBB().addPercepts(ps);
	};
	
	public void removePercepts() {
		ownModel.getBB().removePercepts();
	};
	
	public void addBB(BeliefBase b) {
		ownModel.addBB(b);
	}
	
	public void addGB(GoalBase g) {
		ownModel.addGB(g);
	}
	
	public void addRB(RuleBase r) {
		ownModel.addRB(r);
	}
	
}
