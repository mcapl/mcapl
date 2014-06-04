package eass.mas.vehicle;

import ail.mas.vehicle.Vehicle;
import ail.mas.vehicle.VehicleEnvironment;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.VerifyMap;
import eass.mas.DefaultEASSEnvironment;

public class EASSVehicleEnvironment extends VehicleEnvironment {
	/**
	 * The vehicles in the environment, indexed by their names.
	 */
	VerifyMap<String, Vehicle> vehicles = new VerifyMap<String, Vehicle>();
	
	/**
	 * Add a vehicle to the environment.
	 * @param v
	 */
	public void addVehicle(Vehicle v) {
		v.setEnv(this);
		vehicles.put(v.getName(), v);
	}
	
	public Vehicle getVehicle(String name) {
		return vehicles.get(name);
	}
	

}
