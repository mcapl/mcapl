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

import ail.semantics.AILAgent;
import ajpf.util.AJPFLogger;


public class GMessage extends Message implements GuardAtom {
	
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
    public GMessage(byte sr, int ilf, String s, String r, Term c) {
       	super(ilf, s, r, c);
       	category = sr;
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
    	super(ilf, s, r, c, thid);
    	category = sr;
     }
     

	@Override
	public Iterator<Unifier> logicalConsequence(EvaluationBase eb, RuleBase rb,
			Unifier un) {
		return new EvaluationBaseIterator(eb, un, this);
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		return false;
	}

	@Override
	public StringTerm getEB() {
		// TODO Auto-generated method stub
		return DBnum;
	}

	@Override
	public byte getEBType() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public boolean hasLogicalContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Predicate getLogicalContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PredicateIndicator getPredicateIndicator() {
		// TODO Auto-generated method stub
		return null;
	}

}
