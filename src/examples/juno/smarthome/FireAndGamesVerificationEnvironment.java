// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package juno.smarthome;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import eass.mas.verification.EASSVerificationEnvironment;

/**
 * FireAndGamesVerificationEnvironment provides a verification environment - in the style
 * outlined in Practical Verification of Decision-Making in Agent-Based Autonomous Systems for
 * the example of a smart home that controls access to lights, games console and evacuation 
 * procedures as outlined in Verifiable Machine Ethics in Changing Contexts.
 */
public class FireAndGamesVerificationEnvironment extends EASSVerificationEnvironment {
	public String logname = "juno.smarthome.FireAndGamesVerificationEnvironment";

	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_sharedbeliefs(java.lang.String, ail.syntax.Action)
	 */
	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		Set<Predicate> predicates = new TreeSet<Predicate>();
		int time_of_day = random_int_generator.nextInt(3);
		if  (time_of_day == 0) {
			predicates.add(new Predicate("day"));
			AJPFLogger.info(logname, "Daytime");
		} else if (time_of_day == 1) {
			predicates.add(new Predicate("evening"));
			AJPFLogger.info(logname, "Evening");
		} else {
			predicates.add(new Predicate("night"));
			AJPFLogger.info(logname, "Night");
		}
		
		int  fire = random_int_generator.nextInt(2);
		if (fire == 0) {
			predicates.add(new Predicate("fire"));
			AJPFLogger.info(logname, "Fire!");
		}
		
		int noisy = random_int_generator.nextInt(2);
		if (noisy == 0) {
			predicates.add(new Predicate("children_noisy"));
			AJPFLogger.info(logname, "Children Noisy");
		}
		
		int mum_goal = random_int_generator.nextInt(3);
		if (mum_goal == 0) {
			predicates.add(new Predicate("mum_working"));
			AJPFLogger.info(logname, "Mum wants to work");
		} else if (mum_goal == 1) {
			predicates.add(new Predicate("mum_wrapping_presents"));
			AJPFLogger.info(logname, "Mum wrapping presents");
		}
		
		// AJPFLogger.info(logname, this.agentmap.get("juno").toString());
		AJPFLogger.info(logname, "Predicates: " + predicates);
		return predicates;
		
	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages(java.lang.String, ail.syntax.Action)
	 */
	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		return messages;
	}

}
