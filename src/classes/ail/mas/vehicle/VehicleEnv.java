package ail.mas.vehicle;

import ail.mas.AILEnv;

public interface VehicleEnv extends AILEnv {
	public void addVehicle(VehicleInterface v); 
	
	public VehicleInterface getVehicle(String name); 
	
	public void notifyListeners(String name);

}
