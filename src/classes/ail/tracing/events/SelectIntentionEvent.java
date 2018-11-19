package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Intention;

public class SelectIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public SelectIntentionEvent(final Intention intention) {
		this.intention = intention; // TODO: is clone needed here?
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(1);
		data.add("intention " + intention.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// TODO: no nice descriptor available for intentions?
		// (same problem in CreateIntentionEvent)
		builder.append("selected intention ").append(intention.getID()).append(".");
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
		} else if (obj == null || !(obj instanceof SelectIntentionEvent)) {
			return false;
		}
		SelectIntentionEvent other = (SelectIntentionEvent) obj;
		return (this.intention == other.intention);
	}
}