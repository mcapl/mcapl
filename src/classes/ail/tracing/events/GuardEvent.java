package ail.tracing.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;
import ail.syntax.Intention;
import ail.syntax.Unifier;

public class GuardEvent extends AbstractEvent {
	private final Intention forIntention;
	private final ApplicablePlan forPlan;
	private final Guard guard;
	private final List<Unifier> solutions;

	public GuardEvent(final Intention forIntention, final ApplicablePlan forPlan, final Guard guard,
			final List<Unifier> solutions) {
		this.forIntention = forIntention.clone();
		this.forPlan = forPlan;
		this.guard = (guard == null) ? null : guard.clone();
		this.solutions = solutions;
	}

	public Intention getIntention() {
		return this.forIntention;
	}

	public ApplicablePlan getPlan() {
		return this.forPlan;
	}

	public Guard getGuard() {
		return this.guard;
	}

	public List<Unifier> getSolutions() {
		return Collections.unmodifiableList(this.solutions);
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(2);
		// TODO: probably not only atoms in there?
		if (guard != null && guard.getLHS() instanceof GuardAtom<?>) {
			data.add(((GuardAtom<?>) guard.getLHS()).getPredicateIndicator().toString());
		}
		if (guard != null && guard.getRHS() instanceof GuardAtom<?>) {
			data.add(((GuardAtom<?>) guard.getRHS()).getPredicateIndicator().toString());
		}
		if (data.isEmpty()) {
			data.add("True/0");
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// nothing to do here...
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (guard == null) {
			builder.append("continued the plan ").append(forPlan.getID());
		} else {
			builder.append("evaluated the guard of plan ").append(forPlan.getID()).append(" '").append(guard)
					.append("': ").append(solutions);
		}
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.guard.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof GuardEvent)) {
			return false;
		}
		GuardEvent other = (GuardEvent) obj;
		return (this.guard == other.guard);
	}
}
