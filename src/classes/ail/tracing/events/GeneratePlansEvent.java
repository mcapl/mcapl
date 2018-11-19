package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Unifier;

public class GeneratePlansEvent extends AbstractEvent {
	private final List<ApplicablePlan> plans;

	public GeneratePlansEvent(final List<ApplicablePlan> plans) {
		this.plans = plans;
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(plans.size());
		for (ApplicablePlan plan : plans) {
			data.add("plan " + plan.getID());
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// TODO: improve (plan details? same problem in SelectPlanEvent)
		builder.append("generated ").append(plans.size()).append(" applicable plan(s): ");
		boolean first = true;
		for (ApplicablePlan plan : plans) {
			if (first) {
				first = false;
			} else {
				builder.append(", ");
			}
			builder.append("plan ").append(plan.getID());
			Unifier u = plan.getUnifier();
			if (u.size() > 0) {
				builder.append(" with ").append(plan.getUnifier());
			}
		}
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.plans.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof GeneratePlansEvent)) {
			return false;
		}
		GeneratePlansEvent other = (GeneratePlansEvent) obj;
		return (this.plans == other.plans);
	}
}
