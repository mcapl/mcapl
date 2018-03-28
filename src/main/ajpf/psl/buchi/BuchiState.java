// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf.psl.buchi;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.annotation.FilterField;

import ajpf.MCAPLException;
import ajpf.product.ModelState;
import ajpf.psl.Proposition;
import ajpf.psl.TrueProp;
import ajpf.psl.MCAPLProperty;



/**
 * A class for holding individual states in a Buchi Automata built according to the algorithm in
 * Gerth et. al.  in Simple On-th-fly Automatic Verification of Linear Temporal Logic.  This
 * builds and automaton by expanding individual states, starting with a state to hold the LTL
 * formula to be checked it expands this state gradually unfolding the formula and creating
 * new states where necessary.  Some of these new states are later removed from the Automata.
 * 
 * The expansion process uses three key sets of properties.  New is a set of LTL formula that should
 * hold true in the current state.  These have not yet been processed into the actual formulae to be checked.  
 * Old is the actual formulae to be checked in the stae and Next are the formulae that should hold in the
 * next state.
 * @author lad
 *
 */
public class BuchiState implements Comparable<BuchiState> {
	 protected static Logger log = JPF.getLogger("ajpf.psl.buchi.BuchiState");
	/**
	 * The states that transition to this one.
	 */
	private TreeSet<Integer> incoming = new TreeSet<Integer>();
	/**
	 * The (unprocessed) formulae that should hold in this state of the automata.
	 */
	private TreeSet<MCAPLProperty> newprops = new TreeSet<MCAPLProperty>();
	private String initialnewprops = "";
	/**
	 * The (processed) formulae that should hold true in this state of the automata.  See Gerth et. al for details.
	 */
	private TreeSet<MCAPLProperty> old = new TreeSet<MCAPLProperty>();
	/**
	 * The formulae that should hold true in the next state of the automata.  See Gerth et. al for
	 * details.
	 */
	private TreeSet<MCAPLProperty> next = new TreeSet<MCAPLProperty>();
	/**
	 * Unique identifying number for the state.
	 */
	protected int number;

	/**
	 * Is the next state empty - i.e, we are guaranteed an accepting run from here.
	 */
	@FilterField
	protected boolean emptyNext;
	
	/**
	 * Each Buchi state  is labelled with states in the model where its states in old are true.
	 */
	TreeSet<Integer> labels = new TreeSet<Integer>();
	
	/**
	 * Constructor makes an automata state from a number, and incoming state
	 * and one property.  old and next HashSets start
	 * empty and are expanded by the expand function.
	 * 
	 * @param i The number of the state.
	 * @param i The name of the incoming node.
	 * @param fs The obligation Property.
	 */
	public BuchiState(Integer i, MCAPLProperty fs, Integer n) {
		number = n;
		incoming.add(i);
		newprops.add(fs);
		initialnewprops = newpropstring(newprops);
	}

	/**
	 * Constructor makes an automata state from a number, and incoming state
	 * and a HashSet of (unexpanded) obligations.  old and next HashSets start
	 * empty and are expanded by the expand function.
	 * 
	 * @param i The number of the state.
	 * @param i The number of the incoming node.
	 * @param fs The obligation HashSet.
	 */
	public BuchiState(Integer i, TreeSet<MCAPLProperty> fs, Integer n) {
		number = n;
		incoming.add(i);
		newprops = fs;
		initialnewprops = newpropstring(newprops);
	}
	
	/**
	 * Constructor that makes a new automata set by setting all fields.
	 * 
	 * @param i The set of the names of incoming nodes.
	 * @param newS The set of unexpanded obligations.
	 * @param oldS The set of expanded obligations.
	 * @param nextS The set of obligations for the next state.
	 * @param i The number of the state.
	 */
	public BuchiState(Collection<Integer> i, TreeSet<MCAPLProperty> newS, TreeSet<MCAPLProperty> oldS, TreeSet<MCAPLProperty> nextS, Integer n) {
		number = n;
		incoming = new TreeSet<Integer>(i);
		newprops = newS;
		old = oldS;
		next = nextS;
		initialnewprops = newpropstring(newprops);
	}
	
	/**
	 * Getter method for the state's number.
	 * @return
	 */
	public Integer getNumber() {
		return number;
	}
	
