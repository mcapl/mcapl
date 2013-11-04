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

package eass.nxt.legorover.simple;

import javax.swing.*;   
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintStream;

import eass.mas.nxt.EASSNXTEnvironment;
import ail.syntax.Action;
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
public class LegoRoverUI extends JPanel implements ActionListener, WindowListener, PropertyChangeListener {
		private static final long serialVersionUID = 1L;
		
		// The various buttons and boxes used by the interface.
	    protected JButton fbutton, rbutton, lbutton, sbutton, delaybutton, r90button, l90button, bbutton;
	    protected JCheckBox r1button, r2button, r3button;
	    protected JComboBox<String> delaybox;
	    protected JFormattedTextField speedbox, rspeedbox, distancebox;
	    protected TextAreaOutputStream uvalues;
	    protected NumberFormat numberFormat;
	    //
	    // 500 = 0.5s = Satellite Call UK-Australia
	    // 1000 = 1s
	    // 13000 = 1.3s = Earth-Moon delay
	    // 180000 = 3 min = Earth-Mars delay
	    protected String[] delays = {"0","500","1000","1300","180000"};
	    
	    // The delay before instructions reach the robot, the environment and the default robot name.
	    protected int delay = 0;
	    protected static EASSNXTEnvironment env;
	    protected static String rName = "noor";
	    
	    // Wrapping the environment in a thread so events are handled faster.
	    protected EnvironmentThread envThread = new EnvironmentThread();
	
