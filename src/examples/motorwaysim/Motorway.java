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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import ail.util.AILSocketServer;

/**
 * Simulation of a Motorway as a simple demonstrator for various systems.
 * @author lad
 *
 */
public class Motorway extends JPanel implements Runnable {
	
	static final long serialVersionUID = 0;
	
	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 550;
	private final int INITIAL_X1 = 10;
	private final int INITIAL_Y1 = 0;
	private final int INITIAL_C2_X1 = 40;
	private final int INITIAL_C2_Y1 = 0;
	private final int DELAY = 25;
	
	private Thread animator;
	private Car car1;
	private boolean car1control = false;
	private Car car2;
	
	private boolean started = false;
	private boolean running = true;
	private boolean secondcar = false;
	
	/**
	 * Socket that connects to the MAS environment.
	 */
	protected AILSocketServer socketserver;

	
	/**
	 * Constructor.
	 * @param args
	 */
	public Motorway(String control) {
		initMotorway(control);
	}
		
	/**
	 * Initialisation.
	 * @param args
	 */
	private void initMotorway(String control) {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		
		if (control.equals("agent")) {
			car1control = true;
		}
		
		
		car1 = new Car(INITIAL_X1, INITIAL_Y1, B_WIDTH, INITIAL_Y1, B_HEIGHT, car1control, 1);
		repaint();
		if (car1control) {
			System.err.println("Motorway Sim waiting Socket Connection");
			socketserver = new AILSocketServer();
			System.err.println("Got Socket Connection");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#addNotify()
	 */
	public void addNotify() {
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawMotorway(g);
	}
	
	/**
	 * Draw the current position of the cars on the motorway.
	 * @param g
	 */
	private void drawMotorway(Graphics g) {
		Double d1 = car1.getXRel();
		Double d2 = car1.getYRel();
		
		g.drawRect(d1.intValue(), d2.intValue(), 10, 15);
		g.drawLine(30, 0, 30, B_HEIGHT);
		g.drawLine(60, 0, 60, B_HEIGHT);
		
		Double ydot = car1.getYDot();
		Double cydot = 0.0;
		Double dc2 = 0.0;
		
		if (secondcar) {
			Double dc1 = car2.getXRel();
			dc2 = car2.getYRel();
			
			g.drawRect(dc1.intValue(), dc2.intValue(), 10, 15);
			g.drawLine(30, 0, 30, B_HEIGHT);
			g.drawLine(60, 0, 60, B_HEIGHT);
			
			cydot = car2.getYDot();
			
		}
		
		g.drawString("Speed Car 1: " + ydot.intValue(), 150, 20);
		g.drawString("Distance Car 1: " + d2.intValue(), 150, 50);
		
		if (secondcar) {
			g.drawString("Speed Car 2: " + cydot.intValue(), 150, 100);
			g.drawString("Distance Car 2: " + dc2.intValue(), 150, 130);			
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Update the car positions and information from/to sockets.
	 */
	private void cycle() {
		
		car1.calculatePos();

		if (secondcar) {
			car2.calculatePos();
		}
		
		updateParameters();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		repaint();
		
		while (running) {
			
			if (started) {
				cycle();
				repaint();
			}
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;
			
			if (sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
			
			beforeTime = System.currentTimeMillis();
		} 
	}
	
	/**
	 * Called by the GUI when the user starts the simulation.
	 */
	public void start() {
		started = true;
		car1.start();
		
		if (secondcar) {
			car2.start();
		}
	}
	
	public boolean started() {
		return started;
	}
	
	/**
	 * Stop the loop in run().  Mostly  used for test cases.
	 */
	public void stop() {
		running = false;
		close();
	}
	
	/**
	 * Return car1 object.  Again mostly used for control in tests.
	 * @return
	 */
	public Car getCar1() {
		return car1;
	}
	
	/**
	 * Return Car 2 object.
	 * @return
	 */
	public Car getCar2() {
		return car2;
	}
	
	/**
	 * Configure the motorway for this simulation.
	 * @param config
	 */
	public void configure(MotorwayConfig config) {
		car1.configure(config);
		
		if (config.containsKey("car2.control")) {
			car2 = new Car(INITIAL_C2_X1, INITIAL_C2_Y1, B_WIDTH, INITIAL_Y1, B_HEIGHT, car1control, 2);
			car2.configure(config);
			secondcar = true;
		}
	}
	
	/**
	 * Get control information from external source.
	 */
	public void updateParameters() {
		if (socketserver.allok()) {
			try {
				if (socketserver.pendingInput()) {
					readValues();
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			writeValues();
 		} else {
 			System.err.println("something wrong with socket server");
 		}
	}
	
	/**
	 * Read in values from socket.
	 */
	private void readValues() {
		if (car1.isControlled()) {
			try {
				car1.setXAccel(socketserver.readDouble());
				car1.setYAccel(socketserver.readDouble());
			} catch (Exception e) {
				System.err.println("READ ERROR: Closing socket");
				close();
			}
		}
		
		if (secondcar) {
			if (car2.isControlled()) {
				try {
					car2.setXAccel(socketserver.readDouble());
					car2.setYAccel(socketserver.readDouble());
				} catch (Exception e) {
					System.err.println("READ ERROR: Closing socket");
					close();
				}
				
			}
		}

	}
	
	/**
	 * Write values to socket.
	 */
	public void writeValues() {
		if ( car1.isControlled() ) {
			try {
				if (car1.include_total_distance()) {
					socketserver.writeDouble(car1.getX());
					socketserver.writeDouble(car1.getY());
				}
				socketserver.writeDouble(car1.getXRel());
				socketserver.writeDouble(car1.getYRel());
				socketserver.writeDouble(car1.getXDot());
				socketserver.writeDouble(car1.getYDot());
				socketserver.writeInt(car1.started());
			}  catch (Exception e) {
				System.err.println("READ ERROR: Closing socket");
				close();
			}
		}
		
		if ( car2.isControlled() ) {
			try {
				if (car2.include_total_distance()) {
					socketserver.writeDouble(car2.getX());
					socketserver.writeDouble(car2.getY());
				}
				socketserver.writeDouble(car2.getXRel());
				socketserver.writeDouble(car2.getYRel());
				socketserver.writeDouble(car2.getXDot());
				socketserver.writeDouble(car2.getYDot());
				socketserver.writeInt(car2.started());
			}  catch (Exception e) {
				System.err.println("READ ERROR: Closing socket");
				close();
			}
		}

	}

	/**
	 * Close up the socket server.
	 */
	public void close() {
		socketserver.close();
	}
	

	
	

}
