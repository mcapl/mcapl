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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import ail.util.AILSocketServer;

/**
 * Simulation of a Motorway as a simple demonstrator for various systems.
 * @author lad
 *
 */
public class MotorwayComplex extends JPanel implements Runnable {
	
	static final long serialVersionUID = 0;
	
	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 550;
	private final int DELAY = 20;
	private final int LANE_START = 10;
	private final int LANE_END = B_HEIGHT;
	private final int LANE_1 = 10;
	private final int LANE_2 = 40;
	private final int LANE_3 = 70;
	private final int SPEED_LIMIT = 10;
	private final int STOPPING_DISTANCE = 46;

	private final double min_brake = 0.1;
	private final double max_brake = 1;
	private final double max_acc = 1;
	private final double epsilon = 2;
	
	
	private Thread animator;
	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Car> lane1 = new ArrayList<Car>();
	private ArrayList<Car> lane2 = new ArrayList<Car>();
	private ArrayList<Car> lane3 = new ArrayList<Car>();
	private int safe_in_lane = 1;
	
	private boolean started = false;
	private boolean running = true;

	private boolean ail_control = false;
	private int random_cars = 0;
	/**
	 * Socket that connects to the MAS environment.
	 */
	protected AILSocketServer socketserver;
	
	Random r = new Random();

	
	/**
	 * Constructor.
	 * @param args
	 */
	public MotorwayComplex(String control) {
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
			ail_control = true;
		}
		
		// Car 1 is controlled by the agent if any car is.
		Car car1 = new Car(LANE_1, LANE_START, B_WIDTH, LANE_START, B_HEIGHT, ail_control, 1);
		car1.setColor(Color.RED);
		repaint();
		if (ail_control) {
			System.err.println("Motorway Sim waiting Socket Connection");
			socketserver = new AILSocketServer();
			System.err.println("Got Socket Connection");
		} else {
			// car1.accelerate();
		}
		cars.add(car1);
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
		int carnum = 1;
		
		g.drawLine(30, 0, 30, B_HEIGHT);
		g.drawLine(60, 0, 60, B_HEIGHT);
		g.drawLine(90, 0, 90, B_HEIGHT);
		
		Double car1_distance = cars.get(0).getY();

		lane1 = new ArrayList<Car>();
		lane2 = new ArrayList<Car>();
		lane3 = new ArrayList<Car>();

		int shift = 0;
		for (Car car: cars) {
			Double dc1 = car.getX();
			Double dc2 = car.getY();
			
			Double yrel = dc2 - car1_distance;
			
			if (yrel < B_HEIGHT) {
				g.setColor(car.getColor());
				g.fillRect(dc1.intValue(), yrel.intValue() + 30, 10, 15);
				
				Double cydot = car.getYDot();
	
				g.setColor(Color.BLACK);
				g.drawString("Speed Car " + carnum + ": " + cydot.intValue(), 150, 20 + shift);
				g.drawString("Distance Car " + carnum + ": " + dc2.intValue(), 150, 50 + shift);
				
				shift = shift+50;
				carnum++;	
			}
		}

