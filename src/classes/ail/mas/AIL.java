// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.mas;

import ail.util.AILConfig;
import ail.semantics.AILAgent;
import ail.syntax.ast.GroundPredSets;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFException;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.annotation.FilterField;

import java.util.logging.Level;

/**
 * This class serves as a helper class for initialising and running AIL mas's.  It takes a 
 * configuration file and build a MAS from it.
 * @author louiseadennis
 *
 */
public class AIL {
	@FilterField
	static String logname = "ail.mas.AIL";

	/**
	 * Main method.  There should be one argument consisting of the name of a configuration file.
	 * @param args
	 */
	public static void main(String[] args) {
		runAIL(args[0]);
	}
	
	/**
	 * Run an AIL program as specified in the configuration file.
	 * @param configfile
	 */
	public static void runAIL(String configfile) {
		GroundPredSets.clear();
		AILConfig config = new AILConfig(configfile);
		configureLogging(config);
		
		// Create a controller
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");
	
		// Create the initial state of the multi-agent program.
		MAS mas = AILSetup(config, mccontrol);
		
		// Set up a controller
		// mccontrol.setMAS(mas);
		
		// mas.getEnv().initialise();
		
		// Begin!
		mccontrol.begin(); 
		mas.cleanup();

	}
	
	/**
	 * Set up a multi-agent system from a configuration file.
	 * @param config
	 * @return
	 */
	public static MAS AILSetup(AILConfig config, MCAPLcontroller control) {
		
		// First we need to build the multi-agent system
		MAS mas = buildMAS(config);
		mas.setController(control);
		
		// Then, if necessary, we attach an environment
		if (config.containsKey("env")) {
			try {
				AILEnv env = (AILEnv) (Class.forName(config.getProperty("env"))).newInstance();
				env.configure(config);
				env.init_before_adding_agents();
				mas.setEnv(env);
				control.setMAS(mas);
				env.init_after_adding_agents();
				control.initialiseSpec();
				env.setMAS(mas);
			} catch (Exception e) {
				AJPFLogger.severe("ail.mas.AIL", e.getMessage());
				System.exit(1);
			}
		}
		mas.configure(config);
		return mas;
	}
	
	/**
	 * Build a multi-agent system from the configuration.
	 * @return
	 */
	public static MAS buildMAS(AILConfig config) {
		MAS mas = new MAS();
		// We've been given the name of a file and a mas builder
		if (config.containsKey("mas.file") && config.containsKey("mas.builder")) {
			
			String filename = config.getProperty("mas.file");
			String abs_filename = null;
			try {
				abs_filename = MCAPLcontroller.getFilename(filename);
			} catch (AJPFException e) {
				AJPFLogger.severe("ail.mas.AIL", e.getMessage());
				System.exit(1);
			}
			
			try {
				MASBuilder masbuilder = (MASBuilder) (Class.forName(config.getProperty("mas.builder"))).newInstance();
				mas = masbuilder.getMAS(abs_filename);
			} catch (Exception e) {
				AJPFLogger.severe("ail.mas.AIL", e.getMessage());
				System.exit(1);
			}

		}
		
		int agentcounter = 1;
		while (config.containsKey(agentNumKey(agentcounter) + ".file") && config.containsKey(agentNumKey(agentcounter) + ".builder")) {
			String filename = config.getProperty(agentNumKey(agentcounter) + ".file");
			String abs_filename = null;
			try {
				abs_filename = MCAPLcontroller.getFilename(filename);
			} catch (AJPFException e) {
				AJPFLogger.severe("ail.mas.AIL", e.getMessage());
				System.exit(1);
			}
			
			try {
				AgentBuilder agentbuilder = (AgentBuilder) (Class.forName(config.getProperty(agentNumKey(agentcounter) + ".builder"))).newInstance();
				AILAgent agent = agentbuilder.getAgent(abs_filename);
				if (config.containsKey(agentNumKey(agentcounter) + ".name")) {
					String agentname = config.getProperty(agentNumKey(agentcounter) + ".name");
					agent.setAgName(agentname);
				} 
				
				mas.addAg(agent);
				
			} catch (Exception e) {
				AJPFLogger.severe("ail.mas.AIL", e.getMessage());
				System.exit(1);
			}
			
			
			
			agentcounter++;
			
		}
		return mas;
		
	}
	
	/**
	 * Helper function to build the strings for each agent file.
	 * @param i
	 * @return
	 */
	private static String agentNumKey(int i) {
		return "mas.agent." + i;
	}
		
	/**
	 * Set up the loggers appropriately.
	 */
	public static void configureLogging(AILConfig config) {
		if (config.containsKey("log.finest")) {
			String logs = config.getProperty("log.finest");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.FINEST);
			}
		}
		if (config.containsKey("log.finer")) {
			String logs = config.getProperty("log.finer");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.FINER);
			}
		}
		if (config.containsKey("log.fine")) {
			String logs = config.getProperty("log.fine");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.FINE);
			}
		}
		if (config.containsKey("log.info")) {
			String logs = config.getProperty("log.info");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.INFO);
			}
		}
		if (config.containsKey("log.severe")) {
			String logs = config.getProperty("log.severe");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.SEVERE);
			}
		}
		if (config.containsKey("log.warning")) {
			String logs = config.getProperty("log.warning");
			String [] loggers = logs.split(",");
			for (int i = 0; i < loggers.length; i++) {
				AJPFLogger.setLevel(loggers[i], Level.WARNING);
			}
		}
		if (config.containsKey("log.format")) {
			String format = config.getProperty("log.format");
			if (format.equals("brief")) {
				AJPFLogger.setHandlerFormatBrief();
			} else if (format.equals("as_output")) {
				AJPFLogger.setHandlerFormatAsOutput();
			}
		}
	}

}
