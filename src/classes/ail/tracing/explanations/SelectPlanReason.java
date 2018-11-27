package ail.tracing.explanations;

import ail.tracing.events.SelectPlanEvent;

public class SelectPlanReason extends AbstractReason {
	private final SelectPlanEvent event;
	private GeneratePlansReason parent;

	public SelectPlanReason(final int state, final SelectPlanEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public SelectPlanEvent getEvent() {
		return this.event;
	}

	public void setParent(final GeneratePlansReason parent) {
		this.parent = parent;
	}

	@Override
	public GeneratePlansReason getParent() {
		return this.parent;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append(inCourier(this.event.getPlan()));
		switch (level) {
		case FINEST:
			string.append(" was selected in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because it was included in ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(", ").append(this.parent.getExplanation(level, descriptions));
			}
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
