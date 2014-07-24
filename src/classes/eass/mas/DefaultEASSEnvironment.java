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

/**
 * Default environment class for EASS project.  Sets up socket servers and generic actions.
 * @author louiseadennis
 *
 */
public class DefaultEASSEnvironment extends DefaultEnvironment implements MCAPLJobber {
	/**
	 * Socket that connects to the Physical Engine.
	 */
	protected AILSocketServer socketserver;
	/**
	 * Socket that connects to the Continuous Engine.
	 */
	protected AILSocketServer socketserver2;
	/**
	 * Tracking of input predicates.
	 */
	HashMap<String, Literal> values = new HashMap<String, Literal>();
	/**
	 * Are we actually connected to MatLab?  Useful for debugging.
	 */
	protected boolean connectedtomatlab = true;
	/**
	 * Used to keep track of whether environment thread should continue operating.
	 */
	protected boolean done = false;
	/**
	 * A separate thread for processing calculations and waiting on their answers.
	 */
	protected CalculationThread calculator = new CalculationThread();
	/**
	 * A separate thread for processing waiting.
	 */
	protected WaitingThread waiter = new WaitingThread();

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
			
	/**
	 * Initialise the environment - e.g., get connections to other systems.
	 */
	public void initialise() {
		if (connectedtomatlab) {
			AJPFLogger.info("eass.mas", "Waiting Connections");
			socketserver = new AILSocketServer();
			AJPFLogger.info("eass.mas", "Connected to Physical Engine");
			AJPFLogger.info("eass.mas", "Waiting Connection to Continuous Engine");
			socketserver2 = new AILSocketServer(6254);
			AJPFLogger.info("eass.mas", "Connected to Continuous Engine");
		}
		
		if (mThreads()) {
			startcalculator();
			waiter.start();
		}
		
	}
	
	/**
	 * Are we connecting to  a matlab environment? and do we need various
	 * extra threads to manage this?
	 * @return
	 */
	public boolean mThreads() {
		return true;
	}
	
	
	/**
	 * Starts calculator thread.
	 *
	 */
	public void startcalculator() {
		calculator.start();
	}
	
