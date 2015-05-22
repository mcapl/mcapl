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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import eass.ev3.cheltenham.DinoUI;

/**
 * The simplest panel developed for Cheltenham Science Festival 2015.  Teleop controls with big buttons for small children.
 * @author lad
 *
 */
public class SimplePanel extends TabPanel {
	private static final long serialVersionUID = 1L;

	public SimplePanel(DinoUI ui, int i) {
		super(ui, i);
	}
	
	public static class SimpleTab extends TabMain {
		public SimpleTab(DinoUI ui, SimplePanel sp) {
			super(sp);
			getPanel().setLayout(new GridBagLayout());
			getPanel().setBackground(Color.WHITE);
			c.fill = GridBagConstraints.HORIZONTAL;
	
	    	// A JPanel for Controls
	    	ControlsPanel controls = new BigControlsPanel("Controls", ui);
	    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
	    	c.gridx = 0;
	    	c.gridy = 0;
	    	add(controls, c);
			
	        // The Instructions Panel
	    	ArrayList<String> instructions = new ArrayList<String>();
	    	instructions.add(InstructionsPanel.controls_ins);
	    	
	        InstructionsPanel ins = new InstructionsPanel(1, sp, "Instructions", instructions);
	        ins.setDinoFont(new Font("Sans Serif", Font.PLAIN, 20));
		    setInstructionsPanel(ins);
	        c.gridy = 1;
	        c.weighty = 1.0;
	    	c.fill = GridBagConstraints.BOTH;
	        add(ins, c);
			}

	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#enablePanels(int)
	 */
	@Override
	public void enablePanels(int step) {}

	/*
	 * (non-Javadoc)
	 * @see eass.ev3.cheltenham.ui.TabPanel#createTabMain(eass.ev3.cheltenham.DinoUI)
	 */
	@Override
	public void createTabMain(DinoUI ui) {
		mainPanel = new SimpleTab(ui, this);
		ui.addChangeListener(this);
	};

}
