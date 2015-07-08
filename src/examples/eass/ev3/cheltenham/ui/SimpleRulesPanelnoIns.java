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
 * panel gives a simple interface for setting event-based rules.
 * @author lad
 *
 */
public class SimpleRulesPanelnoIns extends TabPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ContextFreeRulesPanel rulespanel;

	public SimpleRulesPanelnoIns(DinoUI ui, int i) {
		super(ui, i);
		ui.addChangeListener(this);
	}
	
	public class SimpleRulesTab extends TabMain {
		public SimpleRulesTab(DinoUI ui, SimpleRulesPanelnoIns srp) {
			super(srp);
			getPanel().setLayout(new GridBagLayout());
			
	       	// A Panel for the Sensor Streams
	        // A Panel for the ultrasound sensor values
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
	
	        JPanel left = new JPanel();
	        left.setBackground(Color.WHITE);
	        left.setLayout(new GridBagLayout());
	        // A JPanel for Controls
	    	BigControlsPanel controls = new BigControlsPanel("Controls", ui);
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    	c.gridx = 0;
	    	c.gridy = 0;
	    	left.add(controls, c);
	        
	        // A JPanel for Beliefs
	    	c.gridy++;
	        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
	    	left.add(beliefpanel, c);
	    	beliefpanel.setEnabled(true);
	    	setBeliefPanel(beliefpanel);
	    	
	        // A JPanel for Rules
	    	c.gridy++;
	        rulespanel = new ContextFreeRulesPanel("Rules", ui);
	     	left.add(rulespanel, c);
	    	rulespanel.setEnabled(true);
	        
	    	c.gridy++;
	        SensorPanel ultra = new SensorPanel("Sensors", ui, new SensorPanel.SensorConfiguration(true, false, true, false, true));
	        left.add(ultra, c);
	        ultra.setEnabled(true);
	        setSensorPanel(ultra);
		    
	        
	        // The Instructions Panel
	    	c.gridy++;
	    	c.anchor = GridBagConstraints.PAGE_END;
	    	c.weighty = 1.0;
	    	c.weightx = 1.0;
			c.fill = GridBagConstraints.BOTH;
	        ArrayList<String> ins = new ArrayList<String>();
	        ins.add(InstructionsPanel.controls_ins);
	        InstructionsPanel instructions = new InstructionsPanel(1, srp, "Instructions", ins);
		    setInstructionsPanel(instructions);

		    gbc.gridx = 0;
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
	}

	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#createTabMain(eass.ev3.cheltenham.DinoUI)
	 */
	@Override
	public void createTabMain(DinoUI ui) {
			mainPanel = new SimpleRulesTab(ui, this);
	}

}
