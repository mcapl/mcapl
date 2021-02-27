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

package gwendolen.failuredetection;

import ail.mas.AIL;
import org.junit.Test;


/**
 * Test for goal dropping behaviour - basically all this has to do is terminate!
 */
public class SimpleQuickTests {

   
  @Test //----------------------------------------------------------------------
  public void testDroppingNonExistantGoals () {
	  String filename =  "/src/examples/gwendolen/simple/DroppingGoals/DroppingNonExistantGoals.ail";
	  AIL.runAIL(filename);
  }
  
  



}
