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

import gov.nasa.jpf.JPF;

import java.util.Stack;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

// import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
//import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.Verify;

import ajpf.MCAPLException;
import ajpf.psl.Until;
import ajpf.util.VerifyMap;

/**
 * This is an implementation of a Buchi Automaton based on that presented in
 * Simple On-th-fly Automatic Verification of Linear Temporal Logic by
 * R. Gerth et. al, Protocol Specification, Verification and Testing, 1995.
 * With a few modifications.
 * 
 * The automaton is represented as a set of States - these are actually stored
 * in two HashMaps for easy access either by the state's number, or by its incoming
 * States (in order to efficiently acquire its successors).  As the automaton
 * is run the <code>currentState</code> field is checkeed for violations.
 * Temporal properties (until) obviously can't be checked.  Where there is a choice of
 * successor states one is chosen at random.  We rely on correct use of JPF to force
 * the system to check all possible outputs of the random number generator.
 * 
 * We can also check if we are in an accepting state - intended for  when JPF
 * detects it is in an end state.
 * 
 * We assume properties are in negation normal form.
 * 
 * @author louiseadennis
 * @see BuchiState
 *
 */
public class BuchiAutomaton {
	 protected static Logger log = JPF.getLogger("ajpf.psl.buchi.BuchiAutomaton");
	/**
	 * The states of the automaton indexed by number.
	 */
	private VerifyMap<Integer, BuchiState> statesbyNumber = new VerifyMap<Integer, BuchiState>();
	/**
	 * The states of the automaton indexed by incomming state numbers.
	 */
	protected VerifyMap<Integer, ArrayList<BuchiState>> statesbyIncoming = new VerifyMap<Integer, ArrayList<BuchiState>>();
	
	/**
	 * The current number of states in the automaton.  Used for creating new states.
	 */
	protected int numberstates = 2;
	
	/**
	 * The accepting sets associated with each until statement in the property.
	 */
	Map<Until, Set<Integer>> acceptingsets = new HashMap<Until, Set<Integer>>();
	
	Map<Integer, Set<Until>> acceptingsets_rev = new HashMap<Integer, Set<Until>>();
	
	ArrayList<Until> untilarray = new ArrayList<Until>();
	
	
	/**
	 * Initialise the Automation by expanding the states and setting currentStates.
	 * @param s
	 */
	public void init(BuchiState s, Set<Until> uns) {
		// Expand the initial state with the algorithm for creating the automata.
		for (Until u: uns) {
			log.fine("Adding Until: " + u.toString());
			acceptingsets.put(u, new HashSet<Integer>());
			untilarray.add(u);
		}

		// Assumes we are going to construct the property automata in advance.  We may wish to make this on-the-fly in future.
		s.expand(this);
		numberstates = statesbyNumber.values().size();
		log.info(this.toString());
		
		for (BuchiState s1: statesbyNumber.values()) {
			// Construct the accepting sets.
			for (Until u: acceptingsets.keySet()) {
				if (( ! s1.getOld().contains(u)) || s1.getOld().contains(u.getFmla2())) {
					log.finer("adding " + s1.getNumber() + " to accepting set for " + u );
					acceptingsets.get(u).add(s1.getNumber());
					if (acceptingsets_rev.containsKey(s1.getNumber())) {
						acceptingsets_rev.get(s1.getNumber()).add(u);
					} else {
						acceptingsets_rev.put(s1.getNumber(), new HashSet<Until>());
						acceptingsets_rev.get(s1.getNumber()).add(u);						
					}
				}
			    log.finer(" accepting set is " + acceptingsets.get(u));
			}
		}
		
	}
	
	/**
	 * Return the sets of accepting states for this automata.
	 * @return
	 */
	public Collection<Set<Integer>> getAccepting() {
		log.finer(acceptingsets.keySet().toString());
		log.finer(acceptingsets.values().toString());
		return acceptingsets.values();
	}
	
