// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.product;

import ajpf.psl.buchi.BuchiAutomaton;
import ajpf.psl.buchi.BuchiState;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.Until;
import ajpf.psl.Proposition;
import ajpf.util.AJPFException;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A class that represents the current Product Automaton.  
 * Including the current path() being explored through that automaton.
 * 
 * Much of the theory here can be found in 
 * 
 * Rob Gerth, Doron Peled, Moshe Y. Vardi, and Pierre Wolper. 1995. 
 * Simple on-the-fly automatic verification of linear temporal logic. 
 * In Proceedings of the Fifteenth IFIP WG6.1 
 * International Symposium on Protocol Specification, Testing and Verification XV, 
 * Piotr Dembinski and Marek Sredniawa (Eds.). Chapman & Hall, Ltd., London, UK, UK, 3-18.
 * 
 * and
 * 
 * Memory-efficient algorithms for the verification of temporal properties (1992)
 * by C. Courcoubetis , M. Vardi , P. Wolper , M. Yannakakis
 * FORMAL METHODS IN SYSTEM DESIGN
 * 
 * @author louiseadennis
 *
 */
public class Product {
	 protected static Logger log = JPF.getLogger("ajpf.product.Product");
	 
	 /* The number of states in this automaton */
	 int number_of_states = 0;

	 /* The program model */
	MCAPLmodel m;

	/* The Buchi Automaton */
	BuchiAutomaton b = new BuchiAutomaton();
	
	/**
	 * The states in this automaton indexed by the states that transition to them.
	 */
	Map<Integer, HashSet<ProductState>> statesbyIncoming = new HashMap<Integer, HashSet<ProductState>>();
		
	/* Each product state has a number.  We index them by their number */
	Map<Integer, ProductState> productbyNumber = new HashMap<Integer, ProductState>();

	/* Complex nested maps indexing product state numbers by their modelstate number, 
	 * then their buchi state number, and then until counter.
	 * The use of a counter on until statements is explained in [1] and [2] above */
	Map<Integer, Map<Integer, Map<Integer, Integer>>> existence = new HashMap<Integer, Map<Integer, Map<Integer, Integer>>>();
	
	/**
	 * A Map from a given product state the the until statements in which is is accepting.
	 */
	Map<Integer, Set<Integer>> accepting_for_untils = new HashMap<Integer, Set<Integer>>();
	
	/* If there is an accepting path, record it here */
	List<ProductState> accepting_path;
	
	/* A set of atomic propositions relevant to this Automata */
	Set<Proposition> props;
	
	/* Types of Product Automata */
	public enum AutomataType {
		DEFAULT_AUTOMATA,
		PROBABILISTIC_AUTOMATA
	}
	
	/* If we want to output our model to a different model checker then we do not want to build
	 * a product automaton.  This field is used to track this information.
	 */
	boolean model_only = false;
	

	/**
	 * Constructor.
	 * @param negprop
	 * @param props
	 */
	public Product(MCAPLProperty negprop, Set<Proposition> ps, AutomataType automata_type, boolean m_only) {
		if (!m_only) {
			Set<Until> untils = negprop.getUntils();
			BuchiState init = new BuchiState(0, negprop, 1);
			b.init(init, untils);
		} else {
			model_only = true;
		}
		props = ps;
		if (automata_type == AutomataType.PROBABILISTIC_AUTOMATA) {
			m = new ProbabilisticModel(props);
		} else {
			m = new MCAPLmodel(props);
		}
	}

	/**
	 * Create the automata from a negated property.
	 * @param negprop
	 * @param untils
	 */
	protected void init(MCAPLProperty negprop) {
  		Set<Until> untils = negprop.getUntils();
 		BuchiState init = new BuchiState(0, negprop, 1);
 		b.init(init, untils);
 	}
	
	/**
	 * In some situations, particularly where we have decided to abort further search, we
	 * still want to add a new state (and edges) to the model, even  if we don't want to 
	 * run any LTL search on the automaton.
	 * @param modelstatenum
	 * @return
	 */
	public boolean justAddModelState(int modelstatenum) throws AJPFException {
		log.fine("Entering justaddModelState");
		ModelState s = m.containsState(modelstatenum);
		if (s == null) {
			if (lowerLogLevelThan(Level.FINER)) {
				log.finer("Props are: " + props);
			}
			s = new ModelState(modelstatenum, props);
			m.addState(s);
		}
		m.addEdge(s);
		m.addToPath(s);
		log.fine("Leaving justaddModelState");
		return true;
		
	}
		
