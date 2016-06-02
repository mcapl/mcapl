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

package gwendolen.ail_tutorials.tutorial3;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILexception;
import ajpf.MCAPLJobber;

/**
 * Environment for a Search and Rescue Robot Scenario.
 * 
 * @author louiseadennis
 *
 */
public class RobotEnv extends DefaultEnvironment implements MCAPLJobber {
	
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
		addPercept(new Predicate("human"));
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
		}
		return super.executeAction(agName, act);
	}
      
}



