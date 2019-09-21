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

/**
 * Models the environment agent -- the agent that maintains the environment of subsystems. 
 * At the moment the env just provides a "connectionOk" to the executive when it starts up
 * to say that the environment is connected.
 * 
 * @author matt
 *
 */
public class Env extends SubSystem {
	@FilterField
	UavAgentEnv env;
	
	public Env(UavAgentEnv e)
	{
		env = e;
	}
	
	public void tell(Action act)
	{
		Predicate s;
		if (act.getTerm(1).toString().equals("connect") )
		{
			s = new Predicate("connectionOk");
			//s.addTerm(new Literal(vehicleStatus));
			env.addMessage("exec", new Message(1,"env","exec",s));
		}
	
	}
	
	public void step()
	{
		Predicate s;
	
		s = new Predicate("env");
		s.addTerm(new Literal("null"));
		env.addMessage("exec", new Message(1,"env","exec",s));			
		
	}

}
