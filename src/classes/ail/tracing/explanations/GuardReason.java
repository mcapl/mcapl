package ail.tracing.explanations;

import ail.tracing.events.GuardEvent;

public class GuardReason extends Reason {
	private final GuardEvent event;
	private SelectIntentionReason parent;

	public GuardReason(final int state, final GuardEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public GuardEvent getEvent() {
		return this.event;
	}

	public void setParent(final SelectIntentionReason parent) {
		this.parent = parent;
	}

	@Override
	public SelectIntentionReason getParent() {
		return this.parent;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder();
		string.append("the guard '").append(this.event.getGuard()).append("' held with ")
				.append(this.event.getSolutions()).append(" in state ").append(this.state);
		if (this.parent != null) {
			string.append(", because ").append(this.parent);
		} else {
			string.append(".");
		}
		return string.toString();
	}
}
