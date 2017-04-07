// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ail.mas.AILEnv;
import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.semantics.OSRule;
import goal.semantics.executorStages.startCycleStage;
import goal.semantics.GOALAgent;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * Sends the current intention to wait.
 * 
 * @author lad
 *
 */
public class GOALSleepRule implements OSRule {
	@FilterField
	private final static String name = "Sleep if Nothing to Do";
	
	private boolean sleepConditionHoldingPreviousCycle = true;
	
	private startCycleStage scs;
	
	public GOALSleepRule(startCycleStage scs) {
		this.scs = scs;
	}
	
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
		AILEnv env = a.getEnv();
		Set<Message> messages = env.getMessages(a.getAgName());
		Set<Predicate> percepts = env.getPercepts(a.getAgName(), true);
		if (percepts == null) {
			percepts = new HashSet<Predicate>();
		}
		scs.setMessages(messages);
		scs.setPercepts(percepts);
		
		boolean sleepcondition = percepts_have_changed(a, percepts) || !messages.isEmpty() || actionWasPerformed((GOALAgent) a);
		boolean newsleepcondition = sleepcondition || sleepConditionHoldingPreviousCycle;
		sleepConditionHoldingPreviousCycle = sleepcondition;
//		((GOALAgent) a).clearActionPerformed();
		return ! newsleepcondition;
	}
	
	private boolean actionWasPerformed(GOALAgent a) {
		return a.actionPerformedLastCycle();
	}
	
	private boolean percepts_have_changed(AILAgent a, Set<Predicate> percepts) {
		Iterator<Literal> percept_iterator = ((GOALAgent) a).getMentalState().getPercepts();
		Set<Predicate> removed_percepts = new HashSet<Predicate>();
		while (percept_iterator.hasNext()) {
			Literal l = percept_iterator.next();
			if (percepts == null | ! percepts.contains(l)) {
				return true;
			} else {
				removed_percepts.add(l);
			}
		}
		
		if (percepts == null) {
			return false;
		}
		
		for (Predicate l: percepts) {
			if (! removed_percepts.contains(new PredicatewAnnotation(l, a.refertopercept()))) {
				return true;
			}
		}
			
		return false;

	}
	
	/**
	 * Don't need to do anything with the current intention in this situation because it
	 * is empty.
	 */
	public void apply(AILAgent a) {
		
		a.sleep();
			
		// At present sleeping isn't a field in agent state change so this can't
		// actually be represented via MJI.
		
	}
} 