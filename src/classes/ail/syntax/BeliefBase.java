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
import java.util.Set;

import ajpf.util.VerifyMap;
import ajpf.util.VerifyList;
import ajpf.util.AJPFLogger;
import ail.syntax.annotation.SourceAnnotation;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Default implementation and AIL Belief Base.  Based on the Jason BeliefBase
 * class by Rafael F. Bordin and Jomi F. Hubner.
 * 
 * @author louiseadennis;
 */
public class BeliefBase implements Iterable<Literal> {

	@FilterField
	/**
	 * A percept.
	 */
	public static final Predicate Percept = new Predicate("percept");
	/**
	 * From self.
	 */
	@FilterField
	public static final Predicate Self = new Predicate("self");
	@FilterField
	/**
	 * Annotation for percepts.
	 */
    public static final SourceAnnotation TPercept = new SourceAnnotation(new Predicate("source"));
    static { TPercept.getSource().addTerm(Percept); }
    @FilterField
    /**
     * Annotation for information from self.
     */
    public static final SourceAnnotation TSelf = new SourceAnnotation(new Predicate("source"));
    static { TSelf.getSource().addTerm(Self); }
    

    /**
     * belsMap is a table where the key is the bel.getFunctorArity and the value
     * is a list of literals with the same functorArity.  Used for efficient
     * look-up of beliefs.
     */
    private Map<PredicateIndicator, BelEntry> belsMap = new VerifyMap<PredicateIndicator, BelEntry>();

    /**
     * Number of beliefs.
     */
    @FilterField
    private int size = 0;

    /** set of beliefs with percept annot, used to improve performance of buf
    /* this is a list of things the agents "expects" to be able to perceive. 
     */ 
    @FilterField
    ArrayList<Literal> percepts = new ArrayList<Literal>();
    
    /**
     * Getter for the number of beliefs.
     * @return number of beliefs.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns all literals in the belief base.
     * @return
     */
    public ArrayList<Literal> getAll() {
    	ArrayList<Literal> list = new ArrayList<Literal>();
    	for (BelEntry b: belsMap.values()) {
    		list.addAll(b.list);
    	}
    	
    	return list;
    }

    @SuppressWarnings("unchecked")
    /**
     * Get all the percepts in the belief base.
     */
 	public Iterator<Literal> getPercepts() {
    	// returns a clone so that the caller can not change the perceptions
    	return ((ArrayList<Literal>)percepts.clone()).iterator();
    }
    
    /**
     * Horrible hack awaiting refactoring.
     */
 	public Iterator<Predicate> getPerceptsAsStructs() {
    	// returns a clone so that the caller can not change the perceptions
 		ArrayList<Predicate> p_structs = new ArrayList<Predicate>();
 		for (Literal p: percepts) {
 			if (! p.negated()) {
 				Predicate s = new Predicate((Predicate) p.clone());
 				p_structs.add(s);
 			}
 		}
    	return p_structs.iterator();
    }

 	/**
     * Add a literal to the belief base.
     * 
     * @param l The literal to be added.
     * @return whether addition of the literal was successful.
     */
    public boolean add(Literal lin) {
    	Literal l = lin;
       	Term t = lin.strip_varterm();
    	if (t instanceof Literal) {
    		l = (Literal) t;
    	} else {
    		PredicatewAnnotation p = new PredicatewAnnotation((Predicate) t);
    		l = new Literal(true, p);
    	} 
        if (l.equals(Predicate.PTrue) || l.equals(Predicate.PFalse)) {
            return false;
        }
         
        Literal bl = contains(l);
        if (bl != null && !bl.isRule()) {
            // add only annots
            if (bl.addAnnotFrom(l)) {
                // check if it needs to be added in the percepts list
            	
                if (l.hasAnnot(TPercept)) {
                    percepts.add(bl);
                    Collections.sort(percepts);
                }
                
                return true;
            }
        } else {

            BelEntry entry = belsMap.get(l.getPredicateIndicator());
            if (entry == null) {
                entry = new BelEntry();
                belsMap.put(l.getPredicateIndicator(), entry);
            }
            entry.add(l); 
            // add it in the percepts list
            
            if (l.hasAnnot(TPercept)) {
                percepts.add(l);
                try {
                	Collections.sort(percepts);
                } catch (Exception e) {
                	AJPFLogger.severe("ail.syntax.BeliefBase", e.getMessage());
                }
            }
            
            size++;
            return true;
        }
        return false; 
     }

