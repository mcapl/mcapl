package eass.sticky_wheel.ros;

public class StickyWheelIsolated extends StickyWheelAgentNode {
	String targetTopic = "human/teleop";
	String actionStatus = "human/actionStatus";
	String positionTopic = "human/position";
	String actionTopic = "sticky_wheel/actionInfo";
	
	
	public StickyWheelIsolated() {
		super("/src/main/java/sticky_simple_switch.ail");
	}
	
    public void initialise() {
        super.initialise(targetTopic, actionStatus, positionTopic, actionTopic, 20);
    }

}
