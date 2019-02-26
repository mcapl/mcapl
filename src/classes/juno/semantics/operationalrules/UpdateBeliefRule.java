package juno.semantics.operationalrules;

import java.util.List;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.Unifier;
import juno.semantics.JunoAgent;
import juno.syntax.JunoBeliefRule;

public class UpdateBeliefRule implements OSRule {

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		List<JunoBeliefRule> rules = ((JunoAgent) a).getBeliefRules();
		for (JunoBeliefRule rule: rules) {
			if (a.believesyn(new Guard(new GBelief(rule.getTrigger())), new Unifier())) {
				for (Literal l: rule.getbeliefs()) {
					a.addBel(l, AILAgent.refertoself());
				}
			}
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
