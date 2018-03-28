// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher 
// 
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.verifiableautonomoussystems.chapter5;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

/**
 * An environment for verifying a very simple autonomous car agent.
 * @author lad
 *
 */
public class Car1VerificationEnvironment extends
		VerificationofAutonomousSystemsEnvironment {

	String logname = "gwendolen.verifiableautonomoussystems.chapter5.Car1VerificationEnvironment";
	
	/*
	 * (non-Javadoc)
	 * @see gwendolen.mas.VerificationofAutonomousSystemsEnvironment#generate_percepts()
	 */
	@Override
	public Set<Predicate> generate_percepts() {
		Set<Predicate> beliefs = new HashSet<Predicate>();
		
		boolean at_speed_limit = random_bool_generator.nextBoolean();
		boolean started = random_bool_generator.nextBoolean();
		if (at_speed_limit) {
			beliefs.add(new Predicate("at_speed_limit"));
			AJPFLogger.info(logname, "At Speed Limit");
		}
		
		if (started) {
			beliefs.add(new Predicate("started"));
			AJPFLogger.info(logname, "Started");
		}
		return beliefs;
	}

	/*
	 * (non-Javadoc)
	 * @see gwendolen.mas.VerificationofAutonomousSystemsEnvironment#generate_messages()
	 */
	@Override
	public Set<Message> generate_messages() {
		return new HashSet<Message>();
	}

}
