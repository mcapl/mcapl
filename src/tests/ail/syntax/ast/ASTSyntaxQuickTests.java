// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax.ast;

import org.junit.Test;
import org.junit.Assert;

import ail.syntax.ListTerm;


public class ASTSyntaxQuickTests {
	
	/*
	 * Test that literal hashes and equality are behaving sensible.
	 */
	@Test public void Abstract_ListTermTest() {

		Abstract_ListTermImpl list1 = new Abstract_ListTermImpl();
		list1.append(new Abstract_Predicate("term"));
		
		
		Abstract_ListTermImpl list2 = new Abstract_ListTermImpl();
		list2.append(new Abstract_Predicate("term"));
		
		ListTerm l1 = list1.toMCAPL();
		ListTerm l2 = list2.toMCAPL();
		
		
		Assert.assertTrue(l1.equals(l2));
		
	}
	


}
