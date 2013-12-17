// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package gwendolen.syntax.ast;

import java.util.ArrayList;

import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Plan;

/**
 * Class for Gwendolen Plans providing, in particular, a Gwendolen specific plan
 * constructor.
 * @author louiseadennis
 *
 */
public class Abstract_GPlan extends Abstract_Plan { 
	
	/**
	 * Construct a plan from an event, a guard and a stack of deeds.
	 * @param e
	 * @param g
	 * @param ds
	 */
	public Abstract_GPlan(Abstract_Event e, Abstract_Guard g, ArrayList<Abstract_Deed> ds) {
		setTrigger(e);
		ArrayList<Abstract_Guard> gs = new ArrayList<Abstract_Guard>();
		for (int i = 1; i < ds.size(); i++) {
			gs.add(new Abstract_Guard(new Abstract_GBelief()));
		}
		gs.add(g);
		setContext(gs);
		
		setBody(ds);
        
 		ArrayList<Abstract_Deed> prefix = new ArrayList<Abstract_Deed>();
		prefix.add(new Abstract_Deed(Abstract_Deed.Dnpy));
		setPrefix(prefix);
		
	}

}
