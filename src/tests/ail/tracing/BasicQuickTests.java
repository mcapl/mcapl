// ----------------------------------------------------------------------------
// Copyright (C) 2019 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
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
package ail.tracing;

import org.junit.Test;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;

/**
 * Really basic error freeness tests.
 * @author louisedennis
 *
 */
public class BasicQuickTests {

	@Test
	public void orcaTest() {
		AILConfig config = new AILConfig("src/examples/gwendolen/orca/Prototype6VK/Executive.ail");
		AIL.configureLogging(config);
	
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");

		// Create the initial state of the multi-agent program.
		MAS mas = AIL.AILSetup(config, mccontrol);
		
		// Set up a controller 
		mccontrol.setMAS(mas);
		
		// Begin!
		mccontrol.begin(); 
		mas.cleanup();
	}
	
	@Test
	public void tutorialExampleTest() {
		AILConfig config = new AILConfig("src/examples/gwendolen/tracing/pickuprubble_goal.ail");
		AIL.configureLogging(config);
	
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");

		// Create the initial state of the multi-agent program.
		MAS mas = AIL.AILSetup(config, mccontrol);
		
		// Set up a controller
		mccontrol.setMAS(mas);
		
		// Begin!
		mccontrol.begin(); 
		mas.cleanup();
	}
}