	int endstatecount = -2;
	public boolean addEndState(int modelstatenum) throws AJPFException {
		Integer from = m.getEndofPathState();
		ModelState from_state = m.containsState(from);
		ModelState s = new ModelState(endstatecount, from_state);
		m.addState(s);
		m.addEdge(s);
		m.addToPath(s);
		endstatecount--;
		return true;
	}
	
	/**
	 * A new model state has been generated, update the product automata accordingly;
	 * @param modelstatenum
	 */
	public boolean addModelState(int modelstatenum) throws AJPFException {
		log.fine("Entering addModelState");
		ModelState s = m.containsState(modelstatenum);
		// If s == null then this model state does not already exist
		// Otherwise we just want to add a link to this model state from the end of the current path.
		if (s == null) {
			s = new ModelState(modelstatenum, props);
			m.addState(s);

			// model only is for situations where LTL model checking is delegated to some external system
			// and we are just building a model of the program.  There for there is no need to build the
			// property automata.
			if (!model_only) {
				// Some state labelled is true if there is at least one state in the property automata that can
				// be paired with this state in the program model.  The property is automatically true on this
				// branch if no state can be labelled.
				boolean somestatelabelled = false;
				for (BuchiState bs: b.getStates()) {
					somestatelabelled = somestatelabelled | bs.label(s);
				}
			
				//  If no state is labelled then we can stop exploration at this point and prune (as in not explore)
			    // the rest of this branch in the program model.
				if (!somestatelabelled) {
					s.markdone();
					// Add as an edge so it can be pruned.
					m.addToPath(s);
					List<Integer> current_model_path = m.getCurrentPath();
					if (lowerLogLevelThan(Level.INFO)) {
						log.info("Adding " + s + " to " + current_model_path);
						log.info("Always True from Now On");
					}
					return false;
				}
			}
		}

		m.addEdge(s);
		List<Integer> current_model_path = m.getCurrentPath();
		if (lowerLogLevelThan(Level.INFO)) {
			log.info("Adding " + s + " to " + current_model_path);
		}
		// We've extended the program model now, if so desired, we extend the product automata.
		if (!model_only) {
			boolean hassuccessors = true;
			// Generate any new states in the product automaton created by adding this edge (and state) to the
			// program model.
			if (!current_model_path.isEmpty()) {
				hassuccessors = newProductStates(s, current_model_path.get(m.currentPathSize() - 1));
			} else {
				hassuccessors = newProductStates(s);
			}
		
			// If we have successors advance the LTL model checking as far as possible to look for failure.
			if (hassuccessors) {
				accepting_path = DFS();
			}
		}
		m.addToPath(s);
		return true;
		

	}
	
	/**
	 * The current path in the model has ended.
	 * 
	 * Extend the product automata and run the DFS to see if an accepting path can be found.
	 * @return
	 */
	public boolean currentPathEnded() {
		// This is irrelevant if we are just constructing the program model.
		if (model_only) {
			return false;
		}
		
		List<Integer> current_model_path = m.getCurrentPath();
		if (m.currentPathSize() > 0) {
		newProductStates(current_model_path.get(m.currentPathSize() - 1));
		m.getState(current_model_path.get(m.currentPathSize() - 1)).markdone();
		}
		accepting_path = DFS();
		
		return (!accepting_path.isEmpty());
	} 
	


	
	/**
	 * Create new states in the Product Automata on the assumption that we have added
	 * newModelState to the end of a path that previously ended with lastModelState
	 * @param newModelState
	 * @param lastModelState
	 * @return
	 */
	protected boolean newProductStates(ModelState newModelState, Integer lastModelState) {
		log.fine("Entering new Product States in order to expand the path");
		
		// This is the list of product states that are associated with the last state in the model.
		Set<ProductState> ps = getProductStates(lastModelState);
		boolean has_succs = false;
		for (ProductState p: ps) {
			if (m.currentPathContains(newModelState)) {
				log.fine("Current path contains this model state");
				// The model is looping - we want to generate the path(s) of successors in the product
				// that we get by following the loop in the model - there may be more than one of these
				// since loops in the product may involve several passes of the loop in the model.
				has_succs = p.calculateSuccessors(newModelState.getNum(), false);
			} else {
				// We calculate the successors for the product states now we know there is a (non-looping) new edge in the model state.
				has_succs = p.calculateSuccessors(newModelState.getNum(), false);
			}
			
			
		}
		return (has_succs);
	}
	
