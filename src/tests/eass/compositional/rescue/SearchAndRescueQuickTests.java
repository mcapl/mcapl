// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis,  and Michael Fisher
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
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
package eass.compositional.rescue;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.test.TestJPF;

/**
 * Examples from Practical Verification of Decision-Making in Agent-Based Autonomous Systems
 * that run in reasonable time.
 * @author louiseadennis
 *
 */
public class SearchAndRescueQuickTests extends TestJPF {
	 static final String[] ARGS = {};
	
	  @Test //----------------------------------------------------------------------
	  public void planreas1() {
		  if (verifyNoPropertyViolation(ARGS)) {
		    	String filename =  "/src/examples/eass/compositional/rescue/planreas.ail";
		    	String prop_filename =  "/src/examples/eass/compositional/rescue/rescue.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "9";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }


}
