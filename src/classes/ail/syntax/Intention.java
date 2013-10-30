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

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Set;

import ail.syntax.annotation.SourceAnnotation;
import ail.semantics.AILAgent;

/**
 * Class for an AIL Intention - a matrix structure consisting of several
 * rows of event, guard stack, deed stack, unifier stack.  Adapted heavily from the Jason
 * Intention class by Rafael H. Bording, Jomi F. Hubner et al.
 * 
 * @author louiseadennis
 *
 */
public class Intention implements Comparable<Intention>{
	/**
	 * The rows of the intention.  NB. an intention row is not implemented
	 * as a single event, deed, guard, unifier tuple.  but as a tuple of
	 * an event, deed stack, guard stack and unifier stack - this saves 
	 * multiple storing of events.
	 */
    protected ArrayList<IntentionRow> intentionRows = new ArrayList<IntentionRow>();
    /**
     * The original source of the intention.
     */
    protected SourceAnnotation source;
    /**
     * Whether the intention is locked to be the current intention.
     */
    protected boolean islocked = false;
    /**
     * A language specific annotation for the intention.  Unused except
     * in subclasses.
     */
    protected AILAnnotation annotation;
    
    /**
     * Whether the intention is suspended.  i.e, forced not to be the current intention
     * until some condition is met.
     */
    protected boolean suspended = false;

    /**
     * The condition that needs to be true to unsuspend the intention
     */
    protected Literal suspendedfor;

    /**
     * Constructor.  Does nothing except create an empty intention.
     *
     */
    public Intention() {
    	source = new SourceAnnotation(new Predicate("empty"));
    }
    
     /**
     * Constructor.  Creates a new intention from an event, deed stack, guard
     * stack, unifier and source.
     * 
     * @param e  The event.
     * @param ds The deed stack.
     * @param gu The guard stack.
     * @param theta The unifier
     * @param s The source.
     */
    public Intention(Event e, ArrayList<Deed> ds, ArrayList<Guard> gu, Unifier theta, SourceAnnotation s) {
    	this();
    	
    	this.iConcat(e, ds, gu, theta);
    	this.setSource(s);
    }
    
    /**
     * Constructor
     * @param e
     * @param ds
     * @param gu
     * @param theta
     */
    public Intention(Event e, ArrayList<Deed> ds, ArrayList<Guard> gu, Unifier theta) {
    	this(e, ds, gu, theta, AILAgent.refertoself());
     }

    /**
     * Constructor.  Creates and intention from a new event, source and unifier.
     * This creates an intention with an empty unifier and then composes it with
     * the parameter.
     * 
     * @param e the event.
     * @param u the unifier.
     * @param s the source for the intention.
     */
    public Intention(Event e, Unifier u, SourceAnnotation s) {
    	this(e, s);
    	compose(u);
    }
    
    /**
     * Constructor.  Creates an intention from a new goal and a source.  This
     * creates an intention row from the goal.  The event is the special "start"
     * event, the guard stack is "True", the deed stack is the goal, and the
     * unifier stack contains the empty unifier.
     * 
     * @param gl  The goal.
     * @param s  The source.
     */
    public Intention(Goal gl, SourceAnnotation s) {
    	this();
 
    	ArrayList<Guard> gs = new ArrayList<Guard>();
		GBelief gtrue = new GBelief(GBelief.GTrue);
		Guard g = new Guard(gtrue);
   		gs.add(g);
 
   		ArrayList<Deed> ds = new ArrayList<Deed>();
   		Deed d = new Deed(Deed.AILAddition, gl);
   	 	ds.add(d);
   		
   	 	ArrayList<Unifier> us = new ArrayList<Unifier>();
   	 	Unifier u = new Unifier();
   	 	
   	 	us.add(u);
   	 	
   	 	IntentionRow ir = new IntentionRow(new Event(Event.Estart), gs, ds, us);
   	 	intentionRows.add(ir);
    	
    	this.setSource(s);
    	
    }
    
