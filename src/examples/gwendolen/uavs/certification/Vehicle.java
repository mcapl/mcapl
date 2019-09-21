///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2010-12 University of Liverpool Virtual Engineering Centre.
// 
// Author: Matt Webster
///////////////////////////////////////////////////////////////////////////////

package gwendolen.uavs.certification;

import gov.nasa.jpf.annotation.FilterField;
import ail.syntax.Message;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ajpf.util.choice.UniformBoolChoice;

public class Vehicle extends SubSystem {
	@FilterField
	UavAgentEnv env;
	@FilterField
	private static String vehicleStatus;
	@FilterField
	boolean cruisingForMoreThanOneTimeStep = false;
	
	public UniformBoolChoice random_booleans;
	
	public Vehicle(UavAgentEnv e, UniformBoolChoice random)
	{
		this.setVehicleStatus("waitingAtRamp");
		env = e;
		random_booleans = random;
	}
	
	private void setVehicleStatus(String status)
	{
		vehicleStatus = status;
		System.out.println("VEHICLE: " + status);
	}
	
	public void tell(Action act)
	{
		Predicate s;
		System.out.println("vehicle!");
		if (act.getTerm(1).toString().equals("reqfp") )
		{
			s = new Predicate("veh");
			s.addTerm(new Literal("status"));
			s.addTerm(new Literal(vehicleStatus));
			env.addMessage("exec", new Message(1,"env","exec",s));
			System.out.println("sent message!" + s.toString());
			
			// if the vehicle has landed, then it's mission complete
			if (vehicleStatus.equals("land"))
			{
				Literal lit = new Literal("missionComplete");					
				env.addMessage("exec", new Message(1,"env","exec",lit));
				
			}
		}
		else if (act.getTerm(1).toString().equals("updatefp") )
		{
			this.setVehicleStatus(act.getTerm(2).toString());
			
			// if the vehicle status is updated to taxying, then go straight to holding
			// i.e., straight after the vehicle is taxying it is holding. There is no reason to
			// include a time delay here, as for the purposes of model checking these would be
			// subsequent states, i.e., taxying ---> holding
			if (vehicleStatus.equals("taxying"))
			{
				this.setVehicleStatus("atRunwayHoldPosition");
				s = new Predicate("veh");
				s.addTerm(new Literal("status"));
				s.addTerm(new Literal(vehicleStatus));
				env.addMessage("exec", new Message(1,"env","exec",s));
				
			}
			else if (vehicleStatus.equals("lineup"))
			{
				this.setVehicleStatus("linedup");
				s = new Predicate("veh");
				s.addTerm(new Literal("status")); 
				s.addTerm(new Literal(vehicleStatus));
				env.addMessage("exec", new Message(1,"env","exec",s));
			}
			else if (vehicleStatus.equals("takeOff"))
			{
				this.setVehicleStatus("cruise");
				s = new Predicate("veh");
				s.addTerm(new Literal("status"));
				s.addTerm(new Literal(vehicleStatus));
				env.addMessage("exec", new Message(1,"env","exec",s));
			}
			else if (vehicleStatus.equals("taxyingDestination"))
			{
				this.setVehicleStatus("waitingAtRamp");
				s = new Predicate("veh");
				s.addTerm(new Literal("status")); 
				s.addTerm(new Literal(vehicleStatus));
				env.addMessage("exec", new Message(1,"env","exec",s));
			}
		}

	}
	
	public void step()
	{
		
		boolean result = random_booleans.get_choice();  
		
		//int result = 1;   // never gets to destination or approach.
		
		if (vehicleStatus.equals("cruise") & (result) )
		{
			// make sure that we have been cruising for at least one time step, i.e., a non-trivial amount of time,
			// before triggering the new location message.
			// This was introduced after an error was found in which the updatefp action updated the flight phase to takeoff.
			// The vehicle immediately did a "veh(status,cruise)" (see above). However before the exec had time to register this and 
			// update its flight phase to cruise, the veh, which is polled after the self (exec), chose to update the location to
			// sumburgh. However as the exec was not yet in cruise flight phase this caused an error. It was judged that this error
			// was due to inappropriate environment design, so the change was made in here rather than in the exec. So now the 
			// vehicle has to be in cruise for at least one time step before in can update the location.
			if (cruisingForMoreThanOneTimeStep)
			{
				Predicate s = new Predicate("veh");
				s.addTerm(new Literal("location"));
				s.addTerm(new Literal("sumburgh"));
				env.addMessage("exec", new Message(1,"env","exec",s));
				//System.exit(0);
				
			}
			else
			{
				Predicate s = new Predicate("veh");
				s.addTerm(new Literal("null"));
				env.addMessage("exec", new Message(1,"env","exec",s));
				cruisingForMoreThanOneTimeStep = true;				
			}
			
			
		}
		else if (vehicleStatus.equals("approach") & result)
		{
			Predicate s = new Predicate("veh");
			s.addTerm(new Literal("landed"));
			s.addTerm(new Literal("sumburgh"));
			env.addMessage("exec", new Message(1,"env","exec",s));
		}
		else
		{
			Predicate s = new Predicate("veh");
			s.addTerm(new Literal("null"));
			env.addMessage("exec", new Message(1,"env","exec",s));
		}
	}

}
