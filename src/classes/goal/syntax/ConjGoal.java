package goal.syntax;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Predicate;
import ail.syntax.Term;

public class ConjGoal extends Goal {
	
	
	public ConjGoal() {
		super("conjgoal");
	}
	
	public void addConj(Predicate p) {
		addTerm(p);
	}
	
	public List<Goal> getAtomicGoals() {
		ArrayList<Goal> atoms = new ArrayList<Goal>();
		for (Term t: getTerms()) {
			atoms.add(new Goal((Predicate) t, getGoalType()));
		}
		return atoms;
	}
	
	public Guard getAsGuard() {
		Guard g = new Guard();
		for (Goal gl: getAtomicGoals()) {
			g.add(new GBelief(gl.getLogicalContent()));
		}
		return g;
	}

}
