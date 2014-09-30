// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
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

package ethical_governor.mas;

import java.util.HashMap;
import java.util.Map;

import ethical_governor.semantics.EthicalGovernor;
import ail.mas.DefaultEnvironment;
import ail.semantics.AILAgent;

public abstract class DefaultEthicalGovernorEnv extends DefaultEnvironment implements
		EthicalGovernorEnv {
	
	protected Map<String, String> governors = new HashMap<String, String>();


	/**
	 * Add an agent or ethical governor.
	 * @param a
	 */
	public void addAgent(AILAgent a) {
		super.addAgent(a);
		if (a instanceof EthicalGovernor) {
			EthicalGovernor eg = (EthicalGovernor) a;
			addEthicalGovernor(eg.getAgName(), eg.getGovernorFor());
			
			getScheduler().doNotSchedule(eg.getAgName());
		}
	}
	
	/**
	 * Add an ethical governor for some particular agent to the environment.
	 * @param name
	 * @param foragent
	 */
	public void addEthicalGovernor(String name, String foragent) {
		governors.put(name, foragent);
		governors.put(foragent, name);
	}
	
	/**
	 * Return the governor for some agent.
	 * @param agName
	 * @return
	 */
	public EthicalGovernor getGovernorFor(String agName) {
		String egName = governors.get(agName);
		return (EthicalGovernor) agentmap.get(egName);
	}

}
