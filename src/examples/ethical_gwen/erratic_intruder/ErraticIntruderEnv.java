// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
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
package ethical_gwen.erratic_intruder;


import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.PlanLibrary;
import ail.syntax.Event;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.util.AILexception;
import ail.mas.DefaultEnvironment;
import gwendolen.syntax.ast.Abstract_GPlan;
import ail.syntax.Plan;
import ethical_gwen.mas.DefaultEthicalEnvironment;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ajpf.util.AJPFLogger;
import ajpf.MCAPLJobber;

public class ErraticIntruderEnv extends DefaultEnvironment implements DefaultEthicalEnvironment, MCAPLJobber {
	boolean intruder_avoided = false;
	public ErraticIntruderEnv() {
		super();
		super.getScheduler().addJobber(this);
	}
	
	public boolean done() {
		return intruder_avoided;
	}
	
	public void eachrun() {
		if (!intruder_avoided) {
			   Predicate intruder = new Predicate("das");
			   intruder.addTerm(new Predicate("intruder"));
			   intruder.addTerm(new Predicate("headOn"));
			   addPercept("executive", intruder);			
		} else {
			
			   Predicate intruder = new Predicate("das");
			   intruder.addTerm(new Predicate("intruder"));
			   intruder.addTerm(new Predicate("headOn"));
			   removePercept("executive", intruder);
		}
	}

	public Unifier executeAction(String agName, Action act) throws AILexception {
		   
		Unifier u = new Unifier();
		 
	   if (act.getFunctor().equals("plan") && act.getTermsSize() == 2) {
	   		Predicate route1 = new Predicate("route");
	   		route1.addTerm(new Predicate("emergAvoid"));
	   		route1.addTerm(new Predicate("turnRight"));
	   		addPercept(agName, route1);
		   
	   }  else if (act.getFunctor().equals("enactRoute")) {
		   if (act.getTerm(0).equals(new Predicate("return_to_base"))) {
			   intruder_avoided = true;
			   eachrun();
		   }
		   addPercept(agName, new Predicate("moving"));
	   } else if (act.getFunctor().equals("wait")) {
	   }
	   
	   u.compose(super.executeAction(agName, act));
	   return u;
	}

	public PlanLibrary invokeEthicalPlanner(Event e, ListTerm policy) {
		PlanLibrary pl = new PlanLibrary();
		String plan1 = "+!avoid_collision[achieve] : {B flightPhase(emergAvoid)} <- enactRoute(turn_left);";
		Plan p1 = planfromstring(plan1);
   		ListTermImpl l1 = new ListTermImpl();
   		l1.add(new Predicate("doNotViolateRoADetectAvoidTurnRight"));
		if (p1 != null) {
			p1.setAnnotation(new EthicsAnnotation(l1));
			pl.add(p1);
		}
		String plan2 = "+!avoid_collision[achieve] : {B flightPhase(emergAvoid)} <- enactRoute(emergency_land);";
		Plan p2 = planfromstring(plan2);
   		ListTermImpl l2 = new ListTermImpl();
   		l2.add(new Predicate("doNotRoA500Feet"));
   		l2.add(new Predicate("doNotCollideAircraft"));
   		l2.add(new Predicate("doNotCollideObjectsOnGround"));
		if (p2 != null) {
			p2.setAnnotation(new EthicsAnnotation(l2));
			pl.add(p2);
		}
		String plan3 = "+!avoid_collision[achieve] : {B flightPhase(emergAvoid)} <- enactRoute(return_to_base);";
		Plan p3 = planfromstring(plan3);
   		ListTermImpl l3 = new ListTermImpl();
   		l3.add(new Predicate("doNotCollideAircraft"));
		if (p3 != null) {
			p3.setAnnotation(new EthicsAnnotation(l3));
			pl.add(p3);
		}
		return pl;
	}
	
	public Plan planfromstring(String s) {
		EthicalGwendolenLexer lexer = new EthicalGwendolenLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		EthicalGwendolenParser parser = new EthicalGwendolenParser(tokens);
		try {
			Abstract_GPlan aplan = parser.plan();
			Plan plan = aplan.toMCAPL();
			return plan;
		} catch (Exception e) {
			AJPFLogger.warning("ethical_gwen.lineup.LineUpEnv", "Couldn't parse plan: " + s + ":" + e.getMessage());
			return null;
		}
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(getName());
	}

	@Override
	public void do_job() {
		eachrun();
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ErraticIntruderEnvironment";
	}
}
