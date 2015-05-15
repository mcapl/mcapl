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

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import eass.ev3.cheltenham.DinoUI;

/**
 * This is a large panel displaying all the potential features of the Lego Robot Dinosaurs activity at Cheltenham Science Festival 2015.
 * 
 * From this panel users can teleoperate the robot, use event-based rules (with and without contextual information), set goals and investigate
 * the interaction between rules and goals.
 * @author lad
 *
 */
public class ComplexPanel extends TabPanel {
	private static final long serialVersionUID = 1L;
	RulesPanel rulespanel;
	SetGoalPanel goals;

	public ComplexPanel(DinoUI ui, int i) {
		super(ui, i);
		c.fill = GridBagConstraints.HORIZONTAL;
		    		    	
		// A Panel for the Sensor Streams
	    // A Panel for the ultrasound sensor values
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridheight = 6;
	    c.gridwidth = 1;
	    SensorPanel ultra = new SensorPanel("Sensors", ui, new SensorPanel.SensorConfiguration(true, true, true));
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
	    GoalsPanel goalpanel = new GoalsPanel("Goals", ui);
		add(goalpanel, c);
		goalpanel.setEnabled(false);
		setGoalPanel(goalpanel);
		
	
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
        ins.add(InstructionsPanel.both_sensor_ins);
        ins.add(InstructionsPanel.both_beliefs_ins);
        ins.add(InstructionsPanel.rules_ins);
        ins.add(InstructionsPanel.context_ins);
        ins.add(InstructionsPanel.goals_ins);
        ins.add(InstructionsPanel.everything_ins);
	    InstructionsPanel instructions = new InstructionsPanel(7, this, "Instructions", ins);
	    setInstructionsPanel(instructions);
	    c.gridx = 1;
	    c.gridy = 5;
	    c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
	    add(instructions, c);
	    
	    ui.addChangeListener(this);
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
		case 6:
			goals.setEnabled(true);
			getGoalsPanel().setEnabled(true);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(true);
			break;
		case 5:
			goals.setEnabled(true);
			getGoalsPanel().setEnabled(true);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(false);
			rulespanel.choiceEnabled(false);
			break;
		case 4:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(true);
			break;
		case 3:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(true);
			getSensorPanel().setEnabled(true);
			rulespanel.setEnabled(true);
			rulespanel.choiceEnabled(false);
			break;	    			
		case 2:
			goals.setEnabled(false);
			getGoalsPanel().setEnabled(false);
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
			getGoalsPanel().setEnabled(false);
			getBeliefPanel().setEnabled(false);
			getSensorPanel().setEnabled(false);
			rulespanel.setEnabled(false);
		}
		
	}


}
