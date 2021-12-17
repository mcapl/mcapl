package gwendolen.ros;

import com.fasterxml.jackson.databind.JsonNode;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ros.Publisher;
import ros.RosBridge;
import ros.RosListenDelegate;
import ros.SubscriptionRequestMsg;
//import ajpf.MCAPLJobber;
import ros.msgs.std_msgs.PrimitiveMsg;
import ros.tools.MessageUnpacker;



public class RosEnv extends DefaultEnvironment{
	static final String logname = "gwendolen.ros.RosEnv";
	
	RosBridge bridge = new RosBridge();
	
	/**
	 * Constructor.  Decides upon the number of humans, buildings and rubble.
	 */
	public RosEnv() {
		super();
		
		bridge.connect("ws://localhost:9090", true);
		System.out.println("Environment started, connection with ROS established.");
		
		bridge.subscribe(SubscriptionRequestMsg.generate("/ros_to_java")
				.setType("std_msgs/String")
				.setThrottleRate(1)
				.setQueueLength(1),
			new RosListenDelegate() {

				public void receive(JsonNode data, String stringRep) {
					MessageUnpacker<PrimitiveMsg<String>> unpacker = new MessageUnpacker<PrimitiveMsg<String>>(PrimitiveMsg.class);
					PrimitiveMsg<String> msg = unpacker.unpackRosMessage(data);
					System.out.println(msg.data);
				}
			}
	);

	
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		String actionname = act.getFunctor();
		if (actionname.equals("hello_ros")) {
			hello_ros();
		} 
		return super.executeAction(agName, act);
	}
	
	public void hello_ros() {
		Publisher pub = new Publisher("/java_to_ros", "std_msgs/String", bridge);
		
		for(int i = 0; i < 100; i++) {
			pub.publish(new PrimitiveMsg<String>("hello from gwendolen " + i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
