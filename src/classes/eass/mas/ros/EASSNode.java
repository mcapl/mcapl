package eass.mas.ros;

import java.util.HashMap;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;
import org.ros.node.topic.Publisher;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ail.syntax.Predicate;
import ail.syntax.Literal;
import ail.syntax.PredicatewAnnotation;
import ajpf.MCAPLcontroller;

public class EASSNode extends AbstractNodeMain {
	String agent_file_path;
	EASSROSEnvironment env;
	ConnectedNode cNode;
		
	public EASSNode(String file_path) {
		agent_file_path = file_path;
	}

	@Override
	public GraphName getDefaultNodeName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T> Subscriber<T> newSubscriber(String topic_name, String messageType ) {
		return cNode.newSubscriber(topic_name, messageType);
	}
	
	public <T> Publisher<T> newPublisher(String topic_name, String messageType ) {
		return cNode.newPublisher(topic_name, messageType);
	}
 	
	public void setConnectedNode(final ConnectedNode connectedNode) {
		cNode = connectedNode;
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		cNode = connectedNode;
		AILConfig config = new AILConfig(agent_file_path);
		AIL.configureLogging(config);
	
		MAS mas = AIL.AILSetup(config);
		env = (EASSROSEnvironment) mas.getEnv();
		env.setROSNode(this);
		initialise();
		
		// Lastly we construct a controller.
		MCAPLcontroller mccontrol = new MCAPLcontroller(mas, "", 1);
		// Start the system.
		mccontrol.begin(); 
		mas.finalize();
	}
	
	public void initialise() {};
	
	public void addPerceptToEnv(Predicate per) {
		env.addPercept(new Literal(true, new PredicatewAnnotation(per)));
	}

}
