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

package ajpf.psl;

import ajpf.MCAPLmas;
import ajpf.psl.ast.NativeLastAction;

/**
 * The formula A(a, phi) - the last action performed was agent a doing phi.
 * 
 * @author louiseadennis
 * 
 */
public class MCAPLLastAction extends Proposition {
	
	/**
	 * The agent which is required to have the goal.
	 */
	private String agent;
	/**
	 * The formula that is the agent's goal.
	 */
	private MCAPLFormula action;
	
	/**
	 * The multi-agent system.
	 */
	private MCAPLmas mas;
	
	private int hashcode;
	
	/**
	 * Constructor.
	 * @param m The multi-agent system (from which the environment can be extracted).
	 * @param agName the name of the agent.
	 * @param f the formula.
	 */
	public MCAPLLastAction(MCAPLmas m, String agName, MCAPLFormula f) {
		action = f;
		agent = agName;
		mas = m;
		hashcode = action.hashCode() ^ agent.hashCode();
	}
	
	
	/**
	 * Checks the truth of the formula agent believs fmla
	 * 
	 * @return the truth of the formula.
	 */
	public boolean check() {
		// System.err.println("Last Action was " + agent + action + ":"+ mas.lastActionWas(agent, action));
		return (mas.lastActionWas(agent, action));
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#equals(mcapl.psl.MCAPLProperty)
	 */
	// NB.  Does not use the MAS for equality reasoning - this assumes it will only be compared to properties
	// that refer to the same MAS
	public boolean equals(Object p) {
		if (p instanceof NativeLastAction) {
			return (((NativeLastAction) p).getAction().equals(action) && ((NativeLastAction) p).getAgent().equals(agent));
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return hashcode;
	}
	
	/**
	 * Getter method for the Action.
	 * 
	 * @return the Action.
	 */
	public MCAPLFormula getAction() {
		return action;
	}
	
	/**
	 * Getter method for the Agent.
	 * 
	 * @return the agent who should have the goal.
	 */
	public String getAgent() {
		return agent;
	}
	
	/**
	 * Getter method for the MAS.
	 * @return
	 */
	public MCAPLmas getMAS() {
		return mas;
	}
	
	/**
	 * We don't need to clone the agent - its the same one we want to query.
	 */
	public MCAPLLastAction clone() {
		return(new MCAPLLastAction(mas, agent, (MCAPLFormula) action.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "A(" + agent + "," + action.toString() + ")";
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 9;
	}

	    
}
