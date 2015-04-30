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
	    protected String[] actions = {"do_nothing", "stop", "backward", "right", "left", "forward"};
	    protected String[] choices = {"anything", "there is water", "there is no water"};
	    JLabel belieflist = new JLabel(), goallist = new JLabel();
	    
	    protected ArrayList<String> beliefs = new ArrayList<String>();
	    protected ArrayList<String> currentgoals = new ArrayList<String>();
	    
	    // The delay before instructions reach the robot, the environment and the default robot name.
	    protected int delay = 0;
	    protected static EASSEV3Environment env;
	    protected MAS mas;
	    protected static String rName = "dinor3x";
	    protected static String program = "/src/examples/eass/ev3/cheltenham/Dinor3x.ail";
	    
	    // Wrapping the environment in a thread so events are handled faster.
	    protected EnvironmentThread envThread = new EnvironmentThread();
	    
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

	        SimplePanel teleop = new SimplePanel();
	        addTab("Simple", teleop);
	        
	        RulesOnlyPanel ro = new RulesOnlyPanel();
	        addTab("Rules", ro);
	        
	        ComplexPanel all = new ComplexPanel();
	        addTab("Goals and Rules", all);
	    	
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
	 
	    private class SimplePanel extends TabPanel {
	    	public SimplePanel() {
		    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		    	c.fill = GridBagConstraints.HORIZONTAL;

		    	// A JPanel for Controls
		    	ControlsPanel controls = new ControlsPanel();
		    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
		    	c.gridx = 0;
		    	c.gridy = 1;
		        c.gridwidth = 1;
		    	add(controls, c);
	    		
		        // The Instructions Panel
		        InstructionsPanel instructions = new InstructionsPanel(1, this);
		        instructions.setBorder(BorderFactory.createTitledBorder(loweredetched, "Instructions"));
		        c.gridx = 0;
		        c.gridy = 2;
		        c.gridwidth = 1;
		    	c.fill = GridBagConstraints.BOTH;
		        add(instructions, c);

	    	}
	    }
	    
	    /**
	     * Constructs the User Interface.
	     * @param layout
	     */
	    private class RulesOnlyPanel extends TabPanel implements ChangeListener {
	    	
			public RulesOnlyPanel() {
	    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    		    		    	
	    	// A JPanel for Controls
	    	ControlsPanel controls = new ControlsPanel();
	    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
	    	c.gridx = 0;
	    	c.gridy = 1;
	        c.gridwidth = 2;
	    	add(controls, c);
	        
	        // A JPanel for Beliefs
	    	beliefpanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Beliefs"));
	    	c.gridx = 0;
	    	c.gridy = 2;
	        c.gridwidth = 2;
	    	add(beliefpanel, c);
	    	beliefpanel.setEnabled(false);
	    	
	        // A JPanel for Rules
	    	rules.setBorder(BorderFactory.createTitledBorder(loweredetched, "Rules"));
	    	c.gridx = 0;
	    	c.gridy = 3;
	        c.gridwidth = 2;
	    	add(rules, c);
	    	rules.setEnabled(false);
	    	
	    	// A Panel for the Sensor Streams
	        // A Panel for the ultrasound sensor values
	        ultra.setBorder(BorderFactory.createTitledBorder(loweredetched, "The Ultrasonic Sensor"));
	        c.gridx = 0;
	        c.gridy = 5;
	        c.gridwidth = 1;
	        add(ultra, c);
	        ultra.setEnabled(false);
	        
	        // The Instructions Panel
	        InstructionsPanel instructions = new InstructionsPanel(5, this);
	        instructions.setBorder(BorderFactory.createTitledBorder(loweredetched, "Instructions"));
	        c.gridx = 1;
	        c.gridy = 5;
	        c.gridwidth = 1;
	    	c.fill = GridBagConstraints.BOTH;
	        add(instructions, c);
	        addChangeListener(this);
			}

			boolean showing = false;
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (!showing) {
					ultra.componentShown();
					showing = true;
				} else {
					showing = false;
				}
			}
	    }

	
	    /**
	     * Constructs the User Interface.
	     * @param layout
	     */
	    private class ComplexPanel extends TabPanel implements ChangeListener {
	    	
			public ComplexPanel() {
	    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    		    		    	
	    	// A JPanel for Controls
	    	ControlsPanel controls = new ControlsPanel();
	    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
	    	c.gridx = 0;
	    	c.gridy = 1;
	        c.gridwidth = 2;
	    	add(controls, c);
	        
	        // A JPanel for Beliefs
	    	beliefpanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Beliefs"));
	    	c.gridx = 0;
	    	c.gridy = 2;
	        c.gridwidth = 1;
	    	add(beliefpanel, c);
	    	beliefpanel.setEnabled(false);
	    	
	    	// A JPanel for Goals
	    	goalpanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Goals"));
	    	c.gridx = 1;
	    	c.gridy = 2;
	        c.gridwidth = 1;
	    	add(goalpanel, c);
	    	goalpanel.setEnabled(false);
	    	

	        // A JPanel for Rules
	    	rules.setBorder(BorderFactory.createTitledBorder(loweredetched, "Rules"));
	    	c.gridx = 0;
	    	c.gridy = 3;
	        c.gridwidth = 2;
	    	add(rules, c);
	    	rules.setEnabled(false);
	    	
	    	// A Panel for Goals
	    	goals.setBorder(BorderFactory.createTitledBorder(loweredetched, "Goals"));
	    	c.gridx = 0;
	    	c.gridy = 4;
	    	add(goals, c);
	    	goals.setEnabled(false);

	    	// A Panel for the Sensor Streams
	        // A Panel for the ultrasound sensor values
	        ultra.setBorder(BorderFactory.createTitledBorder(loweredetched, "The Ultrasonic Sensor"));
	        c.gridx = 0;
	        c.gridy = 5;
	        c.gridwidth = 1;
	        add(ultra, c);
	        ultra.setEnabled(false);
	        
	        // The Instructions Panel
	        InstructionsPanel instructions = new InstructionsPanel(6, this);
	        instructions.setBorder(BorderFactory.createTitledBorder(loweredetched, "Instructions"));
	        c.gridx = 1;
	        c.gridy = 5;
	        c.gridwidth = 1;
	    	c.fill = GridBagConstraints.BOTH;
	        add(instructions, c);
	        
	        addChangeListener(this);
			}

			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				ultra.componentShown();
			}
	    }
	    
	    private class BeliefPanel extends DinoPanel {
	        @Override
	        public void setEnabled(boolean enabled) {
	        	super.setEnabled(enabled);
	        	belieflist.setEnabled(enabled);
	        }
	    	
	        
	        public BeliefPanel() {
	        	belieflist.setText(beliefs.toString());
	        	add(belieflist);
	        }
	    }
	    
	    private class GoalsPanel extends DinoPanel {
	        @Override
	        public void setEnabled(boolean enabled) {
	        	super.setEnabled(enabled);
	        	goallist.setEnabled(enabled);
	        }
	    	
	        
	        public GoalsPanel() {
	        	goallist.setText(currentgoals.toString());
	        	add(goallist);
	        }
	    }

	    private class GoalPanel extends DinoPanel {
	    	JButton growl = new JButton("Do scare away intruders"), find_water = new JButton("Achieve believe there is water"), drop_goal = new JButton("Stop trying to find water");
	    	
	    	@Override
	    	public void setEnabled(boolean enabled) {
	    		super.setEnabled(enabled);
	    		growl.setEnabled(enabled);
	    		find_water.setEnabled(enabled);
	    		drop_goal.setEnabled(enabled);
	    		if (!enabled) {
	    			envThread.latestAction(new Action("drop_goal"));
	    		}

	    	}
	    	
	    	public GoalPanel() {
	    		growl.setActionCommand("do_growl");
	    		growl.addActionListener(DinoUI.this);
	    		find_water.setActionCommand("achieve_water");
	    		find_water.addActionListener(DinoUI.this);
	    		drop_goal.setActionCommand("drop_goal");
	    		drop_goal.addActionListener(DinoUI.this);
	    		c.gridx = 0;
	    		c.gridwidth = 1;
	    		add(growl, c);
	    		c.gridx = 1;
	    		add(find_water);
	    		c.gridx = 2;
	    		add(drop_goal);
	    	}
	    	
	    }
	    
	    private class SensorPanel extends DinoPanel {
	    	JLabel vtext = new JLabel("Ultrasonic Sensor Values:");
	    	JTextArea textArea = new JTextArea(15, 30);
	        JPanel output = new JPanel();
		    protected TextAreaOutputStream uvalues;
	        
	        @Override
	        public void setEnabled(boolean enabled) {
	        	super.setEnabled(enabled);
	        	vtext.setEnabled(enabled);
	        	textArea.setEnabled(enabled);
	        	output.setEnabled(enabled);
	        	
	        }
	    		        
	    	public SensorPanel() {
		        c.gridx = 0;
		        c.gridy = 1;
		        c.gridwidth = 1;
		        add(vtext, c);
		        uvalues = new TextAreaOutputStream(textArea, "Ultrasound Sensor Value");
		        output.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		        c.gridx = 0;
		        c.gridy = 2;
		        c.gridwidth = 1;
		        add(output, c);
	    		
	    	}

			public void componentShown() {
				// TODO Auto-generated method stub
		        ((DinoEnvironment) env).setUltraPrintStream(rName, new PrintStream(uvalues));
			}
				
	    }
	    
	    private class InstructionsPanel extends DinoPanel {
	    	ArrayList<String> instructions = new ArrayList<String>();
	    	TabPanel panel;
	    	int step = 0;
	    	int limit = 6;
	    	
	    	public InstructionsPanel(int limit, TabPanel panel) {
	    		super();
	    		this.panel = panel;
	    		setLayout(new BorderLayout());
	    		String instructions1 = "Use the Forward, Reverse, Left, Right and Stop buttons in controls to steer your robot.";
	    		String instructions2 = "The Ultrasonic Sensor detects the distance from the front of the Triceratops to an obstacle.\n\n  You can see the values it is returning on the left.";
	    		String instructions3 = "If the value from the sensor falls below 0.5 then the Triceratops believes there is an obstacle in front of it.\n\n  You can see this belief appear in the Belief section.";
	    		String instructions4 = "You can use rules to tell the Triceratops how to react to the appearance and  disappearance of obstacles.\n\n  Use the checkboxes to enable and disable rules and use the drop down menus to select the sequenc of actions the Triceratops should take.";
	    		String instructions5 = "You can vary your rules depending upon the situation the Triceratops finds itself in.\n\n  For instance you can create separate rules for how it should behave when an obstacle appears when the Triceratops has found water, and when it hasn't.\n\n Note that if two rules both apply in the same situation, then the Triceratops will only follow the first.";
	    		String instructions6 = "You can set goals for the Triceratops to get more complex behaviours\n\n Do scare away intruders will make the Triceratops growl and gnash its teeth\n\n Achieve believe there is water will cause the Triceratops to look for water only stopping when it is found.  It does this by finding a path and then following it to the water.";
	    		
	    		instructions.add(instructions1);
	    		instructions.add(instructions2);
	    		instructions.add(instructions3);
	    		instructions.add(instructions4);
	    		instructions.add(instructions5);
	    		instructions.add(instructions6);
	    		
		    	JTextArea info1 = new JTextArea(instructions.get(step));
		    	info1.setLineWrap(true);
		    	info1.setWrapStyleWord(true);
		    	info1.setBackground(this.getBackground());
		    	info1.setSize(300, 300);
		    	
		    	step++;
		    	add(info1, BorderLayout.NORTH);
		    	
		    	if (limit > 1) {
		    	JPanel buttonpanel = new JPanel();
		    	add(buttonpanel, BorderLayout.SOUTH);
		    	buttonpanel.setLayout(new GridBagLayout());
		    	JButton nextbutton = new JButton("Next");
		    	nextbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (step == limit - 1) {
							step = 0;
						} else {
							step++;
						}

						enablePanels(step);
						info1.setText(instructions.get(step));
						
					}
		    		
		    	});
		    	c.gridx = 0;
		    	c.gridy = 0;
		    	buttonpanel.add(nextbutton, c);

		    	JButton previousbutton = new JButton("Back");
		    	previousbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (step != 0) {
							step--;
						}

						enablePanels(step);
						info1.setText(instructions.get(step));
					}
		    		
		    	});
		    	c.gridx = 1;
		    	c.gridy = 0;
		    	c.gridwidth = 1;
		    	buttonpanel.add(previousbutton, c);

		    	JButton resetbutton = new JButton("Restart");
		    	resetbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						step = 0;
						enablePanels(step);
						info1.setText(instructions.get(step));	
					}
		    		
		    	});
		    	c.gridx = 2;
		    	c.gridy = 0;
		    	buttonpanel.add(resetbutton, c);
		    	}
	    		
	    	}
	    	
	    	private void enablePanels(int step) {
	    		switch (step) {
	    			case 5:
	    				panel.beliefpanel.setEnabled(true);
	    				panel.ultra.setEnabled(true);
	    				panel.goals.setEnabled(true);
	    				panel.goalpanel.setEnabled(true);
	    				panel.rules.setEnabled(false);
	    				panel.rules.choiceEnabled(false);
	    				break;
	    			case 4:
	    				panel.beliefpanel.setEnabled(true);
	    				panel.ultra.setEnabled(true);
	    				panel.rules.setEnabled(true);
	    				panel.rules.choiceEnabled(true);
	    				panel.goals.setEnabled(false);
	    				panel.goalpanel.setEnabled(false);
	    				break;
	    			case 3:
	    				panel.beliefpanel.setEnabled(true);
	    				panel.ultra.setEnabled(true);
	    				panel.rules.setEnabled(true);
	    				panel.rules.choiceEnabled(false);
	    				panel.goals.setEnabled(false);
	    				panel.goalpanel.setEnabled(false);
	    				break;	    			
	    			case 2:
	    				panel.beliefpanel.setEnabled(true);
	    				panel.ultra.setEnabled(true);
	    				panel.rules.setEnabled(false);
	    				panel.goals.setEnabled(false);
	    				panel.goalpanel.setEnabled(false);
	    				break;
	    			case 1:
	    				panel.beliefpanel.setEnabled(false);
	    				panel.ultra.setEnabled(true);
	    				panel.rules.setEnabled(false);
	    				panel.goals.setEnabled(false);
	    				panel.goalpanel.setEnabled(false);
	    				break;
	    			default:
	    				panel.beliefpanel.setEnabled(false);
	    				panel.ultra.setEnabled(false);
	    				panel.rules.setEnabled(false);
	    				panel.goals.setEnabled(false);
	    				panel.goalpanel.setEnabled(false);
	    		}
	    				
	    	}
	    }
	    
	    public class DinoPanel extends JPanel {
	    	GridBagConstraints c = new GridBagConstraints();
	    	public DinoPanel() {
	    		setLayout(new GridBagLayout());
	    	}
	    }
	    
	    public class TabPanel extends DinoPanel {
	        SensorPanel ultra = new SensorPanel(); 
	        BeliefPanel beliefpanel = new BeliefPanel();
	        GoalsPanel goalpanel = new GoalsPanel();
	    	RulesPanel rules = new RulesPanel();
	    	GoalPanel goals = new GoalPanel();	    	
	    }
	    	    
	    private class ControlsPanel extends DinoPanel {
		    protected JButton fbutton, rbutton, lbutton, sbutton, bbutton, lfbutton;
	    	
	    	public ControlsPanel() {
	    	// Forward
	    	fbutton = new JButton("Forward");
	        fbutton.setMnemonic(KeyEvent.VK_F);
	        fbutton.setActionCommand("forward");
	        fbutton.addActionListener(DinoUI.this);
	        fbutton.setToolTipText("Click to move Forward");
	        c.gridx = 0;
	        c.gridy = 0;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.BOTH;
	        add(fbutton, c);
	    	
	        // Right
	        rbutton = new JButton("Right");
	        rbutton.setMnemonic(KeyEvent.VK_R);
	        rbutton.setActionCommand("right");
	        rbutton.addActionListener(DinoUI.this);
	        rbutton.setToolTipText("Click to turn Right");
	        c.gridx = 1;
	        c.gridy = 0;
	        add(rbutton, c);

	        // Left
	        lbutton = new JButton("Left");
	        lbutton.setMnemonic(KeyEvent.VK_L);
	        lbutton.setActionCommand("left");
	        lbutton.addActionListener(DinoUI.this);
	        lbutton.setToolTipText("Click to turn Left");
	        c.gridx = 2;
	        c.gridy = 0;
	        add(lbutton, c);
	        
	        // Stop
	        sbutton = new JButton("Stop");
	        sbutton.setMnemonic(KeyEvent.VK_S);
	        sbutton.setActionCommand("stop");
	        sbutton.addActionListener(DinoUI.this);
	        sbutton.setToolTipText("Click to Stop");
	        c.gridx = 3;
	        c.gridy = 0;
	        add(sbutton, c);
	        
	        // Reverse
	        bbutton = new JButton("Reverse");
	        bbutton.setMnemonic(KeyEvent.VK_S);
	        bbutton.setActionCommand("backward");
	        bbutton.addActionListener(DinoUI.this);
	        bbutton.setToolTipText("Click to Go Backwards");
	        c.gridx = 4;
	        c.gridy = 0;
	        add(bbutton, c);

	        
	        // Reverse
	        lfbutton = new JButton("Growl");
	        lfbutton.setActionCommand("growl");
	        lfbutton.addActionListener(DinoUI.this);
	        c.gridx = 5;
	        c.gridy = 0;
	        add(lfbutton, c);
	    	}

	    }
	    

	    private class RulesPanel extends JPanel {
		    JCheckBox r1button = new JCheckBox("If you"), r2button = new JCheckBox("If you"), r3button = new JCheckBox("If you"), r4button = new JCheckBox("If you");
		    ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
		    JComboBox<String> r1action1box = new JComboBox<String>(actions), r1action2box = new JComboBox<String>(actions), r1action3box = new JComboBox<String>(actions), 
		    	r2action1box = new JComboBox<String>(actions), r2action2box = new JComboBox<String>(actions), r2action3box = new JComboBox<String>(actions), 
		    	r3action1box = new JComboBox<String>(actions), r3action2box = new JComboBox<String>(actions), r3action3box = new JComboBox<String>(actions), 
		    	r4action1box = new JComboBox<String>(actions), r4action2box = new JComboBox<String>(actions), r4action3box = new JComboBox<String>(actions), 
		    	r1choicebox = new JComboBox<String>(choices), r2choicebox = new JComboBox<String>(choices), r3choicebox = new JComboBox<String>(choices), r4choicebox = new JComboBox<String>(choices);
		    ArrayList<JComboBox<String>> action1s = new ArrayList<JComboBox<String>>();
		    ArrayList<JComboBox<String>> action2s = new ArrayList<JComboBox<String>>();
		    ArrayList<JComboBox<String>> action3s = new ArrayList<JComboBox<String>>();
		    ArrayList<JComboBox<String>> contexts = new ArrayList<JComboBox<String>>();
		    JLabel r1 = new JLabel("Believe an Obstacle has appeared "); 
	        JLabel r2 = new JLabel("Believe an Obstacle has vanished "); 
		    JLabel r3 = new JLabel("Believe an Obstacle has appeared "); 
	        JLabel r4 = new JLabel("Believe an Obstacle has vanished "); 
	        ArrayList<JLabel> triggers = new ArrayList<JLabel>();
	        
	        JLabel act1d1 = new JLabel("then 1.");
	        JLabel act1d2 = new JLabel("then 1.");
	        JLabel act1d3 = new JLabel("then 1.");
	        JLabel act1d4 = new JLabel("then 1.");
	        ArrayList<JLabel> act1d = new ArrayList<JLabel>();

	        JLabel act2d1 = new JLabel("2.");
	        JLabel act2d2 = new JLabel("2.");
	        JLabel act2d3 = new JLabel("2.");
	        JLabel act2d4 = new JLabel("2.");
	        ArrayList<JLabel> act2d = new ArrayList<JLabel>();

	        JLabel act3d1 = new JLabel("3.");
	        JLabel act3d2 = new JLabel("3.");
	        JLabel act3d3 = new JLabel("3.");
	        JLabel act3d4 = new JLabel("3.");
	        ArrayList<JLabel> act3d = new ArrayList<JLabel>();

	        JLabel and1 = new JLabel("and you believe");
	        JLabel and2 = new JLabel("and you believe");
	        JLabel and3 = new JLabel("and you believe");
	        JLabel and4 = new JLabel("and you believe");
	        ArrayList<JLabel> and = new ArrayList<JLabel>();
		    
		    
		    @Override
		    public void setEnabled(boolean enabled) {
		    	super.setEnabled(enabled);
		    	for (int i = 0; i < 2; i++) {
		    		checkboxes.get(i).setEnabled(enabled);
		    		if (!enabled) {
		    			if ( checkboxes.get(i).isSelected() ) {
		    				checkboxes.get(i).setSelected(false);
		    				int rulenum = i + 1;
		    				String rulestring = "rule" + rulenum;
		    				envThread.latestAction(new Action(rulestring));
		    			}
		    		}
		    		action1s.get(i).setEnabled(enabled);
		    		action2s.get(i).setEnabled(enabled);
		    		action3s.get(i).setEnabled(enabled);
		    		triggers.get(i).setEnabled(enabled);
		    		act1d.get(i).setEnabled(enabled);
		    		act2d.get(i).setEnabled(enabled);
		    		act3d.get(i).setEnabled(enabled);
		    	}
		    	if (!enabled) {
		    		choiceEnabled(enabled);
		    	}
		    }
		    
		    public void choiceEnabled(boolean enabled) { 
		    	for (int i = 0; i < 4; i++) {
		    		contexts.get(i).setEnabled(enabled);
		    		and.get(i).setEnabled(enabled);
		    		if (i >= 2) {
			    		checkboxes.get(i).setEnabled(enabled);
			    		if (!enabled) {
			    			if ( checkboxes.get(i).isSelected() ) {
			    				checkboxes.get(i).setSelected(false);
			    				int rulenum = i + 1;
			    				String rulestring = "rule" + rulenum;
			    				envThread.latestAction(new Action(rulestring));
			    			}
			    		}
			    		action1s.get(i).setEnabled(enabled);
			    		action2s.get(i).setEnabled(enabled);
			    		action3s.get(i).setEnabled(enabled);
			    		triggers.get(i).setEnabled(enabled);
			    		act1d.get(i).setEnabled(enabled);
			    		act2d.get(i).setEnabled(enabled);
			    		act3d.get(i).setEnabled(enabled);		    			
		    		}
		    	}
		    }
		    
		    private void ruleline1(int gridy, GridBagConstraints c, int rulenumber) {
		    	c.gridy = gridy;
		        c.gridx = 0;
		        c.gridwidth = 1;
		        add(checkboxes.get(rulenumber), c);
		        c.gridx = 1;
		        add(triggers.get(rulenumber), c);
		        c.gridx = 2;
		        add(and.get(rulenumber), c);
		        c.gridx = 3;
		        c.anchor = GridBagConstraints.LINE_START;
		        add(contexts.get(rulenumber), c);
		        c.anchor = GridBagConstraints.CENTER;
		    }
		    
		    private void ruleline2(int gridy, GridBagConstraints c, int rulenumber) {
		        c.gridx = 2;
		        c.gridy = gridy;
		        c.anchor = GridBagConstraints.LINE_END;
		        add(act1d.get(rulenumber), c);
		        c.gridx = 3;
		        c.anchor = GridBagConstraints.CENTER;
		        add(action1s.get(rulenumber), c);	        
		        c.gridx = 4;
		        add(act2d.get(rulenumber), c);
		        c.gridx = 5;
		        add(action2s.get(rulenumber), c);	   
		        c.gridx = 6;
		        add(act3d.get(rulenumber), c);
		        c.gridx = 7;
		        add(action3s.get(rulenumber), c);	   

		    }

		    public RulesPanel() {
		    	setLayout(new GridBagLayout());
		    	GridBagConstraints c = new GridBagConstraints();
		    	
		    	triggers.add(r1);
		    	triggers.add(r2);
		    	triggers.add(r3);
		    	triggers.add(r4);
		    	
		    	checkboxes.add(r1button);
		    	checkboxes.add(r2button);
		    	checkboxes.add(r3button);
		    	checkboxes.add(r4button);
		    	
		    	and.add(and1);
		    	and.add(and2);
		    	and.add(and3);
		    	and.add(and4);
		    	
		    	contexts.add(r1choicebox);
		    	contexts.add(r2choicebox);
		    	contexts.add(r3choicebox);
		    	contexts.add(r4choicebox);
		    	
		    	act1d.add(act1d1);
		    	act1d.add(act1d2);
		    	act1d.add(act1d3);
		    	act1d.add(act1d4);

		    	act2d.add(act2d1);
		    	act2d.add(act2d2);
		    	act2d.add(act2d3);
		    	act2d.add(act2d4);

		    	act3d.add(act3d1);
		    	act3d.add(act3d2);
		    	act3d.add(act3d3);
		    	act3d.add(act3d4);
		    	
		    	action1s.add(r1action1box);
		    	action1s.add(r2action1box);
		    	action1s.add(r3action1box);
		    	action1s.add(r4action1box);

		    	action2s.add(r1action2box);
		    	action2s.add(r2action2box);
		    	action2s.add(r3action2box);
		    	action2s.add(r4action2box);

		    	action3s.add(r1action3box);
		    	action3s.add(r2action3box);
		    	action3s.add(r3action3box);
		    	action3s.add(r4action3box);
		    	
		    	for (int i = 0; i < 4; i++) {
		    		int printednumber = i + 1;
		    		int gridline = 2*i;
			    	triggers.get(i).setFont(new Font("Sans Serif", Font.BOLD, 12));
			    	
			    	String rulestring = "rule" + printednumber;
			    	checkboxes.get(i).setActionCommand(rulestring);
			    	checkboxes.get(i).addActionListener(DinoUI.this);
			    	checkboxes.get(i).setToolTipText("Activate Rule " + printednumber);
			    	
			    	contexts.get(i).setActionCommand("r" + printednumber + "context");
			    	contexts.get(i).addActionListener(DinoUI.this);
			    	ruleline1(gridline, c, i);
			    	
			    	action1s.get(i).setActionCommand("r" + printednumber + "action1");
			    	action1s.get(i).addActionListener(DinoUI.this);
			    	action2s.get(i).setActionCommand("r" + printednumber + "action2");
			    	action2s.get(i).addActionListener(DinoUI.this);
			    	action3s.get(i).setActionCommand("r" + printednumber + "action3");
			    	action3s.get(i).addActionListener(DinoUI.this);
			    	ruleline2(gridline+1, c, i);
		    	}

	    	}

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
	     * A text area to display the contents of an output stream.
	     * @author lad
	     *
	     */
	    public class TextAreaOutputStream extends OutputStream {

	    	   private final JTextArea textArea;
	    	   private final StringBuilder sb = new StringBuilder();
	    	   private String title;

	    	   public TextAreaOutputStream(final JTextArea textArea, String title) {
	    	      this.textArea = textArea;
	    	      this.title = title;
	    	      sb.append(title + "> ");
	    	   }

	    	   /*
	    	    * (non-Javadoc)
	    	    * @see java.io.OutputStream#flush()
	    	    */
	    	   public void flush() {
	    	   }

	    	   /*
	    	    * (non-Javadoc)
	    	    * @see java.io.OutputStream#close()
	    	    */
	    	   public void close() {
	    	   }

	    	   /*
	    	    * (non-Javadoc)
	    	    * @see java.io.OutputStream#write(int)
	    	    */
	    	   public void write(int b) throws IOException {

	    	      if (b == '\r')
	    	         return;

	    	      if (b == '\n') {
	    	         final String text = sb.toString() + "\n";
	    	         SwingUtilities.invokeLater(new Runnable() {
	    	            public void run() {
	    	               textArea.append(text);
	    	            }
	    	         });
	    	         sb.setLength(0);
	    	         sb.append(title + "> ");
	    	         return;
	    	      }

	    	      sb.append((char) b);
	    	   }
	    }
	    
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
