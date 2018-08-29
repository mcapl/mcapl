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
import ail.util.Tuple;
import hera.language.Formula;
import juno.semantics.JunoAgent;

public class UpdateAffects implements OSRule {
	private String name="Update Affects";

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
		juno.setAffects(juno.defaultAffects());
		for (Formula f: juno.getContextAffects().keySet()) {
			
			Iterator<Unifier> u_it = juno.believes(f.toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				HashMap<String, ArrayList<Tuple<String, String>>> new_affects = juno.getContextAffects().get(f);
				
				for (String s: new_affects.keySet()) {
					ArrayList<Tuple<String, String>> pairs = new_affects.get(s);
					ArrayList<Tuple<String, String>> new_pairs = new ArrayList<Tuple<String, String>>();
					for (Tuple<String, String> t: pairs) {
						if (! t.getRight().equals("?")) {
							new_pairs.add(t);
						}
					}
					if (!new_pairs.isEmpty()) {
						juno.setAffect(s, new_pairs);
					} else {
						juno.removeAffect(s);
					}
				}
		
				
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
