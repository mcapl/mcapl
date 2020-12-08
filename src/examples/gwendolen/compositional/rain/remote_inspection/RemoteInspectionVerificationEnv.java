package gwendolen.compositional.rain.remote_inspection;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class RemoteInspectionVerificationEnv extends VerificationofAutonomousSystemsEnvironment {

	@Override
	public Set<Predicate> generate_percepts() {
		Set<Predicate> beliefs = new HashSet<Predicate>();
		
		boolean reached_location = random_bool_generator.nextBoolean();
		int radiation = random_int_generator.nextInt(2);
		
		if (reached_location) {
			Predicate movebase_result = new Predicate("movebase_result");
			movebase_result.addTerm(new Predicate("seg"));
			movebase_result.addTerm(new NumberTermImpl(3));
			
			beliefs.add(movebase_result);
		}
		
		if (radiation == 0) {
			beliefs.add(new Predicate("danger_red"));
		}  else if (radiation == 1){
			beliefs.add(new Predicate("danger_orange"));
		}	
		
		return beliefs;

	}

	@Override
	public Set<Message> generate_messages() {
		return new HashSet<Message>();
	}

}
