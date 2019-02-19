package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link ApplicablePlan} has been selected.
 */
public class SelectPlanEvent extends AbstractEvent {
	private final ApplicablePlan plan;
	private final int i_id;

	public SelectPlanEvent(final ApplicablePlan plan, final int intentionID) {
		this.plan = plan;
		this.i_id = intentionID;
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
	
	public boolean isContinue() {
		return (plan.getID() == 0);
	}
	
	public boolean contains(Deed d) {
		ArrayList<Deed> deeds = plan.getPrefix();
		if (deeds.contains(d))  return true;
		return false;
	}
	
	public int getIID() {
		return i_id;
	}
}