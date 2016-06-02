// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and Michael Fisher 
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

package actiononly.goal;

import java.util.Iterator;

import actiononly.mas.ActionOnlyEnv;
import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.NumberTerm;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.util.AILexception;

/**
 * A Very simple environment that chooses among agent capabilities (assumed to be moves) by calculating the 
 * distance to some goal location.
 * @author lad
 *
 */
public class GoalEnv extends DefaultEnvironment implements ActionOnlyEnv {
	// Goal location is hard coded in, not extracted from the agent.
	int target_x = 2;
	int target_y = 4;

	/*
	 * (non-Javadoc)
	 * @see actiononly.mas.ActionOnlyEnv#selectAction(java.util.Iterator, java.lang.String)
	 */
	public Action selectAction(Iterator<Capability> ic, String agName) {
		Action current_action = new Action("do_nothing");
		double distance = 32;
		
		while (ic.hasNext()) {
			Action a = new Action(ic.next().getCap(), Action.normalAction);
			double x = ((NumberTerm) a.getTerm(0)).solve();
			double y = ((NumberTerm) a.getTerm(1)).solve();
			
			double a_distance = (target_x - x)*(target_x - x) + (target_y - y)*(target_y - y);
			if (a_distance < distance) {
				distance = a_distance;
				current_action = a;
			}
		}

		return current_action;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action a) throws AILexception {
		
		Literal position = new Literal("at");
		position.addTerm(a.getTerm(0));
		position.addTerm(a.getTerm(1));
		
		clearPercepts();
		addPercept(position);
		
		return super.executeAction(agName, a);
	}

}
