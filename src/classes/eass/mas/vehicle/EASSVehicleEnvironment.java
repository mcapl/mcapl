package eass.mas.vehicle;

import ail.mas.vehicle.VehicleInterface;
import ail.mas.vehicle.VehicleEnvironment;
import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.VerifyMap;
import eass.mas.DefaultEASSEnvironment;
import eass.semantics.EASSAgent;

import javax.swing.JPanel;

public class EASSVehicleEnvironment extends VehicleEnvironment {
	
	JPanel gui;
	
	public void setInterface(JPanel ui) {
		gui = ui;
	}
		
	public void addAgentToVehicle(AILAgent a) {
		EASSAgent eass = (EASSAgent) a;
		if (eass.isAbstractionEngine()) {
			String eassR = eass.getReasoningName();
			if (contains(eassR)) {
				EASSVehicle v = (EASSVehicle) getVehicle(eassR);
				v.addAgent(eass);
				eass.setEnv(v);
			} 
		} else {
			if (contains(eass.getAgName())) {
				EASSVehicle v = (EASSVehicle) getVehicle(eass.getAgName());
				v.addAgent(eass);
				eass.setEnv(v);
			}
		}
	}


}
