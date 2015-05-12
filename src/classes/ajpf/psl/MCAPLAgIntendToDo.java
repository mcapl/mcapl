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

import ajpf.MCAPLAgent;
import ajpf.MCAPLcontroller;

/**
 * The formula I(a, phi) - a has intention phi.
 * 
 * @author louiseadennis
 * 
 */
public class MCAPLAgIntendToDo extends Proposition {
	
	/**
	 * The agent which is required to have the goal.
	 */
	private MCAPLAgent agent;

	/**
	 * The formula that is the action the agent intends to perform.
	 */
	private MCAPLFormula action;
	
	private int hashcode;
	
	/**
	 * Constructor.
	 * 
	 * @param a  The agent which has the goal.
	 * @param f  The goal.
	 */
	public MCAPLAgIntendToDo(MCAPLAgent a, MCAPLFormula f) {
		action = f;
		agent = a;
		hashcode = action.hashCode() ^ agent.hashCode();
	}
	
	/**
	 * Constructor for when we only have the agent name, not the 
	 * agent.
	 * 
	 * @param s The name of the agent.
	 * @param c The controller for the multi-agent system.
	 * @param f The goal.
	 */
	public MCAPLAgIntendToDo(String s, MCAPLcontroller c, MCAPLFormula f) {
		this(c.getAgent(s), f);
	}
	
	/**
	 * Checks the truth of the formula agent has intention fmla
	 * 
	 * @return the truth of the formula.
	 */
	public boolean check() {
		return (agent.intendsToDo(action));
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#equals(mcapl.psl.MCAPLProperty)
	 */
	public boolean equals(Object p) {
		if (p instanceof MCAPLAgIntendToDo) {
			return (((MCAPLAgIntendToDo) p).getAction().equals(action) && ((MCAPLAgIntendToDo) p).getAgent().equals(agent));
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
	 * @return the action.
	 */
	public MCAPLFormula getAction() {
		return action;
	}
	
	/**
	 * Getter method for the Agent.
	 * 
	 * @return the agent who should intend the action.
	 */
	public MCAPLAgent getAgent() {
		return agent;
	}
	
	/**
	 * We don't need to clone the agent - its the same one we want to query.
	 */
	public MCAPLAgIntendToDo clone() {
		return(new MCAPLAgIntendToDo(agent, (MCAPLFormula) action.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "ItD(" + agent.getAgName() + "," + action.toString() + ")";
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 12;
	}

	    
}
