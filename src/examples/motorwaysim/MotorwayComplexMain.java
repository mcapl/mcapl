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

import java.awt.EventQueue;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This is intended as a very simple motorway simulator to demonstrate aspects of the 
 * EASS Language.
 * @author lad
 *
 */
public class MotorwayComplexMain extends JFrame implements ActionListener {
	
	static final long serialVersionUID = 0;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	MotorwayComplex motorway;
	static MotorwayConfig config;
	
	/*
	 * Constructor;
	 */
	public MotorwayComplexMain(String control) {
		initUI(control);
	}
	
	/**
	 * Initialisation of the GUI;
	 * @param args
	 */
	private void initUI(String control) {
		setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	motorway = new MotorwayComplex(control);
    	motorway.configure(config);
		add(motorway, c);
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "accel");
		motorway.getActionMap().put("accel", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_accel();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "no_accel");
		motorway.getActionMap().put("no_accel", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_no_accel();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "brake");
		motorway.getActionMap().put("brake", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_brake();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "no_brake");
		motorway.getActionMap().put("no_brake", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_no_brake();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right");
		motorway.getActionMap().put("right", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_right();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "no_right");
		motorway.getActionMap().put("no_right", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_no_right();
			}
		});
		motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left");
		motorway.getActionMap().put("left", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_left();
			}
		});motorway.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "no_left");
		motorway.getActionMap().put("no_left", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				motorway.car1_no_left();
			}
		});
		
		c.gridy = 1;
		c.gridwidth = 1;
		JButton go = new JButton("Start");
		add(go, c);
        go.setActionCommand("go");
        go.addActionListener(this);
        go.setToolTipText("Click to Start");
        
        c.gridy = 2;
        JButton accelerate = new JButton("Accelerate");
        add(accelerate, c);
        accelerate.setActionCommand("accel");
        accelerate.addActionListener(this);
        accelerate.setToolTipText("Click to Start Accelerating");
		
        c.gridx = 1;
        JButton stop_accelerate = new JButton("Stop Accelerating");
        add(stop_accelerate, c);
        stop_accelerate.setActionCommand("no_accel");
        stop_accelerate.addActionListener(this);
        stop_accelerate.setToolTipText("Click to Stop Accelerating");

        c.gridy = 3;
        c.gridx = 0;
        JButton brake = new JButton("Brake");
        add(brake, c);
        brake.setActionCommand("brake");
        brake.addActionListener(this);
        brake.setToolTipText("Click to Start Braking");
		
        c.gridx = 1;
        JButton stop_braking = new JButton("Stop Braking");
        add(stop_braking, c);
        stop_braking.setActionCommand("no_brake");
        stop_braking.addActionListener(this);
        stop_braking.setToolTipText("Click to Stop Braking");

        c.gridy = 4;
        c.gridx = 0;
        JButton right = new JButton("Move Right");
        add(right, c);
        right.setActionCommand("right");
        right.addActionListener(this);
        right.setToolTipText("Click to Move Right");
		
        c.gridx = 1;
        JButton stop_right = new JButton("Stop Moving Right");
        add(stop_right, c);
        stop_right.setActionCommand("no_right");
        stop_right.addActionListener(this);
        stop_right.setToolTipText("Click to Stop Moving Right");

        c.gridy = 5;
        c.gridx = 0;
        JButton left = new JButton("Move Left");
        add(left, c);
        left.setActionCommand("left");
        left.addActionListener(this);
        left.setToolTipText("Click to Move Left");
		
        c.gridx = 1;
        JButton stop_left = new JButton("Stop Moving Left");
        add(stop_left, c);
        stop_left.setActionCommand("no_left");
        stop_left.addActionListener(this);
        stop_left.setToolTipText("Click to Stop Moving Left");

        setResizable(false);
		pack();
		
		setTitle("Motorway");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	        	motorway.stop();
	        	System.exit(0);
	        }
	    };
	    
	    KeyAdapter shortcuts = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					motorway.start();
				}
			}
				    	
	    };

	    addWindowListener(exitListener);
	    addKeyListener(shortcuts);
	    setFocusable(true);

	}
	
	/**
	 * Args are presumed to be a list of cars with external control from an agent.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			configure(args[0]);
		} else {
			configure("/src/examples/motorwaysim/config_automatic.txt");
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame motorway = new MotorwayComplexMain(config.getProperty("car1.control"));
				motorway.setVisible(true);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("go")) {
			motorway.start();
		} else if (e.getActionCommand().equals("accel")) {
			motorway.car1_accel();
		} else if (e.getActionCommand().equals("no_accel")) {
			motorway.car1_no_accel();
		} else if (e.getActionCommand().equals("brake")) {
			motorway.car1_brake();
		} else if (e.getActionCommand().equals("no_brake")) {
			motorway.car1_no_brake();
		} else if (e.getActionCommand().equals("right")) {
			motorway.car1_right();
		} else if (e.getActionCommand().equals("no_right")) {
			motorway.car1_no_right();
		} else if (e.getActionCommand().equals("left")) {
			motorway.car1_left();
		} else if (e.getActionCommand().equals("no_left")) {
			motorway.car1_no_left();
		}

	}
	
	private static void configure(String filename) {
		config = new MotorwayConfig(filename);
	}

}
