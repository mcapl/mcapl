package ail.semantics.heuristics;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Intention;

public class PruneRedundantIntentions implements SelectIntentionHeuristic {

	@Override
	public boolean applies(AILAgent ag, Intention i) {
		Deed top_deed = i.hdD();
		if (top_deed.isNPY()  && i.size() == 1) {
			Event top_trigger = i.hdE();
			Iterator<ApplicablePlan> candidates = ag.getAllRelevantPlans(top_trigger);
			if (! candidates.hasNext()) {
				return true;
			}
		}
		return false;
	}

}
