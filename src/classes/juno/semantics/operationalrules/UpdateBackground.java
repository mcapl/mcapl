package juno.semantics.operationalrules;

import java.util.HashMap;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.ComparableTuple;
import ail.util.Tuple;
import hera.language.Formula;
import hera.language.FormulaString;
import juno.semantics.JunoAgent;

public class UpdateBackground implements OSRule {
	private String name="Update Background";

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
		juno.clearBackground();
		for (ComparableTuple<Formula, FormulaString> bck: juno.getContextBackground()) {
			
			Iterator<Unifier> u_it = juno.believes(bck.getLeft().toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				juno.addBel(new Literal(bck.getRight().getString()), juno.refertoself());
			} else {
				juno.delBel(new Literal(bck.getRight().getString()));
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
