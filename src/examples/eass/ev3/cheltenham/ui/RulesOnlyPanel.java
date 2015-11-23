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

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import eass.ev3.cheltenham.DinoUI;

/**
 * A panel for controlling a Lego Robot Dinosaur, designed for Cheltenham Science Festival 2015.  This 
 * panel provides an interface for setting event-based rules but which also allows context to be taken
 * into account.
 * @author lad
 *
 */
public class RulesOnlyPanel extends TabPanel {
	private static final long serialVersionUID = 1L;
	RulesPanel rulespanel;

	public RulesOnlyPanel(DinoUI ui, int i) {
		super(ui, i);
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#createTabMain(eass.ev3.cheltenham.DinoUI)
	 */
	@Override
	public void createTabMain(DinoUI ui) {
		mainPanel = new RulesOnlyTab(ui, this);
		ui.addChangeListener(this);
	}
	
	/**
	 * Class for constructing the panel.
	 * @author louiseadennis
	 *
	 */
	public static class RulesOnlyTab extends TabMain {
		
		public RulesOnlyTab(DinoUI ui, RulesOnlyPanel rop) {
			super(rop);
			getPanel().setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = 1.0;
			gbc.weightx = 1.0;
	    		    		    	
	 
	       	// A Panel for the Sensor Streams
	        // A Panel for the ultrasound sensor values
	        SensorPanel ultra = new SensorPanel("Sensors", ui, new SensorPanel.SensorConfiguration(true, true, false, false));
	        add(ultra, gbc);
	        ultra.setEnabled(false);
	        setSensorPanel(ultra);
	
	        JPanel left = new JPanel();
	        left.setBackground(Color.WHITE);
	        left.setLayout(new GridBagLayout());
	        c.fill = GridBagConstraints.HORIZONTAL;
	        // A JPanel for Controls
	    	ControlsPanel controls = new ControlsPanel("Controls", ui);
	    	c.gridx = 0;
	    	c.gridy = 0;
	    	left.add(controls, c);
	        
	        // A JPanel for Beliefs
	        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
	     	c.gridy = 1;
	    	left.add(beliefpanel, c);
	    	beliefpanel.setEnabled(false);
	    	setBeliefPanel(beliefpanel);
	    	
	        // A JPanel for Rules
	        rop.rulespanel = new RulesPanel("Rules", ui);
	    	c.gridy = 2;
	     	left.add(rop.rulespanel, c);
	    	rop.rulespanel.setEnabled(false);
	    	
	        
	        // The Instructions Panel
	        ArrayList<String> ins = new ArrayList<String>();
	        ins.add(InstructionsPanel.controls_ins);
	        ins.add(InstructionsPanel.sensor_ins);
	        ins.add(InstructionsPanel.beliefs_ins);
	        ins.add(InstructionsPanel.rules_ins);
	        ins.add(InstructionsPanel.context_ins);
	        InstructionsPanel instructions = new InstructionsPanel(5, rop, "Instructions", ins);
		    setInstructionsPanel(instructions);
	        c.gridy = 3;
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 1.0;
			c.weightx = 1.0;
	        left.add(instructions, c);

	        gbc.gridx = 1;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = 1.0;
			gbc.weightx = 1.0;
	        add(left, gbc);
		}
 	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#hasSensorPanel()
	 */
	@Override
	public boolean hasSensorPanel() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#enablePanels(int)
	 */
	@Override
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
