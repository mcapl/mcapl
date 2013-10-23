package gwendolen.eiscarriage;

import ail.mas.ActionScheduler;
import ail.mas.eis.EISEnvironmentWrapper;

import ail.semantics.AILAgent;

import ajpf.util.AJPFLogger;

public class CarriageEnv extends EISEnvironmentWrapper{
	public CarriageEnv() {
		super("/Users/lad/Eclipse/eispackage-0.3-r72/interfaces/eiscarriage-0.3.jar");
		
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
	}
}
