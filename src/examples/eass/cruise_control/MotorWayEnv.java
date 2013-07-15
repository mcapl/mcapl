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
import java.util.ArrayList;

public class MotorWayEnv extends DefaultEASSEnvironment {
	String logname = "eass.cruise_control.MotorWayEnv";
	Random r = new Random();
	double lane_change_time = 5;
	
	ArrayList<Car> cars = new ArrayList<Car>();
	ArrayList<Exit> exits = new ArrayList<Exit>();
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
			calculate_next_exit(c);
			agents_cars.put("abstraction_car" + c.getNumber(), c);
		}
		
	}
	
	int runcounter = 0;
	public void eachrun() {
		if (runcounter == 0) {
		boolean some_car_on_motorway = false;
		for (Car c: cars) {
			if (c.isOnMotorway()) {
				c.update();
				some_car_on_motorway = true;
			}
		}
		
		if (! some_car_on_motorway) {
			setDone(true);
			return;
		}

		calculatesafety();
		calculateexits();
		
		for (Car c: cars) {
			if (c.isOnMotorway()) {
				AJPFLogger.info(logname, c.toString());
			}
		}
		}
		
		runcounter++;
		if (runcounter > 5) {
			runcounter = 0;
		}
	}
	
	public void calculatesafety() {
		addPercept(new Literal("safe_in_left_lane"));
		addPercept(new Literal("safe_in_right_lane"));
		addPercept(new Literal("safe_in_lane"));
	}
	
	public void calculateexits() {
		for (Car c: cars) {
			if (c.isOnMotorway()) {
				calculate_next_exit(c);
			}
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
				double distance_in_feet = e.getStart() - c.getPosition();
				double distance_in_yards = distance_in_feet/3;
				next_exit.addTerm(new NumberTermImpl(distance_in_yards));
				addUniquePercept("abstraction_car" + c.getNumber(), "distance_to_next_exit", next_exit);
				break;
			}
		}
	}
	
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		u = super.executeAction(agName, act);
		AJPFLogger.info(logname, "Agent " + agName + " doing " + act);
		Car car = agents_cars.get(agName);
		if (act.getFunctor().equals("move_onto_ramp")) {
			car.leaveMotorway();
			Literal exit_ramp = new Literal("on_exit_ramp");
			exit_ramp.addTerm(new NumberTermImpl(cars_exits.get(car.getNumber())));
			addPercept(agName, exit_ramp);
		} else if (act.getFunctor().equals("move_lane")) {
			car.change_lane(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("brake")) {
			car.change_acceleration(0 - ((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("accelerate")) {
			car.change_acceleration(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("braking")) {
			car.change_acceleration(0 - r.nextInt(10));
		} else if (act.getFunctor().equals("accelerating")) {
			car.change_acceleration(r.nextInt(10));
		} 
		notifyListeners();
		return u;
	}
	
	public class Car {
		// feet
		double position;
		
		// feet per second
		double velocity;
		
		// feet per second per second
		double acceleration;
		double min_acceleration;
		double max_acceleration;
		
		int lane;
		int old_lane = -2;
		int whichcar;
		String name;
		boolean on_motorway = true;
		
		int ticks_until_lane_change = 0;
		
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
		
		public boolean isOnMotorway() {
			return on_motorway;
		}
		
		public void leaveMotorway() {
			lane = -1;
			old_lane = 0;
			ticks_until_lane_change = ((Double) lane_change_time).intValue();
		}
		
		public String toString() {
			String s = "Car " + whichcar;
			s += ": in lane " + lane;
			if (old_lane != -2 ) {
				s += "/" + old_lane;
			}
			s += "\n";
			s += "    at " + position/5280 + "miles \n";
			s += "    travelling at " + (velocity/88 * 60) + "mph\n";
			s += "    with acceleration " + acceleration + "ft/s^2";
			return s;
		}
		
		/**
		 * Update position and velocity assuming constant acceleration and the passing of 
		 * one unit of time.
		 */
		public void update() {
			position = position + velocity + 0.5*acceleration;
			velocity = velocity + acceleration;
			
			Literal speed = new Literal("speed");
			speed.addTerm(new NumberTermImpl(velocity/5280));
			addUniquePercept("abstraction_" + name, speed);
			
			if (ticks_until_lane_change > 1) {
				ticks_until_lane_change--;				
			} else if (ticks_until_lane_change == 1) {
				if (old_lane == 0 & lane == -1) {
					on_motorway = false;
					Literal new_lane_lit = new Literal("lane");
					new_lane_lit.addTerm(new NumberTermImpl(0));
					removePercept("abstraction_" + name, new_lane_lit);
					old_lane = -2;
					
				} else {
					Literal old_l = new Literal("lane");
					old_l.addTerm(new NumberTermImpl(old_lane));
					removePercept("abstraction_" + name, old_l);
					old_lane = -2;
					
				}
				Literal lane_change = new Literal("changing_lane");
				removePercept("abstraction_" + name, lane_change);
				ticks_until_lane_change--;
			}
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
			Literal new_lane_lit = new Literal("lane");
			new_lane_lit.addTerm(new NumberTermImpl(new_lane));
			addPercept("abstraction_" + name, new_lane_lit);
			
			Literal lane_change = new Literal("changing_lane");
			addPercept("abstraction_" + name, lane_change);
			
			old_lane = lane;
			lane = ((Double) new_lane).intValue();
			ticks_until_lane_change = ((Double) lane_change_time).intValue();
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
		// All in feet
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
