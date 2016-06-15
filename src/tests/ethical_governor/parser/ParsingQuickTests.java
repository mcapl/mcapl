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
// License along with the DEG; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ethical_governor.parser;

import junit.framework.Assert;

import org.junit.Test;

import ethical_governor.EthicalGovernorBuilder;
import ethical_governor.semantics.EthicalGovernor;
import ajpf.MCAPLcontroller;

/**
 * Tests of the ethical governor parser.
 * @author lad
 *
 */
public class ParsingQuickTests {
	@Test public void simplegovernor() {
		try {
			String abs_filename = MCAPLcontroller.getFilename("/src/examples/ethical_governor/human_hole/governor.eg");
			EthicalGovernorBuilder builder = new EthicalGovernorBuilder();
			EthicalGovernor eg = (EthicalGovernor) builder.getAgent(abs_filename);
			Assert.assertNotNull(eg);
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertTrue(false);
		}
	}
}
