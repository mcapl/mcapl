package ail.tracing.explanations;

import ail.tracing.events.SelectIntentionEvent;

public class SelectIntentionReason extends Reason {
	private final SelectIntentionEvent event;
	private CreateIntentionReason parent;

	public SelectIntentionReason(final int state, final SelectIntentionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public SelectIntentionEvent getEvent() {
		return this.event;
	}

	public void setParent(final CreateIntentionReason parent) {
		this.parent = parent;
	}

	@Override
	public CreateIntentionReason getParent() {
		return this.parent;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder();
		string.append("intention ").append(this.event.getIntention().getID()).append(" was selected in state ")
				.append(this.state);
		if (this.parent != null) {
			string.append(", because ").append(this.parent);
		} else {
			string.append(".");
		}
		return string.toString();
	}
}
