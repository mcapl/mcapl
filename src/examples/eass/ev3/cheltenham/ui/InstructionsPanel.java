// ----------------------------------------------------------------------------
// Copyright (C) 2015 Strategic Facilities Technology Council 
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
package eass.ev3.cheltenham.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A Panel that displays instructions to the user of a Lego Robot Dinosaur in the activity developed for Cheltenham Science Festival 2015.
 * 
 * The instructions change as the user presses the next button, this also enables different components in the enclosing panel.
 * @author lad
 *
 */
public class InstructionsPanel extends DinoPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<String> instructions = new ArrayList<String>();
	TabPanel panel;
	int step = 0;
	int limit = 6;
	
	// The default thresholds.  These really ought to be set by consulting the agent code!
	double distancethreshold = 0.4;
	double blueupper = 0.09;
	double bluelower = 0.06;
	double path = 0.03;
	
	// The set of instructions developed for the activity.
	static String controls_ins = "  Use the Forward, Reverse, Left, Right and Stop buttons in controls to steer your dinosaur\n\n  You can can use Snap Jaws to make it chomp its teeth fearsomely.";
	static String sensor_ins = "  The Triceratops robot has sensors to get information about its surroundings\n\n  The Ultrasonic Sensor detects the distance from the front of the Triceratops to an obstacle.\n\n  You can see the values the ultrasonic sensor is returning on the left at the top.\n\n  There is also a light sensor pointing downwards that can detect the colour of light reflected from the table.\n\n You can see the green light values the colour sensor is returning on the left at the bottom.";
	static String goal_sensor_ins = "  The Triceratops robot has sensors to get information about its surroundings\n\n  There is a light sensor pointing downwards that can detect the colour of light reflected from the table.\n\n You can see the green light values the colour sensor is returning on the left at the top and the red light values on the left at the bottom\n\n  It also has an ultrasonic sensor at the front which can detect its distance from obstacles.";
	static String both_sensor_ins = "  The Triceratops robot has sensors to get information about its surroundings\n\n  There is a light sensor pointing downwards that can detect the colour of light reflected from the table.\n\n You can see the green light values the colour sensor is returning on the left in the middle and the red light values on the left at the bottom\n\n  It also has an ultrasonic sensor at the front which can detect its distance from obstacles.";
	static String beliefs_ins = "  The Triceratops robot converts the values from the sensors into beliefs.\n\n  If the value from the ultrasonic sensor falls below DISTANCE then the Triceratops believes there is an obstacle in front of it.\n\n  You can see this belief appear in the Beliefs section.\n\n  Similarly if the value of green light is between BLUELOWER and BLUEUPPER then the Triceratops believes it has found some water.\n\n  It also uses the light sensor to detect paths.  This appears in the Beliefs section as well.";
	static String goal_beliefs_ins = "  The Triceratops robot converts the values from the sensors into beliefs.\n\n  If the value of green light is between BLUELOWER and BLUEUPPER then the Triceratops believes it has found some water.\n\n  You can see this belief appear in the Beliefs section.\n\n  Similarly if the value red light falls below PATH then the Triceratops believes it has found a path.\n\n  This appears in the Beliefs section as well.\n\n  In a similar way it also generates beliefs about obstacles.";
	static String both_beliefs_ins = "  The Triceratops robot converts the values from the sensors into beliefs.\n\n  If the value from the ultrasonic sensor falls below DISTANCE then the Triceratops believes there is an obstacle in front of it.\n\n  You can see this belief appear in the Beliefs section.\n\n  Similarly if the value of green light is between BLUELOWER and BLUEUPPER then the Triceratops believes it has found some water.\n\n  Lastly if the red light value falls below PATH then the Triceratops believes it has found a path.";
	static String rules_ins = "  The Triceratops can have rules which tell it how to react to the appearance and  disappearance of obstacles.\n\n  Use the checkboxes to enable and disable rules and use the drop down menus to select the sequence of actions the Triceratops should take.\n\n  The scare action will cause the Triceratops to snap its jaws.";
	static String context_ins = "  You can vary your rules depending upon the situation the Triceratops finds itself in.\n\n  For instance if the Triceratops has found some water, it may want to behave differently when it detects something in front of it than in a situation where it hasn't found any water.\n\n Note that if two rules both apply in the same situation, then the Triceratops will only follow the first.";
	static String goals_ins = "  You can set a goal for the Triceratops.  You can see these in the Goals section above.\n\n  Achieve believe there is water will cause the Triceratops to look for water, only stopping when it believes it has found water.  The Triceratops does this by finding a path and then following it to the water.  It follows the path by turning in one direction until it can no longer see the path and then turning in the other until the path reappears.";
	static String everything_ins = " You can use goals and rules together for more complex behaviours, but watch out for the unexpected ways they can interact!!\n\n  In particular notice that goals do not go away until they are achieved, even if you can briefly interrupt their behaviour.";
	
	JTextArea info = new JTextArea(controls_ins);
	
	File log = new File("resetlog.txt");
	
	public InstructionsPanel(int limit, TabPanel panel, String title, ArrayList<String> ins) {
		super(title, panel.getDinoUI());
		this.panel = panel;
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		setLayout(layout);
		
		instructions = ins;
		
		setInfo(step);
    	info.setLineWrap(true);
    	info.setWrapStyleWord(true);
    	info.setBackground(this.getBackground());
    	info.setSize(300, 300);
    	info.setMargin(new Insets(0, 5, 0, 5));
    	
    	add(info, BorderLayout.NORTH);
    	
    	if (limit > 1) {
            JPanel buttonpanel = new JPanel();
        	add(buttonpanel, BorderLayout.SOUTH);
        	buttonpanel.setLayout(new GridBagLayout());
        	buttonpanel.setBackground(Color.WHITE);

        	JButton previousbutton = new JButton("Back");
        	JButton nextbutton = new JButton("Next");

        	previousbutton.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				if (step != 0) {
    					step--;
    					nextbutton.setEnabled(true);
    				}
    				
    				if (step == 0) {
    					previousbutton.setEnabled(false);
    				}

    				panel.enablePanels(step);
    				setInfo(step);
    			}
        		
        	});
        	c.gridx = 0;
        	c.gridy = 0;
        	c.gridwidth = 1;
        	buttonpanel.add(previousbutton, c);
        	previousbutton.setEnabled(false);

	    	nextbutton.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					if (step == limit - 1) {
						step = 0;
						previousbutton.setEnabled(false);
					} else {
						step++;
						previousbutton.setEnabled(true);
					}
					
					if (step == limit - 1) {
						nextbutton.setEnabled(false);
					}
	
					panel.enablePanels(step);
					setInfo(step);
					
				}
	    		
	    	});
	    	c.gridx = 1;
	    	c.gridy = 0;
	    	buttonpanel.add(nextbutton, c);
	
	
	    	JButton resetbutton = new JButton("Restart");
	    	resetbutton.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					if (step != 0) {
						String s = "reset: ";
						s += new Date();
						s += "\n";
						try {
							FileWriter fileWriter = new FileWriter("./logfile.txt", true);
		    				BufferedWriter bw = new BufferedWriter(fileWriter);
		    				bw.write(s);
		    				bw.close();
		    				fileWriter.close();
		    			} catch (IOException x) {
		    				System.err.println(x);
						}
						
					}
					step = 0;
					panel.enablePanels(step);
					info.setText(instructions.get(step));	
					nextbutton.setEnabled(true);
					previousbutton.setEnabled(false);
				}
	    		
	    	});
	    	c.gridx = 2;
	    	c.gridy = 0;
	    	buttonpanel.add(resetbutton, c);
	    	
	    	c.gridx = 0;
	    	c.gridy = 1;
	    	c.gridwidth = 3;
	    	c.fill = GridBagConstraints.HORIZONTAL;
    	}
	}
	
	/**
	 * Set the font for the actual instructions.
	 * @param f
	 */
	public void setDinoFont(Font f) {
		info.setFont(f);
	}
	
	/**
	 * Since the various control thresholds may have been changed - e.g., depending upon light levels in the DinoZone marquee, make sure the
	 * instructions display the correct values.
	 * @param step
	 */
	public void setInfo(int step) {
		String instruction = instructions.get(step);
		String i1 = instruction.replaceAll("DISTANCE", ((Double) distancethreshold).toString());
		String i2 = i1.replaceAll("BLUEUPPER", ((Double) blueupper).toString());
		String i3 = i2.replaceAll("BLUELOWER", ((Double) bluelower).toString());
		String i4 = i3.replaceAll("PATH", ((Double) path).toString());
		info.setText(i4);		
	}
	
	/**
	 * If the user changes the threshold update the relevant field.
	 * @param distance
	 */
	public void changeDistanceThreshold(double distance) {
		distancethreshold = distance;
	}
	
	/**
	 * If the user changes the threshold update the relevant field.
	 * @param bu
	 * @param bl
	 */
	public void changeBlueThresholds(double bu, double bl) {
		blueupper = bu;
		bluelower = bl;
	}
	
	/**
	 * If the user changes the threshold update the relevant field.
	 * @param p
	 */
	public void changePathThreshold(double p) {
		path = p;
	}

}
