package gwendolen.verifiableautonomoussystems.chapter5;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class Car1VerificationEnvironment extends
		VerificationofAutonomousSystemsEnvironment {

	String logname = "gwendolen.verifiableautonomoussystems.chapter5.Car1VerificationEnvironment";
	
	@Override
	public Set<Predicate> generate_sharedbeliefs() {
		Set<Predicate> beliefs = new HashSet<Predicate>();
		
		boolean at_speed_limit = random_bool_generator.nextBoolean();
		boolean started = random_bool_generator.nextBoolean();
		if (at_speed_limit) {
			beliefs.add(new Predicate("at_speed_limit"));
			AJPFLogger.info(logname, "At Speed Limit");
		}
		
		if (started) {
			beliefs.add(new Predicate("started"));
			AJPFLogger.info(logname, "Started");
		}
		return beliefs;
	}

	@Override
	public Set<Message> generate_messages() {
		return new HashSet<Message>();
	}

}
