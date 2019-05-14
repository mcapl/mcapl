package ail.tracing.explanations;

import ail.syntax.Deed;
import ail.syntax.Event;
import ail.tracing.events.CreateIntentionEvent;

public class CreateIntentionReason extends AbstractReason {
	private final CreateIntentionEvent event;
	public SelectPlanReason parent = null;

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
		return parent;
	}
	
	public void setParent(SelectPlanReason r) {
		parent = r;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		final Event event = this.event.getEvent();
		switch (level) {
		case FINEST:
			if (event != null && !event.toString(descriptions).equals("start")) {
				string.append(" event ").append(inCourier(event.toString(descriptions)));
			} else if (event != null) {
				Deed d = this.event.getIntention().deeds().get(0);
				string.append("starting goal ").append(d.toString());
			}
			string.append(" was posted in state ").append(this.state);
			break;
		default:
			string.append(this.event.toString(descriptions)).append(" was created in state ").append(state).append(" because ");
			if (event != null) {
				if (event.getCategory() == Event.FromPercept) {
					string.append(this.event.getIntention().hdD().toString(descriptions)).append(" was perceived");
				} else if (event.getCategory() == Event.Estart) {
					string.append(this.event.getIntention().hdD().toString(descriptions)).append(" was an initial belief");
				} else {
					string.append(parent.getExplanation(level, descriptions));
				}
			}
			break;
		}
		string.append(".");
		return string.toString();
	}
}
