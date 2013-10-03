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

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.DefaultEASSEnvironment;

public class MotorWayVerificationEnv extends DefaultEASSEnvironment {
	String logname = "eass.cruise_control.MotorWayVerificationEnv";
	boolean change = true;
	Random random = new Random();

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
	
	boolean singlelane = false;
	boolean overtaking = false;
	
	/**
	 * Randomly determine the percepts received by the agent.
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		lastAction = new Action("nothing");
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();

		if (change) {
			if (! overtaking && ! singlelane ) {
				at_exit_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random at_exit " + at_exit_b);
				leaving_at_chosen_exit_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random leaving_at_chosen_exit " + leaving_at_chosen_exit_b);
				chosen_exit_approaching_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random chosen_exit_approaching " + chosen_exit_approaching_b); 
			}
		
			if (overtaking) {
				in_leftmost_lane_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random in_leftmost_lane " + in_leftmost_lane_b);
				in_rightmost_lane_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random in_righttmost_lane " + in_rightmost_lane_b);
				changed_lane_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random changed_lane " + changed_lane_b);
				safe_right_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random safe_right " + safe_right_b);
				safe_left_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random safe_left " + safe_left_b);
				car_ahead_in_lane_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random car_ahead_in_lane " + car_ahead_in_lane_b);
				car_ahead_in_left_lane_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random car_ahead_in_left_lane " + car_ahead_in_left_lane_b); 
			}
		
			if (singlelane) {
				safe_b = random.nextBoolean(); 
				AJPFLogger.info(logname, "Random safe " + safe_b);
				above_speed_limit_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random at_speed_limit " + above_speed_limit_b); 
				driver_accelerates_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random driver_accelerates " + driver_accelerates_b); 
				driver_brakes_b = random.nextBoolean();
				AJPFLogger.info(logname, "Random driver_brakes " + driver_brakes_b); 
			}
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
		

		change = false;
		return percepts;
	}
	
	/*
	 * 	(non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#mThreads()
	 */
	public boolean mThreads() {
		return false;
	}

	
	/**
	 * When the agent executes an action then something may change.  This method doesn't do anything except alter the flags for generating random numbers.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();
	   	if (AJPFLogger.ltInfo(logname)) {
	   		AJPFLogger.info(logname, agName + " about to do " + act);
	   	}
    	lastAgent = agName;
    	lastAction = act;
	   	
    	if (! act.getFunctor().equals("remove_shared")) {
    		change = true;
    	}
    	
    	// System.err.println(agentmap.get(agName));
 	   		   	 
    	return theta;
    }
   
   /*
    * 
    */
   public void run() {
	   done = true;
	   notifyListeners();
   }
   
   /*
    * (non-Javadoc)
    * @see eass.mas.DefaultEASSEnvironment#eachrun()
    */
   public void eachrun() {
	   AJPFLogger.fine(logname, "running");
   }
   
   
    public boolean nothingPending(String agName) {
    	return (!change);
   }
    
    /*
     * (non-Javadoc)
     * @see ail.mas.DefaultEnvironment#agentIsUpToDate(java.lang.String)
     */
    public boolean agentIsUpToDate(String agName) {
     	return nothingPending(agName);
    }

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#separateThread()
	 */
	public boolean separateThread() {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#done()
	 */
	public boolean done() {
		setDone(true);
		return super.done();
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

}
