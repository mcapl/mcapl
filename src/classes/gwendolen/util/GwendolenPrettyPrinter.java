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

import java.util.ListIterator;

import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.IntentionRow;
import ail.util.AILPrettyPrinter;

public class GwendolenPrettyPrinter extends AILPrettyPrinter {
	public String prettyIntention(Intention i) {
		String s = "";
		
		s += "Intention " + i.getID() + ": ";
		s += i.hdE().toString();
		s += " --- ";
	
	    String s1 = "";
	    boolean first = true;
	    for (Deed d : i.deeds()) {
	    	if (!first) {
	    		s1 += ";";
	    	} else {
	    		first = false;
	    	}
	    	
	    	s1 += d.toString() + s1;
	    }
	   	s+= s1;
	    return s.toString();
	}
	
	public String prettyAppPlan(ApplicablePlan p) {
		//if (nochange) {
		//	return new String("NO CHANGE");
		//} else {
			String triggers = p.getEvent().toString();
			StringBuilder s = new StringBuilder();
			s.append("Plan ");
			s.append(p.getID());
				s.append(": ");
			s.append(triggers);
			s.append(" {");
			
			if (! p.getGuard().isEmpty()) {
				Guard g = p.getGuard().get(0);
				s.append(g.toString());
			}
			s.append("} <- ");
		
			ListIterator<Deed> di = p.getPrefix().listIterator();
			//String us = p.getUnifier().toString();
		
			while (di.hasNext()) {

				Deed d = di.next();

				s.append(d.toString());
				s.append("; ");
			}
		
			return s.toString();
		//}
	}

}
