// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, Michael Fisher
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import ail.semantics.AILAgent;
import ajpf.util.AJPFLogger;


public class GMessage implements GuardAtom<Message> {
	
	StringTerm sender;
	StringTerm receiver;
	StringTerm threadId;
	int performative;
	Term content;
	
	
	private byte category = DefaultAILStructure.AILSent;

	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 * 
	 */
	private StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultBBname);
	

    /**
     * Constructor for a new message in a new thread.
     * 
     * @param ilf the illocutionary force of the message.
     * @param s the sender of the message.
     * @param r the receiver of the message.
     * @param c the content of the message.
     */
    public GMessage(byte sr, int ilf, StringTerm s, StringTerm r, Term c, StringTerm thid) {
    	sender = s;
    	receiver = r;
    	content = c;
    	performative = ilf;
       	category = sr;
       	threadId = thid;
    }
    
    public GMessage(byte sr, int ilf, StringTerm s, StringTerm r, Term c) {
    	sender = s;
    	receiver = r;
    	content = c;
    	performative = ilf;
       	category = sr;
       	threadId = new StringTermImpl("thdid");
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
    public GMessage(byte sr, int ilf, String s, String r, Term c, String thid) {
    	this(sr, ilf, new StringTermImpl(s), new StringTermImpl(r), c, new StringTermImpl(thid));
      }
     
    
	@Override
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un) {
		List<Message> ul = new ArrayList<Message>();
		if (category == DefaultAILStructure.AILSent) {
			ul.addAll(ag.getOutbox());
		} else {
			ul.addAll(ag.getInbox());
		}
		
		return new EvaluationBaseIterator(new ListEvaluationBase(ul), un, this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public GMessage clone() {
		return(new GMessage(category, performative, (StringTerm) sender.clone(), (StringTerm) receiver.clone(), (Term) content.clone(), (StringTerm) threadId.clone()));
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEB()
	 */
	public StringTerm getEB() {
		return DBnum;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEBType()
	 */
	public byte getEBType() {
		return category;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#hasLogicalContent()
	 */
	public boolean hasLogicalContent() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getLogicalContent()
	 */
	public Predicate getLogicalContent() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isVar()
	 */
	public boolean isVar() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getPredicateIndicator()
	 */
	public PredicateIndicator getPredicateIndicator() {
		return null;
	}
	
	public StringTerm getSender() {
		return sender;
	}
	
	public StringTerm getReceiver() {
		return receiver;
	}
	
	public int getIlf() {
		return performative;
	}
	
	public StringTerm getThdID() {
		return threadId;
	}
	
	public Term getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof GMessage) {
			GMessage tm = (GMessage) t;
			if (sender.unifies(tm.getSender(), u)) {
				if (receiver.unifies(tm.getReceiver(), u)) {
					if (performative == tm.getIlf()) {
						if (content.unifies(tm.getContent(), u)) {
							return threadId.unifies(tm.getThdID(), u);
						}
					}
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u) {
	   	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    			}
    		}
    	}
	}

	@Override
	public List<String> getVarNames() {
    	ArrayList<String> varnames = new ArrayList<String>();
    	varnames.addAll(sender.getVarNames());
    	varnames.addAll(receiver.getVarNames());
    	varnames.addAll(content.getVarNames());
    	varnames.addAll(threadId.getVarNames());
		return varnames;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		sender.renameVar(oldname, newname);
		receiver.renameVar(oldname, newname);
		content.renameVar(oldname, newname);
		threadId.renameVar(oldname, newname);

		
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof GMessage) {
			GMessage tm = (GMessage) t;
			if (sender.match(tm.getSender(), u)) {
				if (receiver.match(tm.getReceiver(), u)) {
					if (performative == tm.getIlf()) {
						if (content.match(tm.getContent(), u)) {
							return threadId.match(tm.getThdID(), u);
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof GMessage) {
			GMessage tm = (GMessage) t;
			if (sender.matchNG(tm.getSender(), u)) {
				if (receiver.matchNG(tm.getReceiver(), u)) {
					if (performative == tm.getIlf()) {
						if (content.matchNG(tm.getContent(), u)) {
							return threadId.matchNG(tm.getThdID(), u);
						}
					}
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGround() {
		// TODO Auto-generated method stub
		return (sender.isGround() & receiver.isGround() & content.isGround() & threadId.isGround());
	}

	@Override
	public boolean apply(Unifier theta) {
		return (sender.apply(theta) && receiver.apply(theta) && content.apply(theta) && threadId.apply(theta));
	}

	@Override
	public void makeVarsAnnon() {
		sender.makeVarsAnnon();
		receiver.makeVarsAnnon();
		content.makeVarsAnnon();
		threadId.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new GMessage(category, performative, (StringTerm) sender.strip_varterm(), (StringTerm) receiver.strip_varterm(), (Term) content.strip_varterm(), (StringTerm) threadId.strip_varterm());
	}

}
