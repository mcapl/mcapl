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

import javax.swing.JButton;

import ail.syntax.Action;
import eass.ev3.cheltenham.DinoUI;

/**
 * A panel for setting goals for a Lego Robot Dinosaur.  
 * @author lad
 *
 */
public class SetGoalPanel extends DinoPanel {
	private static final long serialVersionUID = 1L;
	JButton growl = new JButton("Do scare away intruders"), find_water = new JButton("Achieve believe there is water"), drop_goal = new JButton("Stop trying to find water");
	
	
	public SetGoalPanel(String title, DinoUI ui) {
		super(title, ui);
		find_water.setActionCommand("achieve_water");
		find_water.addActionListener(ui);
		drop_goal.setActionCommand("drop_goal");
		drop_goal.addActionListener(ui);
		c.gridx = 0;
		c.gridwidth = 1;
		add(find_water);
		c.gridx = 1;
		add(drop_goal);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		growl.setEnabled(enabled);
		find_water.setEnabled(enabled);
		drop_goal.setEnabled(enabled);
		if (!enabled) {
			getDinoUI().envThread.latestAction(new Action("drop_goal"));
		}

	}
}
