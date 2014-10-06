package ethical_governor.human_hole;

import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Capability;
import ail.syntax.GBelief;
import ail.mas.DefaultEnvironment;

import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;

import ethical_governor.mas.DefaultEthicalGovernorEnv;
import ethical_governor.semantics.EthicalGovernor;
import java.util.Random;

public class HumanHoleVerificationEnv extends DefaultEthicalGovernorEnv implements MCAPLJobber {
	static String logname = "ethical_governor.human_hole.HumanHoleVerificationEnv";
	
	Random r = new Random();
	
	boolean done = false;
	
	static Capability action1 = new Capability(new GBelief(), new Action("action1"), new GBelief());
	static Capability action2 = new Capability(new GBelief(), new Action("action2"), new GBelief());
	static Capability action3 = new Capability(new GBelief(), new Action("action3"), new GBelief());
	static Capability action4 = new Capability(new GBelief(), new Action("action4"), new GBelief());
	static ArrayList<Capability> actions = new ArrayList<Capability>();
	static {actions.add(action1);
		actions.add(action2);
		actions.add(action3);
		actions.add(action4);
	}
	
	static Predicate outcome1 = new Predicate("human");
	static {
		outcome1.addTerm(new Predicate("hole"));
	}
	static Predicate outcome2 = new Predicate("robot");
	static {
		outcome2.addTerm(new Predicate("hole"));
	}
	static Predicate outcome3 = new Predicate("human");
	static {
		outcome3.addTerm(new Predicate("collision"));
	}
	static Predicate outcome4 = new Predicate("robot");
	static {
		outcome4.addTerm(new Predicate("collision"));
	}


	@Override
	public ArrayList<Predicate> model(Action act, String agName) {
		ArrayList<Predicate> outcomes = new ArrayList<Predicate>();
		
		if (r.nextBoolean()) {
			outcomes.add(outcome1);
			AJPFLogger.info(logname, "Human in Hole with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome2);
			AJPFLogger.info(logname, "Robot in Hole with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome3);
			AJPFLogger.info(logname, "Human Collision with " + act);
		}
		if (r.nextBoolean()) {
			outcomes.add(outcome4);
			AJPFLogger.info(logname, "Robot Collision with " + act);
		}
		
		return outcomes;
	}

	/**
	 * Add an ethical governor for some particular agent to the environment.
	 * @param name
	 * @param foragent
	 */
	public void addEthicalGovernor(String name, String foragent) {
	}
	
	/**
	 * Return the governor for some agent.
	 * @param agName
	 * @return
	 */
	public EthicalGovernor getGovernorFor(String agName) {
		return (EthicalGovernor) agentmap.get(agName);
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		return 0;
	}

	@Override
	public void do_job() {
		for (String egName: agentmap.keySet()) {
			EthicalGovernor eg = (EthicalGovernor) agentmap.get(egName);
			eg.govern(actions.iterator());
		}
		
		getScheduler().notActive(this.getName());
		done = true;
	}
	
	public boolean done() {
		return done;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Human Hole Verification Environment";
	}
	
	public void initialise() {
		super.initialise();
		getScheduler().addJobber(this);
	}

}
