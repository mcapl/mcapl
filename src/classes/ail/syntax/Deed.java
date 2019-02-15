// ----------------------------------------------------------------------------
// Copyright (C) 2008-2016 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import java.util.HashSet;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.tracing.explanations.PredicateDescriptions;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Implements a class for AIL Deeds.  This may contain a term (Actions) or a 
 * literal (add/delete goals, add/delete beliefs).  They may also be the 
 * no-plan-yet Deed, a backtrack Deed, or a add/delete lock.
 * 
 * @author louiseadennis
 *
 */
public class Deed extends DefaultAILStructure {

    /**
	 * The possible categories of Deed, represented as bytes.
	 */
	@FilterField
	public static final byte	DAction 	= AILAction;
	@FilterField
    public static final byte	Dnpy = 10;
	// Backtrack deeds untested.
	@FilterField
    public static final byte	Dbacktrack = 11;
	@FilterField
    public static final byte 	Dlock = 12;
	@FilterField
    public static final byte	Dwaitfor = 13;
	@FilterField
    public static final byte	DNull = 14;
	
	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 */
	private StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultBBname);

	/**
	 * Setter for DBnum.
	 * @param n
	 */
    public void setDBnum(StringTerm n) {
    	DBnum = n;
    }
    
    /**
     * Setter for DB num - converts from in to StringTerm.
     * @param n
     */
    public void setDBnum(int n) {
    	DBnum = new StringTermImpl(((Integer) n).toString());
    }
 
    /**
     * Getter for DBnum.
     * @return
     */
    public StringTerm getDBnum() {
    	return DBnum;
    }

    /**
     * Construct a deed from a term, must be an action.
     * 
     * @param t the action.
     */
    public Deed(Predicate t) {
    	super(DAction);
    	if (t instanceof Action) {
    		setContent(t);
    	} else {
    		setContent(new Action(t, Action.normalAction));
    	}
    }
    
    /**
     * Construct a deed from an action.
     * @param a
     */
    public Deed(Action a) {
    	super(DAction);
    	setContent(a);
    }
    
    /**
     * Construct a Deed from an addition/deletion flag, Category and literal.
     * 
     * @param t whether the deed is an addition or deletion.
     * @param b the category of the deed.
     * @param l the literal contained in the deed.
     */
    public Deed(int t, byte b, Unifiable l) {
    		super(t, b, l);
    }
        
    /**
     * Construct a Deed from an addition/deletion flag and a goal.  The
     * Category is determined to be a Goal category automatically.
     * 
     * @param t whether this is an add goal or delete goal Deed.
     * @param g the goal to be added or deleted.
     */
    public Deed(int t, Goal g) {
    	super(t, g);
    	setDBnum(g.getGoalBase());
    }
    
    /**
     * Construct a Deed just from a Category.  To be used for no-plan-yet
     * and backtrack.
     * 
     * @param b the Category of the Deed.
     */
    public Deed(byte b) {
    	super(b);
    }
    
    /**
     * Construct a Deed from an addition/deletion flag and a Category.
     * @param b whether the deed is an addition or a deletion.
     * @param by the category of the deed.
     */
    public Deed(int b, byte by) {
    	super(b, by);
    }
    
    /**
     * Construct a Deed from an addition/deletion flag, a category and a string.
     * Intended to support deeds based on group members - the string is a group.
     * @param t
     * @param b
     * @param s
     */
    public Deed(int t, byte b, String s) {
    	super(t, b, s);
    }

	/**
     * Is the Deed an Action?
     * 
     * @return whether the deed is an action.
     */
    public boolean isAction() {
    	return (getCategory() == DAction);
    }
  
    /**
     * Is the Deed equal to another Object.
     */
    @Override
  	public boolean equals(Object o) {
    	return (super.equals(o));
	}

  	/**
  	 * Is this a no-plan-yet deed?
  	 * 
  	 * @return whether this is a no-plan-yet deed.
  	 */
	public boolean isNPY() {
		return (getCategory() == Dnpy);
	}

	/**
	 * Clone the Deed.
	 */
	@Override
	public Deed clone() {
		if (isAction()) {
			Deed c = new Deed((Predicate) getContent().clone());
			c.setDBnum((StringTerm) getDBnum().clone());
			return c;
		} else {
			if (hasContent()) {
				if (referstoGoal()) {
					Deed d1 = new Deed(getTrigType(), (Goal) getContent().clone());
					d1.setDBnum((StringTerm) getDBnum().clone());
					return d1;
				} else {
					Deed d1 = new Deed(getTrigType(), getCategory(), (Unifiable) getContent().clone());
					d1.setDBnum((StringTerm) getDBnum().clone());
					return d1;
				}
			} else 	{
				if (hasTrigType()) {
					Deed d1 = new Deed(getTrigType(), getCategory());
					d1.setDBnum((StringTerm) getDBnum().clone());
					return d1;
				} else {
					Deed d1 = new Deed(getCategory());
					d1.setDBnum((StringTerm) getDBnum().clone());
					return d1;
				}
			}
		}
	}

   
	/**
	 * Is this a deed? Yes.
	 */
	public boolean isDeed() {
		return true;
	}
	
	/**
	 * Is this a backtrack deed? Yes.
	 * 
	 * @return whether this is a backtrack deed.
	 */
	public boolean isBacktrack() {
		return (getCategory() == Dbacktrack);
	}
	
	/**
	 * Is this a locking or unlocking deed? 
	 * 
	 * @return whether this is a locking or unlocking deed.
	 */
	public boolean isLock() {
		return (getCategory() == Dlock);
	}

	/**
	 * Is this a null deed?
	 */
	public boolean isNull() {
		return (getCategory() == DNull);
	}

	   /**
	 * Convert the deed to a string for printing.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (hasTrigType()) {
			if (isAddition())	
				s.append("+");
			else if (isDeletion())
				s.append("-");
			else if (isUpdate())
				s.append("+-");
		}
			
		if (referstoGoal()) {
			s.append("!");
			s.append(getContent());
		} else if (getCategory() == Dwaitfor) {
			s.append("*...");
			s.append(getContent());
		} else if (hasContent()) {
			s.append(getContent());
		} else if (isNPY()) {
			s.append("which has no plan yet");
		} else if (isBacktrack()) {
			s.append("backtrack");
		} else if (isNull()) {
			s.append("null");
		} else {
			s.append("lock");
		}
		
		String num = getDBnum().toString();
		if (num.length() > 2) { // more than just quotes
			s.append("(").append(num).append(")");
		}
		
		return s.toString();
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		}
		
		StringBuilder s = new StringBuilder();
		if (hasTrigType()) {
			if (isAddition())	
				s.append("add ");
			else if (isDeletion())
				s.append("delete ");
			else if (isUpdate())
				s.append("update ");
		}
			
		if (referstoGoal()) {
			s.append("the goal ").append(getContent().toString(descriptions));
		} else if (getCategory() == Dwaitfor) {
			s.append("wait for ").append(getContent().toString(descriptions));
		} else if (hasContent()) {
			s.append(getContent().toString(descriptions));
		} else if (isNPY()) {
			s.append("which has no plan yet");
		} else if (isBacktrack()) {
			s.append("backtrack");
		} else if (isNull()) {
			s.append("null");
		} else {
			s.append("lock");
		}
		
		String num = getDBnum().toString();
		if (num.length() > 2) { // more than just quotes
			s.append("(").append(num).append(")");
		}
		
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Term#fullstring()
	 */
	@Override
	public String fullstring() {
		return toString();
	}
	
	/**
	 * Apply a unifier to the deed.
	 */
	@Override
	public boolean apply(Unifier theta) {
		boolean result = false;
		
		if (isAction()) {
			result = ((Action) getContent()).apply(theta);
		} else {
			result = super.apply(theta);
		}
		
		return result;
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (isAction()) {
			return new Deed(new Action((Predicate) ((Action) getContent()).substitute(term, subst), ((Action) getContent()).actiontype));
		} else {
			return new Deed(this.getTrigType(), getCategory(), super.substitute(term, subst));
		}
	}
		
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable e, Unifier u) {
		Deed d1 = (Deed) e;
  		
		if (!hasContent()) {
			return sameType(d1);
		} else {
			return sameType(d1) && u.unifies(d1.getContent(), getContent());
		}
		   
	}
 
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		Set<String> varnames = new HashSet<String>();
		if (hasContent()) {
			varnames = getContent().getVarNames();
		}
		varnames.addAll(getDBnum().getVarNames());
		return varnames;
	}
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
		if (hasContent()) {
			getContent().renameVar(oldname, newname);
		}
		getDBnum().renameVar(oldname, newname);
	}

}
