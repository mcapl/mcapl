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
import java.util.List;
import ail.syntax.annotation.SourceAnnotation;

import gov.nasa.jpf.annotation.FilterField;

/**
 * AIL Plan class.  A plan consists of an event (trigger), prefix (deed stack), guard (guard
 * stack) and a body (deed stack).  Both the event and prefix must match the current 
 * intention for the plan to be applicable.  This class is based on the Jason Plan class
 * by Rafael H. Bordini, Jomi F. Hubner, et al.
 * 
 * @author louiseadennis
 *
 */
public class Plan implements Cloneable, Comparable<Plan> {
  
	/**
	 * The plan can have an annotation.
	 */
	protected AILAnnotation  annotation;
	/**
	 * The event (trigger) of the plan.
	 */
    protected Event           event = null;
    /**
     * The guard stack of the plan.
     */
    protected ArrayList<Guard>   context;
    /**
     * The body of the plan.
     */
    protected ArrayList<Deed> body;
    /**
     * The prefix of the plan.
     */
    protected ArrayList<Deed> prefix;
    /**
     * The source of the plan.
     */
    protected SourceAnnotation source;
    /**
     * The plan represented as a term, handy for unificiation.
     */
    @FilterField
    protected PredicatewAnnotation planterm = null;
    
    /**
     * A unique ID.  To be used in plan selection heuristics.
     */
    @FilterField
    protected int keynum;
    /**
     * ID of the plan library that holds this plan.
     */
    @FilterField
    protected String libname;
    
    @FilterField
    private ArrayList<PredicateIndicator> pis = null;
    
    @FilterField
    private Integer hashcode;
        
    /** 
     * Construct an empty plan.
     *
     */
    public Plan() {
    }
    
    /**
     * Construct a plan from an event, two deed stacks and a guard stack.  It is assumed the 
     * second deed stack and the guard stack are the same length.  This assumes that the
     * plan is "from" the agent.
     * 
     * @param e  The plan's trigger event.
     * @param prf The plan's prefix.
     * @param ct The plan's guard stack.
     * @param bd The plan's body.
     */
    public Plan(Event e, ArrayList<Deed> prf, ArrayList<Guard> ct, ArrayList<Deed> bd) {
        event = e;
        setContext(ct);
        setBody(bd);
        setPrefix(prf);
        setSource(new SourceAnnotation(new Predicate("self")));
        context.trimToSize();
        body.trimToSize();
        prefix.trimToSize();
      }
    
    /**
     * Construct a plan from an event, two deed stacks, a guard stack and a source.  It is
     * assumed the second deed stack and hte guard stack are the same length.
     * 
     * @param e The plan's trigger event.
     * @param prf The plan's prefix.
     * @param ct The plan's guard stack.
     * @param bd The plan's body.
     * @param s The plan's source.
     */
    public Plan(Event e, ArrayList<Deed> prf, ArrayList<Guard> ct, ArrayList<Deed> bd, SourceAnnotation s) {
        event = e;
        setContext(ct);
        setBody(bd);
        setPrefix(prf);
        setSource(s);
        context.trimToSize();
        body.trimToSize();
        prefix.trimToSize();
    }
    
    /**
     * Constructs a plan from a Literal.  This needs to be expanded.
     * @param l
     */
    public Plan(Literal l) {
    	if (l.getFunctor().equals("plan")) {
    		Term e = l.getTerm(0);
    		event = new Event(Event.AILAddition, new Goal(new Literal(true, new PredicatewAnnotation((Predicate) e)), Goal.achieveGoal));
    		ArrayList<Guard> guards = new ArrayList<Guard>();
    		guards.add(new Guard(new GBelief()));
    		setContext(guards);
    		setPrefix(new ArrayList<Deed>());
    		ArrayList<Deed> deeds = new ArrayList<Deed>();
    		Term body = l.getTerm(2);
    		Deed deed = new Deed(new Action((Predicate) body, Action.normalAction));
    		deeds.add(deed);
    		setBody(deeds);
    	}
    }
    
