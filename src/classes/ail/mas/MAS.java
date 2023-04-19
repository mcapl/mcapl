// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.mas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.ast.GroundPredSets;
import ail.util.AILConfig;
import ajpf.MCAPLLanguageAgent;
import ajpf.MCAPLScheduler;
import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.PerceptListener;
import ajpf.psl.MCAPLFormula;
import ajpf.psl.MCAPLPredicate;
import ajpf.util.VerifyMap;

/**
 * AIL's view of a multi-agent system.  Based on the Jason MAS class written by
 * Rafael H. Bordine and Jomi F. Hubner.  Implments the MCAPLmas interface.
 * 
 * @author louiseadennis
 *
 */
public class MAS implements MCAPLmas {

	/**
	 * The environment. 
	 */
    AILEnv           	fEnv         	= null;
 
	/**
     * The agents in the MAS indexed by agent name.
     */
    Map<String,AILAgent> 	fAgents    		= new VerifyMap<String,AILAgent>();
    
    /**
     * The overall controller this MAS is running in.
     */
    MCAPLcontroller controller;
    
    /**
     * The directory to store traces in, if any (null if we should not trace)
     */
    String traceDir = null;
    	   
 
    /**
     * Constructor.
     */
    public MAS() {
    }
    
    /**
     * Constructor/
     * 
     * @param env the environment.
     */
    public MAS(AILEnv env) {
    	fEnv = env;
    }
    
    /**
     * @return The directory to store traces in, if any (null if we should not trace)
     */
    public String getTraceDir() {
    	return traceDir;
    }
    
    /**
     * @param dir The directory to store traces in, if any (null if we should not trace)
     */
	public void setTraceDir(String dir) {
		traceDir = dir;
	}
     
	   
	/** 
	 * Setter for the environment.  As a side effect this adds all the agents to the environment.
	 * @param env
	 */
	public void setEnv(AILEnv env) {
    	fEnv = env;
    	// env.setMAS(this);
    	for (AILAgent a: getAgs().values()) {
    		a.setEnv(env);
    		fEnv.addAgent(a);
    	}
     }
    

    /**
     * Getter method for the systems environment.
     * 
     * @return the system's environment.
     */
    public AILEnv getEnv() {
    	return fEnv;
    }
 
    /**
     * Add a new agent to the multi-agent system.
     * 
     * @param ag 
     */
    public void addAg(AILAgent ag) {
     	ag.setMAS(this);
    	fAgents.put(ag.getAgName(), ag);
     }

    /**
     * Remove an agent from the multi-agent system.
     * 
     * @param agName The name of the agent to be removed.
     * @return The <code>AgArch</code> object for the removed agent.
     */
    public AILAgent delAg(String agName) {
    	return fAgents.remove(agName);
    }
    
    /**
     * Get an agent in the multi-agent system.
     * 
     * @param agName The name of the agent wanted.
     * @return The <code>AgArch</code> object for the removed agent.
     */
    public AILAgent getAg(String agName) {
    	return fAgents.get(agName);
    }
    
    /**
     * Getter method for the agents.
     * 
     * @return the indexed set of agents.
     */
    protected Map<String,AILAgent> getAgs() {
    	return fAgents;
    }
    
    /**
     * Allows configuration of parameters within environments for individual applications,
     * if desired.
     * @param configuration
     */
    public void configure(AILConfig config) {
    	for (AILAgent ag: fAgents.values()) {
    		ag.configure(config);
    	}
    }

  
    // MCAPLmas Interface methods.
    
    /*
     * (non-Javadoc)
     * @see ajpf.MCAPLmas#addPerceptListener(ajpf.PerceptListener)
     */
	public void addPerceptListener(PerceptListener l) {
		fEnv.addPerceptListener(l);
	}

    
    /**
     * Get the agents from the multi-agent system.  The implementation is
     * slightly complicated by the need to cast the agents into (MCAPLLanguageAgent)
     * otherwise we could have used getAgs.
     */
    public List<MCAPLLanguageAgent> getMCAPLAgents() {
    	List<MCAPLLanguageAgent> agents = new ArrayList<MCAPLLanguageAgent>();
    	for (AILAgent ag : fAgents.values()) {
    		agents.add((MCAPLLanguageAgent) ag);
    	}
     	return(agents);
    }
    	
    /*
     * (non-Javadoc)
     * @see ajpf.MCAPLmas#alldone()
     */
    public boolean alldone() {
    	return (fEnv.done());
    }
    
    public void begin() {
    	fEnv.begin();
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.MCAPLmas#stopAgs()
     */
    public void stopAgs() {
    	for (AILAgent ag : fAgents.values()) {
    		ag.stop();
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see mcapl.MCAPLmas#lastActionWas(java.lang.String, mcapl.psl.MCAPLFormula)
     */
    public boolean lastActionWas(String a, MCAPLFormula fmla) {
    	String s = fEnv.lastActionby();
    	if (s != null) {
    	if (s.equals(a)) {
     		Predicate st = fEnv.lastAction();
    		    		
    		
    		Unifier u = new Unifier();
    		if (u.unifies(st, new Predicate((MCAPLPredicate) fmla))) {
    			return true;
    		}
    	}
    	}
    	
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see mcapl.MCAPLmas#hasPercept(mcapl.psl.MCAPLFormula)
     */
    public boolean hasPercept(MCAPLFormula fmla) {
    	for (AILAgent ag: fAgents.values()) {
    		// System.err.println("Getting Percepts" + fEnv);
     	Set<Predicate> set = fEnv.getPercepts(ag.getAgName(), false);
    		if (set != null) {
    			for (Predicate s: set) {
    				if (s.equals(new Predicate((MCAPLPredicate) fmla))) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    		// System.err.println("converting mas to string");
    		String s = fEnv.toString();
    		// System.err.println(s);
    		for (AILAgent a : fAgents.values()) {
    			s += "\n" + a.toString();
    			System.err.println(s);
    		}
    		return s;
    }
          
     /*
      * (non-Javadoc)
      * @see ajpf.MCAPLmas#getScheduler()
      */
     public MCAPLScheduler getScheduler() {
    	 return fEnv.getScheduler();
     }
     
     /**
      * Perform any application specific finalisation.
      */
     public void cleanup() {
    	 fEnv.cleanup();
    	 GroundPredSets.clear();
     }
     
     /*
      * (non-Javadoc)
      * @see ajpf.MCAPLmas#getController()
      */
     public MCAPLcontroller getController() {
    	 return controller;
     }
     
     /*
      * (non-Javadoc)
      * @see ajpf.MCAPLmas#setController(ajpf.MCAPLcontroller)
      */
     public void setController(MCAPLcontroller mc) {
    	 controller = mc;
     }
}
