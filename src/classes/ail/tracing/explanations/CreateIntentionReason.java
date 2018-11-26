package ail.tracing.explanations;

import ail.syntax.Event;
import ail.tracing.events.CreateIntentionEvent;

public class CreateIntentionReason extends AbstractReason {
	private final CreateIntentionEvent event;

	public CreateIntentionReason(final int state, final CreateIntentionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public CreateIntentionEvent getEvent() {
		return this.event;
	}

	@Override
	public AbstractReason getParent() {
		return null;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		final Event event = this.event.getEvent();
		switch (level) {
		case FINEST:
			string.append("it was created in state ").append(this.state);
			if (event != null) {
				string.append(" for the event '").append(event.toString(descriptions)).append("'");
			}
			break;
		default:
			if (event != null) {
				string.append("which was created for the event '").append(event.toString(descriptions)).append("'");
			}
			break;
		}
		string.append(".");
		return string.toString();
	}
}
