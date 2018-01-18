// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal;

import ajpf.MCAPLcontroller;
import ajpf.util.AJPFException;
import ajpf.util.AJPFLogger;
import ail.mas.scheduling.ActionScheduler;
import ail.mas.MAS;
import goal.mas.GoalEnvironment;


/**
 * Example Set up for running the pickup agent.
 * 
 * Is this class every used?
 * 
 * @author louiseadennis
 *
 */
public abstract class GOALMAS {
	MCAPLcontroller mccontrol;

	public GOALMAS(String[] args) {
		String filename = args[0];
		String abs_filename = null;
		try {
			abs_filename = MCAPLcontroller.getFilename(filename);
		} catch (AJPFException e) {
			AJPFLogger.severe("goal.GOALMAS", e.getMessage());
			System.exit(1);
		}

		String propertystring = getProperty(0);
		if (args.length == 2) {
			propertystring = getProperty(Integer.parseInt(args[1]));
		}
		
		MAS mas = (new GOALMASBuilder(abs_filename, true)).getMAS();
		GoalEnvironment env = new GoalEnvironment();
		ActionScheduler s = new ActionScheduler();
		env.setScheduler(s);
		env.addPerceptListener(s);
		mas.setEnv(env);
			
			// Set up a MCAPL controller and specification.
		//mccontrol = new MCAPLcontroller(config, propertystring);
		//mas.setController(mccontrol);
		//mccontrol.setMAS(mas, propertystring)
			// Start the system.
		
	}
		
	public void runexample() {
			// Start the system.
		mccontrol.begin(); 
           
 
	}
	
	public abstract String getProperty(int i);

}
