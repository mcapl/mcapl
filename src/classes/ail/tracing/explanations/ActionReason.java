package ail.tracing.explanations;

import ail.tracing.events.ActionEvent;

public class ActionReason extends AbstractReason {
	private final ActionEvent event;
	private SelectPlanReason parent;

	public ActionReason(final int state, final ActionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public ActionEvent getEvent() {
		return this.event;
	}

	public void setParent(final SelectPlanReason parent) {
		this.parent = parent;
	}

	@Override
	public SelectPlanReason getParent() {
		return this.parent;
	}

	@Override
	public String getExplanation(final ExplanationLevel level) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			string.append(this.event.getAction()).append(" was executed in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level));
			}
			break;
		default:
			string.append(this.event.getAction()).append(" was executed");
			if (this.parent != null) {
				string.append(" because it was part of ").append(this.parent.getExplanation(level));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
