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

package eass.tutorials.tutorial3;

import java.util.Set;
import java.util.TreeSet;

import eass.mas.verification.EASSVerificationEnvironment;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ail.syntax.Message;
import ail.syntax.Action;

/**
 * An environment for verifying a simple car reasoning engine.
 * @author louiseadennis
 *
 */
public class VerificationEnvironment extends EASSVerificationEnvironment {

	public String logname = "eass.tutorials.tutorial3.VerificationEnvironment";

	public Set<Predicate> generate_sharedbeliefs(String agName, Action act){
		Set<Predicate> predicates = new TreeSet<Predicate>();
		int assert_at_speed_limit = random_int_generator.nextInt(2);
		if (assert_at_speed_limit == 0) {
			predicates.add(new Predicate("at_speed_limit"));
			AJPFLogger.info(logname, "At the Speed Limit");
		} else {
			AJPFLogger.info(logname, "Not At Speed Limit");
		}

		int assert_start = random_int_generator.nextInt(2);
		if (assert_start == 0) {
			predicates.add(new Predicate("start"));
			AJPFLogger.info(logname, "Asserting start");
		} else {
			AJPFLogger.info(logname, "Not asserting start");
		}

		for(Predicate predicate : predicates){
			addPercept(agName, predicate);
		}

		return predicates;
	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		return messages;
	};


}
