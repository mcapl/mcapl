package ail.tracing.explanations;

import ail.syntax.Predicate;
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
		switch (event.getBase()) {
		case "beliefs":
			return "belief(s)";
		case "goals":
			return "goal(s)";
		case "inbox":
		case "outbox":
			return "message(s)";
		default:
			return "";
		}
	}

	private String getAdded(final PredicateDescriptions descriptions) {
		final StringBuilder s = new StringBuilder();
		boolean first = true;
		for (final Predicate p : event.getAdded()) {
			if (first) {
				first = false;
			} else {
				s.append(", ");
			}
			s.append(p.toString(descriptions));
		}
		return s.toString();
	}

	private String getActionDescriptor() {
		switch (event.getBase()) {
		case "beliefs":
		case "goals":
			return "added";
		case "inbox":
			return "received";
		case "outbox":
			return "sent";
		default:
			return "";
		}
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append("the ").append(getPredicateDescriptor()).append(" ").append(inCourier(getAdded(descriptions)))
				.append(" were ").append(getActionDescriptor());
		switch (level) {
		case FINEST:
			string.append(" in state ").append(this.state);
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(" as part of ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
