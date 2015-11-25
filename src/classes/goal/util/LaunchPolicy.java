package goal.util;

import java.util.ArrayList;
import java.util.Arrays;

import ail.util.AILConfig;
import eis.EnvironmentInterfaceStandard;

public class LaunchPolicy {
	EnvironmentInterfaceStandard eis;
	ArrayList<String> entities = new ArrayList<String>();
	
	public LaunchPolicy(EnvironmentInterfaceStandard e) {
		eis = e;
	}
	
	public void setAssociateEntityLaunch(String agName) {
		entities.add(agName);
	}
	
	public void handleNewEntity(String arg0) {
		if (!entities.isEmpty()) {
			for (String agName: entities) {
				try {
					eis.associateEntity(agName, arg0);
				} catch (Exception e) {
					System.err.println(e);
				}

			}
		}
	}
	
	public void configure(AILConfig config) {
		if (config.containsKey("goal.launchpolicy.entity.launch")) {
			String entitylist = config.getProperty("goal.launchpolicy.entity.launch");
			String[] entity_array = entitylist.split(",");
			for (String s: Arrays.asList(entity_array)) {
				setAssociateEntityLaunch(s);
			}
		}

	}
}
