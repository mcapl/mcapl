// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.orca.Prototype6VK;

import java.util.Scanner;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.util.AILexception;
import ail.syntax.Message;
import ail.syntax.StringTermImpl;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

/**
 * Environment for the ORCA UAV.
 * 
 * @author mattwebster
 *
 */
public class ORCAEnv extends DefaultEnvironment {
	static String logname = "gwendolen.simple.ORCAEnv";
	
	UniformBoolChoice r;
	private RoutePlanner rp;
	private FlightControlSystem fcs;
	
	public ORCAEnv() {
		super();
		fcs = new FlightControlSystem();
	}		
	
	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();

	   	if (act.getFunctor().equals("send")) {
 
	   		
	   		System.out.println("\n\nOUTPUT  " + act.toString());
	   		

	   		
	   		
	   		
	   		if (act.getTerm(0).toString().equals("routePlanner")) {
	   			if (act.getTerm(1).toString().equals("requestRoute")) {
	   				rp = new RoutePlanner(this);
		   			rp.getRoutes(act.getTerm(1).toString(), act.getTerm(2).toString());
		   			// rp will calculate routes and send them back to the agent via the env	
	   			}
	   			else if (act.getTerm(1).toString().equals("enactRoute")) {
	   				
	   				rp.enactRoute(act.getTerm(2).toString(), act.getTerm(3).toString(), act.getTerm(4).toString());
	   			}
	   			
	   		}
	   		else if (act.getTerm(0).toString().equals("taskAgent"))
	   		{
	   			
	   			// Illocutionary force: 1 for tell, 2 for perform, 3 for achieve
		   		Predicate p = new Predicate("target");
		   		p.addTerm(new Predicate("t2"));
	     		addMessage("executive", new Message(1,"taskAgent","executive",p));
	   		}
	   		else if (act.getTerm(0).toString().equals("fcs"))
	   		{
	   			if (act.getTerm(1).toString().equals("requestStatus")) {
	   				Predicate p = new Predicate("flightPhase");
			   		p.addTerm(new Predicate("landed"));
		     		addMessage("executive", new Message(1,"fcs","executive",p));
	   			}
	   		}	   		
	   		
   			
	   		
	   	
       }
	   	
	   	try {
	   		theta = super.executeAction(agName, act);
    	} catch (AILexception e) {
    		throw e;
    	}

    	return theta;
   }
   
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}

 
}
