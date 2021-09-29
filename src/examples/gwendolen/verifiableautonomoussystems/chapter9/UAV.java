package gwendolen.verifiableautonomoussystems.chapter9;

import java.util.HashSet;
import java.util.Set;

import ail.mas.DefaultEnvironmentwRandomness;
import ail.mas.MAS;
import ail.mas.scheduling.ActionScheduler;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyList;
import ajpf.util.choice.ProbBoolChoice;
import gov.nasa.jpf.annotation.FilterField;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class UAV extends
	VerificationofAutonomousSystemsEnvironment {

	@FilterField
	private String vehicleStatus;
	@FilterField
	String logname = "gwendolen.verifiableautonomoussystems.chapter9.UAV";
	
	boolean at_sumburgh = false;
	boolean landed = false;
	Predicate none_pred = new Predicate("none");
	
	boolean requesting_flight_phase = false;
	boolean requesting_fuel = false;
	boolean requesting_position = false;
	boolean requesting_taxi_route = false;
	boolean requesting_route = false;
	boolean requesting_emergency_avoid = false;
	Predicate requesting_enact_route = none_pred;
	boolean requesting_approach = false;
	Predicate requesting_enact_approach = none_pred;
	Predicate updating_flight_phase = none_pred;
	
	String atc = "";
	
	ProbBoolChoice prob_choice;

	private String lastMsgSu = "";
	
	private int das_setting = 0;
	
	VerifyList<Message> exec_pending_messages = new VerifyList<Message>();
	
	public String toString() {
		String s = "Environment:\n";
		s += "At Sumburgh: " + at_sumburgh + "\n";
		s += "Landed: " + landed + "\n";
		s += "Last Status Update: " + lastMsgSu + "\n";
		s += "Vehicle Status: " + vehicleStatus + "\n";
		if (requesting_flight_phase) {
			s += "Requesting Flight Phase\n";
		}
		if (requesting_fuel) {
			s += "Requesting Fuel\n";
		}
		if (requesting_position) {
			s += "Requesting Position\n";
		}
		if (requesting_taxi_route) {
			s += "Requesting Taxi Route\n";
		}
		if (requesting_route) {
			s += "Requesting Route\n";
		}
		if (requesting_emergency_avoid) {
			s += "Requesting Emergency Avoid\n";
		}
		if (requesting_approach) {
			s += "Requesting Approach\n";
		}
		s += "atc waiting: " + atc + "\n";
		s += "route waiting: " + requesting_enact_route + "\n";
		s += "route approach waiting: " + requesting_enact_approach + "\n";
		s += "updating flight phase: " + updating_flight_phase + "\n";
		return s;
	}

	public UAV() {
		super();
		this.setVehicleStatus("waitingAtRamp");
	} 
	
	public String getName() {
		return "UAV";
	}
	
	@Override
	public Set<Predicate> generate_percepts() {
		return new HashSet<Predicate>();
	}


	@Override
	public Set<Message> generate_messages() {
		Set<Message> messages = new HashSet<Message>();
		for (Message m: exec_pending_messages) {
			messages.add(m);
			AJPFLogger.fine(logname, "Sent Message: " + m);
		}
		exec_pending_messages.clear();	
		
		
		if ((vehicleStatus.equals("cruise")  && !at_sumburgh) || (vehicleStatus.equals("approach") && !landed)) {
			// RANDOM CHOICE
			boolean result = random_bool_generator.nextBoolean(); 
			// boolean result = true;
			if (result) {
				AJPFLogger.info(logname, "At Sumburgh or Landed True");
			} else {
				AJPFLogger.info(logname, "At Sumburgh or Landed False");
			}
			
			
			if (vehicleStatus.equals("cruise") & (result) & !at_sumburgh )
			{
				at_sumburgh = true;
				Predicate s = new Predicate("veh");
				s.addTerm(new Literal("location"));
				s.addTerm(new Literal("sumburgh"));
				messages.add(new Message(1,"env","exec",s));
			}
			else if (vehicleStatus.equals("approach") & result & !landed)
			{
				landed = true;
				Predicate s = new Predicate("veh");
				s.addTerm(new Literal("landed"));
				s.addTerm(new Literal("sumburgh"));
				messages.add(new Message(1,"env","exec",s));
			}
			
			
		}
		
		detectAndAvoidSensor(messages);
		
		if (requesting_flight_phase) {
			//boolean message = random_bool_generator.nextBoolean();
			boolean message = true;
			if (message) {
				AJPFLogger.info(logname, "Flight Phase Returned");
				Predicate s = new Predicate("veh");
				s.addTerm(new Literal("status"));
				s.addTerm(new Literal(vehicleStatus));
				messages.add(new Message(1,"env","exec",s));
				requesting_flight_phase = false;
			}
		}	
		
		if (requesting_fuel) {
			//boolean message = random_bool_generator.nextBoolean();
			boolean message = true;
			if (message) {
				AJPFLogger.info(logname, "Fuel Returned");
		   		Predicate s = new Predicate("fuel");
				s.addTerm(new Literal("level"));
				s.addTerm(new Literal("200"));
				messages.add(new Message(1,"env","exec",s));
				requesting_fuel = false;
			}
		}
		
		if (requesting_position) {
			//boolean message = random_bool_generator.nextBoolean();
			boolean message = true;
			if (message) {
				AJPFLogger.info(logname, "Position Returned");
				Predicate s = new Predicate("position");
				s.addTerm(new Literal("52"));
				s.addTerm(new Literal("0"));
				s.addTerm(new Literal("1"));
				messages.add(new Message(1,"env","exec",s));
				requesting_position = false;
			}
		}
		
		if (! atc.equals("")) {
	   		// RANDOM CHOICE
			boolean answer = random_bool_generator.nextBoolean();
			if (answer) {
				AJPFLogger.info(logname, "ATC Replies");
		   		boolean choice = random_bool_generator.nextBoolean();
		   		// boolean choice = true;
		   		if (choice) {
		   			Predicate predFromLine = new Predicate("atc");
		   			if (atc.equals("requestTaxiClearance")) {
		   				Predicate tcg = new Literal("taxiClearanceGiven");
		   				tcg.addTerm(new Literal("rwy090"));   // the runway to go to
		   				predFromLine.addTerm(tcg);      // taxi clearance has been given
		   			} else if (atc.equals("requestLineUpClearance")) {
		   				Predicate lug = new Literal("lineUpClearanceGiven");
		   				predFromLine.addTerm(lug);
		   			} else {
		   				Predicate lug = new Literal("takeOffClearanceGiven");
		   				predFromLine.addTerm(lug);
		   			}
					messages.add(new Message(1,"env","exec",predFromLine));
					atc="";
		   		} else {
		   			Predicate predFromLine = new Predicate("atc");
		   			if (atc.equals("requestTaxiClearance")) {
		   				predFromLine.addTerm(new Literal("taxiClearanceDenied"));      // taxi clearance is denied
		   			} else if (atc.equals("requestLineUpClearance")) {
		   				predFromLine.addTerm(new Literal("lineUpClearanceDenied"));  
		   			} else {
		   				predFromLine.addTerm(new Literal("takeOffClearanceDenied"));  
		   			}
		   			messages.add(new Message(1,"env","exec",predFromLine));
		   			atc="";
		   		}
			}

		}
		
		if (requesting_taxi_route) {
			boolean message = random_bool_generator.nextBoolean();
			if (message) {
				Predicate s = new Predicate("route");
				s.addTerm(new Literal("taxi")); // taxi-type route
				s.addTerm(new Literal("0")); // route number
				s.addTerm(new Literal("5")); // time in mins 
				s.addTerm(new Literal("1")); // fuel in litres
				s.addTerm(new Literal("90")); // safety as a percentage (?) with 100% being no unsafety
				
				// return information about a route. For the purposes of the model checking, the
				// variables of the information are just placeholders. The agent 
				messages.add(new Message(1,"env","exec",s));
				requesting_taxi_route = false;
			}
		}
		
		if (requesting_route) {
			boolean message = random_bool_generator.nextBoolean();
			if (message) {
		   		Predicate s = new Predicate("route");
				s.addTerm(new Literal("cruise")); // taxi-type route
				s.addTerm(new Literal("0")); // route number
				s.addTerm(new Literal("200")); // time in mins 
				s.addTerm(new Literal("100")); // fuel in litres
				s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
				
				// return information about a route. For the purposes of the model checking, the
				// variables of the information are just placeholders. The agent 
				messages.add(new Message(1,"env","exec",s));
				requesting_route = false;
			}
		}
		
		if (requesting_emergency_avoid) {
			boolean message = random_bool_generator.nextBoolean();
			if (message) {
				Predicate s = new Predicate("enacting");
				s.addTerm(new Literal("emergencyAvoid")); 
								
				messages.add(new Message(1,"env","exec",s));

				requesting_emergency_avoid = false;
			}
		}
		
		if (requesting_enact_route.getFunctor() != "none") {
			//boolean message = random_bool_generator.nextBoolean();
			boolean message = true;
			if (message) {
		   		Term type = requesting_enact_route.getTerm(0);
		   		Term num = requesting_enact_route.getTerm(1);
		   		Predicate s = new Predicate("enactRoute");
		   		s.addTerm(type);
		   		s.addTerm(num);
		   		messages.add(new Message(1,"env","exec",s));
		   		
		   		requesting_enact_route = none_pred;
			}
		}
		
		if (requesting_approach) {
			boolean message = random_bool_generator.nextBoolean();
			if (message) {
				Predicate s = new Predicate("appr");
				s.addTerm(new Literal("0")); // route number
				s.addTerm(new Literal("240")); // time in mins 
				s.addTerm(new Literal("100")); // fuel in litres
				s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
				
				// return information about a route. For the purposes of the model checking, the
				// variables of the information are just placeholders. The agent 
				messages.add(new Message(1,"env","exec",s));
				requesting_approach = false;
			}
		}

		if (requesting_enact_approach.getFunctor() != "none") {
			//boolean message = random_bool_generator.nextBoolean();
			boolean message = true;
			if (message) {
		   		Predicate s = new Predicate("enactAppr");
				s.addTerm(new Literal(requesting_enact_approach.getTerm(0).toString()));
				messages.add(new Message(1,"env","exec",s));

				requesting_enact_approach = none_pred;
			}
		}
		
		if (updating_flight_phase != none_pred) {
			if (updating_flight_phase.getTerm(0).getFunctor().equals("taxying") || updating_flight_phase.getTerm(0).getFunctor().equals("lineup") || updating_flight_phase.getTerm(0).getFunctor().equals("takeOff")) {
				boolean message = random_bool_generator.nextBoolean();
				if (message) {
					String phase = updating_flight_phase.getTerm(0).getFunctor();
			   		//if (! phase.equals(vehicleStatus)) {
				   		if (phase.equals("taxying")) {
				   			// if (vehicleStatus.equals("waitingAtRamp")  || vehicleStatus.equals("holding")) {
				   			if (!at_sumburgh) {
				   				setVehicleStatus("holding");
				   			} else {
				   				setVehicleStatus("waitingAtRamp");
				   			}
				   		} else if (phase.equals("lineup")) {
				   			setVehicleStatus("linedup");
				   		} else if (phase.equals("takeOff")) {
				   			setVehicleStatus("cruise");
				   		} 
			   		//}
			   		
			   		Predicate s = new Predicate("veh");
					s.addTerm(new Literal("status"));
					s.addTerm(new Literal(vehicleStatus));
					// clear_flight_status_messages();
					messages.add(new Message(1,"env","exec",s));
					
					updating_flight_phase = none_pred;
					
				}
				
			} else {
			   	//Predicate s = new Predicate("veh");
				//s.addTerm(new Literal("status"));
				//s.addTerm(new Literal(vehicleStatus));
				// clear_flight_status_messages();
				//messages.add(new Message(1,"env","exec",s));
				updating_flight_phase = none_pred;
			}
		}
		
				
		AJPFLogger.info( logname, this.toString());
		return messages;
		
	}
	
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();
	   	
	   	if (act.getFunctor().equals("requestFlightPhase")) {
	   		requesting_flight_phase = true;

	   	} else if (act.getFunctor().equals("requestFuelStatus")) {
	   		requesting_fuel = true;
	   	} else if (act.getFunctor().equals("requestPosition")) {
	   		requesting_position = true;
	   	} else if (act.getFunctor().equals("requestTaxiClearance") || act.getFunctor().equals("requestLineUpClearance") || act.getFunctor().equals("requestTakeOffClearance")) {
	   		atc = act.getFunctor();
	   	} else if (act.getFunctor().equals("requestTaxiRoute")) {
	   		requesting_taxi_route = true;
	   	} else if (act.getFunctor().equals("requestRoute")) {
	   		requesting_route = true;
	   	} else if (act.getFunctor().equals("requestEmergencyAvoid") && !lastMsgSu.equals("")) {
	   		requesting_emergency_avoid = true;
	   	} else if (act.getFunctor().equals("requestEnactRoute")) {
	   		requesting_enact_route = act;
	   	} else if (act.getFunctor().equals("requestApproach")) {
			requesting_approach = true;
	   	} else if (act.getFunctor().equals("enactApproach")) {
	   		requesting_enact_approach = act;
	   	} else if (act.getFunctor().equals("updateFlightPhase")) {
	   		//if (act.getTerm(0).getFunctor().equals("taxying") || act.getTerm(0).getFunctor().equals("lineup") || act.getTerm(0).getFunctor().equals("takeOff")) {
	   		//	updating_flight_phase = act;
	   		//} else {
	   			updating_flight_phase = act;
	   			setVehicleStatus(act.getTerm(0).getFunctor());
	   			//if (! act.getTerm(0).getFunctor().equals("emergencyAvoid")) {
	   			//	requesting_emergency_avoid = false;
	   			//}
	   		//}
	   	}
	   	
	   	theta = super.executeAction(agName, act);
	   		   	
	   	return theta;
	}
	
	/* private void clear_flight_status_messages() {
		VerifyList<Message> exec_pending_messages_tmp = new VerifyList<Message>();
		for (Message m: exec_pending_messages) {
			VarTerm status = new VarTerm("S");
			Predicate s = new Predicate("veh");
			s.addTerm(new Literal("status"));
			s.addTerm(status);
			if (! m.getPropCont().unifies(s, new Unifier())) {
				exec_pending_messages_tmp.add(m);
			}
		}
		exec_pending_messages.clear();
		exec_pending_messages.addAll(exec_pending_messages_tmp);
	} */
	
	private void setVehicleStatus(String status)
	{
		vehicleStatus = status;
		AJPFLogger.fine(logname, "Setting VEHICLE: " + status);
	}
	
	private void detectAndAvoidSensor(Set<Message> messages) {
		Predicate s_o;
		Predicate s_500;

		s_o = new Predicate("das");
		s_500 = new Predicate("das");
		s_o.addTerm(new Literal("objectApproaching"));
		s_500.addTerm(new Literal("alert500"));
		Message s_o_m = new Message(1,"env","exec",s_o);
		Message s_500_m = new Message(1,"env","exec",s_500);
		
		
		AJPFLogger.fine(logname, "das last message status update: " + lastMsgSu + " vehicle status: " + vehicleStatus);
		// if the last message was "object Approaching", the object is now passed. (maybe introduce a delay here , i.e., object appr can be sent again?)
		// otherwise, send either object approaching or nothing to report. 
		if ( lastMsgSu.equals("objectApproaching") || lastMsgSu.equals("alert500"))
		{
			// RANDOM Choice
			boolean choice = prob_choice.get_choice();
			// boolean choice = false;
			if (choice) {
				Predicate s = new Predicate("das");
				if (lastMsgSu.equals("objectApproaching")) {
					AJPFLogger.info(logname, "Removing das objectApproaching"); 
				} else {
					AJPFLogger.info(logname, "Removing das alert500");
				}
				//s.addTerm(new NumberTermImpl(d));
				s.addTerm(new Literal("objectPassed"));
				messages.add(new Message(1,"env","exec",s));
				lastMsgSu = "";
				requesting_emergency_avoid = false;
			} else {
				AJPFLogger.info(logname, "No Object Passed");
			}
		} else if (! (vehicleStatus.equals("emergencyAvoid"))  && lastMsgSu == "")
		{
			// RANDOM Choice
			if (vehicleStatus.equals("cruise") || das_setting == 0) {

			boolean choice = prob_choice.get_choice();
			// boolean choice = false;
			if (choice)  { // 0.001 normal course of things -- so unlikely to be an issue
				// RANDOM Choice
				choice = random_bool_generator.nextBoolean();
				// choice = false;
				if (choice) {
					AJPFLogger.info(logname, "Adding das objectApproaching");
					//s.addTerm(new NumberTermImpl(d));
					//s.addTerm(new Literal("objectApproaching"));
					messages.add(s_o_m);
					lastMsgSu = "objectApproaching";
					return;
				}
				else {
					AJPFLogger.info(logname, "Adding das alert500");
					//s.addTerm(new Literal("alert500"));
					messages.add(s_500_m);
					lastMsgSu = "alert500";
					return;
				}
			} 

			AJPFLogger.info(logname, "No Alerts");
			}
		}
		
	}
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		prob_choice = new ProbBoolChoice(m.getController(), 0.001);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
		if (config.containsKey("uav.das_setting")) {
			String setting = config.getProperty("uav.das_setting");
			if (setting.equals("cruise_only"))  {
				this.das_setting = 1;
			}
		}
	}

	
/*	public boolean done() {
		if ((vehicleStatus == "waitingAtRamp") && at_sumburgh && exec_pending_messages.isEmpty()) {
			return true;
		}
		
		return false;
	} */



	
//	public UAV(AILAgent a) {
//		super();
//		addAgent(a);
//		a.setEnv(this);
//	}

}
