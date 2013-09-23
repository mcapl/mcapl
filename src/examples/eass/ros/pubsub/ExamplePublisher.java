package eass.ros.pubsub;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;

import eass.mas.ros.EASSNode;

public class ExamplePublisher extends EASSNode {

	public ExamplePublisher() {
		super("/src/examples/eass/ros/pubsub/publisher.ail");
	}
	
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/publisher");
	}

	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
		newActionTopic("chatter");
	}

}
