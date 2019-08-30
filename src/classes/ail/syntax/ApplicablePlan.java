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
//----------------------------------------------------------------------------

package ail.syntax;

import ail.syntax.Event;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.util.AILPrettyPrinter;

import java.util.ListIterator;
import java.util.ArrayList;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Applicable plans are a tuple of an event, a stack of deeds (the prefix), a 
 * stack of guards, an integer n and a unifier theta.  The intended semantics
 * is that n rows should be dropped from the intention and replaced by the
 * new prefix, associated event, guards and unifier.
 * 
 * @author louiseadennis
 *
 */
public class ApplicablePlan implements Comparable<ApplicablePlan> {
	/**
	 * The plan trigger event.
	 */
	protected Event event;
	/**
	 * The new intention prefix.
	 */
	protected ArrayList<Deed> prefix = null;
	/**
	 * The guards that match the new deed stack.
	 */
	protected ArrayList<Guard> guards = null;
	/**
	 * The number of lines to be dropped from the intention.
	 */
	protected int n;
	/**
	 * The unifier.
	 */
	protected Unifier theta;
	/**
	 * A unique number for the plan, may be useful in selection heuristics.
	 */
	@FilterField
	protected int keynum;
	/**
	 * Designator of plan library the plan came from
	 */
	@FilterField
	protected String libname;
	
	protected AILPrettyPrinter pretty_printer;
	
	/**
	 * Constructor for the special case where a plan is to make no change to the intention.
	 */
//	public ApplicablePlan() {
//	}
		
	/**
	 * Constructor.
	 * 
	 * @param e the event.
	 * @param p the stack of deeds that replace the deeds in the top rows of the intention.
	 * @param g the stack of guards that replace the guards in the top rows of the intention.
	 * @param nu the number of rows to be dropped.
	 * @param th the unifier.
	 * @param id an id number.
	 */
	public ApplicablePlan(Event e, ArrayList<Deed> p, ArrayList<Guard> g, int nu, Unifier th, int id, String libid, AILPrettyPrinter pretty) {
		event = e;
		prefix = p;
		guards = g;
		n = nu;
		keynum = id;
		libname = libid;
		theta = th;
		pretty_printer = pretty;
	}
		
	/**
	 * Getter for the plan ID.
	 * @return the plan id.
	 */
	public int getID() {
		return keynum;
	}
	
	/**
	 * Getter for the library name.
	 * @return
	 */
	public String getLib() {
		return libname;
	}
	
	/**
	 * Getter method for the plan's event.
	 * 
	 * @return the plan's event.
	 */
	public Event getEvent() {
		return event;
	}
	
	/**
	 * Getter method for the plan's prefix.
	 * 
	 * @return the stack of deeds to replace the dop of the intention.
	 */
	public ArrayList<Deed> getPrefix() {
		return prefix;
	}
	
	/**
	 * Getter method for the plan's guards.
	 * 
	 * @return the stack fo guards to replace the top of the intention.
	 */
	public ArrayList<Guard> getGuard() {
		return guards;
	}
	
	/**
	 * Getter method for the plan's integer.
	 * 
	 * @return the number of rows to be dropped from the intention.
	 */
	public int getN() {
		return n;
	}
	
	/**
	 * Getter method for the plan's unifier.
	 * 
	 * @return the plan's unifier.
	 */
	public Unifier getUnifier() {
		return theta;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return equals((ApplicablePlan) o);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ApplicablePlan p) {
/*		if (nochange) {
			if (p.noChangePlan()) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (p.noChangePlan()) {
				return 1;
			}
		} */

		if (getID() == p.getID()) {
			return theta.compareTo(p.getUnifier());
		} else {
			if (getID() < p.getID())
				return -1;
			else
				return 1;
		}
		
	}
	
	/**
	 * Helper function for equals in Comparable interface.
	 * @param p
	 * @return
	 */
	public boolean equals(ApplicablePlan p) {
		/* if (nochange) {
			if (p.noChangePlan()) {
				return true;
			} else {
				return false;
			}
		} else {
			if (p.noChangePlan()) {
				return false;
			}
		} */
		if (event.equals(p.getEvent())) {
			if (guards.equals(p.getGuard())) {
				if (prefix.equals(p.getPrefix())) {
					if (n == p.getN()) {
						if (theta.equals(p.getUnifier())){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	//public boolean noChangePlan() {
	//	return nochange;
	//}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    public int hashCode() {
    	//if (nochange) {
    	//	return 0;
    	//}
    	final int PRIME = 7;
    	int result = PRIME * (libname.hashCode() ^ n) + event.hashCode();
    	for (Guard g: guards) {
    		result = PRIME * result + g.hashCode();
    	}
    	result = PRIME * result + theta.hashCode();
     	for (Deed d: prefix) {
    		result = PRIME * result + d.hashCode();
    	}
    	return result;
    }
	
	/**
	 * Converts the applicable plan to a string.  Something odd here - 
	 * deed stack appears inverted.
	 * 
	 * @return the plan as a string.
	 */
	public String toString() {
		return pretty_printer.prettyAppPlan(this);

	}

	/**
	 * Smaller print function.  Provides minimal information for uniquely
	 * identifying the applicable plan.
	 * @return
	 */
	public String keyString() {
		String s = "";
		//if (nochange) {
		//	s += "NO CHANGE";
		//} else {
			s += keynum;
			s += " ~ ";
			s += libname;
			s += getUnifier().toString();
		//}
		return s;
	}


}
