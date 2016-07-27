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
package motorwaysim;

import ail.util.AILSocketServer;

/**
 * A class for a car on a simple motorway simulation that may be controlled by an agent.
 * @author lad
 *
 */
public class Car {
	private double x, y, xrel, yrel;
	private double xdot = 0, ydot = 0;
	private double xaccel = 0;
	private double yaccel = 0;
	
	private int INITIAL_X, INITIAL_Y, B_WIDTH, B_HEIGHT;
	
	private boolean controlled;
	private boolean include_total_distance;
	private int started = 0;
	private int carnum = 1;


	/**
	 * Constructor.
	 * @param xi
	 * @param yi
	 * @param bw
	 * @param bh
	 * @param externalcontrol
	 */
	public Car (int xi, int yi, int bw, int bh, boolean externalcontrol, int carnum) {
		x = xi;
		y = yi;
		xrel = xi;
		yrel = yi;
		INITIAL_X = xi;
		INITIAL_Y = yi;
		B_WIDTH = bw;
		B_HEIGHT = bh;
		controlled = externalcontrol;
		this.carnum = carnum;

	}
	
	/**
	 * Getter for x coordinate of car.
	 * @return
	 */
	public double getX() {
		return xrel;
	}
	
	/**
	 * Getter for y coordinate of car.
	 * @return
	 */
	public double getY() {
		return yrel;
	}
	
	public double getXRel() {
		return xrel;
	}
	
	public double getYRel() {
		return yrel;
	}
	
	public double getXDot() {
		return xdot;
	}
	
	/**
	 * Getter for speed in the y direction.
	 * @return
	 */
	public double getYDot() {
		return ydot;
	}
	
	/**
	 * Setter for the y speed.
	 * @param speed
	 */
	public void setYDot(double speed) {
		ydot = speed;
	}
	
	/**
	 * Getter for speed in the y direction.
	 * @return
	 */
	public double getYTot() {
		return y;
	}
	
	public void setXAccel(double a) {
		xaccel = a;
	}
	
	public void setYAccel(double a) {
		yaccel = a;
	}

	/**
	 * Calculate cars new position.
	 */
	public void calculatePos() {
		xdot += xaccel;
		ydot += yaccel;
		
//		System.err.println(ydot);
		
		
		if (xdot < 0) {
			xdot = 0;
		}
		
		if (ydot < 0) {
			ydot = 0;
		}
		
		x += xdot;
		y += ydot;
		xrel += xdot;
		yrel += ydot;

		//		System.err.println(y);
		
		if (yrel > B_HEIGHT) {
			yrel = INITIAL_Y;
		}
		
		if (xrel > B_WIDTH) {
			xrel = INITIAL_X;
		}

	}
		
	/**
	 * Called to tell the car that the simulation has started.
	 */
	public void start() {
		started = 1;
	}
	
	/** 
	 * Configure the car.
	 * @param config
	 */
	public void configure(MotorwayConfig config) {
		if (config.containsKey("data.include_total_distance")) {
			if (config.getProperty("data.include_total_distance").equals("true")) {
				include_total_distance = true;
			}
		}
	}
	
	public boolean isControlled() {
		return controlled;
	}
	
	public boolean include_total_distance() {
		return include_total_distance();
	}
	
	public int started() {
		return started();
	}
}
