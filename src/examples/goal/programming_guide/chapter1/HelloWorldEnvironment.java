// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.programming_guide.chapter1;

import ail.syntax.Action;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import goal.mas.GoalEnvironment;

public class HelloWorldEnvironment extends GoalEnvironment {
	int printcount = 0;

	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		
		
		if (act.getFunctor().equals("printText")) {
			System.out.println(act.getTerm(0));
			
			this.clearPercepts();
			
			printcount++;
			Predicate lastprintedtext = new Predicate("lastPrintedText");
			lastprintedtext.addTerm(act.getTerm(0));
			
			Predicate printedtext = new Predicate("printedText");
			printedtext.addTerm(new NumberTermImpl(printcount));
						
			addPercept(lastprintedtext);
			addPercept(printedtext);
		}
		
		return super.executeAction(agName, act);
	}
}
