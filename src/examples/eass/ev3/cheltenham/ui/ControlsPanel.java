package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import eass.ev3.cheltenham.DinoUI;

public class ControlsPanel extends DinoPanel {
    protected JButton fbutton, rbutton, lbutton, sbutton, bbutton, lfbutton;
	
	public ControlsPanel(String title, DinoUI ui) {
		super(title, ui);
	// Forward
	fbutton = new JButton("Forward");
    fbutton.setMnemonic(KeyEvent.VK_F);
    fbutton.setActionCommand("forward");
    fbutton.addActionListener(ui);
    fbutton.setToolTipText("Click to move Forward");
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    c.fill = GridBagConstraints.BOTH;
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

    
    // Reverse
    lfbutton = new JButton("Growl");
    lfbutton.setActionCommand("growl");
    lfbutton.addActionListener(ui);
    c.gridx = 5;
    c.gridy = 0;
    add(lfbutton, c);
	}


}
