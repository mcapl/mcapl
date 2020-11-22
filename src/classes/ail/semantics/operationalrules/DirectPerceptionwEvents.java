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
import ail.syntax.BeliefBase;
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;
import ajpf.util.AJPFLogger;

/**
 * Perception rule.  Gets a list of all literals the agent can perceive from the
 * environment.  It all gets a list of things the agent believes it can perceive
 * from the agent and compares the two.  Any discrepancies applied directly to the
 * belief base but they also generate events to be handles.  
 * 
 * The rule also gets messages from the environment and adds to inbox.
 * 
 * @author lad
 *
 */
public class DirectPerceptionwEvents implements OSRule {
	private final static String name = "Direct Perception with Events";
	private static String logname = "ail.semantics.operationalrules";

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return ! (a.getEnv().agentIsUpToDate(a.getAgName()));
	}
			
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		AILEnv env = a.getEnv();
		Set<Predicate> percepts = env.getPercepts(a.getAgName(), true);
		Set<Message> messages = env.getMessages(a.getAgName());
		
		if (AJPFLogger.ltFiner(logname)) {
			AJPFLogger.finer(logname, "Incoming percepts: " + percepts);
		}
				
		if (percepts != null) {
			// First work through the agents current perceptions.
			// Create an intention to remove any no longer perceived.
			// Any literal in percepts which was previously perceived, discard to avoid duplication.
			Iterator<Predicate> gbi = a.getBB().getPerceptsAsStructs();
			Set<Literal> removed_percepts = new TreeSet<Literal>();
			while (gbi.hasNext()) {
				Predicate l = gbi.next();
				if (AJPFLogger.ltFiner(logname)) {
					AJPFLogger.finer(logname, "percept " + l);
				}
				if (! percepts.contains(l)) {
					Literal lit = new Literal(true, new PredicatewAnnotation(l));
					lit.addAnnot(BeliefBase.TPercept);
					if (a.delBel(lit) && a.shouldTrace()) {
						a.trace(new ModificationEvent(ModificationEvent.BELIEFS, null, null, l));
					}
					Intention i = new Intention(new Event(Event.AILDeletion, Event.AILBel, lit), AILAgent.refertopercept(), a.getPrettyPrinter());
					a.addNewIntention(i);
					if (a.shouldTrace()) {
						a.trace(new CreateIntentionEvent(i));
					}
					a.tellawake();
					if (AJPFLogger.ltFine(logname)) {
						AJPFLogger.fine(logname, a.getAgName() + " dropped " + l);
					}
					removed_percepts.add(lit);
				} else {
					percepts.remove(l);
				}
			 }
		
			// Add all the remaining perceptions (i.e., the new ones) as intentions.
			boolean additions = false;
			for (Predicate l: percepts) {
				Literal k = new Literal(true, new PredicatewAnnotation(l.clone()));
				additions = true;
				if (a.addBel(k, AILAgent.refertopercept()) && a.shouldTrace()) {
					a.trace(new ModificationEvent(ModificationEvent.BELIEFS, null, k, null));
				}
				// Don't let new intention get dropped totally if things change.
				Intention i = new Intention(new Event(Event.AILAddition, Event.AILBel, k), AILAgent.refertoself(), a.getPrettyPrinter());
				a.addNewIntention(i);
				if (a.shouldTrace()) {
					a.trace(new CreateIntentionEvent(i));
				}
				a.tellawake();
				if (AJPFLogger.ltFine(logname)) {
					AJPFLogger.fine(logname, a.getAgName() + " added " + k);
				}
			}
			
			if (additions || !removed_percepts.isEmpty()) {
				for (Intention i: a.getIntentions()) {
					i.unsuspendFor(percepts, removed_percepts);
				}
				
				if (a.getIntention() != null) {
					a.getIntention().unsuspendFor(percepts, removed_percepts);
				}
			}
		}
		
		Set<Message> previous = new TreeSet<>(a.getInbox());
		Set<Message> addList = Sets.difference(messages, previous);
		a.newMessages(messages);
		if (!addList.isEmpty() && a.shouldTrace()) {
			List<Predicate> predicates = new ArrayList<>(addList.size());
			for (Message msg : addList) {
				predicates.add(msg.toTerm());
			}
			a.trace(new ModificationEvent(ModificationEvent.INBOX, null, predicates, null));
		}
	}
} 