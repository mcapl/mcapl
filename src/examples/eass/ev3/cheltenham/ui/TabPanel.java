package eass.ev3.cheltenham.ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import eass.ev3.cheltenham.DinoUI;


public abstract class TabPanel extends DinoPanel implements ChangeListener {
		SensorPanel sPanel;
		BeliefPanel bPanel;
		int index;
		
		public TabPanel(DinoUI ui, int tabindex) {
			super(ui);
			index = tabindex;
		}
    	
    	public boolean hasSensorPanel() {
    		return sPanel != null;
    	}
    	
    	public boolean hasBeliefPanel() {
    		return bPanel != null;
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
    	
    	public void setSensorPanel(SensorPanel panel) {
    		sPanel = panel;
    	}
    	
    	public void setBeliefPanel(BeliefPanel panel) {
    		bPanel = panel;
    	}
    	
    	public abstract void enablePanels(int i);

}
