// ----------------------------------------------------------------------------
// Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
//
// This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
// 
// The RVMCAPL Library is free software; you can redistribute it and/or
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
// ----------------------------------------------------------------------------

package eass.cruise_control.runtime;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Literal;
import ajpf.util.AJPFLogger;
import eass.mas.verification.EASSVerificationEnvironment;

public class MotorWayVerificationEnv extends EASSVerificationEnvironment {
	String logname = "eass.cruise_control.runtime.MotorWayVerificationEnv";

	Literal safe = new Literal("safe");
	Literal above_speed_limit = new Literal("at_speed_limit");
	Literal driver_accelerates = new Literal("driver_accelerates");
	Literal driver_brakes = new Literal("driver_brakes");


	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
				TreeSet<Predicate> percepts = new TreeSet<Predicate>();
				

				int random_int = random_int_generator.nextInt(16);
				if (random_int == 0) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 1) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");					
				} else if (random_int == 2) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 3) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");					
				} else if (random_int == 4) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 5) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");	
				} else if (random_int == 6) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");					
				} else if (random_int == 7) {
					percepts.add(safe);
					//addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");						
				} else if (random_int == 8) {
					AJPFLogger.info(logname, "Random not safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 9) {
					AJPFLogger.info(logname, "Random not safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");					
				} else if (random_int == 10) {
					AJPFLogger.info(logname, "Random not safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 11) {
					AJPFLogger.info(logname, "Random not safe" );
					percepts.add(above_speed_limit);
					//addPercept(above_speed_limit);
					AJPFLogger.info(logname, "Random Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");					
				} else if (random_int == 12) {
					AJPFLogger.info(logname, "Random not safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");
				} else if (random_int == 13) {
					AJPFLogger.info(logname, "Random not safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					percepts.add(driver_accelerates);
					//addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");	
				} else if (random_int == 14) {
					AJPFLogger.info(logname, "Random not safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					percepts.add(driver_brakes);
					//addPercept(driver_brakes);
					AJPFLogger.info(logname, "Random driver brakes");					
				} else {
					AJPFLogger.info(logname, "Random not safe" );
					AJPFLogger.info(logname, "Random Not Speed Limit");
					AJPFLogger.info(logname, "Random driver doesn't accelerates" );
					AJPFLogger.info(logname, "Random driver doesn't brake");						
				} 
					

				return percepts;
	}

	/**
	 * Randomly determine the percepts received by the agent.
	 */
	//public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }


   /*
    * (non-Javadoc)
    * @see eass.mas.DefaultEASSEnvironment#eachrun()
    */
   public void eachrun() {
	   AJPFLogger.fine(logname, "running");
   }

	@Override
	public Set<Message> generate_messages(String AgName, Action act) {
		return new TreeSet<Message>();
	}

	public Set<Message> add_random_messages(String agName, Action act) {
		return new TreeSet<Message>();
	}

}
