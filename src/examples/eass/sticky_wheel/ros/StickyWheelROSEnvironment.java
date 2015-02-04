package eass.sticky_wheel.ros;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Plan;
import ail.syntax.Predicate;
import ail.syntax.Literal;
import ail.syntax.Unifier;
import ail.util.AILexception;
import eass.mas.ros.EASSROSEnvironment;

public class StickyWheelROSEnvironment extends EASSROSEnvironment {
	String logname = "eass.sticky_wheel.ros.StickyWheelROSEnvironment";
	static int NO_ACTION = 0;
	static int FORWARD = 1;
	static int TURN = 2;
	static int FEEDBACK = 3;
	
	int action_status = NO_ACTION;
	double turn_angle = 0.0;

	int count = 0;
	int count_max = 20;
	public void setCountMax(int cm) {
		count_max = cm;
	}
	
	public void newTarget(Predicate target) {
		addPercept(target);
	}
	
	int counter = 0;
	public void newPosition(Predicate position) {
		//if (counter == 0) {
			addUniquePercept("position", new Literal(true, position));
		//	counter++;
	//	} else if (counter > 100) {
	//		counter = 0;
	//	} else {
	//		counter++;
	//	}
	}
	
	public void newStatus(String status) {
		if (status.equals("done")) {
			if (action_status == FORWARD || action_status == FEEDBACK) {
				action_status = NO_ACTION;
				addPercept(new Predicate("done_move"));
			} else if (action_status == TURN) {
				action_status = NO_ACTION;
				addPercept(new Predicate("done_turn"));
			}
		} else {
			removePercept(new Predicate("done_move"));
			removePercept(new Predicate("done_turn"));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this executes something in the control system which then, in turn, calls
	 * an action in the larger environment (engageBothMotors) typically.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("forward")) {
			StickyWheelAgentNode node = (StickyWheelAgentNode) getROSNode();
			action_status = FORWARD;
			node.forward(((NumberTerm) act.getTerm(0)).solve(), turn_angle);
		} else if (act.getFunctor().equals("turn")) {
			StickyWheelAgentNode node = (StickyWheelAgentNode) getROSNode();
			action_status = TURN;
			turn_angle = ((NumberTerm) act.getTerm(0)).solve();
			// node.turn(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("calculate_angle")) {
			// Maths for calculating the angle the robot needs to turn to in order to face some target point.
			
			double current_x = ((NumberTerm) act.getTerm(0)).solve();
			double current_y = ((NumberTerm) act.getTerm(1)).solve();
			double current_angle = ((NumberTerm) act.getTerm(2)).solve();
			double target_x = ((NumberTerm) act.getTerm(3)).solve();
			double target_y = ((NumberTerm) act.getTerm(4)).solve();
			
			double theta = 0;
			if (target_x != current_x) {
				double tantheta = (target_y - current_y)/(target_x - current_x);
				theta = Math.toDegrees(Math.atan(tantheta));
			}  else if (target_y > current_y){
				theta = 90;
			}  else {
				theta = 270;
			}
			
			double new_angle = current_angle + theta;
			Unifier U = new Unifier();
			U.unifies(act.getTerm(5), new NumberTermImpl(new_angle));
			return U;
		} else if (act.getFunctor().equals("calculate_distance")) {
			// Maths for calculating the distance to some target point.
			double current_x = ((NumberTerm) act.getTerm(0)).solve();
			double current_y = ((NumberTerm) act.getTerm(1)).solve();
			double target_x = ((NumberTerm) act.getTerm(2)).solve();
			double target_y = ((NumberTerm) act.getTerm(3)).solve();
			
			double distance = calculatedistance(current_x, current_y, target_x, target_y);
			Unifier U = new Unifier();
			U.unifies(act.getTerm(4), new NumberTermImpl(distance));
			return U;
			
		} else if (act.getFunctor().equals("feedback_control")) {
			StickyWheelAgentNode node = (StickyWheelAgentNode) getROSNode();
			action_status = FEEDBACK;
			node.feedback(((NumberTerm) act.getTerm(0)).solve(), ((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("substitute_in_plans")) {
			// This finds a new capability in the agents plans if the current capability has failed.
			// This code should probably appear elsewhere in the Capability or Plan classes.
			Predicate capname = (Predicate) act.getTerm(1);
			Predicate post = (Predicate) act.getTerm(0);
			// Predicate pre = (Predicate) act.getTerm(2);
			
			AILAgent ag = agentmap.get(agName);
			Iterator<Plan> plans = ag.getPL().getPlansContainingCap(capname);
			Unifier u = new Unifier();
			Capability oldcap = ag.getCL().getRelevant(capname).next();
			Capability c = ag.getCL().findEquivalent(oldcap, post, ag.getRuleBase(), u );
			oldcap.apply(u);
			while (plans.hasNext()) {
				Plan p = plans.next();
				Plan newplan = (Plan) p.clone();
				
				newplan.replaceCap(capname, c, oldcap);
				newplan.resolveVarsClusters();
				
				ag.removePlan(p);
				ag.addPlan(newplan);
			}
		}
		
		return super.executeAction(agName, act);
	}
	
	/**
	 * Standard maths for calculating a distance between two sets of coordinates.
	 * @param cx
	 * @param cy
	 * @param tx
	 * @param ty
	 * @return
	 */
	private static double calculatedistance(double cx, double cy, double tx, double ty) {
		double xdiff = cx - tx;
		double ydiff = cy - ty;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
	}
	
	public boolean done() {
		return false;
	}

	
}
