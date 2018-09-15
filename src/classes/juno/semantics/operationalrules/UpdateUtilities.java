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
import ajpf.util.VerifyMap;
import hera.language.Formula;
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
		juno.setUtilities(juno.defaultUtilities());
		for (Formula f: juno.getContextUtilities().keySet()) {
			
			Iterator<Unifier> u_it = juno.believes(f.toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				VerifyMap<String, Double> new_utilities = juno.getContextUtilities().get(f);
				
				for (String s: new_utilities.keySet()) {
					juno.setUtility(s, new_utilities.get(s));
				}
				
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
