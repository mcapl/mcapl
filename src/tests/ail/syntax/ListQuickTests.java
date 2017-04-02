// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, and  Michael Fisher 
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

package ail.syntax;

import junit.framework.Assert;

import org.junit.Test;

public class ListQuickTests {
	
	@Test public void consTest() {
		ListTermImpl list = new ListTermImpl();
		list.setTail(new ListTermImpl());
		list.setHead(new Predicate("red"));
		list.cons(new Predicate("green"));
		list.cons(new Predicate("green"));
		list.cons(new Predicate("blue"));

		Assert.assertTrue(list.getHead().getFunctor().equals("blue"));
		Assert.assertTrue(list.getTail().getHead().getFunctor().equals("green"));
		Assert.assertTrue(list.getTail().getTail().getHead().getFunctor().equals("green"));
		Assert.assertTrue(list.getTail().getTail().getTail().getHead().getFunctor().equals("red"));
	}
	
	@Test public void varTailTest() {
		ListTermImpl list = new ListTermImpl();
		list.setTail(new VarTerm("T"));
		list.setHead(new Predicate("e"));
		Assert.assertFalse(list.isGround());
	}

}
