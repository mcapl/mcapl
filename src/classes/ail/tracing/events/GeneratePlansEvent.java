package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;

public class GeneratePlansEvent extends AbstractEvent {
	private final List<ApplicablePlan> plans;

	public GeneratePlansEvent(final List<ApplicablePlan> plans) {
		this.plans = plans;
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
		// TODO: improve (plan details? same problem as SelectPlanEvent)
		builder.append("generated ").append(plans.size()).append(" applicable plans.");
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
