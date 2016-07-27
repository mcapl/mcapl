// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
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
package ethical_governor.semantics;

import ail.syntax.Action;
import ail.syntax.Predicate;

import java.util.ArrayList;

/**
 * A class that allows an action to be annotated by a set of predicates.  Intended for annotating with outcomes but
 * may have other uses.
 * @author louiseadennis
 *
 */
public class AnnotatedAction {
	private Action action;
	private ArrayList<Predicate> annotation;
	
	/**
	 * Constructor;
	 * @param a
	 * @param outcomes
	 */
	public AnnotatedAction(Action a, ArrayList<Predicate> outcomes) {
		action = a;
		annotation = outcomes;
	}
	
	/**
	 * Getter for the action.
	 * @return
	 */
	public Action getAction() {
		return action;
	}
	
	/**
	 * Getter for the annotations.
	 * @return
	 */
	public ArrayList<Predicate> getAnnotations() {
		return annotation;
	}

}
