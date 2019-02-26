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
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.VarTerm;
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
public class PrivacyEnv extends DefaultEnvironment implements MCAPLJobber {
	final static String logname = "juno.smarthome.FireEnv";
	static int Morning = 0;
	static int Afternoon = 1;
	static int Evening = 2;
	int time = Morning;
	
	/**
	 * Constructor.
	 */
	public PrivacyEnv() {
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
		if (time == Morning) {
			time = Afternoon;
			removePercept(new Predicate("morning"));
			addPercept(new Predicate("afternoon"));
			Literal sr = new Literal("set_reminder");
			sr.addTerm(new Literal("public"));
			sr.addTerm(new Literal("afternoon"));
			addPercept(sr);
			System.err.println("Afternoon");
		} else if (time == Afternoon) {
			time = Evening;
			removePercept(new Predicate("afternoon"));
			addPercept(new Predicate("evening"));		
			Literal sr = new Literal("set_reminder");
			sr.addTerm(new VarTerm("A"));
			sr.addTerm(new VarTerm("B"));
			removeUnifiesPercept(sr);
			System.err.println("Evening");
		} else {
			// Yes I know we're skipping night time.
			time = Morning;
			removePercept(new Predicate("evening"));
			addPercept(new Predicate("morning"));
			System.err.println("Morning");
			Literal sr = new Literal("set_reminder");
			sr.addTerm(new VarTerm("A"));
			sr.addTerm(new VarTerm("B"));
			removeUnifiesPercept(sr);
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
		addPercept(new Predicate("morning"));
	}

}
