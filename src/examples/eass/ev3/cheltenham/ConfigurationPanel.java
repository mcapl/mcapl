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
package eass.ev3.cheltenham;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import ail.syntax.Action;
import ail.syntax.NumberTermImpl;

/**
 * A panel to allow restting of threshold values for obstacles, water and paths in the Lego Robot Dinosaur activity.  This is in case these
 * values need changing on the fly during use.
 * @author lad
 *
 */
public class ConfigurationPanel extends JPanel implements WindowListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	JFormattedTextField distancebox, waterubox, waterlbox, pathbox;
    protected double dthreshold=0.4;
    private boolean dtinit  = false;
    protected double pthreshold=0.03;
    private boolean pinit  = false;
    private double wuthreshold=0.09;
    private double wlthreshold=0.06;
    private boolean winit  = false;
    
    private DinoEnvironment env;
    protected static String rName = "dinor3x";
	
	public ConfigurationPanel(JFrame frame, DinoEnvironment env) {
		this.env = env;
		dthreshold = env.dthreshold;
		pthreshold = env.path_threshold;
		wuthreshold = env.wuthreshold;
		wlthreshold = env.wlthreshold;
    	setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	GridBagConstraints tc = new GridBagConstraints();
    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    	JPanel thresholds = new JPanel();
    	thresholds.setBorder(BorderFactory.createTitledBorder(loweredetched, "Detections Thresholds"));
    	thresholds.setLayout(new GridBagLayout());
    	c.gridx = 0;
    	c.gridy = 0;
        c.gridwidth = 1;
    	add(thresholds, c);
    	
    	// Distance Setting
    	JLabel utext = new JLabel("Obstacle Distance:");
    	thresholds.add(utext);
    	NumberFormat f2 = NumberFormat.getNumberInstance();
    	f2.setMaximumIntegerDigits(4);
    	distancebox = new JFormattedTextField(f2);
    	distancebox.setValue(dthreshold);
    	distancebox.setColumns(4);
    	distancebox.addPropertyChangeListener(this);
    	thresholds.add(distancebox);
    	JButton setDistance = new JButton("set");
    	setDistance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDistance();
			}
    		
    	});
    	thresholds.add(setDistance);
    	
    	// Water Setting
    	tc.gridy = 1;
    	tc.gridx = 0;
    	JLabel wtext = new JLabel("Water Light Values:");
    	thresholds.add(wtext, tc);
    	tc.gridx++;
    	waterubox = new JFormattedTextField(f2);
    	waterubox.setValue(wuthreshold);
    	waterubox.setColumns(4);
    	waterubox.addPropertyChangeListener(this);
    	thresholds.add(waterubox, tc);
    	tc.gridx++;
    	waterlbox = new JFormattedTextField(f2);
    	waterlbox.setValue(wlthreshold);
    	waterlbox.setColumns(4);
    	waterlbox.addPropertyChangeListener(this);
    	thresholds.add(waterlbox, tc);
    	tc.gridx++;
    	JButton setWater = new JButton("set");
    	setWater.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setWater();
			}
    		
    	});
    	thresholds.add(setWater, tc);

    	tc.gridy++;
    	tc.gridx = 0;
 
    	// Path Setting
    	JLabel ptext = new JLabel("Path Light Value:");
    	thresholds.add(ptext, tc);
    	tc.gridx++;
    	pathbox = new JFormattedTextField(f2);
    	pathbox.setValue(pthreshold);
    	pathbox.setColumns(4);
    	pathbox.addPropertyChangeListener(this);
    	thresholds.add(pathbox, tc);
    	JButton setPath = new JButton("set");
    	setPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setPath();
			}
    		
    	});
    	tc.gridx++;
    	thresholds.add(setPath, tc);

    	JButton close = new JButton("close");
    	close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
    		
    	});
    	c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        this.add(close, c);
        
        
      
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		
		if (source == distancebox) {
			setDistance();
		} else if (source == waterubox) {
			setWater();
		} else if (source == waterlbox) {
			setWater();
		} else if (source == pathbox ){
			setPath();
		}
	}
	
	/**
	 * Set the new distance everywhere it is needed.
	 */
	private void setDistance() {
		double new_distance = ((Number) distancebox.getValue()).doubleValue();
		if (new_distance != dthreshold || !dtinit) {
			dthreshold = new_distance;
			dtinit = true;

			Action act = new Action("obstacle_distance");
			act.addTerm(new NumberTermImpl(dthreshold));
			try {
				env.executeAction(rName, act);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
	}

	/**
	 * Set the new path thresholds everywhere they are needed.
	 */
	private void setPath() {
		double new_path = ((Number) pathbox.getValue()).doubleValue();
		if (new_path != pthreshold || !pinit) {
			pthreshold = new_path;
			pinit = true;
	
		
			Action act = new Action("path_threshold");
			act.addTerm(new NumberTermImpl(pthreshold));
			try {
				env.executeAction(rName, act);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
	}

	/**
	 * Set the new water threshold everywhere it is needed.
	 */
	private void setWater() {
		double new_water_u = ((Number) waterubox.getValue()).doubleValue();
		double new_water_l = ((Number) waterlbox.getValue()).doubleValue();
		if (new_water_u != wuthreshold || !winit || new_water_l != wlthreshold) {
			wuthreshold = new_water_u;
			wlthreshold = new_water_l;
			winit = true;
	
		
			Action act = new Action("water_levels");
			act.addTerm(new NumberTermImpl(wuthreshold));
			act.addTerm(new NumberTermImpl(wlthreshold));
			try {
				env.executeAction(rName, act);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
	}

	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {

		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

}
 