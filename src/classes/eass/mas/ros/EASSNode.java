package eass.mas.ros;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;

public class EASSNode extends AbstractNodeMain {
	String agent_file_path;
	
	public EASSNode(String file_path) {
		agent_file_path = file_path;
	}

	@Override
	public GraphName getDefaultNodeName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onStart(final ConnectedNode connectedNode) {
		AILConfig config = new AILConfig(agent_file_path);
		AIL.configureLogging(config);
	
		MAS mas = AIL.AILSetup(config);
		((EASSROSEnvironment) mas.getEnv()).setROSNode(this);
		
		// Lastly we construct a controller.
		MCAPLcontroller mccontrol = new MCAPLcontroller(mas, "", 1);
		// Start the system.
		mccontrol.begin(); 
		mas.finalize();
	}

}
