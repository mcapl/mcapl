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
package ethical_gwen.mas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import ail.mas.MAS;
import ajpf.util.choice.UniformBoolChoice;
import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Guard;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Plan;
import ail.syntax.PlanLibrary;
import ail.syntax.Predicate;

public class DefaultEthicalVerificationEnvironment extends DefaultEnvironment
		implements DefaultEthicalEnvironment {
	
	String action = "someaction";
	public UniformBoolChoice random_bool_generator;

	public DefaultEthicalVerificationEnvironment(String actionname) {
		super();
		action = actionname;
	}

	public List<Set<Predicate>> calculate_sideeffects(ListTerm policy) {
		List<Set<Predicate>> actions = subsets_of(policy);
		return actions;
	}
	
	private List<Set<Predicate>> subsets_of(ListTerm policy) {
		if (policy.isEmpty()) {
			Set<Predicate> empty = Collections.<Predicate>emptySet();
			List<Set<Predicate>> containsempty = new ArrayList<Set<Predicate>>();
			containsempty.add(empty);
			return containsempty;
		} else {
			List<Set<Predicate>> tailsets = subsets_of(policy.getTail());
			List<Set<Predicate>> out = new ArrayList<Set<Predicate>>();
			for (Set<Predicate> set:tailsets) {
				HashSet<Predicate> setclone = new HashSet<Predicate>(set);
				setclone.add((Predicate) policy.getHead());
				out.add(setclone);
			}
			out.addAll(tailsets);
			return out;
		}
	}
	
	public Plan plan_from_side_effects(Event e, Set<Predicate> ses) {
		Action a = new Action(action);
		ListTermImpl l = new ListTermImpl();
		for (Predicate p: ses) {
			a.addTerm(p);
			l.add(p);
		}
		
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		deeds.add(new Deed(a));
		ArrayList<Guard> guards = new ArrayList<Guard>();
		guards.add(new Guard());
		ArrayList<Deed> prefix = new ArrayList<Deed>();
		prefix.add(new Deed(Deed.Dnpy));
		
		Plan p = new Plan(e, prefix, guards, deeds);
		
		if (! ses.isEmpty()) {
			p.setAnnotation(new EthicsAnnotation(l));
			// System.err.println(p);
		}
		
		return p;
	}

	public PlanLibrary invokeEthicalPlanner(Event e, ListTerm policy) {
		List<Set<Predicate>> side_effects = calculate_sideeffects(policy);
		List<Plan> plans = new ArrayList<Plan>();
		
		for (Set<Predicate> se: side_effects) {
			Plan plan = plan_from_side_effects(e, se);
			plans.add(plan);
		}
		
		PlanLibrary pl = new PlanLibrary();

		for (int i = 0; i < plans.size(); i++) {
			if (random_bool_generator.nextBoolean()) {
				pl.add(plans.get(i));
			}
		}
		
		if (pl.getPlans().isEmpty()) {
			Action a = new Action(action);
			ArrayList<Deed> deeds = new ArrayList<Deed>();
			deeds.add(new Deed(a));
			ArrayList<Guard> guards = new ArrayList<Guard>();
			guards.add(new Guard());
			ArrayList<Deed> prefix = new ArrayList<Deed>();
			prefix.add(new Deed(Deed.Dnpy));
			
			Plan p = new Plan(e, prefix, guards, deeds);
			pl.add(p);
		}

		return pl;
	}


	public void setMAS(MAS m) {
		super.setMAS(m);
		random_bool_generator = new UniformBoolChoice(m.getController());
	}

}
