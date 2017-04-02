// ----------------------------------------------------------------------------
// Copyright (C) 2014-16 Louise A. Dennis, Michael Fisher
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

import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;

import ail.semantics.AILAgent;

/**
 * This is an iterator for Evaluation Bases.  The Iterator returns potential unifiers 
 * for objects within the Evaluation Base.
 * @author louiseadennis
 *
 * @param <K>
 */
public class EvaluationBaseIterator<K extends Unifiable> implements Iterator<Unifier> {
	// The relevant Evaluation Base
	EvaluationBase<K> eb;
	// The Initial Unifier
	Unifier un;
	// The Unifiable to be matched against the evalution base.
	EBCompare<K> ga;
	// An iterator of elements in the Evaluation Base that may unify with ga.
	Iterator<K> il;
	
 	/**
   	 * This holds the current unification solution.
   	 */
	@FilterField
	Unifier current = null;

	
	public EvaluationBaseIterator(EvaluationBase<K> e, Unifier u, EBCompare<K> g, AILAgent.SelectionOrder so) {
		eb = e;
		un = u;
		ga = g;
		il = eb.getRelevant(ga, so);
	} 

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (current == null)
			get();
		return current != null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Unifier next() {
		if (current == null)
			get();
		Unifier a = current;
		current = null; //get();
		return a;
	}

   	/**
   	 * Work horse method that calculate the next unifier.
   	 *
   	 */
   	private void get() {
   		current = null;
   		// il is all possible Beliefs/messages/whatever that potentially unify with this GBelief
   		if (il != null) {
   			while (il.hasNext()) {
   				Unifier unC = (Unifier) un.clone();
   				Unifiable u = il.next();
   				Unifiable h2 = (Unifiable) ga.clone();
   				if (h2.unifies(u, unC)) {
   					current = unC;
      					return;
   				}
   			}
   		}
   	}

   	/*
   	 * (non-Javadoc)
   	 * @see java.util.Iterator#remove()
   	 */
   	public void remove() {
   	}
}
