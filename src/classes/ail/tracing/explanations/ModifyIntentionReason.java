package ail.tracing.explanations;

import ail.syntax.Event;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModifyIntentionEvent;

public class ModifyIntentionReason extends AbstractReason {
	private final ModifyIntentionEvent event;

	public ModifyIntentionReason(final int state, final ModifyIntentionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public ModifyIntentionEvent getEvent() {
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
				string.append(" for the event ").append(inCourier(event.toString(descriptions)));
			}
			break;
		default:
			if (event != null) {
				string.append("which was created for the event ").append(inCourier(event.toString(descriptions)));
			}
			break;
		}
		string.append(".");
		return string.toString();
	}
}
