package ail.tracing.explanations;

import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;

public class BeliefReason extends AbstractReason {
	AbstractReason parent;
	Predicate belief;
	int index;
	
	public BeliefReason(Predicate b, int state) {
		super(state);
		belief = b;
	}

	@Override
	public AbstractEvent getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractReason getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
	
	public void setParent(AbstractReason r) {
		parent = r;
	}

	@Override
	public String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append("Belief ").append(belief.toString()).append(" was believed in state ").append(state).append(" because ");
		string.append(getParent().getExplanation(level, descriptions));
		return string.toString();
	}

}
