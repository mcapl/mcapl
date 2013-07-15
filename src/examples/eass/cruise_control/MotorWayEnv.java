// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, Michael Fisher
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.cruise_control;

import ail.mas.RoundRobinScheduler;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.util.AILexception;
import eass.mas.DefaultEASSEnvironment;

import ajpf.util.AJPFLogger;

import java.util.HashMap;
import java.util.Random;

public class MotorWayEnv extends DefaultEASSEnvironment {
	String logname = "eass.cruise_control.MotorWayEnv";
	Random r = new Random();
	
	Car[] cars = new Car[10];
	Exit[] exits = new Exit[10];
	HashMap<Integer, Integer> cars_exits = new HashMap<Integer, Integer>();
	HashMap<String, Car> agents_cars = new HashMap<String, Car>();

	public MotorWayEnv() {
		super();
		RoundRobinScheduler s = new RoundRobinScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
		
	}
	
	public void set_up_cars() {
		for (Car c: cars) {
			if (c == null) {
				break;
			}
			calculate_next_exit(c);
			agents_cars.put("abstraction_car" + c.getNumber(), c);
		}
		
	}
	
	public void eachrun() {
		for (Car c: cars) {
			if (c == null) {
				break;
			}
			c.update();
		}

		calculatesafety();
		calculateexits();
		
		AJPFLogger.info(logname, "Car 1:" + cars[0].getLane() + " " + cars[0].getPosition());
	}
	
	public void calculatesafety() {
		addPercept(new Literal("safe_in_left_lane"));
		addPercept(new Literal("safe_in_right_lane"));
		addPercept(new Literal("safe_in_lane"));
	}
	
	public void calculateexits() {
		for (Car c: cars) {
			if (c == null) {
				break;
			}
			calculate_next_exit(c);
		}
		
	}
	
	public void calculate_next_exit(Car c) {
		double pos = c.getPosition();
		for (Exit e: exits) {
			if (e == null) {
				break;
			}
			if (e.getStart() < pos && e.getEnd() > pos) {
				Literal at_exit = new Literal("at_exit_ramp");
				at_exit.addTerm(new NumberTermImpl(e.getNumber()));
				addPercept("abstraction_car" + c.getNumber(), at_exit);
			}
			if (e.getEnd() < pos) {
				Literal at_exit = new Literal("at_exit_ramp");
				at_exit.addTerm(new NumberTermImpl(e.getNumber()));
				removePercept("abstraction_car" + c.getNumber(), at_exit);
			}
			if (e.getStart() > pos) {
				cars_exits.put(c.getNumber(), e.getNumber());
				Literal next_exit = new Literal("distance_to_next_exit");
				next_exit.addTerm(new NumberTermImpl(e.getNumber()));
				next_exit.addTerm(new NumberTermImpl(e.getStart() - c.getPosition()));
				addUniquePercept("abstraction_car" + c.getNumber(), "distance_to_next_exit", next_exit);
				break;
			}
		}
	}
	
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		u = super.executeAction(agName, act);
		AJPFLogger.info(logname, "Agent " + agName + " doing " + act);
		if (act.getFunctor().equals("move_onto_ramp")) {
			Literal exit_ramp = new Literal("on_exit_ramp");
			exit_ramp.addTerm(new NumberTermImpl(cars_exits.get(agents_cars.get(agName).getNumber())));
			addPercept(agName, exit_ramp);
		} else if (act.getFunctor().equals("move_lane")) {
			agents_cars.get(agName).change_lane(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("brake")) {
			agents_cars.get(agName).change_acceleration(0 - ((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("accelerate")) {
			agents_cars.get(agName).change_acceleration(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("braking")) {
			agents_cars.get(agName).change_acceleration(0 - r.nextInt(10));
		} else if (act.getFunctor().equals("accelerating")) {
			agents_cars.get(agName).change_acceleration(r.nextInt(10));
		}
		notifyListeners();
		return u;
	}
	
	public class Car {
		double position;
		double velocity;
		double acceleration;
		double min_acceleration;
		double max_acceleration;
		int lane;
		int whichcar;
		String name;
		
		public Car(double p, double v, double a, int l, int number, double min_acc, double max_acc) {
			position = p;
			velocity = v;
			acceleration = a;
			lane = l;
			whichcar = number;
			name = "car" + number;
			min_acceleration = min_acc;
			max_acceleration = max_acc;
			
			Literal lane = new Literal("lane");
			lane.addTerm(new NumberTermImpl(l));
			addPercept("abstraction_" + name, lane);
			
			
			
		}
		
		/**
		 * Update position and velocity assuming constant acceleration and the passing of 
		 * one unit of time.
		 */
		public void update() {
			position = position + velocity + 0.5*acceleration;
			velocity = velocity + acceleration;
			
			Literal speed = new Literal("speed");
			speed.addTerm(new NumberTermImpl(velocity));
			addPercept("abstraction_" + name, speed);
		}
		
		public double getPosition() {
			return position;
		}
		
		public int getNumber() {
			return whichcar;
		}
		
		public int getLane() {
			return lane;
		}
		
		public void change_lane(double new_lane) {
			Literal old_lane = new Literal("lane");
			old_lane.addTerm(new NumberTermImpl(lane));
			removePercept("abstraction_" + name, old_lane);
			
			Literal new_lane_lit = new Literal("lane");
			new_lane_lit.addTerm(new NumberTermImpl(new_lane));
			addPercept("abstraction_" + name, new_lane_lit);
		}
		
		public void change_acceleration(double a) {
			if (a < min_acceleration) {
				acceleration = min_acceleration;
			} else if (a > max_acceleration) {
				acceleration = max_acceleration;
			} else {
				acceleration = a;
			}
		}
	}
	
	public class Exit {
		double position_start;
		double position_end;
		int number;
		
		public Exit(int start, int end, int exitnum) {
			position_start = start;
			position_end = end;
			number = exitnum;
		}
		
		public int getNumber() {
			return number;
		}
		
		public double getStart() {
			return position_start;
		}
		
		public double getEnd() {
			return position_end;
		}
	}

}
