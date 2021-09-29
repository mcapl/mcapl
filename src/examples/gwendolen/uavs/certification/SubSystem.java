///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2010-12 University of Liverpool Virtual Engineering Centre.
// 
// Author: Matt Webster
///////////////////////////////////////////////////////////////////////////////

package gwendolen.uavs.certification;

import ail.syntax.Action;

/**
 * An Unmanned Aircraft System sub-system. This is stuff like sensors, planners, "agents", etc.
 * 
 * @author matt
 *
 */
public class SubSystem {
	
	/**
	 * This method sends a message to the subsystem. The message is in the form of an action 
	 * that has been performed by the executive. This is used when the executive sends a 
	 * direct message to a subsystem, e.g., requesting a route from the planner. The subsystem 
	 * may choose to send a message back to the executive, e.g., the plan that the planner has 
	 * generated. 
	 */
	public void tell(Action act)
	{
	
	}
	
	/**
	 * This advances the subsystem by one step. The idea is that the subsystem (if it is an
	 * agent) can do something, like measure a fuel level, in this step and will notify the 
	 * executive if necessary. This method should be called for each subsytem whenever the 
	 * executive sends out a message to the environment to "pollAgents".
	 */
	public void step()
	{
		
	}

	
	

}
