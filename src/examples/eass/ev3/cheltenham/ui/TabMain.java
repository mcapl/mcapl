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
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

/**
 * A class for the the main panel in one of the tabbed panes.  Constructed this way largely to minimize effort and errors 
 * when refactoring.  Hence why it contains a JPanel, rather than extending a JPanel.
 * @author louiseadennis
 *
 */
public class TabMain {
	JPanel mainPanel = new JPanel();
	GridBagConstraints c = new GridBagConstraints();
	TabPanel panel;
	
	public TabMain(TabPanel tb) {
		panel = tb;
		mainPanel.setBackground(Color.WHITE);
	}
	
	/**
	 * Getter for the panel constructed by this object.
	 * @return
	 */
	public JPanel getPanel() {
		return mainPanel;
	}
	
	/**
	 * Pass on add methods to the panel.
	 * @param comp
	 * @param gbc
	 */
	public void add(Component comp, GridBagConstraints gbc) {
		mainPanel.add(comp, gbc);
	}
	
	/**
	 * Pass on add methods to the panel.
	 * @param comp
	 * @param gbc
	 */
	public void add(Component comp) {
		mainPanel.add(comp);
	}

	/**
	 * Pass on sub-panel setting methods to the TabPanel.
	 * @param sp
	 */
	public void setSensorPanel(SensorPanel sp) {
		panel.setSensorPanel(sp);
	}
	
	/**
	 * Pass on sub-panel setting methods to the TabPanel.
	 * @param sp
	 */
	public void setBeliefPanel(BeliefPanel bp) {
		panel.setBeliefPanel(bp);
	}
	
	/**
	 * Pass on sub-panel setting methods to the TabPanel.
	 * @param sp
	 */
	public void setGoalPanel(GoalsPanel gp) {
		panel.setGoalPanel(gp);
	}
	
	/**
	 * Pass on sub-panel setting methods to the TabPanel.
	 * @param sp
	 */
	public void setInstructionsPanel(InstructionsPanel ip) {
		panel.setInstructionsPanel(ip);
	}
}
