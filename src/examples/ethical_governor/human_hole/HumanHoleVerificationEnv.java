// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the DEG; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ethical_governor.human_hole;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Capability;
import ail.syntax.GBelief;

import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;

import ethical_governor.mas.DefaultEthicalGovernorEnv;
import ethical_governor.semantics.EthicalGovernor;
import java.util.Random;

/**
 * An environment for verifying an ethical governor trying to keep humans out of holes.
 * @author lad
 *
 */
public class HumanHoleVerificationEnv extends DefaultEthicalGovernorEnv implements MCAPLJobber {
	static String logname = "ethical_governor.human_hole.HumanHoleVerificationEnv";
	
	Random r = new Random();
	
	boolean done = false;
	
	// Four abstract actions.
	static Capability action1 = new Capability(new GBelief(), new Action("action1"), new GBelief());
	static Capability action2 = new Capability(new GBelief(), new Action("action2"), new GBelief());
	static Capability action3 = new Capability(new GBelief(), new Action("action3"), new GBelief());
	static Capability action4 = new Capability(new GBelief(), new Action("action4"), new GBelief());
	static ArrayList<Capability> actions = new ArrayList<Capability>();
	static {actions.add(action1);
		actions.add(action2);
		actions.add(action3);
		actions.add(action4);
	}
	
	// Four possible outcomes.
	static Predicate outcome1 = new Predicate("human");
	static {
		outcome1.addTerm(new Predicate("hole"));
	}
	static Predicate outcome2 = new Predicate("robot");
	static {
		outcome2.addTerm(new Predicate("hole"));
	}
	static Predicate outcome3 = new Predicate("human");
	static {
		outcome3.addTerm(new Predicate("collision"));
	}
	static Predicate outcome4 = new Predicate("robot");
	static {
		outcome4.addTerm(new Predicate("collision"));
	}


	/**
	 * Randomly assign outcomes to actions.
	 */
	public ArrayList<Predicate> model(Action act, String agName) {
		ArrayList<Predicate> outcomes = new ArrayList<Predicate>();
		
		if (r.nextBoolean()) {
			outcomes.add(outcome1);
			AJPFLogger.info(logname, "Human in Hole with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome2);
			AJPFLogger.info(logname, "Robot in Hole with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome3);
			AJPFLogger.info(logname, "Human Collision with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome4);
			AJPFLogger.info(logname, "Robot Collision with " + act);
		}
		
		return outcomes;
	}

	/**
	 * Add an ethical governor for some particular agent to the environment.
	 * @param name
	 * @param foragent
	 */
	public void addEthicalGovernor(String name, String foragent) {
	}
	
	/**
	 * Return the governor for some agent.
	 * @param agName
	 * @return
	 */
	public EthicalGovernor getGovernorFor(String agName) {
		return (EthicalGovernor) agentmap.get(agName);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLJobber o) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	public void do_job() {
		for (String egName: agentmap.keySet()) {
			EthicalGovernor eg = (EthicalGovernor) agentmap.get(egName);
			eg.govern(actions.iterator());
		}
		
		getScheduler().notActive(this.getName());
		done = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#done()
	 */
	public boolean done() {
		return done;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return "Human Hole Verification Environment";
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#init_before_adding_agents()
	 */
	@Override
	public void init_before_adding_agents() {
		super.init_before_adding_agents();
		getScheduler().addJobber(this);
	}

}
