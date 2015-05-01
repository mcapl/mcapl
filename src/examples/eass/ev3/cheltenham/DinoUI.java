// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

import javax.swing.*;   
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintStream;

import eass.ev3.cheltenham.ui.BeliefPanel;
import eass.ev3.cheltenham.ui.ComplexPanel;
import eass.ev3.cheltenham.ui.DinoPanel;
import eass.ev3.cheltenham.ui.GoalsOnlyPanel;
import eass.ev3.cheltenham.ui.RulesOnlyPanel;
import eass.ev3.cheltenham.ui.SimplePanel;
import eass.ev3.cheltenham.ui.TabPanel;
import eass.mas.ev3.EASSEV3Environment;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.util.AILConfig;
import ail.mas.AIL;
import ail.mas.MAS;
import ajpf.MCAPLcontroller;

/**
 * This sets up a user interface for the remote operation of Lego Rovers.  It is intended primarily for use with school children.
 * Further information can be found at: http://cgi.csc.liv.ac.uk/~lad/legorovers/
 * @author louiseadennis
 *
 */
public class DinoUI extends JTabbedPane implements ActionListener, WindowListener {
		private static final long serialVersionUID = 1L;

		// The various buttons and boxes used by the interface.
	    protected NumberFormat numberFormat;
	  	public JLabel belieflist = new JLabel(), goallist = new JLabel();
	    
	    public ArrayList<String> beliefs = new ArrayList<String>();
	    public ArrayList<String> currentgoals = new ArrayList<String>();
	    
	    // The delay before instructions reach the robot, the environment and the default robot name.
	    protected int delay = 0;
	    public static DinoEnvironment env;
	    protected MAS mas;
	    public static String rName = "dinor3x";
	    protected static String program = "/src/examples/eass/ev3/cheltenham/Dinor3x.ail";
	    
	    ArrayList<TabPanel> panels = new ArrayList<TabPanel>();
	    
	    // Wrapping the environment in a thread so events are handled faster.
	    public EnvironmentThread envThread = new EnvironmentThread();
	    
