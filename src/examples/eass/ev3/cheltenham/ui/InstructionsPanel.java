package eass.ev3.cheltenham.ui;

import java.awt.BorderLayout;
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
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;

import static java.nio.file.StandardOpenOption.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InstructionsPanel extends DinoPanel {
	ArrayList<String> instructions = new ArrayList<String>();
	TabPanel panel;
	int step = 0;
	int limit = 6;
	
	double distancethreshold = 0.5;
	double blueupper = 0.15;
	double bluelower = 0.1;
	double path = 0.05;
	
	static String controls_ins = "  Use the Forward, Reverse, Left, Right and Stop buttons in controls to steer your dinosaur\n\n  You can can use Snap Jaws to make it chomp its teeth fearsomely.";
	static String sensor_ins = "  The Triceratops robot has sensors to get information about its surroundings\n\n  The Ultrasonic Sensor detects the distance from the front of the Triceratops to an obstacle.\n\n  You can see the values the ultrasonic sensor is returning on the left at the top.\n\n  There is also a light sensor pointing downwards that can detect the colour of light reflected from the table.\n\n You can see the blue light values the colour sensor is returning on the left at the bottom.";
	static String beliefs_ins = "  The Triceratops robot converts the values from the sensors into beliefs.\n\n  If the value from the ultrasonic sensor falls below DISTANCE then the Triceratops believes there is an obstacle in front of it.\n\n  You can see this belief appear in the Beliefs section.\n\n  Similarly if the value of blue light is between BLUELOWER and BLUEUPPER then the Triceratops believes it has found some water.\n\n  It also uses the light sensor to detect paths.  This appears in the Beliefs section as well.";
	static String rules_ins = "  The Triceratops can have rules which tell it how to react to the appearance and  disappearance of obstacles.\n\n  Use the checkboxes to enable and disable rules and use the drop down menus to select the sequence of actions the Triceratops should take.\n\n  The scare action will cause the Triceratops to snap its jaws.";
	static String context_ins = "  You can vary your rules depending upon the situation the Triceratops finds itself in.\n\n  For instance if the Triceratops has found some water, it may want to behave differently when it detects something in front of it than in a situation where it hasn't found any water.\n\n Note that if two rules both apply in the same situation, then the Triceratops will only follow the first.";
	static String goals_ins = "You can set goals for the Triceratops to get more complex behaviours\n\n Do scare away intruders will make the Triceratops growl and gnash its teeth\n\n Achieve believe there is water will cause the Triceratops to look for water only stopping when it is found.  It does this by finding a path and then following it to the water.";

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
	
	public void setDinoFont(Font f) {
		info.setFont(f);
	}
	
	public void setInfo(int step) {
		String instruction = instructions.get(step);
		String i1 = instruction.replaceAll("DISTANCE", ((Double) distancethreshold).toString());
		String i2 = i1.replaceAll("BLUEUPPER", ((Double) blueupper).toString());
		String i3 = i2.replaceAll("BLUELOWER", ((Double) bluelower).toString());
		String i4 = i3.replaceAll("PATH", ((Double) path).toString());
		info.setText(i4);		
	}
	
	public void changeDistanceThreshold(double distance) {
		distancethreshold = distance;
	}
	
	public void changeBlueThresholds(double bu, double bl) {
		blueupper = bu;
		bluelower = bl;
	}
	
	public void changePathThreshold(double p) {
		path = p;
	}

}
