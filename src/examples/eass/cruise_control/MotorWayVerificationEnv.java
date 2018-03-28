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

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.verification.EASSVerificationEnvironment;

public class MotorWayVerificationEnv extends EASSVerificationEnvironment {
	String logname = "eass.cruise_control.MotorWayVerificationEnv";

	Literal in_leftmost_lane = new Literal("in_leftmost_lane");
	Literal in_rightmost_lane = new Literal("in_rightmost_lane");
	Literal changed_lane = new Literal("changed_lane");
	Literal at_exit = new Literal("at_exit");
	Literal leaving_at_chosen_exit = new Literal("leaving_at_chosen_exit");
	Literal chosen_exit_approaching = new Literal("chosen_exit_approaching");
	Literal safe = new Literal("safe");
	Literal safe_right = new Literal("safe_right");
	Literal safe_left = new Literal("safe_left");
	Literal car_ahead_in_lane = new Literal("car_ahead_in_lane");
	Literal car_ahead_in_left_lane = new Literal("car_ahead_in_left_lane");
	Literal above_speed_limit = new Literal("at_speed_limit");
	Literal driver_accelerates = new Literal("driver_accelerates");
	Literal driver_brakes = new Literal("driver_brakes");

	boolean in_leftmost_lane_b = false;
	boolean in_rightmost_lane_b = false;
	boolean changed_lane_b = false;
	boolean at_exit_b = false;
	boolean leaving_at_chosen_exit_b = false;
	boolean chosen_exit_approaching_b = false;
	boolean safe_b = false;
	boolean safe_right_b = false;
	boolean safe_left_b = false;
	boolean car_ahead_in_lane_b = false;
	boolean car_ahead_in_left_lane_b = false;
	boolean above_speed_limit_b = false;
	boolean driver_accelerates_b = false;
	boolean driver_brakes_b = false;

	boolean singlelane = true;
	boolean overtaking = false;


	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		//		lastAction = new Action("nothing");
				TreeSet<Predicate> percepts = new TreeSet<Predicate>();

						if (! overtaking && ! singlelane ) {
							at_exit_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random at_exit " + at_exit_b);
							leaving_at_chosen_exit_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random leaving_at_chosen_exit " + leaving_at_chosen_exit_b);
							chosen_exit_approaching_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random chosen_exit_approaching " + chosen_exit_approaching_b);
						}

						if (overtaking) {
							in_leftmost_lane_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random in_leftmost_lane " + in_leftmost_lane_b);
							in_rightmost_lane_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random in_righttmost_lane " + in_rightmost_lane_b);
							changed_lane_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random changed_lane " + changed_lane_b);
							safe_right_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random safe_right " + safe_right_b);
							safe_left_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random safe_left " + safe_left_b);
							car_ahead_in_lane_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random car_ahead_in_lane " + car_ahead_in_lane_b);
							car_ahead_in_left_lane_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random car_ahead_in_left_lane " + car_ahead_in_left_lane_b);
						}

						if (singlelane) {
							safe_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random safe " + safe_b);
							above_speed_limit_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random at_speed_limit " + above_speed_limit_b);
							driver_accelerates_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random driver_accelerates " + driver_accelerates_b);
							driver_brakes_b = random_bool_generator.nextBoolean();
							AJPFLogger.info(logname, "Random driver_brakes " + driver_brakes_b);
						}



				if (in_leftmost_lane_b) {
					percepts.add(in_leftmost_lane);
				}

				if (in_rightmost_lane_b) {
					percepts.add(in_rightmost_lane);
				}

				if (changed_lane_b) {
					percepts.add(changed_lane);
				}

				if (at_exit_b) {
					percepts.add(at_exit);
				}

				if (leaving_at_chosen_exit_b) {
					percepts.add(leaving_at_chosen_exit);
				}

				if (chosen_exit_approaching_b) {
					percepts.add(chosen_exit_approaching);
				}

				if (safe_b) {
					percepts.add(safe);
				}

				if (safe_right_b) {
					percepts.add(safe_right);
				}

				if (safe_left_b) {
					percepts.add(safe_left);
				}

				if (car_ahead_in_lane_b) {
					percepts.add(car_ahead_in_lane);
				}

				if (car_ahead_in_left_lane_b) {
					percepts.add(car_ahead_in_left_lane);
				}

				if (above_speed_limit_b) {
					percepts.add(above_speed_limit);
				}

				if (driver_accelerates_b) {
					percepts.add(driver_accelerates);
				}

				if (driver_brakes_b) {
					percepts.add(driver_brakes);
				}

				return percepts;
	}

	/**
	 * Randomly determine the percepts received by the agent.
	 */
	public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }


   /*
    * (non-Javadoc)
    * @see eass.mas.DefaultEASSEnvironment#eachrun()
    */
   public void eachrun() {
	   AJPFLogger.fine(logname, "running");
   }

	public void configure(AILConfig configuration) {
		super.configure(configuration);

		if (configuration.containsKey("singlelane")) {
			singlelane = Boolean.valueOf((String) configuration.get("singlelane"));
		}

		if (configuration.containsKey("overtaking")) {
			overtaking = Boolean.valueOf((String) configuration.get("overtaking"));
		}
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		return new TreeSet<Message>();
	}

	
}
