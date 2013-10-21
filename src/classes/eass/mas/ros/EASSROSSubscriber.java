package eass.mas.ros;

import org.ros.message.MessageListener;
import org.ros.node.topic.Subscriber;

import ail.syntax.Predicate;

public class EASSROSSubscriber<T> {
	EASSNode node;
	Subscriber<T> subscriber;
	
	public EASSROSSubscriber(String topic_name, EASSNode n, String msg_type) {
		node = n;
		subscriber =
			        node.newSubscriber(topic_name, msg_type);
	}
	
	public void addMessageListener(MessageListener<T> listener) {
		subscriber.addMessageListener(listener);
	}
}
