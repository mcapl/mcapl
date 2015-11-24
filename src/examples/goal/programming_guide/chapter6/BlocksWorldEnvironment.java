package goal.programming_guide.chapter6;

import java.util.HashMap;
import java.util.Map;

import ail.util.AILConfig;
import eis.EnvironmentInterfaceStandard;
import eis.iilang.Identifier;
import eis.iilang.Parameter;
import goal.mas.GOALEISEnvironment;
import goal.mas.GoalEnvironment;
import goal.util.LaunchPolicy;

public class BlocksWorldEnvironment extends GOALEISEnvironment {
	
	public BlocksWorldEnvironment() {
		super("/lib/eis/blocksworld-1.1.0.jar");		
	}
	
	@Override
	public void configure(AILConfig config) {
		if (config.containsKey("goal.env.init.start")) {
			String filename = config.getProperty("config_path") + "/" + config.getProperty("goal.env.init.start");
			addFileToInitMap("start", filename);
		}
		
		for (String s: config.stringPropertyNames()) {
			if (s.startsWith("goal.launchpolicy")) {
				getLaunchPolicy().configure(config);
				break;
			}
		}
	}
	
	
	@Override
	public boolean done() {
		return true;
	}


}
