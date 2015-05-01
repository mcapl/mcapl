package eass.ev3.cheltenham.ui;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import eass.ev3.cheltenham.DinoEnvironment;
import eass.ev3.cheltenham.DinoUI;

public class SensorPanel extends DinoPanel {
    SensorValues ultrasonic;
    SensorValues blue;
    SensorValues red;
    
    SensorConfiguration config = new SensorConfiguration(true, true, true);
    
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
		        
	public SensorPanel(String title, DinoUI ui, SensorConfiguration config) {
		super(title, ui);
		this.config = config;
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;

		if (config.showUltra()) {
			ultrasonic = new SensorValues("Ultrasonic Sensor", ui, "Ultrasonic Sensor Values");
			add(ultrasonic, c);
			c.gridy++;
		}
        if (config.showBlue()) {
        	blue = new SensorValues("Blue Light", ui, "Blue Light Values");
        	add(blue, c);
			c.gridy++;
        }
		
        if (config.showRed()) {
        	red = new SensorValues("Red Light", ui, "Red Light Values");
        	add(red, c);
        }
	}

	public void componentShown() {
		// TODO Auto-generated method stub
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
	
	public static class SensorConfiguration {
		boolean ultrasonic = false;
		boolean blue = false;
		boolean red = false;
		
		public SensorConfiguration(boolean u, boolean b, boolean r) {
			ultrasonic = u;
			blue = b;
			red = r;
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
	}
	

}
