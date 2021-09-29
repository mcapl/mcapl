package ail.semantics.heuristics;

import ail.semantics.AILAgent;
import ail.syntax.Deed;
import ail.syntax.Intention;

public class PrioritiseWaitFor implements SelectIntentionHeuristic {
	@Override
	public boolean applies(AILAgent ag, Intention i) {
		Deed top_deed = i.hdD();
		if (top_deed.getCategory() == Deed.Dwaitfor) {
			return true;
		} 
		
		return false;
	}

}
