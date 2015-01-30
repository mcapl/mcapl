package eass.sticky_wheel.ros;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.exception.RemoteException;
import org.ros.message.MessageListener;
import org.ros.node.topic.Subscriber;
import org.ros.node.topic.Publisher;
import sticky_wheel_msgs.*;

import eass.mas.ros.EASSNode;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;

public class StickyWheelAgentNode extends EASSNode {
	Publisher<sticky_wheel_msgs.ActionInfo> outTopic;

	public StickyWheelAgentNode(String configfile) {
        super(configfile);
	}

	public GraphName getDefaultNodeName() {
        return GraphName.of("sticky_wheel/sticky_wheel_agent");
	}

	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
	}
	
    public void initialise(String target_topic, String status_topic, String position_topic, String command_topic, int count_max) {
    	((StickyWheelROSEnvironment) getEnv()).setCountMax(count_max);
    	
    	outTopic = newPublisher(command_topic, sticky_wheel_msgs.ActionInfo._TYPE);
    	
    	Subscriber<sticky_wheel_msgs.TargetInfo> targetTopic = newSubscriber(target_topic, sticky_wheel_msgs.TargetInfo._TYPE);
    	targetTopic.addMessageListener(new MessageListener<sticky_wheel_msgs.TargetInfo>() {
    		public void onNewMessage(sticky_wheel_msgs.TargetInfo message) {
    			Predicate target = getTarget(message);
    			((StickyWheelROSEnvironment) getEnv()).newTarget(target);
    		}
    	});
    	
    	
       	Subscriber<sticky_wheel_msgs.ActionStatus> actionStatus = newSubscriber(status_topic, sticky_wheel_msgs.ActionStatus._TYPE);
    	actionStatus.addMessageListener(new MessageListener<sticky_wheel_msgs.ActionStatus>() {
    		public void onNewMessage(sticky_wheel_msgs.ActionStatus message) {
    			String status = message.getActionid();
    			((StickyWheelROSEnvironment) getEnv()).newStatus(status);
    		}
    	});
    	
       	Subscriber<sticky_wheel_msgs.PositionInfo> positionTopic = newSubscriber(position_topic, sticky_wheel_msgs.PositionInfo._TYPE);
    	positionTopic.addMessageListener(new MessageListener<sticky_wheel_msgs.PositionInfo>() {
    		public void onNewMessage(sticky_wheel_msgs.PositionInfo message) {
    			Predicate position = getPosition(message);
    			((StickyWheelROSEnvironment) getEnv()).newPosition(position);
    		}
    	});    	
    }
    
    public void publish(String action, double x, double y, double theta, double d) {
    	sticky_wheel_msgs.ActionInfo message = outTopic.newMessage();
    	message.setActionid(action);
    	message.setD(d);
    	message.setTheta(theta);
    	message.setX(x);
    	message.setY(y);
    	outTopic.publish(message);
    }
    
    public void forward(double d) {
    	publish("forward", 0, 0, 0, d);
    }
    
    public void turn(double theta) {
    	publish("turn", 0, 0, theta, 0);
    }
    
    public void feedback(double x, double y) {
    	publish("intelligent_control", x, y, 0, 0);
    }

    Predicate getTarget(sticky_wheel_msgs.TargetInfo message) {
    	Predicate target = new Predicate("target");
    	target.addTerm(new NumberTermImpl(message.getX()));
    	target.addTerm(new NumberTermImpl(message.getY()));
    	return target;
    }
    
    Predicate getPosition(sticky_wheel_msgs.PositionInfo message) {
    	Predicate position = new Predicate("position");
    	position.addTerm(new NumberTermImpl(message.getX()));
    	position.addTerm(new NumberTermImpl(message.getY()));
    	position.addTerm(new NumberTermImpl(message.getTheta()));
    	return position;
    }
 
}
