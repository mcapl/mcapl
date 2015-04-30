package eass.ev3.cheltenham.ui;

import eass.ev3.cheltenham.DinoUI;

public class GoalsPanel extends DinoPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	getDinoUI().goallist.setEnabled(enabled);
    }
	
    
    public GoalsPanel(String title, DinoUI ui) {
    	super(title, ui);
    	add(getDinoUI().goallist);
    }
    
    public void componentShown() {
    	add(getDinoUI().goallist);
    }


}
