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
//----------------------------------------------------------------------------

package ail.syntax;

import java.util.ArrayList;
import java.util.List;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Abstract default class for AIL Structures;
 * 
 * @author louiseadennis;
 *
 */
public abstract class DefaultAILStructure extends DefaultTerm implements AILStructure {
	
	/**
	 * Define some useful alias for Belief and Goal Categories and 
	 * Addition and Deletion flags.
	 */
	@FilterField
	public final static byte AILBel = 0;
	@FilterField
	public final static byte AILGoal = 1;
	@FilterField
	public final static byte AILAction = 2;
	@FilterField
	public final static byte AILSent = 3;
	@FilterField
	public final static byte AILContent = 4;
	@FilterField
	public final static byte AILContext = 5;
	@FilterField
	public final static byte AILReceived = 6; 
	@FilterField
	public final static byte AILPlan = 7;
	@FilterField
	public final static byte AILCapability = 8;

	@FilterField
	public final static int AILAddition = 0;
	@FilterField
	public final static int AILDeletion = 1;
	@FilterField
	public final static int AILUpdate = 2;
	@FilterField
	protected PredicateIndicator predicateIndicatorCache = null; // to not compute it all the time (is is called many many times)
	
	/**
	 * The content of the structure, e.g., a Literal, Predicate, Goal etc.,
	 */
	private Unifiable content = null;
	@FilterField
	private boolean hascontent = false;
	
	
	/**
	 * The Structure's literal, if it has one.
	 */
	/* private Literal literal = null;
	@FilterField
	private boolean hasliteral = false; */
	
	/**
	 * The Structure's goal if it has one.
	 */
	/* private Goal goal = null; */
	
	/**
	 * The Structure's category.
	 */
	private byte category;

	/**
	 * The Structure's trigger type.  Defaults to true.
	 */
	private int trigtype = 0;
	@FilterField
	private boolean hastrigtype = false;
	
	/**
	 * The Structure's term if it has one.
	 */
	/* private Predicate term = null;
	@FilterField
	private boolean hasterm = false; */
	
