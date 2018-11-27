package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link ApplicablePlan} has been selected.
 */
public class SelectPlanEvent extends AbstractEvent {
	private final ApplicablePlan plan;

	public SelectPlanEvent(final ApplicablePlan plan) {
		this.plan = plan;
	}

	public ApplicablePlan getPlan() {
		return this.plan;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new ArrayList<>(1);
		data.add("plan " + plan.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		StringBuilder builder = new StringBuilder();
		builder.append("selected ").append(plan).append(".");
		return builder.toString();
	}
}