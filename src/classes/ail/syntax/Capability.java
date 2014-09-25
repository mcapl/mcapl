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
import ail.semantics.AILAgent;

public class Capability implements Unifiable,
		Comparable<Capability> {
	
	GLogicalFormula pre;
	GLogicalFormula post;
	Action cap;
	protected int keynum;
	
	public Capability(GLogicalFormula pr, Action c, GLogicalFormula pt) {
		pre = pr;
		cap = c;
		post = pt;
	}
	
	public Capability clone() {
		return new Capability(pre.clone(), cap.clone(), post.clone());
	}

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
	
	public void setID(int i) {
		keynum = i;
	}
	
	public int getID() {
		return keynum;
	}
	
	public Action getCap() {
		return cap;
	}
	
	public GLogicalFormula getPre() {
		return pre;
	}
	
	public GLogicalFormula getPost() {
		return post;
	}

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

	@Override
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

	@Override
	public List<String> getVarNames() {
		ArrayList<String> varnames = new ArrayList<String>();
		varnames.addAll(cap.getVarNames());
		varnames.addAll(pre.getVarNames());
		varnames.addAll(post.getVarNames());
		return varnames;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
		pre.renameVar(oldname, newname);
		post.renameVar(oldname, newname);
	}

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

	@Override
	public boolean isGround() {
		if (cap.isGround()) {
			if (pre.isGround()) {
				return post.isGround();
			}
		}
		
		return false;
	}

	@Override
	public boolean apply(Unifier theta) {
		boolean c = cap.apply(theta);
		boolean p1 = pre.apply(theta);
		boolean p2 = post.apply(theta);
		return (c || p1 || p2);
	}

	@Override
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
		pre.makeVarsAnnon();
		post.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new Capability((GLogicalFormula) pre.strip_varterm(), (Action) cap.strip_varterm(), (GLogicalFormula) post.strip_varterm());
	}
	
	public String toString() {
		String s = "{";
		s += pre;
		s += "} " + cap + " {";
		s += post;
		s += "}";
		return s;
	}

}
