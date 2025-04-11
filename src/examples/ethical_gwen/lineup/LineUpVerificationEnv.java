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
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.lineup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import ethical_gwen.BaseUAVEnv;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.scheduling.ActionScheduler;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.PlanLibrary;
import ail.syntax.Event;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.util.AILexception;
import gwendolen.syntax.ast.Abstract_GPlan;
import ail.syntax.Plan;
import ail.mas.DefaultEnvironment;
import ethical_gwen.mas.DefaultEthicalVerificationEnvironment;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ajpf.util.AJPFLogger;

public class LineUpVerificationEnv extends BaseUAVEnv {
	
	public LineUpVerificationEnv() {
		super("enactRoutewEffects");
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
	}
	
	public void eachrun() {
		System.err.println("Executing Environment");
	}

	public Unifier executeAction(String agName, Action act) throws AILexception {
		   
		Unifier u = new Unifier();
		 
	   if (act.getFunctor().equals("plan") && act.getTermsSize() > 2) {
	   		// ListTerm policy = (ListTerm) act.getTerm(2);
	   		Predicate route1 = new Predicate("route");
	   		ListTermImpl l1 = new ListTermImpl();
	   		l1.add(new Predicate("doNotDamageOwnAircraft"));
	   		l1.add(new Predicate("doNotCollideAirportHardware"));
	   		route1.addTerm(new Predicate("turn_left"));
	   		route1.addTerm(l1);
	   		addPercept(agName, route1);

	   		Predicate route2 = new Predicate("route");
	   		ListTermImpl l2 = new ListTermImpl();
	   		l2.add(new Predicate("doNotDamageOwnAircraft"));
	   		l2.add(new Predicate("doNotCollidePeople"));
	   		route2.addTerm(new Predicate("turn_right"));
	   		route2.addTerm(l2);
	   		addPercept(agName, route2);

	   		Predicate route3 = new Predicate("route");
	   		ListTermImpl l3 = new ListTermImpl();
	   		l3.add(new Predicate("doNotCollideMannedAircraft"));
	   		route3.addTerm(new Predicate("continue"));
	   		route3.addTerm(l3);
	   		addPercept(agName, route3);
	   		
	   		addPercept(agName, new Predicate("sentAllRoutes"));
	   } else if (act.getFunctor().equals("plan") && act.getTermsSize() == 2) {
	   		Predicate route1 = new Predicate("route");
	   		route1.addTerm(new Predicate("take_off"));
	   		addPercept(agName, route1);
		   
	   }  else if (act.getFunctor().equals("poll")) {
	  
		   addPercept(agName, new Predicate("brakesCompleteFailure"));
	   } else if (act.getFunctor().equals("enactRoutewEffects") || act.getFunctor().equals("enactRoute")) {
		   addPercept(agName, new Predicate("missionComplete"));
	   }
	   
	   u.compose(super.executeAction(agName, act));
	   return u;
	}


}