    /**
     * Constructor.  Creates an intention from an event and a source.
     * Creates an intention row from the event with the event as the event
     * the guard stack contains true, the deed stack contains no plan yet
     * and the unifier stack contains the empty unifier.
     * 
     * @param e  The event.
     * @param s  The source
     */
    public Intention(Event e, SourceAnnotation s) {
    	this();
    	
    	ArrayList<Guard> gs = new ArrayList<Guard>();
		GBelief gtrue = new GBelief(GBelief.GTrue);
		Guard g = new Guard(gtrue);
   		gs.add(g);
 
   		ArrayList<Deed> ds = new ArrayList<Deed>();
   		Deed npy = new Deed(Deed.Dnpy);
   		ds.add(npy);
   	 	
   	 	ArrayList<Unifier> us = new ArrayList<Unifier>();
   	 	Unifier u = new Unifier();
   	 	
   	 	us.add(u);
   	 	
   	 	IntentionRow ir = new IntentionRow(e, gs, ds, us);
   	 	intentionRows.add(ir);
    	
    	this.setSource(s);
    }
    
    /**
     * Suspends the intention.
     *
     */
    public void suspend() {
    	suspended = true;
    }
    
    /**
     * Allows a condition to be set for the unsuspension of the intention.
     * @param beliefcondition
     */
    public void suspendFor(Literal beliefcondition) {
    	suspendedfor = beliefcondition.clone();
    	suspend();
    }
    
    /**
     * Is the intention suspended?
     * @return whether the intention is suspended.
     */
    public boolean suspended() {
    	return suspended;
    }
    
    /**
     * Unsuspend the intention.
     *
     */
    public void unsuspend() {
    	suspended = false;
    }
 
    /**
     * Unsuspend the intention if it's condition is met by the new belief
     * @param beliefcondition
     */
    public void unsuspendFor(Literal beliefcondition) {
    	if (suspended && suspendedfor != null && suspendedfor.unifies(beliefcondition, new Unifier())) {
    		suspendedfor = null;
    		unsuspend();
    	}
    }
    
    /**
     * Unsuspend the intention if it's condition met by the changes in perception
     * @param newbeliefs
     * @param oldbeliefs
     */
    public void unsuspendFor(Set<Predicate> newbeliefs, Set<Literal> oldbeliefs) {
    	if (suspended) {
    		for (Predicate p: newbeliefs) {
    			unsuspendFor((Literal ) p);
    		}
    	}
    	if (suspended) {
    		for (Literal l: oldbeliefs) {
    			if (! l.negated()) {
    				l.setNegated(false);
    			}
    			unsuspendFor(l);
    		}
    	}
    }
    
   /**
     * Setter method for the intention's source.
     * 
     * @param s The source
     */
    public void setSource(SourceAnnotation s) {
    	source = s;
    }
    
    /**
     * Getter method for the intention's source.
     * 
     * @return the source of the intention.
     */
    public SourceAnnotation getSource() {
    	return source;
    }
    
    /**
     * Setter method for the intention's Annotation.
     * 
     * @param ann the annotation for the intention.
     */
    public void setAnnotation(AILAnnotation ann) {
    	annotation = ann;
    }
    
    /**
     * Getter method for the intention's Annotation.
     * 
     * @return The intention's annotation.
     */
    public AILAnnotation getAnnotation() {
    	return (annotation);
    }
    
    /**
     * Is the intention locked to the agent's current intention.
     * 
     * @return whether the intention is locked to the agent's current intention.
     */
    public boolean locked() {
    	return islocked;
    }
    
    /**
     * Lock the intention to the agent's current intention.
     *
     */
    public void lock() {
    	islocked = true;
    }
    
    /**
     * Unlock the intention from the agent's current intention.
     *
     */
    public void unlock() {
    	islocked = false;
    }

    /**
     * Push a new intention row on top of the intention.
     * 
     * @param ir the new intention row.
     */
    private void push(IntentionRow ir) {
        intentionRows.add(ir);
    }

    /**
     * View but do not remove the top row of the intention.
     * 
     * @return the top row of the intention.
     */
    private IntentionRow peek() {
    	int size = intentionRows.size();
        return intentionRows.get(size - 1);
    }

 
    /**
     * Pop and return the top row of the intention.
     * 
     * @return the top row of the intention.
     */
    private IntentionRow pop() {
    	int size = intentionRows.size();
        IntentionRow top = intentionRows.remove(size - 1);
        
        return top;
    }

