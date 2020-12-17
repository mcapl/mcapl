package eass.compositional.rescue;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;

public class PlanReasonerVerificationEnvironment extends EASSVerificationEnvironment {
	public String logname = "eass.compositional.rescue.GoalReasonerVerificationEnvironment";
	boolean first = true;
	TreeSet<Predicate> locations = new TreeSet<Predicate>();

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean need_recharge = random_bool_generator.nextBoolean();
		
		if (need_recharge) {
			System.out.println("battery Low");
			percepts.add(new Literal("battery_low"));
		} else {
			System.out.println("Battery fine");
		}
		
		boolean target = random_bool_generator.nextBoolean();
		
		Literal current_goal = new Literal("current_goal");
		if (target) {
			current_goal.addTerm(new NumberTermImpl(1));
			current_goal.addTerm(new NumberTermImpl(1));
		} else {
			current_goal.addTerm(new NumberTermImpl(2));
			current_goal.addTerm(new NumberTermImpl(3));
		}
		percepts.add(current_goal);
		
		boolean plan1 = random_bool_generator.nextBoolean();
		boolean plan2 = random_bool_generator.nextBoolean();
		boolean plan3 = random_bool_generator.nextBoolean();
		if (plan1) {
			System.out.println("Plan 1");
			Literal p1 = new Literal("plan");
			p1.addTerm(new Predicate("p1"));
			p1.addTerm(new NumberTermImpl(30));
			percepts.add(p1);
		}
	
		if (plan2) {
			System.out.println("Plan 2");
			Literal p1 = new Literal("plan");
			p1.addTerm(new Predicate("p2"));
			p1.addTerm(new NumberTermImpl(1));
			percepts.add(p1);
		} 


		if (plan3) {
			System.out.println("Plan 3");
			Literal p1 = new Literal("plan");
			p1.addTerm(new Predicate("p3"));
			p1.addTerm(new NumberTermImpl(3));
			percepts.add(p1);
		} 

		percepts.add(new Literal("select_plan"));
		System.out.println(percepts);
		return percepts;
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();

		return messages;
	}

}
