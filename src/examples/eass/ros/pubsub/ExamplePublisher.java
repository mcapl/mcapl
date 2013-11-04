package eass.ros.pubsub;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import eass.mas.ros.EASSNode;

public class ExamplePublisher extends EASSNode {
	Publisher<std_msgs.String> publisher;

	public ExamplePublisher() {
		super("/src/examples/eass/ros/pubsub/publisher.ail");
	}
	
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/publisher");
	}

	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
	}
	
	public void initialise() {
		publisher = newPublisher("chatter", std_msgs.String._TYPE);		
	}
	
	public void publish(String s) {
		std_msgs.String message = publisher.newMessage();
		message.setData(s);
		publisher.publish(message);
	}

}
