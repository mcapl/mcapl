package eass.compositional.rescue;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;

public class GoalReasonerVerificationEnvironment extends EASSVerificationEnvironment {

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		percepts.add(new Literal("new_goal"));
		boolean need_recharge = random_bool_generator.nextBoolean();
		
		if (need_recharge) {
			System.out.println("needs recharging");
			percepts.add(new Literal("recharge"));
		} else {
			System.out.println("Doesn't");
		}
		
		return percepts;
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		return new TreeSet<Message>();
	}

}
