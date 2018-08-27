package juno.semantics.operationalrules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import hera.language.Formula;
import juno.semantics.JunoAgent;

public class UpdateGoals implements OSRule {
	private String name="Update Utilities";

	@Override
	public boolean checkPreconditions(AILAgent a) {
		if (a instanceof JunoAgent) {
			return true;
		}
		return false;
	}

	@Override
	public void apply(AILAgent a) {
		JunoAgent juno = (JunoAgent) a;
		juno.setGoals(juno.defaultGoals());
		for (Formula f: juno.getContextGoals().keySet()) {
			
			Iterator<Unifier> u_it = juno.believes(f.toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				ArrayList<String> new_goals = juno.getContextGoals().get(f);
				
				for (String g: new_goals) {
					juno.setNewGoal(g);
				}
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
