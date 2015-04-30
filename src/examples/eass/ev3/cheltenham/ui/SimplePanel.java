package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import eass.ev3.cheltenham.DinoUI;

public class SimplePanel extends TabPanel {
	public SimplePanel(DinoUI ui, int i) {
		super(ui, i);
    	c.fill = GridBagConstraints.HORIZONTAL;

    	// A JPanel for Controls
    	ControlsPanel controls = new BigControlsPanel("Controls", ui);
    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
    	c.gridx = 0;
    	c.gridy = 1;
        c.gridwidth = 2;
    	add(controls, c);
		
        // The Instructions Panel
    	ArrayList<String> instructions = new ArrayList<String>();
    	instructions.add(InstructionsPanel.controls_ins);
    	
        InstructionsPanel ins = new InstructionsPanel(1, this, "Instructions", instructions);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
    	c.fill = GridBagConstraints.BOTH;
        add(ins, c);

	}
	
	@Override
	public void enablePanels(int step) {};

}
