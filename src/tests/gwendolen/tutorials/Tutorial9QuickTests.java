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

package gwendolen.tutorials;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import ail.mas.AIL;
import gov.nasa.jpf.util.test.TestJPF;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Simple test that an auction example works.
 */
public class Tutorial9QuickTests extends TestJPF {

  static final String[] JPF_ARGS = {  "-show" 
  };

  // General framework for testing print statements.  Stolen from stackOverflow.
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private PrintStream systemStdOut = System.out;
  
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
  }

  public void cleanUpStreams() {
      System.setOut(systemStdOut);
  }

  //--- driver to execute single test methods
  public static void main(String[] args) {
    runTestsOfThisClass(args);
  }

  //--- test methods

 
  @Test //----------------------------------------------------------------------
  public void string_w_space () {
	  setUpStreams();
	  AIL.runAIL("/src/examples/gwendolen/tutorials/tutorial9/strings.ail");
	  assertEquals("hello world\n", outContent.toString());
	  cleanUpStreams();
  }
  
  @Test //----------------------------------------------------------------------
  public void ex2 () {
    if (verifyNoPropertyViolation(JPF_ARGS)){
    	String filename =  "/src/examples/gwendolen/tutorials/tutorial9/answers/arithmetic.ail";
    	String prop_filename =  "/src/tests/gwendolen/tutorials/tutorial_props.psl";
    	String[] args = new String[3];
    	args[0] = filename;
    	args[1] = prop_filename;
    	args[2] = "9";
    	AJPF_w_AIL.run(args);
 	 }
  }

  @Test //----------------------------------------------------------------------
  public void ex3 () {
	  setUpStreams();
	  AIL.runAIL("/src/examples/gwendolen/tutorials/tutorial9/answers/equation.ail");
	  String expectedOutput = "3 is less than 5\n3 is less than 4.8\n3 is equal to 3\n4.8 is less than 5\n3 is less than 5\n3 is less than 4.8\n";
	  assertEquals(expectedOutput, outContent.toString());
	  cleanUpStreams();

  }

}
