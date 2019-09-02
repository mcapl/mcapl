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
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Unifier;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;
import ajpf.util.AJPFLogger;


/**
 * Perception rule.  Gets a list of all literals the agent can perceive from the
 * environment.  It all gets a list of things the agent believes it can perceive
 * from the agent and compares the two.  Any discrepancies are turned into intentions
 * to either add or delete beliefs.
 * 
 * @author lad
 *
 */
public class Perceive implements OSRule {
	private static final String name = "Perceive";
	String logname = "ail.semantics.operationalrules.Perceive";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return true;
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
		if (percepts != null) {
			List<Intention> is = a.getIntentions();

			// First work through the agents current perceptions.
			// Create an intention to remove any no longer perceived.
			// Any literal in percepts which was previously perceived, discard to avoid duplication.
			Iterator<Literal> gbi = a.getBB().getPercepts();
			while (gbi.hasNext()) {
				Literal l = gbi.next();
				if (! percepts.contains(l)) {
					ArrayList<Deed> ds = new ArrayList<Deed>();
					ArrayList<Guard> gs  = new ArrayList<Guard>();
					Unifier u = new Unifier();
				
					ds.add(new Deed(Deed.AILDeletion, Deed.AILBel, l));
					gs.add(new Guard(new GBelief()));
					Intention i = new Intention(new Event(Event.FromPercept), ds, gs, u, AILAgent.refertopercept(), a.getPrettyPrinter());
					if (! is.contains(i)) {
						is.add(i);
						if (a.shouldTrace()) {
							a.trace(new CreateIntentionEvent(i));
						}
					}
					a.tellawake();
					
				} else {
					percepts.remove(l);
				}
			}
		
			// Add all the remaining perceptions (i.e., the new ones) as intentions.
			for (Predicate l: percepts) {
				ArrayList<Deed> ds = new ArrayList<Deed>()	;
				ArrayList<Guard> gs  = new ArrayList<Guard>();
				Unifier u = new Unifier();
			
				if (AJPFLogger.ltFine(logname)) {
					AJPFLogger.fine(logname, a.getAgName() + " incoming percept " + l);
				}
				ds.add(new Deed(Deed.AILAddition, Deed.AILBel, new Literal(Literal.LPos, new PredicatewAnnotation((Predicate) l))));
				gs.add(new Guard(new GBelief()));
				Intention i = new Intention(new Event(Event.FromPercept), ds, gs, u, AILAgent.refertopercept(), a.getPrettyPrinter());
				if (! is.contains(i)) {
					is.add(i);
					if (a.shouldTrace()) {
						a.trace(new CreateIntentionEvent(i));
					}
				}
				a.tellawake();
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
		if (! messages.isEmpty()) {
			a.tellawake();
		}
	}
} 