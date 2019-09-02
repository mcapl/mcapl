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
package ail.tracing.explanations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.tracing.EventStorage;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.ActionEvent;
import ail.tracing.events.ModificationEvent;
import ail.util.Tuple;

public class WhyQuestionsBase {
	protected final EventStorage storage;
	private Set<Tuple<Predicate, Integer>> beliefs;
	private List<Tuple<Predicate, Integer>> goals;
	private Set<Tuple<Action, Integer>> actions;
	
	public WhyQuestionsBase(final EventStorage storage) {
		this.storage = storage;
		process();
	}
	
	/**
	 * @return All beliefs (instantiated or not) that can be found in the trace,
	 *         either queried or actually believed at some point. Call
	 *         {@link #process()} first to update the returned beliefs.
	 */
	public Set<Tuple<Predicate, Integer>> getAllBeliefs() {
		return Collections.unmodifiableSet(this.beliefs);
	}

	/**
	 * @return All goals (instantiated or not) that can be found in the trace,
	 *         either queried or actually to be achieved at some point. Call
	 *         {@link #process()} first to update the returned goals.
	 */
	public List<Tuple<Predicate, Integer>> getAllGoals() {
		return Collections.unmodifiableList(this.goals);
	}

	/**
	 * @return All actions (instantiated or not) that can be found in the trace,
	 *         either tried or actually executed at some point. Call
	 *         {@link #process()} first to update the returned actions.
	 */
	public Set<Tuple<Action, Integer>> getAllActions() {
		return Collections.unmodifiableSet(this.actions);
	}

	/**
	 * Call this to update the info returned by {@link #getAllActions()},
	 * {@link #getAllBeliefs()}, and {@link #getAllGoals()}.
	 */
	public void process() {
		this.beliefs = new LinkedHashSet<>();
		this.goals = new ArrayList<>();
		this.actions = new LinkedHashSet<>();
		int step = 0;
		for (final AbstractEvent event : this.storage.getAll()) {
			if (event instanceof ModificationEvent) {
				final ModificationEvent modification = (ModificationEvent) event;
				switch (modification.getBase()) {
				case "beliefs":
					for (Predicate bel : modification.getAdded()) {
						if (bel instanceof PredicatewAnnotation) {
							bel = new Predicate(bel);
						}
						this.beliefs.add(new Tuple(bel, step));
					}
					break;
				case "goals":
					for (Predicate goal : modification.getAdded()) {
						if (goal instanceof PredicatewAnnotation) {
							goal = new Predicate(goal);
						}
						this.goals.add(new Tuple(goal, step));
					}
					break;
				default:
					break;
				}
			} else if (event instanceof ActionEvent) {
				final Action executed = ((ActionEvent) event).getAction();
				if (executed != null) {
					this.actions.add(new Tuple(executed, step));
				}
			}
			step++;
		}
	}

	public AbstractReason whyAction(final Action action, int tindex) {
		return new EmptyReason(tindex);
	}

	public AbstractReason whyBelief(final Predicate belief, int n) {
		return new EmptyReason(n);
	}

	public AbstractReason whyGoal(final Predicate goal, int n) {
		return new EmptyReason(n);
	}
	
	public PredicateDescriptions getDescriptions() {
		return this.storage.getDescriptions();
	}



}