    /**
     * Setter method for the source of the plan.
     * 
     * @param s The plan's source.
     */
    public void setSource(SourceAnnotation s) {
    	source = s;
    }
    
    /**
     * Getter method for the source of the plan.
     * 
     * @return the plan's source.
     */
    public AILAnnotation getSource() {
    	return source;
    }
  
    /**
     * Setter method for the plan's annotation.
     * 
     * @param p The label of a plan.
     */
    public void setAnnotation(AILAnnotation p) {
        annotation = p;
    }
    
    /**
     * Getter method for the plan's label.
     * 
     * @return the label of the plan.
     */
    public AILAnnotation getAnnotation() {
        return annotation;
    }
   
    /**
     * Setter method for the plan's trigger event.
     * 
     * @param e the plan's trigger event.
     */
    public void setTrigger(Event e) {
    	event = e;
    }

    /**
     * Setter method for the plan's context.
     * 
     * @param le a guard stack for the plan.
     */
    public void setContext(ArrayList<Guard> le) {
    	if (le == null)
    		context = new ArrayList<Guard>();
    	else
    		context = le;
    }
    
    /**
     * Creates a context with a single entry at the top - all other entries are True.  The
     * most common context for plans.
     * 
     * @param g  The Guard for the top of the context stack.
     * @param i  The size of the plan body.
     */
    public void setContextSingle (Guard g, int i) {
  		context = new ArrayList<Guard>();

  		if (i > 1) {
  			for (int j = 0; j < (i - 1); j++) {
  				context.add(j, new Guard(new GBelief()));
  			}
  		}
  		
  		context.add(g);
    }
    
    /**
     * Setter method for the plan body.
     * 
     * @param bd The plan's body.
     */
    public void setBody(ArrayList<Deed> bd) {
        if (bd == null)
            body = new ArrayList<Deed>();
        else
            body = bd;
    }
    
    /**
     * Presumably for pretty printing.
     *
     */
    public void reverseBody() {
    	ArrayList<Deed> oldbody = body;
     	body = new ArrayList<Deed>();
    	for (Deed d: oldbody) {
    		body.add(0, d);
    	}
    }
    
    /**
     * Setter method for the plan prefix.
     * 
     * @param prf the plan's prefix.
     */
    public void setPrefix(ArrayList<Deed> prf) {
    	if (prf == null)
    		prefix  = new ArrayList<Deed>();
    	else
    		prefix = prf;
    }
    
    /**
     * Setter method for the unique ID.
     * @param i
     */
    public void setID(int i) {
    	keynum = i;
    }
    
    /**
     * Getter for the unique ID.
     * @return
     */
    public int getID() {
    	return keynum;
    }
 
    /**
     * Setter for the plan library name.
     * @param i
     */
    public void setLibID(String i) {
     	libname = i;
    }
    
    /**
     * Getter for the plan library name.
     * @return
     */
    public String getLibID() {
     	return libname;
    }
    /**
     * Getter method for the plan's trigger event.
     * 
     * @return the trigger event.
     */
    public Event getTriggerEvent() {
        return event;
    }
    
    /**
     * Getter method for the plan's guard stack.
     * 
     * @return the plan's guard stack.
     */
    public ArrayList<Guard> getContext() {
        return context;
    }
    
    
    /**
     * Getter method for the plan's body.
     * 
     * @return the plan's body.
     */
    public ArrayList<Deed> getBody() {
        return body;
    }
    