		Toolkit.getDefaultToolkit().sync();
	}
	
	private void process_lane(ArrayList<Car> lane) {
		for (int i = 0; i < lane.size() - 1; i++) {
			Car car1 = lane.get(i);
			Car car2 = lane.get(i + 1);
			
			double car1pos = car1.getY();
			double car2pos = car2.getY();
			double car1speed = car1.getYDot();
			double car1pref = car1.getSpeedPref();
			double min_safe_gap = car1pos + STOPPING_DISTANCE;
			double max_safe_gap = car1pos + 2*STOPPING_DISTANCE;
			
			boolean safe = safely_behind(car1, car2);
			
			if (car1 != cars.get(0)) {
				if (!safe) {
					car1.brake();
				} else if (max_safe_gap < car2pos && car1speed < car1pref) {
					car1.accelerate();
				} else {
					car1.setYAccel(0);
				}
			} else {
				if (safe) {
					safe_in_lane = 1;
				} else {
					safe_in_lane = 0;
				}
			}
		}
		
		if (lane.size() > 0) {
			Car last_car = lane.get(lane.size() - 1);
			if (last_car.getYDot() < last_car.getSpeedPref()) {
				last_car.accelerate();
			}
			
			if (last_car == cars.get(0)) {
				safe_in_lane = 1;
			}
		}
	}
	
	private void add_to_lane(Car car, ArrayList<Car> lane) {
		int i = 0;
		for (Car c: lane) {
			if (c.getY() > car.getY()) {
				lane.add(i, car);
				break;
			}
			i++;
		}
		
		if (lane.size() == i) {
			lane.add(car);
		}
	}
	
	/**
	 * Update the car positions and information from/to sockets.
	 */
	private void cycle() {
		
		Double car1_distance = cars.get(0).getY();
		lane1 = new ArrayList<Car>();
		lane2 = new ArrayList<Car>();
		lane3 = new ArrayList<Car>();
		ArrayList<Car> cars_to_go = new ArrayList<Car>();

		
		for (Car car: cars) {
			car.calculatePos();

			Double dc1 = car.getX();
			Double car_distance = car.getY();
			Double yrel = car_distance - car1_distance;
			if ((yrel > B_HEIGHT || yrel < -B_HEIGHT)) {
				cars_to_go.add(car);
			} else {
				
				if (dc1 < 30) {
					add_to_lane(car, lane1);
				}
				if (dc1 < 60 && dc1 + 10 >= 30) {
					add_to_lane(car, lane2);
				}
				if (dc1 < 90 && dc1 + 10 >= 60) {
					add_to_lane(car, lane3);
				}

			}
		}
		
		
		cars.removeAll(cars_to_go);
		process_lane(lane1);
		process_lane(lane2);
		process_lane(lane3);

		if (random_cars > 0) {
			int newcar = r.nextInt(random_cars);
			if (newcar == 1) {
				int lane = r.nextInt(3);
				int start_lane = LANE_3;
			if (lane == 0) {
				start_lane = LANE_1;
			} else if (lane == 1) {
				start_lane = LANE_2;
			} 
			
			Double start_y = 0.0;
			if (r.nextBoolean()) {
				start_y = car1_distance + B_HEIGHT;
			} else {
				start_y = car1_distance - B_HEIGHT;
			}
			
			
			Car car = new Car(start_lane, start_y.intValue(), B_WIDTH, LANE_START, B_HEIGHT, false, cars.size() + 1);
			int speed = r.nextInt(SPEED_LIMIT - 1);
			car.setYDot(speed + 1);
			car.setSpeedPref(speed + 1);
			cars.add(car);
			}
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
		
		for (Car car: cars) {
			car.start();
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
	public Car getCar(int i) {
		return cars.get(i);
	}
	
	
	/**
	 * Configure the motorway for this simulation.
	 * @param config
	 */
	public void configure(MotorwayConfig config) {
		cars.get(0).configure(config);
		
		if (config.containsKey("num_cars")) {
		
			int numcars = Integer.parseInt(config.getProperty("num_cars"));
			for (int i = 1; i < numcars; i++) {
				String caricontrol_string = "car" + i + ".control";
				if (config.containsKey(caricontrol_string) && config.getProperty(caricontrol_string).equals("agent")) {
					Car car = new Car(LANE_2, LANE_START, B_WIDTH, LANE_START, B_HEIGHT, true, i + 1);
					car.configure(config);
					cars.add(car);
				} else {
					Car car = new Car(LANE_2, LANE_START, B_WIDTH, LANE_START, B_HEIGHT, false, i + 1);
					car.configure(config);
					car.setYDot(r.nextInt(SPEED_LIMIT));
					cars.add(car);
				}
			}
		}
		
		if (config.containsKey("random_cars")) {
			random_cars = Integer.parseInt(config.getProperty("random_cars"));
		}
	}
	
	/**
	 * Get control information from external source.
	 */
	public void updateParameters() {
		if (cars.get(0).isControlled()) {
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
	}
	
	/**
	 * Read in values from socket.
	 */
	private void readValues() {
		for (Car car: cars) {
			if (car.isControlled()) {
				try {
					car.setYAccel(socketserver.readDouble());
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
		for (Car car: cars) {
			if ( car.isControlled() ) {
				try {
					if (accelerating) {
						socketserver.writeInt(1);
					} else {
						socketserver.writeInt(0);
					}
					if (braking) {
						socketserver.writeInt(1);
					} else {
						socketserver.writeInt(0);
					}
					socketserver.writeInt(safe_in_lane);
					socketserver.writeDouble(SPEED_LIMIT);
					socketserver.writeDouble(car.getX());
					socketserver.writeDouble(car.getY());
					socketserver.writeDouble(car.getXDot());
					socketserver.writeDouble(car.getYDot());
					socketserver.writeInt(car.started());
				}  catch (Exception e) {
					System.err.println("READ ERROR: Closing socket");
					close();
				}
			}
		}

	}
	
	public boolean safely_behind(Car follower, Car leader) {
		double xf = follower.getY();
		double xl = leader.getY();
		double vf = follower.getYDot();
		double vl = leader.getYDot();
		
		double eq1 = xf + (Math.pow(vf, 2)/(2 * min_brake)) + 
				               (max_acc/min_brake + 1)*(max_acc/2 * Math.pow(epsilon,2) + epsilon*vf);
		double eq2 = xl + (Math.pow(vl, 2)/(2 * max_brake));
		
		if (eq1 < eq2) {
			return true;
		}

		
		return false;
	}


	/**
	 * Close up the socket server.
	 */
	public void close() {
		if (cars.get(0).isControlled()) {
			socketserver.close();
		}
	}
	
	boolean accelerating = false;
	boolean braking = false;
	
	public void car1_accel() {
		if (!cars.get(0).isControlled()) {
			cars.get(0).accelerate();
		}
		accelerating = true;
	}
	
	public void car1_no_accel() {
		if (! cars.get(0).isControlled()) {
			cars.get(0).setYAccel(0);
		}
		accelerating = false;
	}
	
	public void car1_brake() {
		if (! cars.get(0).isControlled()) {
			cars.get(0).brake();
		}
		braking = true;
	}
	
	public void car1_no_brake() {
		if (! cars.get(0).isControlled()) {
			cars.get(0).setYAccel(0);
		}
		braking = false;
	}
	
	public void car1_right() {
		cars.get(0).setXDot(0.5);
	}
	
	public void car1_no_right() {
		cars.get(0).setXDot(0);
	}
	
	public void car1_left() {
		cars.get(0).setXDot(-0.5);
	}
	
	public void car1_no_left() {
		cars.get(0).setXDot(0);
	}
	

}
