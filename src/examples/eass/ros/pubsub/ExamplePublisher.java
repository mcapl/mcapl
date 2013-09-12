package eass.ros.pubsub;

import eass.mas.ros.EASSPublisherNode;

public class ExamplePublisher extends EASSPublisherNode {

	public ExamplePublisher() {
		super("chatter", "/src/examples/eass/ros/pubsub/publisher.ail");
	}
}
