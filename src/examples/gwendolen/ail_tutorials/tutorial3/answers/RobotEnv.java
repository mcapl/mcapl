// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, Michael Fisher 
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

package gwendolen.ail_tutorials.tutorial3.answers;

import ail.mas.DefaultEnvironmentwRandomness;
import ail.mas.MAS;
import ail.syntax.Action;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.choice.Choice;

/**
 * Environment for a Search and Rescue Robot Scenario with a randomly moving human.
 * 
 * @author louiseadennis
 *
 */
public class RobotEnv extends DefaultEnvironmentwRandomness implements MCAPLJobber {
	int human_x = 1;
	int human_y = 1;
	// The directions the human may move in.
	private enum direction {
		NORTHWEST, NORTH, NORTHEAST, WEST, UNMOVED, EAST, SOUTHWEST, SOUTH, SOUTHEAST
	}
	public Choice<direction> direction_choice;
	
	/**
	 * Constructor.
	 */
	public RobotEnv() {
		super();
		getScheduler().addJobber(this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	@Override
	public void do_job() {
		direction human_move = direction_choice.get_choice();
		
		// We assume the 3x3 grid wraps so the human appears on the far side if its x or y coordinates are above 2 or below 0.
		switch (human_move) {
		case NORTHWEST:	
			human_x = ((human_x - 1) % 3);
			human_y = ((human_y + 1) % 3);
			return;
		case NORTH:
			human_y = ((human_y + 1) % 3);
			return;
		case NORTHEAST:
			human_x = ((human_x + 1) % 3);
			human_y = ((human_y + 1) % 3);
			return;
		case WEST:
			human_x = ((human_x - 1) % 3);
			return;
		case EAST:
			human_x = ((human_x + 1) % 3);
			return;
		case SOUTHWEST:	
			human_x = ((human_x - 1) % 3);
			human_y = ((human_y - 1) % 3);
			return;
		case SOUTH:
			human_y = ((human_y - 1) % 3);
			return;
		case SOUTHEAST:
			human_x = ((human_x + 1) % 3);
			human_y = ((human_y - 1) % 3);
			return;
		default:
		}
		
		if (human_x < 0) {
			human_x = 3 + human_x;
		}
		if (human_y < 0) {
			human_y = 3 + human_y;
		}
		
		System.err.println("Human at (" + human_x + ", " + human_y + ")");
		getScheduler().perceptChanged();
			
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	@Override
	public String getName() {
		return "gwendolen.ail_tutorials.tutorial3.RobotEnv";
	}   

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("move_to")) {
			Predicate robot_position = new Predicate("at");
			Predicate old_position = new Predicate("at");
			robot_position.addTerm(act.getTerm(0));
			robot_position.addTerm(act.getTerm(1));
			old_position.addTerm(new VarTerm("X"));
			old_position.addTerm(new VarTerm("Y"));
			removeUnifiesPercept(old_position);
			addPercept(robot_position);
			// If the robot is in the same square as the human it finds them.
			if (((NumberTerm) act.getTerm(0)).solve() == human_x && ((NumberTerm) act.getTerm(1)).solve() == human_y ) {
				addPercept(new Predicate("human"));
			}
		}
		return super.executeAction(agName, act);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironmentwRandomness#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		// Setting up the probability distribution.  The human has a 40% chance of staying on the spot
		direction_choice = new Choice<direction>(m.getController());
		// A 10% chance of moving North, South, East or West
		direction_choice.addChoice(0.4, direction.UNMOVED);
		direction_choice.addChoice(0.1, direction.NORTH);
		direction_choice.addChoice(0.1, direction.EAST);
		direction_choice.addChoice(0.1, direction.WEST);
		direction_choice.addChoice(0.1, direction.SOUTH);
		// And a 5% chance of moving in one of the diagonal directions.
		direction_choice.addChoice(0.05, direction.NORTHWEST);
		direction_choice.addChoice(0.05, direction.NORTHEAST);
		direction_choice.addChoice(0.05, direction.SOUTHWEST);
		direction_choice.addChoice(0.05, direction.SOUTHEAST);
		
	}
      
}



