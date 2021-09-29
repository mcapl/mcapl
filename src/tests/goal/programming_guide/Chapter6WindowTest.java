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
package goal.programming_guide;

import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.Test;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ail.util.AJPF_w_AIL;
import ajpf.MCAPLcontroller;

public class Chapter6WindowTest {

	  // General framework for testing print statements.  Stolen from stackOverflow.
	  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	  private PrintStream systemStdErr = System.err;
	  static final String[] JPF_ARGS = {  "-show" };
	  
	  public void setUpStreams() {
	      System.setErr(new PrintStream(errContent));
	  }

	  public void cleanUpStreams() {
	      System.setErr(systemStdErr);
	  }

	  @Test //----------------------------------------------------------------------
	  public void errorfreeeisconnection () {
		  setUpStreams();
		AILConfig config = new AILConfig("src/examples/goal/programming_guide/chapter6/table6_1.ail");
		AIL.configureLogging(config);
	
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");

		// Create the initial state of the multi-agent program.
		MAS mas = AIL.AILSetup(config, mccontrol);
		
		// Set up a controller
		// mccontrol.setMAS(mas);
		
		// Begin!
		mccontrol.begin(); 
		mas.cleanup();
		String nl = System.lineSeparator();
		String expectedOutput = "goal_agent attempting move(b4,b3)" + nl + "goal_agent attempting move(b2,table)"
				+ nl + "goal_agent attempting move(b1,table)" + nl + "goal_agent attempting move(b4,b3)" 
				+ nl + "goal_agent attempting move(b2,table)" + nl + "goal_agent attempting move(b4,b3)"
				+ nl + "goal_agent attempting move(b5,b2)" + nl + "goal_agent attempting move(b1,b5)"
				+ nl + "goal_agent attempting move(b6,b4)" + nl;
		Assert.assertEquals(expectedOutput, errContent.toString());
		cleanUpStreams();
	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void twoagents () {
		 // setUpStreams();
		AILConfig config = new AILConfig("src/examples/goal/programming_guide/chapter6/two_agents.ail");
		AIL.configureLogging(config);
	
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");

		// Create the initial state of the multi-agent program.
		MAS mas = AIL.AILSetup(config, mccontrol);
		
		// Set up a controller
		// mccontrol.setMAS(mas);
		
		// Begin!
		try {
			mccontrol.begin(); 
		} catch (Exception e) {
			Assert.assertFalse(true);
		}
		mas.cleanup();
		//String expectedOutput = "goal_agent attempting move(b4,b3)\ngoal_agent attempting move(b2,table)\ngoal_agent attempting move(b1,table)\ngoal_agent attempting move(b4,b3)\ngoal_agent attempting move(b2,table)\ngoal_agent attempting move(b4,b3)\ngoal_agent attempting move(b5,b2)\ngoal_agent attempting move(b1,b5)\ngoal_agent attempting move(b6,b4)\n";
		//Assert.assertEquals(expectedOutput, errContent.toString());
		//cleanUpStreams();
	  }
	  


}
