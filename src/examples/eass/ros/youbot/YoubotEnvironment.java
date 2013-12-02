// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.ros.youbot;

import ail.mas.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.NumberTerm;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.ros.EASSROSEnvironment;

public class YoubotEnvironment extends EASSROSEnvironment {
	String logname = "eass.ros.youbot.YoubotEnvironment";
	
	public YoubotEnvironment() {
		super();
		NActionScheduler s = new NActionScheduler(20);
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	public void eachrun() {
	}
		
	public Unifier executeAction(String agName, Action act) throws AILexception {
		   Unifier u = new Unifier();
		   String rname = rationalName(agName);
		   
		   float angle = 0.5f;
		   boolean printed = false;
		   
		   if (act.getFunctor().equals("movejoint")) {
			   ((EASSYoubot) getROSNode()).getKUKA().movejoint((int) Math.round(((NumberTerm) act.getTerm(0)).solve()), angle);
			   AJPFLogger.info(logname, agName + " done " + act);
		   } else if (act.getFunctor().equals("close_enough")) {
			   Predicate state = (Predicate) act.getTerm(0);
			   NumberTerm value = (NumberTerm) state.getTerm(0);
			   if (value.solve() > -0.5) {
				   act.getTerm(1).unifies(new Predicate("yes"), u);
			   } else {
				   act.getTerm(1).unifies(new Predicate("no"), u);
			   }
		   } else {
			   super.executeAction(agName, act);
			   printed = true;
		   }
		   
		   if (!printed) {
			   AJPFLogger.info(logname, agName + " done " + printAction(act));
		   }
		   
		   return u;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#done()
	 */
	public boolean done() {
		return false;
	}

}
