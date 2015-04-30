package eass.ev3.cheltenham.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InstructionsPanel extends DinoPanel {
	ArrayList<String> instructions = new ArrayList<String>();
	TabPanel panel;
	int step = 0;
	int limit = 6;
	
	static String controls_ins = "Use the Forward, Reverse, Left, Right and Stop buttons in controls to steer your robot.";
	static String sensor_ins = "The Ultrasonic Sensor detects the distance from the front of the Triceratops to an obstacle.\n\n  You can see the values it is returning on the left.";
	static String beliefs_ins = "If the value from the sensor falls below 0.5 then the Triceratops believes there is an obstacle in front of it.\n\n  You can see this belief appear in the Belief section.";
	static String rules_ins = "You can use rules to tell the Triceratops how to react to the appearance and  disappearance of obstacles.\n\n  Use the checkboxes to enable and disable rules and use the drop down menus to select the sequenc of actions the Triceratops should take.";
	static String context_ins = "You can vary your rules depending upon the situation the Triceratops finds itself in.\n\n  For instance you can create separate rules for how it should behave when an obstacle appears when the Triceratops has found water, and when it hasn't.\n\n Note that if two rules both apply in the same situation, then the Triceratops will only follow the first.";
	static String goals_ins = "You can set goals for the Triceratops to get more complex behaviours\n\n Do scare away intruders will make the Triceratops growl and gnash its teeth\n\n Achieve believe there is water will cause the Triceratops to look for water only stopping when it is found.  It does this by finding a path and then following it to the water.";

	
	public InstructionsPanel(int limit, TabPanel panel, String title, ArrayList<String> ins) {
		super(title, panel.getDinoUI());
		this.panel = panel;
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		setLayout(layout);
		
		instructions = ins;
		
    	JTextArea info1 = new JTextArea(instructions.get(step));
    	info1.setLineWrap(true);
    	info1.setWrapStyleWord(true);
    	info1.setBackground(this.getBackground());
    	info1.setSize(300, 300);
    	info1.setMargin(new Insets(0, 5, 0, 5));
    	
    	step++;
    	add(info1, BorderLayout.NORTH);
    	
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
    				info1.setText(instructions.get(step));
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
				info1.setText(instructions.get(step));
				
			}
    		
    	});
    	c.gridx = 1;
    	c.gridy = 0;
    	buttonpanel.add(nextbutton, c);


    	JButton resetbutton = new JButton("Restart");
    	resetbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				step = 0;
				panel.enablePanels(step);
				info1.setText(instructions.get(step));	
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

}
