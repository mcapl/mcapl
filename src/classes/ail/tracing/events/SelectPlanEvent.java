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

	@Override
	public List<String> getLookupData() {
		return new ArrayList<>(0);
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// TODO: plans with ID 0 seem generated, otherwise it's from the code...
		builder.append("selected plan ").append(plan.getID()).append(".");
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