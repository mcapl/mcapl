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

import java.awt.EventQueue;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * This is intended as a very simple motorway simulator to demonstrate aspects of the 
 * EASS Language.
 * @author lad
 *
 */
public class MotorwayMain extends JFrame implements ActionListener {
	
	static final long serialVersionUID = 0;
	
	Motorway motorway;
	static MotorwayConfig config;
	
	/*
	 * Constructor;
	 */
	public MotorwayMain(String control) {
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
    	motorway = new Motorway(control);
    	motorway.configure(config);
		add(motorway, c);
		
		c.gridy = 1;
		JButton go = new JButton("Start");
		add(go, c);
        go.setMnemonic(KeyEvent.VK_S);
        go.setActionCommand("go");
        go.addActionListener(this);
        go.setToolTipText("Click to Start");
		
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

	    addWindowListener(exitListener);

	}
	
	/**
	 * Args are presumed to be a list of cars with external control from an agent.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			configure(args[0]);
		} else {
			configure("/src/examples/eass/tutorials/motorwaysim/config.txt");
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame motorway = new MotorwayMain(config.getProperty("car1.control"));
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
		}
	}
	
	private static void configure(String filename) {
		config = new MotorwayConfig(filename);
	}
	
}
