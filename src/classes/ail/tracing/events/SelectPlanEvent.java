package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Unifier;

public class SelectPlanEvent extends AbstractEvent {
	private final ApplicablePlan plan;

	public SelectPlanEvent(final ApplicablePlan plan) {
		this.plan = plan;
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(1);
		data.add("plan " + plan.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// TODO: how to nicely describe plans? same in GeneratePlansEvent
		builder.append("selected plan ").append(plan.toString());
		Unifier u = plan.getUnifier();
		if (u.size() > 0) {
			builder.append(" with ").append(plan.getUnifier());
		}
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.plan.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof SelectPlanEvent)) {
			return false;
		}
		SelectPlanEvent other = (SelectPlanEvent) obj;
		return (this.plan == other.plan);
	}
}