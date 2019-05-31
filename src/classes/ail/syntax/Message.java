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

import java.util.HashSet;
import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;
import ail.util.AILexception;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Message class. Adapted from that in Jason by Jomi F. Hubner, Rafael H. Bordini et al.
 * Note that this class is for messages as represented in agents.  Environments may
 * need to serialize these messages for transmission.
 * 
 * @author louiseadennis
 *
 */
public class Message implements Comparable<Message>, Unifiable, HasTermRepresentation {
	/**
	 * We need to override hashCode in order to use hash maps with terms
	 * as keys elsewhere in the system.  Java expects equal objects to 
	 * have the same hashsode.
	 */
	@FilterField
	protected Integer hashCodeCache = null;

	/**
     * Message can have a languages specific illocutionary force.  AIL specifies
     * no illocutionary forces, but represents them as bytes and expects a language
     * to sub-class this appropriately.
     */
    int ilForce;
    /**
     * The sender and receiver of messages are strings representing the agent names
     * that are assumed to be unique.
     */
    String sender   = null;
    /**
     * The receiver of the message: A string assumed to be unique.
     */
    String receiver = null;
    /**
     * The content of the message is an AIL Structure (e.g., add a goal).
     */
    Term propCont = null;
    /**
     * The message has a unique id.
     */
    @FilterField
    StringTerm msgId    = new StringTermImpl("mid");
    /**
     * The message thread has a unique id.
     */
    @FilterField
    StringTerm threadId = new StringTermImpl("thid");
    /**
     * Other language specific information may be included if desired.  It
     * should be noted, however, that this information is not communicated
     * when the message is sent.
     */
    AILAnnotation ann = null;
       
    /**
     * Default empty constructor.
     *
     */
    public Message() {
    }

    /**
     * Constructor for a new message in a new thread.
     * 
     * @param ilf the illocutionary force of the message.
     * @param s the sender of the message.
     * @param r the receiver of the message.
     * @param c the content of the message.
     */
    public Message(int ilf, String s, String r, Term c) {
       	this(ilf, s, r, c, "mid", "thid");
    }
    
    /**
     * Constructor for a new message in an existing thread.
     * 
     * @param ilf the illocutionary force of the message.
     * @param s the sender of the message.
     * @param r the receiver of the message.
     * @param c the content of the message.
     * @param thid the thread of the message.
     */
    public Message(int ilf, String s, String r, Term c, String thid) {
    	this(ilf, s, r, c, "mid", thid);
     }
 
    /**
     * Constructor for an "existing" message in an "existing" thread.  Used as
     * a base by the other constructors, should not be called externally.
     * 
     * @param ilf the illocutionary force of the message.
     * @param s the sender of the message.
     * @param r the receiver of the message.
     * @param c the content of the message.
     * @param id the message id.
     * @param thid the thread id.
     */
    private Message(int ilf, String s, String r, Term c, StringTerm id, StringTerm thid) {
        ilForce  = ilf;
        sender   = s;
        receiver = r;
        propCont = c;
        msgId    = id;
        threadId = thid;
    }
    
    private Message(int ilf, String s, String r, Term c, String id, String thid) {
        ilForce  = ilf;
        sender   = s;
        receiver = r;
        propCont = c;
        msgId    = new StringTermImpl(id);
        threadId = new StringTermImpl(thid);
    }
    
    /**
     * Constructs a message from a message term.  Implicitly assumes
     * appropriate format to term.
     * 
     * @param t a message term.
     * @throws AILexception
     */
	public Message(Predicate t) throws AILexception {
		if (t.getFunctor() == "message") {
			msgId = ((StringTerm) t.getTerm(0));
			threadId = (StringTerm) t.getTerm(1);
			sender = ((Predicate) t.getTerm(2)).getFunctor();
			receiver = ((Predicate) t.getTerm(3)).getFunctor();
			ilForce = Integer.valueOf(((Predicate) t.getTerm(4)).getFunctor()).intValue();
			propCont = t.getTerm(5);
		} else {
			throw (new AILexception("Bad Message Format"));
		}
	}
   
    /**
     * Getter method for the illocutionary force.
     */
	public int getIlForce() {
		return ilForce;
	}
	
	
	/**
	 * Setter method for the content.
	 * 
	 * @param o
	 */
	public void setPropCont(Term o) {
		propCont = o;
	}
	
	/**
	 * Getter method for the content.
	 * 
	 * @return
	 */
	public Term getPropCont() {
		return propCont;
	}
	
	/**
	 * Getter method for the receiveer of the message.
	 * @return
	 */
	public String getReceiver() {
		return receiver;
	}
	
	/**
	 * Setter method for the sender of the message.
	 * @param agName
	 */
	public void setSender(String agName) {
		sender = agName;
	}
	/**
	 * Getter method for the sender of the message.
	 * @return
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * Setter method for the receiver of a message.
	 * @param agName
	 */
	public void setReceiver(String agName) {
		receiver = agName;
	}
	
	/**
	 * Set the ID for the thread this messages is part of.
	 * @param id
	 */
	protected void setThreadId(StringTerm id) {
		threadId = id;
	}
	
	/**
	 * Getter method of the message id.
	 * @return
	 */
	public StringTerm getMsgId() {
		return msgId;
	}
	
