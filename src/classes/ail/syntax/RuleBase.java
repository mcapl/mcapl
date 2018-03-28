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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ajpf.util.VerifyMap;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Default implementation of an AIL Rule Base.  Based on the Jason BeliefBase
 * class by Rafael F. Bordini and Jomi F. Hubner.
 * 
 * @author louiseadennis;
 */
public class RuleBase implements Iterable<Rule> {

 
	/**
     * belsMap is a table where the key is the bel.getFunctorArity and the value
     * is a list of literals with the same functorArity.  Used for efficient
     * look-up of beliefs.
     */
    private Map<PredicateIndicator, RuleEntry> ruleMap = new VerifyMap<PredicateIndicator, RuleEntry>();

    /**
     * Number of rules.
     */
    @FilterField
    private int size = 0;

    /**
     * Getter for the number of rules.
     * @return number of ruless.
     */
    public int size() {
        return size;
    }
       
    /**
     * Add a rule to the rule base.
     * 
     * @param l The rule to be added.
     * @return whether addition of the rule was successful.
     */
    public boolean add(Rule l) {
            RuleEntry entry = ruleMap.get(l.getPredicateIndicator());
            if (entry == null) {
                entry = new RuleEntry();
                ruleMap.put(l.getPredicateIndicator(), entry);
            }
            entry.add(l);
 
            size++;
            return true;
     }

    /**
     * Removing a rule from the Rule Base.
     */
    public boolean remove(Rule l) {
         if (l != null) {
        	 PredicateIndicator key = l.getPredicateIndicator();
        	RuleEntry entry = ruleMap.get(key);
        	entry.remove(l);
        	if (entry.isEmpty()) {
        		ruleMap.remove(key);
        	}
        	size--;
            boolean  result = true;
            return result;
        } 
        return false;
    }

    /**
     * Returns an iterators over all ruless.
     */
    public Iterator<Rule> iterator() {
        List<Rule> all = new ArrayList<Rule>(size());
        for (RuleEntry be : ruleMap.values()) {
            all.addAll(be.list);
        }
        return all.iterator();
	}
    

    /**
     * Get a rule relevant to some gbelief - i.e., a rules whose head has the
     * same predicate name and arity. 
     * 
     * @param l  The literal to search against.
     * @return	An iterators of literals in the belief base with the same
     *          predicate name and arity.
     */
    public Iterator<Rule> getRelevant(GBelief l) {
         if (l.isVar()) {
            // all rules are relevant
            return iterator();
        } else {
            RuleEntry entry = ruleMap.get(l.getPredicateIndicator());
            if (entry != null) {
                return Collections.unmodifiableList(entry.list).iterator();
            } else {
                return null;
            }
        }
    }
    
    public List<Rule> getAll() {
    	ArrayList<Rule> rls = new ArrayList<Rule>();
    	for (PredicateIndicator pi : ruleMap.keySet()) {
    		rls.addAll(ruleMap.get(pi).getAll());
    	}
    	return rls;
    }

    /**
     * Get a rule relevant to some guard atom - i.e., a rules whose head has the
     * same predicate name and arity.  
     * 
     * @param l  The literal to search against.
     * @return	An iterators of rules in the rule base with the same
     *          predicate name and arity.
     */
    public Iterator<Rule> getRelevant(PredicateTerm l) {
         if (l.isVar()) {
            // all bels are relevant
            return iterator();
        } else {
            RuleEntry entry = ruleMap.get(l.getPredicateIndicator());
            if (entry != null) {
                return Collections.unmodifiableList(entry.list).iterator();
            } else {
                return null;
            }
        }
    }
 
    /**
     * There is a rule relevant to this predicate indicator.
     * @param pi
     * @return
     */
    public boolean hasRelevant(PredicateIndicator pi, byte category) {
    	RuleEntry entry = ruleMap.get(new Tuple(pi, category));
    	if (entry != null) {
    		return true;
    	} else {
    		return false;
        }
   }

    /**
     * Convert the rule base into a string for printing.
     *
     */
    public String toString() {
    	return (ruleMap.toString());
    }
    
     
    /** 
     * Special class for storing the actual rules.  Each instance of a class
     * stores a number of rules with the same PredicateIndicator (i.e., the
     * same predicate name and arity).
     * 
     * Much hacked down from the Jason implementation in order to assist JPF state matching.
     * 
     * Many in fact now be redundant.
     * 
     * @author louiseadennis
     *
     */
    final class RuleEntry {
         final private List<Rule> list = new ArrayList<Rule>(); 
        
        /**
         * Add a rule to the entry.
         * 
         * @param l
         */
        public void add(Rule l) {
            list.add(l);
        }
        
        /**
         * Remove a rule from the entry.
         * @param l
         */
        public void remove(Rule l) {
        	list.remove(l);
        }
        
        /**
         * This entry contains no ruless.
         * 
         * @return
         */
        public boolean isEmpty() {
            return list.isEmpty();
        }        
         
        /*
         * (non-Javadoc)
         * @see java.lang.Object#clone()
         */
        protected Object clone() {
        	RuleEntry be = new RuleEntry();
        	for (Rule l: list) {
        		be.add((Rule)l.clone());
        	}
        	return be;
        }
        
        public List<Rule> getAll() {
        	return list;
        }
        
        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Rule l: list) {
                s.append(l + ", ");
            }
            return s.toString();
        }
        
         
    }
    
    private class Tuple implements Comparable<Tuple> {
    	PredicateIndicator pi;
    	byte b;
    	
    	public Tuple(PredicateIndicator p, byte by) {
    		pi = p;
    		b = by;
    	}
    	
    	// Remember to comment this properly.
    	public void randommethod() {};
    	
    	public int compareTo(Tuple t) {
    		int picomp = getPI().compareTo(t.getPI());
    		if (picomp != 0) {
    			return picomp;
    		} else {
    			byte tb = t.getCategory();
    			if (tb < b) {
    				return -1;
    			} else if (tb > b) {
    				return 1;
    			} else {
    				return 0;
    			}
    		}
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see java.lang.Object#equals(java.lang.Object)
    	 */
    	public boolean equals(Object o) {
    		if (o instanceof Tuple) {
    			Tuple t = (Tuple) o;
    			return (pi.equals(t.getPI()) && b == t.getCategory());
    		}
    		return false;
    	}
    	
    	public PredicateIndicator getPI() {
    		return pi;
    	}
    	
    	public byte getCategory() {
    		return b;
    	}
    	
    	public String toString() {
    		return pi.toString() + b;
    	}
    }
}
