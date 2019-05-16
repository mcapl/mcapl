package gwendolen.tracing.explanations;

import ail.tracing.events.AbstractEvent;
import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class GeneratePlansReason extends AbstractReason {
	private final GeneratePlansEvent event;
	private GuardReason parent;
	private AbstractReason postevent;

	public GeneratePlansReason(final int state, final GeneratePlansEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public GeneratePlansEvent getEvent() {
		return this.event;
	}

	public void setParent(final GuardReason parent) {
		this.parent = parent;
	}

	@Override
	public GuardReason getParent() {
		return this.parent;
	}
	
	public void setPostEvent(AbstractReason pe) {
		this.postevent = pe;
	}
	

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			//string.append("the applicable plans generated in state ").append(this.state).append(" ")
			//		.append(inCourier(this.event.getPlans()));
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level, descriptions));
				string.append(" and ").append(this.postevent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(this.parent.getExplanation(level, descriptions));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
