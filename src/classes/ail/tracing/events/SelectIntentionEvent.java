package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Intention} has been selected.
 */
public class SelectIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public SelectIntentionEvent(final Intention intention) {
		this.intention = intention.clone();
	}

	public Intention getIntention() {
		return this.intention;
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
		builder.append("selected ").append(intention).append(".");
		return builder.toString();
	}
}