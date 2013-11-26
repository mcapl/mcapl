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

package eass.ros.pubsub;

import ail.mas.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.ros.EASSROSEnvironment;
import eass.mas.ros.EASSNode;

import org.ros.node.topic.Publisher;
import eass.ros.pubsub.ExamplePublisher;

public class PubSubEnvironment extends EASSROSEnvironment {
	String logname = "eass.ros.pubsub.PubSubEnvironment";
	
	public PubSubEnvironment() {
		super();
		NActionScheduler s = new NActionScheduler(20);
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	public void eachrun() {
	}
	
	int counter = 0;
	public Unifier executeAction(String agName, Action act) throws AILexception {
		   Unifier u = new Unifier();
			if (AJPFLogger.ltFine(logname)) {
				AJPFLogger.fine(logname, "entered executeAction PubSub " + act);
			}
		   
		   if (act.getFunctor().equals("say")) {
			   String actstring = act.getTerm(0).toString() + counter;
			   counter++;
			   ((eass.ros.pubsub.ExamplePublisher) getROSNode()).publish(actstring);
			   try {
				   Thread.sleep(5000);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
			   AJPFLogger.info(logname, agName + " done " + act);
		   } else {
			   super.executeAction(agName, act);
		   }
		   
		   return u;
	}


}