	/**
	 * This is the first model state on the path.  So we need to generate product automaton states for it
	 * from the initial state of the Buchi Automaton.  Set up the indexes etc.
	 * @param newModelState
	 * @return
	 */
	protected boolean newProductStates(ModelState s) {
		log.fine("Entering new Product States with Initial State in Path");
		List<ProductState> ps = new ArrayList<ProductState>();
		// Get the possible next states in the Buchi Automaton
		/* List<BuchiState> buchi = b.possibleNextStates(0);
		if (buchi.isEmpty()) {
			return false;
		}
			 
		Map<Integer, Map<Integer, Integer>> indexedbybuchi = new HashMap<Integer, Map<Integer, Integer>>();
		Integer modelnum = s.getNum();
		
		// Create product states for each relevant property state and add to all the various indexes.
		for (BuchiState bs : buchi) {
			if (bs.labeledWith(modelnum)) {
				Integer buchi_number = bs.getNumber();
				Map<Integer, Integer> indexedbyuntil = new HashMap<Integer, Integer>();
				indexedbybuchi.put(buchi_number, indexedbyuntil);

				ProductState p = new ProductState(buchi_number, modelnum, 0);
				ps.add(p);
				Integer pnum = p.getNum();
				productbyNumber.put(pnum, p);
				indexedbyuntil.put(0, pnum);
			}
		} 
		existence.put(modelnum, indexedbybuchi);
		*/
		
		Map<Integer, Map<Integer, Integer>> indexedbybuchi = new HashMap<Integer, Map<Integer, Integer>>();
		Integer modelnum = s.getNum();
		Map<Integer, Integer> indexedbyuntil = new HashMap<Integer, Integer>();
		indexedbybuchi.put(0, indexedbyuntil);
		ProductState p = new ProductState(0, modelnum, 0);
		ps.add(p);
		Integer pnum = p.getNum();
		productbyNumber.put(pnum, p);
		indexedbyuntil.put(0, pnum);
		existence.put(modelnum, indexedbybuchi);


		// Add to S1 (the depth first LTL search tree) as new start states.
		if (lowerLogLevelThan(Level.FINER)) {
			log.finer("S1 is: " + S1.toString());
		}
		
		S1.addAll(ps);
		if (lowerLogLevelThan(Level.FINER)) {
			log.finer(S1.toString());
		}

		return true;
	}
	
	/**
	 * This one is called when the current path in the program model has ended - presumably because the program has terminated.
	 * This doesn't mean that the current path in the product automata necessarily ends here since there may be transitions the 
	 * buchi automaton can take while remaining in this program end state.
	 * @param newModelState
	 * @return
	 */
	 protected boolean newProductStates(Integer newModelState) {
		log.fine("Entering new Product States with Integer");
		Set<ProductState> ps = getProductStates(newModelState);
		boolean successors = false;
		for (ProductState p: ps) {
			successors = p.calculateSuccessors(p.getModelState(), true);			
		}
		return (successors);
	}  

	/**
	 * Get the product states associated with a particular state in the model.
	 * @param modelstatenum
	 * @return
	 */
	protected Set<ProductState> getProductStates(int modelstatenum) {
		Set<ProductState> list = new HashSet<ProductState>();
		Map<Integer, Map<Integer, Integer>> indexedbybuchi = existence.get(modelstatenum);
		if (indexedbybuchi != null) {
			if (lowerLogLevelThan(Level.FINER)) {
				log.finer("indexedbybuchi is:" + indexedbybuchi.toString());
			}
			for (Map<Integer, Integer> indexbyuntil: indexedbybuchi.values()) {
				for (int ps: indexbyuntil.values()) {
					list.add(productbyNumber.get(ps));
				}
			}
		}
		return list;
	}

	/**
	 * This state in the model need not be explored further.
	 * @param modelstatenum
	 */
	public void done(int modelstatenum) {
		if (lowerLogLevelThan(Level.FINE)) {
			log.fine("Setting done " + modelstatenum);
		}
		m.setdone(modelstatenum);
		if (lowerLogLevelThan(Level.FINER)) {
			log.finer("Product State is:" + print_product());
		}
	}
	