    /**
     * Getter method for the plan's prefix.
     * 
     * @return the plan's prefix.
     */
    public ArrayList<Deed> getPrefix() {
    	return prefix;
    }
        
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o != null && o instanceof Plan) {
            Plan p = (Plan) o;
            if (context == null && p.context != null)
                return false;
            if (context != null && p.context != null && !context.equals(p.context))
                return false;
            return event.equals(p.event) && body.equals(p.body) && prefix.equals(p.prefix);
        }
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
    	final int PRIME = 7;
    	if (hashcode != null) {
    		return hashcode;
    	} else {
    		int result = PRIME + event.hashCode();
    		for (Guard g: context) {
    			result = PRIME * result + g.hashCode();
    		}
    		for (Deed d: body) {
    			result = PRIME * result + d.hashCode();
    		}
    		for (Deed d: prefix) {
    			result = PRIME * result + d.hashCode();
    		}
    		hashcode = result;
    		return hashcode;
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() {
        Plan p = new Plan();
        
        if (annotation != null) {
            p.setAnnotation((AILAnnotation) annotation.clone());
        }
 
        p.event = (Event) event.clone();
        
        ArrayList<Deed> copy = new ArrayList<Deed>(); 
        for (Deed l : body) {
            copy.add((Deed) l.clone());
        }
        p.setBody(copy);
        
        ArrayList<Deed> pcopy = new ArrayList<Deed>();
        for (Deed l : prefix) {
        	pcopy.add((Deed) l.clone());
        }
        p.setPrefix(pcopy);
        
        ArrayList<Guard> ccopy = new ArrayList<Guard>();
        for (Guard f : context) {
        	ccopy.add((Guard) f.clone());
        }
        p.setContext(ccopy);
        p.setID(getID());
        p.setLibID(getLibID());
 
        return p;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return toASString();
    }
    
    /** returns this plan in a string compliant with AS syntax */
    private String toASString() {
    	StringBuilder s = new StringBuilder();
    	s.append(keynum);
    	s.append(" :: ");
    	s.append(event.toString());
    	s.append((prefix.size() == 0) ? "" : " + ");
    	s.append((prefix.size() == 0) ? "" : prefix.toString());
    	s.append((context.size() == 0) ? "" : " : ");
    	s.append((context.size() == 0) ? "" : context.toString());
    	s.append((body.size() == 0) ? "" : " <- ");
    	s.append((body.size() == 0) ? "" : body.toString());
    	s.append(".");
    	return s.toString();
     }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Plan p) {
    	if (keynum == p.getID()) {
    		return 0;
    	} else if (keynum > p.getID()) {
    		return 1;
    	} else {
    		return -1;
    	}
     }
    
    /**
     * Standardise apart the variables in this plan and some other unifiable thing.
     * @param t
     * @param u
     */
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getTriggerEvent().getVarNames();
    	for (Guard g: getContext()) {
    		myvarnames.addAll(g.getVarNames());
    	}
    	for (Deed d: getBody()) {
    		myvarnames.addAll(d.getVarNames());
    	}
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				getTriggerEvent().renameVar(s, s1);
    			   	for (Guard g: getContext()) {
    		    		g.renameVar(s, s1);
    		    	}
    			   	for (Guard g: getContext()) {
    		    		g.renameVar(s, s1);
    		    	}
    			   	for (Deed d: getBody()) {
    					d.renameVar(s, s1);
    				}
    				u.renameVar(s, s1);
    			}
    		}
    	}
 
    } 
    
    /**
     * Standardise apart the variables in this plan and some other unifier.
     * @param t
     * @param u
     */
    public void standardise_apart(Unifier t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getTriggerEvent().getVarNames();
    	for (Guard g: getContext()) {
    		myvarnames.addAll(g.getVarNames());
    	}
    	for (Deed d: getBody()) {
    		myvarnames.addAll(d.getVarNames());
    	}
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				getTriggerEvent().renameVar(s, s1);
    			   	for (Guard g: getContext()) {
    		    		g.renameVar(s, s1);
    		    	}
    			   	for (Guard g: getContext()) {
    		    		g.renameVar(s, s1);
    		    	}
    			   	for (Deed d: getBody()) {
    					d.renameVar(s, s1);
    				}
    				u.renameVar(s, s1);
    			}
    		}
    	}
 
    } 

}