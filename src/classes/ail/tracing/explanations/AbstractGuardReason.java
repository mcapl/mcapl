package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

public abstract class AbstractGuardReason extends AbstractReason {

	protected AbstractGuardReason(int state) {
		super(state);
	}

	@Override
	public abstract AbstractEvent getEvent(); 

	@Override
	public abstract AbstractReason getParent(); 

	@Override
	public abstract String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions);

}
