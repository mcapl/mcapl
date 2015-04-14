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

package ajpf;

import gov.nasa.jpf.annotation.FilterField;

import java.util.Random;
import java.util.List;
import java.io.File;

import ajpf.util.AJPFLogger;
import ajpf.util.VerifyMap;
import ajpf.util.AJPFException;

/**
 * Top level class for controlling the model checking of multi-agent
 * systems.
 * 
 * @author louiseadennis
 *
 */
public class MCAPLcontroller  {
	/**
	 * The multi-agent system to be model-checked.
	 */
	@FilterField
	private MCAPLmas mas;
	/**
	 * A list of the agents in the multi-agent system indexed by the agent
	 * names.
	 */
	@FilterField
	private VerifyMap<String, MCAPLAgent> agents = new VerifyMap<String, MCAPLAgent>();
	/**
	 * The specification against which the system is to be checked.
	 */
	private MCAPLSpec specification = new MCAPLSpec();
	
	/**
	 * Used when controlling the JPF search to force JPF to ignore states where all agents
	 * and the environment have started but the main thread has not concluded.
	 */
	@FilterField
	private boolean mainconcluded = false;
	
	private MCAPLScheduler scheduler;

	Random random_numbers = new Random();
	
	// We make this a class variable for test sets which run AIL in a thread.
	boolean checkend = false;
		

	/**
	 * Constructs a controller from a MAS and a property.
	 * @param mas
	 * @param propertystring
	 * @param outputlevel
	 */
	public MCAPLcontroller(MCAPLmas mas, String pstring, int outputlevel) {
		this(mas, outputlevel);
		specification.addPropertyString(pstring);
		specification.addMas(mas);
		specification.addController(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param m
	 *            The multi-agent system to be model-checked.
	 * @param s
	 *            The specification against which the system is to be checked.
	 */
	public MCAPLcontroller(MCAPLmas m, MCAPLSpec s, int mc) {
		mas = m;
		scheduler = mas.getScheduler();
		List<MCAPLLanguageAgent> lagents = m.getMCAPLAgents();
		for (MCAPLLanguageAgent a : lagents) {
			MCAPLAgent magent = new MCAPLAgent(a, mc, this);
			agents.put(magent.getAgName(), magent);
			m.addPerceptListener(magent);
		}
		specification = s;
		mas.setController(this);
	}
	
	/**
	 * Cretaes a controller from a MAS.
	 * @param m
	 * @param mc
	 */
	public MCAPLcontroller(MCAPLmas m, int mc) {
		mas = m;
		scheduler = mas.getScheduler();
		List<MCAPLLanguageAgent> lagents = m.getMCAPLAgents();
		for (MCAPLLanguageAgent a : lagents) {
			MCAPLAgent magent = new MCAPLAgent(a, mc, this);
			agents.put(magent.getAgName(), magent);
			m.addPerceptListener(magent);
			scheduler.addJobber(magent);
		}
		mas.setController(this);
	}

	/**
	 * Returns the agent with a given name.
	 * 
	 * @param name The name of the agent.
	 * @return The agent which has that name.
	 */
	public MCAPLAgent getAgent(String name) {
		return agents.get(name);
	}
	
	/**
	 * Getter method for the specification.
	 * 
	 * @return The specification against which the MAS is to be checked.
	 */
	public MCAPLSpec getSpecification() {
		return (specification);
	}
		
	/**
	 * Getter method for the multi-agent system.
	 * @return
	 */
	public MCAPLmas getMAS() {
		return mas;
	}
	

	/**
	 * Starts the controller and the underlying system and agents.
	 *
	 */
	MCAPLJobber a;
	public void begin() {
		// We assume it makes no difference the exact order the agents and the 
		// environment (if relevant) start in so make this atomic.
		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
			AJPFLogger.fine("ajpf.MCAPLcontroller", "entered begin");
		}
		specification.createAutomaton();
		specification.checkProperties();
		checkend = checkEnd();
		while (! checkend) {
			a = scheduling();
			if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {			
				AJPFLogger.fine("ajpf.MCAPLcontroller", "before checkend");
			}
			checkend = checkEnd();
		}
		// force_transition();
		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
			AJPFLogger.fine("ajpf.MCAPLcontroller", "leaving begin");
		}
		
	}
	
