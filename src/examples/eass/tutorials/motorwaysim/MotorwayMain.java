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
import javax.swing.JFrame;

/**
 * This is intended as a very simple motorway simulator to demonstrate aspects of the 
 * EASS Language.
 * @author lad
 *
 */
public class MotorwayMain extends JFrame {
	
	static final long serialVersionUID = 0;
	
	/*
	 * Constructor;
	 */
	public MotorwayMain(boolean control) {
		initUI(control);
	}
	
	/**
	 * Initialisation of the GUI;
	 * @param args
	 */
	private void initUI(boolean control) {
		add(new Motorway(control));
		
		setResizable(false);
		pack();
		
		setTitle("Motorway");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Args are presumed to be a list of cars with external control from an agent.
	 * @param args
	 */
	public static void main(String[] args) {
		boolean controlnf = false;
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("1")) {
					controlnf = true;
				}
			}
		}
		
		final boolean control = controlnf;

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame motorway = new MotorwayMain(control);
				motorway.setVisible(true);
			}
		});
	}

}
