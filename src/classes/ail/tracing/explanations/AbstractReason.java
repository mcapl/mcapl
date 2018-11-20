package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

public abstract class AbstractReason {
	protected final int state;

	protected AbstractReason(final int state) {
		this.state = state;
	}

	public abstract AbstractEvent getEvent();

	public abstract AbstractReason getParent();

	@Override
	public abstract String toString();
}
