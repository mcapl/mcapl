// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis and Michael Fisher 
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

package gwendolen.ail_tutorials.tutorial2.answers;

import ail.mas.DefaultEnvironment;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.util.AILexception;

public class LuckyDipEnv extends DefaultEnvironment {
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		
		// The toy can be found in the green bin
		if (act.getFunctor().equals("search")) {
			Predicate bin = (Predicate) act.getTerm(0);
			if (bin.getFunctor().equals("green")) {
				Predicate toy = new Predicate("toy");
				toy.unifies(act.getTerm(1), u);
			} else {
				Predicate book = new Predicate("book");
				book.unifies(act.getTerm(1), u);				
			}
		} else if (act.getFunctor().equals("drop")) {
			Predicate object = (Predicate) act.getTerm(0);
			Predicate see = new Predicate("see");
			see.addTerm(object);
			addPercept(agName, see);
		}
		
		super.executeAction(agName, act);
		return u;
	}
}
