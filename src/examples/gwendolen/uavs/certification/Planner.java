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

public class Planner extends SubSystem {
	@FilterField
	UavAgentEnv env;
	
	public Planner(UavAgentEnv e)
	{
		env = e;
	}
	
	public void tell(Action act)
	{
		Predicate s; 
		if (act.getTerm(1).toString().equals("reqroute") )
		{
			System.out.println("!!! reqroute");
			if (act.getTerm(2).toString().equals("emergAvoid"))
			{
				System.out.println("!!! emergAvoid");
				s = new Predicate("enacting");
				s.addTerm(new Literal("emergencyAvoid")); 
								
				env.addMessage("exec", new Message(1,"env","exec",s));
			}
			else if (act.getTerm(2).toString().equals("sumburgh"))
			{
			
				s = new Predicate("route");
				s.addTerm(new Literal("cruise")); // cruise-type route
				s.addTerm(new Literal("0")); // route number
				s.addTerm(new Literal("240")); // time in mins 
				s.addTerm(new Literal("100")); // fuel in litres
				s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
				
				// return information about a route. For the purposes of the model checking, the
				// variables of the information are just placeholders. The agent 
				env.addMessage("exec", new Message(1,"env","exec",s));
			}
			
		}
		else if (act.getTerm(1).toString().equals("reqTaxiRoute") )
		{
			s = new Predicate("route");
			s.addTerm(new Literal("taxi")); // taxi-type route
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("5")); // time in mins 
			s.addTerm(new Literal("1")); // fuel in litres
			s.addTerm(new Literal("90")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			env.addMessage("exec", new Message(1,"env","exec",s));
		}
		else if (act.getTerm(1).toString().equals("reqRoute") )
		{
			s = new Predicate("route");
			s.addTerm(new Literal("cruise")); // taxi-type route
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("200")); // time in mins 
			s.addTerm(new Literal("100")); // fuel in litres
			s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			env.addMessage("exec", new Message(1,"env","exec",s));
		}
		else if (act.getTerm(1).toString().equals("reqappr") )
		{
			s = new Predicate("appr");
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("240")); // time in mins 
			s.addTerm(new Literal("100")); // fuel in litres
			s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			env.addMessage("exec", new Message(1,"env","exec",s));
			
		}
		else if (act.getTerm(1).toString().equals("reqtaxiDestination") )  // requests a taxi to final destination
		{
			s = new Predicate("taxi");
			s.addTerm(new Literal("0")); // route number
			s.addTerm(new Literal("240")); // time in mins 
			s.addTerm(new Literal("100")); // fuel in litres
			s.addTerm(new Literal("80")); // safety as a percentage (?) with 100% being no unsafety
			
			// return information about a route. For the purposes of the model checking, the
			// variables of the information are just placeholders. The agent 
			env.addMessage("exec", new Message(1,"env","exec",s));
			
		}
		else if (act.getTerm(1).toString().equals("enactRoute") )
		{
			// if the vehicle gets a message, enactOnTakeOff(N), then it will bounce the 
			// message back to the exec as an acknowledgement. Note that in the real
			// vehicle FCS, this route corresponding to the number provided would be stored
			// and enacted at take off. 
			
			s = new Predicate("enactRoute");
			s.addTerm(new Literal(act.getTerm(2).toString()));
			s.addTerm(new Literal(act.getTerm(3).toString()));
			env.addMessage("exec", new Message(1,"env","exec",s));
			
		}
		else if (act.getTerm(1).toString().equals("enactAppr") )
		{
			// if the vehicle gets a message, enactOnTakeOff(N), then it will bounce the 
			// message back to the exec as an acknowledgement. Note that in the real
			// vehicle FCS, this route corresponding to the number provided would be stored
			// and enacted at take off. 
			
			s = new Predicate("enactAppr");
			s.addTerm(new Literal(act.getTerm(2).toString()));
			env.addMessage("exec", new Message(1,"env","exec",s));
			
		}
		else if (act.getTerm(1).toString().equals("enactTaxi") )
		{
			// if the vehicle gets a message, enactOnTakeOff(N), then it will bounce the 
			// message back to the exec as an acknowledgement. Note that in the real
			// vehicle FCS, this route corresponding to the number provided would be stored
			// and enacted at take off. 
			
			s = new Predicate("enactTaxi");
			s.addTerm(new Literal(act.getTerm(2).toString()));
			env.addMessage("exec", new Message(1,"env","exec",s));
			
		}
	}
	
	public void step()
	{
		Predicate s = new Predicate("planner");
		s.addTerm(new Literal("null"));
		env.addMessage("exec", new Message(1,"env","exec",s));
	}

}
