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
	public final static int FOR_EVENT = 1;
	public final static int NO_APPLICABLE_PLANS = 2;
	public final static int NO_APPLICABLE_PLANS_FOR_GOAL = 3;

	private final List<ApplicablePlan> plans;
	private final int category;

	public GeneratePlansEvent(final List<ApplicablePlan> plans, final int category) {
		this.plans = plans;
		this.category = category;
	}

	public List<ApplicablePlan> getPlans() {
		return Collections.unmodifiableList(plans);
	}

	public String getCategory() {
		switch (this.category) {
		case FOR_EVENT:
			return "for an event";
		case NO_APPLICABLE_PLANS:
			return "because there were no applicable plans";
		case NO_APPLICABLE_PLANS_FOR_GOAL:
			return "because there were no applicable plans for a goal";
		default:
			return "";
		}
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
		builder.append(" ").append(getCategory()).append(".");
		return builder.toString();
	}
}
