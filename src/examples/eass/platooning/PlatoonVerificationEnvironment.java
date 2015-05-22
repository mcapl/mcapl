package eass.platooning;

import java.util.Set;
import java.util.TreeSet;

import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ajpf.util.AJPFLogger;
import ail.syntax.Message;

public class PlatoonVerificationEnvironment extends EASSVerificationEnvironment {
			
	public String logname = "eass.platooning.VerificationEnvironment";
	
	boolean assert_join= true;
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_sharedbeliefs()
	 */
	public Set<Predicate> generate_sharedbeliefs() {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		Predicate id = new Predicate("id");
		id.addTerm(new NumberTermImpl(3));
		percepts.add(id);
		AJPFLogger.info(logname, "vehicle_id");

		Predicate name = new Predicate("name");
		name.addTerm(new Literal("follower3"));
		percepts.add(name);
		AJPFLogger.info(logname, "vehicle_name");

		
		percepts.add(new Predicate("preceding_vehicle_platoon_member"));
//		percepts.add(new Predicate("no_platoon_member"));
		
		boolean assert_no_platoon_member = random_generator.nextBoolean();
		if (assert_no_platoon_member) {
			percepts.add(new Predicate("no_platoon_member"));
			AJPFLogger.info(logname, "no_platoon_member");
		} else {
			AJPFLogger.info(logname, "Not no_platoon_member");
		}
		

		boolean assert_initial_speed = random_generator.nextBoolean();
		if (assert_initial_speed) {
			percepts.add(new Predicate("initial_speed"));
			AJPFLogger.info(logname, "Asserting initial_speed");
		} else {
			AJPFLogger.info(logname, "Not initial_speed");
		}
		
		boolean assert_initial_distance = random_generator.nextBoolean();
		if (assert_initial_distance) {
			percepts.add(new Predicate("initial_distance"));
			AJPFLogger.info(logname, "Asserting initial_distance");
		} else {
			AJPFLogger.info(logname, "Not initial_distance");
		}
		
//		boolean assert_leave_distance = random_generator.nextBoolean();
//		if (assert_leave_distance) {
//			percepts.add(new Predicate("leave_distance"));
//			AJPFLogger.info(logname, "Asserting leave_distance");
//		} else {
//			AJPFLogger.info(logname, "Not leave_distance");
//		}
		
//		boolean assert_ready_to_leave = random_generator.nextBoolean();
//		if (assert_ready_to_leave) {
//			percepts.add(new Predicate("ready_to_leave"));
//			AJPFLogger.info(logname, "Asserting ready_to_leave");
//		} else {
//			AJPFLogger.info(logname, "Not ready_to_leave");
//		}
				
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages() {
		TreeSet<Message> messages = new TreeSet<Message>();
		
		boolean assert_join_agreement = random_generator.nextBoolean();
		if (assert_join_agreement) {
			Predicate join_agreement = new Predicate("join_agreement");
			join_agreement.addTerm(new Literal("follower3"));
			join_agreement.addTerm(new Literal("follower1"));
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", join_agreement));
			assert_join= false;
			AJPFLogger.info(logname, "assert_join_agreement");
		} else {
			AJPFLogger.info(logname, "Not assert_join_agreement");
		}
		
		boolean assert_leave_agreement = random_generator.nextBoolean();
		if (assert_leave_agreement) {
			Predicate leave_agreement = new Predicate("leave_agreement");
			leave_agreement.addTerm(new NumberTermImpl(3));
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", leave_agreement));
			AJPFLogger.info(logname, "assert_join_agreement");
		} else {
			AJPFLogger.info(logname, "Not assert_join_agreement");
		}
		

		return messages;
	};

	
}
