package ail.tracing.explanations;

import ail.syntax.Event;
import ail.syntax.Intention;
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
		final Event i_event = this.event.getIntention().hdE();
		switch (level) {
		case FINEST:
			// string.append("it was created in state ").append(this.state);
			if (i_event != null) {
				string.append(" the event ").append(inCourier(i_event.toString(descriptions)));
				string.append(" was posted because it appeared next in intention ").append(this.event.getIntention().getID());
			}
			break;
		default:
			if (i_event != null) {
				string.append("which was created for the event ").append(inCourier(i_event.toString(descriptions)));
			}
			break;
		}
		string.append("");
		return string.toString();
	}
}
