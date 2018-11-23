package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Intention;

public class ModifyIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public ModifyIntentionEvent(final Intention intention) {
		this.intention = intention.clone();
	}

	public Intention getIntention() {
		return this.intention;
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
	public String toString() { // TODO: not always clear what changed?
		StringBuilder builder = new StringBuilder();
		builder.append("modified ").append(intention).append(".");
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