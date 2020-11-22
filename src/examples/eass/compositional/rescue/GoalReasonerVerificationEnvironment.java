package eass.compositional.rescue;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;

public class GoalReasonerVerificationEnvironment extends EASSVerificationEnvironment {
	public String logname = "eass.compositional.rescue.GoalReasonerVerificationEnvironment";

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		percepts.add(new Literal("new_goal"));
		boolean need_recharge = random_bool_generator.nextBoolean();
		
		if (need_recharge) {
			System.out.println("needs recharging");
			percepts.add(new Literal("recharge"));
		} else {
			System.out.println("Doesn't need recharging");
		}
		
		boolean heat_source1 = random_bool_generator.nextBoolean();
		if (heat_source1) {
			System.out.println("source 1");
			Literal loc22 = new Literal("location");
			loc22.addTerm(new NumberTermImpl(2));
			loc22.addTerm(new NumberTermImpl(3));
			loc22.addTerm(new NumberTermImpl(4));
			percepts.add(loc22);
		}
		
		boolean heat_source2 = random_bool_generator.nextBoolean();
		if (heat_source2) {
			System.out.println("source 2");
			Literal loc22 = new Literal("location");
			loc22.addTerm(new NumberTermImpl(3));
			loc22.addTerm(new NumberTermImpl(4));
			loc22.addTerm(new NumberTermImpl(5));
			percepts.add(loc22);
		}
		
		
		System.out.println(percepts);
		return percepts;
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		return new TreeSet<Message>();
	}

}
