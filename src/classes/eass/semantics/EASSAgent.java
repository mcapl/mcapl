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

package eass.semantics;


import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;


/**
 * An EASS Agent - a specialised language for use in Satellite control systems.
 * 
 * @author louiseadennis
 *
 */
public class EASSAgent extends AILAgent { 
	private boolean isAbstraction = false;
	private String abstraction_for;

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public EASSAgent(MAS mas, String name) throws AILexception {
		// first we create an AIL Agent.
		super(mas, name);
		setTrackPlanUsage(false);
		

    // Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		setReasoningCycle(new EASSRC());


		
	}
	
	public void setAbstraction(String agname) {
		isAbstraction = true;
		abstraction_for = agname;
	}
	
	public boolean isAbstractionEngine() {
		return isAbstraction;
	}
	
	public String getEngineFor() {
		return abstraction_for;
	}
 

}
