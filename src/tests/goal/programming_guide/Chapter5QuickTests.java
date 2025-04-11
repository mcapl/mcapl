// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.programming_guide;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

public class Chapter5QuickTests extends TestJPF {
	 static final String[] JPF_ARGS = {  "-show" };

	 @Test //----------------------------------------------------------------------
	  public void stackbuilder () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/goal/programming_guide/chapter5/stackBuilder.ail";
	    	String prop_filename =  "/src/examples/goal/programming_guide/chapter5/stack.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "1";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }


}
