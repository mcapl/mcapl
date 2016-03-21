// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and Michael Fisher 
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
package eass.sticky_wheel;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.awt.GridBagLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ajpf.MCAPLcontroller;

/**
 * A very simple interface for checking the sticky_wheel implementation.  It consists of a square around which a dot representing the robot
 * can move and with some simple buttons to set targets and the stickiness of the wheel.
 * @author lad
 *
 */
public class WheeledRobotUI extends JPanel implements ActionListener,
		PropertyChangeListener, WindowListener {
	// Not sure about setting this to one.
	static final long serialVersionUID = 1;
	
	// NB. hard-coding in the program to run.
	static String path="/src/examples/eass/sticky_wheel/";
	// Uncomment the below to run the files with just the feedback controller or dead reckoning controller.
	static String config_file = "sticky_simple_switch.ail";
	// static String config_file = "sticky_feedback.ail";
	// static String config_file = "sticky_norecovery.ail";
	String rName = "sticky";
	static SimpleWheeledRobotEnv env;

	// Components.
	MovementCanvas canvas = new MovementCanvas();
	JFormattedTextField xbox, ybox, stickiness;
	JButton go, sticky;

	// Robot coordinates and wheel stickiness.
	Double target_x;
	Double target_y;
	double current_x;
	double current_y;
	double sticky_modifier = 0;
	
	public WheeledRobotUI(GridBagLayout layout) {
    	setLayout(layout);
    	GridBagConstraints c = new GridBagConstraints();
    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    	current_x = env.getX();
    	current_y = env.getY();

    	// A JPanel for Controls
    	JPanel controls = new JPanel();
    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
    	controls.setLayout(new GridBagLayout());
    	c.gridx = 0;
    	c.gridy = 1;
    	add(controls, c);
    	
    	// Setting a target
       	go = new JButton("Go!");
        go.setMnemonic(KeyEvent.VK_G);
        go.setActionCommand("go");
        go.addActionListener(this);
        go.setToolTipText("Click to Move");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        controls.add(go, c);

        JLabel xtext = new JLabel("X:");
    	controls.add(xtext);
    	NumberFormat f = NumberFormat.getInstance();
    	f.setMaximumFractionDigits(3);
    	xbox = new JFormattedTextField(f);
     	xbox.setColumns(3);
     	xbox.setValue(current_x);
    	xbox.addPropertyChangeListener(this);
    	controls.add(xbox);

    	JLabel ytext = new JLabel("Y:");
    	controls.add(ytext);
    	ybox = new JFormattedTextField(f);
     	ybox.setColumns(3);
     	ybox.setValue(current_y);
    	ybox.addPropertyChangeListener(this);
    	controls.add(ybox);
    	
    	// Setting the stickiness
    	sticky = new JButton("Set");
    	sticky.setMnemonic(KeyEvent.VK_S);
    	sticky.setActionCommand("set_sticky");
    	sticky.addActionListener(this);
    	sticky.setToolTipText("Set stickiness of Wheel");
    	c.gridx = 0;
    	c.gridy = 1;
    	c.gridwidth = 1;
    	controls.add(sticky, c);
    	
    	JLabel stickytext = new JLabel("Stickiness:");
    	c.gridx = 1;
    	controls.add(stickytext, c);
    	stickiness = new JFormattedTextField(f);
    	stickiness.setColumns(3);
    	stickiness.setValue(0.0);
    	stickiness.addPropertyChangeListener(this);
       	c.gridx = 3;
       	controls.add(stickiness, c);

        //A MovementCanvas
    	add(canvas);
    	env.setGUI(this);

	}
	
	/**
	 * I'm not sure this is the best way to get the canvas to update the location of the robot.  GUI's are not really my strong point.
	 * @param x
	 * @param y
	 * @param theta
	 */
	public void updateGraphics(double  x, double y, double theta) {
		canvas.updateGraphics(x, y, theta);
	}
	
	/**
	 * A canvas to show the path taken by the robot.
	 * @author lad
	 *
	 */
	public class MovementCanvas extends Canvas {
		static final long serialVersionUID = 2;
		
		// Where the robot is now
		double x;
		double y;
		double theta;

		// Where the robot is next
		double xp;
		double yp;
		double thetap;
		
		// The robot is a polygon (a rectangle in fact)
		Polygon robot;
		
		// Arrays for the points in the path.
		int[] xs = new int[10000];
		int[] ys = new int[10000];
		int points = 0;
		
		/**
		 * Constructor.  A 500x500 white swuare.
		 */
		public MovementCanvas() {
			setSize(500, 500);
			setBackground(Color.white);
		}
		
		/**
		 * The rectangle that is the robot!!
		 * @return
		 */
		public Polygon getPolygon() {
			Polygon p = new Polygon();
			p.addPoint((int) x, (int) y);
			double x2 = x + 3*Math.sin(theta);
			double y2 = y + 3*Math.cos(theta);
			p.addPoint((int) x2, (int) y2);
			
			double x3 = x2 - 2*Math.cos(theta);
			double y3 = y2 + 2*Math.sin(theta);
			p.addPoint((int) x3, (int) y3);
			
			double x4 = x - 2*Math.cos(theta);
			double y4 = y + 2*Math.sin(theta);
			p.addPoint((int) x4, (int) y4);
			
			return p;
			
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.awt.Canvas#paint(java.awt.Graphics)
		 */
		public void paint(Graphics g) {
			// set the positions and arrays and draw the robot.
			x = env.getX();
			y = 500 - env.getY();
			xs[points] = (int) x;
			ys[points] = (int) y;
			points++;
			theta = -env.getTheta();
			
			g.drawPolygon(getPolygon());
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.awt.Canvas#update(java.awt.Graphics)
		 */
		public void update(Graphics g) {
			// If the robot has moved update the position and arrays, join the dots in the path with a line and draw the robot's new position.
			if (((Double) xp) != null) {
				if (xp != x || yp != y) {
					x = xp;
					y = yp;
					theta=thetap;
					xs[points] = (int) xp;
					ys[points] = (int) yp;
					points++;
					g.drawPolyline(xs, ys, points);
				}
				theta=thetap;
				g.drawPolygon(getPolygon());
			}
		}
		
		/**
		 * Update the canvas with the robot's new position and then repaint it.
		 * @param x1
		 * @param y1
		 * @param theta1
		 */
		public void updateGraphics(double x1, double y1, double theta1) {
			xp = x1;
			yp = 500 - y1;
			thetap = -theta1;
			repaint();
		}
	}
	
	/**
	 * Create and set up the windoe.
	 */
	public static void createAndShowGUI() {
        JFrame frame = new JFrame("Mars Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        WheeledRobotUI contentPane = new WheeledRobotUI(new GridBagLayout());
        frame.addWindowListener(contentPane);
        frame.setContentPane(contentPane);
 
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}

    /**
     * Start up the whole application
     * @param args
     */
    public static void main(String[] args) {
    	AILConfig config = new AILConfig(path + config_file);

    	AIL.configureLogging(config);
	
    	MCAPLcontroller mccontrol = new MCAPLcontroller(config, "");
		MAS mas = AIL.AILSetup(config, mccontrol);
		env = (SimpleWheeledRobotEnv) mas.getEnv();
		
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }}
        );

        // Lastly we construct a controller.
		mccontrol.setMAS(mas);
		// Start the system.
		mccontrol.begin(); 
		mas.cleanup();
		
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
     */
	public void windowOpened(WindowEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent e) {
		// NB this should probably gracefully stop the program.
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	public void windowClosed(WindowEvent e) {
		// NB this should probably gracefully stop the program.
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	public void windowIconified(WindowEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	public void windowDeiconified(WindowEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	public void windowActivated(WindowEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	public void windowDeactivated(WindowEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		// Handle user changes in the input boxes.
		Object source = evt.getSource();
		
		if (source == xbox) {
			if (xbox.getValue() instanceof Double) {
				target_x = (Double) xbox.getValue();
			} else {
				target_x = Double.parseDouble(xbox.getValue().toString());
			}
		} else if  (source == ybox) {
			if (ybox.getValue() instanceof Double) {
				target_y = (Double) ybox.getValue();
			} else {
				target_y = Double.parseDouble(ybox.getValue().toString());
			}
		} else if (source == stickiness) {
			if (stickiness.getValue() instanceof Double) {
				sticky_modifier = (Double) stickiness.getValue();
			} else {
				sticky_modifier = Double.parseDouble(stickiness.getValue().toString());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("go")) {
			Predicate target = new Predicate("target");
			target.addTerm(new NumberTermImpl(target_x));
			target.addTerm(new NumberTermImpl(target_y));
			env.setTarget(rName, target);
		} else {
			env.setStickiness(sticky_modifier);
		}

	}

}
