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
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import eass.ev3.cheltenham.DinoUI;

/**
 * A UI Panel displaying teleoperation controls for a Lego Robot Dinosaur.
 * @author lad
 *
 */
public class ControlsPanel extends DinoPanel {
 	private static final long serialVersionUID = 1L;
 	
	protected JButton fbutton, rbutton, lbutton, sbutton, bbutton, lfbutton, flbutton, rabutton;
	
	public ControlsPanel(String title, DinoUI ui) {
		super(title, ui);
		
		setLayout(new GridLayout());
		c.weightx = 10;
		c.weighty = 10;
	    c.fill = GridBagConstraints.BOTH;
	
	    // Forward
		fbutton = new JButton("Forward");
	    fbutton.setMnemonic(KeyEvent.VK_F);
	    fbutton.setActionCommand("forward");
	    fbutton.addActionListener(ui);
	    fbutton.setToolTipText("Click to move Forward");
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 1;
	    add(fbutton, c);
		
	    // Right
	    rbutton = new JButton("Right");
	    rbutton.setMnemonic(KeyEvent.VK_R);
	    rbutton.setActionCommand("right");
	    rbutton.addActionListener(ui);
	    rbutton.setToolTipText("Click to turn Right");
	    c.gridx = 1;
	    c.gridy = 0;
	    add(rbutton, c);
	
	    // Left
	    lbutton = new JButton("Left");
	    lbutton.setMnemonic(KeyEvent.VK_L);
	    lbutton.setActionCommand("left");
	    lbutton.addActionListener(ui);
	    lbutton.setToolTipText("Click to turn Left");
	    c.gridx = 2;
	    c.gridy = 0;
	    add(lbutton, c);
	    
	    // Stop
	    sbutton = new JButton("Stop");
	    sbutton.setMnemonic(KeyEvent.VK_S);
	    sbutton.setActionCommand("stop");
	    sbutton.addActionListener(ui);
	    sbutton.setToolTipText("Click to Stop");
	    c.gridx = 3;
	    c.gridy = 0;
	    add(sbutton, c);
	    
	    // Reverse
	    bbutton = new JButton("Reverse");
	    bbutton.setMnemonic(KeyEvent.VK_S);
	    bbutton.setActionCommand("backward");
	    bbutton.addActionListener(ui);
	    bbutton.setToolTipText("Click to Go Backwards");
	    c.gridx = 4;
	    c.gridy = 0;
	    add(bbutton, c);

	    // Snap Jaws
	    lfbutton = new JButton("Snap Jaws");
	    lfbutton.setActionCommand("scare");
	    lfbutton.addActionListener(ui);
	    c.gridx = 5;
	    c.gridy = 0;
	    add(lfbutton, c);
	    
	    // Follow Line
	    flbutton = new JButton("Follow Line");
	    flbutton.setActionCommand("follow_line");
	    flbutton.addActionListener(ui);
	    c.gridx = 6;
	    c.gridy = 0;
	    add(flbutton, c); 

	    // Random
	    /*rabutton = new JButton("Random");
	    rabutton.setActionCommand("random");
	    rabutton.addActionListener(ui);
	    c.gridx = 6;
	    c.gridy = 0;
	    add(rabutton, c); */
	}


}
