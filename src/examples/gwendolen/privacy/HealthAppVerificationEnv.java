package gwendolen.privacy;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class HealthAppVerificationEnv extends VerificationofAutonomousSystemsEnvironment {
	boolean all_beliefs_shared = false;

	@Override
	public Set<Predicate> generate_percepts() {
		// TODO Auto-generated method stub
		return new HashSet<Predicate>();
	}

	@Override
	public Set<Message> generate_messages() {
		// TODO Auto-generated method stub
		Set<Message> messages = new HashSet<Message>();
		
		if (!all_beliefs_shared) {
			// belief(workout_plan(present))
			// belief(diet_recommendations(present))
			// belief(daily_physical_activities(monitored))
			
			boolean workout_plan_present = random_bool_generator.nextBoolean();
			boolean diet_recommendations_present = random_bool_generator.nextBoolean();
			boolean daily_physical_activities_monitored = random_bool_generator.nextBoolean();
			if (workout_plan_present) {
				Predicate workout_plan = new Predicate("workout_plan");
				workout_plan.addTerm(new Predicate("present"));
				messages.add(new Message(1, "user", "agent", workout_plan));
			}
			

			if (diet_recommendations_present) {
				Predicate diet_recommendations = new Predicate("diet_recommendations");
				diet_recommendations.addTerm(new Predicate("present"));
				messages.add(new Message(1, "user", "agent", diet_recommendations));
			}
			
			if (daily_physical_activities_monitored) {
				Predicate daily_physical_activities = new Predicate("daily_physical_activities");
				daily_physical_activities.addTerm(new Predicate("monitored"));
				messages.add(new Message(1, "user", "agent", daily_physical_activities));
			}


			boolean full_name_requested = random_bool_generator.nextBoolean();
			boolean dob_requested = random_bool_generator.nextBoolean();
			boolean gender_requested = random_bool_generator.nextBoolean();
			boolean bmi_requested = random_bool_generator.nextBoolean();
			boolean contact_requested = random_bool_generator.nextBoolean();
			boolean home_address_requested = random_bool_generator.nextBoolean();
			boolean marital_status_requested = random_bool_generator.nextBoolean();
			boolean occupation_requested = random_bool_generator.nextBoolean();
			boolean education_requested = random_bool_generator.nextBoolean();
			boolean gps_requested = random_bool_generator.nextBoolean();
			boolean social_media_requested = random_bool_generator.nextBoolean();
			all_beliefs_shared = true;
			//data(full_name)
			//data(dob)
			//data(gender)
			//data(bmi)
			//data(contact)
			//data(home_address)
			//data(marital_status)
			//data(occupation)
			//data(education)
			//data(gps)
			//data(social_media)
			if (full_name_requested) {
				Predicate full_name = new Predicate("data");
				full_name.addTerm(new Predicate("full_name"));
				messages.add(new Message(1, "user", "agent", full_name));
			}
			
			if (dob_requested) {
				Predicate dob = new Predicate("data");
				dob.addTerm(new Predicate("dob"));
				messages.add(new Message(1, "user", "agent", dob));
			}
			
			if (gender_requested) {
				Predicate gender = new Predicate("data");
				gender.addTerm(new Predicate("gender"));
				messages.add(new Message(1, "user", "agent", gender));
			}
			
			if (bmi_requested) {
				Predicate bmi = new Predicate("data");
				bmi.addTerm(new Predicate("bmi"));
				messages.add(new Message(1, "user", "agent", bmi));
			}
			
			if (contact_requested) {
				Predicate contact = new Predicate("data");
				contact.addTerm(new Predicate("contact"));
				messages.add(new Message(1, "user", "agent", contact));
			}
			
			if (home_address_requested) {
				Predicate home_address = new Predicate("data");
				home_address.addTerm(new Predicate("home_address"));
				messages.add(new Message(1, "user", "agent", home_address));
			}
			
			if (marital_status_requested) {
				Predicate marital_status = new Predicate("data");
				marital_status.addTerm(new Predicate("marital_status"));
				messages.add(new Message(1, "user", "agent", marital_status));
			}
			
			if (occupation_requested) {
				Predicate occupation = new Predicate("data");
				occupation.addTerm(new Predicate("occupation"));
				messages.add(new Message(1, "user", "agent", occupation));
			}
			
			if (education_requested) {
				Predicate education = new Predicate("data");
				education.addTerm(new Predicate("education"));
				messages.add(new Message(1, "user", "agent", education));
			}
			
			if (gps_requested) {
				Predicate gps = new Predicate("data");
				gps.addTerm(new Predicate("gps"));
				messages.add(new Message(1, "user", "agent", gps));
			}
			
			if (social_media_requested) {
				Predicate social_media = new Predicate("data");
				social_media.addTerm(new Predicate("social_media"));
				messages.add(new Message(1, "user", "agent", social_media));
			}
			
			if (all_beliefs_shared) {
				Predicate all_beliefs = new Predicate("all_beliefs_shared");
				messages.add(new Message(1, "user", "agent", all_beliefs));
			}
		}
		
		
		return messages;

	}

}
