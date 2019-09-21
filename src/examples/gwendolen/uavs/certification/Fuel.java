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

public class Fuel extends SubSystem {
	@FilterField
	UavAgentEnv env;
	
	public Fuel(UavAgentEnv e)
	{
		env = e;
	}
	
	public void tell(Action act)
	{
		Predicate s;
		if (act.getTerm(1).toString().equals("reqfuelstatus") )
		{
			s = new Predicate("fuel");
			s.addTerm(new Literal("level"));
			s.addTerm(new Literal("200"));
			env.addMessage("exec", new Message(1,"env","exec",s));
			
			
		}
	}
	
	public void step()
	{
		Predicate s = new Predicate("fuel");
		s.addTerm(new Literal("null"));
		env.addMessage("exec", new Message(1,"env","exec",s));
	}

}