	/**
	 * We need to override hashCode in order to use hash maps with terms
	 * as keys elsewhere in the system.  Java expects equal objects to 
	 * have the same hashsode.
	 */
	@FilterField
	protected Integer hashCodeCache = null;

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
        if (hashCodeCache == null) {
            hashCodeCache = calcHashCode();
        }
        return hashCodeCache;
    }
    
	/**
	 * Calculate the object hashcode.
	 * @return
	 */
    // abstract protected int calcHashCode();
	protected int calcHashCode() {
		final int PRIME = 7;
		int result = getCategory();
		if (hasContent()) {
	    	result = PRIME * result + getContent().hashCode();
	    }

		return result;
	}

	
	/**
	 * Construct an AIL Structure with a given category.
	 * 
	 * @param b the Category for the structure.
	 */
	public DefaultAILStructure(byte b) {
		setCategory(b);
	}
	
	/**
	 * Construct an AIL Structure with a given category containing a literal.
	 * 
	 * @param b the Category.
	 * @param l the literal.
	 */
	public DefaultAILStructure(byte b, Unifiable u) {
		setCategory(b);
		setContent(u);
	}
	
	
	/**
	 * Construct an AIL Structure from a goal.
	 * 
	 * @param g the Goal.
	 */
	public DefaultAILStructure(Goal g) {
		setContent(g);
		setCategory(AILGoal);
	}
	
	public DefaultAILStructure(int t, Goal g) {
		this(g);
		setTrigType(t);
	}

	/**
	 * Construct an AIL Structure from an action.
	 * 
	 * @param a the action.
	 */
	public DefaultAILStructure(Action a) {
		setContent(a);
		setCategory(AILAction);
	}
	
	/**
	 * Construct an AIL Structure from an Add/Delete flag, a Category and
	 * a Literal.
	 * 
	 * @param t the add/delete flag.
	 * @param b the Category.
	 * @param l the Literal.
	 */
	public DefaultAILStructure(int t, byte b, Unifiable l) {
		this(b, l);
		setTrigType(t);
	}
	

	/**
	 * Constructor for creating an AIL Structure from an Add/Delete flag, 
	 * a Category and a String (group/agent name).
	 * 
	 * @param t whether adding or deleting a group.
	 * @param b the cateogory (content or context).
	 * @param s the name of the group agent.
	 */
	public DefaultAILStructure(int t, byte b, String s) {
		this(t, b);
		setContent(new StringTermImpl(s));
	}

		
	/**
	 * Constructor for creating an AIL Structure from  a Category and a String 
	 * (group/agent name).
	 * 
	 * @param b the cateogory (content or context).
	 * @param s the name of the group agent.
	 */
	public DefaultAILStructure(byte b, String s) {
		this(b);
		setContent(new StringTermImpl(s));
	}

	/**
	 * Construct an AIL Structure from an Add/Delete flag and a Category.
	 * 
	 * @param t the add/delete flag.
	 * @param b the category.
	 */
	public DefaultAILStructure(int t, byte b) {
		setCategory(b);
		setTrigType(t);
	}

	/**
	 * Constructor.
	 * @param s
	 */
	public DefaultAILStructure(DefaultAILStructure s) {
		setCategory(s.getCategory());
		if (s.hasTrigType()) {
			setTrigType(s.getTrigType());
		}
		if (hasContent()) {
			setContent(s.getContent());
		} 
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#clone()
	 */
	public abstract AILStructure clone();
	

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#getCategory()
	 */
	public byte getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#getLiteral()
	 */
	/*public Literal getLiteral() {
			return literal;
	} */
	
	public Unifiable getContent() {
		return content;
	}
	
	public boolean hasContent() {
		return hascontent;
	}
	
	/**
	 * Get the literal/goal/term that is contained in the structure.
	 * 
	 * @return
	 */
	/*public Term getContent() {
		if (hasLiteral()) {
			if (referstoGoal()) {
				return goal;
			}
			
			return literal;
		}
		
		return term;
	}*/
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#getTrigType()
	 */
	public int getTrigType() {
		return trigtype;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#getTerm()
	 */
	/*public Predicate getTerm() {
		return term;
	} */
	
	/**
	 * Goal extends literal but for convenience sometimes want to know
	 * its a goal we are getting back.  Assumes, of course, that it is
	 * a goal thats stored. 
	 */
	/* public Goal getGoal() {
		return goal;
	} */

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#hasLiteral()
	 */
	/* public boolean hasLiteral() {
		return hasliteral;
	} */
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#hasTerm()
	 */
	/* public boolean hasTerm() {
		return hasterm;
	} */
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#hasTrigType()
	 */
	public boolean hasTrigType() {
		return hastrigtype;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#isDBelief()
	 */
	public boolean isDBelief() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#isDeed()
	 */
	public boolean isDeed() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#isEvent()
	 */
	public boolean isEvent() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#isGBelief()
	 */
	public boolean isGBelief() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#setCategory()
	 */
	public void setCategory(byte b) {
		category = b;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#setLiteral()
	 */
	//public void setLiteral(Literal l) {
	//	literal = l;
	//	hasliteral = true;
	//}
	
	/**
	 * This is the same as setLiteral.  Should really get rid of it.
	 * 
	 * @param g
	 */
	//public void setGoal(Goal g) {
	//	goal = g;
	//	hasliteral = true;
	//}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#setTrigType(boolean)
	 */
	public void setTrigType(int t) {
        trigtype = t;
        hastrigtype = true;
	}	
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#setTerm(ail.syntax.Term)
	 */
/*	public void setTerm(Predicate t) {
		term = t;
		hasterm = true;
	} */
	
	public void setContent(Unifiable u) {
		content = u;
		hascontent = true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#apply(ail.semantics.Unifier)
	 */
	public boolean apply(Unifier theta) {
			if (hasContent()) {
				if (referstoGoal()) {
					Goal g = (Goal) getContent();
					return g.apply(theta);
				} else {
					return getContent().apply(theta);
				}
			} else {
				return false;
			}
	
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#isAddition()
	 */
	public boolean isAddition() {
		return trigtype == AILAddition;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#isDeletion()
	 */
	public boolean isDeletion() {
		return trigtype == AILDeletion;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#isUpdate()
	 */
	public boolean isUpdate() {
		return trigtype == AILUpdate;
	}
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#referstoBelief()
	 */
	public boolean referstoBelief() {
		return (getCategory() == AILBel || getCategory() == AILReceived || getCategory() == AILSent);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#referstoGoal()
	 */
	public boolean referstoGoal() {
		return (getCategory() == AILGoal);
	}
	
	/**
	 * This structure refers to a message.
	 * @return
	 */
	public boolean referstoSentMessage() {
		return (getCategory() == AILSent);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILStructure#sameType(ail.syntax.AILStructure)
	 */
	public boolean sameType(AILStructure a) {
		if (hasTrigType() ) {
			return (getTrigType() == a.getTrigType() && getCategory() == a.getCategory());
		} else {
			return (getCategory() == a.getCategory());
		}
	}
	
	/**
	 * May be necessary to make an AIL Structures variables anonymous.
	 */
	public void makeVarsAnnon() {
		if (hasContent()) {
			getContent().makeVarsAnnon();
		}
	}
	
	/**
	 * Return those bits of the structure (literal or term) relevant
	 * for unification.  Returns null if there is no literal or term, sub-classes need to
	 * handle this.
	 */
	public Unifiable UnifyingTerm() {
		if (hasContent()) {
		/*	if (referstoGoal()) {
				return getGoal().getLiteral();
			} else {
				return ((Predicate) getLiteral());
			}
		} else if (hasTerm()) {
			return (Predicate) getTerm(); */
			return getContent();
		} else {
			return null;
		}
	}
	

	
	/**
	 * True if this structure is about the content or context of an agent.
	 * 
	 * @return
	 */
	public boolean referstoGroup() {
		if (getCategory() == AILContent | getCategory() == AILContext) {
			return true;
		} else {
			return false;
		}
	}
		
	/**
	 * True if this structure is about a plan.
	 * 
	 * @return
	 */
	public boolean referstoPlan() {
		if (getCategory() == AILPlan) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the name of the group that the structure refers to.
	 * 
	 * @return
	 */
	/* public String getGroupAgentName() {
		Predicate s = (Predicate) term;
		Predicate nameterm = (Predicate) s.getTerm(0);
		return nameterm.getFunctor();				
	} */
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (isVar()) {
			// Refactor
			if (o != null && o instanceof DefaultAILStructure) {
				DefaultAILStructure s = (DefaultAILStructure) o; 
				return varequals(s);
			}
			return(super.equals(o));
		} else {
			if (o != null && o instanceof DefaultAILStructure) {
				DefaultAILStructure a = (DefaultAILStructure) o;
				if (sameType(a)) {
					if (hasContent() && a.hasContent()) {
						return getContent().equals(a.getContent());
						/*if (referstoGoal() && a.referstoGoal()) {
							return (getGoal().equals(a.getGoal()));
						} else if (referstoGoal() && !a.referstoGoal() ){
							return false;
						} else {
							return (getLiteral().equals(a.getLiteral()));
						} */
					/*} else if (hasTerm() && a.hasTerm()) {
						return (getTerm().equals(a.getTerm()));
					} else if (hasTerm()) {
						return false; */
					} else {
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Useful for quick and dirty comparisons.
	 */
	/*public PredicateIndicator getPredicateIndicator() {
		String catstring = ((Byte) getCategory()).toString();
		if (predicateIndicatorCache != null) {
			return predicateIndicatorCache;
		}

		if (hasContent()) {
			if (referstoGoal()) {
				predicateIndicatorCache = new PredicateIndicator(catstring + getGoal().getFunctor(), getGoal().getTermsSize());
			} else {
				predicateIndicatorCache = new PredicateIndicator(catstring +  getLiteral().getFunctor(), getLiteral().getTermsSize());
			}
		} else if (hasTerm()) {
			predicateIndicatorCache = new PredicateIndicator(catstring + getTerm().getFunctor(), getTerm().getTermsSize());
		} else {
			predicateIndicatorCache = new PredicateIndicator(catstring, 0);
		}
		
		return predicateIndicatorCache;
	} */
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Term#strip_varterm()
	 */
	public Term strip_varterm() {
		if (hasContent()) {
			setContent(getContent().strip_varterm());
		}
		return this;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Term#resolveVarsClusters()
	 */
	public Term resolveVarsClusters() {
		if (hasContent()) {
			setContent(getContent().resolveVarsClusters());
		}
		return this;
		
	}

	/**
	 * Checking two variables are equal.
	 * @param s
	 * @return
	 */
	public boolean varequals(DefaultAILStructure s) {
		return (isVar() && s.isVar() && super.equals(s));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s) || u.containsVarName(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				replacednames.add(s);
    				newnames.add(s1);
    			}
    		}
    	}
 
    } 
    
    /**
     * Generate fresh variable names.
     * @param s
     * @param names1
     * @param names2
     * @param names3
     * @param u
     * @return
     */
    public static String generate_fresh(String s, List<String> names1, List<String> names2, List<String> names3, Unifier u) {
    	String sbase = s;
    	String news = sbase;
    	for (int i = 0; i < names1.size() + names2.size() + names3.size(); i++) {
    		news = sbase + i;
    		if (! names1.contains(news) & !names2.contains(news) & !names3.contains(news) & !u.containsVarName(news)) {
    			break;
    		}
    	}
    	return news;
    }
    

}
