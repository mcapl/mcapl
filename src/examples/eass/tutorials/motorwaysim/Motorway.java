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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Simulation of a Motorway as a simple demonstration for the EASS Packages.
 * @author lad
 *
 */
public class Motorway extends JPanel implements Runnable {
	
	static final long serialVersionUID = 0;
	
	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 550;
	private final int INITIAL_X1 = 10;
	private final int INITIAL_Y1 = 0;
	private final int DELAY = 25;
	
	private Thread animator;
	private Car car1;
	private boolean car1control = false;
	
	/**
	 * Constructor.
	 * @param args
	 */
	public Motorway(boolean control) {
		initMotorway(control);
	}
		
	/**
	 * Initialisation.
	 * @param args
	 */
	private void initMotorway(boolean control) {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		
		car1control = control;
		
		
		car1 = new Car(INITIAL_X1, INITIAL_Y1, B_WIDTH, B_HEIGHT, car1control);
		repaint();
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
		g.drawRect(car1.getX(), car1.getY(), 10, 15);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Update the car positions and information from/to sockets.
	 */
	private void cycle() {
		
		car1.calculatePos();
		car1.updateParameters();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		repaint();
		
		while (true) {
			
			cycle();
			repaint();
			
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

}
