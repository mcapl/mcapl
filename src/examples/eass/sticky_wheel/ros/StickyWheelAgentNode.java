package eass.sticky_wheel.ros;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.exception.RemoteException;
import org.ros.message.MessageListener;

import eass.mas.ros.EASSNode;

public class StickyWheelAgentNode extends EASSNode {

	public StickyWheelAgentNode(String configfile) {
        super(configfile);
	}

	public GraphName getDefaultNodeName() {
        return GraphName.of("sticky_wheel/sticky_wheel_agent");
	}

	public void onStart(final ConnectedNode connectedNode) {
		super.onStart(connectedNode);
	}

}
