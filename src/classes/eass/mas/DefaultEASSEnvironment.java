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

//import gov.nasa.jpf.jvm.Verify;

import ail.util.AILConfig;
import ail.util.AILexception;
import ail.mas.DefaultEnvironment;
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
import ail.syntax.SendAction;
import eass.semantics.EASSAgent;

import ajpf.MCAPLJobber;
import ajpf.PerceptListener;
import ajpf.util.VerifyMap;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifySet;

/**
 * Default environment class for EASS project.  Sets up socket servers and generic actions.
 * @author louiseadennis
 *
 */
public class DefaultEASSEnvironment extends DefaultEnvironment implements EASSEnv {
	/**
	 * Tracking of input predicates.
	 */
	HashMap<String, Literal> values = new HashMap<String, Literal>();
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
	private String logname = "eass.mas.DefaultEASSEnvironment";
	
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
	
/*	public void setVersion(int v) {
		version = v;
	}
	
	public int getVersion() {
		return version;
	} */
		
	
	
	
	
	public void do_job() {			
		eachrun();
		
		// Really????
		notifyPerceptListeners();

	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Overridable function.
	 *
	 */
	public void eachrun() {
		AJPFLogger.finer(logname, this.toString());
	}
	
	public void printvalues(Literal pred) {
	
	}

	
	public void addUniquePercept(String s, Literal  pred) {
		if (values.containsKey(s.toLowerCase())) {
			removePercept(values.get(s.toLowerCase()));
			// System.err.println("removed old value");
		}

		values.put(s.toLowerCase(), pred);
		addPercept(pred);		
	}
	
	
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
    		printed = true;
    	} else {
     		 u = super.executeAction(agName, act);
    		 printed = true;
    	}
	   
	   if (!printed) {
		   AJPFLogger.info(logname, agName + " done " + printAction(act));
	   }

	     
	   return u;
	  }
	  
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#addPercept(ail.syntax.Literal)
	 */
	public void addPercept(Literal per) {
		AJPFLogger.finer(logname, "adding + " + per.toString());
			// System.err.println("adding got flag");
			if (per != null) {
				if (! percepts.contains(per)) {
					percepts.add(per);
					//Collections.sort(percepts);
					uptodateAgs.clear();
				}
			}
		notifyPerceptListeners();
		AJPFLogger.finer(logname, this.toString());
	}
		
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#removePercept(ail.syntax.Literal)
	 */
	public boolean removePercept(Literal per) {
		// System.err.println("removing + " + per);
		boolean b = false;
			// System.err.println("removing got flag");
			if (per != null) {
				uptodateAgs.clear();
				b =  percepts.remove(per);
				// System.err.println("a");
				// System.err.println("d");
				// return b;
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
		}
	}

		
	/**
	 * Complicated by the separation of abstraction and reasoning engines.
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		// check whether this agent needs the current version of perception
//		System.err.println(agName + " getting percepts ");
		Set<Predicate> p = new TreeSet<Predicate>();
//			System.err.println(agName + " has flag");
//			int size = 0;
			List<Literal> agl = agSharedBeliefs.get(agName);
//			if (agl != null) {
//				size += agl.size();
//			}
//			List<Literal> p = new ArrayList<Literal>(size);
			// System.err.println(agName + "accessed shared beliefs");
			//If this is to update an agent rather than looking for model checking purposes
			if (update) {
				if (uptodateAgs.contains(agName)) {
//					System.err.println("returning null");
					AJPFLogger.finer("eass.mas.DefaultEASSEnvironment", "Shared beliefs returning null to " + agName);
					return null;
				}
				
				// if its the abstraction engine (NB.  this will add agName to up-to-date ags
				if (abstractionenginelist.contains(agName)) {
					//System.err.println("about to super get percepts");
					Set<Predicate> ps = super.getPercepts(agName, update);
					// System.err.println("super successful");
					if (ps != null) {
						p.addAll(ps);
					//	System.err.println(ps);
					}
				} else {

				uptodateAgs.add(agName);
				}
			}
						
		    				
			if (agl != null) { // add agent personal perception
				p.addAll(agl);
			}
	    			
			//return p;
		 		
			// System.err.println(p);
//		System.err.println(agName + " releasing flag");
		return p;
				
	}
		   
	/** Adds a perception for a specific agent */
	public void addSharedBelief(String agName, Literal per) {
		// System.err.println(agName + " going for flag with " + per);
			// System.err.println(agName + " has flag");
			if (per != null && agName != null) {
				ArrayList<Literal> agl = agSharedBeliefs.get(agName);
				if (agl == null) {
					agl = new ArrayList<Literal>();
					uptodateAgs.remove(agName);
					agl.add(per);
					agSharedBeliefs.put( agName, agl);
				} else {
					if (! agl.contains(per)) {
						uptodateAgs.remove(agName);
						agl.add(per);
						Collections.sort(agl);
					}
				}
				
				String partneragent = abstractionengines.get(agName);
				ArrayList<Literal> agl2 = agSharedBeliefs.get(partneragent);
				if (partneragent == null) {
					
				} else {
				if (agl2 == null) {
					agl2 = new ArrayList<Literal>();
					uptodateAgs.remove(partneragent);
					agl2.add(per);
					agSharedBeliefs.put(partneragent, agl2);
				} else {
					if (! agl2.contains(per)) {
						uptodateAgs.remove(partneragent);
						agl2.add(per);
						Collections.sort(agl2);
					}
				}
				}
		}
		// System.err.println(this);
		//System.err.println(agName + " releasing flag");
		
					
		notifySharedListeners(agName);
	}
			
	/** Removes a perception for one agent */
	public boolean removeSharedBelief(String agName, Literal per) {
		boolean result = true;
		// System.err.println(agName + " removing " + per);
		boolean resulttoreturn = false;
		// ArrayList<String> tonotify = new ArrayList<String>();
			// System.err.println(agName + " has flag");
			if (per != null && agName != null) {
				ArrayList<Literal> agl = agSharedBeliefs.get(agName);
				ArrayList<Literal> aglr = new ArrayList<Literal>();
				if (agl != null && ! agl.isEmpty()) {
					uptodateAgs.remove(agName);
					try {
						for (Literal l: agl) {
							if (l.equals(per)) {
								// notifyListeners(agName);
								//result = agl.remove(l);
								aglr.add(l);
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
							// System.err.println("i");
							if (result) {
								// System.err.println(agName + "agl2 remove");
								resulttoreturn = agl2.remove(l);
								break;
							} else {
								// System.err.println("g");
								agl2.remove(l);
								// System.err.println(agName + "return false 1");
								resulttoreturn = false;
								break;
							}
						}
					}
				}
		}
		// System.err.println("d");
		notifySharedListeners(agName);
		// System.err.println(agName + " return " + resulttoreturn);
		return resulttoreturn;
	}

	/**
	 * Notify the relevant listeners that the perceptions have changed.
	 *
	 */
	public void notifyPerceptListeners() {
		// System.err.println("notifying percept listeners");
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
		// System.err.println(agName + " removing shared");
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

					Collections.sort(sharedbeliefs);
				
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

					Collections.sort(psharedbeliefs);
				
				// notifySharedListeners(agName);
					return b;
				}
			} 
					
		// System.err.println(agName + " releasing flag");
		notifySharedListeners(agName);
		return b;
	}
		
	
	public void stopRunning() {
		running = false;
	}
	
	public void setVersion(int i) {
		version = i;
	}
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


