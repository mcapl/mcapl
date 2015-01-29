package eass.sticky_wheel.ros;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;
import org.ros.node.topic.Publisher;
import org.ros.concurrent.CancellableLoop;
import sticky_wheel.ActionStatus;

import java.util.Scanner;
import java.util.ArrayList;


public class ManualControl extends AbstractNodeMain {

	public GraphName getDefaultNodeName() {
		return GraphName.of("human/teleop");
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		final Publisher<sticky_wheel.ActionStatus> publisher =
				connectedNode.newPublisher("human/teleop", sticky_wheel.ActionStatus._TYPE);
		final Scanner in = new Scanner(System.in);
		
		connectedNode.executeCancellableLoop(new CancellableLoop() {
			protected void loop() throws InterruptedException {
				System.out.println("Send Command");
				String yn = in.nextLine();
				ActionStatus message = publisher.newMessage();				
				
				if (yn.equals("e")) {
					message.setYoubotInfo("executing");
				} else if (yn.equals("d")) {
					message.setYoubotInfo("done");
				} 
				
				publisher.publish(message);

				Thread.sleep(1000);
			}
		});
	}
	


}
