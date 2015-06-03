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
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ail.syntax.Action;
import eass.ev3.cheltenham.DinoUI;

/**
 * A panel for controlling a Lego Robot Dinosaur, designed for Cheltenham Science Festival 2015.  This 
 * panel gives a simple interface for setting event-based rules.
 * @author lad
 *
 */
public class ContextFreeRulesPanel extends DinoPanel {
 	private static final long serialVersionUID = 1L;

	/*
	 * The set of actions that the robot can perform.
	 */
	protected String[] actions = {"do_nothing", "stop", "forward", "forward_a_bit", "backward", "backward_a_bit", "right", "right_a_bit", "left", "left_a_bit", "snap_jaws"};

	// Various interface components.
    JCheckBox r1button = new JCheckBox("If you"), r2button = new JCheckBox("If you");
    ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    JComboBox<String> r1action1box = new JComboBox<String>(actions), r1action2box = new JComboBox<String>(actions), r1action3box = new JComboBox<String>(actions), 
    	r2action1box = new JComboBox<String>(actions), r2action2box = new JComboBox<String>(actions), r2action3box = new JComboBox<String>(actions);
    ArrayList<JComboBox<String>> action1s = new ArrayList<JComboBox<String>>();
    ArrayList<JComboBox<String>> action2s = new ArrayList<JComboBox<String>>();
    ArrayList<JComboBox<String>> action3s = new ArrayList<JComboBox<String>>();
    JLabel r1 = new JLabel("Believe an Obstacle has appeared "); 
    JLabel r2 = new JLabel("Believe an Obstacle has vanished "); 
    ArrayList<JLabel> triggers = new ArrayList<JLabel>();
    
    JLabel act1d1 = new JLabel("then 1.");
    JLabel act1d2 = new JLabel("then 1.");
    ArrayList<JLabel> act1d = new ArrayList<JLabel>();

    JLabel act2d1 = new JLabel("2.");
    JLabel act2d2 = new JLabel("2.");
    ArrayList<JLabel> act2d = new ArrayList<JLabel>();

    JLabel act3d1 = new JLabel("3.");
    JLabel act3d2 = new JLabel("3.");
    ArrayList<JLabel> act3d = new ArrayList<JLabel>();
    

    public ContextFreeRulesPanel(String title, DinoUI ui) {
    	super(title, ui);
    	
    	triggers.add(r1);
    	triggers.add(r2);
    	
    	checkboxes.add(r1button);
    	checkboxes.add(r2button);
    	
    	act1d.add(act1d1);
    	act1d.add(act1d2);

    	act2d.add(act2d1);
    	act2d.add(act2d2);

    	act3d.add(act3d1);
    	act3d.add(act3d2);
    	
    	action1s.add(r1action1box);
    	action1s.add(r2action1box);

    	action2s.add(r1action2box);
    	action2s.add(r2action2box);

    	action3s.add(r1action3box);
    	action3s.add(r2action3box);

    	for (int i = 0; i < 2; i++) {
    		int printednumber = i + 1;
    		int gridline = i;
	    	triggers.get(i).setFont(new Font("Sans Serif", Font.BOLD, 12));
	    	
	    	String rulestring = "rule" + printednumber;
	    	checkboxes.get(i).setActionCommand(rulestring);
	    	checkboxes.get(i).addActionListener(ui);
	    	checkboxes.get(i).setToolTipText("Activate Rule " + printednumber);
	    	
	    	ruleline1(gridline, c, i);
	    	
	    	action1s.get(i).setActionCommand("r" + printednumber + "action1");
	    	action1s.get(i).addActionListener(ui);
	    	action2s.get(i).setActionCommand("r" + printednumber + "action2");
	    	action2s.get(i).addActionListener(ui);
	    	action3s.get(i).setActionCommand("r" + printednumber + "action3");
	    	action3s.get(i).addActionListener(ui);
	    	ruleline2(gridline, c, i);
    	}

	}

    /*
     * (non-Javadoc)
     * @see javax.swing.JComponent#setEnabled(boolean)
     */
    @Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	for (int i = 0; i < 2; i++) {
    		checkboxes.get(i).setEnabled(enabled);
    		if (!enabled) {
    			if ( checkboxes.get(i).isSelected() ) {
    				checkboxes.get(i).setSelected(false);
    				int rulenum = i + 1;
    				String rulestring = "rule" + rulenum;
    				getDinoUI().envThread.latestAction(new Action(rulestring), true);
    			}
    		}
    		action1s.get(i).setEnabled(enabled);
    		action2s.get(i).setEnabled(enabled);
    		action3s.get(i).setEnabled(enabled);
    		triggers.get(i).setEnabled(enabled);
    		act1d.get(i).setEnabled(enabled);
    		act2d.get(i).setEnabled(enabled);
    		act3d.get(i).setEnabled(enabled);
    	}
    }
    
    /**
     * A method for displaying the first part of a rule.
     * @param gridy
     * @param c
     * @param rulenumber
     */
    private void ruleline1(int gridy, GridBagConstraints c, int rulenumber) {
    	c.gridy = gridy;
        c.gridx = 0;
        c.gridwidth = 1;
        add(checkboxes.get(rulenumber), c);
        c.gridx = 1;
        add(triggers.get(rulenumber), c);
        c.gridx = 2;
        c.anchor = GridBagConstraints.CENTER;
    }
    
    /**
     * A method for displaying the second part of a rule.
     * @param gridy
     * @param c
     * @param rulenumber
     */
    private void ruleline2(int gridy, GridBagConstraints c, int rulenumber) {
        c.gridx = 2;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.LINE_END;
        add(act1d.get(rulenumber), c);
        c.gridx = 3;
        c.anchor = GridBagConstraints.CENTER;
        action1s.get(rulenumber).setMaximumRowCount(actions.length);
        add(action1s.get(rulenumber), c);	        
        c.gridx = 4;
        add(act2d.get(rulenumber), c);
        c.gridx = 5;
        action2s.get(rulenumber).setMaximumRowCount(actions.length);
        add(action2s.get(rulenumber), c);	   
        c.gridx = 6;
        add(act3d.get(rulenumber), c);
        c.gridx = 7;
        action3s.get(rulenumber).setMaximumRowCount(actions.length);
        add(action3s.get(rulenumber), c);	   

    }

}
