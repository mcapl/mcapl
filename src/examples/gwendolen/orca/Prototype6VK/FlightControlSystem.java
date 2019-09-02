package gwendolen.orca.Prototype6VK;

public class FlightControlSystem {
	public String flightPhase;
	
	public FlightControlSystem()
	{
		// initialise the flight control system. Get basic information from sensors.		
		initialise();
		flightPhase = getFlightPhase();
		
	}

	public String getFlightPhase()
	{
		return flightPhase;
	}
	
	public void initialise()
	{
		// in this model the UAV starts off landed
		flightPhase = "landed";
	}
	
}
