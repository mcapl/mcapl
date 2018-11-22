package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;

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
		builder.append("selected ").append(plan).append(".");
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