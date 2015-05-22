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
 * A Panel for controlling a Lego Robot Dinosaur by setting goals.  Developed for use at the Cheltenham Science Festival 2015.
 * @author lad
 *
 */
public class GoalsOnlyPanel extends TabPanel {
	private static final long serialVersionUID = 1L;
	RulesPanel rulespanel;
	SetGoalPanel goals;

	public GoalsOnlyPanel(DinoUI ui, int i) {
		super(ui, i);
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#createTabMain(eass.ev3.cheltenham.DinoUI)
	 */
	@Override
	public void createTabMain(DinoUI ui) {
		mainPanel = new GoalsOnlyTab(ui, this);
		mainPanel.getPanel().setBackground(Color.WHITE);
		ui.addChangeListener(this);
	}
	
	/**
	 * The actual panel contents
	 * @author louiseadennis
	 *
	 */
	public static class GoalsOnlyTab extends TabMain {
		public GoalsOnlyTab(DinoUI ui, GoalsOnlyPanel gop) {
			super(gop);
			getPanel().setLayout(new GridBagLayout());
			getPanel().setBackground(Color.WHITE);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = 1.0;
			gbc.weightx = 1.0;
			    		    	
			// A Panel for the Sensor Streams
		    // A Panel for the ultrasound sensor values
		    SensorPanel ultra = new SensorPanel("Sensors", ui, new SensorPanel.SensorConfiguration(false, true, true, false));
		    setSensorPanel(ultra);
		    add(ultra, gbc);
		    ultra.setEnabled(false);
	
		    JPanel right = new JPanel();
		    right.setLayout(new GridBagLayout());
		    // A JPanel for Controls
			ControlsPanel controls = new ControlsPanel("Controls", ui);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;
			right.add(controls, c);
		    
		    // A JPanel for Beliefs	
			c.gridy = 1;
	        BeliefPanel beliefpanel = new BeliefPanel("Beliefs", ui);
			right.add(beliefpanel, c);
			beliefpanel.setEnabled(false);
			setBeliefPanel(beliefpanel);
			
			// A JPanel for Goals
			c.gridy = 2;
		    GoalsPanel goalpanel = new GoalsPanel("Goals", ui);
			right.add(goalpanel, c);
			goalpanel.setEnabled(false);
			setGoalPanel(goalpanel);
			
			
			// A Panel for Goals
			c.gridy = 3;
			gop.goals = new SetGoalPanel("Set Goals", ui);
			right.add(gop.goals, c);
			gop.goals.setEnabled(false);
		
		    
		    // The Instructions Panel
		    ArrayList<String> ins = new ArrayList<String>();
	        ins.add(InstructionsPanel.controls_ins);
	        ins.add(InstructionsPanel.goal_sensor_ins);
	        ins.add(InstructionsPanel.goal_beliefs_ins);
	        ins.add(InstructionsPanel.goals_ins);
		    InstructionsPanel instructions = new InstructionsPanel(4, gop, "Instructions", ins);
		    setInstructionsPanel(instructions);
		    c.gridy = 4;
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 1.0;
		    right.add(instructions, c);
		    
		    gbc.gridx = 1;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = 1.0;
			add(right, gbc);
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
		case 3:
			goals.setEnabled(true);
			getGoalsPanel().setEnabled(true);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			break;
		case 2:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			break;
		case 1:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(true);
			break;
		default:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(false);
		}
		
	}


}
