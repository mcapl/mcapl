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
package goal.programming_guide.chapter6;

import ail.util.AILConfig;
import eis.iilang.Identifier;
import goal.mas.GOALEISEnvironment;

public class BlocksWorldEnvironment extends GOALEISEnvironment {
	
	public BlocksWorldEnvironment() {
		super("/lib/eis/blocksworld-1.3.0.jar");
	}
	
	@Override
	public void configure(AILConfig config) {
		if (config.containsKey("goal.env.init.start")) {
			String filename = config.getProperty("config_path") + "/" + config.getProperty("goal.env.init.start");
			addFileToInitMap("start", filename);
		}
		
		if (config.containsKey("goal.env.init.gui")) {
			Identifier value = new Identifier("true");
			if (config.getProperty("goal.env.init.gui").equals("false")) {
				value = new Identifier("false");
			}
			addToInitMap("gui", value);
		}

		super.configure(config);
	}
	
	
	@Override
	public boolean done() {
		return true;
	}


}
