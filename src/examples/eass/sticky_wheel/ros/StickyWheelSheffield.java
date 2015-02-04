package eass.sticky_wheel.ros;

public class StickyWheelSheffield extends StickyWheelAgentNode {
	String targetTopic = "human/teleop";
	String actionStatus = "actionstatus";
	String positionTopic = "positioninfo";
	String actionTopic = "actioninfo";
	
	
	public StickyWheelSheffield() {
		super("/src/main/java/sticky_simple_switch.ail");
	}
	
    public void initialise() {
        super.initialise(targetTopic, actionStatus, positionTopic, actionTopic, 20);
    }

}
