package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import eass.ev3.cheltenham.DinoUI;


public abstract class TabPanel extends DinoPanel implements ChangeListener {
		SensorPanel sPanel;
		BeliefPanel bPanel;
		GoalsPanel gPanel;
		int index;
    	JLabel twitter = new JLabel("If you've enjoyed this activity why not tweet us your thoughts and photos: @legorovers #legodinos");
		
		public TabPanel(DinoUI ui, int tabindex) {
			super(ui);
			index = tabindex;
			
			c.gridx = 0;
			c.gridy = 8;
			c.gridwidth = 2;
			c.gridheight = 1;
			c.fill = GridBagConstraints.NONE;
			c.insets = new Insets(10, 0, 0, 0);
			add(twitter, c);
			c.insets = new Insets(0, 0, 0, 0);
		}
    	
    	public boolean hasSensorPanel() {
    		return sPanel != null;
    	}
    	
    	public boolean hasBeliefPanel() {
    		return bPanel != null;
    	}
    	
    	public boolean hasGoalsPanel() {
    		return gPanel != null;
    	}

    	@Override
		public void stateChanged(ChangeEvent e) {
    		if (e.getSource() instanceof JTabbedPane) {
    			JTabbedPane pane = (JTabbedPane) e.getSource();
    			int tmp = pane.getSelectedIndex();
    			if (pane.getSelectedIndex() == index) {
    				if (hasSensorPanel()) {
    					getSensorPanel().componentShown();
    				}
    				
    				if (hasBeliefPanel()) {
    					getBeliefPanel().componentShown();
    				}
    				
    				if (hasGoalsPanel()) {
    					getGoalsPanel().componentShown();
    				}
    				
    				enablePanels(0);
    			}
    		}
		}
    	
    	public SensorPanel getSensorPanel() {
    		return sPanel;
    	}
    	
    	public BeliefPanel getBeliefPanel() {
    		return bPanel;
    	}
    	
    	public GoalsPanel getGoalsPanel() {
    		return gPanel;
    	}
    	
    	public void setSensorPanel(SensorPanel panel) {
    		sPanel = panel;
    	}
    	
    	public void setBeliefPanel(BeliefPanel panel) {
    		bPanel = panel;
    	}
    	
    	public void setGoalPanel(GoalsPanel panel) {
    		gPanel = panel;
    	}
    	
    	public abstract void enablePanels(int i);

}
