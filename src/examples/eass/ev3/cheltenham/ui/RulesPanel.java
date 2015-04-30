package eass.ev3.cheltenham.ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ail.syntax.Action;
import eass.ev3.cheltenham.DinoUI;

public class RulesPanel extends DinoPanel {
    protected String[] actions = {"do_nothing", "stop", "backward", "right", "left", "forward"};
    protected String[] choices = {"anything", "there is water", "there is no water"};

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
    				getDinoUI().envThread.latestAction(new Action(rulestring));
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
	    				getDinoUI().envThread.latestAction(new Action(rulestring));
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
    
    private void ruleline1(int gridy, GridBagConstraints c, int rulenumber) {
    	c.gridy = gridy;
        c.gridx = 0;
        c.gridwidth = 1;
        add(checkboxes.get(rulenumber), c);
        c.gridx = 1;
        add(triggers.get(rulenumber), c);
        c.gridx = 2;
        add(and.get(rulenumber), c);
        c.gridx = 3;
        c.anchor = GridBagConstraints.LINE_START;
        add(contexts.get(rulenumber), c);
        c.anchor = GridBagConstraints.CENTER;
    }
    
    private void ruleline2(int gridy, GridBagConstraints c, int rulenumber) {
        c.gridx = 2;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.LINE_END;
        add(act1d.get(rulenumber), c);
        c.gridx = 3;
        c.anchor = GridBagConstraints.CENTER;
        add(action1s.get(rulenumber), c);	        
        c.gridx = 4;
        add(act2d.get(rulenumber), c);
        c.gridx = 5;
        add(action2s.get(rulenumber), c);	   
        c.gridx = 6;
        add(act3d.get(rulenumber), c);
        c.gridx = 7;
        add(action3s.get(rulenumber), c);	   

    }

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
	    	ruleline1(gridline, c, i);
	    	
	    	action1s.get(i).setActionCommand("r" + printednumber + "action1");
	    	action1s.get(i).addActionListener(ui);
	    	action2s.get(i).setActionCommand("r" + printednumber + "action2");
	    	action2s.get(i).addActionListener(ui);
	    	action3s.get(i).setActionCommand("r" + printednumber + "action3");
	    	action3s.get(i).addActionListener(ui);
	    	ruleline2(gridline+1, c, i);
    	}

	}


}
