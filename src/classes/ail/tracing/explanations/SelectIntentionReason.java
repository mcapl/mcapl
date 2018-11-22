package ail.tracing.explanations;

import ail.tracing.events.SelectIntentionEvent;

public class SelectIntentionReason extends AbstractReason {
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
	public String getExplanation(final ExplanationLevel level) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			string.append(this.event.getIntention()).append(" was selected in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(this.parent.getExplanation(level));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
