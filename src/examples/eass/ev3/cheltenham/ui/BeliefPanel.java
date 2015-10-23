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

import eass.ev3.cheltenham.DinoUI;

/**
 * A Panel for displaying a robots current set of beliefs.
 * @author lad
 *
 */
public class BeliefPanel extends DinoPanel {
 	private static final long serialVersionUID = 1L;
   
    public BeliefPanel(String title, DinoUI ui) {
    	super(title, ui);
    	add(getDinoUI().belieflist);
    }

    /*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
	@Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	getDinoUI().belieflist.setEnabled(enabled);
    }
    
	/**
	 * When this panel is shown - i.e., when a tabbed pane containing it is revealed, grab the belief list from the enclosing UI.
	 */
	public void componentShown() {
    	add(getDinoUI().belieflist);
    }

}
