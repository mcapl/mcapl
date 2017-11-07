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
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
import pbdi.syntax.PythonCalculation;

import java.util.List;
import java.util.Set;

import ail.mas.MAS;
import ail.semantics.AILAgent;


/**
 * An EASS Agent - a specialised language for use in Satellite control systems.
 * 
 * @author louiseadennis
 *
 */
public class PBDIAgent extends AILAgent { 
	public VerifyMap<String,Object> pythonstate;
	
	public VerifyList<PythonCalculation> python_calculations = new VerifyList<PythonCalculation>();
	
	
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
	
	public void updateState(String variable, Object value) {
		pythonstate.put(variable, value);
	}
	
	public Object getState(String variable) throws Exception {
		if (pythonstate.containsKey(variable)) {
			return pythonstate.get(variable);
		} else {
			throw new Exception("Null value returned");
		}
	}

	public List<PythonCalculation> getPCs() {
		return python_calculations;
	}
	
	public void setCalcs(Set<PythonCalculation> calcs) {
		python_calculations.clear();
		for (PythonCalculation calc: calcs) {
			python_calculations.add(calc);
		}
	}
	
 	/*
 	 * (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
	@Override
 	public String toString() {
 		StringBuilder is = new StringBuilder();
 		if (getIntention() != null) {
 				is.append(getIntention().toString());
 		}
 		
 		StringBuilder s1 = new StringBuilder();
 		s1.append(getAgName());
 		s1.append("\n=============\n");
 		s1.append("After Stage ");
 		s1.append(RC.getStage().getStageName()); 
 		s1.append(" :\n");
 		s1.append(getBB().toString());
 		s1.append("\n");
		s1.append(getGoalBase().toString());
 		s1.append("\n");
 		s1.append(python_calculations.toString());
 		s1.append("\n");
		s1.append(is);
		s1.append("\n");
		s1.append(Is);
		String s = s1.toString();
 		return s;
 	}



}
