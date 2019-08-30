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
package ethical_gwen.semantics;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.Action;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Predicate;
import ail.syntax.ListTermImpl;
import ail.syntax.ApplicablePlan;
import ail.syntax.Unifier;
import ail.syntax.annotation.SourceAnnotation;
import ail.syntax.BeliefBase;
import ail.syntax.Literal;

import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ethical_gwen.semantics.EthicalGwendolenAgent;
import ethical_gwen.syntax.Ethic;

public class EthicsQuickTests {
	
	@Test public void ethicalSectionTest() {
		Event e = new Event(Event.AILAddition, new Goal("some_event"));
		
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		deeds.add(new Deed(new Action("some_action")));
		ArrayList<Guard> guards = new ArrayList<Guard>();
		guards.add(new Guard());
		ArrayList<Deed> prefix = new ArrayList<Deed>();
		prefix.add(new Deed(Deed.Dnpy));
		
		Plan p1 = new Plan(e, prefix, guards, deeds);
		ListTermImpl ethics1 = new ListTermImpl();
		ethics1.add(new Predicate("rank1"));
		ethics1.add(new Predicate("rank3"));
		p1.setAnnotation(new EthicsAnnotation(ethics1));
		
		ArrayList<Deed> deeds1 = new ArrayList<Deed>();
		deeds1.add(new Deed(new Action("some_other_action")));
		ArrayList<Guard> guards1 = new ArrayList<Guard>();
		guards1.add(new Guard());
		ArrayList<Deed> prefix1 = new ArrayList<Deed>();
		prefix1.add(new Deed(Deed.Dnpy));
		
		Plan p2 = new Plan(e, prefix1, guards1, deeds1);
		ListTermImpl ethics2 = new ListTermImpl();
		ethics2.add(new Predicate("rank2"));
		p2.setAnnotation(new EthicsAnnotation(ethics2));
		
		Ethic ethic1 = new Ethic(new Predicate("context"), new Predicate("rank1"), 1);
		Ethic ethic2 = new Ethic(new Predicate("context"), new Predicate("rank2"), 2);
		Ethic ethic3 = new Ethic(new Predicate("context"), new Predicate("rank3"), 3);
		
		try {
			EthicalGwendolenAgent a = new EthicalGwendolenAgent("ethel");
			a.addEthic(ethic1);
			a.addEthic(ethic2);
			a.addEthic(ethic3);
			a.addPlan(p1);
			a.addPlan(p2);
			a.addBel(new Literal("context"), BeliefBase.TSelf);
			ApplicablePlan ap1 = new ApplicablePlan(p1.getTriggerEvent(), p1.getBody(), p1.getContext(), 1, new Unifier(), p1.getID(), p1.getLibID(), a.getPrettyPrinter());
			ApplicablePlan ap2 = new ApplicablePlan(p2.getTriggerEvent(), p2.getBody(), p2.getContext(), 1, new Unifier(), p2.getID(), p2.getLibID(), a.getPrettyPrinter());
			
			Assert.assertFalse(a.compareEthics(ap1, ap2));
			
		} catch (Exception ex) {
			
		}

	}

}
