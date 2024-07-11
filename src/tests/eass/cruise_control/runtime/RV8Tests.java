// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Angelo Ferrando and  Michael Fisher 
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
package eass.cruise_control.runtime;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

public class RVTests extends TestJPF {
	 static final String[] JPF_ARGS = {};

	 //--- driver to execute single test methods
	  public static void main(String[] args) {
		  runTestsOfThisClass(args);
	  }

	  @Test //----------------------------------------------------------------------
	  public void TraceAsUnstructuredTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/trace_as_unstructured.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void BrakeOrAcclerateTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/brake_or_accelerate_verification.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void StandardSafeTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/standard_verification_safe.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void SafeOrAccelerateTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/safe_or_accelerate_verification.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void SafeOrAccelerateUnsafeTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/safe_or_accelerate_verification_unsafe.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void TwoConstraintsTest() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/two_constraints_verification_safe.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void TwoConstraintsTestUnsafe() {
		  if (verifyNoPropertyViolation(JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/two_constraints_verification_unsafe.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }

	  @Test //----------------------------------------------------------------------
	  public void StandardUnsafeTest() {
		  if (verifyPropertyViolation(new TypeRef("ajpf.MCAPLListener"), JPF_ARGS)) {
		    	String filename =  "src/examples/eass/cruise_control/runtime/standard_verification_unsafe.ail";
		    	String prop_filename =  "src/examples/eass/cruise_control/motorway.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "5";
		    	AJPF_w_AIL.run(args);
		  } else {
		    	 
		  }
	  }

}
