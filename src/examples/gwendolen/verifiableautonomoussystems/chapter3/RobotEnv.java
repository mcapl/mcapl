// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher 
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

package gwendolen.verifiableautonomoussystems.chapter3;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.util.AILexception;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.NumberTerm;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformIntChoice;

import java.util.Set;
import java.util.HashSet;


/**
 * Environment for a Search and Rescue Robot Scenario.  
 * 
 * 
 * @author louiseadennis
 *
 */
public class RobotEnv extends DefaultEnvironment {
	int human_x = 0;
	int human_y = 0;
	
	int searcher_x = 0;
	int searcher_y = 0;
	int lifter_x = 0;
	int lifter_y = 0;
	Literal human;

	UniformIntChoice random;
	
	String logname = "gwendolen.rescue.RobotEnv";
	
	/**
	 * Constructor.
	 */
	public RobotEnv() {
		super();
		human=new Literal("human");
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#getPercepts(java.lang.String, boolean)
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		Set<Predicate> percepts = new HashSet<Predicate>();
		int robot_x = 0;
		int robot_y = 0;
		if (agName.equals("searcher")) {
			robot_x = searcher_x;
			robot_y = searcher_y;
		} else {
			robot_x = lifter_x;
			robot_y = lifter_y;
		}

		if (robot_x == human_x && robot_y == human_y) {
			percepts.add(human);
		} 
		
		AJPFLogger.fine(logname, percepts.toString());
		return percepts;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	if (act.getFunctor().equals("move_to")) {
	   		int robot_x = (int) ((NumberTerm) act.getTerm(0)).solve();
	   		int robot_y = (int) ((NumberTerm) act.getTerm(1)).solve();
	   		
	   		if (agName.equals("searcher")) {
	   			searcher_x = robot_x;
	   			searcher_y = robot_y;
	   		} else {
	   			lifter_x = robot_x;
	   			lifter_y = robot_y;
	   		}
	   		
	   	}
	   	
	   	Unifier theta = super.executeAction(agName, act);
	   	
	   	 
    	return theta;
    }
   
   
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
   @Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		random = new UniformIntChoice(m.getController());
		human_x = random.nextInt(2);
		human_y = random.nextInt(2);
	}

}


