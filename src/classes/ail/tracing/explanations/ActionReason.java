package ail.tracing.explanations;

import ail.syntax.Action;
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
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append(inCourier(this.event.getAction().toString(descriptions))).append(" was executed");
		switch (level) {
		case FINEST:
			string.append(" in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(" because it was part of ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
	
	public Action getAction() {
		return this.event.getAction();
	}
	
	public int getIID() {
		return event.getIID();
	}
}
