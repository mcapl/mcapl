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

package eass.mas.socket;

import java.util.HashMap;

import ail.util.AILConfig;
import ail.util.AILSocketClient;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.VarTerm;
import eass.mas.DefaultEASSEnvironment;

import ajpf.util.AJPFLogger;

/**
 * Default environment class for EASS project.  Sets up socket servers and generic actions.  As originally developed for EASS Project.
 * @author louiseadennis
 *
 */
public class EASSSocketClientEnvironment extends DefaultEASSEnvironment {
	/**
	 * Socket that connects to the Physical Engine.
	 */
	protected AILSocketClient socket;

	/**
	 * Tracking of input predicates.
	 */
	HashMap<String, Literal> values = new HashMap<String, Literal>();

	/**
	 * Are we actually connected to a socket?  Useful for debugging.
	 */
	protected boolean connectedtosocket = true;


	private String name = "Default EASS Socket Environment";
	
	protected int control = 0;
	int misccounter = 0;
	boolean running = true;
	int version = 1;

	/**
	 * Constructor - creates sockets.
	 *
	 */
	public EASSSocketClientEnvironment() {
		super();
	}
	
	
	public void initialise() {
		if (connectedtosocket) {
			AJPFLogger.info("eass.mas", "Waiting Connection");
			socket = new AILSocketClient();
			AJPFLogger.info("eass.mas", "Connected to Socket");
		}		
	}
	
	
	
	public void do_job() {
		if (connectedtosocket) {
			if (socket.allok()) {
				readPredicatesfromSocket();
			}	else {
				System.err.println("something wrong with socket");
			}
		}
			
		super.do_job();
	}
	
	public void readPredicatesfromSocket() {}

	
	public void finalize() {
		done = true;
		socket.close();
	}
	
	/**
	 * Overridable function.
	 *
	 */
	public void eachrun() {
		
	}
	
	public void printvalues(Literal pred) {
	
	}
	
	public void noconnection_run(String agname, Action act) {
		System.err.println("No Socket Connection: " + act.toString());
	}
	
	public Literal noconnection_calc(Predicate predicate, VarTerm val, Unifier u) {
		try {
			System.err.println("calculated");
		} catch (Exception e) {
			System.err.println("didn't sleep");
		}
		Literal result = new Literal("result");
		result.addTerm(predicate);
		result.addTerm(new Predicate("result"));
		return result;
	}

	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	public boolean done() {
		if (done) {
			return true;
		}
		return false;
	}
						
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
		if (config.containsKey("connectedtosocket")) {
			if (config.getProperty("connectedtosocket").equals("false")) {
				connectedtosocket = false;
			} else {
				connectedtosocket = true;
			}
		}
	}
	
	public void notConnectedToSocket() {
		connectedtosocket = false;
	}
	
	public boolean connectedToSocket() {
		return connectedtosocket;
	}
	
}


