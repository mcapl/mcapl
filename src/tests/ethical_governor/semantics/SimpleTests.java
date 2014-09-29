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
package ethical_governor.semantics;

import junit.framework.Assert;

import org.junit.Test;

import actiononly.ActionOnlyAgentBuilder;
import actiononly.semantics.ActionOnlyAgent;
import ajpf.MCAPLcontroller;
import ail.mas.MAS;
import ethical_governor.human_hole.HumanHoleEnv;
import ethical_governor.EthicalGovernorBuilder;

public class SimpleTests {
	@Test public void simpleagent() {
		try {
			String ao_abs_filename = MCAPLcontroller.getFilename("/src/examples/actiononly/random/simplerobot.ao");
			String eg_abs_filename = MCAPLcontroller.getFilename("/src/examples/ethical_governor/human_hole/governor.eg");
			HumanHoleEnv env = new HumanHoleEnv();
			MAS mas = new MAS();
			mas.setEnv(env);
			
			ActionOnlyAgentBuilder ao_builder = new ActionOnlyAgentBuilder();
			EthicalGovernorBuilder eg_builder = new EthicalGovernorBuilder();
			
			ActionOnlyAgent ao = (ActionOnlyAgent) ao_builder.getAgent(ao_abs_filename);
			EthicalGovernor eg = (EthicalGovernor) eg_builder.getAgent(eg_abs_filename);
			
			mas.addAg(ao);
			mas.addAg(eg);
			env.addAgent(ao);
			env.addAgent(eg);
			
			env.initialise();
			
			
			ao.reason();
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertTrue(false);
		}
	}

}
