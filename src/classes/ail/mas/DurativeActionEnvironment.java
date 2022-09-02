package gwendolen.failuredetection;

import ail.mas.DefaultEnvironment;
import ail.mas.EnvWithCapLibrary;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DurativeActionEnvironment extends DefaultEnvironment implements MCAPLJobber, EnvWithCapLibrary {
	static String logname = "gwendolen.failuredetection.DurativeActionEnvironment";

	int seconds = 0;
	protected boolean done = false;

	Capability capability;
	UniformBoolChoice r;
	CapabilityLibrary capLibrary = new CapabilityLibrary();

	public DurativeActionRouteEnv() {
		// Make environment
		super();
		AJPFLogger.fine(logname, "Environment Created");

		// Construct belief literals
		Literal atW0 = new Literal("at");
		atW0.addTerm(new NumberTermImpl(0));
		Literal atW1 = new Literal("at");
		atW1.addTerm(new NumberTermImpl(1));

		// Create literals for use as actions
		Literal move1_0 = new Literal("move");
		move1_0.addTerm(new NumberTermImpl(1));
		move1_0.addTerm(new NumberTermImpl(0));

		// Create Durative Actions
		DurativeAction moveW1W0 = new DurativeAction(new Action(move1_0, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW0)));

		// Add capabilities to environment
		capLibrary.add(moveW1W0);

		// Add percept for start location (fixes annotation issue for initial beliefs)
		addPercept(atW0);

		getScheduler().addJobber(this);

	}

		public void processMovement(String agName, Capability capability) {
			//gwendolen format required: move(term0, term1)
			// wait for the duration allowed in the capability
			// ----- logic here -----


			// if (env.config == AIL.Config.PROGRAMMATIC) {
			Action act = capability.getAction();
			Term origin = act.getTerm(0);
			Term destination = act.getTerm(1);
			Predicate new_position = new Predicate("at");
			Predicate old_position = new Predicate("at");
			new_position.addTerm(destination);
			old_position.addTerm(origin);
			removePercept(old_position);
			addPercept(new_position);
			
			// Logic for PHYSICAL deployment
			// } else {
			// removePercepts(at);
			// addPercept(getPerceptfromSensor(agName));
	}

	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (!act.getFunctor().equals("abort")) {
			AJPFLogger.info(logname, "Executing action: " + act.toPredicate().toString());
		}
		Unifier theta = new Unifier();
		if (act.getFunctor().equals("move")) {
			updateTimePassed(0);
			// find the corresponding action in the caplibrary
			if (capLibrary.getCapability(act) != null) {
				Capability capability = capLibrary.getCapability(act);
				processMovement(agName, capability);
			}
		} else if (act.getFunctor().equals("abort")) {
			updateTimePassed(0);
			System.err.println("ABORTING ACTION - TIMED OUT");

		} else if (act.getFunctor().equals("printlogs")) {
			agentmap.get(agName).printActionLog();
		}

		try {
			theta = super.executeAction(agName, act);
		} catch (AILexception e) {
			throw e;
		}

		return theta;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}

	public int clock() {
		seconds++;
		return seconds;
	}

	public Set<Literal> perceptsToLiterals() {
		Set<Literal> p = new HashSet<Literal>();
		if (! percepts.isEmpty()) {
			for (Predicate per: percepts) {
				p.add(new Literal((Predicate) per.clone()));
			}
		}
		return p;
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void do_job() {
		// If at start, do the saved cap
		Literal atW0 = new Literal("at");
		atW0.addTerm(new NumberTermImpl(0));
		if (agPercepts.containsValue(atW0)) {
			int timepassed = clock();
			updateTimePassed(timepassed);
			robotProcessing(lastAgent, capability);
		} else {
			addPercept(new Literal("something"));
		}
	}

	public boolean done() {
		Literal atW4 = new Literal("at");
		atW4.addTerm(new NumberTermImpl(4));
		return (percepts.contains(atW4));
	}

	public void updateTimePassed(int seconds) {
		Literal oldtime = new Literal("timepassed");
		oldtime.addTerm(new VarTerm("Any"));
		removeUnifiesPercept(oldtime);
		Literal time = new Literal("timepassed");
		time.addTerm(new NumberTermImpl(seconds));
		addPercept(time);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DurativeActionEnvironment";
	}

	@Override
	public CapabilityLibrary getCapabilityLibrary() {
		return capLibrary;

	}
}