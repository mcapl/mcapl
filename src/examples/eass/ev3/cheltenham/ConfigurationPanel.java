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

import eass.mas.ev3.EASSEV3Environment;
import ail.syntax.Action;
import ail.syntax.NumberTermImpl;

public class ConfigurationPanel extends JPanel implements ActionListener, WindowListener, PropertyChangeListener {
	JFormattedTextField distancebox, waterbox, pathbox;
    protected double dthreshold=0.5;
    private boolean dtinit  = false;
    
    private EASSEV3Environment env;
    protected static String rName = "dinor3x";
	
	public ConfigurationPanel(JFrame frame, EASSEV3Environment env) {
		this.env = env;
    	setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
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
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		
		if (source == distancebox) {
			setDistance();
		}
	}
	
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
 