    /**
     * The number of rows in the intention.
     * 
     * @return the number of rows in the intention.
     */
    public int size() {
        return intentionRows.size();
    }

  
    /**
     * Return the first intention row that unifies with a 
     * given event.  NB. as a side-effect the unifier may gain further
     * instantiations.
     * 
     * @param g the event.
     * @param u the event's existing unifier.
     * @return and intention row whose event unifies with the event argument.
     */
    private IntentionRow getIR(Event g, Unifier u) {
        for (IntentionRow ir : intentionRows) {
            if (u.unifies(g, ir.getEvent())) {
                return ir;
            }
        }
        return null;
    }
    

    /**
     * Remove all intention rows up to and including the first that
     * unifies with a given event.
     * 
     * @param te The event
     * @param un The event's unifier.
     * @return whether a matching intention row was found.
     */
    public boolean dropGoal(Event te, Unifier un) {
        IntentionRow ir = getIR(te, un);
        if (ir != null) {
            // remove the IRs until ir-1
            while (peek() != ir) {
                pop();
            }
            pop(); // remove im
            return true;
        }      
        return false;
    }
        
    /**
     * Convert the intention to a string.  At the moment this prints out the
     * rows of the intention, not the annotation or locking information.
     * 
     * @return a string representing the intention.
     */
    public String toString() {
         String s = "";
         if (suspended) {
        	 s += "SUSPENDED\n";
         }
         for (IntentionRow ir : intentionRows) {
        	s += "   *  " + ir.toString();
        }
        if (annotation != null) {
        	 s += annotation.toString();
        }
        s += source.toString();
        return s.toString();
    }

    // The operations on intentions defined in the AIL technical reports //
    
    /**
     * The deeds stack of the intention.
     * 
     * @return the deed stack of the intention.
     */
    public ArrayList<Deed> deeds() {
    	ArrayList<Deed> ds = new ArrayList<Deed>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		ArrayList<Deed> dsp = i.next().deeds();
    		ListIterator<Deed> di = dsp.listIterator();
    		while (di.hasNext()) {
   		   			ds.add(di.next());
    		}  
    	}
    	
