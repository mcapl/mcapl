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

import java.io.IOException;

import ail.util.AILConfig;
import ail.util.AILSocketClient;
import eass.mas.DefaultEASSEnvironment;
import ajpf.util.AJPFLogger;

/**
 * An basic class providing functionality for EASS environments which are client's for some socket.
 * @author louiseadennis
 *
 */
public abstract class EASSSocketClientEnvironment extends DefaultEASSEnvironment {
	/**
	 * Socket that connects to the Physical Engine.
	 */
	protected AILSocketClient socket;

	/**
	 * Are we actually connected to a socket?  Useful for debugging where it can be set to false,
	 * and this classes methods overridden as appropriate for testing behaviour.
	 */
	protected boolean connectedtosocket = true;

	/**
	 * Name for the environment.
	 */
	private String name = "Default EASS Socket Environment";
	
	/**
	 * The port number for the socket  (Default 6253)
	 */
	protected int portnumber = 6253;
	
	/**
	 * Constructor - creates sockets.
	 *
	 */
	public EASSSocketClientEnvironment() {
		super();
	}
	
	/**
	 * Constructor - creates sockets.
	 *
	 */
	public EASSSocketClientEnvironment(int portnumber) {
		super();
		this.portnumber = portnumber;
	}


	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#init_after_adding_agents()
	 */
	@Override
	public void init_after_adding_agents() {
		if (connectedtosocket) {
			AJPFLogger.info("eass.mas", "Waiting Connection");
			try {
				socket = new AILSocketClient(portnumber);
			} catch (IOException e) {
				AJPFLogger.severe("eass.mas", e.getMessage());
				System.exit(0);
			}
			AJPFLogger.info("eass.mas", "Connected to Socket");
		}		
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#do_job()
	 */
	@Override
	public void do_job() {
		if (connectedtosocket) {
			if (socket.allok()) {
				readPredicatesfromSocket();
			}	else {
				System.err.println("something wrong with socket");
			}
		} else {
			debuggingPredicates();
		}
	}
	
	/**
	 * To be overridden.  This method dictates how information from the socket should be converted to predicates.
	 */
	public abstract void readPredicatesfromSocket();
	
	/**
	 * Can be overridden.  This method dictates how predicates should be generated when the environment is not connected to a socket.
	 */
	public void debuggingPredicates() {};

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#cleanup()
	 */
	@Override
	public void cleanup() {
		done = true;
		if (connectedtosocket) {
			socket.close();
		}
	}
			
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#done()
	 */
	@Override
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
	@Override
	public void configure(AILConfig config) {
		if (config.containsKey("connectedtosocket")) {
			if (config.getProperty("connectedtosocket").equals("false")) {
				connectedtosocket = false;
			} else {
				connectedtosocket = true;
			}
		}
	}
	
	/**
	 * Indicate that the environment is not connected to a socket.
	 */
	public void notConnectedToSocket() {
		connectedtosocket = false;
	}
	
	/**
	 * Return whether the environment is connected to a socket.
	 * @return
	 */
	public boolean connectedToSocket() {
		return connectedtosocket;
	}
	
	/**
	 * Getter for the socket.
	 * @return
	 */
	public AILSocketClient getSocket() {
		return socket;
	}
	
}