	/**
	 * Use scheduler to pick a Jobber, do a Jobber, and return the Jobber.
	 * @return
	 */
	public MCAPLJobber scheduling() {
		List<MCAPLJobber> activeJobs = scheduler.getActiveJobbers();

		if (!activeJobs.isEmpty()) {
			a = null;
			int job_num = pickJob(activeJobs.size());
			a = activeJobs.get(job_num);
			// Necessary to assist state matching at call to pickJob
			job_num = 0;
		} 

		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
				AJPFLogger.fine("ajpf.MCAPLcontroller", "Picked jobber " + a.getName() + " from " + activeJobs);
		}
		a.do_job();
		specification.checkProperties();
		force_transition();
		return a;
	}
	
	/**
	 * Pick a jobber.  This method is intercepted by a native peer when executing in JPF.
	 * Hence why it returns an int.
	 * @param limit
	 * @return
	 */
	private int pickJob(int limit) {
		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
			AJPFLogger.fine("ajpf.MCAPLcontroller", "Limit is " + limit);
		}
		int choice = random_numbers.nextInt(limit);
		return choice;
	}
	
	/**
	 * Essentially a getter method for the mainconcluded field used to prune parts of the JPF
	 * search space.
	 * 
	 * @return
	 */
	public boolean beginfinished() {
		return mainconcluded;
	}
		
	/**
	 * This Jobber is asleep.
	 * @param agname
	 */
	public void addAsleep(String agname) {
		scheduler.notActive(agname);
	}
	
	/**
	 * This Jobber is now awake.
	 * @param agname
	 */
	public void addAwake(String agname) {
		scheduler.isActive(agname);
	}
	
	/**
	 * Checks to see that all agents are asleep and no notifications are outstanding.
	 * If so it tells all agents to stop and wakes them up.
	 *
	 * @return
	 */
	public boolean checkEnd() {
		// Check all agents are sleeping and without notifications.
		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
			AJPFLogger.fine("ajpf.MCAPLcontroller", "entering check end");
		}
		for (MCAPLAgent ag : agents.values()) {
			if (scheduler.getActiveJobberNames().contains(ag.getAgName())) {
				if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
					AJPFLogger.fine("ajpf.MCAPLcontroller", "returning false");
				}
				return false;
			}
		}

		// If the MAS also reckons it's done.
		if (getMAS().alldone()) {
			getMAS().stopAgs();
			if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
				AJPFLogger.fine("ajpf.MCAPLcontroller", "returning true");
			}
			return true;
		}
		if (AJPFLogger.ltFine("ajpf.MCAPLcontroller")) {
			AJPFLogger.fine("ajpf.MCAPLcontroller", "returning false by default");
		}
		return false;
		
	} 
	
	/**
	 * Dummy procedure for triggering the listener.
	 * @return
	 */
	public static boolean force_transition() {
		return true;
	}
		
	/**
	 * Return the current scheduler.
	 * @return
	 */
	public MCAPLScheduler getScheduler() {
		return scheduler;
	}

	/**
	 * Return the current path being used to store config files etc.
	 * @return
	 */
	public static String getPath() {
		if (System.getenv("AJPF_HOME") != null) {
			return System.getenv("AJPF_HOME");
		} else {
			return System.getenv("HOME");
		}

	}
	
	/**
	 * Given a filename, try to find the file.
	 * @param filename
	 * @return
	 * @throws AJPFException
	 */
	public static String getFilename(String filename) throws AJPFException {
		String ajpf_filename = null;
		String abs_filename = System.getenv("HOME") + filename;
		File f = new File(filename);
		String rel_filename = System.getProperty("user.dir") + filename;
		if (f.exists()) {
			return filename;
		} else {
			f = new File(abs_filename);
			if (f.exists()) {
				return abs_filename;
			} else {
				f = new File(rel_filename);
				if (f.exists()) {
					return rel_filename;
				} else if (System.getenv("AJPF_HOME") != null) {
					ajpf_filename =System.getenv("AJPF_HOME") + filename;

					f = new File(ajpf_filename);
					if (f.exists()) {
						return ajpf_filename;
					}
				}
			}
		}
		
		String msg = "Could not find file.  Checked: \n " + filename + ",\n " + abs_filename + ",\n " + rel_filename;
		if (ajpf_filename != null) {
			msg += ",\n " + ajpf_filename;
		}
		
		throw (new AJPFException(msg));
	}
	
	/**
	 * Get the absolute file name of a file in the current user.dir.
	 * @param filename
	 * @return
	 */
	public static String getAbsFilename(String filename) {
		return System.getProperty("user.dir") + "/" + filename;
	}
	
	/**
	 * Stop the MAS.
	 */
	public void stop() {
		checkend = false;
	}
}
