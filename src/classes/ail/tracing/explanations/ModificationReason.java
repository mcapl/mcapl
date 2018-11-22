package ail.tracing.explanations;

import ail.tracing.events.ModificationEvent;

public class ModificationReason extends AbstractReason {
	private final ModificationEvent event;
	private SelectPlanReason parent;

	public ModificationReason(final int state, final ModificationEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public ModificationEvent getEvent() {
		return this.event;
	}

	public void setParent(final SelectPlanReason parent) {
		this.parent = parent;
	}

	@Override
	public SelectPlanReason getParent() {
		return this.parent;
	}

	private String getPredicateDescriptor() {
		switch (event.getUpdate().getBase()) {
		case BELIEFS:
			return "belief(s)";
		case GOALS:
			return "goal(s)";
		case INBOX:
		case OUTBOX:
			return "message(s)";
		default:
			return "";
		}
	}

	private String getActionDescriptor() {
		switch (event.getUpdate().getBase()) {
		case BELIEFS:
		case GOALS:
			return "added";
		case INBOX:
			return "received";
		case OUTBOX:
			return "sent";
		default:
			return "";
		}
	}

	@Override
	public String getExplanation(final ExplanationLevel level) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			string.append("the ").append(getPredicateDescriptor()).append(" ").append(event.getUpdate().getAdded())
					.append(" were ").append(getActionDescriptor()).append(" in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level));
			}
			break;
		default:
			string.append("the ").append(getPredicateDescriptor()).append(" ").append(event.getUpdate().getAdded())
					.append(" were ").append(getActionDescriptor());
			if (this.parent != null) {
				string.append(" as part of ").append(this.parent.getExplanation(level));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