	/**
	 * Getter method of the numbers of all incoming states.
	 * 
	 * @return A HashSet of the numbers of all incoming states.
	 */
	public TreeSet<Integer> getIncoming() {
		return incoming;
	}
	
	/**
	 * Getter method for the "old" properties.  Those that must hold
	 * in the current state of the program.
	 * 
	 * @return the obligations that should hold in the current state of the 
	 * program.
	 */
	public TreeSet<MCAPLProperty> getOld() {
		return old;
	}
	
	/**
	 * Getter method for the "next" properties.  Those that must hold in the
	 * next state of the program.
	 * 
	 * @return the obligations that should hold in the next state of the program.
	 */
	public TreeSet<MCAPLProperty> getNext() {
		return next;
	}
	
	
	public String getNPString() {
		return initialnewprops;
	}
	
	/**
	 * Buchi Automata generation.  This method expands a BuchiState by
	 * moving the formulae in new into old and next where old are the obligations
	 * this state should satisfy and next the obligations the next state should satisfy.
	 * Once new is empty the state is added to the automaton.
	 * Some properties (such as until) split the state.
	 * 
	 * @param automaton the automaton for which this is a state.
	 * @return the set of properties to be satsified in the next states of the 
	 * automaton.
	 */
	public void expand(BuchiAutomaton automaton) {	
		// Collapses the HashSet to a canonical form
		// this.toString();
		if (newprops.isEmpty()) {
			if (automaton.duplicates(this)) {
				try {
					BuchiState bs = automaton.getMatchingState(this);
					bs.addIncoming(incoming, automaton);
				} catch (MCAPLException e) {
					System.err.println(e.getMessage());
				}
			} else {
				TreeSet<MCAPLProperty> newnew = new TreeSet<MCAPLProperty>();
				for (MCAPLProperty n: next) {
					newnew.add(n);
				}
				BuchiState ns = new BuchiState(number, newnew, automaton.getNext());
				automaton.addState(this);
				ns.expand(automaton);
			}
		} else {
			Iterator<MCAPLProperty> newI = newprops.iterator();
			MCAPLProperty eta = newI.next();
			newI.remove(); // remove eta from 
			if (! eta.isContradiction(old)) {
				if (eta.splitsAutomataState()) {
					TreeSet<MCAPLProperty> new1 = new TreeSet<MCAPLProperty>();
					TreeSet<MCAPLProperty> new2 = new TreeSet<MCAPLProperty>();
					TreeSet<MCAPLProperty> old1 = new TreeSet<MCAPLProperty>();
					TreeSet<MCAPLProperty> old2 = new TreeSet<MCAPLProperty>();
					TreeSet<MCAPLProperty> next1 = new TreeSet<MCAPLProperty>();
					TreeSet<MCAPLProperty> next2 = new TreeSet<MCAPLProperty>();

					for (MCAPLProperty p: newprops) {
						new1.add(p);
						new2.add(p);
					}
					for (MCAPLProperty p: old) {
						old1.add(p);
						old2.add(p);
					}
					for (MCAPLProperty p: next) {
						next1.add(p);
						next2.add(p);
					}

					new1.addAll(eta.addtoNew1(old, new1));
					old1.addAll(eta.addtoOld1());
					next1.addAll(eta.addtoNext1());
					BuchiState ns1 = new BuchiState(incoming, new1, old1, next1, automaton.getNext());
					ns1.expand(automaton);

					new2.addAll(eta.addtoNew2(old, new2));
					old2.addAll(eta.addtoOld2());
					next2.addAll(eta.addtoNext2());
					BuchiState ns2 = new BuchiState(incoming, new2, old2, next2, automaton.getNext());

					// ns1.expand(automaton);
					ns2.expand(automaton);
				} else {
					if (eta instanceof TrueProp) {
						if (old.isEmpty()) {
							old.addAll(eta.addtoOld());
						}
					} else{
						old.addAll(eta.addtoOld());
					}
					newprops.addAll(eta.addtoNew(old));
					next.addAll(eta.addtoNext());
					expand(automaton);
				}
			} 
		}
		
	}
	
