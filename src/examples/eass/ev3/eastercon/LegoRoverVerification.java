package eass.ev3.eastercon;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;

public class LegoRoverVerification extends EASSVerificationEnvironment {

	@Override
	public Set<Predicate> generate_sharedbeliefs() {
		Set<Predicate> shared_beliefs = new HashSet<Predicate>();
		boolean click = random_generator.nextBoolean();
		if (click) {
			System.err.println("click");
			shared_beliefs.add(new Predicate("click"));
		} else {
			System.err.println("no click");
		}
		
		boolean obstacle = random_generator.nextBoolean();
		if (obstacle) {
			System.err.println("obstacle");
			shared_beliefs.add(new Predicate("obstacle"));
		} else {
			System.err.println("no obstacle");
		}
		
		
		// TODO Auto-generated method stub
		return shared_beliefs;
	}

	@Override
	public Set<Message> generate_messages() {
		// TODO Auto-generated method stub
		return new HashSet<Message>();
	}

}
