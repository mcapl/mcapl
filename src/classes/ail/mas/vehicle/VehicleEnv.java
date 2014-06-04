package ail.mas.vehicle;

import ail.mas.AILEnv;

public interface VehicleEnv extends AILEnv {
	public void addVehicle(Vehicle v); 
	
	public Vehicle getVehicle(String name); 

}
