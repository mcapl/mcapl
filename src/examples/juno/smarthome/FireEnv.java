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

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.mas.scheduling.RoundRobinScheduler;
import ail.syntax.Predicate;
import ajpf.MCAPLJobber;

/**
 * FireEnv provides a simple environment for testing the agent described in Verifiable Machine 
 * Ethics in Changing Environments which controls access to the games console, lights and 
 * evacuation procedures.
 * 
 * FireEnv cycles through day, evening and night and at specific moments states that there
 * is a fire (the games console related actions are ignored).
 * @author louisedennis
 *
 */
public class FireEnv extends DefaultEnvironment implements MCAPLJobber {
	final static String logname = "juno.smarthome.FireEnv";
	static int DAY = 0;
	static int EVENING = 1;
	static int NIGHT = 2;
	int time = DAY;
	static int FIRE = 0;
	int fires = 0;
	
	/**
	 * Constructor.
	 */
	public FireEnv() {
		super();
		RoundRobinScheduler scheduler = new RoundRobinScheduler();
		this.setScheduler(scheduler);
		addPerceptListener(scheduler);
		
		getScheduler().addJobber(this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	@Override
	public void do_job() {
		if (time == DAY) {
			time = EVENING;
			removePercept(new Predicate("day"));
			addPercept(new Predicate("evening"));
			System.err.println("Evening");
			if (fires == 1) {
				FIRE = 0;
				removePercept(new Predicate("fire"));
				fires++;
			}
		} else if (time == EVENING) {
			time = NIGHT;
			removePercept(new Predicate("evening"));
			addPercept(new Predicate("night"));		
			System.err.println("Night");
			if (fires == 0) {
				fires = 1;
			}
			if (fires == 2) {
				FIRE = 1;
				System.err.println("Fire!");
				addPercept(new Predicate("fire"));				
			}
		} else {
			time = DAY;
			removePercept(new Predicate("night"));
			addPercept(new Predicate("day"));
			System.err.println("Day");
			if (fires == 1) {
				FIRE = 1;
				System.err.println("Fire!");
				addPercept(new Predicate("fire"));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	@Override
	public String getName() {
		return logname;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		addPercept(new Predicate("day"));
	}

}
