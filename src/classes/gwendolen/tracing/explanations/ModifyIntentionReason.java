package gwendolen.tracing.explanations;

import ail.syntax.Event;
import ail.syntax.Intention;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class ModifyIntentionReason extends AbstractReason {
	private final ModifyIntentionEvent event;
	AbstractReason parent;

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
		return parent;
	}
	
	public void setParent(AbstractReason r) {
		parent = r;
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
				string.append("Event: ");
				string.append(i_event.toString(descriptions));
				string.append(" was posted in state ").append(state).append(" because ");
				if (this.getParent() instanceof CreateIntentionReason) {
					string.append(((CreateIntentionReason) this.getParent()).getExplanation(level, descriptions));
				} else if (this.getParent() instanceof SelectPlanReason) {
					string.append(((SelectPlanReason) this.getParent()).getExplanation(level, descriptions));
				} else {
					string.append("it appeared next in intention ").append(this.event.getIntention().getID());
				}
			}
			break;
		}
		string.append("");
		return string.toString();
	}
}