	/**
	 * Do we have an accepting path in the current (partial) build of this product automaton?
	 * @return
	 */
	public boolean hasAcceptingPath() {
		if (model_only) {
			return false;
		}
		if (!accepting_path.isEmpty()) {
			// System.err.println(accepting_path);
		}
		return (!accepting_path.isEmpty());
	} 
	
	/**
	 * Prune the various current paths here and in the model if the model exploration has backtracked.
	 * @param statenum
	 */
	public void pruneCurrentPath (int statenum) {
		if (lowerLogLevelThan(Level.FINE)) {
			log.fine("pruning " + statenum);
		}
		m.prune(statenum);	
		accepting_path = DFS();
	}

	/**
	 * Return the accepting path - returns null if there isn't one.
	 * @return
	 */
	public List<ProductState> getAcceptingPath() {
		return accepting_path;
	}
	
	/**
	 * Get the path in the model represented by the accepting path in the product automata.
	 * @return
	 */
	public List<Integer> getModelAcceptingPath() {
		List<Integer> modelpath = new ArrayList<Integer>();
		if (model_only) {
			return modelpath;
		}
		for (ProductState p: getAcceptingPath()) {
			modelpath.add(p.getModelState());
		}
		return modelpath;
	}
		
	/**
	 * Overridable method for annotating model edges.
	 * @param a
	 */
	public void annotate_edge(double a) {
		log.fine("Annotating an edge");
		m.annotate_edge(a);
	}
	
	/**
	 * Getter for the program model;
	 * @return
	 */
	public MCAPLmodel getModel() {
		return m;
	}
	
	
	// This is where we implement the algorithms from Courcoubetis et al, Memory-Efficient Algorithms for the Verification 
	// of Temporal Properties.
	// This involves two nested depth first searches.
	
	// The current depth first path in the first DFS
	List<ProductState> S1 = new ArrayList<ProductState>();
	// A Map indicated whether a given product state has been visited by this search yet.
	Map<Integer, Boolean> M1 = new HashMap<Integer, Boolean>();
	// We also link the product state to an iterator over its unvisited successor states.
	// Hopefully the use of iterators will allow us to do some efficiency savings.
	Map<Integer, Iterator<ProductState>> M1it = new HashMap<Integer, Iterator<ProductState>>();
	
	// The current depth first path in the second DFS
	List<ProductState> S2 = new ArrayList<ProductState>();
	// A Map indicated whether a given product state has been visited by this search yet.
	Map<Integer, Boolean> M2 = new HashMap<Integer, Boolean>();
	// The map between a product state and the iterators of its unvisited states under M2.
	Map<Integer, Iterator<ProductState>> M2it = new HashMap<Integer, Iterator<ProductState>>();
	
	/**
	 * This implements the interleaved double DFS algorithm with Courcoubetis et al, in such a way that its execution can
	 * be interleaved with generation of the product automata.  Full details of the algorithm can be found in the paper.
	 * 
	 * It returns an accepting path if it finds one and an empty path if it doesn't.
	 * @return
	 */
	public List<ProductState> DFS() {
		// Don't do any of this if we are only building a model of the program.
		boolean canexplore = !model_only;
		
		// We run DFS in an interleaved fashion as we build the product automata
		// Therefore we also use canexplore to indicate that we can't explore the DFS tree any
		// further in the current state of the Product Automata.
		while (canexplore & !S1.isEmpty()) {
			ProductState x = S1.get(S1.size() - 1);
			if (lowerLogLevelThan(Level.FINE)) {
				log.fine("Current DFS State: " + x.toString());
			}

			Iterator<ProductState> m1iterator = M1it.get(x.getNum());
			
			if (m1iterator.hasNext()){
				ProductState y = m1iterator.next();
				M1.put(y.getNum(), true);
				S1.add(y);	
				if (lowerLogLevelThan(Level.FINE)) {
					log.fine("New Path: " + S1.toString());
				}
			} else {
				if (! x.modelIsDone()) {
					// We haven't fully generated the model for this node yet.
					// can't find any successors for this node doesn't mean there aren't any
					// so we need to suspend the depth first search until this node is fully explored.
					log.fine("Model isn't done");
					canexplore = false;
					break;
				} else {

					log.fine("Moving into second DFS");
					S1.remove(S1.size() - 1);

					if (x.isAccepting()) {
						log.fine("This state is accepting");
						S2.add(x);
						while (! S2.isEmpty()) {
							log.fine("S2 isn't empty");
							ProductState v = S2.get(S2.size() - 1);
							if (v.getSuccessorNums().contains(x.getNum())) {
								List<ProductState> acceptingpath = new ArrayList<ProductState>();
								acceptingpath.addAll(S1);
								acceptingpath.addAll(S2);
								if (lowerLogLevelThan(Level.FINE)) {
									log.fine("returning " + acceptingpath);
								}
								return acceptingpath;
							} else {
								log.fine("v's successors do not contain x" + S2);
								Iterator<ProductState> m2iterator = M2it.get(v.getNum());
								if (m2iterator.hasNext()) {
									ProductState w = m2iterator.next();
									M2.put(w.getNum(), true);
									S2.add(w);
								}	else {
									S2.remove(S2.size() - 1);
								}
								log.fine("S2" + S2);
							}
						}
					}
				}
			}
		}
		
		return new ArrayList<ProductState>();
	}
	
