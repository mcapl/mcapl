// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.mas;

import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.BroadcastSendAction;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifySet;
import goal.syntax.GoalMessage;
import gov.nasa.jpf.vm.Verify;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import ail.mas.AILEnv;
import ail.mas.scheduling.ActionScheduler;
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
public class GoalEnvironment extends DefaultEnvironment { 

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
	

}
