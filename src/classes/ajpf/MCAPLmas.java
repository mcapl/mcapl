// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf;

import java.util.List;

import ajpf.psl.MCAPLFormula;

/**
 * Interface to be implemented by a specific multi-agent system.
 * 
 * @author louiseadennis
 *
 */
public interface MCAPLmas {
	/**
	 * List the agents present in the MAS.
	 * 
	 * @return a list of objects implementing the MCAPLLanguageAgent interface.
	 */
	public List<MCAPLLanguageAgent> getMCAPLAgents(); 
	
	/**
	 * Start the system.
	 * 
	 * @param flag indicates whether or not this is being invoked on a model
	 * checking run.
	 */
	//public void MCAPLstart();
	
	/**
	 * Add a listener for waking agents to the system.
	 * 
	 * @param l the listener.
	 */
	public void addPerceptListener(PerceptListener l);
		
	/**
	 * This agent is now asleep;
	 * @param AgName
	 */
    ///public void addAsleep(String AgName);
        
    /**
     * All the agents and the environment have finished executing.
     * @return
     */
    public boolean alldone();
    
    /**
     * The agent named, a, has nothing left to do.
     * @param a
     * @return
     */
    //public boolean alldonefor(String a);
    
    /**
     * Stop all the agents - or at least inform them they need to stop.
     *
     */
    public void stopAgs();
    
    /**
     * Succeeds if the last action executed was agent ag doing f.
     * The implementation of this method defines the semantics of action in the Property Specificaiton
	 * Languages.

     * @param ag
     * @param f
     * @return
     */
    public boolean lastActionWas(String ag, MCAPLFormula f);
    
    /**
     * Succeeds if f is perceptable in the environment.  The implementation of t his method defines the
     * semantics of perceptible in the Property Specification Language.
     * @param f
     * @return
     */
    public boolean hasPercept(MCAPLFormula f);
    
    public MCAPLScheduler getScheduler();
    
    public MCAPLcontroller getController();
    
    public void setController(MCAPLcontroller mc);
    
    /**
     * Sets a debugging outputlevel for the MAS.
     * @param i
     */
   // public void setOutputLevel(int i);
    
   // public void cleanup();
 
}
