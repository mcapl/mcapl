// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.semantics;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ail.util.AILConfig;
import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Intention;


// Got this far in comment updatign.
import java.util.Random;


/**
 * An EASS Agent - a specialised language for use in Satellite control systems.
 * 
 * @author louiseadennis
 *
 */
public class EASSAgent extends AILAgent { 
	private boolean isAbstraction = false;
	private String abstraction_for;
	
	public static final int TELL = 1;
	public static final int PERFORM = 2;
	public static final int ACHIEVE = 3;

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public EASSAgent(MAS mas, String name) throws AILexception {
		// first we create an AIL Agent.
		super(mas, name);
		//setTrackPlanUsage(false);
		

    // Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		setReasoningCycle(new EASSRC());


		
	}
	
	public EASSAgent(String name) throws AILexception {
		// first we create an AIL Agent.
		super(name);
	//	setTrackPlanUsage(false);
		

    // Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle.  See the GwendolenRC class for how
		// to create a language specific reasoning cycle.  NB. this will
		// change when we get the rules to return state change objects.
		setReasoningCycle(new EASSRC());


		
	}

	public void setAbstraction(String agname) {
		isAbstraction = true;
		abstraction_for = agname;
	}
	
	public boolean isAbstractionEngine() {
		return isAbstraction;
	}
	
	public String getEngineFor() {
		return abstraction_for;
	}
	
	public String getReasoningName() {
		if (isAbstractionEngine()) {
			return getAgName().substring(12);
		} else {
			return getAgName();
		}
	}
 
	public void setAgName(String name) {
		super.setAgName(name);
		if (isAbstractionEngine()) {
			abstraction_for = name.substring(12);
		}
	}
	
    /**
     * Select an intention from a linked list of intentions.
     * Privilege those which don't have actions at the top.
     * 
     * @param intentions
     * @return the selected intention.
     */
    public Intention selectIntention(List<Intention> intentions) {
        // make sure the selected Intention is removed from 'intentions'
        // and make sure no intention will "starve"!!!
    	Iterator<Intention> ii = intentions.iterator();
    	ArrayList<Intention> iiprime = new ArrayList<Intention>();
       	ArrayList<Intention> iiprimeaction = new ArrayList<Intention>();

    	while (ii.hasNext()) {
    		Intention ip = ii.next();
    		// Need a more principled way to handle this with select intention
    		if (!(ip == null) && (ip.empty() || ip.suspended() || ip.hdD().isAction())) {
     			ii.remove();
     			if (! ip.empty()) {
     				if (ip.hdD().isAction()) {
     					iiprimeaction.add(ip);
     				} else {
     					iiprime.add(ip);
     				}
     			}
    		}
    	}
        
    	Intention i;
    	if (intentions.isEmpty()) {
    		if (iiprimeaction.isEmpty()) {
    			i = null;
    		} else {
    			i = iiprimeaction.remove(0);
    		}
    	} else {
    		i = intentions.remove(0);
    	}
    	intentions.addAll(iiprimeaction);
    	intentions.addAll(iiprime);

    	return i;
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.AILAgent#configure(ail.util.AILConfig)
	 */
	@Override
	public void configure(AILConfig config) {
		if (config.containsKey("ail.store_sent_messages")) {
			String store_sent_messages = config.getProperty("ail.store_sent_messages");
			if (store_sent_messages.equals("true")) {
				setStoreSentMessages(true);
			} else {
				setStoreSentMessages(false);
			}
		}
		
	}



}
