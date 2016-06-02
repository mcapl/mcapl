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

package gwendolen.ail_tutorials.tutorial1;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.util.AILexception;

/**
 * This is a simple class representing a search and rescue environment on a grid.  For use 
 * with the Gwendolen Tutorials.
 * @author lad
 *
 */
public class SearchAndRescueMASEnv extends DefaultEnvironment {
	String logname = "gwendolen.tutorials.SearchAndRescueEnv";
	
	double rubble1_x = 5;
	double rubble1_y = 5;
	
	double human1_x = 5;
	double human1_y = 5;
	
	double human2_x = 3;
	double human2_y = 4;

	double rubble2_x = 3;
	double rubble2_y = 4;

	double allclear_x = 0;
	double allclear_y = 0;

	double robot1_x = 0;
	double robot1_y = 0;
	
	double robot2_x = 0;
	double robot2_y = 0;
	
	double robot3_x = 0;
	double robot3_y = 0;

	boolean robot_rubble1 = false;
	boolean robot_rubble2 = false;
		
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		
		if (act.getFunctor().equals("move_to")) {
			double x = ((NumberTerm) act.getTerm(0)).solve();
			double y = ((NumberTerm) act.getTerm(1)).solve();
			
			Predicate at = new Predicate("at");
			at.addTerm(new NumberTermImpl(x));
			at.addTerm(new NumberTermImpl(y));
			
			Predicate old_pos = new Predicate("at");
			
			double robot_x;
			double robot_y;
			double new_robot_x;
			double new_robot_y;
			if (agName.equals("lifter")) {
				robot_x = robot1_x;
				robot_y = robot1_y;
				robot1_x = x;
				robot1_y = y;
				new_robot_x = x;
				new_robot_y = y;
			} else if (agName.equals("medic")) {
				robot_x = robot2_x;
				robot_y = robot2_y;
				robot2_x = x;
				robot2_y = y;
				new_robot_x = x;
				new_robot_y = y;
			} else {
				robot_x = robot3_x;
				robot_y = robot3_y;
				robot3_x = x;
				robot3_y = y;
				new_robot_x = x;
				new_robot_y = y;
			}

			
			old_pos.addTerm(new NumberTermImpl(robot_x));
			old_pos.addTerm(new NumberTermImpl(robot_y));
			
			removePercept(agName, old_pos);
			addPercept(agName, at);
			
					
			if (new_robot_y == rubble1_y && new_robot_x == rubble1_x && !robot_rubble1) {
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble1_x));
				rubble.addTerm(new NumberTermImpl(rubble1_y));
						
				addPercept(agName, rubble);
			}
					
			if (new_robot_y == rubble2_y && new_robot_x == rubble2_x && !robot_rubble2) {
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble2_x));
				rubble.addTerm(new NumberTermImpl(rubble2_y));
						
				addPercept(agName, rubble);
			}

			if (new_robot_y == human1_y && new_robot_x == human1_x ) {
				Predicate rubble = new Predicate("human");
				rubble.addTerm(new NumberTermImpl(human1_x));
				rubble.addTerm(new NumberTermImpl(human1_y));
						
				addPercept(agName, rubble);
			}

			if (new_robot_y == human2_y && new_robot_x == human2_x ) {
				Predicate rubble = new Predicate("human");
				rubble.addTerm(new NumberTermImpl(human2_x));
				rubble.addTerm(new NumberTermImpl(human2_y));
						
				addPercept(agName, rubble);
			}

		} if (act.getFunctor().equals("lift_rubble")) {
			if (agName.equals("lifter")) {
				if (robot1_x == rubble1_x) {
					if (robot1_y == rubble1_y && !robot_rubble1) {
						Predicate rubble = new Predicate("rubble");
						rubble.addTerm(new NumberTermImpl(rubble1_x));
						rubble.addTerm(new NumberTermImpl(rubble1_y));
					
						removePercept(agName, rubble);
					
						Predicate holding = new Predicate("holding");
						holding.addTerm(new Predicate("rubble"));
						addPercept(agName, holding);
						robot_rubble1 = true;
					}
				} else if (robot1_x == rubble2_x) {
					if (robot1_y == rubble2_y && !robot_rubble2) {
						Predicate rubble = new Predicate("rubble");
						rubble.addTerm(new NumberTermImpl(rubble2_x));
						rubble.addTerm(new NumberTermImpl(rubble2_y));
					
						removePercept(agName, rubble);
					
						Predicate holding = new Predicate("holding");
						holding.addTerm(new Predicate("rubble"));
						addPercept(agName, holding);
						robot_rubble2 = true;
					}
				}
			}
		} if (act.getFunctor().equals("drop")) {
			if (agName.equals("lifter")) {
				if (robot_rubble1) {
					robot_rubble1 = false;
					rubble1_x = robot1_x;
					rubble1_y = robot1_y;

					Predicate holding = new Predicate("holding");
					holding.addTerm(new Predicate("rubble"));
					removePercept(agName, holding);
				
					Predicate rubble = new Predicate("rubble");
					rubble.addTerm(new NumberTermImpl(rubble1_x));
					rubble.addTerm(new NumberTermImpl(rubble1_y));
				
					addPercept(agName, rubble);
				
				} else if (robot_rubble2) {
					robot_rubble2 = false;
					rubble2_x = robot1_x;
					rubble2_y = robot1_y;

					Predicate holding = new Predicate("holding");
					holding.addTerm(new Predicate("rubble"));
					removePercept(agName, holding);
				
					Predicate rubble = new Predicate("rubble");
					rubble.addTerm(new NumberTermImpl(rubble2_x));
					rubble.addTerm(new NumberTermImpl(rubble2_y));
				
					addPercept(agName, rubble);
				}
			}
		} if (act.getFunctor().equals("assist")) {
			if (agName.equals("medic")) {
				if (robot2_x == human1_x) {
					if (robot2_y == human1_y) {
						Predicate rubble = new Predicate("human");
						rubble.addTerm(new NumberTermImpl(human1_x));
						rubble.addTerm(new NumberTermImpl(human1_y));
					
						removePercept(agName, rubble);
					}
				} else if (robot2_x == human2_x) {
					if (robot2_y == human2_y) {
						Predicate rubble = new Predicate("human");
						rubble.addTerm(new NumberTermImpl(human2_x));
						rubble.addTerm(new NumberTermImpl(human2_y));
					
						removePercept(agName, rubble);
					}
				} 

			} else if (agName.equals("medic2")) {
				if (robot3_x == human1_x) {
					if (robot3_y == human1_y) {
						Predicate rubble = new Predicate("human");
						rubble.addTerm(new NumberTermImpl(human1_x));
						rubble.addTerm(new NumberTermImpl(human1_y));
					
						removePercept(agName, rubble);
					}
				} else if (robot3_x == human2_x) {
					if (robot3_y == human2_y) {
						Predicate rubble = new Predicate("human");
						rubble.addTerm(new NumberTermImpl(human2_x));
						rubble.addTerm(new NumberTermImpl(human2_y));
					
						removePercept(agName, rubble);
					}
				} 
			}
		}

		
		super.executeAction(agName, act);
				
		return u;
	}

}
