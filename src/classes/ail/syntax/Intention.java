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
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.syntax.annotation.SourceAnnotation;
import ail.tracing.events.ModificationEvent;
import ail.util.AILPrettyPrinter;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Class for an AIL Intention - a matrix structure consisting of several
 * rows of event, guard stack, deed stack, unifier stack.  Adapted heavily from the Jason
 * Intention class by Rafael H. Bording, Jomi F. Hubner et al.
 * 
 * @author louiseadennis
 *
 */
public class Intention implements Comparable<Intention>{
	@FilterField
	private static volatile int idCounter = 0;

	@FilterField
	protected final int id;
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
     * A pretty printer - tells the intention how to pretty print itself;
     */
    public AILPrettyPrinter pretty_printer = new AILPrettyPrinter();

    /**
     * Constructor.  Does nothing except create an empty intention.
     *
     */
    public Intention(AILPrettyPrinter pretty) {
    	id = idCounter++;
    	source = new SourceAnnotation(new Predicate("empty"));
    	pretty_printer = pretty;
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
    public Intention(Event e, ArrayList<Deed> ds, ArrayList<Guard> gu, Unifier theta, SourceAnnotation s, AILPrettyPrinter pretty) {
    	this(pretty);
    	iConcat(e, ds, gu, theta);
    	setSource(s);
    	trimUnifiers();
    }
    
    // Used for cloning (i.e. when we want to keep the same ID)
    private Intention(int ID, AILPrettyPrinter pretty) {
    	id = ID;
    	source = new SourceAnnotation(new Predicate("empty"));
    	pretty_printer = pretty;
    }
    
    //private Intention(int ID, ArrayList<Event> es, ArrayList<Deed> ds, ArrayList<Guard> gu, Unifier theta, SourceAnnotation s, AILPrettyPrinter pretty) {
    //	this(ID, pretty);
    //	iConcat(e, ds, gu, theta);
    //	setSource(s);
   // 	trimUnifiers();
   // }
    
    /**
     * Constructor
     * @param e
     * @param ds
     * @param gu
     * @param theta
     */
    public Intention(Event e, ArrayList<Deed> ds, ArrayList<Guard> gu, Unifier theta, AILPrettyPrinter pretty) {
    	this(e, ds, gu, theta, AILAgent.refertoself(), pretty);
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
    public Intention(Event e, Unifier u, SourceAnnotation s, AILPrettyPrinter pretty) {
    	this(e, s, pretty);
    	compose(u);
    	trimUnifiers();
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
    public Intention(Goal gl, SourceAnnotation s, AILPrettyPrinter pretty) {
    	this(pretty);
 
    	ArrayList<Guard> gs = new ArrayList<Guard>();
		GBelief gtrue = new GBelief();
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
    	
    	setSource(s);
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
    public Intention(Event e, SourceAnnotation s, AILPrettyPrinter pretty) {
    	this(pretty);
    	
    	ArrayList<Guard> gs = new ArrayList<Guard>();
		GBelief gtrue = new GBelief();
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
    	
    	setSource(s);
    }
    
    /**
     * Get the ID of the intention; right now this is a count of the how-manieth intention this is.
     */
    public int getID() {
    	return id;
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
     * Unsuspend the intention if it's condition is met by the new belief
     * @param beliefcondition
     */
    public void unsuspendFor(Predicate beliefcondition) {
    	if (suspended && suspendedfor != null && suspendedfor.unifies(new Literal(true, beliefcondition), new Unifier())) {
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
    			unsuspendFor(p);
    		}
    	}
    	if (suspended) {
    		for (Literal l: oldbeliefs) {
   				Literal l1 = l.clone();
   				if (! l.negated()) {
    				l1.setNegated(false);
    			}
    			unsuspendFor(l1);
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
    @Override
    public String toString() {
    	return pretty_printer.prettyIntention(this);
    }
    
    public void addPretty(AILPrettyPrinter pretty) {
    	pretty_printer = pretty;
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
    
    public ArrayList<Guard> guards() {
    	ArrayList<Guard> gs = new ArrayList<Guard>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		ArrayList<Guard> gsp = i.next().guards();
    		ListIterator<Guard> gi = gsp.listIterator();
    		while (gi.hasNext()) {
   		   			gs.add(gi.next());
    		} 
    	}
    	
    	return gs;
    }
    
    public ArrayList<Unifier> unifiers() {
    	ArrayList<Unifier> us = new ArrayList<Unifier>();
    	
    	ListIterator<IntentionRow> i = intentionRows.listIterator();
    	while (i.hasNext()) {
    		ArrayList<Unifier> usp = i.next().unifiers();
    		ListIterator<Unifier> ui = usp.listIterator();
    		while (ui.hasNext()) {
   		   			us.add(ui.next());
    		} 
    	}
    	
    	return us;
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
    
    public Event getEventforDeed(int i) {
    	int j = 0;
    	ListIterator<IntentionRow> intn = intentionRows.listIterator();
    	while (intn.hasNext()) {
    		IntentionRow intentionR = intn.next();
    		ArrayList<Deed> ds = intentionR.deeds();
    		for (Deed d: ds) {
    			if (j == i) {
    				return intentionR.getEvent();
    			}
    			j++;
    		}
    	}
    	return null;
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
    * The rows of the intention;
    */
   public ArrayList<IntentionRow> getRows() {
	   return intentionRows;
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
		trimUnifiers();
		
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
				
		intentionRows.trimToSize();
		trimUnifiers();
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
		try {
			return(theta(0));
		} catch (Exception e) {
			// This may be an empty intention
			return new Unifier();
		}
	}
	
	/**
	 * Drop the top deed (with associated event etc.) from the intention.
	 */
	public   void tlI(AILAgent ag) {
		if (hdE().referstoGoal()) {
			Goal g = (Goal) hdE().getContent();
			Goal gcloned = g.clone();
			gcloned.apply(hdU());
			dropP(1);
			if (empty() || !hdE().referstoGoal() || (Goal) hdE().getContent() != g) {
				if (ag.removeGoal(gcloned) && ag.shouldTrace()) {
					ag.trace(new ModificationEvent(getID(), ModificationEvent.GOALS, null, null, gcloned));
				}
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
		trimUnifiers();
	}
	
	/**
	 * Compose a new unifier with the top unifier of the intention.
	 * 
	 * @param theta the new unifier.
	 */
	public void compose (Unifier theta) {
		if (! empty()) {
			Event e = hdE();
			Deed d = hdD();
			Guard g = hdG();
			Unifier thetaHD = hdU();
			thetaHD.compose(theta);
		
			thetaHD.pruneRedundantNames(getVarNames());
			dropP(1);
			iCons(e, d, g, thetaHD);
			trimUnifiers();
		}
	}
	
	/**
	 * Get a set of all the variable names mentioned in the intention.
	 * @return
	 */
	private Set<String> getVarNames() {
     	Set<String> varnames = new HashSet<String>();
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
	@Override
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
	@Override
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
	@Override
	public int hashCode() {
		final int PRIME = 7;
		int result = PRIME * getSource().hashCode();
		if (getAnnotation() != null) {
			result = PRIME * result + getAnnotation().hashCode();
		}
		
		for (IntentionRow ir: intentionRows) {
			result = PRIME * result + ir.hashCode();
		}
		return result;
	}
	
	/**
	 * Remove unused variable names from unifiers.
	 */
	public void trimUnifiers() {
		Set<String> varnames = new HashSet<String>();
		for (int i = 0; i < size(); i++) {
			IntentionRow ir = intentionRows.get(i);
			varnames.addAll(ir.getVarNames());
		}
		
		for (int i = 0; i < size(); i++) {
			IntentionRow ir = intentionRows.get(i);
			ir.trimUnifiers(varnames);
		}
	}

	public Intention clone() {
		if (intentionRows.isEmpty()) {
			Intention i = new Intention(id, pretty_printer);
			return i;
		} else {
			Intention i = new Intention(id, pretty_printer);
			for (IntentionRow ir : getRows()) {
				i.push(ir.clone());
			}
			return i;
		}
	}
	
	public static void add_intention_to_sorted(Intention i, ArrayList<Intention> list) {
		int index = 0;
		if (list.isEmpty()) {
			list.add(i);
			return;
		}
		for (Intention in : list) {
			if (i.compareTo(in) < 0) {
				list.add(index, i);
				return;
			}
			index ++;
		}
		list.add(index, i);
	}

}
