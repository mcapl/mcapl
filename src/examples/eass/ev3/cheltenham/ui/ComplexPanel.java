package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import eass.ev3.cheltenham.DinoUI;

public class ComplexPanel extends TabPanel {
	RulesPanel rulespanel;
	GoalsPanel goalpanel;
	SetGoalPanel goals;

	public ComplexPanel(DinoUI ui, int i) {
		super(ui, i);
		c.fill = GridBagConstraints.HORIZONTAL;
		    		    	
		// A Panel for the Sensor Streams
	    // A Panel for the ultrasound sensor values
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridheight = 6;
	    SensorPanel ultra = new SensorPanel("Sensors", ui);
	    setSensorPanel(ultra);
	    add(ultra, c);
	    ultra.setEnabled(false);

	    // A JPanel for Controls
		ControlsPanel controls = new ControlsPanel("Controls", ui);
		c.gridx = 1;
		c.gridy = 0;
	    c.gridheight = 1;
		add(controls, c);
	    
	    // A JPanel for Beliefs
		c.gridx = 1;
		c.gridy = 1;
	    c.gridwidth = 1;
        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
		add(beliefpanel, c);
		beliefpanel.setEnabled(false);
		setBeliefPanel(beliefpanel);
		
		// A JPanel for Goals
		c.gridx = 1;
		c.gridy = 2;
	    c.gridwidth = 1;
	    goalpanel = new GoalsPanel("Goals", ui);
		add(goalpanel, c);
		goalpanel.setEnabled(false);
		
	
	    // A JPanel for Rules
		c.gridx = 1;
		c.gridy = 3;
	    rulespanel = new RulesPanel("Rules", ui);
		add(rulespanel, c);
		rulespanel.setEnabled(false);
		
		// A Panel for Goals
		c.gridx = 1;
		c.gridy = 4;
		goals = new SetGoalPanel("Set Goals", ui);
		add(goals, c);
		goals.setEnabled(false);
	
	    
	    // The Instructions Panel
	    ArrayList<String> ins = new ArrayList<String>();
        ins.add(InstructionsPanel.controls_ins);
        ins.add(InstructionsPanel.sensor_ins);
        ins.add(InstructionsPanel.beliefs_ins);
        ins.add(InstructionsPanel.rules_ins);
        ins.add(InstructionsPanel.context_ins);
        ins.add(InstructionsPanel.goals_ins);
	    InstructionsPanel instructions = new InstructionsPanel(6, this, "Instructions", ins);
	    c.gridx = 1;
	    c.gridy = 5;
	    c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
	    add(instructions, c);
	    
	    ui.addChangeListener(this);
	}
	
	@Override
	public boolean hasSensorPanel() {
		return true;
	}
	
	public void enablePanels(int step) {
		switch (step) {
		case 5:
			goals.setEnabled(true);
			goalpanel.setEnabled(true);
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(false);
			rulespanel.choiceEnabled(false);
			break;
		case 4:
			goals.setEnabled(false);
			goalpanel.setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(true);
			break;
		case 3:
			goals.setEnabled(false);
			goalpanel.setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(false);
			break;	    			
		case 2:
			goals.setEnabled(false);
			goalpanel.setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(false);
			break;
		case 1:
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(false);
			break;
		default:
			goals.setEnabled(false);
			goalpanel.setEnabled(false);
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(false);
			rulespanel.setEnabled(false);
		}
		
	}


}
