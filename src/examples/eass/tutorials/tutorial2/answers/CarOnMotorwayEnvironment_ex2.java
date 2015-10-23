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

package eass.tutorials.tutorial2.answers;

import java.io.IOException;

import eass.mas.DefaultEASSEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.util.AILSocketClient;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;

/**
 * This is an environment for connecting with the simple Java Motorway Simulation for tutorial purposes.
 * @author louiseadennis
 *
 */
public class CarOnMotorwayEnvironment_ex2 extends DefaultEASSEnvironment {
	
	String logname = "eass.tutorials.tutorial1.CarOnMotorwayEnvironment";
		
	/**
	 * Socket that connects to the Physical Engine.
	 */
	protected AILSocketClient socket;
	/**
	 * Has the environment concluded?
	 */
	private boolean finished = false;

	/**
	 * Constructor.
	 */
	public CarOnMotorwayEnvironment_ex2() {
		super();
		super.scheduler_setup(this,  new NActionScheduler(100));
		AJPFLogger.info("eass.mas", "Waiting Connection");
		try {
			socket = new AILSocketClient();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
			System.exit(0);
		}
		AJPFLogger.info(logname, "Connected to Socket");
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#do_job()
	 */
	public void do_job() {
		try {
			if (socket.allok()) {
				readPredicatesfromSocket();
			}
		} catch (Exception e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}

	/**
	 * Reading the values from the sockets and turning them into perceptions.
	 */
	public void readPredicatesfromSocket() {
		
		try {
			if (socket.pendingInput()) {
				double x = socket.readDouble();
				double y = socket.readDouble();
				socket.readDouble();
				socket.readDouble();
				double xdot = socket.readDouble();
				double ydot = socket.readDouble();
				int started = socket.readInt();
		
				try {
					while (socket.pendingInput()) {
						x = socket.readDouble();
						y = socket.readDouble();
						socket.readDouble();
						socket.readDouble();
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
		
		if (act.getFunctor().equals("accelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.1);
		} else if (act.getFunctor().equals("decelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(-0.1);
		} else if (act.getFunctor().equals("maintain_speed")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.0);
		} else if (act.getFunctor().equals("finished")) {
			finished = true;
		} else if (act.getFunctor().equals("change_lane")) {
			socket.writeDouble(0.1);
			socket.writeDouble(0.0);
			
			// The following probably isn't necessary, the idea is to stop the
			// car accelerating sideways once it has some speed in the x direction.
			boolean xspeed0 = true;
			while (xspeed0) {
				try {
					if (socket.pendingInput()) {
						socket.readDouble();
						socket.readDouble();
						socket.readDouble();
						socket.readDouble();
						double xdot = socket.readDouble();
						socket.readDouble();
						socket.readInt();
				
						if (xdot != 0.0) {
							xspeed0 = false;
						}
					}
				} catch (Exception e) {
					AJPFLogger.warning(logname, e.getMessage());
				}
			}
			socket.writeDouble(0.0);
			socket.writeDouble(0.0);
		} else if (act.getFunctor().equals("stay_in_lane")) {
			socket.writeDouble(-0.1);
			socket.writeDouble(0.0);
		}
		
		u.compose(super.executeAction(agName, act));
		return u;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#finalize()
	 */
	public void finalize() {
		socket.close();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	public boolean done() {
		if (finished) {
			return true;
		}
		return false;
	}

}
