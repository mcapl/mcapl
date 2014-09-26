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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ethical_governor.human_hole;

import java.util.ArrayList;
import java.util.Iterator;

import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ethical_governor.mas.DefaultEthicalGovernorEnv;
import ethical_governor.semantics.EthicalGovernor;
import actiononly.mas.ActionOnlyEnv;

public class HumanHoleEnv extends DefaultEthicalGovernorEnv implements ActionOnlyEnv {
	int numberofhumans = 2;
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("ahead")) {
			System.err.println("Robot Falls in Hole");
			if (numberofhumans > 0) {
				System.err.println("Left Human Falls in Hole");
				if (numberofhumans > 1) {
					System.err.println("Right Human Falls in Hole");
				}
			} 
		} else if (act.getFunctor().equals("ahead_right")) {
			if (numberofhumans > 0) {
				if (numberofhumans > 1) {
					System.err.println("Collision with Right Human");
				}
				System.err.println("Left Human Falls in Hole");
			}
		} else if (act.getFunctor().equals("ahead_left")) {
			if (numberofhumans > 0) {
				if (numberofhumans > 1) {
					System.err.println("Right Human Falls in Hole");
				}
				System.err.println("Collision with Left Human");
			}
		} else {
			if (numberofhumans > 0) {
				System.err.println("Left Human Falls in Hole");
				if (numberofhumans > 1) {
					System.err.println("Right Human Falls in Hole");
				}
			} 
		}
		
		super.stopagents();
		
		return new Unifier();
	}

	/*
	 * (non-Javadoc)
	 * @see actiononly.mas.ActionOnlyEnv#selectAction(java.util.Iterator)
	 */
	public Action selectAction(Iterator<Capability> ic, String agName) {
		EthicalGovernor eg = getGovernorFor(agName);
		return eg.govern(ic).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see ethical_governor.mas.EthicalGovernorEnv#model(ail.syntax.Action, java.lang.String)
	 */
	public ArrayList<Predicate> model(Action act, String agName) {
		ArrayList<Predicate> outcomes = new ArrayList<Predicate>();
		Predicate safe_robot = new Predicate("robot");
		safe_robot.addTerm(new Predicate("safe"));
		Predicate safe_human = new Predicate("human");
		safe_human.addTerm(new Predicate("safe"));
		Predicate collision_robot = new Predicate("robot");
		collision_robot.addTerm(new Predicate("collision"));
		Predicate collision_human = new Predicate("human");
		collision_human.addTerm(new Predicate("collision"));
		Predicate hole_robot = new Predicate("robot");
		hole_robot.addTerm(new Predicate("hole"));
		Predicate hole_human = new Predicate("human");
		hole_human.addTerm(new Predicate("hole"));
		
		if (act.getFunctor().equals("ahead")) {
			outcomes.add(hole_robot);
			if (numberofhumans > 0) {
				outcomes.add(hole_human);
			} 
		} else if (act.getFunctor().equals("ahead_right")) {
			if (numberofhumans > 0) {
				if (numberofhumans > 1) {
					outcomes.add(collision_human);
					outcomes.add(collision_robot);
				} 
				outcomes.add(hole_human);
			} else {
				outcomes.add(safe_robot);
			}
		} else if (act.getFunctor().equals("ahead_left")) {
			if (numberofhumans > 0) {
				if (numberofhumans > 1) {
					outcomes.add(hole_human);
				}
				outcomes.add(collision_human);
				outcomes.add(collision_robot);
			} else {
				outcomes.add(safe_robot);
			}
		} else {
			if (numberofhumans > 0) {
				outcomes.add(hole_human);
			} 
			outcomes.add(safe_robot);
		}
		
		return outcomes;

	}

}