    /**
     * Removing a literal from the Belief Base.
     * 
     * @param l The literal to be removed.
     * @return
     */
    public boolean remove(Literal l) {
   	Literal bl = contains(l);
        if (bl != null) {
                 if (l.hasAnnot(TPercept)) {
                    percepts.remove(bl);
                } 
                
         	PredicateIndicator key = l.getPredicateIndicator();
        	BelEntry entry = belsMap.get(key);
        	entry.remove(bl);
        	if (entry.isEmpty()) {
        		belsMap.remove(key);
        	}
        	size--;
            boolean  result = true;
            return result;
        } 
        return false; 
    }
    
    /**
     * Completely clear out this belief base.
     */
    public void clear() {
    	belsMap = new VerifyMap<PredicateIndicator, BelEntry>();
    }

    /**
     * Returns an iterators over all beliefs.
     */
    public Iterator<Literal> iterator() {
        List<Literal> all = new ArrayList<Literal>(size());
        for (BelEntry be : belsMap.values()) {
            all.addAll(be.list);
       }
        return all.iterator();
	}
    

    /**
     * Does the belief base contain this literal?
     * 
     * @param l the literal to be checked.
     * @return whether the belief base contains the literal.
     */
    public Literal contains(Literal l) {
        BelEntry entry = belsMap.get(l.getPredicateIndicator());
        if (entry == null) {
            return null;
        } else {
    		return entry.contains(l);
        }
    }
 
    /**
     * Check whether the belief base contains something with a particular
     * predicate indicator.  Can be used for quick filtering of plans but caution
     * should be applied when belief rules are in operation.
     * @param pi
     * @return
     */
    public boolean contains(PredicateIndicator pi) {
    	BelEntry entry = belsMap.get(pi);
    	if (entry == null) {
    		return false;
    	} else {
    		return true;
    	} 
    }
    
    /**
     * Getter for the predicate indicators in use.
     * @return
     */
    public Set<PredicateIndicator> getPIs() {
    	return belsMap.keySet();
    }

    /**
     * Get a belief relevant to some literal - i.e., a belief with the
     * same predicate name and arity.  Presumably you can then check for
     * unifiability.
     * 
     * @param l  The literal to search against.
     * @return	An iterators of literals in the belief base with the same
     *          predicate name and arity.
     */
    public Iterator<Literal> getRelevant(Literal l) {
    	if (l.isVar()) {
            // all bels are relevant
            return iterator();
        } else {
            BelEntry entry = belsMap.get(l.getPredicateIndicator());
            if (entry != null) {
                List<Literal> entrylist = new ArrayList<Literal>();
                entrylist.addAll(entry.list);
                return entrylist.iterator();
           } else {
            	ArrayList<Literal> empty = new ArrayList<Literal>();
                return empty.iterator();
            }
        }
        
     }

    /**
     * Convert the belief base into a string for printing.
     *
     */
    public String toString() {
    	return (belsMap.toString());
     }
    
    /** 
     * Special class for storing the actual beliefs.  Each instance of a class
     * stores a number of literals with the same PredicateIndicator (i.e., the
     * same predicate name and arity).
     * 
     * @author louiseadennis
     *
     */
    final class BelEntry {
        
        final private VerifyList<Literal> list = new VerifyList<Literal>(); // maintains the order of the bels
        
        /**
         * Add a literal to the belEntry.
         * 
         * @param l
         */
        public void add(Literal l) {
            list.put(l);
      //      try {
      //      	Collections.sort(list);
      //      } catch (Exception e) {
      //      	AJPFLogger.severe("ail.syntax.BeliefBase", e.getMessage());
      //      }
        }
        
        /**
         * Remove a literal from the belEntry.
         * @param l
         */
        public void remove(Literal l) {
        	if (list.contains(l)) {
        		list.remove(l);
        	}
       }
        
        /**
         * This entry contains no literals.
         * 
         * @return
         */
        public boolean isEmpty() {
            return list.isEmpty();
        }
        
        /**
         * Does this belEntry contain some literal.
         * @param l
         * @return
         */
        public Literal contains(Literal l) {
        	if (list.contains(l)) {
        		return l;
        	} else {
        		return	null;
        	}
        }
        
        /*
         * (non-Javadoc)
         * @see java.lang.Object#clone()
         */
        protected Object clone() {
        	BelEntry be = new BelEntry();
        	for (Literal l: list) {
        		be.add((Literal)l.clone());
        	}
        	return be;
        }
        
        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Literal l: list) {
                s.append(l + ", ");
            }
            return s.toString();
        }
        
    }
}
