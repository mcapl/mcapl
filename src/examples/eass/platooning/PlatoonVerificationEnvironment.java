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

		Predicate name_front = new Predicate("name_front");
		name_front.addTerm(new Literal("follower1"));
		percepts.add(name_front);
		AJPFLogger.info(logname, "name_front_follower1");
		
		percepts.add(new Predicate("ready_to_join"));
		AJPFLogger.info(logname, "ready_to_join");

		
		boolean assert_change_lane = random_generator.nextBoolean();
		if(assert_change_lane){
			percepts.add(new Literal("changed_lane"));
			AJPFLogger.info(logname, "assert_changed_lane");
		}else{
			AJPFLogger.info(logname, "No assert_changed_lane");
		}

		boolean assert_init_dis = random_generator.nextBoolean();
		if(assert_init_dis){
			percepts.add(new Literal("initial_distance"));
			AJPFLogger.info(logname, "assert_initial_distance");
		}else{
			AJPFLogger.info(logname, "No assert_initial_distance");
		}

		boolean assert_spacing = random_generator.nextBoolean();
		if(assert_spacing){
			percepts.add(new Literal("spacing"));
			AJPFLogger.info(logname, "assert_spacing");
		}else{
			AJPFLogger.info(logname, "No assert_spacing");
		}

		
		
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages() {
		TreeSet<Message> messages = new TreeSet<Message>();
		
//		boolean assert_join_agreement = random_generator.nextBoolean();
//		if (assert_join_agreement) {
			Predicate join_agreement = new Predicate("join_agreement");
			join_agreement.addTerm(new Literal("follower3"));
			join_agreement.addTerm(new Literal("follower1"));
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", join_agreement));
			assert_join= false;
			AJPFLogger.info(logname, "assert_join_agreement");
//		} else {
//			AJPFLogger.info(logname, "Not assert_join_agreement");
//		}

		
		boolean assert_platoon_m = random_generator.nextBoolean();
		if (assert_platoon_m) {
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", new Predicate("platoon_m")));
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
