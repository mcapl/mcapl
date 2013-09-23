package eass.mas.ros;

import org.ros.message.MessageListener;
import org.ros.node.topic.Subscriber;

import ail.syntax.Predicate;

public class EASSROSSubscriber {
	EASSNode node;
	
	public EASSROSSubscriber(String topic_name, EASSNode n) {
		node = n;
		Subscriber<std_msgs.String> subscriber =
			        node.newSubscriber(topic_name, std_msgs.String._TYPE);
	    subscriber.addMessageListener(new MessageListener<std_msgs.String>() {
	    	public void onNewMessage(std_msgs.String message) {
	    		Predicate per = new Predicate(message.getData());
				Predicate heard = new Predicate("heard");
				heard.addTerm(per);
				node.addPerceptToEnv(heard);
	    	}
	    });

	}
}
