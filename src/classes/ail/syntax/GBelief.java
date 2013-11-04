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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import ail.semantics.AILAgent;
import ail.syntax.annotation.BeliefBaseAnnotation;
import ajpf.util.AJPFLogger;

import gov.nasa.jpf.annotation.FilterField;

/**
 * GBeliefs are beliefs that are "checked" e.g., by guards etc.
 * 
 * @author louiseadennis
 *
 */
public class GBelief extends DefaultAILStructure implements GuardAtom {
	static String logname = "ail.syntax.GBelief";
	
	/**
	 * A Special type of Belief: True - for when there is no condition to be checked.
	 * This is the category used in most AIL Structures for Goals - hence the use
	 * of the referstoGoal() method to check this not a category check.
	 */
	@FilterField
    public static final byte 	  GTrue = 10;
	
	@FilterField
	public static final byte GpureR = 12;

	/**
     * Predicate and arity represented as a string - may prove useful for swift
     * access of belief base at some point.
     */
	@FilterField
    private PredicateIndicator piCache;
	
	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 * 
	 * CHANGE STATIC REFERENCE
	 */
	private StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultBBname);

    /**
     * Construct a GBelief from a category - intended for construction of GTrue.
     * @param b
     */
    public GBelief(byte b) {
    	super(b);
    }
    
    /**
     * Construct a GBelief from a category and a literal.
     * 
     * @param b the Belief Category.
     * @param l the Literal/
     */
    public GBelief(byte b, Literal l) {
    	super(b, l);
    }
        
    /**
     * Constructor.
     * @param b
     * @param t
     */
    public GBelief(byte b, StringTerm t) {
    	super(b, t);
    }

    /**
     * Construct a GBelief from a category and a term.
     * @param b the category.
     * @param t the term.
     */
    public GBelief(byte b, Term t) {
    	super(b, new Literal(Literal.LPos, new PredicatewAnnotation((Predicate) t)));
    }

    /**
     * Construct a GBelief from a category and a group/agent name.
     * @param b the category.
     * @param s the group/agent name.
     */
    public GBelief(byte b, String s) {
    	super(b, s);
    }
    
    /**
     * Constructor for cloning.
     * @param b
     */
    public GBelief(GBelief b) {
    	super(b);
    	setDBnum(b.getDBnum());
    }
    
    /**
     * Return the GBelief as a term - i.e., without the category marker.
     * 
     * @return The GBelief as a term.
     */
    public Term toTerm() {
    	if (hasLiteral()) {
    		return getLiteral();
    	} else {
    		return (new Predicate(Predicate.PTrue));
    	}
    }
    
    /**
     * Setter for the DB num.
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
     * Getter for the DB num.
     * @return
     */
    public StringTerm getDBnum() {
    	return DBnum;
    }
        
    /**
     * Whether or not this is the distinguished "True" marker.
     * 
     * @return whether this is a trivially true belief.
     */
	public boolean isTrue() {
		return (getCategory() == GTrue);
	}
	
	
	/** return [+|-][!] super.getFunctorArity */
	public PredicateIndicator getPredicateIndicator() {
        if (piCache == null) {

        	if (hasLiteral()) {
            	piCache = new PredicateIndicator(getLiteral().getFunctor(), getLiteral().getTermsSize());
        
            } else if (hasTerm()) {
            	Term t = getTerm();
            	if (t instanceof Predicate) {
            		Predicate s = (Predicate) t;
            		piCache = new PredicateIndicator(s.getFunctor(), s.getTermsSize());
            	} else {
            		piCache = new PredicateIndicator(t.toString(), 0);
            	}
            } else {
            	String s = "True";
            	piCache = new PredicateIndicator(s, 0);
            }
        }
        return piCache;
    }
	
	/**
	 * Clone this GBelief - useful when propagating guards through intention structures.
	 */
	public GBelief clone() {
		if (hasLiteral()) {
			GBelief gb1 = new GBelief(getCategory(), (Literal) getLiteral().clone());
			gb1.setDBnum((StringTerm) getDBnum().clone());
			return gb1;
		} else {
			GBelief gb1 = new GBelief(getCategory());
			gb1.setDBnum((StringTerm) getDBnum().clone());
			return gb1;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (hasLiteral()) {
			s.append(getContent().toString()).append("(").append(getDBnum().toString()).append(")");
		}  else {
			s.append("True");
		}
		return s.toString();
	}

	/**
	 * Flag a GBelief as a varialble if the literal is a variable.
	 */
	public boolean isVar() {
		if (hasLiteral()) {
			return getLiteral().isVar();
		} else {
			return false;
		}
	}
	
	

	/**
	 * Get a list of unifiable things from an agent that are relevant to this GBelief.
	 * @param ag
	 * @param un
	 * @return
	 */
	public Iterator<Unifiable> getRelevant(AILAgent ag, Unifier un) {
		Iterator<Unifiable> il;
		
		if (getCategory() == AILSent) {
			il = getRelevantSent(ag);
        }  else if (getCategory() == AILReceived) {
        	il = getRelevantReceived(ag);
        } else if (referstoGroup()) {
          	if (getCategory() == AILContent) {
          		il = getRelevantContent(ag);
          	} else if (getCategory() == AILContext) {
          		il = getRelevantContext(ag);
          	} else {
          		il = null;
          	}
        }  else if (getCategory() == AILBel ) {
            il = getRelevantBeliefs(ag);
        } else {
        	il = null;
        }
		
		return il;
	}
	
	public Iterator<Unifiable> getRelevant(AILAgent ag) {
		return getRelevant(ag, new Unifier());
	}
	
	/**
	 * Overridable method for getting relevant sent messages.
	 * @param ag
	 * @return
	 */
	public Iterator<Unifiable> getRelevantSent(AILAgent ag) {
    	List<Message> ml = ag.getOutbox();
    	LinkedList<Unifiable> tl = new LinkedList<Unifiable>();
    	for (Message m: ml) {
    		tl.add(m.toTerm());
    	}
    	return tl.iterator();		
	}
	
	/**
	 * Overridable method for getting relevant received messages.
	 * @param ag
	 * @return
	 */
	public Iterator<Unifiable> getRelevantReceived(AILAgent ag) {
       	List<Message> ml = ag.getInbox();
    	LinkedList<Unifiable> tl = new LinkedList<Unifiable>();
    	for (Message m: ml) {
    		tl.add(m.toTerm());
    	}
    	return tl.iterator();		
	}
		
	/**
	 * Overridable method for getting relevant Content
	 * @param ag
	 * @return
	 */
	public Iterator<Unifiable> getRelevantContent(AILAgent ag) {
		LinkedList<Unifiable> tl = new LinkedList<Unifiable>();
		List <String> cl = ag.getContent();
		for (String s : cl) {
			Literal incontent = new Literal(s);
			tl.add(incontent);
		}
		return tl.iterator();
	}
	
	/**
	 * Overridable method for getting relevant Context
	 * @param ag
	 * @return
	 */
	public Iterator<Unifiable> getRelevantContext(AILAgent ag) {
		LinkedList<Unifiable> tl = new LinkedList<Unifiable>();
		List <String> cl = ag.getContext();
		for (String s : cl) {
			Literal incontext = new Literal(s);
			tl.add(incontext);
		}
		return tl.iterator();
	}
	
	/** 
	 * Overridable method for getting relevant beliefs.
	 * @param ag
	 * @return
	 */
	public Iterator<Unifiable> getRelevantBeliefs(AILAgent ag) {
       	Iterator<Literal> ll = null;
        LinkedList<Unifiable> lll = new LinkedList<Unifiable>();
    	StringTerm dbnum =  getDBnum();
    	if (dbnum instanceof VarTerm) {
    		VarTerm dbv = (VarTerm) dbnum;
    		if (dbv.hasValue()) {
    			ll = ag.getBB(getDBnum()).getRelevant(this.getLiteral());
    	           if (ll != null) {
    	        	   while(ll.hasNext()) {
    	        		   lll.add(ll.next());
    	        	   }
    	           }
    		} else {
    			for (String db: ag.getBBList()) {
    				ll = ag.getBB(db).getRelevant(this.getLiteral());
    		           if (ll != null) {
    		        	   while(ll.hasNext()) {
    		        		   Literal l = (Literal) ll.next().clone();
    		        		   Predicate dna = new Predicate("beliefbase");
    		        		   dna.addTerm(new Predicate(db));
    		        		   // This should probably be add but lets wait until beliefs a refactored
    		        		   l.setAnnot(new BeliefBaseAnnotation(dna));
    		        		   lll.add(l);
    		        	   }
    		           }
    			}
    		}
    	} else {
    		ll = ag.getBB(getDBnum()).getRelevant(this.getLiteral());
            if (ll != null) {
         	   while(ll.hasNext()) {
         		   lll.add(ll.next());
         	   }
            }
    	}
        return lll.iterator();
	}

	/**
	 * Get the agent's rules.
	 * @param ag
	 * @param un
	 * @return
	 */
	public Iterator<Rule> getRules(AILAgent ag, Unifier un) {
		return ag.getRuleBase().getRelevant(this);
	}
	
	public boolean isTrivial() {
		return isTrue();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.semantics.Unifier)
	 */
	// Based on code by Rafael H. Bordini, Jomi F. Hubner et. al for Jason
	public Iterator<Unifier> logicalConsequence(final AILAgent ag, final Unifier un) {
		return GBelief.logicalConsequence(ag, un, this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
	 */
	public boolean unifies(Unifiable u, Unifier un) {
		if (u instanceof GBelief) {
			GBelief gu = (GBelief) u;
			if (gu.getCategory() == getCategory()) {
				if (referstoGoal()) {
					return getGoal().unifies(gu.getGoal(), un);
				} else if (hasLiteral()) {
					return getLiteral().unifies(gu.getLiteral(), un);
				} else if (hasTerm()) {
					return ((Predicate) getTerm()).unifies(((Predicate) gu.getTerm()), un);
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else if (u instanceof Goal) {
			if (referstoGoal()) {
				return getGoal().unifies(u, un);
			} else {
				return false;
			}
		} else if (u instanceof Literal) {
			if (getCategory() == AILBel || getCategory() == AILContent || getCategory() == AILContext) {
				return getLiteral().unifies(u, un);
			}
		} else if (u instanceof Rule) {
			return this.unifies(((Rule) u).getHead(), un);
		}
		
		if (getCategory() == AILSent || getCategory() == AILReceived) {
				Predicate message = (Predicate) u;
				return message.unifies(getLiteral(), un);
		}
		  
		
		return false;
	}
		
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#calcHashCode()
	 */
	protected int calcHashCode() {
		return (41 * getDBnum().hashCode() + super.calcHashCode());
	}
	   
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof GBelief) {
			return (((GBelief) o).getDBnum().equals(getDBnum()) && super.equals(o));
		}
		   
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	public List<String> getVarNames() {
		if (hasLiteral() || hasTerm()) {
			List<String> varnames = getContent().getVarNames();
			varnames.addAll(getDBnum().getVarNames());
			return varnames;
		}
		return new LinkedList<String>();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	public void renameVar(String oldname, String newname) {
		if (hasLiteral() || hasTerm()) {
			getContent().renameVar(oldname, newname);
		}
		getDBnum().renameVar(oldname, newname);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#getPosTerms()
	 */
	public List<LogicalFormula> getPosTerms() {
		LinkedList<LogicalFormula> l = new LinkedList<LogicalFormula>();
		l.add(this);
		return l;
	}
	    
	/**
	 * New static method creating a general logical consequence method for Guard Atoms that make unify
	 * with the heads of Prolog Rules.
	 * @param ag
	 * @param un
	 * @param ga
	 * @return
	 */
	public static Iterator<Unifier> logicalConsequence(final AILAgent ag, final Unifier un, final GuardAtom ga) {
		// A list(iterator) of literals that might unify.
		// The agent may believe several things that can unify
		// with the query.
		final Iterator<Unifiable> il;
		final Iterator<Rule> rl;
       
		// First we create a list of possible unifiable objects (Literals/Goals/Messaages as appropriate)
		if (ga.isTrivial()) {
            return LogExpr.createUnifIterator(un);            
        }  else {
        	il = ga.getRelevant(ag);
        	rl = ag.getRuleBase().getRelevant(ga);
        }
   

         if (il == null & rl == null) { // & !(referstoGoal())) {
        	 LinkedList<Unifier> empty = new LinkedList<Unifier>();
        	 return empty.iterator();
         }
      

        // We create an iterator of unifiers given that we
        // have an iterator of unifiable objects.
        return new Iterator<Unifier>() {
        	// We filter all fields because logical consequence calculation
        	// should be "atomic" from the POV of the reasoning system.
        	/**
        	 * This holds the current unification solution.
        	 */
         	@FilterField
        	Unifier current = null;
         	/**
         	 * A helper field when processing prolog like rules.
         	 */
        	@FilterField
        	Iterator<Unifier> ruleIt = null; // current rule solutions iterator
        	/**
        	 * If we're doing prolog style reasoning the curren rule we
        	 * are using.
        	 */
        	@FilterField
        	Rule rule = null; // current rule
                
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
        		
        		// try rule iterator, if it has been created I've worked through all of il
        		// and am now chaining through rules.
        		while (ruleIt != null && ruleIt.hasNext()) {
        			// unifies the rule head with the result of rule evaluation
        			Unifier ruleUn = ruleIt.next(); // evaluation result
        			current = ruleUn;
        			return;
         		}
                          		
 
        		// il is all possible Beliefs/messages/whatever that potentially unify with this GBelief
        		if (il != null) {
        			while (il.hasNext()) {
        				Unifier unC = (Unifier) un.clone();
        				Unifiable u = il.next();
        				GuardAtom h2 = (GuardAtom) ga.clone();
        				if (h2.unifies(u, unC)) {
        					StringTerm DBnum = ga.getDBnum();
        					if (DBnum.isVar()) {
        						if (u instanceof Literal) {
        							Literal l = (Literal) u;
        							AILAnnotation a = l.getAnnot();
        							Predicate bb = new Predicate("beliefbase");
        							bb.addTerm(DBnum);
        							if (a.compatibleAnnotations(new BeliefBaseAnnotation(bb), unC)) {
        								current = unC;
        							}
        						} else {
        							current = unC;
        						}
        					} else {
        						current = unC;
        					}
          					return;
        				}
        			}
        		}
        		       		
           		if (rl != null) {
        			while (rl.hasNext()) {
        				Unifier unC = (Unifier) un.clone();
        				rule = rl.next();
        				Rule ruleC = rule.clone();
           				GuardAtom h = (GuardAtom) ga.clone();
           				ruleC.standardise_apart(h, unC);
           				// This this will just unify the head!!
        				if (h.unifies(ruleC, unC)) {
        					// ruleUn is now (one possible) unifier for this GBelief and the head of the rule.
        					// This GBelief should be ground? so only one possibility (?)
            					ruleIt = ruleC.getBody().logicalConsequence(ag, unC);
            					// ruleIt is an iterator over all possible unifiers for the rule body.
            					get();
            					if (current != null) {
               						if (AJPFLogger.ltFine(logname)) {
            							AJPFLogger.fine(logname, "Rule instantiated with " + current);
            						}
            						return;
            					}
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
        };
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#conjuncts()
	 */
	public List<LogicalFormula> conjuncts() {
		ArrayList<LogicalFormula> l = new ArrayList<LogicalFormula>();
		l.add(this);
		return l;
	}

}
