package ail.tracing.events;

import java.util.LinkedList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Intention} has been created (based upon a certain {@link Event}).
 */
public class CreateIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public CreateIntentionEvent(final Intention intention) {
		this.intention = intention.clone();
	}

	public Intention getIntention() {
		return this.intention;
	}

	public Event getEvent() {
		final List<Event> events = this.intention.events();
		return (events.isEmpty()) ? null : this.intention.events().get(0);
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new LinkedList<>();
		data.add("intention " + intention.getID());
		for (final Event event : intention.events()) {
			data.add(event.getPredicateIndicator().toString());
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		StringBuilder builder = new StringBuilder();
		Event event = getEvent();
		if (event != null) {
			builder.append("for the event '").append(event.toString(descriptions)).append("', ");
		}
		builder.append("created ").append(intention).append(".");
		return builder.toString();
	}
}