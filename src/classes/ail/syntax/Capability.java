// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Capabilities represent what an agent can do and are very closely related to actions.  So closely related that for a long
 * time the AIL managed without capabilities using, instead, a combination of actions and plans.  However in some situations
 * they do need to be represented explicitly.  A capability can be thought of as an action with explicit pre- and post-conditions.
 * @author lad
 *
 */
public class Capability implements Unifiable,
		Comparable<Capability> {
	
	GLogicalFormula pre;
	GLogicalFormula post;
	Predicate cap;
	protected int keynum;
	
	/**
	 * Constructor.
	 * @param pr
	 * @param c
	 * @param pt
	 */
	public Capability(GLogicalFormula pr, Predicate c, GLogicalFormula pt) {
		pre = pr;
		cap = c;
		post = pt;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Capability clone() {
		return new Capability(pre.clone(), cap.clone(), post.clone());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Capability o) {
    	if (keynum == o.getID()) {
    		return 0;
    	} else if (keynum > o.getID()) {
    		return 1;
    	} else {
    		return -1;
    	}
	}
	
	/**
	 * Set a unique id for the capability.
	 * @param i
	 */
	public void setID(int i) {
		keynum = i;
	}
	
	/**
	 * Getter for the ID>
	 * @return
	 */
	public int getID() {
		return keynum;
	}
	
	/**
	 * Return the "action" part of the capability (reprsented as a predicate).
	 * @return
	 */
	public Predicate getCap() {
		return cap;
	}
	
	/**
	 * Get the capability's preconditions.
	 * @return
	 */
	public GLogicalFormula getPre() {
		return pre;
	}
	
	/**
	 * Get the capability's postconditions.
	 * @return
	 */
	public GLogicalFormula getPost() {
		return post;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			Guard expr = new Guard(new GBelief(getCap()), Guard.GLogicalOp.and, new Guard(getPre(), Guard.GLogicalOp.and, getPost()));
			Guard oexpr = new Guard(new GBelief(c.getCap()), Guard.GLogicalOp.and, new Guard(c.getPre(), Guard.GLogicalOp.and, c.getPost()));
			return expr.unifies(oexpr, u);			
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier, java.util.List)
	 */
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
		List<String> tvarnames = t.getVarNames();
		List<String> myvarnames = getVarNames();
		tvarnames.addAll(varnames);
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

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	public List<String> getVarNames() {
		ArrayList<String> varnames = new ArrayList<String>();
		varnames.addAll(cap.getVarNames());
		varnames.addAll(pre.getVarNames());
		varnames.addAll(post.getVarNames());
		return varnames;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
		pre.renameVar(oldname, newname);
		post.renameVar(oldname, newname);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			Guard expr = new Guard(new GBelief(getCap()), Guard.GLogicalOp.and, new Guard(getPre(), Guard.GLogicalOp.and, getPost()));
			Guard oexpr = new Guard(new GBelief(c.getCap()), Guard.GLogicalOp.and, new Guard(c.getPre(), Guard.GLogicalOp.and, c.getPost()));
			return expr.match(oexpr, u);			
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			Guard expr = new Guard(new GBelief(getCap()), Guard.GLogicalOp.and, new Guard(getPre(), Guard.GLogicalOp.and, getPost()));
			Guard oexpr = new Guard(new GBelief(c.getCap()), Guard.GLogicalOp.and, new Guard(c.getPre(), Guard.GLogicalOp.and, c.getPost()));
			return expr.matchNG(oexpr, u);			
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	public boolean isGround() {
		if (cap.isGround()) {
			if (pre.isGround()) {
				return post.isGround();
			}
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	public boolean apply(Unifier theta) {
		boolean c = cap.apply(theta);
		boolean p1 = pre.apply(theta);
		boolean p2 = post.apply(theta);
		return (c || p1 || p2);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
		pre.makeVarsAnnon();
		post.makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	public Unifiable strip_varterm() {
		return new Capability((GLogicalFormula) pre.strip_varterm(), (Predicate) cap.strip_varterm(), (GLogicalFormula) post.strip_varterm());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	public Unifiable resolveVarsClusters() {
		return new Capability((GLogicalFormula) pre.resolveVarsClusters(), (Predicate) cap.resolveVarsClusters(), (GLogicalFormula) post.resolveVarsClusters());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "{";
		s += pre;
		s += "} " + cap + " {";
		s += post;
		s += "}";
		return s;
	}

}
