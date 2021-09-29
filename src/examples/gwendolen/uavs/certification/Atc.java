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

public class Atc extends SubSystem {
	
	@FilterField
	UavAgentEnv env;
	public UniformBoolChoice random_booleans;
	
	public Atc(UavAgentEnv e, UniformBoolChoice random)
	{
		env = e;
		random_booleans = random;
	}
	
	public void tell(Action act)
	{
		String message = act.getTerm(1).toString();
		if (message.equals("reqtc") && random_booleans.get_choice())  //0.9
		{
			Predicate predFromLine = new Predicate("atc");
			predFromLine.addTerm(new Literal("tcg"));      // taxi clearance has been given
			predFromLine.addTerm(new Literal("rwy090"));   // the runway to go to
			env.addMessage("exec", new Message(1,"env","exec",predFromLine));
			System.out.println("Adding message: " + predFromLine.toString());
		}
		else if (message.equals("reqtc") )
		{
			// should be deny taxi clearance
			Predicate predFromLine = new Predicate("atc");
			predFromLine.addTerm(new Literal("tcg"));      // taxi clearance has been given
			predFromLine.addTerm(new Literal("rwy090"));   // the runway to go to
			env.addMessage("exec", new Message(1,"env","exec",predFromLine));
			System.out.println("Adding message: " + predFromLine.toString());
		}
		else if (message.equals("reqluc") )
		{
			sendMessageToAgent("lucg","exec");
		}
		else if (message.equals("reqtoc") )
		{
			sendMessageToAgent("tocg","exec");
		}
	}
	
	public void step()
	{
		Predicate s = new Predicate("atc");
		s.addTerm(new Literal("null"));
		env.addMessage("exec", new Message(1,"env","exec",s));
	}
	
	public void sendMessageToAgent( String msg, String rcpt)
	{
		Predicate predFromLine = new Predicate("atc");
		predFromLine.addTerm(new Literal(msg));
		env.addMessage(rcpt, new Message(1,"env",rcpt,predFromLine));
		System.out.println("Adding message: " + predFromLine.toString());
	}

}
