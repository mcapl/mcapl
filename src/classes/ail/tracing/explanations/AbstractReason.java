package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

public abstract class AbstractReason {
	protected final int state;

	protected AbstractReason(final int state) {
		this.state = state;
	}

	public abstract AbstractEvent getEvent();

	public abstract AbstractReason getParent();

	public abstract String getExplanation(ExplanationLevel level);

	public final String toString() {
		return getExplanation(ExplanationLevel.FINEST);
	}
}
