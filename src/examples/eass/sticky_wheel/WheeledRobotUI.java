package eass.sticky_wheel;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.awt.GridBagLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ajpf.MCAPLcontroller;
import eass.mas.nxt.EASSNXTEnvironment;

public class WheeledRobotUI extends JPanel implements ActionListener,
		PropertyChangeListener, WindowListener {
	static String path="/src/examples/eass/sticky_wheel/";
	static String config_file = "sticky_wheel.ail";
	String rName = "sticky";
	static SimpleWheeledRobotEnv env;
	MovementCanvas canvas = new MovementCanvas();
	JFormattedTextField xbox, ybox;
	JButton go;
	double target_x;
	double target_y;
	
	public WheeledRobotUI(GridBagLayout layout) {
    	setLayout(layout);
    	GridBagConstraints c = new GridBagConstraints();
    	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    	// A JPanel for Controls
    	JPanel controls = new JPanel();
    	controls.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
    	controls.setLayout(new GridBagLayout());
    	c.gridx = 0;
    	c.gridy = 1;
    	add(controls, c);
    	
    	JLabel xtext = new JLabel("X:");
    	controls.add(xtext);
    	NumberFormat f = NumberFormat.getNumberInstance();
    	f.setMaximumIntegerDigits(3);
    	xbox = new JFormattedTextField(f);
     	xbox.setColumns(3);
    	xbox.addPropertyChangeListener(this);
    	controls.add(xbox);

    	JLabel ytext = new JLabel("Y:");
    	controls.add(ytext);
    	ybox = new JFormattedTextField(f);
     	ybox.setColumns(3);
    	ybox.addPropertyChangeListener(this);
    	controls.add(ybox);

    	go = new JButton("Go!");
        go.setMnemonic(KeyEvent.VK_G);
        go.setActionCommand("go");
        go.addActionListener(this);
        go.setToolTipText("Click to Move");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        controls.add(go, c);

        //A MovementCanvas
    	add(canvas);

	}
	
	public void updateGraphics(double  x, double y, double theta) {
		canvas.updateGraphics(x, y, theta);
	}
	
	public class MovementCanvas extends Canvas {
		double x;
		double y;
		double theta;
		double xp;
		double yp;
		double thetap;
		Polygon robot;
		int[] xs;
		int[] ys;
		int points = 0;
		
		public MovementCanvas() {
			setSize(1000, 1000);
			setBackground(Color.white);
		}
		
		public Polygon getPolygon() {
			Polygon p = new Polygon();
			p.addPoint((int) x, (int) y);
			double x2 = x + Math.sin(theta);
			double y2 = y + Math.cos(theta);
			p.addPoint((int) x2, (int) y2);
			
			double x3 = x2 - Math.cos(theta);
			double y3 = y2 + Math.sin(theta);
			p.addPoint((int) x3, (int) y3);
			
			double x4 = x - Math.cos(theta);
			double y4 = y + Math.sin(theta);
			p.addPoint((int) x4, (int) y4);
			
			return p;
			
		}
		
		public void paint(Graphics g) {
			x = env.getX();
			y = env.getY();
			xs[points] = (int) x;
			ys[points] = (int) y;
			points++;
			theta = env.getTheta();
			
			g.drawPolygon(getPolygon());
		}
		
		public void update(Graphics g) {
			if (((Double) xp) != null) {
				x = xp;
				y = yp;
				theta=thetap;
				xs[points] = (int) xp;
				ys[points] = (int) yp;
				points++;
				g.drawPolyline(xs, ys, points);
				g.drawPolygon(getPolygon());
			}
		}
		
		public void updateGraphics(double x1, double y1, double theta1) {
			xp = x1;
			yp = y1;
			thetap = theta1;
			repaint();
		}
	}
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Mars Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        WheeledRobotUI contentPane = new WheeledRobotUI(new GridBagLayout());
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
    	AILConfig config = new AILConfig(path + config_file);

    	AIL.configureLogging(config);
	
		MAS mas = AIL.AILSetup(config);
		env = (SimpleWheeledRobotEnv) mas.getEnv();
		
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
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		Object source = evt.getSource();
		
		if (source == xbox) {
			target_x = (Double) xbox.getValue();
		} else if  (source == ybox) {
			target_y = (Double) ybox.getValue();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Predicate target = new Predicate("target");
		target.addTerm(new NumberTermImpl(target_x));
		target.addTerm(new NumberTermImpl(target_y));
		env.setTarget(rName, target);

	}

}
