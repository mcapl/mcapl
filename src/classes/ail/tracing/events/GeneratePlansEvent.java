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
import java.util.Collections;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ApplicablePlan;
import ail.syntax.Event;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * The list of current {@link ApplicablePlans} has been finalized.
 */
public class GeneratePlansEvent extends AbstractEvent {
	public final static int FOR_EVENT = 1;
	public final static int NO_APPLICABLE_PLANS = 2;
	public final static int NO_APPLICABLE_PLANS_FOR_GOAL = 3;

	private final List<ApplicablePlan> plans;
	private final int category;
	private Event event;
	private int iid;

	public GeneratePlansEvent(final List<ApplicablePlan> plans, final int category, int intention_id) {
		this.plans = plans;
		this.category = category;
		this.iid = intention_id;
	}
	
	public GeneratePlansEvent(final List<ApplicablePlan> plans, final int category, int intention_id, Event e) {
		this(plans, category, intention_id);
		this.event = e;
	}

	public List<ApplicablePlan> getPlans() {
		return Collections.unmodifiableList(plans);
	}
	
	public Event getEvent() {
		return event;
	}
	
	public int getIID() {
		return iid;
	}

	public String getCategory() {
		switch (this.category) {
		case FOR_EVENT:
			return "for an event";
		case NO_APPLICABLE_PLANS:
			return "because there were no applicable plans";
		case NO_APPLICABLE_PLANS_FOR_GOAL:
			return "because there were no applicable plans for a goal";
		default:
			return "";
		}
	}

	public List<Integer> getPlanIDs() {
		final List<Integer> IDs = new ArrayList<>(plans.size());
		for (final ApplicablePlan plan : plans) {
			IDs.add(plan.getID());
		}
		return IDs;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new ArrayList<>(plans.size());
		for (final ApplicablePlan plan : plans) {
			data.add("plan " + plan.getID());
		}
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("generated ").append(plans.size()).append(" applicable plan(s): ");
		boolean first = true;
		for (final ApplicablePlan plan : plans) {
			if (first) {
				first = false;
			} else {
				builder.append(", ");
			}
			builder.append(plan);
		}
		builder.append(" ").append(getCategory()).append(".");
		return builder.toString();
	}
}
