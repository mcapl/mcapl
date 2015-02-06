// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis and Michael Fisher 
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

package gwendolen.tutorials;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;

/**
 * This is a simple class representing a search and rescue environment on a grid.  For use 
 * with the Gwendolen Tutorials.
 * @author lad
 *
 */
public class SearchAndRescueEnv extends DefaultEnvironment {
	String logname = "gwendolen.tutorials.SearchAndRescueEnv";
	
	double rubble1_x = 5;
	double rubble1_y = 5;
	
	double rubble2_x = 3;
	double rubble2_y = 4;
	
	double rubble3_x = 0;
	double rubble3_y = 2;
	
	double siren_x = rubble3_x;
	double siren_y = rubble3_y;
	
	double allclear_x = 0;
	double allclear_y = 0;

	double robot_x = 0;
	double robot_y = 0;
	
	boolean robot_rubble1 = false;
	boolean robot_rubble2 = false;
	boolean robot_rubble3 = false;
	
	boolean warning_message = false;
	boolean nowarning_message = false;
	
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		
		if (act.getFunctor().equals("move_to")) {
			double x = ((NumberTerm) act.getTerm(0)).solve();
			double y = ((NumberTerm) act.getTerm(1)).solve();
			
			Predicate at = new Predicate("at");
			at.addTerm(new NumberTermImpl(x));
			at.addTerm(new NumberTermImpl(y));
			
			Predicate old_pos = new Predicate("at");
			old_pos.addTerm(new NumberTermImpl(robot_x));
			old_pos.addTerm(new NumberTermImpl(robot_y));
			
			removePercept(agName, old_pos);
			addPercept(agName, at);
			
			robot_x = x;
			robot_y = y;
					
			if (robot_y == rubble1_y && robot_x == rubble1_x && !robot_rubble1) {
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble1_x));
				rubble.addTerm(new NumberTermImpl(rubble1_y));
						
				addPercept(agName, rubble);
			}
					
			if (robot_y == rubble2_y && robot_x == rubble2_x && !robot_rubble2) {
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble2_x));
				rubble.addTerm(new NumberTermImpl(rubble2_y));
						
				addPercept(agName, rubble);
			}

			if (robot_y == rubble3_y && robot_x == rubble3_x && !robot_rubble3) {
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble3_x));
				rubble.addTerm(new NumberTermImpl(rubble3_y));
						
				addPercept(agName, rubble);
			}

			if (robot_y == siren_y && robot_x == siren_x) {
				Predicate warning = new Predicate("warning");
						
				warning_message = true;
				addPercept(agName, warning);
			}

			if (robot_y == allclear_y && robot_x == allclear_x) {
				Predicate warning = new Predicate("warning");
						
				nowarning_message = true;
				removePercept(agName, warning);
			}
		} if (act.getFunctor().equals("lift_rubble")) {
			if (robot_x == rubble1_x) {
				if (robot_y == rubble1_y && !robot_rubble1) {
					Predicate rubble = new Predicate("rubble");
					rubble.addTerm(new NumberTermImpl(rubble1_x));
					rubble.addTerm(new NumberTermImpl(rubble1_y));
					
					removePercept(agName, rubble);
					
					Predicate holding = new Predicate("holding");
					holding.addTerm(new Predicate("rubble"));
					addPercept(agName, holding);
					robot_rubble1 = true;
				}
			} else if (robot_x == rubble2_x) {
				if (robot_y == rubble2_y && !robot_rubble2) {
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
		} if (act.getFunctor().equals("drop")) {
			if (robot_rubble1) {
				robot_rubble1 = false;
				rubble1_x = robot_x;
				rubble1_y = robot_y;

				Predicate holding = new Predicate("holding");
				holding.addTerm(new Predicate("rubble"));
				removePercept(agName, holding);
				
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble1_x));
				rubble.addTerm(new NumberTermImpl(rubble1_y));
				
				addPercept(agName, rubble);
				
			} else if (robot_rubble2) {
				robot_rubble2 = false;
				rubble2_x = robot_x;
				rubble2_y = robot_y;

				Predicate holding = new Predicate("holding");
				holding.addTerm(new Predicate("rubble"));
				removePercept(agName, holding);
				
				Predicate rubble = new Predicate("rubble");
				rubble.addTerm(new NumberTermImpl(rubble2_x));
				rubble.addTerm(new NumberTermImpl(rubble2_y));
				
				addPercept(agName, rubble);
				
			}
		}
		super.executeAction(agName, act);
		
		if (warning_message) {
			AJPFLogger.info(logname, "Warning is Sounding");
			warning_message = false;
		}
		
		if (nowarning_message) {
			AJPFLogger.info(logname, "Warning Ceases");
			nowarning_message = false;
		}
		
		return u;
	}

}
