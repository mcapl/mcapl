package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;

public class GuardEvent extends AbstractEvent {
	private final Guard guard;

	public GuardEvent(final Guard guard) {
		this.guard = guard; // TODO: is clone needed here?
	}

	@Override
	public List<String> getLookupData() {
		List<String> data = new ArrayList<>(2);
		// TODO: probably not only atoms in there?
		if (guard.getLHS() == null) {
			data.add("True");
		} else if (guard.getLHS() instanceof GuardAtom<?>) {
			data.add(((GuardAtom<?>) guard.getLHS()).getPredicateIndicator().toString());
		}
		if (guard.getRHS() == null) {
			data.add("True");
		} else if (guard.getRHS() instanceof GuardAtom<?>) {
			data.add(((GuardAtom<?>) guard.getRHS()).getPredicateIndicator().toString());
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		// nothing to do here...
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("evaluated the guard ").append(guard).append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.guard.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof GuardEvent)) {
			return false;
		}
		GuardEvent other = (GuardEvent) obj;
		return (this.guard == other.guard);
	}
}
