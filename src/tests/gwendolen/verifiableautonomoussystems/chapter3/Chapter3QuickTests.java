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

package gwendolen.verifiableautonomoussystems.chapter3;

import org.junit.Test;

import com.sun.istack.internal.logging.Logger;

import ail.util.AJPF_w_AIL;
import ail.mas.AIL;
import gov.nasa.jpf.util.test.TestJPF;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.StreamHandler;

/**
 * Simple test that an auction example works.
 */
public class Chapter3QuickTests extends TestJPF {

  static final String[] JPF_ARGS = {  "-show" 
  };

  // General framework for testing print statements.  Stolen from stackOverflow.
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private PrintStream systemStdOut = System.out;
  
  private PrintStream systemErrOut = System.err;
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
      //System.setErr(new PrintStream(errContent));
  }

  public void cleanUpStreams() {
      System.setOut(systemStdOut);
      //System.setErr(systemErrOut);
  }

  //--- driver to execute single test methods
  public static void main(String[] args) {
    runTestsOfThisClass(args);
  }

  //--- test methods

 
  @Test //----------------------------------------------------------------------
  public void example_3_11 () {
	  setUpStreams();
	  AIL.runAIL("/src/examples/gwendolen/verifiableautonomoussystems/chapter3/example_3_11.ail");
	  assertEquals("done\n", outContent.toString());
	  cleanUpStreams();
  }
  
  @Test //----------------------------------------------------------------------
  public void example_3_12 () {
	  PrintStream errPrintStream = new PrintStream(errContent);
	  System.setErr(errPrintStream);
	  java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");
	  logger.addHandler(new ConsoleHandler());
	  // System.err.println("content 1");
	  AIL.runAIL("/src/examples/gwendolen/verifiableautonomoussystems/chapter3/example_3_12.ail");
	  // System.err.println("some content");
	  String s = errContent.toString();
	  assertEquals("ag1 done send(2:take(ag1,block), ag2) \nag2 done send(1:take(ag2,block), ag1) \n", s);
	  System.setErr(systemErrOut);
  }
  
  @Test //----------------------------------------------------------------------
  public void example_3_13() {
	  PrintStream errPrintStream = new PrintStream(errContent);
	  System.setErr(errPrintStream);
	  java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");
	  logger.addHandler(new ConsoleHandler());
	  // System.err.println("content 1");
	  AIL.runAIL("/src/examples/gwendolen/verifiableautonomoussystems/chapter3/example_3_13.ail");
	  // System.err.println("some content");
	  String s = errContent.toString();
	  assertTrue(s.contains("searcher done move_to(0,0)"));
	  assertTrue(s.contains("lifter done lift(human)"));
	  System.setErr(systemErrOut);
  }
  
  private class NoFlushPrintStream extends PrintStream {
	  public NoFlushPrintStream(ByteArrayOutputStream s) {
		  super(s);
	  }
	  
	  @Override
	  public void flush() {
		  
	  }
	  
	  public void close() {
		  
	  }
	  
  }
  

}
