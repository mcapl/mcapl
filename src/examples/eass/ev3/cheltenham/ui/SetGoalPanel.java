package eass.ev3.cheltenham.ui;

import javax.swing.JButton;

import ail.syntax.Action;
import eass.ev3.cheltenham.DinoUI;

public class SetGoalPanel extends DinoPanel {
	JButton growl = new JButton("Do scare away intruders"), find_water = new JButton("Achieve believe there is water"), drop_goal = new JButton("Stop trying to find water");
	
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
	
	public SetGoalPanel(String title, DinoUI ui) {
		super(title, ui);
//		growl.setActionCommand("do_growl");
//		growl.addActionListener(ui);
		find_water.setActionCommand("achieve_water");
		find_water.addActionListener(ui);
		drop_goal.setActionCommand("drop_goal");
		drop_goal.addActionListener(ui);
		c.gridx = 0;
		c.gridwidth = 1;
//		add(growl, c);
//		c.gridx = 1;
		add(find_water);
		c.gridx = 1;
		add(drop_goal);
	}

}
