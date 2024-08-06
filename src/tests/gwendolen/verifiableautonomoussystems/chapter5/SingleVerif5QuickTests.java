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

package gwendolen.verifiableautonomoussystems.chapter5;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;


/**
 * Simple test that an auction example works.
 */
public class SingleVerif5QuickTests extends TestJPF {

  static final String[] JPF_ARGS = {  "-show" 
  };



  //--- driver to execute single test methods
  public static void main(String[] args) {
    runTestsOfThisClass(args);
  }

  //--- test methods

 
  @Test //----------------------------------------------------------------------
  public void prop5 () {
	  if (verifyPropertyViolation(new TypeRef("ajpf.MCAPLListener"), JPF_ARGS)){
		  String filename =  "/src/examples/gwendolen/verifiableautonomoussystems/chapter5/car1_verif.ail";
		  String prop_filename =  "/src/examples/gwendolen/verifiableautonomoussystems/chapter5/cars.psl";
		  String[] args = new String[3];
		  args[0] = filename;
		  args[1] = prop_filename;
		  args[2] = "5";
		  AJPF_w_AIL.run(args);
	  }
  }   
  
}
