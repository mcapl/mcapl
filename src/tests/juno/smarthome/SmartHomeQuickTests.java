// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package juno.smarthome;

import org.junit.Test;

import ail.util.AJPF_w_AIL;

public class SmartHomeQuickTests {
	
	@Test public void utilitariantest() {
		String file = "/src/examples/juno/smarthome/lights_and_fire.ail";
    	String prop_filename =  "/src/examples/juno/smarthome/fire_and_games.psl";
    	String[] args = new String[3];
    	args[0] = file;
    	args[1] = prop_filename;
    	args[2] = "sanity";
    	AJPF_w_AIL.run(args);
	}

}