	/**
	 * Setter method for the message id.
	 * @param id
	 */
	public void setMsgId(StringTerm id) {
		msgId = id;
	}
	
	/**
	 * Get the id of the thread this message is part of.
	 * @return
	 */
	public StringTerm getThreadId() {
		return threadId;
	}
	
	/**
	 * Getter method for the messages annotations.
	 * @return
	 */
	public AILAnnotation getAnnotation() {
		return ann;
	}
	
	/**
	 * Setter method for the message annotation.
	 * @param ann_in
	 */
	public void setAnnotation(AILAnnotation ann_in) {
		ann = ann_in;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        s.append("<").append(msgId).append(",").append(threadId).append(",").append(sender).append(",").append(ilForce);
        s.append(",").append(receiver).append(",").append(propCont).append(">");
        return s.toString();
    }
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		} else {
			StringBuilder s = new StringBuilder();
			s.append("from ").append(sender).append(": ").append(propCont.toString(descriptions));
			return s.toString();
		}
	}
		
	/**
	 * Produce a term to represent the message.
	 * 
	 * @return a term representing the message.
	 */
	@Override
	public Predicate toTerm() {
		Predicate t = new Predicate("message");
		t.addTerm(msgId);
		t.addTerm(threadId);
		t.addTerm(new Predicate(sender));
		t.addTerm(new Predicate(receiver));
		String s = (new Integer(ilForce)).toString();
		t.addTerm(new Predicate(s));
		t.addTerm(propCont);
		return t;
	}
	
	
	/**
	 * Apply a unifier to the message.  Applies it to the content - we assume
	 * ilf, etc. are constants.
	 * 
	 * @param u the unifier to be applied.
	 * @return whether or not the unifier successfully appplied.
	 */
	@Override
	public boolean apply(Unifier u) {
		boolean flag = propCont.apply(u);
		flag = flag || threadId.apply(u);	
		return(flag);
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) return subst;
		
		return new Message(ilForce, sender, receiver, (Term) getPropCont().substitute(term, subst), (StringTerm) getMsgId().substitute(term, subst), (StringTerm) getThreadId().substitute(term, subst));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Message clone() {
		return(new Message(ilForce, sender, receiver, (Term) propCont.clone(), (StringTerm) msgId.clone(), (StringTerm) threadId.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Message m) {
		return toTerm().compareTo(m.toTerm());
	}  
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Message) {
			return toTerm().equals(((Message) o).toTerm());
		} else {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toTerm().hashCode();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof Message) {
			Message msg = (Message) t;
			if (msg.getIlForce() == getIlForce()) {
				if (msg.getSender() == getSender()) {
					if (msg.getReceiver() == getReceiver()) {
						if (getMsgId().unifies(msg.getMsgId(), u)) {
							if (getThreadId().unifies(msg.getThreadId(), u)) {
								return getPropCont().unifies(msg.getPropCont(), u);
							}
						}
					}
				}
				
			}
		} else if (t instanceof Term) {
			return toTerm().unifies(t, u);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
		DefaultAILStructure.standardise_apart(t, u, varnames, this);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		HashSet<String> varnames = new HashSet<String>();
		varnames.addAll(msgId.getVarNames());
		varnames.addAll(threadId.getVarNames());
		varnames.addAll(propCont.getVarNames());
		return varnames;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
		msgId.renameVar(oldname, newname);
		threadId.renameVar(oldname, newname);
		propCont.renameVar(oldname, newname);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof Message) {
			Message msg = (Message) t;
			if (msg.getIlForce() == getIlForce()) {
				if (msg.getSender() == getSender()) {
					if (msg.getReceiver() == getReceiver()) {
						if (getMsgId().match(msg.getMsgId(), u)) {
							if (getThreadId().match(msg.getThreadId(), u)) {
								return getPropCont().match(msg.getPropCont(), u);
							}
						}
					}
				}
				
			}
		} else if (t instanceof Term) {
			return toTerm().match(t, u);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof Message) {
			Message msg = (Message) t;
			if (msg.getIlForce() == getIlForce()) {
				if (msg.getSender() == getSender()) {
					if (msg.getReceiver() == getReceiver()) {
						if (getMsgId().matchNG(msg.getMsgId(), u)) {
							if (getThreadId().matchNG(msg.getThreadId(), u)) {
								return getPropCont().matchNG(msg.getPropCont(), u);
							}
						}
					}
				}
				
			}
		} else if (t instanceof Term) {
			return toTerm().matchNG(t, u);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	@Override
	public boolean isGround() {
		return (msgId.isGround() & threadId.isGround() & propCont.isGround());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	@Override
	public void makeVarsAnnon() {
		msgId.makeVarsAnnon();
		threadId.makeVarsAnnon();
		propCont.makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	@Override
	public Unifiable strip_varterm() {
		return new Message(getIlForce(), getSender(), getReceiver(), (Term) propCont.strip_varterm(), (StringTerm) msgId.strip_varterm(), (StringTerm)  threadId.strip_varterm());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	@Override
	public Unifiable resolveVarsClusters() {
		return new Message(getIlForce(), getSender(), getReceiver(), (Term) propCont.resolveVarsClusters(), (StringTerm) msgId.resolveVarsClusters(), (StringTerm)  threadId.resolveVarsClusters());
	}


}
