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

public class Nav extends SubSystem {
	@FilterField
	UavAgentEnv env;
	
	public Nav(UavAgentEnv e)
	{
		env = e;
	}
	
	public void tell(Action act)
	{
		Predicate s;
		if (act.getTerm(1).toString().equals("reqposition") )
		{
			s = new Predicate("position");
			s.addTerm(new Literal("52"));
			s.addTerm(new Literal("0"));
			s.addTerm(new Literal("1"));
			env.addMessage("exec", new Message(1,"env","exec",s));
			
			
		}
	}
	
	public void step()
	{
		Predicate s = new Predicate("nav");
		s.addTerm(new Literal("null"));
		env.addMessage("exec", new Message(1,"env","exec",s));
	}

}
