// ----------------------------------------------------------------------------
// Copyright (C) 2008-2016 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

package ail.syntax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ajpf.util.VerifySet;

/**
 * A class for AIL Send Actions.  These are actions with addition fields for 
 * performatives and ids.  It is assumed that the basic action is a term
 * with two arguments, the content and the receiver (as a StringTerm).
 * Largely untested
 * 
 * @author louiseadennis
 *
 */
public class BroadcastSendAction extends Action {
	
	/**
	 * Any langauges specific annotations on the message.
	 */
	protected AILAnnotation ann;
	
	/**
	 * Illocutionary force.
	 */
	protected int ilf;
		
	/**
	 * The thId of the message.
	 */
	protected StringTerm thId = new StringTermImpl("");
	
	/**
	 * The message constructed to be sent by the action when it is
	 * executed.
	 */
	protected BroadcastMessage msg;

	/**
	 * Create a send action froma recipient, ilf and content.
	 * 
	 * @param r The receiver
	 * @param i the illocutionary force of the message.
	 * @param c the content of the message.
	 */
	public BroadcastSendAction(Set<Term> rs, int i, Term c) {
		super("send");
		// we add the unifiable bits of the content to the term.
		this.addTerm(c);
		ListTermImpl receiversTerm = new ListTermImpl();
		for (Term r : rs) {
			receiversTerm.add(r);
		}
		this.addTerm(receiversTerm);
		ilf = i;
		setActionType(Action.sendAction);
	}
	
	/**
	 * Create a send action from a recipient, ilf, content, and thread id.
	 * 
	 * @param r reciever
	 * @param i the illocutionary force.
	 * @param c the message content.
	 * @param thid the thread id.
	 */
	public BroadcastSendAction(Set<Term> recievers, int i, Term c, StringTerm thid) {
		this(recievers, i, c);
		this.addTerm(thid);
		thId = thid;
		setActionType(Action.sendAction);
	}
	
	/**
	 * Construct from another action.
	 * 
	 * @param a
	 * @param i
	 * @param ann1
	 */
	private BroadcastSendAction(Action a, int i, AILAnnotation ann1, StringTerm thid) {
		super(a);
		ilf = i;
		ann = ann1;
		thId = thid;
		setActionType(Action.sendAction);
	}
	
	/**
	 * Construct from another action.
	 * 
	 * @param a
	 * @param i
	 * @param ann1
	 */
	public BroadcastSendAction(Action a, int i, StringTerm thid) {
		super(a);
		ilf = i;
		thId = thid;
		setActionType(Action.sendAction);
	}
	
	/**
	 * Construct from another action.
	 * 
	 * @param a
	 * @param i
	 * @param ann1
	 */
	public BroadcastSendAction(Action a, int i) {
		super(a);
		ilf = i;
		setActionType(Action.sendAction);
	}

	/**
	 * Setter method for the message annotation.
	 * 
	 * @param ann1
	 */
	public void setAnnotation(AILAnnotation ann1) {
		ann = ann1;
	}
	
	/**
	 * Getter for the illocutionary force.
	 * @return
	 */
	public int getILF() {
		return ilf;
	}
	
	/**
	 * getter for the recipeint.
	 * 
	 * @return
	 */
	public Term getReceivers() {
		return this.getTerm(1);
	}
	
	/**
	 * Get list of recipients for the message.
	 * @return
	 */
	public Set<String> getReceiversSet() {
		Set<String> list = new VerifySet<String>();
		ListTermImpl tlist = (ListTermImpl) getReceivers();
		Iterator<Term> tli = tlist.iterator();
		while (tli.hasNext()) {
			list.add(tli.next().toString());
		}
		return list;
	}
	
	/**
	 * Getter for the thread id.
	 * @return
	 */
	public StringTerm getThId() {
		return thId;
	}
	
	/**
	 * Getter for the message content.
	 * @return
	 */
	public Term getContent() {
		return this.getTerm(0);
	}
	
	/**
	 * Setter method for teh message.
	 * @param msg1
	 */
	public void addMessage(BroadcastMessage msg1) {
		msg = msg1;
	}
	
	/**
	 * Getter for the action's message - returns null if the message hasn't
	 * been sent yet.
	 * 
	 * @param a The sender of the message.
	 * @return the action's message.
	 */
	public BroadcastMessage getMessage(String agName) {
		if (msg == null) {
			StringTerm thid = getThId();
			if (thid != null) {
				msg = new BroadcastMessage(getILF(), agName, 
					 getReceiversSet(), getContent(), getThId());
			
			} else {
			msg = new BroadcastMessage(getILF(), agName, 
					  getReceiversSet(), getContent());
			}
		}

		return msg;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Action#clone()
	 */
	@Override
	public BroadcastSendAction clone() {
		Action a = (Action) super.clone();
		return(new BroadcastSendAction(a, ilf, ann, (StringTerm) thId.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#apply(ail.syntax.Unifier)
	 */
	@Override
	public boolean apply(Unifier u) {
		boolean flag = false;
		if (msg != null) {
			flag = msg.apply(u);
		}
		return (flag || super.apply(u));
	}
	
	/**
	 * Setter for the message.
	 * @param m
	 */
	public void setMessage(BroadcastMessage m) {
		msg = m;
	}
	
}
