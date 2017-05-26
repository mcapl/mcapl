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

package eass.cruise_control.runtime;

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
	String logname = "eass.cruise_control.runtime.MotorWayVerificationEnv";

	Literal safe = new Literal("safe");
	Literal above_speed_limit = new Literal("at_speed_limit");
	Literal driver_accelerates = new Literal("driver_accelerates");
	Literal driver_brakes = new Literal("driver_brakes");

	boolean safe_b = false;
	boolean above_speed_limit_b = false;
	boolean driver_accelerates_b = false;
	boolean driver_brakes_b = false;

	public Set<Predicate> add_random_beliefs(String agName, Action act) {
		//		lastAction = new Action("nothing");
				TreeSet<Predicate> percepts = new TreeSet<Predicate>();
				
				//safe_b = random_bool_generator.nextBoolean();
				//AJPFLogger.info(logname, "Random safe " + safe_b);
				//above_speed_limit_b = random_bool_generator.nextBoolean();
				//AJPFLogger.info(logname, "Random at_speed_limit " + above_speed_limit_b);
				//driver_accelerates_b = random_bool_generator.nextBoolean();
				//AJPFLogger.info(logname, "Random driver_accelerates " + driver_accelerates_b);
				//driver_brakes_b = random_bool_generator.nextBoolean();

				if (random_bool_generator.nextBoolean()) {
					percepts.add(safe);
					addPercept(safe);
					AJPFLogger.info(logname, "Random safe" );
				} else {
					AJPFLogger.info(logname, "Random not safe" );
				}


				if (random_bool_generator.nextBoolean()) {
					percepts.add(above_speed_limit);
					addPercept(above_speed_limit);
				} 

				if (random_bool_generator.nextBoolean()) {
					percepts.add(driver_accelerates);
					addPercept(driver_accelerates);
					AJPFLogger.info(logname, "Random driver accelerates" );
				} else {
					AJPFLogger.info(logname, "Random driver doesn't accelerate" );
				}

				if (random_bool_generator.nextBoolean()) {
					percepts.add(driver_brakes);
					addPercept(driver_brakes);
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

	@Override
	public Set<Message> generate_messages() {
		return new TreeSet<Message>();
	}

	public Set<Message> add_random_messages(String agName, Action act) {
		return new TreeSet<Message>();
	}

}
