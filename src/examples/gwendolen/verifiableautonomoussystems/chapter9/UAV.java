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
	
	boolean requesting_flight_phase = false;
	boolean requesting_fuel = false;
	boolean requesting_position = false;
	
	String atc = "";
	
	ProbBoolChoice prob_choice;

	private String lastMsgSu = "";
	
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
		s += "atc waiting: " + atc + "\n";
		for (Message m: agMessages.get("exec")) {
			s += "Current messages in Environment: " + m + "\n";
		}
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
			boolean result = random_bool_generator.get_choice(); 
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
			boolean message = random_bool_generator.nextBoolean();
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
			boolean message = random_bool_generator.nextBoolean();
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
			boolean message = random_bool_generator.nextBoolean();
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
	   		boolean choice = random_bool_generator.get_choice();
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
				// AJPFLogger.fine(logname, "Adding message: " + predFromLine.toString());
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
				// System.out.println("Adding message: " + predFromLine.toString());
	   			atc="";
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
	   		Predicate s = new Predicate("route");
			s.addTerm(new Literal("taxi")); // taxi-type route
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("5")); // time in mins 
			s.addTerm(new Literal("1")); // fuel in litres
			s.addTerm(new Literal("90")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			exec_pending_messages.add(new Message(1,"env","exec",s));
	   	} else if (act.getFunctor().equals("requestRoute")) {
	   		Predicate s = new Predicate("route");
			s.addTerm(new Literal("cruise")); // taxi-type route
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("200")); // time in mins 
			s.addTerm(new Literal("100")); // fuel in litres
			s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			exec_pending_messages.add(new Message(1,"env","exec",s));

	   	} else if (act.getFunctor().equals("requestEmergencyAvoid")) {
			AJPFLogger.info(logname, "!!! emergAvoid");
			Predicate s = new Predicate("enacting");
			s.addTerm(new Literal("emergencyAvoid")); 
							
			exec_pending_messages.add(new Message(1,"env","exec",s));

	   	} else if (act.getFunctor().equals("requestEnactRoute")) {
	   		Term type = act.getTerm(0);
	   		Term num = act.getTerm(1);
	   		Predicate s = new Predicate("enactRoute");
	   		s.addTerm(type);
	   		s.addTerm(num);
	   		exec_pending_messages.add(new Message(1,"env","exec",s));
	   	} else if (act.getFunctor().equals("requestApproach")) {
			Predicate s = new Predicate("appr");
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("240")); // time in mins 
			s.addTerm(new Literal("100")); // fuel in litres
			s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			exec_pending_messages.add(new Message(1,"env","exec",s));

	   	} else if (act.getFunctor().equals("enactApproach")) {
	   		Predicate s = new Predicate("enactAppr");
			s.addTerm(new Literal(act.getTerm(0).toString()));
			exec_pending_messages.add(new Message(1,"env","exec",s));
	   	} else if (act.getFunctor().equals("updateFlightPhase")) {
	   		String phase = act.getTerm(0).getFunctor();
	   		if (! phase.equals(vehicleStatus)) {
		   		if (phase.equals("taxying")) {
		   			if (vehicleStatus.equals("waitingAtRamp")  || vehicleStatus.equals("holding")) {
		   				setVehicleStatus("holding");
		   			} else {
		   				setVehicleStatus("waitingAtRamp");
		   			}
		   		} else if (phase.equals("lineup")) {
		   			setVehicleStatus("linedup");
		   		} else if (phase.equals("takeOff")) {
		   			setVehicleStatus("cruise");
		   		} else {
		   			setVehicleStatus(phase);
		   		}
		   		Predicate s = new Predicate("veh");
				s.addTerm(new Literal("status"));
				s.addTerm(new Literal(vehicleStatus));
				clear_flight_status_messages();
				exec_pending_messages.add(new Message(1,"env","exec",s));
	   		}
			//addMessage("exec", new Message(1,"env","exec",s));
			// System.out.println("sent message!" + s.toString());
	   	}
	   	
	   	theta = super.executeAction(agName, act);
	   		   	
	   	return theta;
	}
	
	private void clear_flight_status_messages() {
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
	}
	
	private void setVehicleStatus(String status)
	{
		vehicleStatus = status;
		AJPFLogger.info(logname, "Setting VEHICLE: " + status);
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
					System.out.println("!!! das objectApproaching last msg"); 
				} else {
					System.out.println("!!! das alert500 last msg");
				}
				//s.addTerm(new NumberTermImpl(d));
				s.addTerm(new Literal("objectPassed"));
				messages.add(new Message(1,"env","exec",s));
				lastMsgSu = "";
			} else {
				AJPFLogger.info(logname, "No Object Passed");
			}
		} else if (! (vehicleStatus.equals("emergencyAvoid"))  && lastMsgSu == "")
		{
			// RANDOM Choice
			boolean choice = prob_choice.get_choice();
			// boolean choice = false;
			if (choice)  // 0.5
			{
				AJPFLogger.info(logname, "!!! das objectApproaching");
				//s.addTerm(new NumberTermImpl(d));
				//s.addTerm(new Literal("objectApproaching"));
				messages.add(s_o_m);
				lastMsgSu = "objectApproaching";
				return;
			}
			else {
				// RANDOM Choice
				choice = prob_choice.get_choice();
				// choice = false;
				if (choice) {
					AJPFLogger.info(logname, "!!! das alert500");
					//s.addTerm(new Literal("alert500"));
					messages.add(s_500_m);
					lastMsgSu = "alert500";
					return;
				}
			}

			AJPFLogger.info(logname, "No Alerts");
		}

		
	}
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		prob_choice = new ProbBoolChoice(m.getController(), 0.001);
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
