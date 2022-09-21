package ail.mas;

import ail.syntax.*;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

import java.util.HashSet;
import java.util.Set;

public class DurativeActionEnvironment extends DefaultEnvironment implements MCAPLJobber, EnvWithCapLibrary {
	static String logname = "gwendolen.failuredetection.DurativeActionEnvironment";

	int seconds = 0;
	protected boolean done = false;

	Capability capability;
	UniformBoolChoice r;
	CapabilityLibrary capLibrary = new CapabilityLibrary();

	public DurativeActionEnvironment() {
		// Make environment
		super();
		AJPFLogger.fine(logname, "Environment Created");

//		// Construct belief literals
//		Literal atW0 = new Literal("at");
//		atW0.addTerm(new NumberTermImpl(0));
//		Literal atW1 = new Literal("at");
//		atW1.addTerm(new NumberTermImpl(1));
//
//		// Create literals for use as actions
//		Literal move1_0 = new Literal("move");
//		move1_0.addTerm(new NumberTermImpl(1));
//		move1_0.addTerm(new NumberTermImpl(0));
//
//		// Create Durative Actions
//		DurativeAction moveW1W0 = new DurativeAction(new Action(move1_0, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW0)));
//
//		// Add capabilities to environment
//		capLibrary.add(moveW1W0);
//
//		// Add percept for start location (fixes annotation issue for initial beliefs)
//		addPercept(atW0);

		getScheduler().addJobber(this);

	}



	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier theta = new Unifier();
		if (!act.getFunctor().equals("abort")) {
			AJPFLogger.info(logname, "Executing action: " + act.toPredicate().toString());
		}
		else if (act.getFunctor().equals("abort")) {
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
		// pass time
			int timepassed = clock();
			updateTimePassed(timepassed);
	}

	public boolean done() {
		// if the agent believes "done", return true.
		Literal done = new Literal("done");
		return (percepts.contains(done));
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