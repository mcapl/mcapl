package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Intention;

public class SetIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public SetIntentionEvent(final Intention intention) {
		this.intention = intention;
	}

	@Override
	public List<String> getLookupData() {
		return new ArrayList<>(0);
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SetIntention[");
		builder.append(intention);
		builder.append("]");
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
		} else if (obj == null || !(obj instanceof SetIntentionEvent)) {
			return false;
		}
		SetIntentionEvent other = (SetIntentionEvent) obj;
		return (this.intention == other.intention);
	}
}