// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
//
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
//
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.mas;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedList;
import java.lang.Thread;

import ail.util.AILConfig;
import ail.util.AILexception;
import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.util.AILSocketServer;
import ail.semantics.AILAgent;
import ail.syntax.Unifier;
import ail.syntax.Message;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.StringTerm;
import ail.syntax.Term;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Predicate;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.StringTermImpl;
import ail.syntax.VarTerm;
import eass.semantics.EASSAgent;
import ajpf.MCAPLJobber;
import ajpf.util.VerifyMap;
import ajpf.util.AJPFLogger;
import ajpf.MCAPLScheduler;

/**
 * Default environment class for EASS project.  Sets up socket servers and generic actions.
 * @author louiseadennis
 *
 */
public class DefaultEASSEnvironment extends DefaultEnvironment implements EASSEnv {
	/**
	 * Tracking of input predicates.
	 */
	protected HashMap<String, Predicate> values = new HashMap<String, Predicate>();
	/**
	 * Tracking of input predicates.
	 */
	HashMap<String, HashMap<String, Predicate>> agvalues = new HashMap<String,HashMap<String, Predicate>>();
	/**
	 * Used to keep track of whether environment thread should continue operating.
	 */
	protected boolean done = false;

	/**
	 * Beliefs shared by all agents.  May need to be modifed for multi-agent setting.
	 */
	private Map<String,ArrayList<Literal>>  agSharedBeliefs = new VerifyMap<String, ArrayList<Literal>>();
	/**
	 * List of abstraction engines.
	 */
	protected List<String> abstractionenginelist = new ArrayList<String>();
	protected Map<String, String> abstractionengines = new HashMap<String, String>();
	private String name = "Default EASS Environment";
	private static String logname = "eass.mas.DefaultEASSEnvironment";

	protected int control = 0;
	int misccounter = 0;
	boolean running = true;
	int version = 1;

	/**
	 * Constructor - creates sockets.
	 *
	 */
	public DefaultEASSEnvironment() {
		super();
	}

	public static void scheduler_setup(EASSEnv env, MCAPLScheduler s) {
		s.addJobber(env);
		env.setScheduler(s);
		env.addPerceptListener(s);
	}



