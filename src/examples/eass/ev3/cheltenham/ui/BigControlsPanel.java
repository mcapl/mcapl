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

import java.awt.Font;
import java.awt.Insets;

import eass.ev3.cheltenham.DinoUI;

/**
 * This is a class to display a very simple control panel for Lego Robot Dinosaurs with large friendly buttons for controlling
 * the dinosaur.  Intended for use with toddlers and small children.
 * @author lad
 *
 */
public class BigControlsPanel extends ControlsPanel {
	private static final long serialVersionUID = 1L;

	public BigControlsPanel(String title, DinoUI ui) {
		super(title, ui);
		fbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		rbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		bbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		lbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		sbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		lfbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		flbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		Insets buttonpadding = new Insets(20, 10, 20, 10);
		fbutton.setMargin(buttonpadding);
		rbutton.setMargin(buttonpadding);
		bbutton.setMargin(buttonpadding);
		lbutton.setMargin(buttonpadding);
		sbutton.setMargin(buttonpadding);
		lfbutton.setMargin(buttonpadding);
		flbutton.setMargin(buttonpadding);
		
	}

}
