// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis,  Michael Fisher, and Matt Webster
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
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------


package gwendolen.auctions;

import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.ActionScheduler;
import ail.util.AILexception;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;

/**
 * Environment for an Auction.
 * 
 * @author louiseadennis
 *
 */
public class AuctionEnv extends DefaultEnvironment {
	
	/**
	 * Two performatives, perform and tell.
	 */
	public static byte performILF = 0;
	public static byte tellILF = 1;
	
	// @FilterField
	private Literal winlit;

	/**
	 * Constructor.
	 *
	 */
	public AuctionEnv() {
		super();
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
	}

	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();
	   	if (act.getFunctor().equals("win")) {
	   		Literal win = new Literal(Literal.LPos, act.getFunctor());
	   		win.addTerm(act.getTerm(0));
	   		win.addTerm(act.getTerm(1));
	   		
	   		if (winlit != null) {
	   			removePercept(winlit);
	   		}
	   		winlit = win;
	   		addPercept(win);
	   	}
	   	try {
	   		theta = super.executeAction(agName, act);
    	} catch (AILexception e) {
    		throw e;
    	}

    	return theta;
    }
   
   /**
    * Overrides a function in Default environment and pretty prints performatives nicely.
    */
   public String ilfString(int ilf) {
	   if (ilf == tellILF) {
		   return "tell:";
	   } else {
		   return "perform:";
	   }
   }


}
