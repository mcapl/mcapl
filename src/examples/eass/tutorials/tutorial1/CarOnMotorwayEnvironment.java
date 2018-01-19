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

package eass.tutorials.tutorial1;

import eass.mas.socket.EASSSocketClientEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.VarTerm;
import ail.util.AILSocketClient;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;


/**
 * This is an environment for connecting with the simple Java Motorway Simulation for tutorial purposes.
 * @author louiseadennis
 *
 */
public class CarOnMotorwayEnvironment extends EASSSocketClientEnvironment {

	String logname = "eass.tutorials.tutorial1.CarOnMotorwayEnvironment";

	// Two doubles used to keep track of the total distance the car has travelled.
	private double totalydistance = 0;
	private double prevy = 0;

	/**
	 * Constructor.
	 */
	public CarOnMotorwayEnvironment() {
		super();
		super.scheduler_setup(this,  new NActionScheduler(100));
	}

	/**
	 * Overwriting the EASSSocketClient method that is activated when do_job is called.
	 * This gets the values from the simulator and converts them into predicates.  It also
	 * updates total distance.
	 */
	public void readPredicatesfromSocket() {
		if (AJPFLogger.ltFine(logname)) {
			AJPFLogger.fine(logname, "Reading Values from Socket");
		}

		try {
			AILSocketClient socket = getSocket();
			if ( socket.pendingInput()) {

				double x = socket.readDouble();
				double y = socket.readDouble();
				double xdot = socket.readDouble();
				double ydot = socket.readDouble();
				int started = socket.readInt();
				// System.err.println(ydot);

				if (y >= prevy) {
					totalydistance += (y - prevy);
				}  else {
					double ylost = 550 - prevy;
					totalydistance += ylost;
					totalydistance += y;
				}
				// System.err.println(totalydistance);
				prevy = y;

				try {
					while (socket.pendingInput()) {
						x = socket.readDouble();
						y = socket.readDouble();
						xdot = socket.readDouble();
						ydot = socket.readDouble();
						started = socket.readInt();
					}
				} catch (Exception e) {
					AJPFLogger.warning(logname, e.getMessage());
				}


				Literal xpos = new Literal("xpos");
				xpos.addTerm(new NumberTermImpl(x));

				Literal ypos = new Literal("ypos");
				ypos.addTerm(new NumberTermImpl(y));

				Literal xspeed = new Literal("xspeed");
				xspeed.addTerm(new NumberTermImpl(xdot));

				Literal yspeed = new Literal("yspeed");
				yspeed.addTerm(new NumberTermImpl(ydot));

				if (started > 0) {
					addPercept(new Literal("started"));
				}

				addUniquePercept("xpos", xpos);
				addUniquePercept("ypos", ypos);
				addUniquePercept("xspeed", xspeed);
				addUniquePercept("yspeed", yspeed);
				}
		} catch (Exception e) {
			AJPFLogger.warning(logname, e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
		AILSocketClient socket = getSocket();

		if (act.getFunctor().equals("accelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.01);
		} else if (act.getFunctor().equals("decelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(-0.1);
		} else if (act.getFunctor().equals("maintain_speed")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.0);
		} else if (act.getFunctor().equals("calculate_totaldistance")) {
			VarTerm distance = (VarTerm) act.getTerm(0);
			u.unifies(distance, new NumberTermImpl(totalydistance));
		}

		u.compose(super.executeAction(agName, act));
		return u;

	}



}
