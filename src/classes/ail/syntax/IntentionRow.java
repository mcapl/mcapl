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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;


/**
 * A class for an intention row which associates an event with a stack of guards,
 * deeds and unifiers.
 * 
 * @author louiseadennise
 *
 */
public class IntentionRow implements Cloneable {
	/**
	 * The trigger event for the intention row.
	 */
	protected ail.syntax.Event trigger;
	/**
	 * The guard stack in the row.
	 */
	protected ArrayList<Guard> guardstack = new ArrayList<Guard>();
	/**
	 * The deed stack in the row.
	 */
	protected ArrayList<Deed> body = new ArrayList<Deed>();
	/**
	 * The unifier stack in the row.
	 */
	protected ArrayList<Unifier> unif = new ArrayList<Unifier>();
	/**
	 * An annotation for the row.  Unused by AIL but possibly 
	 * used by subclasses.
	 */
	protected AILAnnotation annotation;
	
	/**
	 * Constructor.  Obvious construction from an event, guard stack, deed stack
	 * and unifier stack.  NB. the stack are all expected to be the same size.
	 *
	 * @param te the event.
	 * @param gs the guard stack.
	 * @param ds the deed stack.
	 * @param us the unifier stack.
	 */
	public IntentionRow(Event te, ArrayList<Guard> gs, ArrayList<Deed> ds, ArrayList<Unifier> us) {
		trigger = te;
		
		for (Guard g : gs) {
			guardstack.add((Guard) g.clone());
		}
		
		for (Deed d: ds) {
			Deed d1 = (Deed) d.clone();
			body.add(d1);
		}
		
		for (Unifier u: us) {
			unif.add(u.clone());
		}
		
		guardstack.trimToSize();
		body.trimToSize();
		unif.trimToSize();
		
	}
	
	/**
	 * Constructor.  This time there is only a single unifier which is then 
	 * duplicated to create a stack of identical unifiers the size of the guard
	 *  and deed stacks which are expected to be the same size.
	 * 
	 * @param te the event.
	 * @param gs the guard stack.
	 * @param ds the deed stack.
	 * @param theta the unifier.
	 */
	public IntentionRow(Event te, ArrayList<Guard> gs, ArrayList<Deed> ds, Unifier theta) {
		this(te, gs, ds, duplicateunifier(theta, ds.size()));
	}
	
	
	/**
	 * Returns a stack of identical unifiers of the requested size.
	 * 
	 * @param theta the unifier to be duplicated.
	 * @param m the size of the desired stack.
	 * @return a stack of identical unifiers.
	 */
	private static ArrayList<Unifier> duplicateunifier(Unifier theta, int m) {
		ArrayList<Unifier> us = new ArrayList<Unifier>();
		
		for (int n = 0; n < m; n++) {
			us.add(theta.clone());
		}
		
		us.trimToSize();
		return us;
	}
	
	/**
	 * Converts the intention row to a string for printing.
	 * 
	 * @return the intention row as a string.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		ListIterator<Guard> gi = guardstack.listIterator();
		ListIterator<Deed> di = body.listIterator();
		ListIterator<Unifier> ui = unif.listIterator();
		
		StringBuilder s1 = new StringBuilder();
		String triggers = trigger.toString();
		while (gi.hasNext()) {
			StringBuilder ir = new StringBuilder();
			Guard gu = gi.next();
			Deed d = di.next();
			Unifier u = ui.next();
			
			ir.append("      ");
			ir.append(triggers).append("||").append(gu).append("||").append(d).append("||").append(u).append("\n");
			ir.append(s1);
			s1 = ir;
		}
		s.append(s1.substring(6));
		
		if (annotation != null) {
			s.append(annotation);
		}
		
		return s.toString();
	}
	
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		}
		
		StringBuilder s = new StringBuilder();
		
		ListIterator<Guard> gi = guardstack.listIterator();
		ListIterator<Deed> di = body.listIterator();
		ListIterator<Unifier> ui = unif.listIterator();
		
		StringBuilder s1 = new StringBuilder();
		String triggers = trigger.toString(descriptions);
		while (gi.hasNext()) {
			StringBuilder ir = new StringBuilder();
			Guard gu = gi.next();
			Deed d = di.next();
			Unifier u = ui.next();
			
			ir.append("      ");
			ir.append(triggers).append("||").append(gu.toString(descriptions)).append("||");
			ir.append(d.toString(descriptions)).append("||").append(u).append("\n");
			ir.append(s1);
			s1 = ir;
		}
		s.append(s1.substring(6));
		
		if (annotation != null) {
			s.append(annotation);
		}
		
		return s.toString();
	}
	
	/**
	 * Getter method for the intention row's event.
	 * 
	 * @return The trigger event of the intention.
	 */
	public  Event getEvent() {
		return trigger;
	}
	
