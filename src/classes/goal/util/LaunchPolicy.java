package goal.util;

import java.util.ArrayList;
import java.util.Arrays;

import ail.semantics.AILAgent;
import ail.util.AILConfig;
import eis.EnvironmentInterfaceStandard;

public class LaunchPolicy {
	EnvironmentInterfaceStandard eis;
	ArrayList<String> entities = new ArrayList<String>();
	ArrayList<String> eis_entities = new ArrayList<String>();
	
	public LaunchPolicy(EnvironmentInterfaceStandard e) {
		eis = e;
	}
	
	public void setAssociateEntityLaunch(String agName) {
		entities.add(agName);
	}
	
	public void handleNewEntity(String arg0) {
		eis_entities.add(arg0);

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

	public void associateEntities() {
		if (!entities.isEmpty()) {
			for (String entity_name: eis_entities) {
				for (String agName: entities) {
					try {
						eis.associateEntity(agName, entity_name);
					} catch (Exception e) {
						System.err.println(e);
					}
				}

			}
		}		// TODO Auto-generated method stub
		
	}
}
