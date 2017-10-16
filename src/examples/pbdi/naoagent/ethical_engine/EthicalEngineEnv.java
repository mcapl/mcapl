// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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
package pbdi.naoagent.ethical_engine;

import java.util.Set;
import java.util.TreeSet;

import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.SingleAgentScheduler;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;
import pbdi.mas.verification.PBDIVerificationEnvironment;

public class EthicalEngineEnv extends PBDIVerificationEnvironment {
	String logname = "pbdi.pi2goagent.Pi2GoAgentEnv";

	@Override
	public Set<Predicate> generate_sharedbeliefs() {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean too_close_to_human = random_bool_generator.nextBoolean();
		if (too_close_to_human) {
			percepts.add(new Predicate("danger_close"));
			AJPFLogger.info(logname, "Danger Close to Human");
		} else {
			AJPFLogger.info(logname, "Danger not close to  human");
		}

		return percepts;
	}

	@Override
	public Set<Message> generate_messages() {
		return new TreeSet<Message>();
	}

}
