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

import javax.swing.*;   

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import eass.ev3.cheltenham.ui.GoalsOnlyPanel;
import eass.ev3.cheltenham.ui.RulesOnlyPanel;
import eass.ev3.cheltenham.ui.SimplePanel;
import eass.ev3.cheltenham.ui.SimpleRulesPanel;
import eass.ev3.cheltenham.ui.SimpleRulesPanelnoIns;
import eass.ev3.cheltenham.ui.TabPanel;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.mas.MAS;

/**
 * This sets up a user interface for the remote operation of Lego Robot Dinosaurs.  It is intended for use in the DinoZone at 
 * Cheltenham Science Festival 2015.
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
	    
	    public static DinoEnvironment env;
	    protected MAS mas;
	    public static String rName = "dinor3x";
	    protected static String program = "/src/examples/eass/ev3/cheltenham/Dinor3x.ail";
	    
	    // A list of all the different versions of the interface designed for different ability levels.
	    ArrayList<TabPanel> panels = new ArrayList<TabPanel>();
	    
	    // Wrapping the environment in a thread so events are handled faster.
	    public EnvironmentThread envThread = new EnvironmentThread();
	    
	    // Does this robot have wheels?
	    private boolean wheeled = true;
	    
	    public DinoUI() {
	    	this.setBackground(Color.WHITE);	    	
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
	    	
	    	// We may want to hide some of the options from attendees - especially if they are proving confusing.
	    	JMenuItem tabshow = new JMenuItem("Show Goal Tab");
	    	file.add(tabshow);
	    	
	    	JMenuItem wheeled_item = new JMenuItem("Robot has Legs");
	    	file.add(wheeled_item);
	    	wheeled_item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (wheeled ) {
						wheeled_item.setText("Robot has Wheels");
						DinoUI.this.setWheeled(false);
					} else {
						wheeled_item.setText("Robot has Legs");
						DinoUI.this.setWheeled(true);
					}
				}
	    		
	    	});
	    	
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
	        frame.setBackground(Color.WHITE);

	    	belieflist.setText(beliefs.toString());
        	goallist.setText(currentgoals.toString());
 
        	// Set up the panels and add them to the panel list.
	    	SimplePanel teleop = new SimplePanel(this, 0);
	        addTab("Simple", teleop);
	        panels.add(teleop);
	        
	        SimpleRulesPanelnoIns sro = new SimpleRulesPanelnoIns(this, 1);
	        addTab("Simple Rules", sro);
	        panels.add(sro);
	        
	        RulesOnlyPanel ro = new RulesOnlyPanel(this, 2);
	        addTab("Rules", ro);
	        panels.add(ro);
	        
	        GoalsOnlyPanel go = new GoalsOnlyPanel(this, 3);
	       // addTab("Goals", go);
	        panels.add(go);
	        
	        /* ComplexPanel all = new ComplexPanel(this, 4);
	        addTab("Goals and Rules", all);
	        panels.add(all); */
	        
	        
	    	tabshow.addActionListener(new ActionListener() {
	    		boolean hidden = true;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (hidden) {
						DinoUI.this.addTab("Goals", go);
					//	DinoUI.this.addTab("Goals and Rules", all);
						tabshow.setText("Hide Goal Tab");
						hidden = false;
					} else {
						DinoUI.this.remove(go);
					//	DinoUI.this.remove(all);
						tabshow.setText("Show Goal Tab");
						hidden = true;
					}
					
				}
	    		
	    	});

	    	
	        envThread.start();
	        frame.addWindowListener(this);
	        frame.setContentPane(this);
	        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	    	frame.setJMenuBar(menuBar);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setSize(100, 100);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
		 
	    /**
	     * Add the multi-agent system that this UI controls.
	     * @param mas
	     */
	    public void addMas(MAS mas) {
	    	this.mas = mas;
	    	setEnv((DinoEnvironment) mas.getEnv());
	    }
	    
	    /** 
	     * Get the multi-agent environment associated with this UI.
	     * @return
	     */
	    public DinoEnvironment getEnv() {
	    	return env;
	    }
	    
	    /**
	     * Get the name of the agent program associated with this UI.
	     * @return
	     */
	    public String getProgramFileName() {
	    	return program;
	    }
	    
	    /**
	     * Set the multi-agent environment associated with this UI.
	     * @param env
	     */
	    public void setEnv(DinoEnvironment env) {
	    	DinoUI.env = env;
	    	env.setUI(this);
	    }
	    
	    /**
	     * Get the name of the robot associated with this UI.
	     * @return
	     */
	    public String getRName() {
	    	return rName;
	    }
	    
	    /**
	     * Add something to the list of beliefs to be displayed by the UI.
	     * @param p
	     */
	    public void addToBeliefList(String p) {
	    	beliefs.add(p);
	    	belieflist.setText(beliefs.toString());
	    }

	    /**
	     * Remove something from the list of beliefs to be displayed by the UI.
	     * @param p
	     */
	    public void removeFromBeliefList(String p) {
	    	beliefs.remove(p);
	    	while (beliefs.contains(p)) {
	    		beliefs.remove(p);
	    	}
	    	belieflist.setText(beliefs.toString());
	    }

	    /**
	     * Add something to the list of goals to be displayed by the UI.
	     * @param p
	     */
	    public void addToGoalList(String p) {
	    	currentgoals.add(p);
	    	goallist.setText(currentgoals.toString());
	    }

	    /**
	     * Remove something from the list of goals to be displayed by the UI.
	     * @param p
	     */
	    public void removeFromGoalList(String p) {
	    	currentgoals.remove(p);
	    	goallist.setText(currentgoals.toString());
	    }
	    
	    /**
	     * Change the distance thresholds reported by the UI.
	     * @param d
	     */
	    public void changeDistanceThreshold(double d) {
	    	for (TabPanel p: panels) {
	    		p.changeDistanceThreshold(d);
	    	}
	    }
	
	    /**
	     * Change the water detection thresholds reported by the UI.
	     * @param d1
	     * @param d2
	     */
	    public void changeWaterThresholds(double d1, double d2) {
	    	for (TabPanel p: panels) {
	    		p.changeWaterThreshold(d1, d2);
	    	}
	    }
	    
	    /**
	     * Change the path thresholds reported by the UI.
	     * @param d
	     */
	    public void changePathThreshold(double d) {
	    	for (TabPanel p: panels) {
	    		p.changePathThreshold(d);
	    	}
	    }
	    
	    public void setWheeled(boolean w) {
	    	wheeled = w;
	    	if (mas != null) {
	    		((Dinor3x) getEnv().getRobot(rName)).setWheeled(w);
	    	}
	    }
	    
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
		public void actionPerformed(ActionEvent e) {
	    	Action act = new Action(e.getActionCommand());
	    	boolean mustbeprocessed = false;
	    	
	    	if (e.getActionCommand().equals("r1action1") || e.getActionCommand().equals("r1action2") || e.getActionCommand().equals("r1action3") ||
	    			e.getActionCommand().equals("r2action1") || e.getActionCommand().equals("r2action2") || e.getActionCommand().equals("r2action3") ||
	    			e.getActionCommand().equals("r3action1") || e.getActionCommand().equals("r3action2") || e.getActionCommand().equals("r3action3") ||
	    			e.getActionCommand().equals("r4action1") || e.getActionCommand().equals("r4action2") || e.getActionCommand().equals("r4action3") ||
	    			e.getActionCommand().equals("r1context") || e.getActionCommand().equals("r2context") || e.getActionCommand().equals("r3context") || e.getActionCommand().equals("r4context")
	    			) {
	    		@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
	    		act.addTerm(new Literal((String)cb.getSelectedItem()));
	    		mustbeprocessed = true;
	    	} else if (e.getActionCommand().equals("rule1") || e.getActionCommand().equals("rule2") ||
	    			e.getActionCommand().equals("rule3") || e.getActionCommand().equals("rule4") ) {
	    		mustbeprocessed = true;
	    	}
	    	
	    	envThread.latestAction(act, mustbeprocessed);
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
	    	LinkedList<Action> actionlist = new LinkedList<Action>();
	    	Action action = null;
	    	// A flag to control the while loop in the run method.
	    	boolean isrunning = true;
	    	
	    	/**
	    	 * Set up the latest actions ready to run next time the thread loops.  Notify the thread in case it is waiting.
	    	 * @param name
	    	 * @param act
	    	 */
	    	public void latestAction(Action act, boolean mustbeprocessed) {
	    		synchronized(this) {
	    			if (action == null) {
	    				action = act;
	    			} else if (mustbeprocessed) {
	    				actionlist.offer(act);
	    			}
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
	    				if (action == null && actionlist.isEmpty()) {
	    					try {
	    						wait();
	    					} catch (InterruptedException ie) {
	    						System.err.println("catching an interrupt");
	    					}
	    				} else if (action == null) {
	    					action = actionlist.poll();
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
