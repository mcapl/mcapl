package ail.tracing.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;

public class GeneratePlansEvent extends AbstractEvent {
	private final List<ApplicablePlan> plans;

	public GeneratePlansEvent(final List<ApplicablePlan> plans) {
		this.plans = plans;
	}

	public List<ApplicablePlan> getPlans() {
		return Collections.unmodifiableList(plans);
	}

	public List<Integer> getPlanIDs() {
		List<Integer> IDs = new ArrayList<>(plans.size());
		for (ApplicablePlan plan : plans) {
			IDs.add(plan.getID());
		}
		return IDs;
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
		builder.append("generated ").append(plans.size()).append(" applicable plan(s): ").append(plans).append(".");
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
