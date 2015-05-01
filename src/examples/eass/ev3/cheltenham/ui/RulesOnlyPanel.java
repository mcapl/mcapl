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
    		    		    	
 
       	// A Panel for the Sensor Streams
        // A Panel for the ultrasound sensor values
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        SensorPanel ultra = new SensorPanel("Sensors", ui, new SensorPanel.SensorConfiguration(true, true, false));
        add(ultra, c);
        ultra.setEnabled(false);
        setSensorPanel(ultra);

        // A JPanel for Controls
    	ControlsPanel controls = new ControlsPanel("Controls", ui);
    	c.gridx = 1;
    	c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
    	add(controls, c);
        
        // A JPanel for Beliefs
        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
     	c.gridy = 1;
    	add(beliefpanel, c);
    	beliefpanel.setEnabled(false);
    	setBeliefPanel(beliefpanel);
    	
        // A JPanel for Rules
        rulespanel = new RulesPanel("Rules", ui);
    	c.gridy = 2;
     	add(rulespanel, c);
    	rulespanel.setEnabled(false);
    	
        
        // The Instructions Panel
        ArrayList<String> ins = new ArrayList<String>();
        ins.add(InstructionsPanel.controls_ins);
        ins.add(InstructionsPanel.sensor_ins);
        ins.add(InstructionsPanel.beliefs_ins);
        ins.add(InstructionsPanel.rules_ins);
        ins.add(InstructionsPanel.context_ins);
        InstructionsPanel instructions = new InstructionsPanel(5, this, "Instructions", ins);
	    setInstructionsPanel(instructions);
        c.gridx = 1;
        c.gridy = 3;
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
