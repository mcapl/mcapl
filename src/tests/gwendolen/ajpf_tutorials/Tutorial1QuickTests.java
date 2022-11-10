// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis,  and Michael Fisher
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
package gwendolen.ajpf_tutorials;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.test.TestJPF;

public class Tutorial1QuickTests extends TestJPF {
	 static final String[] JPF_ARGS = {  };



	  //--- driver to execute single test methods
	  //public static void main(String[] args) {
	 //   runTestsOfThisClass(args);
	 // }

	  //--- test methods

	  @Test //----------------------------------------------------------------------
	  public void example () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/lifterandmedic.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "1";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  
	  /*@Test //----------------------------------------------------------------------
	  public void ex1 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex1";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }

	  @Test //----------------------------------------------------------------------
	  public void ex2 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex2";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  @Test //----------------------------------------------------------------------
	  public void ex3 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex3";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  @Test //----------------------------------------------------------------------
	  public void ex4 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex4";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  @Test //----------------------------------------------------------------------
	  public void ex5 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex5";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  @Test //----------------------------------------------------------------------
	  public void ex6 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex6";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  @Test //----------------------------------------------------------------------
	  public void ex7 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/ail_tutorials/tutorial1/answers/ex2.ail";
	    	String prop_filename =  "/src/examples/gwendolen/ajpf_tutorials/tutorial1/answers/lifterandmedic.psl";	    	
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "ex7";
	    	AJPF_w_AIL.run(args);
	 	 }
	  } */
}
