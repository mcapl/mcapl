package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Intention} has been modified; either its top deed has been deleted,
 * or a plan has been added as its top deed.
 */
public class ModifyIntentionEvent extends AbstractEvent {
	public static final int DELETE_TOP_DEEDS = 1;
	public static final int MERGE_PLAN = 2;
	public static final int POST_EVENT = 3;

	private final Intention intention;
	private final int category;
	private final ApplicablePlan plan; // TODO: currently unused

	/**
	 * @param intention The intention that has been modified.
	 * @param category  A constant from this class, indicating the kind of
	 *                  modication that happened.
	 * @param plan      The plan directly relevant to the modification.
	 */
	public ModifyIntentionEvent(final Intention intention, final int category, final ApplicablePlan plan) {
		this.intention = intention.clone();
		this.category = category;
		this.plan = plan;
	}

	public ModifyIntentionEvent(final Intention intention, final int category) {
		this.intention = intention.clone();
		this.category = category;
		this.plan = null;
	}

	public Intention getIntention() {
		return this.intention;
	}

	public String getCategory() {
		switch (this.category) {
		case DELETE_TOP_DEEDS:
			return "removing the top of the intention";
		case MERGE_PLAN:
			return "replacing the top of the intention with the selected plan";
		case POST_EVENT:
			return "posting an event";
		default:
			return "";
		}
	}

	public ApplicablePlan getPlan() {
		return this.plan;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new ArrayList<>(1);
		data.add("intention " + intention.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("modified intention by ").append(getCategory());
		builder.append(" to become ").append(intention).append(".");
		return builder.toString();
	}
	
	public Event getEvent() {
		final List<Event> events = this.intention.events();
		return (events.isEmpty()) ? null : this.intention.events().get(0);
	}
}