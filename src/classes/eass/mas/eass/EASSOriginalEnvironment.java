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

package eass.mas.eass;

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
import eass.mas.EASSEnv;
import eass.mas.DefaultEASSEnvironment;

import ajpf.MCAPLJobber;
import ajpf.PerceptListener;
import ajpf.util.VerifyMap;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifySet;

/**
 * Default environment class for EASS project.  Sets up socket servers and generic actions.  As originally developed for EASS Project.
 * @author louiseadennis
 *
 */
public class EASSOriginalEnvironment extends DefaultEASSEnvironment {
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
	// protected boolean done = false;
	/**
	 * A separate thread for processing calculations and waiting on their answers.
	 */
	protected CalculationThread calculator = new CalculationThread();
	/**
	 * A separate thread for processing waiting.
	 */
	protected WaitingThread waiter = new WaitingThread();

	protected int control = 0;
	int misccounter = 0;
	boolean running = true;
	int version = 1;

	/**
	 * Constructor - creates sockets.
	 *
	 */
	public EASSOriginalEnvironment() {
		super();
	}
	
/*	public void setVersion(int v) {
		version = v;
	}
	
	public int getVersion() {
		return version;
	} */
		
	
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
				// System.err.println("reading in predicates");
				readin_predicates();
				// System.err.println("finished reading in predicates");
			}	else {
				System.err.println("something wrong with socket server");
			}
		}
			
		super.do_job();
	}

	
	public void cleanup() {
		done = true;
		calculator.terminate();
		waiter.terminate();
		calculator.calculate("env", new Action("done"));
		waiter.wait("env", new Action("done"));
	}
	
	/**
	 * Overridable function.
	 *
	 */
	public void eachrun() {
		
	}
	
	public void printvalues(Literal pred) {
	
	}
	
	public void noconnection_run(String agname, Action act) {
		System.err.println("No Matlab Connection: " + act.toString());
	}
	
	public Literal noconnection_calc(Predicate predicate, VarTerm val, Unifier u) {
		try {
			// Simulate calculation time 
	//		sleep(100);
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
				// System.err.println("d " + size);
				
				ArrayList<Term> terms = new ArrayList<Term>();
					
				for (int i= 0; i < size; i++) {
					// System.err.println(i);
					String s1 = socketserver.readLine();
					try {
						NumberTermImpl n = new NumberTermImpl(s1);
						terms.add(n);
					} catch (NumberFormatException ne) {
						terms.add(new Predicate(s1));
					}
				}
				// System.err.println("out of for loop");
				
				pred.addTerms(terms);
				AJPFLogger.finer("eass.mas.DefaultEASSEnvironment", pred.toString());

				printvalues(pred);
				
				if (control == 0) {
					addUniquePercept(s, pred);
				} else {
					AJPFLogger.finer("eass.mas.DefaultEASSEnvironment", "not adding percepts");
				}
				// System.err.println("f");
				s = socketserver.readLine();
			} else {
				//socketserver.write("handshake " + misccounter);
				//System.out.println("shake " + misccounter);
				//misccounter++;
			}
		}
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   
		Unifier u = new Unifier();
		boolean printed = false;
		 
	   if (act.getFunctor().equals("calculate")) {
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
//			   	socketserver.write(predname);
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
			   		// System.err.println(s);
				   socketserver.write(s);	
			   	}
			   socketserver.write("0");
		   } else {
			   noconnection_run(agName, act);
		   }
	   } else if (act.getFunctor().equals("run_as_is")) {
		   if (connectedtomatlab) {
//			   int agentnum = Integer.parseInt(((String) agName).substring(14));
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
//			   	socketserver.write(predname);
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
			   		// System.err.println(s);
				   socketserver.write(s);	
			   	}
			   socketserver.write("0");
		   } else {
			   noconnection_run(agName, act);
		   }
	   } else {
     		 u = super.executeAction(agName, act);
    		 printed = true;
    	}
	   
	   if (!printed) {
		   AJPFLogger.info("eass.mas.EASSMatLabEnvironment", agName + " done " + printAction(act));
	   }

	     
	   return u;
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
//		private LinkedList<String> actinitiators = new LinkedList<String>();
		public boolean terminate = false;
				
		/*
		 * (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			AJPFLogger.fine("eass.mass.DefaultEnvironment", "Starting up Calculator");
			try {
				while (!terminate) {
					AgAct agact = pendingCalculations.take();
					Action act = agact.getAct();
					// Action act = pendingCalculations.take();
					Literal r = new Literal("dummy");
					if (! act.getFunctor().equals("done")) {
						r = runCalculate(act);
					}
					String agName = agact.getAgName();
					//String agName = actinitiators.poll();
					if (! act.getFunctor().equals("done")) {
						// System.out.println(agName + " adding " + r);
						
						// Really shared beliefs?
						addSharedBelief(agName, r);
					}
					//actinitiators.remove(agName);
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
				//actinitiators.offer(AgName);
				AJPFLogger.fine("eass.mas.DefaultEASSEnvironment", "calculating " + act);
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
		
		public boolean done() {
			return pendingCalculations.isEmpty();
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
				AJPFLogger.fine("eass.mas.DefaultEASSEnvironment", "sending calculation to matlab");
				socketserver2.write("CALLMFILE");
				socketserver2.write(predicate.getFunctor());
				socketserver2.write(num_arg_s);
				for (int i = 0; i < num_args; i++) {
					socketserver2.write(predicate.getTerm(i).toString());
				}
				socketserver2.write("1");
				String value = socketserver2.readLine();
				// System.out.println(value);
				Term v;
				if (value.startsWith("0") || value.startsWith("1") || value.startsWith("2")
						|| value.startsWith("3") || value.startsWith("4") || value.startsWith("5")
						|| value.startsWith("6") || value.startsWith("7") || value.startsWith("8")
						|| value.startsWith("9") 

						) {
				try {
					NumberTermImpl n = new NumberTermImpl(value);
					val.unifies(n, u);
					v = n;
				} catch (NumberFormatException ne) {
					v = new Predicate(value);
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
				// System.err.println(result);
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
						// System.err.println("adding " + r + " for " + agName);
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
				
		
		public boolean done() {
			return waitinitiators.isEmpty();
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
			// System.err.println("waiting " + act);
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
	
	public void notConnectedToMatLab() {
		connectedtomatlab = false;
	}
	
	public boolean connectedToMatLab() {
		return connectedtomatlab;
	}
	
}


