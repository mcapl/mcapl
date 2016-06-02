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
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ail.syntax.Action;
import eass.ev3.cheltenham.DinoUI;

/**
 * A panel containing an interface for selecting and customising event-based BDI rules for a Lego Robot Dinosaur.  Developed for Cheltenham Science Festival 2015.
 * @author lad
 *
 */
public class RulesPanel extends DinoPanel {
 	private static final long serialVersionUID = 1L;
 	// The actions the dinosaur can take.
	protected String[] actions = {"do_nothing", "stop", "forward", "forward_a_bit", "backward", "backward_a_bit", "right", "right_a_bit", "left", "left_a_bit", "snap_jaws"};
	
	// Beliefs that may be used as additional context for a rule.
    protected String[] choices = {"anything", "there is water", "there is no water"};

    // Interface components.
    JCheckBox r1button = new JCheckBox("If you"), r2button = new JCheckBox("If you"), r3button = new JCheckBox("If you"), r4button = new JCheckBox("If you");
    ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    JComboBox<String> r1action1box = new JComboBox<String>(actions), r1action2box = new JComboBox<String>(actions), r1action3box = new JComboBox<String>(actions), 
    	r2action1box = new JComboBox<String>(actions), r2action2box = new JComboBox<String>(actions), r2action3box = new JComboBox<String>(actions), 
    	r3action1box = new JComboBox<String>(actions), r3action2box = new JComboBox<String>(actions), r3action3box = new JComboBox<String>(actions), 
    	r4action1box = new JComboBox<String>(actions), r4action2box = new JComboBox<String>(actions), r4action3box = new JComboBox<String>(actions), 
    	r1choicebox = new JComboBox<String>(choices), r2choicebox = new JComboBox<String>(choices), r3choicebox = new JComboBox<String>(choices), r4choicebox = new JComboBox<String>(choices);
    ArrayList<JComboBox<String>> action1s = new ArrayList<JComboBox<String>>();
    ArrayList<JComboBox<String>> action2s = new ArrayList<JComboBox<String>>();
    ArrayList<JComboBox<String>> action3s = new ArrayList<JComboBox<String>>();
    ArrayList<JComboBox<String>> contexts = new ArrayList<JComboBox<String>>();
    JLabel r1 = new JLabel("Believe an Obstacle has appeared "); 
    JLabel r2 = new JLabel("Believe an Obstacle has vanished "); 
    JLabel r3 = new JLabel("Believe an Obstacle has appeared "); 
    JLabel r4 = new JLabel("Believe an Obstacle has vanished "); 
    ArrayList<JLabel> triggers = new ArrayList<JLabel>();
    
    JLabel act1d1 = new JLabel("then 1.");
    JLabel act1d2 = new JLabel("then 1.");
    JLabel act1d3 = new JLabel("then 1.");
    JLabel act1d4 = new JLabel("then 1.");
    ArrayList<JLabel> act1d = new ArrayList<JLabel>();

    JLabel act2d1 = new JLabel("2.");
    JLabel act2d2 = new JLabel("2.");
    JLabel act2d3 = new JLabel("2.");
    JLabel act2d4 = new JLabel("2.");
    ArrayList<JLabel> act2d = new ArrayList<JLabel>();

    JLabel act3d1 = new JLabel("3.");
    JLabel act3d2 = new JLabel("3.");
    JLabel act3d3 = new JLabel("3.");
    JLabel act3d4 = new JLabel("3.");
    ArrayList<JLabel> act3d = new ArrayList<JLabel>();

    JLabel and1 = new JLabel("and you believe");
    JLabel and2 = new JLabel("and you believe");
    JLabel and3 = new JLabel("and you believe");
    JLabel and4 = new JLabel("and you believe");
    ArrayList<JLabel> and = new ArrayList<JLabel>();
    
