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
package goal.syntax;

import goal.semantics.GOALAgent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.BroadcastSendAction;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Literal;
import ail.syntax.SendAction;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;

public class GOALSendAction extends BroadcastSendAction {
	public static final int SEND = 0;
	public static final int SENDONCE = 1;
	
	int type = SEND;
	
	public enum RECEIVER {
		ALL, ALLOTHER, SELF, SOME, SOMEOTHER, THIS, TERM;
		
		static RECEIVER[] value_array = RECEIVER.values();
				
		public static RECEIVER fromInt(int i) {
            return value_array[i];
         }
		
	}
	private RECEIVER receiver;
	private Term receiver_term;
	
	public GOALSendAction(Action a, RECEIVER receiver, int ilf, int type) {
		super(a, ilf);
		this.receiver = receiver;
		this.type = type;
	}
	
	public GoalMessage getMessage(String agName) {
		return new GoalMessage(super.getMessage(agName));
	}
	
	public void setReceiver(Term r) {
		receiver_term = r;
	}

	public void setReceiverEnum(RECEIVER rec) {receiver = rec;}
	
	ListTerm receivers = new ListTermImpl();
	
	public void clearReceivers() {
		receivers = new ListTermImpl();
	}
	
	public void setReceivers(GOALAgent a) {
		Literal me = new Literal("me");
		VarTerm a1 = new VarTerm("A");
		me.addTerm(a1);
		
		Literal agent = new Literal("agent");
		agent.addTerm(a1);
		Guard notme = new Guard(Guard.GLogicalOp.not, new GBelief(me));

		switch (receiver) {
		case TERM:
			receivers.cons(receiver_term);
			break;
		case ALLOTHER:
			Guard allother = new Guard(new GBelief(agent), Guard.GLogicalOp.and, notme);
			Iterator<Unifier> agents = a.believes(allother, new Unifier());
			while (agents.hasNext()) {
				Unifier u = agents.next();
				receivers.cons(u.get(a1));
			}
			break;
		case SELF:
			Guard selfguard = new Guard(Guard.GLogicalOp.none, new GBelief(me));
			Iterator<Unifier> meagent = a.believes(selfguard, new Unifier());
			while (meagent.hasNext()) {
				Unifier u = meagent.next();
				receivers.cons(u.get(a1));
			}
			break;
		case SOME:
			Guard some = new Guard(Guard.GLogicalOp.none, new GBelief(agent));
			Iterator<Unifier> some_it = a.believes(some, new Unifier());
			if (some_it.hasNext()) {
				Unifier u = some_it.next();
				receivers.cons(u.get(a1));
			}
			break;
		case SOMEOTHER:
			Guard someother = new Guard(new GBelief(agent), Guard.GLogicalOp.and, notme);
			Iterator<Unifier> someother_it = a.believes(someother, new Unifier());
			if (someother_it.hasNext()) {
				Unifier u = someother_it.next();
				receivers.cons(u.get(a1));
			}
			break;
		case THIS:
			break;
		case ALL:
			Guard all = new Guard(Guard.GLogicalOp.none, new GBelief(agent));
			Iterator<Unifier> all_it = a.believes(all, new Unifier());
			while (all_it.hasNext()) {
				Unifier u = all_it.next();
				receivers.cons(u.get(a1));
			}
		}		
	}
	
	/**
	 * getter for the recipeint.
	 * 
	 * @return
	 */
	public ListTerm getReceivers() {
		
			
		return receivers;
	}

	
	@Override
	public GOALSendAction clone() {
		BroadcastSendAction aclone = super.clone();
		GOALSendAction gas =  new GOALSendAction(aclone, receiver, ilf, type);
		if (receiver == RECEIVER.TERM) {
			gas.setReceiver((Term) receiver_term.clone()); 
		}
		return gas;
	}
	
	/**
	 * Is this SEND or SENDONCE?
	 * @return
	 */
	public int getType() {
		return type;
	}
	
	@Override
	public boolean apply(Unifier u) {
		boolean b = super.apply(u);
		boolean b2 = true;
		if (receiver_term != null) {
			b2 = receiver_term.apply(u);
		}
		return (b && b2);
	}
	
	@Override
	public Set<String> getVarNames() {
		Set<String> varnames = super.getVarNames();
		if (receiver_term != null) {
			if (receiver_term instanceof VarTerm) {
				varnames.addAll(((VarTerm) receiver_term).getVarNames());
			}
		}
		return varnames;
	}

}
