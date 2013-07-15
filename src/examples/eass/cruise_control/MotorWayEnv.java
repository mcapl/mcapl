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
import ail.syntax.VarTerm;
import ail.util.AILexception;
import eass.mas.DefaultEASSEnvironment;

import ajpf.util.AJPFLogger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class MotorWayEnv extends DefaultEASSEnvironment {
	String logname = "eass.cruise_control.MotorWayEnv";
	Random r = new Random();
	double lane_change_time = 5;
	int car_number = 0;
	
	// Miles per hour
	int speed_limit = 70;
	int number_lanes = 3;
	
	ArrayList<Car> cars = new ArrayList<Car>();
	ArrayList<Exit> exits = new ArrayList<Exit>();
	HashMap<Integer, Integer> cars_exits = new HashMap<Integer, Integer>();
	HashMap<String, Car> agents_cars = new HashMap<String, Car>();
	HashMap<Integer, ArrayList<Car>> lanes_cars = new HashMap<Integer, ArrayList<Car>>();

	
	public MotorWayEnv(int slimit, int num_lanes) {
		this();
		
		speed_limit = slimit;
		number_lanes = num_lanes;
	}
	
	public MotorWayEnv() {
		super();
		RoundRobinScheduler s = new RoundRobinScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
		
	}
	
	public void set_up_cars() {
		Literal slimit = new Literal("speed_limit");
		slimit.addTerm(new NumberTermImpl(speed_limit));
		
		Literal rightmost_lane = new Literal("rightmost_lane");
		rightmost_lane.addTerm(new NumberTermImpl(number_lanes - 1));
		
		for (Car c: cars) {
			calculate_next_exit(c);
			agents_cars.put("abstraction_car" + c.getNumber(), c);
			
			addPercept("abstraction_car" + c.getNumber(), slimit);
			addPercept("abstraction_car" + c.getNumber(), rightmost_lane);
		}
		
	}
	
	public void set_up_lanes() {
		for (int i = 0; i < number_lanes; i++) {
			lanes_cars.put(i, new ArrayList<Car>());
		}
		for (Car c: cars) {
			lanes_cars.get(c.getLane()).add(c);
		}
		for (int i = 0; i < number_lanes; i++) {
			Collections.sort(lanes_cars.get(i));
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
	
	public void calculate_next_in_lane(int lane, Car c) {
		double pos = c.getPosition();
		boolean car_in_lane = false;
		for (Car lcar: lanes_cars.get(lane)) {
			if (lcar.getPosition() > pos) {
				Literal car_lane = new Literal("car");
				car_lane.addTerm(new NumberTermImpl(lane));
				car_lane.addTerm(new NumberTermImpl(lcar.getPosition() - pos));
				c.addUniqueCarPercept("car", car_lane);
				car_in_lane = true;
				
				break;
			}
		}
		
		if (!car_in_lane) {
			Literal car_lane = new Literal("car");
			car_lane.addTerm(new NumberTermImpl(lane));
			car_lane.addTerm(new VarTerm("C"));
			c.removeUnifiesCarPercept(car_lane);
			
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
			car.change_acceleration(((NumberTerm) act.getTerm(0)).solve());
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
	
	public class Car implements Comparable<Car>{
		// feet
		double position;
		
		// feet per second
		double velocity;
		
		// feet per second per second
		double acceleration;
		double max_braking; // NB treated as negative acceleration
		double min_braking; // also treated as negative acceleration.
		double max_acceleration;
		
		double driver_prob;
		double driver_bprob;
		
		int lane;
		int old_lane = -2;
		int whichcar;
		String name;
		boolean on_motorway = true;
		
		int ticks_until_lane_change = 0;
		
		public Car(double p, double v, double a, int l, 
				   double max_brake, double min_brake, double max_acc, int exit,
				   double driver_acts, double driver_brakes) {
			position = p;
			velocity = v;
			acceleration = a;
			lane = l;
			whichcar = car_number;
			name = "car" + car_number;
			car_number++;
			max_braking = max_brake;
			min_braking = min_brake;
			max_acceleration = max_acc;
			driver_prob = driver_acts;
			driver_bprob = driver_brakes;
			
			
			Literal lane = new Literal("lane");
			lane.addTerm(new NumberTermImpl(l));
			addPercept("abstraction_" + name, lane);
			
			Literal cexit = new Literal("chosen_exit");
			cexit.addTerm(new NumberTermImpl(exit));
			addPercept("abstraction_" + name, cexit);
			
		}
		
		public boolean isOnMotorway() {
			return on_motorway;
		}
		
		public int compareTo(Car c) {
			if (c.getPosition() < getPosition()) {
				return 1;
			} else if (c.getPosition() > getPosition()) {
				return -1;
			} else {
				return 0;
			}
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
			double pos_modifier = velocity + 0.5*acceleration;
			if (pos_modifier < 0) {
				pos_modifier = 0;
			}
			position = position + pos_modifier;
			velocity = velocity + acceleration;
			if (velocity < 0) {
				velocity = 0;
			}
			
			Literal speed = new Literal("speed");
			speed.addTerm(new NumberTermImpl(velocity/88 * 60));
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
			
			double driver = r.nextDouble();
			if (driver < driver_prob ) {
				double dbrakes = r.nextDouble();
				
				if (dbrakes < driver_bprob) {
					double brake = r.nextDouble() * max_braking;
					if (brake > min_braking) {
						brake = min_braking;
					}
					
					Literal driver_brakes = new Literal("brake_pedal");
					driver_brakes.addTerm(new NumberTermImpl(brake));
					addCarPercept(driver_brakes);
					
				} else {
					double acc = r.nextDouble() * max_acceleration;
					
					Literal driver_acc = new Literal("acceleration_pedal");
					driver_acc.addTerm(new NumberTermImpl(acc));
					addCarPercept(driver_acc);
				}
			} else {
				Literal driver_brakes = new Literal("brake_pedal");
				driver_brakes.addTerm(new VarTerm("V"));
				removeUnifiesCarPercept(driver_brakes);
				Literal driver_acc = new Literal("acceleration_pedal");
				driver_acc.addTerm(new VarTerm("V"));
				removeUnifiesCarPercept(driver_acc);
			}
		}
		
		public void addCarPercept(Literal l) {
			addPercept("abstraction_" + name, l);
		}
		
		public void addUniqueCarPercept(String s, Literal l) {
			addUniquePercept("abstraction_" + name, s, l);
		}

		public void removeCarPercept(Literal l) {
			removePercept("abstraction_" + name, l);
		}

		public void removeUnifiesCarPercept(Literal l) {
			removeUnifiesPercept("abstraction_" + name, l);
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
			if (a < max_braking) {
				acceleration = max_braking;
			} else if (a > max_acceleration) {
				acceleration = max_acceleration;
			} else if (a < 0 && a > min_braking) {
				acceleration = min_braking;
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
