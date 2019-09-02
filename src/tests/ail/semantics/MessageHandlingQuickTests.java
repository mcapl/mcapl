// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.semantics;

import java.util.ArrayList;

import org.junit.Test;

import ail.syntax.Event;
import ail.syntax.Intention;
import ail.syntax.Message;
import ail.syntax.SendAction;
import ail.syntax.Literal;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.syntax.Deed;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.GMessage;
import ail.syntax.VarTerm;
import ail.syntax.Predicate;
import ail.semantics.operationalrules.HandleAddAchieveTestGoalwEvent;

import java.util.Iterator;

import junit.framework.Assert;

public class MessageHandlingQuickTests {
	
	/*
	 * What happens when an intention contains a sent message.  Checking no errors are thrown.
	 */
	@Test public void sentMessageInIntentions() {
		
		SendAction sent = new SendAction(new StringTermImpl("ag1"), 0, new Literal("message"));
		AILAgent a = new AILAgent();
		Message msg = sent.getMessage("ag");
		Intention i = new Intention(new Event(Event.AILAddition, Event.AILSent, msg), new Unifier(), AILAgent.refertoself(), a.getPrettyPrinter());
		a.getIntentions().add(i);
		a.newSentMessage(msg);
		
		Deed d = new Deed(Deed.AILAddition, new Goal("goal"));
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		deeds.add(d);
		
		Guard g = new Guard();
		ArrayList<Guard> guards = new ArrayList<Guard>();
		guards.add(g);
		
		Intention current = new Intention(new Event(Event.AILAddition, Event.AILBel, new Literal("something")), deeds, guards, new Unifier(), a.getPrettyPrinter());
		a.setIntention(current);
		
		a.addBel(new Literal("goal"), AILAgent.refertoself());
		
		HandleAddAchieveTestGoalwEvent rule = new HandleAddAchieveTestGoalwEvent();
		rule.checkPreconditions(a);
		rule.apply(a);
	
	}
	
	@Test public void sentMessageInGuard() {
		SendAction sent = new SendAction(new StringTermImpl("ag1"), 0, new Literal("message"));
		AILAgent a = new AILAgent();
		Message msg = sent.getMessage("ag");
		a.newSentMessage(msg);
		
		Guard g = new Guard(new GMessage(Event.AILSent, 0, new StringTermImpl("ag"), new StringTermImpl("ag1"), new Literal("message")));
		Iterator<Unifier> iun = a.believes(g, new Unifier());
		Assert.assertTrue(iun.hasNext());
	}

	@Test public void sentMessageInGuardwUnification() {
		SendAction sent = new SendAction(new StringTermImpl("ag1"), 1, new Literal("message"));
		AILAgent a = new AILAgent();
		Message msg = sent.getMessage("ag");
		a.newSentMessage(msg);
		
		Unifier u = new Unifier();
		u.unifies(new VarTerm("Name"), new Predicate("ag"));
		u.unifies(new VarTerm("Ag"), new StringTermImpl("ag1"));
		
		Guard g = new Guard(new GMessage(Event.AILSent, 1, new VarTerm("Name"), new VarTerm("Ag"), new Literal("message")));
		Iterator<Unifier> iun = a.believes(g, u);
		Assert.assertTrue(iun.hasNext());
	}
}
