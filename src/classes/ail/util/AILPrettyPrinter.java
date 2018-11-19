// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
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
package ail.util;

import ail.syntax.Intention;
import ail.syntax.IntentionRow;

public class AILPrettyPrinter {
	
	public String prettyIntention(Intention i) {
		String s = "";
	    if (i.suspended()) {
	   	 s += "SUSPENDED\n";
	    }
	    s += i.getSource().toString() + ":: ";
	    if (i.getAnnotation() != null) {
	   	 	s += i.getAnnotation().toString();
	    }
	    s+="\n";
	
	    String s1 = "";
	    for (IntentionRow ir : i.getRows()) {
	    	s1 = "   *  " + ir.toString() + s1;
	    }
	   	s+= s1;
	    return s.toString();
	}


}
