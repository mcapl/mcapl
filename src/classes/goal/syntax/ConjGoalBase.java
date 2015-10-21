package goal.syntax;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.Goal;
import ail.syntax.GoalBase;
import ail.syntax.Predicate;
import ail.syntax.Term;

public class ConjGoalBase extends GoalBase {
	ArrayList<ConjGoal> conjgoals = new ArrayList<ConjGoal>();
	
	public void add(ConjGoal cg) {
		conjgoals.add(cg);
		
		List<Term> goals = cg.getTerms();
		
		for (Term t: goals) {
			add(new Goal((Predicate) t, cg.getGoalType()));
		}
	}
	
	public void remove(ConjGoal cg) {
		conjgoals.remove(cg);
		
		for (Goal g: cg.getAtomicGoals()) {
			remove(g);
		}
	}
	
	public List<ConjGoal> getAllConjGoals() {
		return conjgoals;
	}

}
