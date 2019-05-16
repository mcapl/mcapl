package gwendolen.tracing.explanations;

import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class SelectPlanReason extends AbstractReason {
	private final SelectPlanEvent event;
	// private GeneratePlansReason parent;
	private GuardReason guard;
	private CreateIntentionReason crei = null;
	private ModifyIntentionReason add = null;

	public SelectPlanReason(final int state, final SelectPlanEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public SelectPlanEvent getEvent() {
		return this.event;
	}

	public void setParent(final GuardReason parent) {
		this.guard = parent;
	//	this.parent = parent;
	}

	@Override
	public GuardReason getParent() {
		return this.guard;
	}
	
	public void setParent2(CreateIntentionReason c) {
		crei = c;
	}
	
	public void setParent2(ModifyIntentionReason add) {
		this.add = add;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append(inCourier(this.event.getPlan()));
		switch(level) {
		case FINEST:
			string.append(" was selected in state ").append(this.state);
			if (this.guard != null) {
			//	string.append(", because it was included in ").append(this.parent.getExplanation(level, descriptions));
				string.append(this.guard.getExplanation(level, descriptions));
				string.append(" and ");
				if (crei != null) {
					string.append(this.crei.getExplanation(level, descriptions));
				} else {
					string.append(this.add.getExplanation(level, descriptions));
				}
			}
			break;
		default:
			string.append(" was selected in state ").append(this.state);
			if (this.guard != null) {
				string.append(" because ");
				if (!this.guard.getEvent().isContinuation() && !this.guard.getEvent().getGuard().isTrivial()) {
					string.append(this.guard.toString());
					// string.append(" held");
					string.append(" and ");
				}
				if (crei != null) {
					string.append(this.crei.toString(descriptions));
				} else {
					string.append(this.add.toString(descriptions) + " in state " + this.add.state);
				}
			}
		}
		if (this.guard == null) {
			string.append(".");
		}
		return string.toString();
	}
}
