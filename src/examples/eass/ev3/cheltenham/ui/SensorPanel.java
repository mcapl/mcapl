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

import java.awt.GridBagConstraints;

import eass.ev3.cheltenham.DinoUI;

/**
 * A Panel for displaying the output from the sensors of a Lego Robot Dinosaur.  This was developed for use at Cheltenham Science Festival 2015.
 * The panel can be configured, depending upon which senor outputs are to be displayed.
 * @author lad
 *
 */
public class SensorPanel extends DinoPanel {
 	private static final long serialVersionUID = 1L;
	SensorValues ultrasonic;
    SensorValues blue;
    SensorValues red;
    
    // The configuration specifying which sensor outputs to show.
    SensorConfiguration config = new SensorConfiguration(true, true, true, false);
    
    
	public SensorPanel(String title, DinoUI ui, SensorConfiguration config) {
		super(title, ui);
		this.config = config;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		if (config.showUltra()) {
			ultrasonic = new SensorValues("Ultrasonic Sensor", ui, "Ultrasonic Sensor Values", config.getLong());
			add(ultrasonic, c);
			c.gridy++;
		}

		if (config.showBlue()) {
			blue = new SensorValues("Green Light", ui, "Green Light Values", config.getLong());
			add(blue, c);
			c.gridy++;
		}
		
		if (config.showRed()) {
			red = new SensorValues("Red Light", ui, "Red Light Values", config.getLong());
			add(red, c);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
    @Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	if (config.showUltra()) {
    		ultrasonic.setEnabled(enabled);
    	}
    	if (config.showBlue()) {
    		blue.setEnabled(enabled);
    	}
    	
    	if (config.showRed()) {
    		red.setEnabled(enabled);
    	}
    	
    }

    /**
     * If this panel is shown - e.g., when the tab containing it is displayed, grab the relevant sensor streams.
     */
	public void componentShown() {
		if (config.showUltra()) {
			ultrasonic.componentShown();
		}

		if (config.showBlue()) {
        	blue.componentShown();
        }

		if (config.showRed()) {
        	red.componentShown();
        }
	}
	
	/**
	 * The class representing the sensor configuration.  The Lego Robot Dinosaurs have a distance sensor and an RGB sensor of which the
	 * activity is interested in the Red and Blue light values.
	 * @author lad
	 *
	 */
	public static class SensorConfiguration {
		boolean ultrasonic = false;
		boolean blue = false;
		boolean red = false;
		boolean longpanels = false;
		
		public SensorConfiguration(boolean u, boolean b, boolean r, boolean longpanels) {
			ultrasonic = u;
			blue = b;
			red = r;
			this.longpanels = longpanels;
		}
		
		public boolean showUltra() {
			return ultrasonic;
		}
		
		public boolean showBlue() {
			return blue;
		}
		
		public boolean showRed() {
			return red;
		}
		
		public boolean getLong() {
			return longpanels;
		}
	}
	

}
