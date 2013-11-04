// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis and Michael Fisher
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

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;
import geometry_msgs.Twist;
import geometry_msgs.Point;
import geometry_msgs.Quaternion;
import geometry_msgs.Vector3;

import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;

import eass.mas.ros.EASSNode;

public class EASSTurtle extends EASSNode {
	Turtle turtle;
	
	public EASSTurtle() {
		super("/src/examples/eass/ros/turtlesim/turtle.ail");
	}
	
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/turtle_agent");
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
	}
	
	public void initialise() {
		turtle = new Turtle("turtle1", this);
	}
	
	public Turtle getTurtle() {
		return turtle;
	}
	

	public class Turtle {
		Subscriber<geometry_msgs.Pose> pose;
		Publisher<geometry_msgs.Twist> command_velocity;
		String name;
		
		public Turtle(String turtlename, EASSNode node)  {
			name = turtlename;
			
			String posestring = turtlename + "/pose";
			String command_velocity_string = turtlename + "/command_velocity";

			command_velocity = node.newPublisher(command_velocity_string, geometry_msgs.Twist._TYPE);
			
			pose = node.newSubscriber(posestring, geometry_msgs.Pose._TYPE);
			pose.addMessageListener(new MessageListener<geometry_msgs.Pose>() { 
				public void onNewMessage(geometry_msgs.Pose message) {
					Predicate heard = new Predicate("heard");
					Predicate position = new Predicate("pose");
					Point p = message.getPosition();
					position.addTerm(new NumberTermImpl(p.getX()));
					position.addTerm(new NumberTermImpl(p.getY()));
					heard.addTerm(position);
					addPerceptToEnv(heard);
				};
			});
		}
		
		public void send(float angular, float linear) {
			Twist v = command_velocity.newMessage();
			v.getAngular().setZ(angular);
			v.getLinear().setX(linear);
			command_velocity.publish(v);
		}
	}


}
