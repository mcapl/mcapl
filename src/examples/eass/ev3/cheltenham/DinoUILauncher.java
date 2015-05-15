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

import javax.swing.UIManager;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;

/**
 * A launcher class for the Lego Robot Dinosaurs demonstration for Cheltenham Science Festival 2015.
 * @author lad
 *
 */
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

    	
        DinoUI ui = new DinoUI();

        AILConfig config = new AILConfig(ui.getProgramFileName());
		AIL.configureLogging(config);
	
		MAS mas = AIL.AILSetup(config);
		ui.addMas(mas);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.err.println("Final Clean up");
				mas.cleanup();
			}
		});
		
		if (!ui.getEnv().error) {
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
