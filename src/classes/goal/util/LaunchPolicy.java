// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.util;

import java.util.ArrayList;
import java.util.Arrays;

import ail.semantics.AILAgent;
import ail.util.AILConfig;
import eis.EnvironmentInterfaceStandard;

public class LaunchPolicy {
	EnvironmentInterfaceStandard eis;
	ArrayList<String> entities = new ArrayList<String>();
	ArrayList<String> eis_entities = new ArrayList<String>();
	
	public LaunchPolicy(EnvironmentInterfaceStandard e) {
		eis = e;
	}
	
	public void setAssociateEntityLaunch(String agName) {
		entities.add(agName);
	}
	
	public void handleNewEntity(String arg0) {
		eis_entities.add(arg0);

	}
	
	public void configure(AILConfig config) {
		if (config.containsKey("goal.launchpolicy.entity.launch")) {
			String entitylist = config.getProperty("goal.launchpolicy.entity.launch");
			String[] entity_array = entitylist.split(",");
			for (String s: Arrays.asList(entity_array)) {
				setAssociateEntityLaunch(s);
			}
		}

	}

	public void associateEntities() {
		if (!entities.isEmpty()) {
			for (String entity_name: eis_entities) {
				for (String agName: entities) {
					try {
						eis.associateEntity(agName, entity_name);
					} catch (Exception e) {
						System.err.println(e);
					}
				}

			}
		}		// TODO Auto-generated method stub
		
	}
}
