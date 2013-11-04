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
package eass.ros.youbot;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;

import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;

import eass.mas.ros.EASSNode;

public class EASSYoubot extends EASSNode {
	KUKA kuka;
	
	public EASSYoubot() {
		super("/src/examples/eass/ros/youbot/youbot.ail");
	}
	
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/kuka_agent");
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
	}
	
	public void initialise() {
		kuka = new KUKA("youbot", this);
	}
	
	public KUKA getKUKA() {
		return kuka;
	}
	
	public void movejoint(int i, float f) {
		kuka.movejoint(i, f);
	}
	

	public class KUKA {
		String name;
		Joint[] joints = new Joint[5];
		
		public KUKA(String kukaname, EASSNode node)  {
			name = kukaname;
			
			joints[0] = new Joint(1, node);
			joints[1] = new Joint(2, node);
			joints[2] = new Joint(3, node);
			joints[3] = new Joint(4, node);
			joints[4] = new Joint(5, node);
		}
		
		public Joint getJoint(int i) {
			int newi = i - 1;
			return joints[newi];
		}
		
		public void movejoint(int i, float f) {
			getJoint(i).move(f);
		}
		
		public class Joint {
			Subscriber<control_msgs.JointControllerState> state;
			Publisher<std_msgs.Float64> command;
			int joint_num;
			
			String statestring;
			String commandstring;
			
			public Joint(int i, EASSNode node) {
				joint_num = i;
				statestring = name + "/arm_joint_" + joint_num + "position_controller/state";
				commandstring = name + "/arm_joint_" + joint_num + "position_controller/command";

				command = node.newPublisher(commandstring, std_msgs.Float64._TYPE);
				
				state = node.newSubscriber(statestring, control_msgs.JointControllerState._TYPE);
				state.addMessageListener(new MessageListener<control_msgs.JointControllerState>() { 
					public void onNewMessage(control_msgs.JointControllerState message) {
						Predicate heard = new Predicate("heard");
						Predicate position = new Predicate("state");
						position.addTerm(new NumberTermImpl(message.getP()));
						heard.addTerm(position);
						addPerceptToEnv(heard);
					};
				});
			}
			
			public void move(float angle) {
				std_msgs.Float64 c = command.newMessage();
				c.setData(angle);
				command.publish(c);
			}
		}

		}
		

}
