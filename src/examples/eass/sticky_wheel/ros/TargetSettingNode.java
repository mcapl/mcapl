// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and Michael Fisher 
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
package eass.sticky_wheel.ros;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;
import org.ros.node.topic.Publisher;
import org.ros.concurrent.CancellableLoop;
import sticky_wheel_msgs.ActionStatus;
import sticky_wheel_msgs.TargetInfo;

import java.util.Scanner;
import java.util.ArrayList;


public class TargetSettingNode extends AbstractNodeMain {

	public GraphName getDefaultNodeName() {
		return GraphName.of("human/teleop");
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		final Publisher<sticky_wheel_msgs.TargetInfo> publisher =
				connectedNode.newPublisher("human/teleop", sticky_wheel_msgs.TargetInfo._TYPE);
		final Scanner in = new Scanner(System.in);
		
		connectedNode.executeCancellableLoop(new CancellableLoop() {
			protected void loop() throws InterruptedException {
				TargetInfo message = publisher.newMessage();
				System.out.println("x coordinate?");
				String xs = in.nextLine();
				message.setX(Double.parseDouble(xs));
				System.out.println("y coordinate?");
				String ys = in.nextLine();
				message.setY(Double.parseDouble(ys));
				publisher.publish(message);

				Thread.sleep(1000);
			}
		});
	}

}
