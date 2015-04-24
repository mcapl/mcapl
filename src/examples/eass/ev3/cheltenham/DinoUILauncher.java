package eass.ev3.cheltenham;

import java.awt.GridBagLayout;

import javax.swing.UIManager;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import eass.mas.ev3.EASSEV3Environment;

public class DinoUILauncher {
    /**
     * Start up the whole application
     * @param args
     */
    public static void main(String[] args) {
       	try {
    		System.setProperty("apple.laf.useScreenMenuBar", "true");
    		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "LegoRobotDinosaurs");
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch (Exception e) {
    		System.err.println(e);
    	}

       	AILConfig config;
    	// By default the robot is Noor, but if a different name is supplied then this is used.
	    	
        DinoUI ui = new DinoUI();

        config = new AILConfig(ui.program);
		AIL.configureLogging(config);
	
		MAS mas = AIL.AILSetup(config);
		ui.env = (EASSEV3Environment) mas.getEnv();
		ui.addMas(mas);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.err.println("Final Clean up");
				mas.cleanup();
			}
		});
		
		if (!ui.env.error) {
		
 
        	//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					ui.createAndShowGUI();
				}}
			);

        // Lastly we construct a controller.
			MCAPLcontroller mccontrol = new MCAPLcontroller(mas, "", 1);
		// Start the system.
			mccontrol.begin(); 
		}
		mas.cleanup();
		System.err.println("leaving main");
		
    }
}
