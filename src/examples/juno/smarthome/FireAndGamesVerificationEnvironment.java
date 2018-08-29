package juno.smarthome;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import eass.mas.verification.EASSVerificationEnvironment;

public class FireAndGamesVerificationEnvironment extends EASSVerificationEnvironment {
	public String logname = "juno.smarthome.FireAndGamesVerificationEnvironment";

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		Set<Predicate> predicates = new TreeSet<Predicate>();
		int time_of_day = random_int_generator.nextInt(3);
		if  (time_of_day == 0) {
			predicates.add(new Predicate("day"));
			AJPFLogger.info(logname, "Daytime");
		} else if (time_of_day == 1) {
			predicates.add(new Predicate("evening"));
			AJPFLogger.info(logname, "Evening");
		} else {
			predicates.add(new Predicate("night"));
			AJPFLogger.info(logname, "Night");
		}
		
		int  fire = random_int_generator.nextInt(2);
		if (fire == 0) {
			predicates.add(new Predicate("fire"));
			AJPFLogger.info(logname, "Fire!");
		}
		
		int noisy = random_int_generator.nextInt(2);
		if (noisy == 0) {
			predicates.add(new Predicate("children_noisy"));
			AJPFLogger.info(logname, "Children Noisy");
		}
		
		int mum_goal = random_int_generator.nextInt(3);
		if (mum_goal == 0) {
			predicates.add(new Predicate("mum_working"));
			AJPFLogger.info(logname, "Mum wants to work");
		} else if (mum_goal == 1) {
			predicates.add(new Predicate("mum_wrapping_presents"));
			AJPFLogger.info(logname, "Mum wrapping presents");
		}
		
		AJPFLogger.info(logname, "Predicates: " + predicates);
		return predicates;
		
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		return messages;
	}

}
