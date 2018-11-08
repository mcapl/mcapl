package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Predicate;

public class ModificationEvent extends AbstractEvent {
	private final ModificationAction update;

	public ModificationEvent(final ModificationAction update) {
		this.update = update;
	}

	public ModificationAction getUpdate() {
		return this.update;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> result = new ArrayList<>(this.update.getAdded().size() + this.update.getRemoved().size());
		for (final Predicate add : this.update.getAdded()) {
			result.add(add.getPredicateIndicator().toString());
		}
		for (final Predicate rem : this.update.getRemoved()) {
			result.add(rem.getPredicateIndicator().toString());
		}
		return result;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		this.update.execute(agent, reverse);
	}

	@Override
	public String getDescription() {
		return toString();
	}

	public String toString() {
		return this.update.toString();
	}

	@Override
	public int hashCode() {
		return (this.update == null) ? 0 : this.update.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof ModificationEvent)) {
			return false;
		}
		ModificationEvent other = (ModificationEvent) obj;
		if (this.update == null) {
			if (other.update != null) {
				return false;
			}
		} else if (!this.update.equals(other.update)) {
			return false;
		}
		return true;
	}
}
