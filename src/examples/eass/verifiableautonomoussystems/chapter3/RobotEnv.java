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

package eass.verifiableautonomoussystems.chapter3;

import ail.mas.DefaultEnvironment;
import ail.util.AILexception;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.SendAction;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Environment for a very simple search and rescue robot scenario.
 * 
 * WARNING: This environment can not be used with record and replay because of the use of Random.
 * 
 * @author louiseadennis
 *
 */
public class RobotEnv extends DefaultEnvironment {
	// Initial position of robot (off the grid).
	int robot_x = -1;
	int robot_y = -1;
	int human_x;
	int human_y;
	boolean changer = true;
	@FilterField
	boolean canseehumanr = false;
	Literal human;

	Random random = new Random();
	
	String logname = "gwendolen.rescue.RobotEnv";
	
	/**
	 * Constructor.
	 */
	public RobotEnv() {
		super();
		human=new Literal("human");
		human_x = random.nextInt(3);
		human_y = random.nextInt(3);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#getPercepts(java.lang.String, boolean)
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		Set<Predicate> percepts = new HashSet<Predicate>();
		if (agName.equals("searcher")) {
			if (robot_x == human_x && robot_y == human_y) {
					canseehumanr = true;
			}
			if (canseehumanr) {
				percepts.add(human);
			}
			changer = false;
		
		} 

		return percepts;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();
	   	if (act instanceof SendAction) {
	   		theta = super.executeAction(agName, act);
	   	} else if (act.getFunctor().equals("move_to")){
	   		robot_x = (int) ((NumberTerm) act.getTerm(0)).solve();
	   		robot_y = (int) ((NumberTerm) act.getTerm(1)).solve();
	   		AJPFLogger.info("gwendolen.easss_tutorial.RobotEnv", agName + " done " + printAction(act));
	   	} else {
	   		AJPFLogger.info("gwendolen.easss_tutorial.RobotEnv", agName + " done " + printAction(act));
	   	}
	   	
	   	change_for(agName);
	   	 
    	return theta;
    }
   
   /**
    * Indicates that percepts for a particular robot may have changed.
    * @param name
    */
   public void change_for(String name) {
	   if (name.equals("searcher")) {
		   changer = true;
	   } 
   }
   
 
}