	/**
	 * Size of this product autataon.
	 * @return
	 */
	public int size() {
		return number_of_states;
	}

	/**
	 * At the moment there are no configuration options for the product automata, but there are some for the model and
	 * so this call is passed on.
	 * @param config
	 */
	public void setConfig(Config config) {
		m.setConfig(config);
	}
	
	/**
	 * I'm under the impression that composition of strings is quite inefficient in java.  Therefore we don't want to
	 * perform such compositions for logging messages unless absolutely necessary.  This is a "helper" function for simply
	 * determing the log level and it is wrapped around any log message that requires string composition.  I _think_ using
	 * this function doesn't introduce a competeing overhead because it is static, but I could be wrong.
	 * @param l
	 * @return
	 */
	private static boolean lowerLogLevelThan(Level l) {
		if  (log.getLevel().intValue() <= l.intValue()) {
			return true;
		}
		return false;
	}

	
	/**
	 * Helper class for storing tuples of automata states and model states.
	 * @author louiseadennis
	 *
	 */
	public class ProductState implements Comparable<ProductState>{
		// The property automata state
		Integer buchistate;
		// The program model state
		int modelstate;
		// The number for this state.
		int statenum;
				
		// The set of Until statements in the property expression that this state is 
		// accepting in.  These are indicated by integers and we "rotate" through them as described in 
		// Gerth et al.  The product state is only accepting if it is accepting in the 0th until.
		Set<Integer> acceptinginuntils = new HashSet<Integer>();
		
		// By default we are currently checking the zeroth until until.
		int until = 0;
		
		// The number of possible next states in the property automata.
		Integer compnum = 0;
		
		/* Is there a model state.  Sometimes there isn't if the model run is terminating and non looping */
		boolean hasmodelstate = false;
		
		/* Are we generating this product state in order to see if the program model is in the prefix of an
		 * accepting run in the product automata.
		 */
		boolean maybeungeneratedsuccessors = false;
		
		/**
		 * Constructor.
		 * @param bs
		 * @param index
		 */
		ProductState(Integer bs, int index, int u) {
			buchistate = bs;
			modelstate = index;
			hasmodelstate = true;
			until = u;
			statenum = number_of_states++;
			
			Set<Integer> acceptingin = b.isAccepting(buchistate);
			
			if (lowerLogLevelThan(Level.FINE)) {
				log.fine(acceptingin.toString());
			}
			
			acceptinginuntils.addAll(acceptingin);
			
			// Note that this state has not yet been fully explored in the DFS searches
			M1.put(statenum, false);
			M1it.put(statenum, unvisitedSuccessors(M1));
			M2.put(statenum, false);
			M2it.put(statenum, unvisitedSuccessors(M2));

			statesbyIncoming.put(statenum, new HashSet<ProductState>());
			
			if (lowerLogLevelThan(Level.FINE)) {
				log.fine("Creating Product State:" + this);
				
				if (lowerLogLevelThan(Level.FINER)) {
					log.finer(acceptinginuntils.toString());
				}
			}
			
			compnum = b.possibleNextStates(bs).size();
		}

		/**
		 * Setter for whether this product is just for checking the prefix.
		 */
		public void setUngeneratedSuccessors() {
			maybeungeneratedsuccessors = true;
		}
		
