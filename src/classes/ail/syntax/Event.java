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

import ail.tracing.explanations.PredicateDescriptions;
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
	
	@FilterField
	public static final byte    FromPercept = 11;

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
	
	public Event(Goal g) {
		this(Event.AILAddition, g);
	}
	
	/**
	 * Construct an event from an add/delete flag, a category and a message.
	 * @param t
	 * @param c
	 * @param msg
	 */
	public Event(int t, byte c, Message msg) {
		super(t, c, msg);
	}
	
		
	/**
	 * Is this a start event?
	 * 
	 * @return whether this is a start event.
	 */
	public boolean isStart() {
		return (getCategory() == Estart);
	}
	
	public boolean fromPercept() {
		return (getCategory() == FromPercept);
	}

	/**
	 * Get a predicateindicator for the event.
	 * @return
	 */
	public PredicateIndicator getPredicateIndicator() {
        if (piCache == null) {
            String s = "";
            if (isStart()) {
            	piCache = new PredicateIndicator("start", 0);
             } else if (fromPercept()) {
            	 piCache = new PredicateIndicator("from perception", 0);
             } else {
            	if (isAddition())
            		s += "+";
            	else if (isDeletion())
            		s += "-";
            	else if (isUpdate())
            		s += "+-";
            	if (getContent() instanceof PredicateTerm) {
            		if (getContent() instanceof Goal) {
            			s += "!";
            		}
            		piCache = new PredicateIndicator(s + ((PredicateTerm) getContent()).getFunctor(), ((PredicateTerm) getContent()).getTermsSize());
            	} else if (getContent() instanceof HasTermRepresentation) {
            		Term t = ((HasTermRepresentation) getContent()).toTerm();
            		piCache = new PredicateIndicator(s + t.getFunctor(), t.getTermsSize());
            	} else {
            		piCache = new PredicateIndicator(s + "not_a_predicate", 0);
            	}
            }
        }
        return piCache;
    }
	
	public PredicateIndicator getPurePredicateIndicator() {
        if (piCache == null) {
            String s = "";
            if (isStart()) {
            	piCache = new PredicateIndicator("start", 0);
             } else if (fromPercept()) {
            	 piCache = new PredicateIndicator("from perception", 0);
             } else {
            /*	if (isAddition())
            		s += "+";
            	else if (isDeletion())
            		s += "-";
            	else if (isUpdate())
            		s += "+-"; 
            	if (getContent() instanceof PredicateTerm) {
            		if (getContent() instanceof Goal) {
            			s += "!";
            		}
            		piCache = new PredicateIndicator(s + ((PredicateTerm) getContent()).getFunctor(), ((PredicateTerm) getContent()).getTermsSize());
            	} else */
            	if (getContent() instanceof HasTermRepresentation) {
            		Term t = ((HasTermRepresentation) getContent()).toTerm();
            		piCache = new PredicateIndicator(s + t.getFunctor(), t.getTermsSize());
            	} else {
            		piCache = new PredicateIndicator(s + "not_a_predicate", 0);
            	}
            }
        }
        return piCache;
    }

	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#clone()
	 */
	@Override
	 public Event clone() {
			if (hasContent()) {
				if (referstoGoal())  {
					return (new Event(getTrigType(), ((Goal) getContent()).clone()));
				} else if (referstoSentMessage()) {
					return (new Event(getTrigType(), getCategory(), ((Message) getContent()).clone()));
				} else {
					if (getContent() instanceof Message) {
						return (new Event(getTrigType(), getCategory(), ((Message) getContent()).clone()));
						//Predicate content = (Predicate) ((Message) getContent()).getPropCont();
					//	return (new Event(getTrigType(), getCategory(), new Literal(true, content)).clone());
					}
					return (new Event(getTrigType(), getCategory(), ((Literal) getContent()).clone()));
				}
			} else {
				return (new Event(getCategory()));
			}
		}
		

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (isStart()) {
			s.append("start");
		} else if (fromPercept()) {
			s.append("perceived");
		} else {
			if (isAddition())
				s.append("+");
			else
				s.append("x");
			if (referstoGoal()) {
				s.append("!");
				s.append(getContent());
			} else {
				s.append(getContent());
			}
		}
		return s.toString();
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		}
		
		StringBuilder s = new StringBuilder();
		if (isStart()) {
			s.append("start");
		} else if (fromPercept()) {
			s.append("perceived");
		} else {
			if (isAddition())
				s.append("added the ");
			else
				s.append("deleted the ");
			switch (getCategory()) {
			case DefaultAILStructure.AILBel:
				s.append("belief");
				break;
			case DefaultAILStructure.AILGoal:
				s.append("goal");
				break;
			case DefaultAILStructure.AILReceived:
				s.append("received message");
				break;
			case DefaultAILStructure.AILSent:
				s.append("sent message");
				break;
			default:
				break;
			}
			s.append(" ").append(getContent().toString(descriptions));
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#isEvent()
	 */
	@Override
	public boolean isEvent() {
		return true;
	}
		   
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable e, Unifier u) {
		Event e1 = (Event) e;
		
		if (isStart()) {
			return sameType(e1);
		} else if (fromPercept()) {
			return sameType(e1);
		} else {
			return sameType(e1) && u.unifies(getContent(), e1.getContent());
		}
 		   
	}
	   
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isVar()
	 */
	@Override
	public boolean isVar() {
		if (hasContent()) {
			if (getContent() instanceof Term) {
				return ((Term) getContent()).isVar();
			}
			return false;
		} else {
			return false;
		}
	}
	
	/**
	 * Equals if content is a variable.
	 */
	public boolean varequals(DefaultAILStructure s) {
		if (hasContent()) {
			if (!referstoGoal()) {
				return (((Term) getContent()).isVar() && getContent().equals(s.getContent()));
			} else {
				return (((Term) getContent()).isVar() && getContent().equals(s.getContent()));
			}
		} else {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		if (hasContent()) {
			Set<String> varnames = getContent().getVarNames();
			return varnames;
		}
		return new HashSet<String>();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isGround()
	 */
	@Override
	public boolean isGround() {
		if (hasContent()) {
			return getContent().isGround();
		} 
		
		return true;
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
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	   public boolean match(Unifiable t1g, Unifier u) {
	    	boolean ok = false;
	    	if (t1g instanceof Event) {
	    		Event e = (Event) t1g;
	    		if (e.getCategory() == getCategory()) {
	    			if (e.hasContent()) {
	    				if (hasContent()) {
	    					ok = u.matchTerms((Term) getContent(), (Term) e.getContent());
	    				}
	    			} else if (!hasContent()) {
	    				ok = true;
	    			}
	    			
	    		}
	    	}

	    	return ok;
	    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	   public boolean matchNG(Unifiable t1g, Unifier u) {
	    	boolean ok = false;
	    	if (t1g instanceof Event) {
	    		Event e = (Event) t1g;
	    		if (e.getCategory() == getCategory()) {
	    			if (e.hasContent()) {
	    				if (hasContent()) {
	    					ok = u.matchTermsNG((Term) getContent(), (Term) e.getContent());
	    				}
	    			} else if (!hasContent()) {
	    				ok = true;
	    			}
	    			
	    		}
	    	}

	    	return ok;
	    }


}
