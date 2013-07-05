// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ail.semantics;

/**
 * Interface for an APL reasoning cycle.  There is assumed to be a
 * reasoning cycle object for each agent and the cycle is stateful - i.e.,
 * it knows at which stage in the cycle the agent currently is.
 * 
 * @author louiseadennis
 *
 */
public interface ReasoningCycle {
	
	/**
	 * Tell the reasoning cycle it should stop and check properties at the next
	 * opportunity.
	 * @param b
	 */
	public void setStopandCheck(boolean b);
	
	/**
	 * Flag indicating whether the reasoning cycle has reached a state
	 * where the model checker should check properties.
	 * 
	 * @return whether the model checker should stop and check properties.
	 */
	public boolean stopandcheck();
	
	/**
	 * Cycle the reasoning cycle - i.e., move on to the next stage.  The
	 * agent is supplied in case the next stage is dependent on the state
	 * of the agent.
	 * 
	 * @param ag The agents whose reasoning cycle is to cycled.
	 */
	public void cycle(AILAgent ag);

	/**
	 * Return the current stage of the reasoning cycle.
	 * 
	 * @return The current stage of the reasoning cycle.
	 */
	public RCStage getStage();
	
	/**
	 * Setter for the current reasoning stage.
	 * @param rcs
	 */
	public void setCurrentStage(RCStage rcs);
	
	/**
	 * The reason cycle has not been interrupted.  This is used to control scheduler choice points that can happen, 
	 * in particular, during action execution rather than in between the execution of individual rules.  This is
	 * used by the OOPL implementation.
	 * @return
	 */
	public boolean not_interrupted();
		
}
