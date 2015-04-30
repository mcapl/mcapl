package eass.ev3.cheltenham.ui;

import javax.swing.JLabel;

import eass.ev3.cheltenham.DinoUI;

public class BeliefPanel extends DinoPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	getDinoUI().belieflist.setEnabled(enabled);
    }
	
    
    public BeliefPanel(String title, DinoUI ui) {
    	super(title, ui);
    	add(getDinoUI().belieflist);
    }
    
    public void componentShown() {
    	add(getDinoUI().belieflist);
    }

}
