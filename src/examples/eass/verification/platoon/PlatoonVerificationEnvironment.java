package eass.verification.platoon;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;

import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;
import gov.nasa.jpf.annotation.FilterField;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ail.syntax.Message;

public class PlatoonVerificationEnvironment extends EASSVerificationEnvironment {
			
	public String logname = "eass.platooning.PlatoonVerificationEnvironment";
	@FilterField
	boolean assert_set_spacing_goal_once= false;
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

		int assert_join = random_generator.nextInt(3);
		if(assert_join == 0){
			percepts.add(new Predicate("ready_to_join"));
			AJPFLogger.info(logname, "assert ready_to_join");
		}else if (assert_join == 1) {
			percepts.add(new Predicate("ready_to_leave"));
			AJPFLogger.info(logname, "assert ready_to_leave");
		}else{
				AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_jion");
		}

		
		boolean assert_change_lane = true;
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

		
		//boolean assert_spacing_x = random_generator.nextBoolean();

		// Having both spacing and spacing(17) seems redundant.  Keeping just spacing.
		/* if(assert_spacing_x){
			Predicate spacing_x = new Predicate("spacing");
			spacing_x.addTerm(new NumberTermImpl(17));
			percepts.add(spacing_x);
			AJPFLogger.info(logname, "assert_spacing_x");
		}else{
			AJPFLogger.info(logname, "Not assert_spacing_x");
		} */
		
		/*
		boolean assert_spacing = random_generator.nextBoolean();
		if(assert_spacing){
			percepts.add(new Literal("spacing"));
			AJPFLogger.info(logname, "assert_spacing");
		}else{
			AJPFLogger.info(logname, "No assert_spacing");
		}
		*/

		
		
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages() {
		TreeSet<Message> messages = new TreeSet<Message>();

		if(assert_set_spacing_goal_once){ 
			boolean assert_set_spacing_goal = random_generator.nextBoolean();
			if(assert_set_spacing_goal){
				Predicate set_spacing_goal = new Predicate("set_spacing");
				set_spacing_goal.addTerm(new NumberTermImpl(17));
				messages.add(new Message(EASSAgent.ACHIEVE, "leader", "follower3", set_spacing_goal));
				AJPFLogger.info(logname, "assert_set_spacing_goal");
				assert_set_spacing_goal_once=false;
			} else {
				AJPFLogger.info(logname, "Not assert_set_spacing_goal");				
			}
		}
		

		/*int assert_join_agreement = random_generator.nextInt(3);
		if (assert_join_agreement == 0) {
			Predicate join_agreement = new Predicate("join_agreement");
			join_agreement.addTerm(new Literal("follower3"));
			join_agreement.addTerm(new Literal("follower1"));
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", join_agreement));
			AJPFLogger.info(logname, "assert_join_agreement");
		} else if (assert_join_agreement == 1) {
			Predicate leave_agreement = new Predicate("leave_agreement");
			leave_agreement.addTerm(new Literal("follower3"));
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", leave_agreement));
			AJPFLogger.info(logname, "assert_leave_agreement");
		} else {
			AJPFLogger.info(logname, "Not assert join_agreement or leave_agreement");
		} */
		
		int assert_platoon_m = random_generator.nextInt(3);
		if (assert_platoon_m == 0) {
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", new Predicate("platoon_m")));
			AJPFLogger.info(logname, "assert_platoon_m");
		} else if (assert_platoon_m == 1){
			messages.add(new Message(EASSAgent.TELL, "leader", "follower3", new Predicate("no_platoon_m")));
			AJPFLogger.info(logname, "assert_no_platoon_m");
		} else {
			AJPFLogger.info(logname, "Not assert platoon_m or no_platoon_m");
		} 

		
		return messages;
	};

	
}
