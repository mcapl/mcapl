package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.AILAnnotation;
import ail.syntax.Goal;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;

public class ModificationAction {
	private final int base;
	private final String selector;
	private final List<Predicate> added;
	private final List<Predicate> removed;

	public ModificationAction(final BaseType base, final String selector, final List<Predicate> added,
			final List<Predicate> removed) {
		this.base = base.ordinal();
		this.selector = selector;
		this.added = added;
		this.removed = removed;
	}

	public ModificationAction(final BaseType base, final String selector, final Predicate added,
			final Predicate removed) {
		this.base = base.ordinal();
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (added != null) {
			this.added.add(added);
		}
		this.removed = (removed == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (removed != null) {
			this.removed.add(removed);
		}
	}

	public BaseType getBase() {
		return BaseType.values()[this.base];
	}

	public List<Predicate> getAdded() {
		return this.added;
	}

	public List<Predicate> getRemoved() {
		return this.removed;
	}

	public void execute(final AILAgent agent, final boolean reverse) {
		StringTerm n = (selector == null) ? null : new StringTermImpl(selector);
		switch (getBase()) {
		case BELIEFS:
			for (Predicate add : added) {
				Literal bel = (Literal) add;
				if (reverse) {
					agent.delBel(n, bel);
				} else {
					AILAnnotation annot = bel.getAnnot();
					bel.setAnnot(null);
					agent.addBel(bel, annot, selector);
				}
			}
			for (Predicate rem : removed) {
				Literal bel = (Literal) rem;
				if (reverse) {
					AILAnnotation annot = bel.getAnnot();
					bel.setAnnot(null);
					agent.addBel(bel, annot, selector);
				} else {
					agent.delBel(n, bel);
				}
			}
			break;
		case GOALS:
			for (Predicate add : added) {
				Goal goal = (Goal) add;
				if (reverse) {
					agent.removeGoal(goal);
				} else {
					agent.addGoal(goal);
				}
			}
			for (Predicate rem : removed) {
				Goal goal = (Goal) rem;
				if (reverse) {
					agent.addGoal(goal);
				} else {
					agent.removeGoal(goal);
				}
			}
			break;
		case INBOX:
			// TODO: will require new functions in AILAgent
			break;
		case OUTBOX:
			// TODO: will require new functions in AILAgent
			break;
		}
	}

	@Override
	public String toString() { // FIXME
		StringBuilder builder = new StringBuilder();
		if (added != null && !added.isEmpty()) {
			builder.append("added ").append(added).append(" to ");
		}
		if (removed != null && !removed.isEmpty()) {
			if (builder.length() > 0) {
				builder.append(" and ");
			}
			builder.append("removed ").append(removed).append(" from ");
		}
		builder.append("the agent's ").append(getBase().toString().toLowerCase());
		if (selector != null && !selector.isEmpty()) {
			builder.append(" (").append(selector).append(")");
		}
		builder.append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = this.base;
		result = prime * result + ((this.selector == null) ? 0 : this.selector.hashCode());
		result = prime * result + ((this.added == null) ? 0 : this.added.hashCode());
		result = prime * result + ((this.removed == null) ? 0 : this.removed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof ModificationAction)) {
			return false;
		}
		ModificationAction other = (ModificationAction) obj;
		if (this.base != other.base) {
			return false;
		}
		if (this.selector == null) {
			if (other.selector != null) {
				return false;
			}
		} else if (!this.selector.equals(other.selector)) {
			return false;
		}
		if (this.added == null) {
			if (other.added != null) {
				return false;
			}
		} else if (!this.added.equals(other.added)) {
			return false;
		}
		if (this.removed == null) {
			if (other.removed != null) {
				return false;
			}
		} else if (!this.removed.equals(other.removed)) {
			return false;
		}
		return true;
	}
}
