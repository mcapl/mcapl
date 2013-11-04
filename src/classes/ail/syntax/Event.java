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

import java.util.List;
import java.util.ArrayList;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A class for AIL events.
 * 
 * @author louiseadennis
 *
 */
public class Event extends DefaultAILStructure implements Unifiable {

    /**
	 * Category for start events.
	 */
	@FilterField
	public static final byte	Estart = 10;

	/**
	 * String for fast lookup.  Not used at the moment but I expect we will
	 * want this for plan look up.
	 */
	@FilterField
	private PredicateIndicator piCache;
	
	/**
	 * Construct an event of a given category.
	 * 
	 * @param b the cateogry.
	 */
	public Event(byte b) {
		super(b);
	}
	
	/**
	 * Construct an event with a given add/delete flag, category and literal.
	 * 
	 * @param t the add/delete flag.
	 * @param b the category.
	 * @param l the literal.
	 */
	public Event(int t, byte b, Literal l) {
		super(t, b, l);
	}
	
	/**
	 * Construct an event from an add/delete flag, category and a group name.
	 * @param t
	 * @param b
	 * @param s
	 */
	public Event(int t, byte b, String s) {
		super(t, b, s);
	}
	
	/**
	 * Construct and event with a given add/delete flag and goal.
	 * 
	 * @param t the add/delete flag.
	 * @param g the goal.
	 */
	public Event(int t, Goal g) {
		super(t, g);
	}
		
	/**
	 * Is this a start event?
	 * 
	 * @return whether this is a start event.
	 */
	public boolean isStart() {
		return (getCategory() == Estart);
	}
	
	/** return [+|-][!|?] super.getFucntorArity */
	public PredicateIndicator getPredicateIndicator() {
        if (piCache == null) {
            String s = "";
            if (isStart()) {
            	piCache = new PredicateIndicator("start", 0);
             } else {
            	if (isAddition())
            		s += "+";
            	else if (isDeletion())
            		s += "-";
            	else if (isUpdate())
            		s += "+-";
            	if (referstoGoal()) {
            		s += "!";
            		piCache = new PredicateIndicator(s + getGoal().getFunctor(), getGoal().getTermsSize());
            	} else {
            		piCache = new PredicateIndicator(s + getLiteral().getFunctor(), getLiteral().getTermsSize());
            	}
            }
        }
        return piCache;
    }
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#clone()
	 */
	 public Event clone() {
			if (hasLiteral()) {
				if (referstoGoal())  {
					return (new Event(getTrigType(), getGoal().clone()));
				} else {
					return (new Event(getTrigType(), getCategory(), (Literal) getLiteral().clone()));
				}
			} else {
				return (new Event(getCategory()));
			}
		}
		

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (isStart()) {
			s.append("start");
		} else {
			if (isAddition())
				s.append("+");
			else
				s.append("x");
			if (referstoGoal()) {
				s.append("!");
				s.append(getGoal().toString());
			} else {
				s.append(getLiteral().toString());
			}
		}
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#isEvent()
	 */
	public boolean isEvent() {
		return true;
	}
		   
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
	 */
	public boolean unifies(Unifiable e, Unifier u) {
		Event e1 = (Event) e;
		
		if (isStart()) {
			return sameType(e1);
		} else {
			return sameType(e1) && u.unifies(e1.getContent(), getContent());
		}
 		   
	}
	   
	/**
	 * Is the event a variable - as in a reactive plan.
	 */
	public boolean isVar() {
		if (hasLiteral()) {
			if (!referstoGoal()) {
				return getLiteral().isVar();
			} else {
				return getGoal().getLiteral().isVar();
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Equals if content is a variable.
	 */
	public boolean varequals(DefaultAILStructure s) {
		if (hasLiteral()) {
			if (!referstoGoal()) {
				return (getLiteral().isVar() && getLiteral().equals(s.getLiteral()));
			} else {
				return (getGoal().getLiteral().isVar() && getGoal().getLiteral().equals(s.getGoal().getLiteral()));
			}
		} else {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	public List<String> getVarNames() {
		if (hasLiteral() || hasTerm()) {
			List<String> varnames = getContent().getVarNames();
			return varnames;
		}
		return new ArrayList<String>();
	}
	
	public boolean isGround() {
		if (hasLiteral() || hasTerm()) {
			return getContent().isGround();
		} 
		
		return true;
	}
	    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	public void renameVar(String oldname, String newname) {
		if (hasLiteral() || hasTerm()) {
			getContent().renameVar(oldname, newname);
		}
	}
	
	   public boolean match(Unifiable t1g, Unifier u) {
	    	boolean ok = false;
	    	if (t1g instanceof Event) {
	    		Event e = (Event) t1g;
	    		if (e.getCategory() == getCategory()) {
	    			if (e.hasLiteral() || e.hasTerm()) {
	    				if (hasLiteral() || hasTerm()) {
	    					ok = u.matchTerms(getContent(), e.getContent());
	    				}
	    			} else if (!hasLiteral() && !hasTerm()) {
	    				ok = true;
	    			}
	    			
	    		}
	    	}

	    	return ok;
	    }

	   public boolean matchNG(Unifiable t1g, Unifier u) {
	    	boolean ok = false;
	    	if (t1g instanceof Event) {
	    		Event e = (Event) t1g;
	    		if (e.getCategory() == getCategory()) {
	    			if (e.hasLiteral() || e.hasTerm()) {
	    				if (hasLiteral() || hasTerm()) {
	    					ok = u.matchTermsNG(getContent(), e.getContent());
	    				}
	    			} else if (!hasLiteral() && !hasTerm()) {
	    				ok = true;
	    			}
	    			
	    		}
	    	}

	    	return ok;
	    }


}
