// ----------------------------------------------------------------------------
// Copyright (C) 2008-2015 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import ajpf.util.AJPFLogger;
import gov.nasa.jpf.annotation.FilterField;

/**
 * A class for AIL Actions.  These are terms with some scope for extension.
 * 
 * @author louiseadennis
 *
 */
public class Action extends Predicate {
	/**
	 * Normally actions are just predicates, but we may want special actions
	 * with particular content.  AIL defines some here.
	 */
	@FilterField
	public final static int normalAction = 0;
	@FilterField
	public final static int sendAction = 1;
	@FilterField
	public final static int synchronisedJoin = 2;
	@FilterField
	public final static int synchronisedAdopt = 3;
	@FilterField
	public final static int receivedAction = 4;
	
	@FilterField
	public int loglevel = AJPFLogger.INFO;
	
	/**
	 * By default an action is a normalAction (i.e. a term).
	 */
	@FilterField
	int actiontype = normalAction;
	

	/**
	 * Create an action from a String.
	 * 
	 * @param s the string.
	 */
	public Action(String s) {
		super(s);
	}
	
	/**
	 * Create an action from a string and an action type.
	 * 
	 * @param s The string represented the action predicate.
	 * @param n The type of the action.
	 */
	public Action(String s, int n) {
		super(s);
		actiontype = n;
	}
	
	/**
	 * Construct an action from a predicate and an action type.
	 * 
	 * @param s The structure representing the action.
	 * @param n The type of the action.
	 */
	public Action(Predicate s, int n) {
		super(s);
		actiontype = n;
	}
	
	/**
	 * Create one action from another.
	 * 
	 * @param a
	 */
	public Action(Action a) {
		super((Predicate) a);
		actiontype = a.getActionType();
	}
	
	/**
	 * Getter method for the action type.
	 * 
	 * @return the type of the action.
	 */
	public int getActionType() {
		return actiontype;
	}
	
	/**
	 * Setter for the actiontype.  Protected so the type can
	 * only be set by sub-classes.
	 * 
	 * @param i the new action type.
	 */
	public void setActionType(int i) {
		actiontype = i;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#clone()
	 */
	@Override
	public Action clone() {
		Predicate p = (Predicate) super.clone();
		return(new Action(p, getActionType()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#sameStructureType(ail.syntax.Predicate)
	 */
	public boolean sameStructureType(Predicate s) {
		if (s instanceof Action) {
			return (actiontype == ((Action) s).getActionType());
		}
		
		return false;
	}
	
	/**
	 * Set the log level at which this action should be printed.
	 * This is mostly so "print" actions don't end up getting printed twice during logging at INFO level.
	 * @param level
	 */
	public void setLogLevel(int level) {
		loglevel = level;
	}
	
	/**
	 * Get the logging level at which this action should be printed.
	 * @return
	 */
	public int getLogLevel() {
		return loglevel;
	}
	
	
}
