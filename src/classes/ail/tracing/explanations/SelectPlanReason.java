package ail.tracing.explanations;

import ail.tracing.events.SelectPlanEvent;

public class SelectPlanReason extends Reason {
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
	public String toString() {
		final StringBuilder string = new StringBuilder();
		string.append("plan ").append(this.event.getPlan().getID()).append(" was selected in state ")
				.append(this.state);
		if (this.parent != null) {
			string.append(", because it was included in ").append(this.parent);
		} else {
			string.append(".");
		}
		return string.toString();
	}
}
