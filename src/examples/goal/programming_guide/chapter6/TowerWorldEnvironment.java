package goal.programming_guide.chapter6;

import ail.util.AILConfig;
import eis.iilang.Identifier;
import goal.mas.GOALEISEnvironment;

public class TowerWorldEnvironment extends GOALEISEnvironment {

	public TowerWorldEnvironment() {
		super("/lib/eis/tower-1.2.0.jar");
	}

	@Override
	public void configure(AILConfig config) {
		for (String s: config.stringPropertyNames()) {
			if (s.startsWith("goal.launchpolicy")) {
				getLaunchPolicy().configure(config);
				break;
			}
		}
	}
}
