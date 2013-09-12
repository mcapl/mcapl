package eass.mas.ros;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import ajpf.util.AJPFLogger;

public class EASSPublisherNode extends EASSNode {
	String topic_name;
	Publisher<std_msgs.String> publisher;
	String logname = "eass.mas.ros.EASSPublisherNode";
	
	public EASSPublisherNode(String s, String fp) {
		super(fp);
		topic_name = s;
	}

	@Override
	public GraphName getDefaultNodeName() {
	    return GraphName.of("eass_ros/publisher");
	}
	
	public void publish(String s) {
		if (publisher == null) {
			AJPFLogger.warning(logname, "publisher is null");
		} else {
            std_msgs.String str = publisher.newMessage();
            str.setData(s);
            publisher.publish(str);
		}
		
	}
	
	  public void onStart(final ConnectedNode connectedNode) {
		  publisher =
		        connectedNode.newPublisher(topic_name, std_msgs.String._TYPE);
		  super.onStart(connectedNode);
	  }

}
