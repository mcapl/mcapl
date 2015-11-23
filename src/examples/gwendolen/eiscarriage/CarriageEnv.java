package gwendolen.eiscarriage;

import ail.mas.scheduling.ActionScheduler;
import ail.mas.eis.EISEnvironmentWrapper;

import ail.semantics.AILAgent;

import ajpf.util.AJPFLogger;

public class CarriageEnv extends EISEnvironmentWrapper {
	public CarriageEnv() {
		super("/Users/louiseadennis/Eclipse/mcapl/lib/eis/Carriage-1.0.0.jar");
		
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);

	}
	
	public void addAgent(AILAgent a) {
		super.addAgent(a);
		if (a.getAgName().equals("ag1")) {
			try {
				getEIS().associateEntity("ag1", "robot1");
			} catch (Exception e) {
				AJPFLogger.severe("gwendolen.eiscarriage.CarriageEnv", e.getMessage());
			}
		}
		if (a.getAgName().equals("ag2")) {
			try {
				getEIS().associateEntity("ag2", "robot2");
			} catch (Exception e) {
				AJPFLogger.severe("gwendolen.eiscarriage.CarriageEnv", e.getMessage());
			}
		}
	}
	
	public boolean done() {
		return true;
	}
}
