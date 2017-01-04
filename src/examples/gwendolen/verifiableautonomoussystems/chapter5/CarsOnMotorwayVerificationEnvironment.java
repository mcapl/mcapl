// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Michael Fisher 
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

import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.RoundRobinScheduler;
import ail.syntax.Literal;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;

/**
 * This is an environment for verifying two simple cars.
 * @author louiseadennis
 *
 */
public class CarsOnMotorwayVerificationEnvironment extends DefaultEnvironment implements MCAPLJobber {
	
	String logname = "gwendolen.verifiableautonomoussystems.chapter5.CarsOnMotorwayEnvironment";
		
	
	/**
	 * Has the environment concluded?
	 */
	private boolean car1_finished = false;
	private boolean car2_finished = false;
	
	private int speed_limit = 5;

	/**
	 * Constructor.
	 */
	public CarsOnMotorwayVerificationEnvironment() {
		super();
		MCAPLScheduler s = new RoundRobinScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	int car1_speed = 0;
	int car2_speed = 0;
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#do_job()
	 */
	@Override
	public void do_job() {
		if (car1_yaccel > 0) {
			car1_speed = car1_speed + car1_yaccel;
		} 
		if (car2_yaccel > 0) {
			car2_speed = car2_speed + car2_yaccel;
		}

		addPercept("car1", new Literal("started"));
		addPercept("car2", new Literal("started"));

		if (car1_speed < speed_limit) {
			removePercept("car1", new Literal("at_speed_limit"));
		} else {
			addPercept("car1", new Literal("at_speed_limit"));
		}
					
		if (car2_speed < speed_limit) {
			removePercept("car2", new Literal("at_speed_limit"));
		} else {
			addPercept("car2", new Literal("at_speed_limit"));
		}
	}
	
	
	int car1_xaccel = 0;
	int car1_yaccel = 0;
	int car2_xaccel = 0;
	int car2_yaccel = 0;
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {

		if (act.getFunctor().equals("accelerate")) {
			if (agName.equals("car1")) {
				car1_yaccel = 1;
			} else {
				car2_yaccel = 1;
			}
		} else if (act.getFunctor().equals("decelerate")) {
			if (agName.equals("car1")) {
				car1_yaccel = -1;
			} else {
				car2_yaccel = -1;
			}
		} else if (act.getFunctor().equals("maintain_speed")) {
			if (agName.equals("car1")) {
				car1_yaccel = 0;
			} else {
				car2_yaccel = 0;
			}
		} else if (act.getFunctor().equals("finished")) {
			if (agName.equals("car1")) {
				car1_finished = true;
			} else {
				car2_finished = true;
			}
		}
		
		return super.executeAction(agName, act);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	@Override
	public boolean done() {
		if (car1_finished && car2_finished) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	@Override
	public String getName() {
		return "CarsOnMotorwayVerificationEnvironment";
	}

}
