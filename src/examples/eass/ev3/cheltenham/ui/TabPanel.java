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

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import eass.ev3.cheltenham.DinoUI;

/**
 * This is a generic class for a top level pane to appear in a tabbed in the Lego Robot Dinsaur activity developed for Cheltenham Science Festival 2015.
 * @author lad
 *
 */
public abstract class TabPanel extends DinoPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;

		// The behaviour of several of the subpanels this one may contain are determined by whether this pane is
		// visible or not.  Therefore we need field for these subpanels.
		SensorPanel sPanel;
		BeliefPanel bPanel;
		GoalsPanel gPanel;
		InstructionsPanel iPanel;
		TabMain mainPanel;
		
		int index;
    	JLabel twitter = new JLabel("If you've enjoyed this activity why not tweet us your thoughts and photos: @legorovers #legodinos");
    	JLabel cast = new JLabel("This activity was developed by the Centre for Autonomous Systems Technology, University of Liverpool and supported by the Strategic Technology Facilities Council.");
		
		BufferedImage cast_logo;
		BufferedImage stfc_logo;

    	
		public TabPanel(DinoUI ui, int tabindex) {
			super(ui);
			index = tabindex;
			createTabMain(ui);
			setBackground(Color.WHITE);
			
			try {
				 cast_logo = ImageIO.read(new File("./src/examples/eass/ev3/cheltenham/resources/cast.png"));
				 stfc_logo = ImageIO.read(new File("./src/examples/eass/ev3/cheltenham/resources/stfc.jpg"));
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
			//JLabel cast_logo_l = new JLabel(new ImageIcon(cast_logo));
			//JLabel stfc_logo_l = new JLabel(new ImageIcon(stfc_logo));
			
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 3;
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 1.0;
			c.weightx = 1.0;
			add(mainPanel.getPanel(), c);
			
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 2;
			c.gridheight = 1;
			c.fill = GridBagConstraints.NONE;
			c.insets = new Insets(10, 0, 20, 0);
			add(twitter, c);
			/*c.anchor = GridBagConstraints.LINE_START;
			c.insets = new Insets(0, 0, 0, 0);
			c.gridy++;
			c.gridwidth = 2;
			add(cast_logo_l, c);
			c.gridx = 1;
			c.anchor = GridBagConstraints.LINE_END;
			c.insets = new Insets(0, 0, 0, 10);
			add(stfc_logo_l, c); */
			c.insets = new Insets(0, 0, 0, 0);
			c.gridwidth = 2;
			c.gridy++;
			c.gridx = 0;
			c.anchor = GridBagConstraints.CENTER;
			add(cast, c);
		}
    	
		/**
		 * Does this pane contain a panel displaying sensor values?
		 * @return
		 */
    	public boolean hasSensorPanel() {
    		return sPanel != null;
    	}
    	
    	/**
    	 * Does this pane contain a panel showing the robot's beliefs?
    	 * @return
    	 */
    	public boolean hasBeliefPanel() {
    		return bPanel != null;
    	}
    	
    	/**
    	 * Does this pane contain a panel showing the robot's goals?
    	 * @return
    	 */
    	public boolean hasGoalsPanel() {
    		return gPanel != null;
    	}

    	/*
    	 * (non-Javadoc)
    	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
    	 */
    	@Override
		public void stateChanged(ChangeEvent e) {
    		if (e.getSource() instanceof JTabbedPane) {
    			JTabbedPane pane = (JTabbedPane) e.getSource();
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
    	
    	/**
    	 * Return the sensor panel.
    	 * @return
    	 */
    	public SensorPanel getSensorPanel() {
    		return sPanel;
    	}
    	
    	/**
    	 * Return the belief panel.
    	 * @return
    	 */
    	public BeliefPanel getBeliefPanel() {
    		return bPanel;
    	}
    	
    	/**
    	 * Return the goal panel.
    	 * @return
    	 */
    	public GoalsPanel getGoalsPanel() {
    		return gPanel;
    	}
    	
    	/**
    	 * Return the instructions panel.  NB.  Always present.
    	 * @return
    	 */
    	public InstructionsPanel getInstructionsPanel() {
    		return iPanel;
    	}
    	
    	/**
    	 * Set the sensor panel.
    	 * @param panel
    	 */
    	public void setSensorPanel(SensorPanel panel) {
    		sPanel = panel;
    	}
    	
    	/**
    	 * Set the belief panel.
    	 * @param panel
    	 */
    	public void setBeliefPanel(BeliefPanel panel) {
    		bPanel = panel;
    	}
    	
    	/**
    	 * Set the Goal panel.
    	 * @param panel
    	 */
    	public void setGoalPanel(GoalsPanel panel) {
    		gPanel = panel;
    	}
    	
    	/**
    	 * Set the Instructions panel.
    	 * @param panel
    	 */
    	public void setInstructionsPanel(InstructionsPanel panel) {
    		iPanel =  panel;
    	}
    	
    	/**
    	 * Change the distance threshold (used when displaying instructions).
    	 * @param d
    	 */
    	public void changeDistanceThreshold(double d) {
    		iPanel.changeDistanceThreshold(d);
    	}
    	
    	/**
    	 * Change the blue light threshold used to detect "water" (used when displaying instructions).
    	 * @param d1
    	 * @param d2
    	 */
    	public void changeWaterThreshold(double d1, double d2) {
    		iPanel.changeBlueThresholds(d1, d2);
    	}
    	
    	/**
    	 * Change the red light threshold used to detect a "path" (used when displaying instructions).
    	 * @param d
    	 */
    	public void changePathThreshold(double d) {
    		iPanel.changePathThreshold(d);
    	}
    	
    	/**
    	 * As the user cycles through the instructions for this pane, different sub-components will be enabled.  This 
    	 * behaviour should be controled by the enablePanels method.
    	 * @param i
    	 */
    	public abstract void enablePanels(int i);
    	
    	/**
    	 * Create the main panel for this tab.
    	 */
    	public abstract void createTabMain(DinoUI ui);

}
