package ethical_gwen.mas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

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
	Random r = new Random();
	
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
			if (r.nextBoolean()) {
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

}
