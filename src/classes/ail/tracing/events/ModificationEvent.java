// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.AILAnnotation;
import ail.syntax.Goal;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * One or more {@link Predicate}s have been added or removed from a certain base
 * (i.e. beliefs, goals, inbox or outbox). Supports base selectors as well. This
 * event should resemble an actual modification; e.g. adding a belief that
 * already exists (and is thus not inserted) should NOT be a ModificationEvent.
 */
public class ModificationEvent extends AbstractEvent {
	public static final int BELIEFS = 1;
	public static final int GOALS = 2;
	public static final int INBOX = 3;
	public static final int OUTBOX = 4;

	private final int base;
	private final String selector;
	private final List<Predicate> added;
	private final List<Predicate> removed;
	private boolean initial = false;
	private int intention_id;

	/**
	 * @param base     A constant from this class, indicating which base was
	 *                 modified
	 * @param selector An optional base-selector (can be null)
	 * @param added    The list of predicates that were added (if any; null
	 *                 otherwise)
	 * @param removed  The list of predicates that were removed (if any; null
	 *                 otherwise)
	 */
	public ModificationEvent(final int base, final String selector, final List<Predicate> added,
			final List<Predicate> removed) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : added;
		this.removed = (removed == null) ? new ArrayList<>(0) : removed;
		// this.intention_id = intention_id;
	}

	public ModificationEvent(final int intention_id, final int base, final String selector, final List<Predicate> added,
			final List<Predicate> removed) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : added;
		this.removed = (removed == null) ? new ArrayList<>(0) : removed;
		this.intention_id = intention_id;
	}
	
	public ModificationEvent(final int base, final String selector, final List<Predicate> added,
			final List<Predicate> removed, boolean start) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : added;
		this.removed = (removed == null) ? new ArrayList<>(0) : removed;
		this.initial = start;
	}


	/**
	 * Convience constructor for single-item modifications.
	 * 
	 * @param base     A constant from this class, indicating which base was
	 *                 modified
	 * @param selector An optional base-selector (can be null)
	 * @param added    The predicate that was added (if any; null otherwise)
	 * @param removed  The predicate that was removed (if any; null otherwise)
	 */
	public ModificationEvent(final int base, final String selector, final Predicate added, final Predicate removed) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (added != null) {
			this.added.add(added);
		}
		this.removed = (removed == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (removed != null) {
			this.removed.add(removed);
		}
		// this.intention_id = intention_id;
	}

	public ModificationEvent(final int intention_id, final int base, final String selector, final Predicate added, final Predicate removed) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (added != null) {
			this.added.add(added);
		}
		this.removed = (removed == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (removed != null) {
			this.removed.add(removed);
		}
		this.intention_id = intention_id;
	}

	public ModificationEvent(final int base, final String selector, final Predicate added, final Predicate removed, boolean start) {
		this.base = base;
		this.selector = selector;
		this.added = (added == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (added != null) {
			this.added.add(added);
		}
		this.removed = (removed == null) ? new ArrayList<>(0) : new ArrayList<>(1);
		if (removed != null) {
			this.removed.add(removed);
		}
		this.initial = start;
	}

	
	public String getBase() {
		switch (this.base) {
		case BELIEFS:
			return "beliefs";
		case GOALS:
			return "goals";
		case INBOX:
			return "inbox";
		case OUTBOX:
			return "outbox";
		default:
			return "";
		}
	}
	
	public boolean isInitial() {
		return initial;
	}

	public List<Predicate> getAdded() {
		return this.added;
	}

	public List<Predicate> getRemoved() {
		return this.removed;
	}
	
	public int getIID() {
		return intention_id;
	}

	/**
	 * @param predicate
	 * @param positive  If true we only try to match added predicates; if false we
	 *                  only try to match removed predicates.
	 * @return True iff the modification involved the given predicate. Annotations
	 *         are ignored in this check.
	 */
	public boolean contains(Predicate predicate, final boolean positive) {
		if (predicate instanceof PredicatewAnnotation) {
			predicate = new Predicate(predicate);
		}
		final List<Predicate> predicates = positive ? this.added : this.removed;
		for (Predicate added : predicates) {
			if (added instanceof PredicatewAnnotation) {
				added = new Predicate(added);
			}
			if (added.match(predicate, new Unifier())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> result = new ArrayList<>(this.added.size() + this.removed.size());
		for (final Predicate add : this.added) {
			result.add(add.getPredicateIndicator().toString());
		}
		for (final Predicate rem : this.removed) {
			result.add(rem.getPredicateIndicator().toString());
		}
		return result;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
		final StringTerm n = (selector == null) ? null : new StringTermImpl(selector);
		switch (base) {
		case BELIEFS:
			for (Predicate add : added) {
				final Literal bel = (Literal) add;
				if (reverse) {
					agent.delBel(n, bel);
				} else {
					final AILAnnotation annot = bel.getAnnot();
					bel.setAnnot(null);
					agent.addBel(bel, annot, selector);
				}
			}
			for (final Predicate rem : removed) {
				final Literal bel = (Literal) rem;
				if (reverse) {
					final AILAnnotation annot = bel.getAnnot();
					bel.setAnnot(null);
					agent.addBel(bel, annot, selector);
				} else {
					agent.delBel(n, bel);
				}
			}
			break;
		case GOALS:
			for (final Predicate add : added) {
				final Goal goal = (Goal) add;
				if (reverse) {
					agent.removeGoal(goal);
				} else {
					agent.addGoal(goal);
				}
			}
			for (final Predicate rem : removed) {
				final Goal goal = (Goal) rem;
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
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		if (added != null && !added.isEmpty()) {
			builder.append("added ");
			boolean first = true;
			for (Predicate add : added) {
				if (first) {
					first = false;
				} else {
					builder.append(", ");
				}
				builder.append(add.toString(descriptions));
			}
			builder.append(" to ");
		}
		if (removed != null && !removed.isEmpty()) {
			if (builder.length() > 0) {
				builder.append(" and ");
			}
			builder.append("removed ");
			boolean first = true;
			for (Predicate rem : removed) {
				if (first) {
					first = false;
				} else {
					builder.append(", ");
				}
				builder.append(rem.toString(descriptions));
			}
			builder.append(" from ");
		}
		builder.append("the agent's ").append(getBase());
		if (selector != null && selector.length() > 2) { // not just quotes
			builder.append(" (").append(selector).append(")");
		}
		builder.append(".");
		return builder.toString();
	}
}
