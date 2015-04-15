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

import ail.util.AILConfig;
import ail.util.AILSocketClient;
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
	 * Are we actually connected to a socket?  Useful for debugging.
	 */
	protected boolean connectedtosocket = true;

	private String name = "Default EASS Socket Environment";
	
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
		}
	}
	
	/**
	 * Can be overridden.
	 */
	public void readPredicatesfromSocket() {}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#cleanup()
	 */
	@Override
	public void cleanup() {
		done = true;
		socket.close();
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
	
	/**
	 * We are not to connect to a socket.  Can be useful for debugging.
	 */
	public void notConnectedToSocket() {
		connectedtosocket = false;
	}
	
	/**
	 * Are we supposed to connect to a socket?
	 * @return
	 */
	public boolean connectedToSocket() {
		return connectedtosocket;
	}
	
}