	    /**
	     * Constructs the User Interface.
	     * @param layout
	     */
	    public LegoRoverUI(GridBagLayout layout) {
	    	
			
	    	setLayout(layout);
	    	GridBagConstraints c = new GridBagConstraints();
	    	
	    	// A JPanel for Settings
	    	JPanel settings = new JPanel();
	    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    	settings.setBorder(BorderFactory.createTitledBorder(loweredetched, "Settings"));
	    	c.gridx = 0;
	    	c.gridy = 0;
	        c.gridwidth = 1;
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    	add(settings, c);
	    	
	    	// ---------- Components of the Settings box
	    	
	    	// Delay
	    	JLabel dtext = new JLabel("Delay:");
	    	settings.add(dtext);
	    	delaybox = new JComboBox<String>(delays);
	    	delaybox.setActionCommand("delay");
	    	delaybox.addActionListener(this);
	    	settings.add(delaybox);
	    	
	    	// Speed
	    	JLabel stext = new JLabel("Forward Speed:");
	    	settings.add(stext);
	    	NumberFormat f = NumberFormat.getIntegerInstance(); 
	    	f.setMaximumIntegerDigits(3);
	    	speedbox = new JFormattedTextField(f);
	    	speedbox.setValue(10);
	    	speedbox.setColumns(3);
	    	speedbox.addPropertyChangeListener(this);
	    	settings.add(speedbox);
	    	
	    	// Speed
	    	JLabel ttext = new JLabel("Turning Speed:");
	    	settings.add(ttext);
	    	NumberFormat f1 = NumberFormat.getIntegerInstance(); 
	    	f1.setMaximumIntegerDigits(3);
	    	rspeedbox = new JFormattedTextField(f1);
	    	rspeedbox.setValue(15);
	    	rspeedbox.setColumns(3);
	    	rspeedbox.addPropertyChangeListener(this);
	    	settings.add(rspeedbox);
	    		    	
	    	// A JPanel for Controls
	    	JPanel controls = new JPanel();
	    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
	    	controls.setLayout(new GridBagLayout());
	    	c.gridx = 0;
	    	c.gridy = 1;
	    	add(controls, c);

	    	// Forward
	    	fbutton = new JButton("Forward");
	        fbutton.setMnemonic(KeyEvent.VK_F);
	        fbutton.setActionCommand("forward");
	        fbutton.addActionListener(this);
	        fbutton.setToolTipText("Click to move Forward");
	        c.gridx = 0;
	        c.gridy = 0;
	        c.gridwidth = 1;
	        controls.add(fbutton, c);
	    	
	        // Right
	        rbutton = new JButton("Right");
	        rbutton.setMnemonic(KeyEvent.VK_R);
	        rbutton.setActionCommand("right");
	        rbutton.addActionListener(this);
	        rbutton.setToolTipText("Click to turn Right");
	        c.gridx = 1;
	        c.gridy = 0;
	        controls.add(rbutton, c);

	        // Left
	        lbutton = new JButton("Left");
	        lbutton.setMnemonic(KeyEvent.VK_L);
	        lbutton.setActionCommand("left");
	        lbutton.addActionListener(this);
	        lbutton.setToolTipText("Click to turn Left");
	        c.gridx = 2;
	        c.gridy = 0;
	        controls.add(lbutton, c);
	        
	        // Stop
	        sbutton = new JButton("Stop");
	        sbutton.setMnemonic(KeyEvent.VK_S);
	        sbutton.setActionCommand("stop");
	        sbutton.addActionListener(this);
	        sbutton.setToolTipText("Click to Stop");
	        c.gridx = 3;
	        c.gridy = 0;
	        controls.add(sbutton, c);
	        
	        // Reverse
	        bbutton = new JButton("Reverse");
	        bbutton.setMnemonic(KeyEvent.VK_S);
	        bbutton.setActionCommand("backward");
	        bbutton.addActionListener(this);
	        bbutton.setToolTipText("Click to Got Backwards 10");
	        c.gridx = 0;
	        c.gridy = 1;
	        controls.add(bbutton, c);

	        // Right 90
	        r90button = new JButton("Right (90)");
	        r90button.setActionCommand("right90");
	        r90button.addActionListener(this);
	        r90button.setToolTipText("Click to turn Right 90 degrees");
	        c.gridx = 1;
	        c.gridy = 1;
	        controls.add(r90button, c);

	        // Left 90
	        l90button = new JButton("Left (90)");
	        l90button.setActionCommand("left90");
	        l90button.addActionListener(this);
	        l90button.setToolTipText("Click to turn Left 90 degrees");
	        c.gridx = 2;
	        c.gridy = 1;
	        controls.add(l90button, c);
	        
	    	// A JPanel for Rules
	    	JPanel rules = new JPanel();
	    	rules.setBorder(BorderFactory.createTitledBorder(loweredetched, "Rules"));
	    	rules.setLayout(new GridBagLayout());
	    	c.gridx = 0;
	    	c.gridy = 2;
	        c.gridwidth = 1;
	    	add(rules, c);

	    	// Rule 1
	    	r1button = new JCheckBox("rule1:");
	        r1button.setActionCommand("rule1");
	        r1button.addActionListener(this);
	        r1button.setToolTipText("Activate rule 1");
	        c.gridx = 0;
	        c.gridy = 0;
	        c.gridwidth = 1;
	        rules.add(r1button, c);
	        JLabel r1 = new JLabel("if you Believe there is an obstacle then Stop ");
	        c.gridx = 1;
	        c.gridy = 0;
	        rules.add(r1, c);
	       
	        // Rule 2
	        r2button = new JCheckBox("rule2:");
	        r2button.setActionCommand("rule2");
	        r2button.addActionListener(this);
	        r2button.setToolTipText("Activate rule 2");
	        c.gridx = 0;
	        c.gridy = 1;
	        rules.add(r2button, c);
	        JLabel r2 = new JLabel("if you Believe there is an obstacle then Stop and then Turn Right ");
	        c.gridx = 1;
	        c.gridy = 1;
	        rules.add(r2, c);

	        // Rule 3
	        r3button = new JCheckBox("rule3:");
	        r3button.setActionCommand("rule3");
	        r3button.addActionListener(this);
	        r3button.setToolTipText("Activate rule 3");
	        c.gridx = 0;
	        c.gridy = 2;
	        rules.add(r3button, c);
	        JLabel r3 = new JLabel("if you Believe there is an obstacle then Reverse and then Turn Right ");
	        c.gridx = 1;
	        c.gridy = 2;
	        rules.add(r3, c);
	        
	        // Control of Ultrasound Sensor
	    	if (env.getRobot(rName) instanceof LegoRoverEnvironment.Noor) {
	    		// Obstacle Distance
		    	JPanel ultra = new JPanel();
		    	ultra.setBorder(BorderFactory.createTitledBorder(loweredetched, "The Ultrasonic Sensor"));
		    	ultra.setLayout(new GridBagLayout());
		    	c.gridx = 0;
		    	c.gridy = 3;
		        c.gridwidth = 1;
		    	add(ultra, c);
		    	
		    	// Distance Setting
		    	JLabel utext = new JLabel("Obstacle Distance:");
		    	ultra.add(utext);
		    	NumberFormat f2 = NumberFormat.getIntegerInstance(); 
		    	f2.setMaximumIntegerDigits(3);
		    	distancebox = new JFormattedTextField(f2);
		    	distancebox.setValue(50);
		    	distancebox.setColumns(3);
		    	distancebox.addPropertyChangeListener(this);
		    	ultra.add(distancebox);
		    	
		    	// Ultrasound Values
		    	JLabel vtext = new JLabel("Ultrasonic Sensor Values:");
		    	c.gridx = 0;
		    	c.gridy = 1;
		        c.gridwidth = 2;
		    	ultra.add(vtext, c);
		    	JTextArea textArea = new JTextArea(15, 30);
		    	uvalues = new TextAreaOutputStream(textArea, "Ultrasound Sensor Value");
		    	((LegoRoverEnvironment) env).setUltraPrintStream(rName, new PrintStream(uvalues));
		    	JPanel output = new JPanel();
		    	output.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		    	c.gridx = 0;
		    	c.gridy = 2;
		        c.gridwidth = 2;
		    	ultra.add(output, c);
		    	

	    	}
	    	
	    	envThread.start();


	    }

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Mars Robot");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        LegoRoverUI contentPane = new LegoRoverUI(new GridBagLayout());
	        frame.addWindowListener(contentPane);
	        frame.setContentPane(contentPane);
	 
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	    /**
	     * Start up the whole application
	     * @param args
	     */
	    public static void main(String[] args) {
	    	AILConfig config;
	    	// By default the robot is Noor, but if a different name is supplied then this is used.
	    	if (args.length > 0) {
	    		rName = args[0];
	    	}
	    	
	    	if (rName.equals("claudia")) {
		    	config = new AILConfig("/src/examples/eass/nxt/legorover/simple/Claudia.ail");
	    	} else {
	    		config = new AILConfig("/src/examples/eass/nxt/legorover/simple/Noor.ail");
	    	}
			AIL.configureLogging(config);
		
			MAS mas = AIL.AILSetup(config);
			env = (EASSNXTEnvironment) mas.getEnv();
			
			//Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }}
	        );

