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
	JFormattedTextField distancebox, waterubox, waterlbox, pathbox;
    protected double dthreshold=0.5;
    private boolean dtinit  = false;
    protected double pthreshold=0.04;
    private boolean pinit  = false;
    protected double wuthreshold=0.15;
    protected double wlthreshold=0.1;
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
 