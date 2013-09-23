package eass.ros.pubsub;

import eass.mas.ros.EASSSubscriberNode;

public class ExampleSubscriber extends EASSSubscriberNode {

	public ExampleSubscriber() {
		super("chatter", "/src/examples/eass/ros/pubsub/subscriber.ail");
	}
}
