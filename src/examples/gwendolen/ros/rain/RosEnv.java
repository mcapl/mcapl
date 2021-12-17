package gwendolen.ros.rain;

import java.util.Random;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ros.Publisher;
import ros.RosBridge;
import ros.RosListenDelegate;
import ros.SubscriptionRequestMsg;
import ros.msgs.geometry_msgs.Twist;
import ros.msgs.geometry_msgs.Vector3;
import ros.msgs.move_base_msgs.MoveBaseActionResult;
import ros.msgs.monitor_msgs.MonitorError;
import ros.msgs.remote_inspection_msgs.Radiation;
import ros.msgs.std_msgs.PrimitiveMsg;
import ros.tools.MessageUnpacker;
import ros.tools.PeriodicPublisher;


public class RosEnv extends DefaultEnvironment{
	static final String logname = "gwendolen.ros.rain.RosEnv";
	
	RosBridge bridge = new RosBridge();
	
	float radiation = 0;
	
	public RosEnv() {
		super();
		
		bridge.connect("ws://localhost:9090", true);
		System.out.println("Environment started, connection with ROS established.");
		
		bridge.subscribe(SubscriptionRequestMsg.generate("/move_base/result")
				.setType("move_base_msgs/MoveBaseActionResult"),
//				.setThrottleRate(1)
//				.setQueueLength(1),
			new RosListenDelegate() {
				public void receive(JsonNode data, String stringRep) {
					MessageUnpacker<MoveBaseActionResult> unpacker = new MessageUnpacker<MoveBaseActionResult>(MoveBaseActionResult.class);
					MoveBaseActionResult msg = unpacker.unpackRosMessage(data);
					clearPercepts();
//					System.out.println("Frame id: "+msg.header.frame_id);
//					System.out.println("Stamp sec: "+msg.header.stamp.secs);
//					System.out.println("Seq: "+msg.header.seq);
//					System.out.println("Goal: "+msg.status.goal_id.id);
//					System.out.println("Stamp sec: "+msg.status.goal_id.stamp.secs);
//					System.out.println("Status: "+msg.status.status);
//					System.out.println("Text: "+msg.status.text);
//					
//					System.out.println();
					Literal movebase_result = new Literal("movebase_result");
					movebase_result.addTerm(new NumberTermImpl(msg.header.seq));
					movebase_result.addTerm(new NumberTermImpl(msg.status.status));
					addPercept(movebase_result);
				}
			}
	    );
		
		bridge.subscribe(SubscriptionRequestMsg.generate("/radiation_sensor_plugin/sensor_0")
				.setType("gazebo_radiation_plugins/Simulated_Radiation_Msg"),
//				.setThrottleRate(1)
//				.setQueueLength(1),
			new RosListenDelegate() {
				public void receive(JsonNode data, String stringRep) {
					MessageUnpacker<Radiation> unpacker = new MessageUnpacker<Radiation>(Radiation.class);
					Radiation msg = unpacker.unpackRosMessage(data);
					radiation = msg.value;
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
		int nterms = act.getTermsSize();
		Unifier u = new Unifier();
		if ((actionname.equals("move")) && nterms == 6) {
			NumberTerm lx = (NumberTerm) act.getTerm(0);
			NumberTerm ly = (NumberTerm) act.getTerm(1);
			NumberTerm lz = (NumberTerm) act.getTerm(2);
			NumberTerm ax = (NumberTerm) act.getTerm(3);
			NumberTerm ay = (NumberTerm) act.getTerm(4);
			NumberTerm az = (NumberTerm) act.getTerm(5);
			move(lx.solve(),ly.solve(),lz.solve(),ax.solve(),ay.solve(),az.solve());
		} else if ((actionname.equals("move")) && nterms == 3) {
			NumberTerm lx = (NumberTerm) act.getTerm(0);
			NumberTerm ly = (NumberTerm) act.getTerm(1);
			NumberTerm lz = (NumberTerm) act.getTerm(2);
			move(lx.solve(),ly.solve(),lz.solve());
		} else if (actionname.equals("keep_moving")) {
			NumberTerm period = (NumberTerm) act.getTerm(0);
			NumberTerm lx = (NumberTerm) act.getTerm(1);
			NumberTerm ly = (NumberTerm) act.getTerm(2);
			NumberTerm lz = (NumberTerm) act.getTerm(3);
			NumberTerm ax = (NumberTerm) act.getTerm(4);
			NumberTerm ay = (NumberTerm) act.getTerm(5);
			NumberTerm az = (NumberTerm) act.getTerm(6);
			keep_moving((int) period.solve(),lx.solve(),ly.solve(),lz.solve(),ax.solve(),ay.solve(),az.solve());
		} else if (actionname.equals("stop_moving")) {
			stop_moving();
		} else if (actionname.equals("inspect")) {
			try {
				Thread.sleep(3000);
				receive_inspect();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (actionname.equals("wait")) {
			NumberTerm period = (NumberTerm) act.getTerm(0);
			try {
				Thread.sleep((int) period.solve());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (actionname.equals("key_press")) {
			Scanner myObj = new Scanner(System.in);
			System.out.println(":::");
			myObj.nextLine();  // Read user input
		} else if (actionname.equals("get_random_coordinates")) {
			Random random = new Random();
			double x = random.nextDouble()*20 - 10;
			double y = random.nextDouble()*20 - 10;
			while (inaccessible(x, y)) {
				x = random.nextDouble()*20 - 10;
				y = random.nextDouble()*20 - 10;
			}
			NumberTerm lx = new NumberTermImpl(x);
			NumberTerm ly = new NumberTermImpl(y);
			act.getTerm(0).unifies(lx, u);
			act.getTerm(1).unifies(ly, u);
		}
		
		Unifier theta = super.executeAction(agName, act);
		theta.compose(u);
		return theta;
	}
	
	private boolean inaccessible(double x, double y) {
		if (x > 0.6 && x < 4.2 && y > -7.3 && y < -3) {
			return true;
		} else if (x > -8 && x < -5 && y > -9 && y < -6.5 ) {
			return true;
		} else if (x > 7.5 && x < 8.6 && y < -4 && y > -7.2) {
			return true;
		} else if (x > -1.1 && x < 2.1 && y > 3 && y < 4.2 ) {
			return true;
		} else if (x > 8.7) {
			return true;
		} else if (y > 9) {
			return true;
		} else if (x < -9) {
			return true;
		} else if (y < -9) {
			return true;
		} else if (x > 2.9 && x < 3.4 && y > 2.8 && y < 6.4) {
			return true;
		} else if (x > -5.8 && x < -4.9 && y < -6.9 && y > -8.15) {
			return true;
		} else if (x > 4.6 && x < 5.1 && y > -3.8 && y < -3.4) {
			return true;
		} else if (x > -6.9 && x < -6.15 && y > -4.8 && y < -1.5) {
			return true;
		} else if (x > -2.6 && x < -1.9 && y < 0.8 && y < 6.6) {
			return true;
		}
		
		return false;
	}
	
	public void move(double lx, double ly, double lz, double ax, double ay, double az) {
		Publisher cmd_vel = new Publisher("/cmd_vel", "geometry_msgs/Twist", bridge);
		
		Vector3 linear = new Vector3(lx,ly,lz);
		Vector3 angular = new Vector3(ax,ay,az);
		cmd_vel.publish(new Twist(linear, angular));
	}
	
	public void move(double lx, double ly, double lz) {
		Publisher move_base = new Publisher("/gwendolen_to_move_base", "geometry_msgs/Vector3", bridge);
		move_base.publish(new Vector3(lx,ly,lz));
	}
	
	public void keep_moving(int period, double lx, double ly, double lz, double ax, double ay, double az) {
		PeriodicPublisher cmd_vel = new PeriodicPublisher("/cmd_vel", "geometry_msgs/Twist", bridge);
		
		Vector3 linear = new Vector3(lx,ly,lz);
		Vector3 angular = new Vector3(ax,ay,az);
		cmd_vel.beginPublishing(new Twist(linear, angular), 2000);
	}

	public void stop_moving() {
		Publisher cmd_vel = new Publisher("/cmd_vel", "geometry_msgs/Twist", bridge);
		
		Vector3 linear = new Vector3(0.0,0.0,0.0);
		Vector3 angular = new Vector3(0.0,0.0,0.0);
		cmd_vel.publish(new Twist(linear, angular));
	}
	
	public void receive_inspect() {
		String status = null;
		System.out.println("Radiation: " + radiation);
		if (radiation >= 250 ) {
			status = "red";
			Literal rad = new Literal("danger_red");
			addPercept(rad);
		} else if (radiation >= 120) {
			status = "orange";
			Literal rad = new Literal("danger_orange");
			addPercept(rad);
		} else {
			status = "green";
		}
		Publisher radstatus = new Publisher("radiationStatus", "std_msgs/String", bridge);
		radstatus.publish(new PrimitiveMsg<String>(status));
	}
	
	@Override
	public boolean done() {
		return false;
	}

}

	