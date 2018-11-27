package ail.tracing.events;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * A {@link Guard} has been evaluated (resulting in a possible empty list of
 * {@link Unifier}s). We keep track of the intention and plan this guard was
 * relevant for as well in order to be able to link to related events in
 * explanations. The continuation of a plan is a special case that for
 * simplicity is modelled as a GuardEvent as well (but explicitly marked).
 */
public class GuardEvent extends AbstractEvent {
	private final Intention forIntention;
	private final ApplicablePlan forPlan;
	private final Guard guard;
	private final List<Unifier> solutions;
	private final boolean continuation;

	public GuardEvent(final Intention forIntention, final ApplicablePlan forPlan, final Guard guard,
			final List<Unifier> solutions, final boolean continuation) {
		this.forIntention = forIntention.clone();
		this.forPlan = forPlan;
		this.guard = guard.clone();
		this.solutions = solutions;
		this.continuation = continuation;
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

	public boolean isContinuation() {
		return this.continuation;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new LinkedList<>();
		for (final GuardAtom<?> atom : guard.getAllAtoms()) {
			if (!atom.isVar()) {
				data.add(atom.getPredicateIndicator().toString());
			}
		}
		if (data.isEmpty()) {
			data.add("True/0");
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		if (continuation) {
			builder.append("confirmed ").append(forIntention).append(" can still be processed");
		} else {
			builder.append("evaluating the guard of ").append(forPlan).append(" resulted in ");
			if (solutions.isEmpty()) {
				builder.append("False");
			} else if (solutions.size() == 1) {
				final Unifier solution = solutions.get(0);
				builder.append((solution.size() == 0) ? "True" : solution);
			} else {
				builder.append(solutions);
			}
		}
		builder.append(".");
		return builder.toString();
	}
}
