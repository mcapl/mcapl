/* A smaller environment for testing - just to check the general thing isn't broken */

package gwendolen.privacy;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class HealthAppVerificationSmallEnv extends VerificationofAutonomousSystemsEnvironment {
	boolean all_beliefs_shared = false;
	boolean full_set = false;

	@Override
	public Set<Predicate> generate_percepts() {
		// TODO Auto-generated method stub
		return new HashSet<Predicate>();
	}

	@Override
	public Set<Message> generate_messages() {
		// TODO Auto-generated method stub
		Set<Message> messages = new HashSet<Message>();
		System.out.println("changing env");
		
		if (!all_beliefs_shared) {
			// belief(workout_plan(present))
			// belief(diet_recommendations(present))
			// belief(daily_physical_activities(monitored))
			
			boolean workout_plan_present = random_bool_generator.nextBoolean();
			if (workout_plan_present) {
				Predicate workout_plan = new Predicate("workout_plan");
				workout_plan.addTerm(new Predicate("present"));
				messages.add(new Message(1, "user", "agent", workout_plan));
			}
			

			boolean diet_recommendations_present = random_bool_generator.nextBoolean();
			if (diet_recommendations_present) {
				Predicate diet_recommendations = new Predicate("diet_recommendations");
				diet_recommendations.addTerm(new Predicate("present"));
				messages.add(new Message(1, "user", "agent", diet_recommendations));
			}
			
			boolean daily_physical_activities_monitored = random_bool_generator.nextBoolean();
			if (daily_physical_activities_monitored) {
				Predicate daily_physical_activities = new Predicate("daily_physical_activities");
				daily_physical_activities.addTerm(new Predicate("monitored"));
				messages.add(new Message(1, "user", "agent", daily_physical_activities));
			}

			//data(full_name)
			//data(dob) *
			//data(gender)
			//data(bmi) *
			//data(contact)
			//data(home_address)
			//data(marital_status) *
			//data(occupation) *
			//data(education) *
			//data(gps) * 
			//data(social_media)
			
			
			boolean dob_requested = random_bool_generator.nextBoolean();
			if (dob_requested) {
				Predicate dob = new Predicate("data");
				dob.addTerm(new Predicate("dob"));
				messages.add(new Message(1, "user", "agent", dob));
			}
			
			boolean gender_requested = random_bool_generator.nextBoolean();
			if (gender_requested) {
				Predicate gender = new Predicate("data");
				gender.addTerm(new Predicate("gender"));
				messages.add(new Message(1, "user", "agent", gender));
			}
			
			boolean bmi_requested = random_bool_generator.nextBoolean();
			if (bmi_requested) {
				Predicate bmi = new Predicate("data");
				bmi.addTerm(new Predicate("bmi"));
				messages.add(new Message(1, "user", "agent", bmi));
			}
			
			all_beliefs_shared = true;			
			if (all_beliefs_shared) {
				Predicate all_beliefs = new Predicate("all_beliefs_shared");
				messages.add(new Message(1, "user", "agent", all_beliefs));
			}
		}
		
		
		return messages;

	}

}
