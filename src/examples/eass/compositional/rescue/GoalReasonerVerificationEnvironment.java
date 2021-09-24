package eass.compositional.rescue;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;

public class GoalReasonerVerificationEnvironment extends EASSVerificationEnvironment {
	public String logname = "eass.compositional.rescue.GoalReasonerVerificationEnvironment";
	boolean first = true;
	TreeSet<Predicate> locations = new TreeSet<Predicate>();

	@Override
	public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean need_recharge = random_bool_generator.nextBoolean();
		
		if (need_recharge) {
			System.out.println("needs recharging");
			percepts.add(new Literal("recharge"));
		} else {
			System.out.println("Doesn't need recharging");
		}
		
		
		boolean moved = random_bool_generator.nextBoolean();
		if (moved) {
			int init_pos = random_int_generator.nextInt(3);
			Literal init = new Literal("init_pos");
			if (init_pos == 1) {
				System.out.println("init 1");
				init.addTerm(new NumberTermImpl(2));
				init.addTerm(new NumberTermImpl(3));
			} else if (init_pos == 2) {
				System.out.println("init 2");
	
				init.addTerm(new NumberTermImpl(3));
				init.addTerm(new NumberTermImpl(4));
			} else {
				System.out.println("init 3");
	
				init.addTerm(new NumberTermImpl(1));
				init.addTerm(new NumberTermImpl(1));
			}
			percepts.add(init);
			percepts.add(new Literal("atGoal"));
			percepts.add(new Literal("new_goal"));

		}
		
		
		System.out.println(percepts);
		return percepts;
	}

	@Override
	public Set<Message> generate_messages(String agName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		
		
		if (first) {
			boolean heat_source1 = random_bool_generator.nextBoolean();
			if (heat_source1) {
				System.out.println("source 1");
				Literal loc22 = new Literal("location");
				loc22.addTerm(new NumberTermImpl(2));
				loc22.addTerm(new NumberTermImpl(3));
				loc22.addTerm(new NumberTermImpl(4));
				messages.add(new Message(EASSAgent.TELL, "vision", "goalreas", loc22));
			}
			
			boolean heat_source2 = random_bool_generator.nextBoolean();
			if (heat_source2) {
				System.out.println("source 2");
				Literal loc22 = new Literal("location");
				loc22.addTerm(new NumberTermImpl(3));
				loc22.addTerm(new NumberTermImpl(4));
				loc22.addTerm(new NumberTermImpl(5));
				messages.add(new Message(EASSAgent.TELL, "vision", "goalreas", loc22));
			}
			
			Literal cp = new Literal("location");
			cp.addTerm(new NumberTermImpl(1));
			cp.addTerm(new NumberTermImpl(1));
			cp.addTerm(new NumberTermImpl(0));
			messages.add(new Message(EASSAgent.TELL, "vision", "goalreas", cp));
			first = false;
		}

		return messages;
	}

}
