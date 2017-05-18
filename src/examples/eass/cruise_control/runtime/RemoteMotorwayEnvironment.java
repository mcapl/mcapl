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

package eass.cruise_control.runtime;

import java.io.IOException;

import eass.mas.DefaultEASSEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.util.AILSocketClient;
import ail.util.AILexception;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFLogger;
import monitor.Monitorable;

import java.util.List;
import java.util.ArrayList;

/**
 * This is an environment for connecting with the simple Java Motorway Simulation for tutorial purposes.
 * @author louiseadennis
 *
 */
public class RemoteMotorwayEnvironment extends DefaultEASSEnvironment implements Monitorable {

	String logname = "eass.cruise_control.RemoteMotorwayEnvironment";

	/**
	 * Socket that connects to the Simulator.
	 */
	protected AILSocketClient socket;

	/**
	 * Has the environment concluded?
	 */
	private boolean finished = false;

	/**
	 * Constructor.
	 */
	public RemoteMotorwayEnvironment() {
		super();
		super.scheduler_setup(this,  new NActionScheduler(100));
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

				int accelerating = socket.readInt();
				int braking = socket.readInt();
				int safe_in_lane = socket.readInt();
				double speed_limit = socket.readDouble();
				socket.readDouble();
				socket.readDouble();
				double xdot = socket.readDouble();
				double ydot = socket.readDouble();
				int started = socket.readInt();


				try {
					while (socket.pendingInput()) {
						accelerating = socket.readInt();
						braking = socket.readInt();
						safe_in_lane = socket.readInt();
						speed_limit = socket.readDouble();
						socket.readDouble();
						socket.readDouble();
						xdot = socket.readDouble();
						ydot = socket.readDouble();
						started = socket.readInt();
					}
				} catch (Exception e) {
					AJPFLogger.warning(logname, e.getMessage());
				}

				Literal speedlimit = new Literal("speed_limit");
				speedlimit.addTerm(new NumberTermImpl(speed_limit));

				Literal xspeed = new Literal("xspeed");
				xspeed.addTerm(new NumberTermImpl(xdot));

				Literal yspeed = new Literal("yspeed");
				yspeed.addTerm(new NumberTermImpl(ydot));

				if (started > 0) {
					addPercept(new Literal("started"));
				}

				if (accelerating == 1) {
					addPercept(new Literal("acceleration_pedal"));
				} else {
					removePercept(new Literal("acceleration_pedal"));
				}

				if (braking == 1) {
					addPercept(new Literal("brake_pedal"));
				} else {
					removePercept(new Literal("brake_pedal"));
				}

				if (safe_in_lane == 1) {
					addPercept(new Literal("safe_in_lane"));
				} else {
					removePercept(new Literal("safe_in_lane"));
				}
				addUniquePercept("speed_limit", speedlimit);
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

		if (act.getFunctor().equals("accelerate")) {
			socket.writeDouble(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("brake")) {
			socket.writeDouble(((NumberTerm) act.getTerm(0)).solve());
		} else if (act.getFunctor().equals("braking")) {
			socket.writeDouble(-1);
		} else if (act.getFunctor().equals("accelerating")) {
			socket.writeDouble(0.1);
		}
		return super.executeAction(agName, act);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#cleanup()
	 */
	@Override
	public void cleanup() {
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

	public String getTraceExpressionPath(){
		try {
			return MCAPLcontroller.getFilename("/src/examples/eass/cruise_control/trace_expression.pl");
		} catch (Exception e) {
			System.err.println(e);
			return "null";
		}
	}

	public String getLogFilePath(){
		return "monitor-logfile.txt";
	}

	public String getProtocolName(){
		//return "cruise_control_protocol";
		return "motorwayNew";
	}

	/*public String[] getEventsToCatch(){
		return new String[]{ "assert_shared" };
	}*/

	public void manageProtocolViolation(){

	}

}