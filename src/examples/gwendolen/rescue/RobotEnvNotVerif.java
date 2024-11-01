// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher 
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

package gwendolen.rescue;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.syntax.*;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifySet;
import ajpf.util.choice.UniformBoolChoice;
import gov.nasa.jpf.annotation.FilterField;

import java.util.Set;

/**
 * Verification Environment for a Trash Robot Scenario;
 * 
 * @author louiseadennis
 *
 */
public class RobotEnvNotVerif extends DefaultEnvironment {
	double searcher_x = 0;
	double searcher_y = 0;

	double lifter_x = 0;
	double lifter_y = 0;

	double human_x = 2;
	double human_y = 2;

	boolean withlifter = false;
	boolean withlifter2 = false;
	boolean withsearcher = true;
	Literal human;
	Literal clear;

	String logname = "gwendolen.rescue.RobotEnv";

	public RobotEnvNotVerif() {
		super();
		human=new Literal("human");
		clear = new Literal("clear");
	}

	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();
	   	AJPFLogger.info("gwendolen.rescue.RobotEnv", agName + " done " + printAction(act));

	   if (act.getFunctor().equals("move_to")) {
		   double x = ((NumberTerm) act.getTerm(0)).solve();
		   double y = ((NumberTerm) act.getTerm(1)).solve();

		   Predicate at = new Predicate("at");
		   at.addTerm(new NumberTermImpl(x));
		   at.addTerm(new NumberTermImpl(y));

		   Predicate old_pos = new Predicate("at");

		   if (agName == "r") {
			   old_pos.addTerm(new NumberTermImpl(searcher_x));
			   old_pos.addTerm(new NumberTermImpl(searcher_y));
			   searcher_x = x;
			   searcher_y = y;
		   } else {
			   old_pos.addTerm(new NumberTermImpl(lifter_x));
			   old_pos.addTerm(new NumberTermImpl(lifter_y));
			   lifter_x = x;
			   lifter_y = y;
		   }

		   removePercept(agName, old_pos);
		   addPercept(agName, at);

		   if (x == human_x && y == human_y) {
			   addPercept(agName, human);
		   }
	   } else if (act.getFunctor().equals(("lift"))) {
			addPercept(agName, clear);
	   }

	   theta = super.executeAction(agName, act);
 
    	return theta;
    }


	public void configure(AILConfig configuration) {
		super.configure(configuration);
		
		if (configuration.containsKey("withsearcher")) {
			withsearcher = Boolean.valueOf((String) configuration.get("withsearcher"));
		}
		if (configuration.containsKey("withlifter")) {
			withlifter = Boolean.valueOf((String) configuration.get("withlifter"));
		}
		if (configuration.containsKey("withlifter2")) {
			withlifter2 = Boolean.valueOf((String) configuration.get("withlifter2"));
		}
	} 

}