	/**
	 * Stops calculator thread.
	 *
	 */
	public void stopcalculator() {
		calculator.terminate();
	}
	
	
	public void do_job() {
		if (connectedtomatlab) {
			if (socketserver.allok()) {
				readin_predicates();
			}	else {
				AJPFLogger.warning(logname, "something wrong with socket server");
			}
		}
			
		eachrun();
		
		// Really????
		notifyPerceptListeners();

	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#finalize()
	 */
	public void finalize() {
		done = true;
		calculator.terminate();
		waiter.terminate();
		calculator.calculate("env", new Action("done"));
		waiter.wait("env", new Action("done"));
	}
	
	/**
	 * This method is intended to be overriden by sub-classes which want something
	 * specific to happen in each cycle of the environment.
	 */
	public void eachrun() {}
	
	/**
	 * This method can be overriden during debugging to print out specific information.
	 * @param pred
	 */
	public void printvalues(Literal pred) {}
	
	/**
	 * What to do if execution a run command and not connected to MatLab.
	 * @param agname
	 * @param act
	 */
	public void noconnection_run(String agname, Action act) {
		System.err.println("No Matlab Connection: " + act.toString());
	}
	
	/**
	 * What to do if executing a calculate command and not connect to MatLab.
	 * @param predicate
	 * @param val
	 * @param u
	 * @return
	 */
	public Literal noconnection_calc(Predicate predicate, VarTerm val, Unifier u) {
		try {
			System.err.println("calculated");
		} catch (Exception e) {
			System.err.println("didn't sleep");
		}
		Literal result = new Literal("result");
		result.addTerm(predicate);
		result.addTerm(new Predicate("result"));
		return result;
	}

	/**
	 * Read in data from Matlab and convert to predicates.
	 * @param s
	 */
	private void readin_predicates() {
		String s = socketserver.readLine();
		while (!s.equals("ENDDATA")) {
			s = socketserver.readLine();
			
			if (!s.equals("ENDDATA")) {
				// Convert everything to lower case otherwise AIL will get confused 
				// and start treating things as variables.
				Literal pred = new Literal(s.toLowerCase());
			
				Integer size = Integer.parseInt(socketserver.readLine());
				
				ArrayList<Term> terms = new ArrayList<Term>();
					
				for (int i= 0; i < size; i++) {
					String s1 = socketserver.readLine();
					try {
						NumberTermImpl n = new NumberTermImpl(s1);
						terms.add(n);
					} catch (NumberFormatException ne) {
						terms.add(new Predicate(s1));
					}
				}
				
				pred.addTerms(terms);
				if (AJPFLogger.ltFiner(logname)) {
					AJPFLogger.finer(logname, pred.toString());
				}

				printvalues(pred);
				
				if (control == 0) {
					addUniquePercept(s, pred);
				} else {
					if (AJPFLogger.ltFiner(logname)) {
						AJPFLogger.finer(logname, "not adding percepts");
					}
				}
				s = socketserver.readLine();
			} else {
			}
		}
	}
	
	/**
	 * Add a percept to this environment that is supposed to be unique - i.e.,
	 * the predicate functor is unique.
	 * @param s
	 * @param pred
	 */
	public void addUniquePercept(String s, Literal  pred) {
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
	public void addUniquePercept(String agName, String s, Literal  pred) {
		if (values.containsKey(s.toLowerCase())) {
			removePercept(agName, values.get(s.toLowerCase()));
		}

		values.put(s.toLowerCase(), pred);
		addPercept(agName, pred);		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	public boolean done() {
		if (done) {
			calculator.terminate();
			waiter.terminate();
			return true;
		}
		return false;
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
	   } else  if (act.getFunctor().equals("remove_shared")) {
		   removeSharedBelief(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
		   printed = true;
	   } else  if (act.getFunctor().equals("remove_shared_unifies")) {
		   removeUnifiesShared(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
	   } else if (act.getFunctor().equals("calculate")) {
		   calculator.calculate(agName, act);
	   } else if (act.getFunctor().equals("wait")) {
		   waiter.wait(agName, act);
	   } else if (act.getFunctor().equals("run")) {
		   if (connectedtomatlab) {
			   int agentnum = Integer.parseInt(((String) agName).substring(14));
			   Predicate predlist = (Predicate) act.getTerm(0);
			   Predicate predargs = (Predicate) act.getTerm(1);
			   int num_args = predargs.getTermsSize();
			   String num_arg_s = "" + num_args;
			   int num_name_comps = predlist.getTermsSize();
			   String predname = "";
			   for (int i=0; i<num_name_comps; i++) {
				   // Lots of extra work to get the string correct.
				   Term nb = predlist.getTerm(i);
				   String s = nb.toString();
				   if (nb instanceof VarTerm) {
					   VarTerm v = (VarTerm) nb;
					   nb = v.getValue();
				   }
				   if (nb instanceof NumberTerm) {
					   NumberTerm num = (NumberTerm) nb;
					   Double number = num.solve();
					   int num_as_int = number.intValue();
					   s = ((Integer) num_as_int).toString();
				   }
				   if (nb instanceof StringTermImpl) {
					   StringTermImpl string = (StringTermImpl) nb;
					   s = string.getString();
				   }
				   predname += s;
			   }

			   	socketserver.write("RUNTASK");
			   	if (version == 2) {
			   		socketserver.write(((Integer) agentnum).toString());
			   	}
			   	socketserver.write(predname);
			   	socketserver.write(num_arg_s);
			   	for (int i=0; i < num_args; i++) {
			   		Term arg = predargs.getTerm(i);
			   		String s = arg.toString();
			   		if (arg instanceof VarTerm) {
			   			VarTerm v = (VarTerm) arg;
			   			arg = v.getValue();
			   		}
			   		if (arg instanceof NumberTerm) {
			   			NumberTerm num = (NumberTerm) arg;
			   			Double number = num.solve();
			   			int num_as_int = number.intValue();
			   			s = ((Integer) num_as_int).toString();
			   		}
			   		if (arg instanceof StringTermImpl) {
			   			StringTermImpl string = (StringTermImpl) arg;
			   			s = string.getString();
			   		}
				   socketserver.write(s);	
			   	}
			   socketserver.write("0");
		   } else {
			   noconnection_run(agName, act);
		   }
	   } else if (act.getFunctor().equals("run_as_is")) {
		   if (connectedtomatlab) {
			   double anum = ((NumberTermImpl) act.getTerm(0)).solve();
			   int agentnum = ((Double) anum).intValue();
			   Predicate predlist = (Predicate) act.getTerm(1);
			   Predicate predargs = (Predicate) act.getTerm(2);
			   int num_args = predargs.getTermsSize();
			   String num_arg_s = "" + num_args;
			   int num_name_comps = predlist.getTermsSize();
			   String predname = "";
			   for (int i=0; i<num_name_comps; i++) {
				   // Lots of extra work to get the string correct.
				   Term nb = predlist.getTerm(i);
				   String s = nb.toString();
				   if (nb instanceof VarTerm) {
					   VarTerm v = (VarTerm) nb;
					   nb = v.getValue();
				   }
				   if (nb instanceof NumberTerm) {
					   NumberTerm num = (NumberTerm) nb;
					   Double number = num.solve();
					   int num_as_int = number.intValue();
					   s = ((Integer) num_as_int).toString();
				   }
				   if (nb instanceof StringTermImpl) {
					   StringTermImpl string = (StringTermImpl) nb;
					   s = string.getString();
				   }
				   predname += s;
			   }

			   	socketserver.write("RUNTASK");
			   	if (version == 2) {
			   		socketserver.write(((Integer) agentnum).toString());
			   	}
			   	socketserver.write(predname);
			   	socketserver.write(num_arg_s);
			   	for (int i=0; i < num_args; i++) {
			   		Term arg = predargs.getTerm(i);
			   		String s = arg.toString();
			   		if (arg instanceof VarTerm) {
			   			VarTerm v = (VarTerm) arg;
			   			arg = v.getValue();
			   		}
			   		if (arg instanceof NumberTerm) {
			   			NumberTerm num = (NumberTerm) arg;
			   			Double number = num.solve();
			   			int num_as_int = number.intValue();
			   			s = ((Integer) num_as_int).toString();
			   		}
			   		if (arg instanceof StringTermImpl) {
			   			StringTermImpl string = (StringTermImpl) arg;
			   			s = string.getString();
			   		}
				   socketserver.write(s);	
			   	}
			   socketserver.write("0");
		   } else {
			   noconnection_run(agName, act);
		   }
	   } else if (act.getFunctor().equals("perf")) {
		   Predicate run = (Predicate) act.getTerm(0);
		   Message m = new Message(2, agName, "abstraction", run);
		   String abs = abstractionengines.get(agName);
		   addMessage(abs, m);
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
		   AJPFLogger.info("eass.mas.DefaultEASSEnvironment", agName + " done " + printAction(act));
	   }

	     
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
				
				// if its the abstraction engine (NB.  this will add agName to up-to-date ags
				if (abstractionenginelist.contains(agName)) {
					Set<Predicate> ps = super.getPercepts(agName, update);
					if (ps != null) {
						p.addAll(ps);
					}
				} else {

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
					
				return b;
			}
		} 

		notifySharedListeners(agName);
		return b;
	}
		
	/**
	 * Setter for connected to matlab.
	 * @param b
	 */
	protected void setConnected(boolean b) {
		connectedtomatlab = b;
	}
			
	/**
	 * A separate thread for managing calculations.  Uses a blocking queue so it only calls calculate when it 
	 * has a request for processing.
	 * @author louiseadennis
	 *
	 */
	private class CalculationThread extends Thread {
		private BlockingQueue<AgAct> pendingCalculations = new LinkedBlockingQueue<AgAct>();
		public boolean terminate = false;
				
		/*
		 * (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			if (AJPFLogger.ltFine(logname)) {
				AJPFLogger.fine(logname, "Starting up Calculator");
			}
			try {
				while (!terminate) {
					AgAct agact = pendingCalculations.take();
					Action act = agact.getAct();
					Literal r = new Literal("dummy");
					if (! act.getFunctor().equals("done")) {
						r = runCalculate(act);
					}
					String agName = agact.getAgName();
					if (! act.getFunctor().equals("done")) {
						addSharedBelief(agName, r);
					}
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
				
		/**
		 * When a calculation is requested, add it to the queue.
		 * @param act
		 */
		public void calculate(String AgName, Action act) {
			try {
				if (AJPFLogger.ltFine(logname)) {
					AJPFLogger.fine(logname, "calculating " + act);
				}
				pendingCalculations.put(new AgAct(AgName, act));
			} catch (Exception e) {
				System.err.println("failed to add calculation to queue");
			}
		}
				
		/**
		 * Stop the thread.
		 *
		 */
		public void terminate() {
			terminate = true;
		}
		

		/**
		 * When resources are available actually do the calculation.
		 * @param act
		 * @return
		 */
		protected Literal runCalculate(Action act) {
			Predicate predicate = (Predicate) act.getTerm(0);
			VarTerm val = (VarTerm) act.getTerm(1);
			Unifier u = new Unifier();
			if (connectedtomatlab) {
				int num_args = predicate.getTermsSize();
				String num_arg_s = "" + num_args;
				if (AJPFLogger.ltFine(logname)) {
					AJPFLogger.fine(logname, "sending calculation to matlab");
				}
				socketserver2.write("CALLMFILE");
				socketserver2.write(predicate.getFunctor());
				socketserver2.write(num_arg_s);
				for (int i = 0; i < num_args; i++) {
					socketserver2.write(predicate.getTerm(i).toString());
				}
				socketserver2.write("1");
				String value = socketserver2.readLine();
				if (value.startsWith("0") || value.startsWith("1") || value.startsWith("2")
						|| value.startsWith("3") || value.startsWith("4") || value.startsWith("5")
						|| value.startsWith("6") || value.startsWith("7") || value.startsWith("8")
						|| value.startsWith("9") 

						) {
				try {
					NumberTermImpl n = new NumberTermImpl(value);
					val.unifies(n, u);
				} catch (NumberFormatException ne) {
					val.unifies(new Predicate(value), u);
				}
				} else {
					val.unifies(new Predicate(value), u);
				}
				val.apply(u);
				Literal result = new Literal("result");
				result.addTerm(predicate);
				result.addTerm(val);
				return result;
			} else {
				Literal result = noconnection_calc(predicate, val, u);
				return result;
			}
		}
		
		private class AgAct {
			public String agname;
			public Action act;
			
			public AgAct(String ag, Action a) {
				agname = ag;
				act = a;
			}
			
			public String getAgName() {
				return agname;
			}
			
			public Action getAct() {
				return act;
			}
		}
	}

	/**
	 * A separate thread for managing calculations.  Uses a blocking queue so it only calls calculate when it 
	 * has a request for processing.
	 * @author louiseadennis
	 *
	 */
	private class WaitingThread extends Thread {
		private BlockingQueue<Action> pendingWaits = new LinkedBlockingQueue<Action>();
		private LinkedList<String> waitinitiators = new LinkedList<String>();
		public boolean terminate = false;
				
		/*
		 * (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			try {
				while (!terminate) {
					Action act = pendingWaits.take();
					Literal r = new Literal("dummy");
					if (! act.getFunctor().equals("done")) {
						r = runWait(act);
					}
					String agName = waitinitiators.poll();
					if (! act.getFunctor().equals("done")) {
						addSharedBelief(agName, r);
					}
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
				
		/**
		 * When a calculation is requested, add it to the queue.
		 * @param act
		 */
		public void wait(String agName, Action act) {
			try {
				pendingWaits.put(act);
				waitinitiators.offer(agName);
			} catch (Exception e) {
				System.err.println("failed to add wait to queue");
			}
		}
				
		/**
		 * Stop the thread.
		 *
		 */
		public void terminate() {
			terminate = true;
		}

		/**
		 * When resources are available actually do the calculation.
		 * @param act
		 * @return
		 */
		protected Literal runWait(Action act) {
			NumberTerm val = (NumberTerm) act.getTerm(0);
			Term waitkey = act.getTerm(1);
			double n = val.solve();
			try {
				sleep(((Double) n).intValue());
			} catch (Exception e) {
			}
				
			Literal waited = new Literal("waited");
			waited.addTerm(waitkey);
			return waited;
		}
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
		if (config.containsKey("connectedtomatlab")) {
			if (config.getProperty("connectedtomatlab").equals("false")) {
				connectedtomatlab = false;
			} else {
				connectedtomatlab = true;
			}
		}
	}
	
	/**
	 * This environement is not connected to MatLab.
	 */
	public void notConnectedToMatLab() {
		connectedtomatlab = false;
	}
	
	/**
	 * Is this environment connected to MatLab.
	 * @return
	 */
	public boolean connectedToMatLab() {
		return connectedtomatlab;
	}
	
}


