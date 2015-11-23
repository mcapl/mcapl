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
import ail.semantics.AILAgent;
import ail.syntax.Capability;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ajpf.MCAPLcontroller;

/**
 * A very simple interface for checking the sticky_wheel implementation.  It consists of a square around which a dot representing the robot
 * can move and with some simple buttons to set targets and the stickiness of the wheel.
 * @author lad
 *
 */
public class EfficiencyTest {
	// Not sure about setting this to one.
	static final long serialVersionUID = 1;
	
	// NB. hard-coding in the program to run.
	static String path="/src/examples/eass/sticky_wheel/";
	// Uncomment the below to run the files with just the feedback controller or dead reckoning controller.
	static String config_file = "sticky_test1.ail";
	// static String config_file = "sticky_feedback.ail";
	// static String config_file = "sticky_norecovery.ail";
	static String rName = "sticky";
	static SimpleWheeledRobotEnv env;

	// Robot coordinates and wheel stickiness.
	Double target_x;
	Double target_y;
	double current_x;
	double current_y;
	static double sticky_modifier = 10;
	static int runs = 50;
		
    /**
     * Start up the whole application
     * @param args
     */
    public static void main(String[] args) {
     	int test_number = Integer.parseInt(args[0]);
 
     	long total_time = 0;
    	
    	for (int i = 1; i <= runs; i++) {
        	long start = System.currentTimeMillis();
	    	AILConfig config = new AILConfig(path + config_file);
	
	    	AIL.configureLogging(config);
		
			MAS mas = AIL.AILSetup(config);
			env = (SimpleWheeledRobotEnv) mas.getEnv();
			
			for (int j = 1; j <= test_number; j++) {
				addCap(j);
			}
			
			env.setStickiness(sticky_modifier);
			Predicate target = new Predicate("target");
			target.addTerm(new NumberTermImpl(150));
			target.addTerm(new NumberTermImpl(150));
			env.setTarget(rName, target);
			
	        // Lastly we construct a controller.
			MCAPLcontroller mccontrol = new MCAPLcontroller(mas, "", 1);
			// Start the system.
			mccontrol.begin(); 
			mas.cleanup();
			long end = System.currentTimeMillis();
			// System.out.println((end - start) + " ms");
			total_time += (end - start);
    	}
    	
    	System.out.println("Average time for " + test_number + " capabilities over " + runs + " runs is " + total_time/runs + " ms");
		
    }
    
    public static void addCap(int number) {
    	Predicate precondition = new Predicate("precondition");
    	Predicate postcondition = new Predicate("postcondition");
    	Predicate capname = new Predicate("capability" + number);
    	env.addCap(new Capability(new Guard(new GBelief(precondition)), capname, new Guard(new GBelief(postcondition))), rName);
    }


}
