// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher and Vincent Koeman
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
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package gwendolen.util;

import ail.syntax.Deed;
import ail.syntax.Intention;
import ail.syntax.IntentionRow;
import ail.util.AILPrettyPrinter;

public class GwendolenPrettyPrinter extends AILPrettyPrinter {
	public String prettyIntention(Intention i) {
		String s = "";
		//s += "GWENDOLEN INTENTION";
	    //if (i.suspended()) {
	   	// s += "SUSPENDED\n";
	    //}
	    //s += i.getSource().toString() + ":: ";
	    //if (i.getAnnotation() != null) {
	   	// 	s += i.getAnnotation().toString();
	    //}
	    //s+="\n";
		
		s += i.hdE().toString();
		s += "||";
	
	    String s1 = ".";
	    for (Deed d : i.deeds()) {
	    	s1 = ";  " + d.toString() + s1;
	    }
	   	s+= s1;
	    return s.toString();
	}

}