	/**
	 * Detects whether this Buchi State is fully expanded or not.  This is
	 * defined by whether the "new" (i.e., unprocessed) formulas HashSet is
	 * empty or not.
	 * 
	 * @return Whether the state is fully expanded.
	 */
	protected boolean isExpanded() {
		return (newprops.isEmpty());
	}
	
	/**
	 * Detects whether this Buchi State is not fully expanded.  This is
	 * defined by whether the "new" (i.e., unprocessed) formulas HashSet is
	 * empty or not.
	 * 
	 * @return Whether the state is not fully expanded.
	 */
	protected boolean isUnexpanded() {
		return (! isExpanded());
	}
	
	/**
	 * Checks for violations of any properties that can be detected in the current
	 * state.  It assumes that the state is fully expanded - it will not behave
	 * correctly if it is not.  It therefore assumes that all the property obligations
	 * on this state are to be found in the old HashSet.  Calls the check method of 
	 * the MCAPLPropertys and assumes this method is implemented correctly - i.e., 
	 * checks of temporal properties default to false.
	 * 
	 * @return true if there are no property violations detectable on this stae.
	 */
	public boolean check() {
		boolean flag = true;
//		System.err.println(number);

		for (MCAPLProperty f : old) {
			if (! f.check()) {
				flag = false;
				break;
			}
		} 
		
		return flag;
	}
	
	public boolean check(Set<Proposition> props) {
		boolean flag = true;
//		System.err.println(number);

		for (MCAPLProperty f : old) {
			if (! f.check(props)) {
				flag = false;
				break;
			}
		} 
		
		return flag;
	}

	
	/** 
	 * Checks whether two BuchiStates can be identified.  Defined when two
	 * Buchi States are both fully expanded and contain the same old and 
	 * next fields.  They are not the same state, however, because they
	 * have different names.
	 * 
	 * @param bs the <code>BuchiState</code> to be checked against.
	 * @return whether the two states can be identifed.
	 */
	public boolean isSameStateExceptNameAs(BuchiState bs) {
		if (isExpanded() && bs.isExpanded()) {
			if (old.equals(bs.getOld())) {
				if (next.equals(bs.getNext())) {
					if (number != bs.getNumber()){
						return true;
					}
				}
			}
			
			return false;
		}
		
		return false;
	}
	
	
	
	/**
	 * Add new Buchi State names to the incoming field.  Used when a new
	 * state is identified with this one and its incoming states are then
	 * identified with this.
	 * 
	 * @param newincoming
	 */
	public void addIncoming(Collection<Integer> newincoming, BuchiAutomaton automaton) {
		for (Integer bsname : newincoming) {
			if (! incoming.contains(bsname)) {
				incoming.add(bsname);
				automaton.updateStatesbyIncoming(bsname, this);
			}
		}
	}
	
	/*
	 * 
	 */
	private String newpropstring(TreeSet<MCAPLProperty> newprops) {
		StringBuilder s = new StringBuilder();
		for (MCAPLProperty p: newprops) {
			s.append(p.toString()).append(",");
		}
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder("Number: " + number + "\n");
		s.append("Incoming States: ");
		for (Integer i: incoming) {
			s.append(i).append(",");
		}
		s.append("\n");
		s.append("True in this State: ");
		for (MCAPLProperty p: old) {
			s.append(p.toString()).append(",");
		}
		s.append("\n");
		if (! next.isEmpty()) {
			s.append("True in next State: ");
			for (MCAPLProperty p: next) {
				s.append(p.toString()).append(",");
			}
		}
		
		
		return s.toString();
	}
	
	
	
	public TreeSet<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		for (MCAPLProperty f: old) {
			for (Proposition p: f.getProps()) {
				if (!props.contains(p)) {
					props.add(p);
				}
			}
		}
		return props;
	}
	
	public int compareTo(BuchiState bs) {
		return bs.getNumber().compareTo(getNumber());
	}

	public boolean label(ModelState s) {
		log.finer(this + " labelling with? " + s + ":" + s.getProps());
		boolean islabelled = false;
		if (check(s.getProps())) {
			labels.add(s.getNum());
			islabelled = true;
			log.fine(this + " LABELLED with " + s);
		}
		return islabelled;
	}
	
	public boolean labeledWith(Integer s) {
		log.fine("checking " + number + " labelled with " + s);
		return labels.contains(s);
	}
}
