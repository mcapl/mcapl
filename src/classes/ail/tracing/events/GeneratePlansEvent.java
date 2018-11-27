package ail.tracing.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * The list of current {@link ApplicablePlans} has been finalized.
 */
public class GeneratePlansEvent extends AbstractEvent {
	private final List<ApplicablePlan> plans;

	public GeneratePlansEvent(final List<ApplicablePlan> plans) {
		this.plans = plans;
	}

	public List<ApplicablePlan> getPlans() {
		return Collections.unmodifiableList(plans);
	}

	public List<Integer> getPlanIDs() {
		final List<Integer> IDs = new ArrayList<>(plans.size());
		for (final ApplicablePlan plan : plans) {
			IDs.add(plan.getID());
		}
		return IDs;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new ArrayList<>(plans.size());
		for (final ApplicablePlan plan : plans) {
			data.add("plan " + plan.getID());
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("generated ").append(plans.size()).append(" applicable plan(s): ");
		boolean first = true;
		for (final ApplicablePlan plan : plans) {
			if (first) {
				first = false;
			} else {
				builder.append(", ");
			}
			builder.append(plan);
		}
		builder.append(".");
		return builder.toString();
	}
}
