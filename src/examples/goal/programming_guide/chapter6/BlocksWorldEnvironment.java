package goal.programming_guide.chapter6;

import java.util.HashMap;
import java.util.Map;

import eis.EnvironmentInterfaceStandard;
import eis.iilang.Identifier;
import eis.iilang.Parameter;
import goal.mas.GOALEISEnvironment;
import goal.mas.GoalEnvironment;
import goal.util.LaunchPolicy;

public class BlocksWorldEnvironment extends GOALEISEnvironment {
	
	public BlocksWorldEnvironment() {
		super("/lib/eis/blocksworld-1.1.0.jar");		
		addFileToInitMap("start", "/src/examples/goal/programming_guide/chapter6/bwconfigEx1.txt");
		getLaunchPolicy().setAssociateEntityLaunch("stackBuilder");
	}
	
	
	@Override
	public boolean done() {
		return true;
	}


}
