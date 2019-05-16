package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

public class EmptyReason extends AbstractReason {
	
	public EmptyReason(int state) {
		super(state);
	}

	@Override
	public AbstractEvent getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractReason getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions) {
		// TODO Auto-generated method stub
		return "No Explanations for this Language";
	}

}
