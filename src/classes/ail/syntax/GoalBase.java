// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax;

import ajpf.util.AJPFCollections;
import gov.nasa.jpf.annotation.FilterField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ail.semantics.AILAgent;
import ajpf.util.VerifyMap;
import ajpf.util.VerifySet;

/**
 * A Goal Base is a set of goals.  
 * @author lad
 *
 */
public class GoalBase implements EvaluationBase<PredicateTerm> {
	/**
     * goalMap is a table used for efficient
     * look-up of goals.
     */
    private Map<PredicateIndicator, Set<Goal>> goalMap = new VerifyMap<PredicateIndicator, Set<Goal>>();
    
    /**
     * Number of goals.
     */
    @FilterField
    private int size = 0;
    
    /**
     * Getter for the number of goals.
     * @return number of goals.
     */
    public int size() {
        return size;
    }

    /**
     * Returns all goals in the goal base.
     * @return
     */
    public ArrayList<Goal> getAll() {
    	ArrayList<Goal> list = new ArrayList<Goal>();
    	for (Set<Goal> gs: goalMap.values()) {
    		list.addAll(gs);
    	}
    	
    	return list;
    }

 	/**
     * Add a goal to the goal base.
     * 
     */
    public boolean add(Goal gin) {
       	Goal g = (Goal) gin.strip_varterm();
         
       	Set<Goal> entry = goalMap.get(g.getPredicateIndicator());
       	if (entry == null) {
       		entry = new VerifySet<Goal>();
       		goalMap.put(g.getPredicateIndicator(), entry);
       	}
       	boolean added = entry.add(g); 
       	if (added) {
       		size++;
       	}
       	return added;
     }

    /**
     * Removing a goal from the Goal Base.
     */
    public boolean remove(Goal g) {
		PredicateIndicator key = g.getPredicateIndicator();
    	if (goalMap.containsKey(key) && goalMap.get(key).contains(g)) {
    		Set<Goal> entry = goalMap.get(key);
    		entry.remove(g);
    		if (entry.isEmpty()) {
    			goalMap.remove(key);
    		}
    		size--;
    		return true;
    	} 
    	return false; 
    }

    /**
     * Returns an iterators over all goals.
     */
    public Iterator<Goal> iterator() {
        List<Goal> all = new ArrayList<Goal>(size());
        for (Set<Goal> gs :goalMap.values()) {
            all.addAll(gs);
       }
        return all.iterator();
	}
    

    /**
     * Getter for the predicate indicators in use.
     * @return
     */
    public Set<PredicateIndicator> getPIs() {
    	return goalMap.keySet();
    }

    /**
     * Get a goal relevant to some literal - i.e., a goal with the
     * same predicate name and arity.  Presumably you can then check for
     * unifiability.
     * 
     * @param l  The literal to search against.
     * @return	An iterators of goals in the goal base with the same
     *          predicate name and arity.
     */
    public Iterator<PredicateTerm> getRelevant(EBCompare<PredicateTerm> ebl, AILAgent.SelectionOrder so) {
    	PredicateTerm l = (PredicateTerm) ebl;
    	LinkedList<PredicateTerm> ul = new LinkedList<PredicateTerm>();
    	Iterator<Goal> gl = null;
    	if (l.isVar()) {
            // all goals are relevant
            gl = iterator();
        } else {
            Set<Goal> entry = goalMap.get(l.getPredicateIndicator());
            if (entry != null) {
                List<Goal> entrylist = new ArrayList<Goal>();
                entrylist.addAll(entry);
                gl = entrylist.iterator();
           } else {
            	ArrayList<Goal> empty = new ArrayList<Goal>();
                gl = empty.iterator();
            }
        }
    	
    	if (gl != null) {
    		while (gl.hasNext()) {
    			ul.add(gl.next());
    		}
    	}
    	
    	if (so == AILAgent.SelectionOrder.RANDOM) {
    		AJPFCollections.shuffle(ul);
    	}
    	return ul.iterator();
        
     }
        
    /**
     * Convert the goal base into a string for printing.
     *
     */
    @Override
    public String toString() {
    	return (goalMap.toString());
     }
    
    /**
     * Does this goal base have any goals?
     * @return
     */
    public boolean isEmpty() {
    	return size == 0;
    }

}
