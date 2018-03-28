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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import ail.util.AILexception;
import ajpf.util.VerifySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Broadcast Message class. For Messages to go to multiple recipients  Environments may
 * need to serialize these messages for transmission.  Largely untested.
 * 
 * @author louiseadennis
 *
 */
public class BroadcastMessage extends Message {
	/**
	 * We need to override hashCode in order to use hash maps with terms
	 * as keys elsewhere in the system.  Java expects equal objects to 
	 * have the same hashsode.
	 */
	@FilterField
	protected Integer hashCodeCache = null;

    /**
     * The receiver of the message: A string assumed to be unique.
     */
    Set<String> receivers = new VerifySet<String>();
    
      
    /**
     * Default empty constructor.
     *
     */
    public BroadcastMessage() {
    }

    /**
     * Constructor for a new message in a new thread.
     * 
     * @param ilf the illocutionary force of the message.
     * @param s the sender of the message.
     * @param r the receiver of the message.
     * @param c the content of the message.
     */
    public BroadcastMessage(int ilf, String s, Set<String> r, Term c) {
       	this(ilf, s, r, c, new StringTermImpl("mid"), new StringTermImpl("thid"));
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
    public BroadcastMessage(int ilf, String s, Set<String> r, Term c, StringTerm thid) {
    	this(ilf, s, r, c, new StringTermImpl("mid"), thid);
    }
 
     
    /**
     * Constructor for a broadcast message in an existing thread with an existing message id.
     * @param ilf
     * @param s
     * @param rs
     * @param c
     * @param id
     * @param thid
     */
    protected BroadcastMessage(int ilf, String s, Set<String> rs, Term c, String id, String thid) {
    	ilForce = ilf;
    	sender = s;
    	receivers = rs;
    	propCont = c;
    	msgId = new StringTermImpl(id);
    	threadId = new StringTermImpl(thid);
    	hashCodeCache = toTerm().hashCode();
    }
    
    /**
     * Constructor for a broadcast message in an existing thread with an existing message id.
     * @param ilf
     * @param s
     * @param rs
     * @param c
     * @param id
     * @param thid
     */
    protected BroadcastMessage(int ilf, String s, Set<String> rs, Term c, StringTerm id, StringTerm thid) {
    	ilForce = ilf;
    	sender = s;
    	receivers = rs;
    	propCont = c;
    	msgId = id;
    	threadId = thid;
    	hashCodeCache = toTerm().hashCode();
    }
 
    /**
     * Constructs a message from a message term.  Implicitly assumes
     * appropriate format to term.
     * 
     * @param t a message term.
     * @throws AILexception
     */
	public BroadcastMessage(Predicate t) throws AILexception {
		if (t.getFunctor() == "message") {
			msgId = ((StringTerm) t.getTerm(0));
			threadId = (StringTerm) t.getTerm(1);
			sender = ((Predicate) t.getTerm(2)).getFunctor();
			List<Term> rs = (((ListTermImpl) t.getTerm(3)).getAsList());
			for (Term r: rs) {
				receivers.add(((Predicate) r).getFunctor());
			}
			ilForce = Integer.valueOf(((Predicate) t.getTerm(4)).getFunctor()).intValue();
			propCont = t.getTerm(5);
		} else {
			throw (new AILexception("Bad Message Format"));
		}
	}
   
 	
	/**
	 * Getter method for the receivers of the message.
	 * @return
	 */
	public Set<String> getReceivers() {
		return receivers;
	}
	
	/**
	 * Setter method for the receivers of a message.
	 * @param agName
	 */
	public void setReceivers(Set<String> agNames) {
		receivers = agNames;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("<");
		s.append(msgId).append(",").append(threadId).append(",").append(sender);
		s.append(",").append(ilForce).append(",").append(receivers).append(",").append(propCont).append(">");
		s.append(receiver).append(ann);
		String s1 = s.toString();
		return s1;  
    }
		
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Message#toTerm()
	 */
	@Override
	public Predicate toTerm() {
		Predicate t = new Predicate("message");
		t.addTerm(msgId);
		t.addTerm(threadId);
		t.addTerm(new Predicate(sender));
		ListTermImpl receiversTerm = new ListTermImpl();
		for (String r : receivers) {
			receiversTerm.cons(new Predicate(r));
		}
		t.addTerm(receiversTerm);
		String s = (new Integer(ilForce)).toString();
		t.addTerm(new Predicate(s));
		t.addTerm(propCont);
		return t;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public BroadcastMessage clone() {
		return(new BroadcastMessage(ilForce, sender, receivers, (Term) propCont.clone(), (StringTerm) msgId, (StringTerm) threadId.clone()));
	}
	
	
	
}