	        // Lastly we construct a controller.
			MCAPLcontroller mccontrol = new MCAPLcontroller(mas, "", 1);
			// Start the system.
			mccontrol.begin(); 
			mas.finalize();
			
	    }
	
	    
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
		public void actionPerformed(ActionEvent e) {
	    	Action act = new Action(e.getActionCommand());
	    	
	    	if (e.getActionCommand().equals("delay")) {
	    		@SuppressWarnings("unchecked")
	    		JComboBox<String> cb = (JComboBox<String>)e.getSource();
	    		delay = Integer.parseInt((String)cb.getSelectedItem());
	    		return;
	    	}
	    	
	    	envThread.latestAction(act);
	    		    	

		}
		
		/*
		 * (non-Javadoc)
		 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent e) {
			Object source = e.getSource();
			
			if (source == speedbox) {
				Number speed = (Number) speedbox.getValue();
			
				Action act = new Action("speed");
				act.addTerm(new NumberTermImpl(speed.intValue()));
			
				try {
					env.executeAction(rName, act);
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			} else if (source == rspeedbox) {
				Number speed = (Number) rspeedbox.getValue();
				
				Action act = new Action("rspeed");
				act.addTerm(new NumberTermImpl(speed.intValue()));
			
				try {
					env.executeAction(rName, act);
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
				
			} else if (source == distancebox) {
				Number distance = (Number) distancebox.getValue();
				
				Action act = new Action("obstacle_distance");
				act.addTerm(new NumberTermImpl(distance.intValue()));
				try {
					env.executeAction(rName, act);
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
						
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
	    	envThread.stopRunning();
	    	env.close(rName);
	    	System.out.println("closing "+rName);
	    }
	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	     */
	    public void windowClosing(WindowEvent e) {
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
