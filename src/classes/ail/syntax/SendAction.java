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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

/**
 * A class for AIL Send Actions.  These are actions with addition fields for 
 * performatives and ids.  It is assumed that the basic action is a term
 * with two arguments, the content and the receiver (as a StringTerm).
 * 
 * @author louiseadennis
 *
 */
public class SendAction extends Action {
	
	/**
	 * Any languages specific annotations on the message.
	 */
	protected AILAnnotation ann;
	
	/**
	 * Illocutionary force.
	 */
	protected int ilf;
		
	/**
	 * The thId of the message.
	 */
	protected String thId;
	
	/**
	 * The message constructed to be sent by the action when it is
	 * executed.
	 */
	protected Message msg;

	/**
	 * Create a send action from a recipient, ilf and content.
	 * 
	 * @param r The receiver
	 * @param i the illocutionary force of the message.
	 * @param c the content of the message.
	 */
	public SendAction(StringTerm r, int i, Term c) {
		super("send");
		// we add the unifiable bits of the content to the term.
		this.addTerm(c);
		this.addTerm(r);
		ilf = i;
		setActionType(Action.sendAction);
	}
	
	/**
	 * Same as above but the recipient is a Term rather than a string term.
	 * @param r
	 * @param i
	 * @param c
	 */
	public SendAction(Term r, int i, Term c) {
		super("send");
		// we add the unifiable bits of the content to the term.
		this.addTerm(c);
		this.addTerm(r);
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
	public SendAction(StringTerm reciever, int i, Term c, String thid) {
		this(reciever, i, c);
		this.addTerm(new Predicate(thid));
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
	private SendAction(Action a, int i, AILAnnotation ann1) {
		super(a);
		ilf = i;
		ann = ann1;
		setActionType(Action.sendAction);
	}
	

	public SendAction(Action a, int i) {
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
	public Term getReceiver() {
		return this.getTerm(1);
	}
	
	public String getRecieverAsString() {
		Term r = getReceiver();
		if (r instanceof VarTerm) {
			if (r.isGround()) {
				Term rg = ((VarTerm) r).getValue();
				if (rg instanceof StringTerm) {
					return ((StringTerm) rg).getString();
				} else {
					return r.toString();
				}
			}
			return r.toString();
		} else if (r instanceof StringTerm) {
			StringTerm rs = (StringTerm) r;
			return rs.getString();
		} else {
			return r.toString();
		}
	}
	
	/**
	 * Getter for the thread id.
	 * @return
	 */
	public String getThId() {
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
	public void addMessage(Message msg1) {
		msg = msg1;
	}
	
	/**
	 * Getter for the action's message - returns null if the message hasn't
	 * been sent yet.
	 * 
	 * @param a The sender of the message.
	 * @return the action's message.
	 */
	public Message getMessage(String agName) {
		if (msg == null) {
			if (getThId() != null) {
				msg = new Message(getILF(), agName, 
					 getRecieverAsString(), getContent(), getThId());
			
			} else {
			msg = new Message(getILF(), agName, 
					  getRecieverAsString(), getContent());
			}
		}

		return msg;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Pred#clone()
	 */
	public SendAction clone() {
		Action a = (Action) super.clone();
		return(new SendAction(a, ilf, ann));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Structure#apply(ail.semantics.Unifier)
	 */
	public boolean apply(Unifier u) {
		return (super.apply(u));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append(ilf);
		return s.toString();
	}
}
