package ail.tracing.events;

import java.util.LinkedList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Event;
import ail.syntax.Intention;

public class CreateIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public CreateIntentionEvent(final Intention intention) {
		this.intention = intention.clone();
	}

	public Intention getIntention() {
		return this.intention;
	}

	public Event getEvent() {
		List<Event> events = this.intention.events();
		return (events.isEmpty()) ? null : this.intention.events().get(0);
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new LinkedList<>();
		data.add("intention " + intention.getID());
		for (Event event : intention.events()) {
			data.add(event.getPredicateIndicator().toString());
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
		Event event = getEvent();
		if (event != null) {
			builder.append("for the event '").append(event).append("', ");
		}
		builder.append("created ").append(intention).append(".");
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
		} else if (obj == null || !(obj instanceof CreateIntentionEvent)) {
			return false;
		}
		CreateIntentionEvent other = (CreateIntentionEvent) obj;
		return (this.intention == other.intention);
	}
}