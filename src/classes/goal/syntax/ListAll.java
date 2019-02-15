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

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;
import ail.syntax.DefaultAILStructure;
import ail.syntax.GLogicalFormula;
import ail.syntax.Guard;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Term;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.tracing.explanations.PredicateDescriptions;
import goal.syntax.ast.Abstract_MentalState;

public class ListAll implements GLogicalFormula {
	ListTerm list;
	Guard mental_state;
	Set<String> ms_varnames;
	
	public ListAll(ListTerm v, Guard ms) {
		list = v;
		mental_state = ms;
		ms_varnames = mental_state.getVarNames();
	}
	
	public ListAll(ListTerm v, Abstract_MentalState ms) {
		if (ms.isMacro()) {
			ms_varnames = ms.getKey().toMCAPL().getVarNames();
			mental_state = ms.toMCAPL();
		} else {
			mental_state = ms.toMCAPL();
			ms_varnames = mental_state.getVarNames();
		}
		list = v;
		// ms_varnames = mental_state.getVarNames();
	}

	public ListTerm getList() {
		return list;
	}
	
	public Guard getMS() {
		return mental_state;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (l.getMS().unifies(getMS(), u)) {
				if (l.getList().unifies(getList(), u)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
	   	Set<String> tvarnames = t.getVarNames();
    	Set<String> myvarnames = getVarNames();
    	tvarnames.addAll(varnames);
    	HashSet<String> replacednames = new HashSet<String>();
    	HashSet<String> newnames = new HashSet<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    		    	for (String n: ms_varnames) {
    		    		if (n.equals(s)) {
    		    			replaceName(n, s);
    		    		}
    		    	}
    			}
    		}
    	}		
	}

	@Override
	public Set<String> getVarNames() {
		Set<String> varnames = new HashSet<String>();
		varnames.addAll(list.getVarNames());
		varnames.addAll(mental_state.getVarNames());
		return varnames;
	}
	
	private void replaceName(String oldname, String newname) {
		ms_varnames.remove(oldname);
		ms_varnames.add(newname);		
	}

	@Override
	public void renameVar(String oldname, String newname) {
		list.renameVar(oldname, newname);
		mental_state.renameVar(oldname, newname);
		for (String s: ms_varnames) {
			if  (s.equals(oldname)) {
				replaceName(oldname, newname);
			}
		}
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (getMS().match(l.getMS(), u)) {
				if (getList().match(l.getList(), u)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (getMS().matchNG(l.getMS(), u)) {
				if (getList().matchNG(l.getList(), u)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isGround() {		
		return (list.isGround() && mental_state.isGround());
	}

	@Override
	public boolean apply(Unifier theta) {
		return (list.apply(theta) && mental_state.apply(theta));
	}

	@Override
	public void makeVarsAnnon() {
		list.makeVarsAnnon();
		mental_state.makeVarsAnnon();
		for (String s: ms_varnames) {
			replaceName(s, "_");
		}
	}

	@Override
	public Unifiable strip_varterm() {
		return new ListAll((ListTerm) list.strip_varterm(), (Guard) mental_state.strip_varterm());
	}

	@Override
	public Unifiable resolveVarsClusters() {
		return new ListAll((ListTerm) list.resolveVarsClusters(), (Guard) mental_state.resolveVarsClusters());
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag,
			Unifier un, Set<String> varnames, SelectionOrder so) {
		Iterator<Unifier> allms = mental_state.logicalConsequence(ag, un, varnames, so);
		ListTermImpl newlist = new ListTermImpl();
		while (allms.hasNext()) {
			Unifier u = allms.next();
			ListTermImpl vartuple = new ListTermImpl();
			for (String s: ms_varnames) {
				Term t = u.get(s);
				vartuple.add(t);
			}
			newlist.add(vartuple);
		}
		if (list instanceof VarTerm) {
			list.unifies(newlist, un);
			return Guard.createUnifIterator(un);
		} else if (list.equals(newlist)){
			return Guard.createUnifIterator(un);
		} else {
			return Collections.emptyIterator();
		}
	}

	@Override
	public ListAll clone() {
		return new ListAll((ListTerm) list.clone(), mental_state.clone());
	}
	
	@Override
	public String toString() {
		String s = "listall ";

		s += list.toString();
		s+= " <- ";
		s += mental_state.toString();
		return s;
	}	
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		String s = "listall ";
		s += list.toString(descriptions);
		s += " <- ";
		s += mental_state.toString(descriptions);
		return s;
	}

	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (this.equals(term)) {
			return subst;
		} else {
			ListTerm l = (ListTerm) list.substitute(term, subst);
			Guard g = (Guard) mental_state.substitute(term, subst);
			return new ListAll(l, g);
		}
	}

}
