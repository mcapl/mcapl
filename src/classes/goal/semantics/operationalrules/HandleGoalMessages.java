// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.semantics.OSRule;
import ail.syntax.Literal;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ail.syntax.annotation.SourceAnnotation;

import goal.syntax.GoalMessage;
import goal.mas.GoalEnvironment;
import goal.semantics.GOALAgent;
import goal.syntax.ActionRule;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * A Rule that converts the agent's inbox into intentions.
 * 
 * @author lad
 *
 */
public class HandleGoalMessages implements OSRule {
	@FilterField
	private static final String name = "Handle Goal Messages";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		GOALAgent ga = (GOALAgent) a;
		List<Message> msgs = a.getInbox();
		for (Message m: msgs) {
			GoalMessage gm = (GoalMessage) m;
			if (gm.getIlForce() == GoalEnvironment.Imperative) {
				ga.delBel((Literal) gm.getPropCont(), gm.getSender());
				ga.addGoal(gm.getPropCont(), new StringTermImpl(gm.getSender()));
			} else if (gm.getIlForce() == GoalEnvironment.Interrogative) {
				ga.delBel((Literal) gm.getPropCont(), gm.getSender());
				Literal negc = (Literal) gm.getPropCont();
				if (negc.negated()) {
					negc.setNegated(true);
				} else {
					negc.setNegated(false);
				}
				ga.delBel(negc, gm.getSender());
			} else if (gm.getIlForce() == GoalEnvironment.Declarative) {
				ga.addBel((Literal) gm.getPropCont(), new Predicate(gm.getSender()), gm.getSender());
				// System.err.println(ga.toString());
			} else if (gm.getIlForce() == GoalEnvironment.InformPlan) {
				try {
					ga.addPlan(new ActionRule((Literal) gm.getPropCont()), new SourceAnnotation(new Predicate(gm.getSender())));
				} catch (Exception e) {
					System.err.println("failed to add plan" + gm.getPropCont());
				}
			} else if (gm.getIlForce() == GoalEnvironment.InformConstraint) {
				try {
					//THIS NEEDS TO BE SORTED OUT
//					ga.addConstraint(new Constraint((Literal) gm.getPropCont()), new SourceAnnotation(new Predicate(gm.getSender())));
				} catch (Exception e) {
					System.err.println("failed to add constraint" + gm.getPropCont());
				}
			}
		}
	
		a.clearInbox();
	}

}