		/**
		 * Return the current successors of this product state in the automata
		 * @return
		 */
		Iterator<ProductState> getSuccessors() {
			return statesbyIncoming.get(statenum).iterator();
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(ProductState s) {
			return ((Integer) statenum).compareTo((Integer) s.getNum());
		}

		/**
		 * Return the number of possible successors to the property in the Buchi Automatan.
		 * @return
		 */
		public Integer compSize() {
			return compnum;
		}
		
		/**
		 * Get a lists of the numbers of the successors to this product state.
		 * @return
		 */
		List<Integer> getSuccessorNums() {
			List<Integer> sucnums = new ArrayList<Integer>();
			Iterator<ProductState> successors_iterator = getSuccessors();
			while (successors_iterator.hasNext()) {
				sucnums.add(successors_iterator.next().getNum());
			}
			return sucnums;
		}
		
		/**
		 * An iterator over the successors of this product state that have not been visited by one of the depth first
		 * searches.  The map stores information on which have been visited and which haven't.
		 * @param map
		 * @return
		 */
		Iterator<ProductState> unvisitedSuccessors(final Map<Integer, Boolean> map) {

			return new Iterator<ProductState>() {
				private ProductState nextUnvisitedSuccessor = null;
				//Iterator<ProductState> succs = getSuccessors();
				
				public void remove() {}
				
				public ProductState next() {
					if (nextUnvisitedSuccessor == null) {
						get();
					}
					
					ProductState p = nextUnvisitedSuccessor;
					nextUnvisitedSuccessor = null;
					return p;
					
				}
				
				public boolean hasNext() {
					if (nextUnvisitedSuccessor == null) {
						get();
					}
					
					return nextUnvisitedSuccessor != null;
				}
				
				//Iterator<ProductState> succs;
				private void get() {
					Iterator<ProductState> succs = getSuccessors();
					if (! succs.hasNext()) {
						if (maybeungeneratedsuccessors) {
							calculateSuccessors(modelstate, true);
							succs = getSuccessors();
						}
					} else {
						
						while (succs.hasNext()) {
							ProductState s = succs.next();
							if (map.get(s.getNum()) == false) {
								nextUnvisitedSuccessor = s;
								break;
							}
						}
					}
					
				}
				
			};
		}


		
		/**
		 * Has the model state associated with this product state been fully explored?
		 * @return
		 */
		public boolean modelIsDone() {
			if (hasmodelstate) {
				return m.getState(modelstate).done();
			} else {
				return true;
			}
		}
			
		/**
		 * Getter for the unique number of this state.
		 * @return
		 */
		public int getNum() {
			return statenum;
		}
		
		/**
		 * Getter for the Buchi State.
		 * @return
		 */
		public int getBuchiState() {
			return buchistate;
		}
		
		/**
		 * Getter for the model state.
		 * @return
		 */
		public int getModelState() {
			return modelstate;
		}
		
		/**
		 * Does this tuple contain a model state?
		 * @return
		 */
		public boolean hasModelState() {
			return hasmodelstate;
		}
		
		/**
		 * Rather odd implementation of equality to account for that fact we want a tuple with no model state to match all
		 * tuples with the same buchi state when were are searching for accepting paths.
		 */
		public boolean equals(Object o) {
			// System.err.println("calling equals");
			if (o instanceof ProductState) {
				ProductState t = (ProductState) o;
				return hashCode() == t.hashCode();
			}
			
			return false;
		}
		
		/**
		 * The hash code is the state number.
		 */
		public int hashCode() {
			return statenum;
		}
		
		/*
		 * 	
		 */
		public boolean equals(ProductState s) {
			return(hashCode() == s.hashCode());
		}
		
		/**
		 * Is this an accepting state?
		 * @return
		 */
		public boolean isAccepting() {
			if (lowerLogLevelThan(Level.FINE)) {
				log.fine("Accepting untils: " + acceptinginuntils);
			}
			return ((acceptinginuntils.contains(0) && until == 0) || acceptinginuntils.contains(-1));
		}
				
		/**
		 * Calculate the successors of this product state, assuming the next state in the model is modelnum and we
		 * are (or are not) in a situation where the successors my have ungenerated successors in the existing model
		 * - i.e. we are investigating a loop in the program model or we've reached the end of a path in the program model.
		 * @param modelnum
		 * @param poss_nextBuchi
		 * @param firstinpath
		 * @return
		 */
		public boolean calculateSuccessors(int modelnum, boolean ungenerated_successors) {
			boolean arenewstates = false;

			 /**
			  * If there are no buchi states that can be reached from this state to model state modelnum
			  * then there are no successors.
			  */
			 List<BuchiState> poss_nextBuchi = b.possibleNextStates(buchistate);
			 if (poss_nextBuchi == null) {
				 return false;
			 } else {
				 if (lowerLogLevelThan(Level.FINER)) {
					 log.finer("poss_nextBuchi is:" + poss_nextBuchi.toString());
				 }
			 }
			 
			 /**
			  * Increment the until count if this state is accepting in the current until.
			  */
			 int newuntil = until;
			 if (lowerLogLevelThan(Level.FINE)) {
				 log.fine(acceptinginuntils.toString());
			 }
			 if (acceptinginuntils.contains(until)) {
				 if (lowerLogLevelThan(Level.FINE)) {
					 log.fine("Number of Untils: " + (b.number_of_untils()));
				 }
				 if (until == b.number_of_untils()) {
					 newuntil = 0;
				 } else {
					 newuntil++;
				 }
			 }

			 /**
			  * Create an index new model states as appropriate.
			  */
			 for (BuchiState s1: poss_nextBuchi) {
				 if (s1.labeledWith(modelnum)) {
					 Map<Integer, Integer> indexedbyuntil = new HashMap<Integer, Integer>();
					 Integer buchi_number = s1.getNumber();
					 arenewstates = true;
					 if (lowerLogLevelThan(Level.FINE)) {
						 log.fine("Adding new successors to " + this + ": ");
					 }
					 if (existence.containsKey(modelnum)) {
						 Map<Integer, Map<Integer, Integer>> indexedbybuchi = existence.get(modelnum);
						 if (indexedbybuchi.containsKey(buchi_number)) {
							 indexedbyuntil = indexedbybuchi.get(buchi_number);
							 if (indexedbyuntil.containsKey(newuntil)) {
								 if (lowerLogLevelThan(Level.FINE)) {
									 log.fine("     " + productbyNumber.get(indexedbyuntil.get(newuntil)));
								 }

								 if (! statesbyIncoming.get(statenum).contains(productbyNumber.get(indexedbyuntil.get(newuntil)))) {
									 statesbyIncoming.get(statenum).add(productbyNumber.get(indexedbyuntil.get(newuntil)));
								 }
								 break;
							 } 
						 } else {
							 indexedbybuchi.put(buchi_number, indexedbyuntil);
						 }
					 } else {
						 Map<Integer, Map<Integer, Integer>> indexedbybuchi = new HashMap<Integer, Map<Integer, Integer>>();
						 indexedbybuchi.put(buchi_number, indexedbyuntil);
						 existence.put(modelnum, indexedbybuchi);
					 }

					 ProductState newps = new ProductState(buchi_number, modelnum, newuntil);
					 if (ungenerated_successors) {
						 newps.setUngeneratedSuccessors();
					 }

					 if (lowerLogLevelThan(Level.FINE)) {
						 log.fine("     " + newps);
					 }

					 int newstatenum = newps.getNum();
					 productbyNumber.put(newstatenum, newps);
					 statesbyIncoming.get(statenum).add(newps);
					 if (lowerLogLevelThan(Level.FINE)) {
						 log.fine("States by incoming for " + statenum + " is " + statesbyIncoming.get(statenum));
					 }
					 
					 indexedbyuntil.put(newuntil, newstatenum); 
						 
				 }
			 } 
			 
			 return arenewstates;

		}		
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			String s = "<";
			if (!hasmodelstate) {
				s += "null, " + buchistate + ", " + until + ">";
			} else {
				s+= modelstate + ", " + buchistate + ", " + until + ">";
			}
			return s;
		}
				
		public String toPrettyString() {
			String s = "[MS: ";
			if (!hasmodelstate) {
				s += "null, BS: " + buchistate + ", UN: " + until + "]";
			} else {
				s+= modelstate + ", BS: " + buchistate + ", UN: " + until + "]";
			}
			return s;
		}

	}
	
	public String print_product() {
		String s = "";
		for (Map.Entry<Integer, ProductState> pair : productbyNumber.entrySet()) {
			s += pair.getKey().toString() + " " + pair.getValue().toString() + "\n";
			
		}
		s += "Indexed by Incoming:\n";
		for (Map.Entry<Integer, HashSet<ProductState>> pair: statesbyIncoming.entrySet()) {
			s += pair.getKey() + ":[";
			for (ProductState p: pair.getValue()) {
				s += p.toString();
				s += ", ";
			}
			s += "]\n";
		}
		return s;
		
	}
	
	public BuchiAutomaton getBuchi() {
		return b;
	}
}
