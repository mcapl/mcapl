// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis,  and Michael Fisher
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
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.tutorials;

import junit.framework.Assert;

import org.junit.Test;

import ail.mas.AIL;
import ajpf.MCAPLcontroller;
import gwendolen.GwendolenAgentBuilder;
import gwendolen.semantics.GwendolenAgent;


/**
 * Simple test that an auction example works.
 */
public class Tutorial7QuickTests {

  @Test //----------------------------------------------------------------------
  public void hello_world() {
	  try {
		  String abs_filename = MCAPLcontroller.getFilename("/src/examples/gwendolen/tutorials/tutorial7/answers/pickuprubble.gwen");
		  GwendolenAgentBuilder builder = new GwendolenAgentBuilder();
		  GwendolenAgent g = (GwendolenAgent) builder.getAgent(abs_filename);
		  Assert.assertNotNull(g);
	  } catch (Exception e) {
		  System.err.println(e);
		  Assert.assertTrue(false);
	  }
  }
  


}
