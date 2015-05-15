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

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import eass.ev3.cheltenham.DinoUI;

/**
 * A generic class for a component of the interface for the Lego Robot Dinosaurs activity used at Cheltenham Science Festival 2015.
 * @author lad
 *
 */
public class DinoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public GridBagConstraints c = new GridBagConstraints();
	
	/* The Top Level UI that contains the panel.*/
	DinoUI dinoUI;
	
	/**
	 * A Dino Panel has a white background and a GridBagLayout.
	 * @param ui
	 */
	public DinoPanel(DinoUI ui) {
		dinoUI = ui;
		setLayout(new GridBagLayout());	
		setBackground(Color.WHITE);
	}
	
	public DinoPanel(String title, DinoUI ui) {
		this(ui);
		setBorder(BorderFactory.createTitledBorder(loweredetched, title));
	}
	
	/**
	 * Return the top level UI for the panel.
	 * @return
	 */
	public DinoUI getDinoUI() {
		return dinoUI;
	}

}
