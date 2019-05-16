package gwendolen.tracing.explanations;

import java.util.List;

import ail.syntax.Unifier;
import ail.tracing.events.GuardEvent;
import ail.tracing.explanations.AbstractGuardReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class GuardReason extends AbstractGuardReason {
	private final GuardEvent event;
	private SelectIntentionReason parent;

	public GuardReason(final int state, final GuardEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public GuardEvent getEvent() {
		return this.event;
	}

	public void setParent(final SelectIntentionReason parent) {
		this.parent = parent;
	}

	@Override
	public SelectIntentionReason getParent() {
		return this.parent;
	}

	private String solutions() {
		final List<Unifier> solutions = this.event.getSolutions();
		if (solutions.isEmpty()) {
			return "False";
		} else if (solutions.size() == 1) {
			final Unifier solution = solutions.get(0);
			return (solution.size() == 0) ? "True" : solution.toString();
		} else {
			return solutions.toString();
		}
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			if (event.isContinuation()) {
				string.append("it was continued in state ").append(this.state);
			} else {
				string.append("its guard ").append(inCourier(this.event.getGuard().toString(descriptions)));
				if (!solutions().equals("True")) {
					string.append(" held with possible solution(s) ").append(inCourier(solutions()));
				} else {
					string.append(" held ");
				}
			}
			if (this.parent != null) {
				string.append(", ");
				if (!event.isContinuation()) {
					string.append("which was evaluated ");
				}
				string.append("because ").append(this.parent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (!event.isContinuation()) {
				string.append("of which the guard ").append(inCourier(this.event.getGuard().toString(descriptions)));
				string.append(" held with possible solution(s) ").append(inCourier(solutions()));
			}
			if (this.parent != null) {
				if (!event.isContinuation()) {
					string.append(", and ");
				}
				string.append(this.parent.getExplanation(level, descriptions));
			}
			break;
		}
		if (this.parent == null) {
			// string.append(".");
		}
		return string.toString();
	}
}
