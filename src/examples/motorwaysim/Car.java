// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Michael Fisher 
// 
// This file is part of A Really Simple Motorway Simulation (RSMS)
// 
// RSMS is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// RSMS is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with RSMS; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package motorwaysim;

import java.awt.Color;

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
	
	private int INITIAL_X, INITIAL_Y, B_WIDTH, MIN_Y, MAX_Y;
	private double DEFAULT_ACCELERATION = 0.01;
	private double DEFAULT_BRAKE = -0.1;
	
	private boolean controlled;
	private boolean include_total_distance;
	private int started = 0;
	@SuppressWarnings("unused")
	private int carnum = 1;
	
	Color color = Color.BLACK;
	double pref_y = 0.0;

	/**
	 * Constructor.
	 * @param xi
	 * @param yi
	 * @param bw
	 * @param bh
	 * @param externalcontrol
	 * @param carnum
	 */
	public Car (int xi, int yi, int bw, int miny, int bh, boolean externalcontrol, int carnum) {
		x = xi;
		y = yi;
		xrel = xi;
		yrel = yi;
		INITIAL_X = xi;
		INITIAL_Y = yi;
		B_WIDTH = bw;
		MAX_Y = bh;
		MIN_Y = miny;
		controlled = externalcontrol;
		this.carnum = carnum;

	}
	
	/**
	 * Getter for x coordinate of car.
	 * @return
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Getter for y coordinate of car.
	 * @return
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Getter for the x coordinate relative to the top of the GUI.
	 * @return
	 */
	public double getXRel() {
		return xrel;
	}
	
	/**
	 * Getter for the y coordinate relative to the top of the GUI.
	 * @return
	 */
	public double getYRel() {
		return yrel;
	}
	
	/**
	 * Getter for the speed in the x direction
	 * @return
	 */
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
	
	public void setSpeedPref(double speed) {
		pref_y = speed;
	}
	
	public double getSpeedPref() {
		return pref_y;
	}
	
	/**
	 * Setter for the x speed.
	 * @param speed
	 */
	public void setXDot(double speed) {
		xdot = speed;
	}

	/**
	 * Getter for total distance in the y direction.
	 * @return
	 */
	public double getYTot() {
		return y;
	}
	
	/**
	 * Getter for total distance in the x direction.
	 * @return
	 */
	public double getXTot() {
		return x;
	}
	
	/**
	 * Setter for the acceleration in the x direction.
	 * @param a
	 */
	public void setXAccel(double a) {
		xaccel = a;
	}
	
	/**
	 * Setter for the acceleration in the y direction.
	 * @param a
	 */
	public void setYAccel(double a) {
		yaccel = a;
	}

	/**
	 * Calculate cars new position.
	 */
	public void calculatePos() {
		xdot += xaccel;
		ydot += yaccel;
				
		if (ydot < 0) {
			ydot = 0;
		}
		
		x += xdot;
		y += ydot;
		xrel += xdot;
		yrel += ydot;

		
		if (yrel > MAX_Y) {
			yrel = MIN_Y;
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
	
	/**
	 * Is the car being controlled externally to the simulator?
	 * @return
	 */
	public boolean isControlled() {
		return controlled;
	}
	
	/**
	 * Calculate total distances travelled not just relative to the top of the GUI.
	 * @return
	 */
	public boolean include_total_distance() {
		return include_total_distance;
	}
	
	/**
	 * Has the car started?
	 * @return
	 */
	public int started() {
		return started;
	}
	
	public void accelerate() {
		setYAccel(DEFAULT_ACCELERATION);
	}
	
	public void brake() {
		setYAccel(DEFAULT_BRAKE);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
}