	/**
	 * Return the states in this automata.
	 * @return
	 */
	public Collection<BuchiState> getStates() {
		return statesbyNumber.values();
	}
		
	
	/**
	 * Given a set of new Buchi States this method adds them to the
	 * appropriate HashMaps.  The states are expected be unexpanded.
	 * 
	 * @param newstates The new unexpanded states to be added to the Buchi
	 *                  automaton.
	 */
	private void addtostatemaps(Stack<BuchiState> newstates) {
		for (BuchiState s : newstates) {
			Integer number = s.getNumber();
			statesbyNumber.put(number, s);
			Collection<Integer> incoming = s.getIncoming();
			for (Integer in : incoming) {
				updateStatesbyIncoming(in, s);
			}
		}
	}
	
	/**
	 * Checks whether the automaton duplicates a fully expanded state 
	 * States are identified when they contain the same
	 * old and next sets.
	 * 
	 * @param bs The <code>BuchiState</code> to be checked against.
	 * @return whether the automaton already contains this state.
	 */
	public boolean duplicates(BuchiState bs) {
		for (BuchiState s : statesbyNumber.values()) {
			if (s.isSameStateExceptNameAs(bs)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Returns a state that matches an existing state.  States are identified
	 * when they contain the same old and next sets.
	 * 
	 * @param bs The <code>BuchiState</code> to be matched.
	 * @return the matching state.
	 * @throws MCAPLException if no state matches.
	 */
	public BuchiState getMatchingState(BuchiState bs) throws MCAPLException {
		for (BuchiState s : statesbyNumber.values()) {
			if (s.isSameStateExceptNameAs(bs)) {
				return s;
			}
		}
		
		throw(new MCAPLException("No Matching State"));
	}

	
	/**
	 * Removes a state from the Buchi automata.  It is assumed that
	 * this state has just been fully expanded and that no states
	 * in the Automata have it marked as an incoming state.
	 * 
	 * @param bs the Buchi State to remove.
	 */
	public void removeState(BuchiState bs) {
		for (Integer incomingname: bs.getIncoming()) {
			statesbyIncoming.get(incomingname).remove(bs);
		}
	}
		
	/**
	 * Add a new state.
	 * 
	 * @param s The state to be added.
	 */
	public void addState(BuchiState s) {
		Stack<BuchiState> tmp = new Stack<BuchiState>();
		tmp.add(s);
		
		addtostatemaps(tmp);
	}
	
	/**
	 * Add a BuchiState to the StatesbyIncoming lists with a particular key.
	 * 
	 * @param in the key to be associated with s.
	 * @param s the BuchiState to be added.
	 */
	public void updateStatesbyIncoming(Integer in, BuchiState s) {
		if (statesbyIncoming.containsKey(in)) {
			statesbyIncoming.get(in).add(s);
			Collections.sort(statesbyIncoming.get(in));
		} else {
			ArrayList<BuchiState> st = new ArrayList<BuchiState>();
			st.add(s);
			statesbyIncoming.put(in, st);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		for (BuchiState st: statesbyNumber.values()) {
			s += st.toString() + "\n";
		}
		return s;
	}
	
	public int number_of_untils() {
		return untilarray.size() - 1;
	}
	
	/**
	 * Return a new number for the next state created in building the automata.
	 * @return a unique number for a new automata state.
	 */
	public Integer getNext() {
		int tmp = numberstates;
		numberstates++;
		return tmp;
	}
	

	/**
	 * Return a list of states that follow this one in the automata.
	 * @param s
	 * @return
	 */
	public List<BuchiState> possibleNextStates(int s) {
		return statesbyIncoming.get(s);
	}
	
	
	public Set<Integer> isAccepting(int s) {
		Set<Integer> ints = new HashSet<Integer>();
		// System.err.println(untilarray);
		if (acceptingsets_rev.containsKey(s)) {
			for (Until u: acceptingsets_rev.get(s)) {
				for (int i=0; i< untilarray.size(); i++) {
					//System.err.println(u);
					//System.err.println(untilarray.get(i));
					if (u.equals(untilarray.get(i))) {
						ints.add(i);
					}
					log.fine("Ints are " + ints);
					// System.err.println(ints);
				}
			}
		}
		// No until but therefore all states are accepting - HALP!!!
		if (untilarray.isEmpty()) {
			ints.add(-1);
			log.finer("Empty Until Array");
		}
		return ints;
	}
}
