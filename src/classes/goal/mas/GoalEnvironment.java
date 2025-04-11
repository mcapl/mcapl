// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.mas;

import ail.semantics.AILAgent;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import goal.semantics.GOALAgent;
import goal.syntax.GoalMessage;
import gov.nasa.jpf.annotation.FilterField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ail.mas.AILEnv;
import ail.mas.DefaultEnvironment;

/**
 * An environment for Goal Agents with the semantics or GOAL with communication as developed by Hindriks and
 * van Riemsdijk from "A Computational Semantics for Communicating Rational Agents
 * Based on Mental Models", ProMAS'09, 2009.
 * 
 *  This handles the creation, selection and removal of conversatoins and conversation ids
 *  as specified in the above paper.
 * @author louiseadennis
 *
 */
public class GoalEnvironment extends DefaultEnvironment implements GOALEnv { 
	
	/**
	 * Name for logging.
	 */
	@FilterField
	String logname = "goal.mas.GoalEnvironment";


	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#getPercepts(java.lang.String, boolean)
	 */
	@Override
	public Set<Predicate> getPercepts(String agName, boolean update) {
    	Set<Predicate> agl = agPercepts.get(agName);
    	Set<Predicate> p = new HashSet<Predicate>();
    		
    	if (! percepts.isEmpty()) { // has global perception?
    		for (Predicate per: percepts) {
    			p.add((Predicate) per.clone());
    		}
    	}
    				
    	if (agl != null) { // add agent personal perception
    		p.addAll(agl);
    	}
     	return p;
		
	}
	
	@Override
	public void init_after_adding_agents() {
		sendEnvironmentAgentBeliefs(this);
	}
	
	public static void sendEnvironmentAgentBeliefs(AILEnv e) {
		List<Literal> agentlist = new ArrayList<Literal>();
		
		for (AILAgent ag: e.getAgents()) {
			GOALAgent gag =  (GOALAgent) ag;
			Literal me = new Literal("me");
			me.addTerm(new Predicate(gag.getAgName()));
			gag.addBel(me, gag.refertoself());
			
			Literal agent = new Literal("agent");
			agent.addTerm(new Predicate(gag.getAgName()));
			agentlist.add(agent);
		}
		
		for (AILAgent ag: e.getAgents()) {
			for (Literal l: agentlist) {
				ag.addBel(l, ag.refertoself());
			}
		}
	}

	@Override
	public void postMessage(GoalMessage m) {
		for (String ag: m.getReceivers()) {
			this.addMessage(ag, m);
			
		   	System.err.println(m.getSender() + " done " + printAction(m));

		}
	}
	
	private String printAction(GoalMessage m) {
		String s = "send(";
		s += m.toTerm().toString();
		s += ")";
		return s;
		
	}
	

}
