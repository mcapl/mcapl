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
	
	//private String propertystring;
	Random random_numbers = new Random();
		

	/**
	 * Constructs a controller from a MAS and a property.
	 * @param mas
	 * @param propertystring
	 * @param outputlevel
	 */
	public MCAPLcontroller(MCAPLmas mas, String pstring, int outputlevel) {
		this(mas, outputlevel);
		//propertystring = pstring;
		//Property_AST prop_ast = new Property_AST();
		//prop_ast.parse(propertystring);
		//MCAPLProperty prop = prop_ast.toMCAPL(mas, this);
		//System.err.println(prop);
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
			//System.err.println(magent.getAgName());
		}
		//m.addPerceptListener(this);
		specification = s;
		mas.setController(this);
	//	setOutputLevel(mc);
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
			//System.err.println(magent.getAgName());
		}
		mas.setController(this);
		//m.addPerceptListener(this);
		//setOutputLevel(mc);
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
	 * Setter method for the outputlevel flag.
	 * 
	 * @param b the value of the flag.
	 */
//	public void setOutputLevel(int b) {
//		mas.setOutputLevel(b);
//	}
	
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
		AJPFLogger.fine("ajpf.MCAPLcontroller", "entered begin");
		specification.createAutomaton();
		specification.checkProperties();
		//mas.MCAPLstart();
		//for (MCAPLAgent a: agents.values()) {
		//	System.out.println("starting agent" + a.getName());
		//	a.start();
		//}
		// a = scheduling();
		boolean checkend = checkEnd();
		while (! checkend) {
			a = scheduling();
			AJPFLogger.fine("ajpf.MCAPLcontroller", "before checkend");
			checkend = checkEnd();
		}
		triggerendstate();
		AJPFLogger.fine("ajpf.MCAPLcontroller", "leaving begin");
		
	}
	
	public MCAPLJobber scheduling() {
		List<MCAPLJobber> activeJobs = scheduler.getActiveJobbers();
		//AJPFLogger.info("ajpf.MCAPLcontroller", "About to pick job");
		if (!activeJobs.isEmpty()) {
			a = null;
			int job_num = pickJob(activeJobs.size());
			a = activeJobs.get(job_num);
			// Necessary to assist state matching at call to pickJob
			job_num = 0;
		//	AJPFLogger.info("ajpf.MCAPLcontroller", "Picked jobber " + a.getName());
		} //else {
		//	pickJob(1);
		//}
		AJPFLogger.fine("ajpf.MCAPLcontroller", "Picked jobber " + a.getName() + " from " + activeJobs);
		a.do_job();
		specification.checkProperties();
		return a;
	}
	
	private int pickJob(int limit) {
		// System.err.println(limit);
		AJPFLogger.fine("ajpf.MCAPLcontroller", "Limit is " + limit);
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
		
	
	//private VerifySet<String> sleeping = new VerifySet<String>();
	public void addAsleep(String agname) {
		scheduler.notActive(agname);
//		System.out.println(sleeping);
	}
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
		AJPFLogger.fine("ajpf.MCAPLcontroller", "entering check end");
		for (MCAPLAgent ag : agents.values()) {
			if (scheduler.getActiveJobberNames().contains(ag.getAgName())) {
				//	!sleeping.contains(ag.getAgName()) ) {
				// System.err.println(ag.getAgName());
				AJPFLogger.fine("ajpf.MCAPLcontroller", "returning false");
				return false;
			}
		}

		// If the MAS also reckons it's done.
		if (getMAS().alldone()) {
			//boolean tmp = triggerendstate();
			getMAS().stopAgs();
		//	for (MCAPLAgent ag : agents.values()) {
		//		ag.perceptChanged();
		//	}
			AJPFLogger.fine("ajpf.MCAPLcontroller", "returning true");
			return true;
		}
		// System.err.println("not done");
		AJPFLogger.fine("ajpf.MCAPLcontroller", "returning false by default");
		return false;
		

	} 
	
	/**
	 * Dummy procedure for triggering the listener.
	 * @return
	 */
	public boolean triggerendstate() {
//		Thread.yield();
		return true;
	}
		
	/**
	 * Check an agent is all done.
	 * @param a
	 * @return
	 */
	//public boolean nothingpendingfor(MCAPLLanguageAgent a) {
	//	return (getMAS().alldonefor(a.getMCAPLAgName()));
	//}

	public MCAPLScheduler getScheduler() {
		return scheduler;
	}

	public static String getPath() {
		if (System.getenv("AJPF_HOME") != null) {
			return System.getenv("AJPF_HOME");
		} else {
			return System.getenv("HOME");
		}

	}
	
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
	
	public static String getAbsFilename(String filename) {
		return System.getProperty("user.dir") + "/" + filename;
	}
}
