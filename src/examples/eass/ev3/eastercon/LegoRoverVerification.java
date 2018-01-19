// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
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
package eass.ev3.eastercon;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;

/**
 * A Verification Environment for a simple obstacle avoidance programme.
 * @author lad
 *
 */
public class LegoRoverVerification extends EASSVerificationEnvironment {

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		Set<Predicate> shared_beliefs = new HashSet<Predicate>();
		boolean click = random_bool_generator.nextBoolean();
		if (! click) {
			System.err.println("click");
			shared_beliefs.add(new Predicate("click"));
		} else {
			System.err.println("no click");
		}
		
		boolean obstacle = random_bool_generator.nextBoolean();
		if (! obstacle) {
			System.err.println("obstacle");
			shared_beliefs.add(new Predicate("obstacle"));
		} else {
			System.err.println("no obstacle");
		}
		
		
		return shared_beliefs;
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		return new HashSet<Message>();
	}


}
