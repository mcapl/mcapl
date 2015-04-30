package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;

import eass.ev3.cheltenham.DinoUI;

public class RulesOnlyPanel extends TabPanel {
	RulesPanel rulespanel;

	public RulesOnlyPanel(DinoUI ui, int i) {
		super(ui, i);
		c.fill = GridBagConstraints.HORIZONTAL;
    		    		    	
    	// A JPanel for Controls
    	ControlsPanel controls = new ControlsPanel("Controls", ui);
    	c.gridx = 0;
    	c.gridy = 1;
        c.gridwidth = 2;
    	add(controls, c);
        
        // A JPanel for Beliefs
    	c.gridx = 0;
    	c.gridy = 2;
        c.gridwidth = 2;
        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
    	add(beliefpanel, c);
    	beliefpanel.setEnabled(false);
    	setBeliefPanel(beliefpanel);
    	
        // A JPanel for Rules
    	c.gridx = 0;
    	c.gridy = 3;
        c.gridwidth = 2;
        rulespanel = new RulesPanel("Rules", ui);
    	add(rulespanel, c);
    	rulespanel.setEnabled(false);
    	
    	// A Panel for the Sensor Streams
        // A Panel for the ultrasound sensor values
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        SensorPanel ultra = new SensorPanel("Sensors", ui);
        add(ultra, c);
        ultra.setEnabled(false);
        setSensorPanel(ultra);
        
        // The Instructions Panel
        ArrayList<String> ins = new ArrayList<String>();
        ins.add(InstructionsPanel.controls_ins);
        ins.add(InstructionsPanel.sensor_ins);
        ins.add(InstructionsPanel.beliefs_ins);
        ins.add(InstructionsPanel.rules_ins);
        ins.add(InstructionsPanel.context_ins);
        InstructionsPanel instructions = new InstructionsPanel(5, this, "Instructions", ins);
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
		case 4:
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(true);
			break;
		case 3:
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(false);
			break;	    			
		case 2:
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
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(false);
			rulespanel.setEnabled(false);
	}
			

	}

}
