// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.util;

import java.io.IOException;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.syntax.ast.GroundPredSets;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFException;
import ajpf.util.AJPFLogger;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Helper class for running an AIL based system under AJPF.  This is mostly handy for running things with configuration files.
 * @author lad
 *
 */
public class AJPF_w_AIL {
	private static String logname = "ail.util.AJPF_w_AIL";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  if (AJPFLogger.ltFine(logname)) {
			  AJPFLogger.fine(logname, "Entering Main in AJPF_w_AIL");
		  }

		// GroundPredSets.clear();
		run(args);
	}
	
	/**
	 * Run
	 * @param args
	 */
	public static void run(String[] args) {
		GroundPredSets.clear();
		// Create the configuration.
		AILConfig config = new AILConfig(args[0]);
		// Configure an AIL based MAS accordingly
		String propertystring = getProperty(args[1],args[2]);
		MCAPLcontroller mccontrol = new MCAPLcontroller(config, propertystring);
		MAS mas = AIL.AILSetup(config, mccontrol);

		mccontrol.begin();
	}
	
	/**
	 * Get a particular property from the property file.
	 * @param filename
	 * @param key
	 * @return
	 */
	public static String getProperty(String filename, String key) {
		String abs_filename = "";
		String propertystring = "";
		try {
			abs_filename = MCAPLcontroller.getFilename(filename);
		} catch (AJPFException e) {
			AJPFLogger.severe("ail.util.AJPF_w_AIL", e.getMessage());
			System.exit(1);
		}
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(abs_filename));
			String str;
			String string = "";
			while ((str = in.readLine()) != null) {
				if (! str.startsWith("#")) {
					String[] pair = str.split(":");
					if (pair[0].equals(key)) {
						string = pair[1];
						AJPFLogger.fine(logname, string);
					} else if (pair.length == 1 & string != "") {
						string += pair[0];
					} else if (string != "") {
						propertystring = string;
						string = "";
					}
				}
			}
			if (string != "") {
				propertystring = string;
			}
			in.close();
		} catch (IOException e) {
			AJPFLogger.severe("ail.util.AJPF_w_AIL", e.getMessage());
			System.exit(1);			
		}

		AJPFLogger.info(logname, propertystring);
		return propertystring;
		
		
	}

}
