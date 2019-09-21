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


public class DetectAndAvoidSensor extends SubSystem {
	@FilterField
	UavAgentEnv env;
	@FilterField
	private static String lastMsgSu = "";
	
	public UniformBoolChoice random_booleans;
	
	public DetectAndAvoidSensor(UavAgentEnv e, UniformBoolChoice random)
	{
		env = e;
		random_booleans = random;
	}
	
	public void tell(Action act)
	{

	}
	
	public void step()
	{
		Predicate s;

		s = new Predicate("das");
		
		System.out.println("!!! das");
		// if the last message was "object Approaching", the object is now passed. (maybe introduce a delay here , i.e., object appr can be sent again?)
		// otherwise, send either object approaching or nothing to report. 
		if ( lastMsgSu.equals("objectApproaching") )
		{
			System.out.println("!!! das objectApproaching last msg");
			//s.addTerm(new NumberTermImpl(d));
			s.addTerm(new Literal("objectPassed"));
			env.addMessage("exec", new Message(1,"env","exec",s));
			lastMsgSu = "objectPassed";
		} else if ( lastMsgSu.equals("alert500")  ) {
			System.out.println("!!! das alert500 last msg");
			//s.addTerm(new NumberTermImpl(d));
			s.addTerm(new Literal("objectPassed"));
			env.addMessage("exec", new Message(1,"env","exec",s));
			lastMsgSu = "objectPassed";			
		} else
		{
			if (random_booleans.get_choice())  // 0.5
			{
				//s.addTerm(new NumberTermImpl(d));
				s.addTerm(new Literal("objectApproaching"));
				env.addMessage("exec", new Message(1,"env","exec",s));
				lastMsgSu = "objectApproaching";
			}
			else if (random_booleans.get_choice()) 
			{
				s.addTerm(new Literal("alert500"));
				env.addMessage("exec", new Message(1,"env","exec",s));
				lastMsgSu = "alert500";
			}
			{
				//s.addTerm(new NumberTermImpl(d));
				s.addTerm(new Literal("nothingToReport"));
				env.addMessage("exec", new Message(1,"env","exec",s));
				lastMsgSu = "nothingToReport";
			}
			
		}
	}

}
