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

import ail.semantics.AILAgent;
import ail.util.MergeIterator;

import ajpf.util.VerifyMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;

import gov.nasa.jpf.annotation.FilterField;


/**
 * AIL Plan Libraries.  Based on the Jason Plan Library class by Rafael H. Bordini, Jomi F. Hubner et al.
 * 
 * @author louiseadennis.
 *
 */
public class PlanLibrary implements EvaluationBase<Plan>{
	/** a MAP from TE to a list of relevant plans */
	@FilterField
    Map<PredicateIndicator,PlanSet> relPlans = new VerifyMap<PredicateIndicator,PlanSet>();

	/**
	 * All plans as defined in the AS code (maintains the order of the plans)
	 */
	PlanSet plans = new PlanList();
	
	/** list of plans that have var as TE */
	@FilterField
	PlanSet varPlans = new PlanList();
	
	/**
	 * The number of plans in the library.
	 */
	@FilterField
	protected int numplans = 1;
	
	/**
	 * The name of this plan library.
	 */
	@FilterField
	protected String libname = AILAgent.AILdefaultPLname;
	
	
	/**
	 * Constructor.
	 */
	public PlanLibrary() {
		
	}
	
	/**
	 * Constructor.
	 * @param i
	 */
	public PlanLibrary(String i) {
		libname = i;
	}
	
	/** 
	 * Add a plan to the library.
	 */
    public void add(Plan p) {
    	Event trigger = p.getTriggerEvent();
    	p.setID(numplans);
    	p.setLibID(libname);
    	numplans++;

        if (trigger.isVar()) {
        	varPlans.add(p);
          } else {
    		PredicateIndicator pi = trigger.getPredicateIndicator();
    		PlanSet lc = relPlans.get(pi);
    		if (lc != null) {
    			lc.add(p);
    	    } else {
    	    	lc = new PlanList();
    	    	lc.add(p);
    	    	relPlans.put(pi, lc);
    	    }      		
    	}
  
        plans.add(p);        
    }
    
    /**
     * Add a plan library to this one.
     * 
     * @param pl another plan library
      */
	public void addAll(PlanLibrary pl) {
		for (Plan p: pl.getPlans()) { 
			add(p);
		}
	}

	/**
	 * Add a list of plans to the library.
	 * 
	 * @param plans a list of plans.
	 */
	public void addAll(List<Plan> plans) {
		for (Plan p: plans) { 
			add(p);
		}
	}

	/**
	 * Getter method for the plans in the library.
	 * 
	 * @return the plans in the library.
	 */
    public List<Plan> getPlans() {
      	    return plans.getAsList();
    }
    
    /**
     * Get all the plans relevant to a particular trigger predicate indicator.
     */
    public Iterator<ApplicablePlan> getAllRelevant(PredicateIndicator pi, AILAgent a) {
        	PlanSet l = relPlans.get(pi);
        	if (l != null) {
        		return new MergeIterator<ApplicablePlan>(l.get(a), varPlans.get(a));
        	} else {
        		return varPlans.get(a);
        	}
     }
       

    /**
     * Get all the reactive plans;
     * @return
     */
    public Iterator<ApplicablePlan> getAllReactivePlans(AILAgent a) {
   		return varPlans.get(a);
    }
      
    /**
     * Return the number of plans in the library.
     * @return
     */
    public int size() {
    	return plans.size();
    }
    
    
    /**
     * Get a plan with ID i from the library.
     * @param i
     * @return
     */
    public Plan getPlanbyID(int i) {
    	for (Plan p: plans) {
    		if (p.getID() == i) {
    			return p;
    		}
    	}
    	
    	for (Plan p: varPlans) {
    		if (p.getID() == i) {
    			return p;
    		}
    	}
    	
    	return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return plans.toString();
    }
    
    /**
     * Setter for the library name.
     * @param name
     */
    public void setLibId(String name) {
    	libname = name;
    	for (Plan p: plans) {
    		p.setLibID(name);
    	}
    }
    
    // EXPERIMENTS WITH PLAN INDEXING
    
    /**
     * This is an interface that any indexing method for plans should satisfy.
     * @author louiseadennis
     *
     */
    protected interface PlanSet extends Iterable<Plan> {
    	/**
    	 * Add a plan to the index.
    	 * @param p
    	 */
    	public void add(Plan p);
    	/**
    	 * Add a collection of plans to the index.
    	 * @param ps
    	 */
    	public void addAll(Collection<Plan> ps);
    	/**
    	 * Return all the plans in the index as a list.
    	 * @return
    	 */
    	public List<Plan> getAsList();
    	/**
    	 * Return an iterator over the applicable plans that can be generated from the index for the current agent a.
    	 * @param a
    	 * @return
    	 */
    	public Iterator<ApplicablePlan> get(AILAgent a);
    	/**
    	 * The number of plans in the index.
    	 * @return
    	 */
    	public int size();
    	/**
    	 * Remove p from the set of plans.
    	 * @param p
    	 */
    	public void remove(Plan p);
    }
    
