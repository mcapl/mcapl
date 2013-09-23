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

package eass.ros.turtlesim;

import ail.mas.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.ros.EASSROSEnvironment;
import eass.mas.ros.EASSNode;
import eass.mas.ros.EASSROSSubscriber;
import org.ros.node.ConnectedNode;

import org.ros.node.topic.Publisher;

public class TurtleEnvironment extends EASSROSEnvironment {
	String logname = "eass.ros.pubsub.TurtleEnvironment";
	
	public TurtleEnvironment() {
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

		   super.executeAction(agName, act);
		   
		   return u;
	}
	
	public class Turtle {
		Publisher<std_msgs.String> pose;
		EASSROSSubscriber command_velocity;
		String name;
		
		public Turtle(String turtlename, EASSNode node)  {
			name = turtlename;
			
			String posestring = turtlename + "/pose";
	        pose = node.newPublisher(posestring, std_msgs.String._TYPE);
			
			String command_velocity_string = turtlename + "/command_velocity";
			command_velocity = new EASSROSSubscriber(command_velocity_string, node);
		}
	}


}
