// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis,  and Michael Fisher
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

package gwendolen.rescue;

import org.junit.Test;

import ail.util.AJPF_w_AIL;

import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.util.TypeRef;

/**
 * Regresssion test of various properties using the Rescue Robots as an example problem.
 * Split over several files since JPF was having problems executing multiple tests in one file.
 */
public class RescueB2QuickTests extends TestJPF {

	 static final String[] RESCUE_ARGS = { "-show", 
		 "+listener+=,.listener.ExecTracker",
	     "+et.print_insn=false",
	     "+et.show_shared=false"
	};

	  //--- test methods

	  

	 @Test //----------------------------------------------------------------------
	 public void testProblemsWithEndStates () {
	   if (verifyPropertyViolation(new TypeRef("ajpf.MCAPLListener"), RESCUE_ARGS)){
	   	String filename =  "/src/examples/gwendolen/rescue/searcherliftersmall.ail";
	   	String prop_filename =  "/src/examples/gwendolen/rescue/rescue.psl";
	   	String[] args = new String[3];
	   	args[0] = filename;
	   	args[1] = prop_filename;
	   	args[2] = "10b";
	   	AJPF_w_AIL.run(args);
	    } else {
	   	 
	    }
	 }





}