	    public DinoUI() {
	    	
	    }
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    public void createAndShowGUI() {
	    	JMenuBar menuBar = new JMenuBar();
	    	JMenu file = new JMenu("Menu");
	    	JMenuItem config = new JMenuItem("Settings");
	    	config.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame settings = new JFrame("Settings");
					ConfigurationPanel config = new ConfigurationPanel(settings, env);
					settings.setContentPane(config);
					settings.pack();
					settings.setVisible(true);
				}
	    		
	    	});
	    	file.add(config);
	    	
	    	JMenuItem tabshow = new JMenuItem("Hide Goal Tabs");
	    	file.add(tabshow);
	    	
	    	JMenuItem quit = new JMenuItem("Quit");
	    	quit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mas.cleanup();
					System.exit(0);
				}
	    		
	    	});
	    	file.add(quit);
	    	menuBar.add(file);
	    		    	
	    	//Create and set up the window.
	        JFrame frame = new JFrame("Triceratops Robot");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    	belieflist.setText(beliefs.toString());
        	goallist.setText(currentgoals.toString());
 
	    	SimplePanel teleop = new SimplePanel(this, 0);
	        addTab("Simple", teleop);
	        panels.add(teleop);
	        
	        RulesOnlyPanel ro = new RulesOnlyPanel(this, 1);
	        addTab("Rules", ro);
	        panels.add(ro);
	        
	        GoalsOnlyPanel go = new GoalsOnlyPanel(this, 2);
	        addTab("Goals", go);
	        panels.add(go);
	        
	        ComplexPanel all = new ComplexPanel(this, 3);
	        addTab("Goals and Rules", all);
	        panels.add(all);
	        
	        
	    	tabshow.addActionListener(new ActionListener() {
	    		boolean hidden = false;

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (hidden) {
						DinoUI.this.addTab("Goals", go);
						DinoUI.this.addTab("Goals and Rules", all);
						tabshow.setText("Hide Goal Tabs");
						hidden = false;
					} else {
						DinoUI.this.remove(go);
						DinoUI.this.remove(all);
						tabshow.setText("Show Goal Tabs");
						hidden = true;
					}
					
				}
	    		
	    	});

	    	
	        envThread.start();
	        frame.addWindowListener(this);
	        frame.setContentPane(this);
	    	frame.setJMenuBar(menuBar);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setSize(100, 100);
	 
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
		    	        
	    public void addMas(MAS mas) {
	    	this.mas = mas;
	    	((DinoEnvironment) env).setUI(this);
	    }
	    
	    public void addToBeliefList(String p) {
	    	beliefs.add(p);
	    	belieflist.setText(beliefs.toString());
	    }

	    public void removeFromBeliefList(String p) {
	    	beliefs.remove(p);
	    	belieflist.setText(beliefs.toString());
	    }

	    public void addToGoalList(String p) {
	    	currentgoals.add(p);
	    	goallist.setText(currentgoals.toString());
	    }

	    public void removeFromGoalList(String p) {
	    	currentgoals.remove(p);
	    	goallist.setText(currentgoals.toString());
	    }
	    
	    public void changeDistanceThreshold(double d) {
	    	for (TabPanel p: panels) {
	    		p.changeDistanceThreshold(d);
	    	}
	    }
	
	    public void changeWaterThresholds(double d1, double d2) {
	    	for (TabPanel p: panels) {
	    		p.changeWaterThreshold(d1, d2);
	    	}
	    }
	    
	    public void changePathThreshold(double d) {
	    	for (TabPanel p: panels) {
	    		p.changePathThreshold(d);
	    	}
	    }
	    
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
		public void actionPerformed(ActionEvent e) {
	    	Action act = new Action(e.getActionCommand());
	   // 	System.err.println(act);
	    	
	    	if (e.getActionCommand().equals("r1action1") || e.getActionCommand().equals("r1action2") || e.getActionCommand().equals("r1action3") ||
	    			e.getActionCommand().equals("r2action1") || e.getActionCommand().equals("r2action2") || e.getActionCommand().equals("r2action3") ||
	    			e.getActionCommand().equals("r3action1") || e.getActionCommand().equals("r3action2") || e.getActionCommand().equals("r3action3") ||
	    			e.getActionCommand().equals("r4action1") || e.getActionCommand().equals("r4action2") || e.getActionCommand().equals("r4action3") ||
	    			e.getActionCommand().equals("r1context") || e.getActionCommand().equals("r2context") || e.getActionCommand().equals("r3context") || e.getActionCommand().equals("r4context")
	    			) {
	    		JComboBox<String> cb = (JComboBox<String>)e.getSource();
	    		act.addTerm(new Literal((String)cb.getSelectedItem()));
	    	} 
	    	
	    	envThread.latestAction(act);
		}
				
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
		 */
	    public void windowActivated(WindowEvent e) {};
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	     */
	    public void windowClosed(WindowEvent e) {
	    	// envThread.stopRunning();
	    	env.close(rName);
	    	System.out.println("closed "+rName);
	    }
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	     */
	    public void windowClosing(WindowEvent e) {
	    	envThread.stopRunning();
	    	env.close(rName);
	    	System.out.println("closing "+rName);
	    };
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	     */
	    public void windowDeactivated(WindowEvent e) {};
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	     */
	    public void windowDeiconified(WindowEvent e) {};
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	     */
	    public void windowIconified(WindowEvent e) {};
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	     */
	    public void windowOpened(WindowEvent e) {};
	    
	    
	    /**
	     * We encapsulate the environment in a thread because small children like rapidly pressing buttons and the
	     * environments executeAction method takes too  long if they do this.
	     * @author louiseadennis
	     *
	     */
	    public class EnvironmentThread extends Thread {
	    	// This stores the most recent action.  We assume children have no interest in queueing actions.
	    	Action action = null;
	    	// A flag to control the while loop in the run method.
	    	boolean isrunning = true;
	    	
	    	/**
	    	 * Set up the latest actions ready to run next time the thread loops.  Notify the thread in case it is waiting.
	    	 * @param name
	    	 * @param act
	    	 */
	    	public void latestAction(Action act) {
	    		synchronized(this) {
	    			action = act;
	    			notify();
	    		}
	    	}
	    	
	    	/*
	    	 * (non-Javadoc)
	    	 * @see java.lang.Thread#run()
	    	 */
	    	public void run() {
	    		while (isrunning) {
	    			synchronized(this) {
	    				// If there is no recent action we wait for one to arrive.
	    				if (action == null) {
	    					try {
	    						wait();
	    					} catch (InterruptedException ie) {
	    						System.err.println("catching an interrupt");
	    					}
	    				}
	    			}
	    			
	    			// At this point we should definitely have an action so it is safe to execute the most recent.
	    			executeAction();
	    		}
	    	}
	    	
	    	/**
	    	 * Execute the most recently supplied action, with a delay if necessary.
	    	 */
	    	public void executeAction() {
		    	try {
		    		Action act = action;
		    		// OK we've got the action so set it to null ready for the next one to arrive.
		    		action = null;
		    		try {
		    			Thread.sleep(delay);
		    		} catch (InterruptedException ie) {
		    			System.out.println("catching interrupt");
		    		}
		    		env.executeAction(rName, act);
		    	} catch (Exception ex){
		    		System.err.println(ex.getMessage());
		    	}
		    	
	    		
	    	}
	    	
	    	/**
	    	 * Stop running.
	    	 */
	    	public void stopRunning() {
	    		isrunning = false;
	    	}
	    	
	    }	    

}