    	return ds;
    }
    
    /**
     * The event stack of the intention.
     * 
     * @return The event stack of the intention.
     */
    public ArrayList<Event> events() {
    	ArrayList<Event> es = new ArrayList<Event>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		es.add(i.next().getEvent());
    	}
    	
    	return es;
    }
    
    /**
     * The event stack of the intention.
     * 
     * @return The event stack of the intention.
     */
    public ArrayList<Event> eventsUnified() {
    	ArrayList<Event> es = new ArrayList<Event>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		IntentionRow ir = i.next();
    		Event eclone = ir.getEvent().clone();
    		eclone.apply(ir.unifiers().get(ir.unifiers().size() - 1));
    		es.add(eclone);
    	}
    	
    	return es;
    }

    /**
     * A clone of event stack of the intention with unifiers applied.
     * 
     * @return The event stack of the intention.
     */
    public ArrayList<Event> getUnifiedevents() {
    	ArrayList<Event> es = new ArrayList<Event>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		IntentionRow ir = i.next();
    		if (! ir.unifiers().isEmpty()) {
    			Event e = ir.getEvent().clone();
    			e.apply(ir.unifiers().get(0));
    			es.add(e);
    		}
    	}
    	
    	return es;
    }
    
    /**
     * A clone of event stack of the intention with unifiers applied excluding any unplanned events.
     * 
     * @return The event stack of the intention excluding any unplanned events.
     */
   public ArrayList<Event> getPlannedUnifiedEvents() {
    	ArrayList<Event> es = new ArrayList<Event>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		IntentionRow ir = i.next();
    		if (! ir.unplanned() &&  ! ir.unifiers().isEmpty()) {
    			Event e = ir.getEvent().clone();
    			e.apply(ir.unifiers().get(0));
    			es.add(e);
    		}
    	}
    	
    	return es;
   	
    }

    
    /**
     * Finds the trigger event associated with the nth deed on the deed stack,
     * counting down.
     * 
     * @param n the number of the deed of interest.
     * @return the trigger event associated with the deed.
     * @throws IndexOutOfBoundsException if n is larger than the deed stack.
     */
    public Event tr(int n) throws IndexOutOfBoundsException {
    	int counter = 0;
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator(intentionRows.size());
    	while (i.hasPrevious()) {
		    IntentionRow ip = i.previous();
    		counter += ip.deeds().size();
    		if (counter > n) {
    			return (ip.getEvent());
    		}
    	}
    	
    	throw new IndexOutOfBoundsException("No Such Deed");
    	
    }
    
    /**
     * Finds the unifier associated with the nth deed on the deed stack, counting
     * down.
     * 
     * @param n the number of the deed of interest.
     * @return The unifier associated with the deed.
     * @throws IndexOutOfBoundsException if n is larger than the deed stack.
     */
    public Unifier theta(int n) throws IndexOutOfBoundsException {
    	int counter = 0;
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator(intentionRows.size());
    	while(i.hasPrevious()) {
			IntentionRow ip = i.previous();
    		counter += ip.deeds().size();
    		if (counter > n) {
    			return (ip.unifiers().get(counter - n - 1));
    		}
    	}
    	
    	throw new IndexOutOfBoundsException("No Such Deed");
     }
    
    /**
     * The guard associated with the nth deed on the deed stack, counting down.
     * 
     * @param n the number of the deed of interest.
     * @return the guard associated with the deed.
     * @throws IndexOutOfBoundsException if n is larger than the deed stack.
     */
    public Guard gu(int n) throws IndexOutOfBoundsException {
    	int counter = 0;
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator(intentionRows.size());
    	while(i.hasPrevious()) {
			IntentionRow ip = i.previous();
    		counter += ip.deeds().size();
    		if (counter > n) {
    			return (ip.guards().get(counter - n - 1));
    		}
    	}
    	
    	throw new IndexOutOfBoundsException("No Such Deed" + i + n);
    }
    
	/**
	 * Pushes a new intention row onto the intention.
	 * 
	 * @param e The event for the new row.
	 * @param ds The deed stack of the new row.
	 * @param gs The guard stack for the new row.
	 * @param theta The unifier which will form all instances of the unifier stack
	 *              for the intention row.
	 */
	public   void iConcat(Event e, ArrayList<Deed> ds, ArrayList<Guard> gs, Unifier theta) {
		IntentionRow ir = new IntentionRow(e, gs, ds, theta);
		
		intentionRows.add(ir);
	}
	
	/**
	 * Drop n deeds from the intentions deed stack along with their associated
	 * events, guards and unifiers.
	 * 
	 * @param n the number of deeds to drop.
	 */
	public   void dropP(int n) {
		int counter = 0;
		int lastcount = 0;
		
		ListIterator<IntentionRow> i = intentionRows.listIterator(intentionRows.size());
		
		while (i.hasPrevious()) {
			IntentionRow ir = i.previous();
			counter += ir.deeds().size();
			
			if (counter <= n) {
				i.remove();
			} else {
				ir.dropIR(n - lastcount);
			}
			
			lastcount = counter;
		}
		
		/* if (empty()) {
			source = new Atom("empty");
		} */
		
		intentionRows.trimToSize();
		
	}
	
	/**
	 * Drop n events from the intention along with their associated deed stacks,
	 * guard stacks and unifier stacks.
	 * 
	 * @param n the number of events to drop.
	 */
	public   void dropE(int n) {
		for (int m = 0; m < n; m++) {
			int size = intentionRows.size();
			intentionRows.remove(size - 1);
		}
		intentionRows.trimToSize();
	}
	
	/**
	 * The top deed on the deed stack.
	 * 
	 * @return the top deed on the deed stack.
	 */
	public   Deed hdD() {
		return(deeds().get(deeds().size() - 1));
	}
	
	/**
	 * The top event on the event stack.
	 * 
	 * @return the top event on the event stack.
	 */
	public Event hdE() {
		return(events().get(events().size()-1));
	}
	
	/**
	 * The top guard on the guard stack.
	 * 
	 * @return the top guard on the guard stack.
	 */
	public   Guard hdG() {
		return(gu(0));
	}
	
	/**
	 * The top unifier on the unifier stack.
	 * 
	 * @return the top unifier on the unifier stack.
	 */
	public   Unifier hdU() {
		return(theta(0));
	}
	
	/**
	 * Drop the top deed (with associated event etc.) from the intention.
	 */
	public   void tlI(AILAgent ag) {
		if (hdE().referstoGoal()) {
			Goal g = hdE().getGoal();
			Goal gcloned = g.clone();
			gcloned.apply(hdU());
			dropP(1);
			if (!hdE().referstoGoal() || hdE().getGoal() != g) {
				ag.removeGoal(gcloned);
			}
		} else {
			dropP(1);
		}
	}
	
	/**
	 * Replace top of intention with a new event, deed, guard and unifier onto the top of the intention.
	 * 
	 * @param e The event.
	 * @param d The deed.
	 * @param g The guard.
	 * @param theta The unifier.
	 */
	public   void iReplace(Event e, Deed d, Guard g, Unifier theta) {
		dropP(1);
		ArrayList<Deed> ds = new ArrayList<Deed>();
		ArrayList<Guard> gs = new ArrayList<Guard>();
		
		gs.add(g);
		ds.add(d);
		
		IntentionRow ir = new IntentionRow (e, gs, ds, theta);
		push(ir);
	}

	/**
	 * Push a new event, deed, guard and unifier onto the top of the intention.
	 * 
	 * @param e The event.
	 * @param d The deed.
	 * @param g The guard.
	 * @param theta The unifier.
	 */
	public   void iCons(Event e, Deed d, Guard g, Unifier theta) {
		ArrayList<Deed> ds = new ArrayList<Deed>();
		ArrayList<Guard> gs = new ArrayList<Guard>();
		
		gs.add(g);
		ds.add(d);
		
		IntentionRow ir = new IntentionRow (e, gs, ds, theta);
		push(ir);
	}
	
	/**
	 * Compose a new unifier with the top unifier of the intention.
	 * 
	 * @param theta the new unifier.
	 */
	public   void compose (Unifier theta) {
		if (! empty()) {
			Event e = hdE();
			Deed d = hdD();
			Guard g = hdG();
			Unifier thetaHD = hdU();
			thetaHD.compose(theta);
		
			thetaHD.pruneRedundantNames(getVarNames());
			dropP(1);
			iCons(e, d, g, thetaHD);
		}
	}
	
	/**
	 * Get a list of all the variable names mentioned in the intention.  Useful when standardising
	 * apart.
	 * @return
	 */
	public List<String> getVarNames() {
     	ArrayList<String> varnames = new ArrayList<String>();
     	for (IntentionRow ir: intentionRows) {
     		varnames.addAll(ir.getVarNames());
     	}
     	return varnames;
	}

	
	/**
	 * Replace the top unifier of the intention.
	 * 
	 * @param theta the new top unifier.
	 */
	public void replace(Unifier theta) {
		if (! events().isEmpty()) {
			Event e = hdE();
			Deed d = hdD();
			Guard g = hdG();
	
			dropP(1);
			iCons(e, d, g, theta);
		}
	}
	
	/**
	 * The intention has no "plan" defined as a deed stack consisting of a 
	 * singleton no-plan-yet marker.
	 * 
	 * @return whether the intention has no plan.
	 */
	public   boolean noplan() {
		return (this.deeds().get(this.deeds().size() - 1).isNPY() && this.deeds().size() == 1);
	}
	
	/**
	 * Is the intention empty.  Defined as having an empty deed stack.
	 * 
	 * @return whether the intention is empty.
	 */
	public   boolean empty() {
		return (this.deeds().isEmpty());
	}
	
	/**
	 * Change the top guard of the intention.  Used when leaving (achieve)
	 * goals on the stack.
	 * 
	 * @param g
	 */
	public   void setTopGuard(Guard g) {
		int size = intentionRows.size();
		intentionRows.get(size - 1).setTopGuard(g);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Intention i) {
		if (this.size() != i.size()) {
			if (this.size() > i.size()) {
				return 1;
			}
			return -1;
		}
		return this.hdE().toString().compareTo(i.hdE().toString());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Intention) {
			Intention i = (Intention) o;
			if (this.size() == i.size()) {
				int index = 0;
				if (this.getSource() != i.getSource()) {
					return false;
				}
				
				if (this.getAnnotation() != i.getAnnotation()) {
					return false;
				}
				
				for (IntentionRow ir: intentionRows) {
					IntentionRow ir2 = i.intentionRows.get(index);
					if (!(ir.equals(ir2))) {
						return false;
					}
					index++;
				}
				return true;
			}
			
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int PRIME = 7;
		int result = PRIME * getSource().hashCode() + getAnnotation().hashCode();
		
		for (IntentionRow ir: intentionRows) {
			result = PRIME * result + ir.hashCode();
		}
		return result;
	}
	

}