	/**
	 * Setter method for the intention row's annotation.
	 * 
	 * @param ann the annotation.
	 */
	public  void setAnnotation(AILAnnotation ann) {
		annotation = ann;
	}
	
	/**
	 * Getter method for the intention row's annotation.
	 * 
	 * @return the intention's annotation.
	 */
	public  AILAnnotation getAnnotation() {
		return(annotation);
	}
	
	/**
	 * Getter method for the intention row's deed stack.
	 * 
	 * @return the intention row's deed stack.
	 */
	public  ArrayList<Deed> deeds() {
		return body;
	}
	
	/**
	 * Getter method for the intention row's unifier stack.
	 * 
	 * @return the intention row's unifier stack.
	 */
	public  ArrayList<Unifier> unifiers() {
		return unif;
	}
	
	/**
	 * Getter method for the intention row's guard stack.
	 * 
	 * @return the intention row's guard stack.
	 */
	public  ArrayList<Guard> guards() {
		return guardstack;
	}
	
	/**
	 * Change the top guard on this intention row.  Used when leaving a 
	 * goal deed on the stack (Achieve goals).
	 * 
	 * @param g the guard to replace.
	 */
	public  void setTopGuard(Guard g) {
		if (! guardstack.isEmpty()) {
			guardstack.remove(guardstack.size() - 1);
			guardstack.add(g);
		}
	}
	
	/**
	 * Drop n items from the deed, guard and unifier stacks.
	 * 
	 * @param n the number of items to drop.
	 */
	public  void dropIR(int n) {
			for(int m = 0; m < n; m++) {
				body.remove(body.size() - 1);
				unif.remove(unif.size() - 1);
				guardstack.remove(guardstack.size() - 1);
			}
			
			body.trimToSize();
			unif.trimToSize();
			guardstack.trimToSize();
	}
	
	/**
	 * Does this row represent an unplanned event?
	 * 
	 * @return Whether this row represents an unplanned event.
	 */
	public boolean unplanned() {
		if (deeds().size() == 1) {
			if (deeds().get(0).getCategory() == Deed.Dnpy) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof IntentionRow) {
			IntentionRow ir = (IntentionRow) o;
			if (! this.getEvent().equals(ir.getEvent())) {
				return false;
			}
			
			if (! this.guards().equals(ir.guards())) {
				return false;
			}
			
			if (! this.deeds().equals(ir.deeds())) {
				return false;
			}
			
			if (! this.unifiers().equals(ir.unifiers())) {
				return false;
			}
			
			if (this.getAnnotation() == null) {
				if (ir.getAnnotation() == null) {
					return true;
				}
				return false;
			}
			
			if (ir.getAnnotation() == null || ! this.getAnnotation().equals(ir.getAnnotation())) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 7;
		int result = PRIME * getEvent().hashCode();
		
		for (Guard g: guards()) {
			result = PRIME * result + g.hashCode();
		}
		
		for (Deed d: deeds()) {
			result = PRIME * result + d.hashCode();
		}
		
		for (Unifier u: unifiers()) {
			result = PRIME * result + u.hashCode();
		}
		
		if (getAnnotation() != null) {
			result = PRIME * result + getAnnotation().hashCode();
		}
		return result;
		
	}
	
	/**
	 * Get a list of all the variable names mentioned in the intention.  Useful when standardising
	 * apart.
	 * @return
	 */
	public List<String> getVarNames() {
     	ArrayList<String> varnames = new ArrayList<String>();
     	varnames.addAll(trigger.getVarNames());
     	for (Deed d: body) {
     		varnames.addAll(d.getVarNames());
     	}
     	for (Guard g:guardstack) {
     		varnames.addAll(g.getVarNames());
     	}
    	return varnames;
	}
	
	/**
	 * Remove unused variable names from the unifier/
	 * @param varnames
	 */
	public void trimUnifiers(Set<String> varnames) {
		varnames.addAll(trigger.getVarNames());
		for (int i = body.size(); i > 0; i--) {
			varnames.addAll(body.get(i - 1).getVarNames());
			varnames.addAll(guardstack.get(i - 1).getVarNames());
			Unifier u = unif.get(i - 1);
			u.pruneRedundantNames(varnames);
		}

	}

	public IntentionRow clone() {
		return new IntentionRow(getEvent().clone(), guardstack, body, unif);
	}
}
