// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis and Michael Fisher
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

package eass.tutorials.tutorial3.answers;

import java.util.Set;
import java.util.TreeSet;

import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ail.syntax.Message;

/**
 * An environment for verifying a simple car reasoning engine.
 * @author louiseadennis
 * 
 */
public class VerificationEnvironmentEx2 extends EASSVerificationEnvironment {
			
	public String logname = "eass.tutorials.tutorial3.VerificationEnvironment";
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_sharedbeliefs()
	 */
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean assert_at_speed_limit = random_bool_generator.nextBoolean();
		if (assert_at_speed_limit) {
			percepts.add(new Predicate("at_speed_limit"));
			AJPFLogger.info(logname, "At the Speed Limit");
		} else {
			AJPFLogger.info(logname, "Not At Speed Limit");
		}
		
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		
		boolean assert_start = random_bool_generator.nextBoolean();
		if (assert_start) {
			messages.add(new Message(EASSAgent.TELL, "simulator", "car", new Predicate("start")));
			AJPFLogger.info(logname, "Asserting start");
		} else {
			AJPFLogger.info(logname, "Not asserting start");
		}
		return messages;
	}

}