    public RulesPanel(String title, DinoUI ui) {
    	super(title, ui);
    	
    	triggers.add(r1);
    	triggers.add(r2);
    	triggers.add(r3);
    	triggers.add(r4);
    	
    	checkboxes.add(r1button);
    	checkboxes.add(r2button);
    	checkboxes.add(r3button);
    	checkboxes.add(r4button);
    	
    	and.add(and1);
    	and.add(and2);
    	and.add(and3);
    	and.add(and4);
    	
    	contexts.add(r1choicebox);
    	contexts.add(r2choicebox);
    	contexts.add(r3choicebox);
    	contexts.add(r4choicebox);
    	
    	act1d.add(act1d1);
    	act1d.add(act1d2);
    	act1d.add(act1d3);
    	act1d.add(act1d4);

    	act2d.add(act2d1);
    	act2d.add(act2d2);
    	act2d.add(act2d3);
    	act2d.add(act2d4);

    	act3d.add(act3d1);
    	act3d.add(act3d2);
    	act3d.add(act3d3);
    	act3d.add(act3d4);
    	
    	action1s.add(r1action1box);
    	action1s.add(r2action1box);
    	action1s.add(r3action1box);
    	action1s.add(r4action1box);

    	action2s.add(r1action2box);
    	action2s.add(r2action2box);
    	action2s.add(r3action2box);
    	action2s.add(r4action2box);

    	action3s.add(r1action3box);
    	action3s.add(r2action3box);
    	action3s.add(r3action3box);
    	action3s.add(r4action3box);
    	
    	for (int i = 0; i < 4; i++) {
    		int printednumber = i + 1;
    		int gridline = 2*i;
	    	triggers.get(i).setFont(new Font("Sans Serif", Font.BOLD, 12));
	    	
	    	String rulestring = "rule" + printednumber;
	    	checkboxes.get(i).setActionCommand(rulestring);
	    	checkboxes.get(i).addActionListener(ui);
	    	checkboxes.get(i).setToolTipText("Activate Rule " + printednumber);
	    	
	    	contexts.get(i).setActionCommand("r" + printednumber + "context");
	    	contexts.get(i).addActionListener(ui);
	    	c.gridy = gridline;
	    	add(ruleline1(gridline, i), c);
	    	
	    	action1s.get(i).setActionCommand("r" + printednumber + "action1");
	    	action1s.get(i).addActionListener(ui);
	    	action2s.get(i).setActionCommand("r" + printednumber + "action2");
	    	action2s.get(i).addActionListener(ui);
	    	action3s.get(i).setActionCommand("r" + printednumber + "action3");
	    	action3s.get(i).addActionListener(ui);
	    	c.gridy = gridline+1;
	    	add(ruleline2(gridline+1, i), c);
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
    	if (!enabled) {
    		choiceEnabled(enabled);
    	}
    }
    
    /**
     * Sometimes, when this panel is displayed, the option to customise the rules further by adding context into the rule guards
     * will be disabled.  This method controls this.
     * @param enabled
     */
    public void choiceEnabled(boolean enabled) { 
    	for (int i = 0; i < 4; i++) {
    		contexts.get(i).setEnabled(enabled);
    		and.get(i).setEnabled(enabled);
    		if (i >= 2) {
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
    }
    
    /**
     * Display the first part of the rule.
     * @param gridy
     * @param c
     * @param rulenumber
     */
    private JPanel ruleline1(int gridy, int rulenumber) {
    	JPanel line1 = new JPanel();
    	line1.setLayout(new FlowLayout());
    	line1.setBackground(Color.WHITE);
    	line1.add(checkboxes.get(rulenumber));
    	line1.add(triggers.get(rulenumber));
        line1.add(and.get(rulenumber));
        line1.add(contexts.get(rulenumber));
        return line1;
    }
    
    /**
     * Display the second part of the rule.
     * @param gridy
     * @param c
     * @param rulenumber
     */
    private JPanel ruleline2(int gridy, int rulenumber) {
    	JPanel line2 = new JPanel();
    	line2.setLayout(new FlowLayout());
    	line2.setBackground(Color.WHITE);
        line2.add(act1d.get(rulenumber));
        action1s.get(rulenumber).setMaximumRowCount(actions.length);
        line2.add(action1s.get(rulenumber));	        
        line2.add(act2d.get(rulenumber));
        action2s.get(rulenumber).setMaximumRowCount(actions.length);
        line2.add(action2s.get(rulenumber));	   
        line2.add(act3d.get(rulenumber));
        action3s.get(rulenumber).setMaximumRowCount(actions.length);
        line2.add(action3s.get(rulenumber));	  
        return line2;

    }

}
