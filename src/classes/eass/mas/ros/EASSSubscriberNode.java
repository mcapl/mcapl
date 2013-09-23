package eass.mas.ros;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;

import ail.syntax.Predicate;

import ajpf.util.AJPFLogger;

public class EASSSubscriberNode extends EASSNode {
	String topic_name;
	Subscriber<std_msgs.String> subscriber;
	String logname = "eass.mas.ros.EASSSubscriberNode";
	
	public EASSSubscriberNode(String s, String fp) {
		super(fp);
		topic_name = s;
	}

	@Override
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/listener");
	}
		
	  public void onStart(final ConnectedNode connectedNode) {
		  subscriber =
		        connectedNode.newSubscriber(topic_name, std_msgs.String._TYPE);
		  subscriber.addMessageListener(new MessageListener<std_msgs.String>() {
			      @Override
			      public void onNewMessage(std_msgs.String message) {
			    	  Predicate per = new Predicate(message.getData());
			    	  Predicate heard = new Predicate("heard");
			    	  heard.addTerm(per);
			    	  addPerceptToEnv(heard);
			      }
			    });
		  super.onStart(connectedNode);
	  }

}
