package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

public abstract class Reason {
	protected final int state;

	protected Reason(final int state) {
		this.state = state;
	}

	public abstract AbstractEvent getEvent();

	public abstract Reason getParent();

	@Override
	public abstract String toString();
}
