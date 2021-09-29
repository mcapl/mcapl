package ail.semantics.heuristics;

import ail.semantics.AILAgent;
import ail.syntax.Intention;

public interface SelectIntentionHeuristic {
	public boolean applies(AILAgent ag, Intention i);
}