    /**
     * An index which simply represents the plans as a list.
     * @author louiseadennis
     *
     */
    protected class PlanList implements PlanSet {
    	ArrayList<Plan> plans = new ArrayList<Plan>();
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#add(ail.syntax.Plan)
    	 */
    	public void add(Plan p) {
    		plans.add(p);
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#addAll(java.util.Collection)
    	 */
    	public void addAll(Collection<Plan> ps) {
    		plans.addAll(ps);
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#getAsList()
    	 */
    	public List<Plan> getAsList() {
    		return plans;
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#size()
    	 */
    	public int size() {
    		return plans.size();
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see java.lang.Iterable#iterator()
    	 */
    	public Iterator<Plan> iterator() {
    		return plans.iterator();
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see java.lang.Object#toString()
    	 */
    	public String toString() {
    		return plans.toString();
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#get(ail.semantics.AILAgent)
    	 */
    	public Iterator<ApplicablePlan> get(final AILAgent a) {
    		return new Iterator<ApplicablePlan> () {
    			ApplicablePlan current = null;
    			/**
    			 * Index of the plan in the list we are currently considering
    			 */
    			int i = 0;
    			/**
    			 * The current intention.
    			 */
    			Intention intention = a.getIntention();
    			/**
    			 * The iterator of the unifers that match the current plan to the current situation.
    			 */
    			Iterator<Unifier> iun = null;
    			
    			/*
    			 * (non-Javadoc)
    			 * @see java.util.Iterator#remove()
    			 */
    			public void remove() {}
			
    			/*
    			 * (non-Javadoc)
    			 * @see java.util.Iterator#next()
    			 */
    			public ApplicablePlan next() {
    				if (current == null)
    					get();
    				ApplicablePlan ap = current;
    				current = null;
    				return ap;
    			}
			
    			/*
    			 * (non-Javadoc)
    			 * @see java.util.Iterator#hasNext()
    			 */
    			public boolean hasNext() {        		
    				if (current == null)
    					get();
    				return current != null;
    			}
    			
    			/**
    			 * This is the method that does all the work of generating the applicable plans for a particular agent.
    			 */
    			public void get() {
    				if (i < size()) {
    					Plan cp = (Plan) plans.get(i).clone();
    					cp.standardise_apart(intention.hdU(), new Unifier());
    					int prefixsize = cp.getPrefix().size();
    					int appplanlength = prefixsize;
    					Unifier un = intention.hdU();
    					boolean plan_is_applicable = false;
    				
    					if (prefixsize > 0) {
    						if (a.goalEntails(intention.hdE(), cp, un)) {
    							// WE DON'T HAVE ANY EXAMPLES THAT UNIFY PREFIXES - COMMENTED OUT UNTIL WE DO
        				//		if (realintention) {
        				//			ArrayList<Deed> ids = i.deeds();
        				//			int deedssize = i.deeds().size();
        							// Prefix unifies
        				//			for(int n = prefixsize; n > 0 ; n--) {
        				//				boolean r = un.unifies(ids.get(deedssize - n), current.getPrefix().get(n - 1));
        				//				result = (result  && r);
        				//			}
        				//		}
    							plan_is_applicable = true;
        					} 
    						
    	    			} else {
    	    				if (! intention.empty() || cp.getTriggerEvent().getContent() instanceof VarTerm) {
    	    					appplanlength = 0;
    	    					plan_is_applicable = true;
    	    				} 
    	    			} 
    					
    					if (plan_is_applicable) {
    						if (iun == null) {
    							iun = a.believes(cp.getContext().get(cp.getContext().size() - 1), un);
    						}
    					}
    					
    					if (iun != null && iun.hasNext()) {
    						current = new ApplicablePlan(cp.getTriggerEvent(), cp.getBody(), cp.getContext(), appplanlength, iun.next(), cp.getID(), cp.getLibID());
    					} else {
    						// If we've exhausted all possibilities for plan i then we try the next plan.
    						iun = null;
    						i++;
    						get();
    					}

    				} else {
    					current = null;
    				}
    			}
    		};

    	}

		/*
		 * (non-Javadoc)
		 * @see ail.syntax.PlanLibrary.PlanSet#remove(ail.syntax.Plan)
		 */
		public void remove(Plan p) {
			plans.remove(p);
		}
    }
    
    
    /**
     * getPlansContainingCap returns an iterator of all the plans in the library that contain
     * an Action that unifies with capname.  WARNING: This version of the function is intended 
     * for use with EASS programs and so in fact searches for perf(capname).  This needs to be generalised.
     * @param capname
     * @return
     */
    public Iterator<Plan> getPlansContainingCap(Predicate capname) {
    	// Using perf here is very specific - can we fix that somehow?
    	Action perf = new Action("perf");
    	perf.addTerm(capname);
    	List<Plan> plans = getPlans();
    	ArrayList<Plan> cap_plans = new ArrayList<Plan>();
    	for (Plan  p: plans) {
    		ArrayList<Deed> body = p.getBody();
    		for (Deed d: body) {
    			if (d.getCategory() == Deed.DAction) {
    				Action a = (Action) d.getContent();
    				Action aclone = (Action) a.clone();
    				if (aclone.unifies(perf, new Unifier())) {
    					cap_plans.add(p);
    				}
    			}
    		}
    	}
    	return cap_plans.iterator();
    }

    
	// Think I may need a new datatype here - or need guard plan to implement EBCompare
   	public Iterator<Plan> getRelevant(EBCompare<Plan> ga) {
		return null;
	}
	
	/**
	 * Remove a plan from the plan library.
	 * @param p
	 */
	public void remove(Plan p) {
    	Event trigger = p.getTriggerEvent();
    	numplans--;

        if (trigger.isVar()) {
        	varPlans.remove(p);
          } else {
    		PredicateIndicator pi = trigger.getPredicateIndicator();
    		PlanSet lc = relPlans.get(pi);
    		if (lc != null) {
    			lc.remove(p);
    			if (lc.size() == 0) {
    				relPlans.remove(lc);
    			}
    	    }  		
    	}
  
        plans.remove(p);        

	} 
        
}


