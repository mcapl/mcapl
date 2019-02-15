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
package pbdi.pi2goagent;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import pbdi.mas.verification.PBDIVerificationEnvironment;
import pbdi.syntax.PythonCalculation;

public class Pi2GoAgentEnv extends PBDIVerificationEnvironment {
	String logname = "pbdi.pi2goagent.Pi2GoAgentEnv";

	@Override
	public Set<Predicate> generate_sharedbeliefs() {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean irRight = random_bool_generator.nextBoolean();
		if (irRight) {
			percepts.add(new Predicate("obstacle_right"));
			AJPFLogger.info(logname, "Obstacle on Right");
		} else {
			AJPFLogger.info(logname, "No Obstacle on Right");
		}
			
		boolean irLeft = random_bool_generator.nextBoolean();
		if (irLeft) {
			percepts.add(new Predicate("obstacle_left"));
			AJPFLogger.info(logname, "Obstacle on Left");
		} else {
			AJPFLogger.info(logname, "No Obstacle on Left");
		}
		
		boolean irCentre = random_bool_generator.nextBoolean();
		if (irCentre) {
			percepts.add(new Predicate("obstacle_centre"));
			AJPFLogger.info(logname, "Obstacle in the Centre");
		} else {
			AJPFLogger.info(logname, "No Obstacle in the Centre");
		}
		
		boolean irLeftLine = random_bool_generator.nextBoolean();
		if (irLeftLine) {
			percepts.add(new Predicate("no_line_left"));
			AJPFLogger.info(logname, "No Line on Left");
		} else {
			AJPFLogger.info(logname, "Line on Left");
		}
			
		boolean irRightLine = random_bool_generator.nextBoolean();
		if (irRightLine) {
			percepts.add(new Predicate("no_line_right"));
			AJPFLogger.info(logname, "No Line on Right");
		} else {
			AJPFLogger.info(logname, "Right on Left");
		}
		
		boolean switch_pressed = random_bool_generator.nextBoolean();
		if (switch_pressed) {
			percepts.add(new Predicate("switch_pressed"));
			AJPFLogger.info(logname, "Switch Pressed");
		} else {
			AJPFLogger.info(logname, "Switch Not Pressed");
		}
			
		return percepts;
	}

	@Override
	public Set<Message> generate_messages() {
		return new TreeSet<Message>();
	}

	@Override
	public Set<PythonCalculation> generate_calcs() {
		// TODO Auto-generated method stub
		return new TreeSet<PythonCalculation>();
	}

}
