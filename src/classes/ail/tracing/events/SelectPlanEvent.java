package ail.tracing.events;

import java.util.LinkedList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;

public class SelectPlanEvent extends AbstractEvent {
	private final ApplicablePlan plan;

	public SelectPlanEvent(final ApplicablePlan plan) {
		this.plan = plan;
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new LinkedList<>();
		data.add(plan.getEvent().getPredicateIndicator().toString());
		for(Guard guard : plan.getGuard()) {
			if(guard.getLHS() instanceof GuardAtom<?>) {
				data.add(((GuardAtom<?>)guard.getLHS()).getPredicateIndicator().toString());
			}
			if(guard.getRHS() instanceof GuardAtom<?>) {
				data.add(((GuardAtom<?>)guard.getLHS()).getPredicateIndicator().toString());
			}
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
		builder.append("SelectPlan[");
		builder.append(plan);
		builder.append("]");
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