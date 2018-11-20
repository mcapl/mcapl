package ail.tracing.explanations;

import java.util.LinkedList;
import java.util.List;

import ail.tracing.events.GeneratePlansEvent;

public class GeneratePlansReason extends AbstractReason {
	private final GeneratePlansEvent event;
	private GuardReason parent;

	public GeneratePlansReason(final int state, final GeneratePlansEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public GeneratePlansEvent getEvent() {
		return this.event;
	}

	public void setParent(final GuardReason parent) {
		this.parent = parent;
	}

	@Override
	public GuardReason getParent() {
		return this.parent;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder();
		List<String> plans = new LinkedList<>();
		for (Integer planID : this.event.getPlanIDs()) {
			plans.add(Integer.toString(planID));
		}
		string.append("the applicable plans generated in state ").append(this.state).append(" ").append(plans);
		if (this.parent != null) {
			string.append(", because ").append(this.parent);
		} else {
			string.append(".");
		}
		return string.toString();
	}
}
