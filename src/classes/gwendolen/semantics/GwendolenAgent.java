// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
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
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.semantics;


import ail.util.AILConfig;
import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;


/**
 * A Gwendolen Agent - a demonstration of how to subclass an AIL Agent and
 * create a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public class GwendolenAgent extends AILAgent { 

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public GwendolenAgent(MAS mas, String name) throws AILexception {
		// first we create an AIL Agent.
		super(mas, name);
		
      //  try {
    //        ((DefaultEnvironment) fEnv).addPerceptListener(this);
    //} catch (Exception e) {
    //        throw new AILexception("AIL: error creating the agent architecture! - " + e);
    //}

    // Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		// setTrackPlanUsage(false);
		setReasoningCycle(new GwendolenRC());


		
	}
	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public GwendolenAgent(String name) throws AILexception {
		// first we create an AIL Agent.
		super(name);
		
      //  try {
    //        ((DefaultEnvironment) fEnv).addPerceptListener(this);
    //} catch (Exception e) {
    //        throw new AILexception("AIL: error creating the agent architecture! - " + e);
    //}

    // Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
	//	setTrackPlanUsage(false);
		setReasoningCycle(new GwendolenRC());


		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.AILAgent#configure(ail.util.AILConfig)
	 */
	@Override
	public void configure(AILConfig config) {
		if (config.containsKey("ail.store_sent_messages")) {
			String store_sent_messages = config.getProperty("ail.store_sent_messages");
			if (store_sent_messages.equals("true")) {
				setStoreSentMessages(true);
			} else {
				setStoreSentMessages(false);
			}
		}
		
	}
	


}
