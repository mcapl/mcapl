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

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.EventTable;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * The base class for all tracing events.
 */
public abstract class AbstractEvent {
	@SuppressWarnings("unchecked")
	public static FSTConfiguration getSerialization() {
		final FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
		conf.setForceSerializable(true); // so we don't require everything to implement Serializable
		conf.getStreamCoderFactory().getInput().set(new FSTObjectInput(conf));
		conf.getStreamCoderFactory().getOutput().set(new FSTObjectOutput(conf));
		// for optimization, we give classes that will surely be serialized here
		conf.registerClass(ActionEvent.class, Action.class, CreateIntentionEvent.class, Intention.class,
				GeneratePlansEvent.class, ApplicablePlan.class, GuardEvent.class, Guard.class, Unifier.class,
				ModificationEvent.class, ModifyIntentionEvent.class, SelectIntentionEvent.class, SelectPlanEvent.class);
		return conf;
	}

	/**
	 * @return A list of strings indicating at all related syntax objects, i.e
	 *         actions/beliefs/goals/plans/intentions, either by their ID or by
	 *         their predicate indicator. Used in the {@link EventTable}.
	 */
	abstract public List<String> getLookupData();

	/**
	 * Given a certain agent, either performs or reverses this event (if possible).
	 * 
	 * @param agent
	 * @param reverse
	 */
	abstract public void execute(final AILAgent agent, final boolean reverse);

	/**
	 * @param descriptions
	 * @return A full sentence describing the event.
	 */
	abstract public String toString(final PredicateDescriptions descriptions);

	@Override
	public final String toString() {
		return toString(new PredicateDescriptions(new ArrayList<>(0)));
	}
}
