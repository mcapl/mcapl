package juno.semantics.operationalrules;

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
import juno.semantics.JunoAgent;

public class UpdateUtilities implements OSRule {
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
		HashMap<String, Double> utilities = new HashMap<String, Double>();
		for (String action: juno.getHeraActions()) {
			Predicate utility = new Predicate("utility");
			utility.addTerm(new Predicate(action));
			VarTerm u = new VarTerm("U");
			utility.addTerm(u);
			
			Iterator<Unifier> u_it = juno.believes(new Guard(new GBelief(utility)), new Unifier());
			
			u.apply(u_it.next());
			
			NumberTerm n = (NumberTerm) u;
			
			utilities.put(action, n.solve());
		}
		juno.setUtilities(utilities);

	}

	@Override
	public String getName() {
		return name;
	}

}
