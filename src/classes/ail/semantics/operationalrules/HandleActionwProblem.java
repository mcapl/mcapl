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

import ail.syntax.*;
import ail.util.AILexception;
import ajpf.util.VerifyMap;
import ail.syntax.ActionLog;

import java.util.Iterator;

import ail.mas.AILEnv;
import ail.mas.EnvWithCapLibrary;
import ail.semantics.AILAgent;
import ail.tracing.events.ActionEvent;

/**
 * Handle an action.  Calls immediately executeAction in the environment but also
 * adds the action to the agent's list.
 * 
 * @author lad
 *
 */
public class HandleActionwProblem extends HandleTopDeed {
	private static final String name = "Handle Action and Recognise Problems";
	protected boolean succeeded = true;

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		succeeded = true;
		if (super.checkPreconditions(a) && topdeed.getCategory() == Deed.DAction) {
			return true;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		/**
		 * The action to be handled
		 */
		Action act = (Action) topdeed.getContent();
		AILEnv env = a.getEnv();

		// set pre belief base for keeping a note of beliefs before execution
		a.setPreBB();
		
		// Bit of a hack this!
		
		// NEW STUFF
		if (env instanceof EnvWithCapLibrary) {
			// First time we encounter act we change it to a durative action then we proceed
			if (! (act instanceof DurativeAction)) {
				Iterator<Capability> caps = ((EnvWithCapLibrary) env).getCapabilityLibrary().getRelevant(act, AILAgent.SelectionOrder.LINEAR);
				while (caps.hasNext()) {
					Capability a1 = caps.next().clone();
					if (a1.getAction().unifies(act, new Unifier())) {
						i.tlI(a);
						i.iCons(i.hdE(), new Deed(a1), new Guard(new GBelief()), thetahd);
						// Fancy footwork to try to make sure the durative aciton now on top of the intention is the same action we are working with
						topdeed = i.hdD();
						act = (Action) topdeed.getContent();
						break;
					}
				}
					
			} 
		}
		
		if (act instanceof DurativeAction) {
			
			// We can (hopefully!) now assume act is a durative action.
			DurativeAction dact = (DurativeAction) act;
			thetahd.compose(thetab);
			dact.apply(thetahd);
			try {
				Unifier thetaa = new Unifier();
				// if the action isn't seen as executing: execute it, and mark it as executing.
				if (! dact.isExecuting()) {
					//take note of the currently held beliefs before execution.
					a.setPreBB();
					//execute
					thetaa = a.getEnv().executeAction(a.getAgName(), dact);
					dact.executing();
				}
				//if the agent believes the action's success conditions, log it, update action status and go to next deed.
				if (a.believesyn(new Guard((GLogicalFormula) dact.getSuccess()), thetahd)) {
					a.al.add(new ActionLogEntry(dact, a.prebeliefs, a.getBB(), ActionLogEntry.actionSucceeded));
					i.tlI(a);
					thetahd.compose(thetaa);
					i.compose(thetahd);
					dact.notExecuting();
					//if the agent believes the action's failure conditions, log it, update action status and retry.
					//using - not+ the above if statement whilst I chance success+failure
				} else if (a.believesyn(new Guard((GLogicalFormula) dact.getFail()), thetahd)) {
					// Do nothing, retry
					dact.notExecuting();
					// Log it
					a.al.add(new ActionLogEntry(dact, a.prebeliefs, a.getBB(), ActionLogEntry.actionFailed));
					//remove action from intention stack
					i.tlI(a);
					// add action to top of intention stack again
					i.iCons(i.hdE(), new Deed(dact), new Guard(new GBelief()), thetahd);
					thetahd.compose(thetaa);
					i.compose(thetahd);
					System.out.println("ACTION FAILED RETRYING");
					
				} else if (dact.abort(a)) {
					// Abort retry
					if (dact.isExecuting()) {
						Predicate abort = new Predicate("abort");
						abort.addTerm(dact);
						a.getEnv().executeAction(a.getAgName(), new Action(abort, Action.normalAction));
					}
					dact.notExecuting();
					a.al.add(new ActionLogEntry(dact, a.prebeliefs, a.getBB(), ActionLogEntry.actionAbort));
					a.log(dact, ActionLogEntry.actionAbort);
					i.tlI(a);
					i.iCons(i.hdE(), new Deed(dact), new Guard(new GBelief()), thetahd);
					thetahd.compose(thetaa);
					i.compose(thetahd);
					
				} else {
					if (dact.isExecuting()) {
						i.suspend();
					} else {
						dact.executing();
						i.suspend();						
					}
				}
			} catch (AILexception ex) { // Hopefully this doesn't happen because we have success and fail conditions made explicit
				succeeded = false;
				Event e = i.hdE();
				if (e.referstoGoal()) {
					Goal goal = (Goal) e.getContent();
					Event ep = new Event(Event.AILDeletion, goal);
					thetahd.compose(thetab);
					i.iCons(ep, new Deed(Deed.Dnpy), new Guard(new GBelief()), thetahd);
				} else {
					i.tlI(a);
					i.compose(thetahd);
				}
			}
			
		} else { // OLD STUFF
			try {
				Unifier thetaa = a.getEnv().actionResult(a.getAgName(), act);
				if (thetaa == null) {
					thetahd.compose(thetab);
					act.apply(thetahd);
					// i.suspend();
					thetaa = a.getEnv().executeAction(a.getAgName(), act);
					if (a.shouldTrace()) {
						a.trace(new ActionEvent(act, i_id));
					}
				} 
				if (a.getEnv().executing(a.getAgName(), act)) {
					a.getReasoningCycle().setStopandCheck(true);
				} else {	
					i.tlI(a);
					thetahd.compose(thetaa);
					i.compose(thetahd);
				}
			} catch (AILexception ex) {
				succeeded = false;
				Event e = i.hdE();
				if (e.referstoGoal()) {
					Goal goal = (Goal) e.getContent();
					Event ep = new Event(Event.AILDeletion, goal);
					thetahd.compose(thetab);
					i.iCons(ep, new Deed(Deed.Dnpy), new Guard(new GBelief()), thetahd);
				} else {
					i.tlI(a);
					i.compose(thetahd);
				}
			}
		}
	}
}