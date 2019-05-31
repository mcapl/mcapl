// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ail.semantics.operationalrules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;

import ail.mas.AILEnv;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.tracing.events.ModificationEvent;


/**
 * Perception rule.  Gets a list of all literals the agent can perceive from the
 * environment.  It all gets a list of things the agent believes it can perceive
 * from the agent and compares the two.  Any discrepancies applied directly to the
 * belief base.  Also gets messages from the environment and adds to inbox.
 * 
 * @author lad
 *
 */
public class DirectPerception implements OSRule {
	private final static String name = "Direct Perception";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return ! (a.getEnv().agentIsUpToDate(a.getAgName()));
	}
			
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		AILEnv env = a.getEnv();
		Set<Predicate> percepts = env.getPercepts(a.getAgName(), true);
		Set<Message> messages = env.getMessages(a.getAgName());
		
			
		// if percepts == null then there is no change in the agent's perceptions.
		// System.err.println(percepts);
		if (percepts != null) {
			// First work through the agents current perceptions.
			// Remove any no longer perceived.
			// Any literal in percepts which was previously perceived, discard to avoid duplication.
			Iterator<Literal> percept_iterator = a.getBB().getPercepts();
			Set<Literal> removed_percepts = new TreeSet<Literal>();
			while (percept_iterator.hasNext()) {
				Literal l = percept_iterator.next();
				if (! percepts.contains(l)) {		
					if (a.delBel(l) && a.shouldTrace()) {
						a.trace(new ModificationEvent(ModificationEvent.BELIEFS, null, null, l));
					}
					a.tellawake();
					removed_percepts.add(l);
				} else {
					percepts.remove(l);
				}
			}
		
			// Add all the remaining perceptions (i.e., the new ones) as intentions.
			boolean additions = false;
			for (Predicate l : percepts) {
				Predicate k = (Predicate) l.clone();
				additions = true;
				Literal add = new Literal(k);
				if (a.addBel(add, AILAgent.refertopercept()) && a.shouldTrace()) {
					a.trace(new ModificationEvent(ModificationEvent.BELIEFS, null, add, null));
				}
				a.tellawake();
			}
			
			if (additions) {
				for (Intention i: a.getIntentions()) {
					i.unsuspendFor(percepts, removed_percepts);
				}
			}

		}
		
		Set<Message> previous = new TreeSet<>(a.getInbox());
		Set<Message> msglist = new TreeSet<>(messages);
		Set<Message> addList = Sets.difference(msglist, previous);
		a.newMessages(msglist);
		if (!addList.isEmpty() && a.shouldTrace()) {
			List<Predicate> predicates = new ArrayList<>(addList.size());
			for (Message msg : addList) {
				predicates.add(msg.toTerm());
			}
			a.trace(new ModificationEvent(ModificationEvent.INBOX, null, predicates, null));
		}
	}
} 