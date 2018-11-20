// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ethical_gwen.semantics.operationalrules;

import java.util.ArrayList;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.ApplyApplicablePlans;
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.syntax.GBelief;
import ail.syntax.Literal;
import ail.syntax.Event;
import ail.syntax.Guard;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Deed;
import ail.syntax.Plan;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.annotation.SourceAnnotation;
import ail.syntax.StringTermImpl;
import ail.syntax.BeliefBase;

import ethical_gwen.syntax.annotation.EthicsAnnotation;


/**
 * Applying one of the applicable plans to the current intention.
 * 
 * @author lad
 *
 */
public class EthicallyApplyApplicablePlans extends ApplyApplicablePlans {
	// The name of the rule.
	private static final String name = "EthicallyApplyApplicablePlans";
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention i = a.getIntention();
		Iterator<ApplicablePlan> aps = a.getApplicablePlans();
		
		ApplicablePlan p = a.selectPlan(aps, i);
		
		ArrayList<Guard> guardstack = p.getGuard();
		
		if (p.getN() == 0 && (! (guardstack.isEmpty()) && (! (guardstack.get(guardstack.size() - 1).isTrivial())))) {
			// This plan has not been triggered by an event and so should form a new intention.
			
			Literal state_literal = new Literal("state");
			// state_literal.addTerm(guardstack.get(guardstack.size() - 1).toTerm());
			Event state = new Event(Deed.AILAddition, DefaultAILStructure.AILBel, state_literal);
			// change the head of the guardstack to trivial - we've already checked it holds
			guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));
			a.setIntention(new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone(), a.getPrettyPrinter()));
		} else {
			// This plan has been triggered by an event and should be added to the intention associated with that event.
			i.dropP(p.getN());
			
			// NOTE HACK - top of guardstack presumably already tested!
			if (! (guardstack.isEmpty()) && (! (guardstack.get(guardstack.size() - 1).isTrivial()))) {
				guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));			
			}
			
			if (p.getPrefix().size() != 0) {			
				i.iConcat(p.getEvent(), p.getPrefix(), guardstack, p.getUnifier().clone());
			} else if(! i.empty()) {
				i.hdU().compose(p.getUnifier().clone());
			}
		}
		
		// We store the ethics of the plan we chose as a belief.
		int idnum = p.getID();
		String library = p.getLib();
		Plan plan = a.getPL(library).getPlanbyID(idnum);
		if (plan != null) {
			EthicsAnnotation e = (EthicsAnnotation) plan.getAnnotation();
			a.getBB("plan_selection").clear();
			if (e != null ) {
				for (Term ethic : e.getEthics()) {
					Literal pred = new Literal("ethical_concern");
					pred.addTerm(ethic);
					a.addBel(pred, new SourceAnnotation(new Predicate("plan_selection")), "ethics");
				}
			}
		}
		Literal tried = new Literal("already_tried");
		tried.addTerm(new StringTermImpl(p.keyString()));
		a.addBel(tried, BeliefBase.TSelf);

		// To encourage state matching during model checking we clear the list of applicable plans.
		a.clearApplicablePlans();

	}
}