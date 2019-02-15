// ----------------------------------------------------------------------------
// Copyright (C) 2014-2016 Louise A. Dennis, and  Michael Fisher 
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;

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
	@Override
	public Capability clone() {
		return new Capability(pre.clone(), cap.clone(), post.clone());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
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
	 * Return the "action" part of the capability (represented as a predicate).
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
	@Override
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
		varnames.addAll(cap.getVarNames());
		varnames.addAll(pre.getVarNames());
		varnames.addAll(post.getVarNames());
		return varnames;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
		pre.renameVar(oldname, newname);
		post.renameVar(oldname, newname);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean apply(Unifier theta) {
		boolean c = cap.apply(theta);
		boolean p1 = pre.apply(theta);
		boolean p2 = post.apply(theta);
		return (c || p1 || p2);
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) {
			return subst;
		} else {
			return new Capability((GLogicalFormula) pre.substitute(term,  subst), (Predicate) cap.substitute(term, subst), (GLogicalFormula) post.substitute(term, subst));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	@Override
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
		pre.makeVarsAnnon();
		post.makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	@Override
	public Unifiable strip_varterm() {
		return new Capability((GLogicalFormula) pre.strip_varterm(), (Predicate) cap.strip_varterm(), (GLogicalFormula) post.strip_varterm());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	@Override
	public Unifiable resolveVarsClusters() {
		return new Capability((GLogicalFormula) pre.resolveVarsClusters(), (Predicate) cap.resolveVarsClusters(), (GLogicalFormula) post.resolveVarsClusters());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "{";
		s += pre;
		s += "} " + cap + " {";
		s += post;
		s += "}";
		return s;
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		String s = "{";
		s += pre.toString(descriptions);
		s += "} " + cap.toString(descriptions) + " {";
		s += post.toString(descriptions);
		s += "}";
		return s;
	}
	
	public ArrayList<Literal> postConditionsToLiterals() {
		GLogicalFormula posts = getPost();
		return fmla_to_lits(posts);
	}
	
	private static ArrayList<Literal> fmla_to_lits(GLogicalFormula lf) {
		ArrayList<Literal> lits = new ArrayList<Literal>();
		if (lf instanceof Literal) {
			lits.add(new Literal((Literal) lf));
			return lits;
		}
		
		if (lf instanceof Predicate) {
			lits.add(new Literal((Predicate) lf));
			return lits;
		}
		
		if (lf instanceof Guard) {
			Guard g = (Guard) lf;
			if (g.getOp() == Guard.GLogicalOp.none) {
				lits.addAll(fmla_to_lits(g.getRHS()));
			} else if (g.getOp() == Guard.GLogicalOp.not) {
				ArrayList<Literal> neglits = fmla_to_lits(g.getRHS());
				Literal neglit = neglits.get(0);
				if (neglit.negated()) {
					neglit.setNegated(false);
				} else {
					neglit.setNegated(true);
				}
				lits.add(neglit);
			} else {
				lits.addAll(fmla_to_lits(g.getLHS()));
				lits.addAll(fmla_to_lits(g.getRHS()));
			}
		}
		return lits;
	}

}
