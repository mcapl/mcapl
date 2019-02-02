// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher and Alan Winfield
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
package pbdi.naoagent.ethical_engine;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

public class UnconstrainedBugJPFQuickTests extends TestJPF {
	 static final String[] JPF_ARGS = {  "-show" };



	  //--- driver to execute single test methods
	  public static void main(String[] args) {
	    runTestsOfThisClass(args);
	  }

	  //--- test methods
	  
	  @Test //----------------------------------------------------------------------
	  public void unconstrainedfalse() {
		  if (verifyPropertyViolation(new TypeRef("ajpf.MCAPLListener"), JPF_ARGS)) {
			  String filename =  "/src/examples/pbdi/naoagent/ethical_engine/3plan_case_unconstrained.ail";
			  String prop_filename =  "/src/examples/pbdi/naoagent/ethical_engine/ethical_nao.psl";
			  String[] args = new String[3];
			  args[0] = filename;
			  args[1] = prop_filename;
			  args[2] = "6";
			  AJPF_w_AIL.run(args);
		  }
	  }
	  
}