	public void do_job() {
		eachrun();
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is intended to be overriden by sub-classes which want something
	 * specific to happen in each cycle of the environment.
	 */
	public void eachrun() {}


	/**
	 * Add a percept to this environment that is supposed to be unique - i.e.,
	 * the predicate functor is unique.
	 * @param s
	 * @param pred
	 */
	public void addUniquePercept(String s, Predicate pred) {
		if (values.containsKey(s.toLowerCase())) {
			removePercept(values.get(s.toLowerCase()));
		}

		values.put(s.toLowerCase(), pred);
		addPercept(pred);
	}

	/**
	 * Add a percept to this environment that is supposed to be unique - i.e.,
	 * the predicate functor is unique.
	 * @param agName
	 * @param s
	 * @param pred
	 */
	public void addUniquePercept(String agName, String s, Predicate pred) {
		HashMap<String, Predicate> vs = agvalues.get(agName);
		if (vs != null) {
			if (vs.containsKey(s.toLowerCase())) {
				removePercept(agName, vs.get(s.toLowerCase()));
			}

			vs.put(s.toLowerCase(), pred);
		}

		addPercept(agName, pred);
	}

	/**
	 * This environment has finished.
	 * @param b
	 */
	public void setDone(boolean b) {
		done = b;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {

		Unifier u = new Unifier();
		boolean printed = false;

	   if (act.getFunctor().equals("assert_shared")) {
		   addSharedBelief(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
		   printed = true;
		   if (AJPFLogger.ltFine(logname)) {
			   AJPFLogger.fine(logname, agName + " done " + act);
		   }
	   } else  if (act.getFunctor().equals("remove_shared")) {
		   removeSharedBelief(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
		   printed = true;
		   if (AJPFLogger.ltFine(logname)) {
			   AJPFLogger.fine(logname, agName + " done " + act);
		   }
	   } else  if (act.getFunctor().equals("remove_shared_unifies")) {
		   removeUnifiesShared(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
	   } else if (act.getFunctor().equals("perf")) {
		   Predicate run = (Predicate) act.getTerm(0);
		   Message m = new Message(2, agName, "abstraction", run);
		   String abs = abstractionengines.get(agName);
		   addMessage(abs, m);
		   if (AJPFLogger.ltFine(logname)) {
			   AJPFLogger.fine(logname, agName + " done PERF " + act);
		   }
	   } else if (act.getFunctor().equals("query")) {
		   Predicate query = (Predicate) act.getTerm(0);
		   Message m = new Message(2, agName, "abstraction", query);
		   String abs = abstractionengines.get(agName);
		   addMessage(abs, m);
	   }  else	if (act.getFunctor().equals("append_string_pred")) {
    		StringTerm x = (StringTerm) act.getTerm(0);
    		String y =  act.getTerm(1).toString();
    		String append = x.getString() + y;
    		VarTerm result = (VarTerm) act.getTerm(2);
    		StringTermImpl z = new StringTermImpl(append);
    		u.unifies(result, z);
    	}

     	u = super.executeAction(agName, act);

	   return u;
	  }


	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#addPercept(ail.syntax.Literal)
	 */
	public void addPercept(Literal per) {
		if (AJPFLogger.ltFiner(logname)) {
			AJPFLogger.finer(logname, "adding + " + per.toString());
		}
		if (per != null) {
			if (! percepts.contains(per)) {
				percepts.add(per);
				uptodateAgs.clear();
			}
		}
		notifyPerceptListeners();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#removePercept(ail.syntax.Literal)
	 */
	public boolean removePercept(Literal per) {
		boolean b = false;
		if (per != null) {
			uptodateAgs.clear();
			b =  percepts.remove(per);
		}

		notifyPerceptListeners();

		return b;
	}


	/**
	 * Add and abstraction engine.
	 * @param s
	 */
	public void addAbstractionEngine(String s, String foragent) {
		abstractionengines.put(s, foragent);
		abstractionengines.put(foragent, s);
		abstractionenginelist.add(s);
	}

	/**
	 * Add an agent to the list the environment knows about.
	 * @param a
	 */
	public void addAgent(AILAgent a) {
		super.addAgent(a);
		EASSAgent ea = (EASSAgent) a;
		if (ea.isAbstractionEngine()) {
			addAbstractionEngine(ea.getAgName(), ea.getEngineFor());
			HashMap<String, Predicate> input_values = new HashMap<String, Predicate>();
			agvalues.put(ea.getAgName(), input_values);
		}
	}


	/**
	 * Complicated by the separation of abstraction and reasoning engines.
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		Set<Predicate> p = new TreeSet<Predicate>();
		List<Literal> agl = agSharedBeliefs.get(agName);
		//If this is to update an agent rather than looking for model checking purposes
			if (update) {
				if (uptodateAgs.contains(agName)) {
					if (AJPFLogger.ltFiner(logname)) {
						AJPFLogger.finer("eass.mas.DefaultEASSEnvironment", "Shared beliefs returning null to " + agName);
					}
					return null;
				}
			}

			// if its the abstraction engine (NB.  this will add agName to up-to-date ags
			if (abstractionenginelist.contains(agName)) {
				Set<Predicate> ps = super.getPercepts(agName, update);
				if (ps != null) {
					p.addAll(ps);
				}
			} else {
				if (update) {
					uptodateAgs.add(agName);
				}
			}


			if (agl != null) { // add agent personal perception
				p.addAll(agl);
			}

		return p;

	}

	/** Adds a perception for a specific agent */
	public void addSharedBelief(String agName, Literal per) {
			if (per != null && agName != null) {
				ArrayList<Literal> agl = agSharedBeliefs.get(agName);
				if (agl == null) {
					agl = new ArrayList<Literal>();
					uptodateAgs.remove(agName);
					Literal.add_literal_to_sorted(per, agl);
					agSharedBeliefs.put( agName, agl);
				} else {
					if (! agl.contains(per)) {
						uptodateAgs.remove(agName);
						Literal.add_literal_to_sorted(per, agl);
					}
				}

				String partneragent = abstractionengines.get(agName);
				ArrayList<Literal> agl2 = agSharedBeliefs.get(partneragent);
				if (partneragent == null) {

				} else {
				if (agl2 == null) {
					agl2 = new ArrayList<Literal>();
					uptodateAgs.remove(partneragent);
					Literal.add_literal_to_sorted(per, agl2);
					agSharedBeliefs.put(partneragent, agl2);
				} else {
					if (! agl2.contains(per)) {
						uptodateAgs.remove(partneragent);
						Literal.add_literal_to_sorted(per, agl2);
		
					}
				}
				}
		}

		notifySharedListeners(agName);
	}

	/** Removes a perception for one agent */
	public boolean removeSharedBelief(String agName, Literal per) {
		boolean result = true;
		boolean resulttoreturn = false;
		if (per != null && agName != null) {
			ArrayList<Literal> agl = agSharedBeliefs.get(agName);
			ArrayList<Literal> aglr = new ArrayList<Literal>();
			if (agl != null && ! agl.isEmpty()) {
				uptodateAgs.remove(agName);
				try {
					for (Literal l: agl) {
						if (l.equals(per)) {
							Literal.add_literal_to_sorted(l, aglr);
						}
					}
					result = agl.removeAll(aglr);
				} catch (Exception e) {
					System.out.println("PROBLEM" + agl);
				}
			}

			String partneragent = abstractionengines.get(agName);
			List<Literal> agl2 = agSharedBeliefs.get(partneragent);
			if (agl2 != null && !agl2.isEmpty()) {
				uptodateAgs.remove(partneragent);
				for (Literal l: agl2) {
					if (l.equals(per)) {
						if (result) {
							resulttoreturn = agl2.remove(l);
							break;
						} else {
							agl2.remove(l);
							resulttoreturn = false;
							break;
						}
					}
				}
			}
		}
		notifySharedListeners(agName);
		return resulttoreturn;
	}

	/**
	 * Notify the relevant listeners that the perceptions have changed.
	 *
	 */
	public void notifyPerceptListeners() {
		for (String s: agentmap.keySet()) {
			if (abstractionenginelist.contains(s)) {
				super.notifyListeners(s);
			}
		}

		notifyListeners("scheduler");
	}

	/**
	 * Notify all listeners about changes of shared beliefes.
	 *
	 */
	public void notifySharedListeners(String agName) {
		super.notifyListeners(agName);
		super.notifyListeners(abstractionengines.get(agName));
	}

	/**
	 * Remove all beliefs that unify with the percept - ?should be the default.
	 * @param per
	 * @return
	 */
	public boolean removeUnifiesShared(String agName, Literal per) {
		boolean b = false;
		Literal rper = null;
		if (per != null) {
			uptodateAgs.remove(agName);
			List<Literal> sharedbeliefs = agSharedBeliefs.get(agName);
			if (sharedbeliefs != null) {
				for (Literal p: sharedbeliefs) {
					if (p.unifies(per, new Unifier())) {
						rper = p;
					}
				}


				if (rper != null) {
					b = sharedbeliefs.remove(rper);
				}

				// Collections.sort(sharedbeliefs);

				String partneragent = abstractionengines.get(agName);
				uptodateAgs.remove(partneragent);
				List<Literal> psharedbeliefs = agSharedBeliefs.get(agName);
				for (Literal p: psharedbeliefs) {
					if (p.unifies(per, new Unifier())) {
						rper = p;
					}
				}

				if (rper != null) {
					b = psharedbeliefs.remove(rper);
				}

				// Collections.sort(psharedbeliefs);

				return b;
			}
		}

		notifySharedListeners(agName);
		return b;
	}


	/**
	 * Stop the environment running.
	 */
	public void stopRunning() {
		running = false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLJobber j) {
		return j.getName().compareTo(getName());
	}

	/**
	 * Actions are called by an agent called abstract_rname, but the actual agent's name
	 * May sometimes be needed.
	 * @param name
	 * @return
	 */
	public String rationalName(String name) {
		int index = 12;
		if (name.length() > index) {
			return name.substring(index);
		} else {
			return name;
		}
	}


}
