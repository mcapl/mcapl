// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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

package pbdi.semantics;


import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;


/**
 * An EASS Agent - a specialised language for use in Satellite control systems.
 * 
 * @author louiseadennis
 *
 */
public class PBDIAgent extends AILAgent { 
	/**
	 * Construct a PBDI agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public PBDIAgent(MAS mas, String name) throws AILexception {
		// first we create an AIL Agent.
		super(mas, name);
		// Then we construct its reasoning cycle, starting with
		// an empty reasoning cycle.  See the PBDIRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		setReasoningCycle(new PBDIRC());


		
	}
	
	public PBDIAgent(String name) throws AILexception {
		// first we create an AIL Agent.
		super(name);
		// Then we construct its reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		setReasoningCycle(new PBDIRC());


		
	}



}
