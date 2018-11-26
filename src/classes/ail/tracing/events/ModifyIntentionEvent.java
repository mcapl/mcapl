package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.tracing.explanations.PredicateDescriptions;

public class ModifyIntentionEvent extends AbstractEvent {
	public static int DELETE_TOP_DEEDS = 1;
	public static int MERGE_PLAN = 2;

	private final Intention intention;
	private final int category;
	private final ApplicablePlan plan;

	public ModifyIntentionEvent(final Intention intention, final int category, final ApplicablePlan plan) {
		this.intention = intention.clone();
		this.category = category;
		this.plan = plan;
	}

	public Intention getIntention() {
		return this.intention;
	}

	public int getCategory() {
		return this.category;
	}

	public ApplicablePlan getPlan() {
		return this.plan;
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(1);
		data.add("intention " + intention.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		StringBuilder builder = new StringBuilder();
		if (category == DELETE_TOP_DEEDS) {
			builder.append("modified intention by removing top of intention to become ").append(intention);
		} else if (category == MERGE_PLAN) {
			builder.append("modified intention by replacing top with selected plan to become ").append(intention);
		}
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.intention.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof ModifyIntentionEvent)) {
			return false;
		}
		ModifyIntentionEvent other = (ModifyIntentionEvent) obj;
		return (this.intention == other.intention);
	}
}