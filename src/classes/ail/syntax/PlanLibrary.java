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
import ail.tracing.events.GuardEvent;
import ail.util.MergeIterator;
import ajpf.util.AJPFCollections;
import ajpf.util.VerifyMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;

import gov.nasa.jpf.annotation.FilterField;


/**
 * AIL Plan Libraries.  Based on the Jason Plan Library class by Rafael H. Bordini, Jomi F. Hubner et al.
 * 
 * @author louiseadennis.
 *
 */
public class PlanLibrary {
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
	
	public PlanLibrary copy() {
		PlanLibrary pl = new PlanLibrary();
		for (Plan p: getPlans()) {
			pl.add(p);
		}
		return pl;
	}
	
	public void shuffle() {
		plans.shuffle();
		varPlans = new PlanList();
		for (Plan p: plans) {
			if (p.getTriggerEvent().isVar()) {
				varPlans.add(p);
			}
		}
	}
	
	
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
        		return new MergeIterator<ApplicablePlan>(l.get(a, false), varPlans.get(a, false));
        	} else {
        		return varPlans.get(a, false);
        	}
     }       

    /**
     * Get an iterator over all uninstantiated plans that are relevant to pi;
     * @param pi
     * @param a
     * @return
     */
    public Iterator<Plan> getUninstantiatedRelevant(PredicateIndicator pi, AILAgent a) {
    	PlanSet l = relPlans.get(pi);
    	if (l != null) {
    		return new MergeIterator<Plan>(l.getPlans(), varPlans.getPlans());
    	} else {
    		return varPlans.getPlans();
    	}
    }
    
    /**
     * Get all the reactive plans;
     * @return
     */
    public Iterator<ApplicablePlan> getAllReactivePlans(AILAgent a) {
   		return getAllReactivePlans(a, false);
    }
    
    /**
     * Get an iterator of all reactive plans in the agent.
     * @param a
     * @return
     */
    public Iterator<Plan> getUninstantiatedReactivePlans(AILAgent a) {
    	return varPlans.getPlans();
    }
    
    /**
     * Get an iterator of all instantions of plan p against agent a;
     * @param p
     * @param a
     * @return
     */
    public Iterator<ApplicablePlan> getPlanInstantions(Plan p, AILAgent a) {
    	if (p.getTriggerEvent().isVar()) {
    		return varPlans.getApplicablePlansFor(a, p, false);
    	} else {
    		return relPlans.get(p.getTriggerEvent().getPredicateIndicator()).getApplicablePlansFor(a, p, false);
    	}
    }
      
    public Iterator<ApplicablePlan> getAllReactivePlans(AILAgent a, boolean random) {
   		return varPlans.get(a, random);
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
    	public Iterator<ApplicablePlan> get(AILAgent a, boolean random);
    	/**
    	 * Return an iterator over uninstantiated plans in this plan base.
    	 * @param a
    	 * @return
    	 */
    	public Iterator<Plan> getPlans();
    	
    	/**
    	 * Get an iterator of instantiated plans for plan p given agent a;
    	 * @param a
    	 * @param p
    	 * @return
    	 */
    	public Iterator<ApplicablePlan> getApplicablePlansFor(AILAgent a, Plan p, boolean random);
    	
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
    	
    	public void shuffle();
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
    	 * @see ail.syntax.PlanLibrary.PlanSet#getPlans(ail.semantics.AILAgent)
    	 */
    	@Override
    	public Iterator<Plan> getPlans() {
    		return plans.iterator();
    	};
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#getApplicablePlansFor(ail.semantics.AILAgent, ail.syntax.Plan, boolean)
    	 */
    	@Override
      	public Iterator<ApplicablePlan> getApplicablePlansFor(final AILAgent a, final Plan p, boolean random) {
    		return new Iterator<ApplicablePlan> () {
    			ApplicablePlan current = null;

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
    				Plan cp = (Plan) p.clone();
    				Unifier un = new Unifier();
    				
    				if (intention != null  && !intention.empty()) {
    					cp.standardise_apart(intention.hdU(), new Unifier());
    					un = intention.hdU();
    				}
 
    				int prefixsize = cp.getPrefix().size();
    				int appplanlength = prefixsize;
    				boolean plan_is_applicable = false;
    				
    				if (prefixsize > 0) {
    					/* if (intention.events().size() < 1) {
    						System.err.println("EHY");
    						System.err.println(intention.toString());
    					} */
    					if (intention != null && !intention.empty() && a.goalEntails(intention.hdE(), cp, un)) {
    							// WE DON'T HAVE ANY EXAMPLES THAT UNIFY PREFIXES - COMMENTED OUT UNTIL WE DO
    						plan_is_applicable = true;
    					} 
    						
    				} else {
    					if ( (intention != null && intention.empty()) || (appplanlength == 0)) {
    	    					// appplanlength = 0;
    						plan_is_applicable = true;
    					} 
    				} 
    					
    				if (plan_is_applicable) {
    					if (iun == null) {
    						Guard g = cp.getContext().get(cp.getContext().size() - 1);
    						if (random == true) {
    							iun = a.believes(g, un, AILAgent.SelectionOrder.RANDOM);
    						} else {
    							iun = a.believes(g, un, AILAgent.SelectionOrder.LINEAR);
    						}
    						if (a.shouldTrace()) { // this is bad, but don't see how to do it otherwise
								List<Unifier> data = Lists.newArrayList(iun);
								iun = data.iterator();
								ApplicablePlan mock = new ApplicablePlan(cp.getTriggerEvent(), cp.getBody(),
										cp.getContext(), appplanlength, null, cp.getID(), cp.getLibID(), a.getPrettyPrinter());
								a.trace(new GuardEvent(intention, mock, g, data, false));
    						}
    					}
    				}
    					
    				if (iun != null && iun.hasNext()) {
     					current = new ApplicablePlan(cp.getTriggerEvent(), cp.getBody(), cp.getContext(), appplanlength, iun.next(), cp.getID(), cp.getLibID(), a.getPrettyPrinter());
    				} else {
    					current = null;
    					return;
    				}
    			}

     		};
   			
    	};
    	
    	
    	/*
    	 * (non-Javadoc)
    	 * @see ail.syntax.PlanLibrary.PlanSet#get(ail.semantics.AILAgent)
    	 */
    	@Override
    	public Iterator<ApplicablePlan> get(final AILAgent a, boolean random) {
    		return new Iterator<ApplicablePlan> () {
    			ApplicablePlan current = null;
    			/**
    			 * Index of the plan in the list we are currently considering
    			 */
    			Iterator<Plan> planit = getPlans();
     			/**
    			 * The iterator of the instantiations that match the current plan to the current situation.
    			 */
    			Iterator<ApplicablePlan> ap_it = null;
   			
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
    				if (ap_it != null && ap_it.hasNext()) {
    					current = ap_it.next();
    				} else {
    					if (planit.hasNext()) {
    						ap_it = getApplicablePlansFor(a, planit.next(), random);
    						get();
    					} else {
    						current = null;
    						return;
    					}
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
		
		public void shuffle() {
			AJPFCollections.shuffle(plans);
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
   	public Iterator<Plan> getRelevant(EBCompare<Plan> ga, AILAgent.SelectionOrder so) {
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
    				relPlans.remove(pi);
    			}
    	    }  		
    	}
  
        plans.remove(p);        

	} 
        
}


