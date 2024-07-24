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
package ethical_gwen.fuel_low;


import ethical_gwen.BaseUAVEnv;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.scheduling.ActionScheduler;
import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.PlanLibrary;
import ail.syntax.Event;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.Guard;
import ail.syntax.Term;
import ail.util.AILexception;
import gwendolen.syntax.ast.Abstract_GPlan;
import ail.syntax.Plan;
import ethical_gwen.mas.DefaultEthicalEnvironment;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ajpf.util.AJPFLogger;
import ajpf.MCAPLJobber;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FuelLowVerificationEnv extends BaseUAVEnv implements MCAPLJobber {
	boolean intruder_avoided = false;
	
	public FuelLowVerificationEnv() {
		super();
		ActionScheduler s = new ActionScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	public void eachrun() {
		Predicate fuel = new Predicate("fuel");
		fuel.addTerm(new Predicate("fuelLowEmerg"));
		addPercept("executive", fuel);
	}
	

	public Unifier executeAction(String agName, Action act) throws AILexception {
		   
		Unifier u = new Unifier();
		 
	   if (act.getFunctor().equals("reqRoute") && act.getTermsSize() == 2) {
	   		addPercept(agName, new Predicate("landEmerg"));
	   }  else if (act.getFunctor().equals("enactRoute")) {
	   		addPercept(agName, new Predicate("landEmerg"));
	   		addPercept((Predicate) act.getTerm(0));
	   } else if (act.getFunctor().equals("wait")) {
	   }
	   
	   u.compose(super.executeAction(agName, act));
	   return u;
	}
	

	public PlanLibrary invokeEthicalPlanner(Event e, ListTerm policy) {
		boolean road = random_bool_generator.nextBoolean();
		boolean field_power_lines = random_bool_generator.nextBoolean();
		boolean empty_field = random_bool_generator.nextBoolean();
		boolean field_people = random_bool_generator.nextBoolean();
		
		PlanLibrary pl = new PlanLibrary();

		if (field_power_lines) {
			String plan = "+!landEmerg [achieve] : {True} <- enactRoute(land_in_field_w_power_lines);";
			planfromstring(plan);
			Plan p = pfs.toMCAPL();
	   		ListTermImpl l1 = new ListTermImpl();
	   		l1.add(new Predicate("doNotViolateRoA500Feet"));
	   		l1.add(new Predicate("doNotCollideObjectsOnGround"));
	   		l1.add(new Predicate("doNotCauseDamageToCriticalInfrastructure"));
	   		pl.add(p);
	   		addPercept(new Predicate("power_lines"));
	   	}
		
		if (road) {
			String plan = "+!landEmerg [achieve] : {True} <- enactRoute(land_on_read);";
			planfromstring(plan);
			Plan p = pfs.toMCAPL();
	   		ListTermImpl l1 = new ListTermImpl();
	   		l1.add(new Predicate("doNotViolateRoA500Feet"));
	   		l1.add(new Predicate("doNotCauseDamageToCriticalInfrastructure"));
	   		pl.add(p);			
	   		addPercept(new Predicate("road"));
		}
		
		if (field_people) {
			String plan = "+!landEmerg [achieve] : {True} <- enactRoute(land_in_field_w_people);";
			planfromstring(plan);
			Plan p = pfs.toMCAPL();
	   		ListTermImpl l1 = new ListTermImpl();
	   		l1.add(new Predicate("doNotViolateRoA500Feet"));
	   		l1.add(new Predicate("doNotCollidePeople"));
	   		pl.add(p);						
	   		addPercept(new Predicate("people"));
		}
		
		if (empty_field || pl.getPlans().isEmpty()) {
			String plan = "+!landEmerg [achieve] : {True} <- enactRoute(land_in_empty_field);";
			planfromstring(plan);
			Plan p = pfs.toMCAPL();
			pl.add(p);
	   		addPercept(new Predicate("empty"));
		}
		

		return pl;
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
		return "FuelLowEnvironment";
	}
}
