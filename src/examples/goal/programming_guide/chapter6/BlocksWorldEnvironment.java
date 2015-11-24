package goal.programming_guide.chapter6;

import java.util.HashMap;
import java.util.Map;

import eis.EnvironmentInterfaceStandard;
import eis.iilang.Identifier;
import eis.iilang.Parameter;
import goal.mas.GOALEISEnvironment;
import goal.mas.GoalEnvironment;

public class BlocksWorldEnvironment extends GOALEISEnvironment {
	
	public BlocksWorldEnvironment() {
		super("/Users/louiseadennis/Eclipse/mcapl/lib/eis/blocksworld-1.1.0.jar");
		
	}
	
	@Override
	public void initialise() {
		EnvironmentInterfaceStandard eis = getEISEnvironment();
		
		Map<String, Parameter> initMap = new HashMap<String, Parameter>();
		initMap.put("start", new Identifier("/Users/louiseadennis/Eclipse/mcapl/src/examples/goal/programming_guide/chapter6/bwconfigEx1.txt"));
		try {
			eis.init(initMap);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@Override
	public void handleNewEntity(String arg0) {
		EnvironmentInterfaceStandard eis = getEISEnvironment();
		try {
			eis.associateEntity("stackBuilder", arg0);
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	@Override
	public boolean done() {
		return true;
	}


}
