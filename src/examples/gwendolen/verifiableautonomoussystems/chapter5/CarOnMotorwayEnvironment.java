// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Michael Fisher 
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

package gwendolen.verifiableautonomoussystems.chapter5;

import java.io.IOException;

import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.util.AILSocketClient;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;
import ajpf.util.AJPFLogger;

/**
 * This is an environment for connecting with the simple Java Motorway Simulation for tutorial purposes.
 * @author louiseadennis
 *
 */
public class CarOnMotorwayEnvironment extends DefaultEnvironment implements MCAPLJobber {
	
	String logname = "gwendolen.verifiableautonomoussystems.chapter5.CarOnMotorwayEnvironment";
		
	/**
	 * Socket that connects to the Simulator.
	 */
	protected AILSocketClient socket;
	
	/**
	 * Has the environment concluded?
	 */
	private boolean finished = false;
	
	private int speed_limit = 5;

	/**
	 * Constructor.
	 */
	public CarOnMotorwayEnvironment() {
		super();
		MCAPLScheduler s = new NActionScheduler(100);
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
		AJPFLogger.info(logname, "Waiting Connection");
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
	@Override
	public void do_job() {
		if (socket.allok()) {
			readPredicatesfromSocket();
		}	else {
			System.err.println("something wrong with socket");
		}
	}

	/**
	 * Reading the values from the sockets and turning them into perceptions.
	 */
	public void readPredicatesfromSocket() {
		
		try {
			if (socket.pendingInput()) {

				socket.readDouble();
				socket.readDouble();
				double c1_xdot = socket.readDouble();
				double c1_ydot = socket.readDouble();
				int c1_started = socket.readInt();
				
				socket.readDouble();
				socket.readDouble();
				double c2_xdot = socket.readDouble();
				double c2_ydot = socket.readDouble();
				int c2_started = socket.readInt();
				
				
				try {
					while (socket.pendingInput()) {
						socket.readDouble();
						socket.readDouble();
						c1_xdot = socket.readDouble();
						c1_ydot = socket.readDouble();
						c1_started = socket.readInt();			
						socket.readDouble();
						socket.readDouble();
						c2_xdot = socket.readDouble();
						c2_ydot = socket.readDouble();
						c2_started = socket.readInt();			
					}
				} catch (Exception e) {
					AJPFLogger.warning(logname, e.getMessage());
				} 
				
								
				if (c1_started > 0) {
					addPercept("car1", new Literal("start"));
				}
				
				if (c2_started > 0) {
					addPercept("car2", new Literal("start"));
				}

				if (c1_ydot < speed_limit) {
					removePercept("car1", new Literal("at_speed_limit"));
				} else {
					addPercept("car1", new Literal("at_speed_limit"));
				}
				
				if (c2_ydot < speed_limit) {
					removePercept("car2", new Literal("at_speed_limit"));
				} else {
					addPercept("car2", new Literal("at_speed_limit"));
				}

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

		if (act.getFunctor().equals("accelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.01);
		} else if (act.getFunctor().equals("decelerate")) {
			socket.writeDouble(0.0);
			socket.writeDouble(-0.1);
		} else if (act.getFunctor().equals("maintain_speed")) {
			socket.writeDouble(0.0);
			socket.writeDouble(0.0);
		} else if (act.getFunctor().equals("finished")) {
			finished = true;
		}
		
		return super.executeAction(agName, act);
	}
	
	@Override
	public void cleanup() {
		socket.close();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	@Override
	public boolean done() {
		if (finished) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	@Override
	public String getName() {
		return "CarOnMotorwayEnvironment";
	}

}
