// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis,  and Michael Fisher
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
package eass.tutorials.motorwaysim;

import ail.util.AILSocketServer;

/**
 * A class for a car on a simple motorway simulation that may be controlled by an agent.
 * @author lad
 *
 */
public class Car {
	private int x, y;
	private int xdot = 0, ydot = 1;
	private int xaccel = 0;
	private int yaccel = 0;
	
	private int INITIAL_X, INITIAL_Y, B_WIDTH, B_HEIGHT;
	
	private boolean controlled;

	/**
	 * Socket that connects to the agent.
	 */
	protected AILSocketServer socketserver;

	/**
	 * Constructor.
	 * @param xi
	 * @param yi
	 * @param bw
	 * @param bh
	 * @param externalcontrol
	 */
	public Car (int xi, int yi, int bw, int bh, boolean externalcontrol) {
		x = xi;
		y = yi;
		INITIAL_X = xi;
		INITIAL_Y = yi;
		B_WIDTH = bw;
		B_HEIGHT = bh;
		controlled = externalcontrol;
		
		if (controlled) {
			socketserver = new AILSocketServer();
		}

	}
	
	/**
	 * Getter for x coordinate of car.
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for y coordinate of car.
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Calculate cars new position.
	 */
	public void calculatePos() {
		xdot += xaccel;
		ydot += yaccel;
		
		x += xdot;
		y += ydot;
		
		if (y > B_HEIGHT) {
			y = INITIAL_Y;
		}
		
		if (x > B_WIDTH) {
			x = INITIAL_X;
		}

	}
	
	/**
	 * Read in new accelerations from the socket and write current position and speed to the socket.
	 */
	public void updateParameters() {
		if (controlled && socketserver.allok()) {
			// System.err.println("reading in predicates");
			readValues();
			writeValues();
			// System.err.println("finished reading in predicates");
		}	else {
			System.err.println("something wrong with socket server");
		}

	}
	
	/**
	 * Read in values from socket.
	 */
	private void readValues() {
		if (controlled) {
			xaccel = socketserver.readInt();
		
			yaccel = socketserver.readInt();
		}

	}
	
	/**
	 * Write values to socket.
	 */
	public void writeValues() {
		if ( controlled ) {
			socketserver.write(x);
			socketserver.write(y);
			socketserver.write(xdot);
			socketserver.write(ydot);
		}
	}
	
	/**
	 * Close up the socket server.
	 */
	public void close() {
		if (controlled) {
			socketserver.close();
		}
	}
}
