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

import java.util.List;
import java.util.Set;

import ajpf.PerceptListener;
import ajpf.MCAPLScheduler;
import ail.syntax.Unifier;
import ail.syntax.Message;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.util.AILexception;
import ail.util.AILConfig;
import ail.semantics.AILAgent;


/**
 * An interface to be satisfied by any environment that is to interact with 
 * the AIL classes.  Key aspects are based on the Jason Environment class by 
 * Rafael H. Bordini and Jomi F. Hubner, et al.
 * 
 * @author louiseadennis
 *
 */
public interface AILEnv {//  extends EnvironmentInterfaceStandard { 
	/**
	 * This is the effect of execution of an action on the environment from
	 * the perspective of the environment.
	 * 
	 * @param agName The name of the agent executing the action.
	 * @param act	 The action - an AIL Structure (e.g. a Literal).
	 * @return		 In 3APL it is possible for actions to cause bindings
	 *               in the agent.  Therefore executeAction returns a unifier.
	 *               Obviously this can be an empty unifier.
	 * @throws AILexception The method should throw an exception if the 
	 *               action fails.
	 */
    public Unifier executeAction(String agName, Action act) throws AILexception; 

    /**
     * Returns a list of literals representing beliefs about the environment that the 
     * agent needs to update.  It is understood that this is a complete list of 
     * things the agents perceives to be the case and things it perceives not to be the
     * case in the Environment.  Clearly perceiving things not to be the case is a bit
     * tricky but should be used if something was previously the case and is no longer.
     * 
     * @param agName the name of the agent doing the perceiving.
     *        update flag indicating whether the agent is actually receiving these percepts - necessary to distinguish
     *        between checking properties and actual agent perception.
     * @return A list of structures (predicates) that the agent perceives to be (or not be) the case.
     *         returns null if the agents perceptions have not changed since it last
     *         queried the environment.
     */
    public Set<Predicate> getPercepts(String agName, boolean update);
    
    /**
     * Returns a list of messages sent to the agent since it last checked.
     * 
     * @param AgName the name of the agent.
     * @return the list of messages received since the agent last checked.
     */
    public Set<Message> getMessages(String AgName);
 
    /**
     * If the environment is to be treated as capable of independent action then it needs to indicate
     * when it has finished whatever its doing.  This method is used to indicate
     * when an environment has finished.  If the environment has no separate actions
     * then this should default to true.
     * 
     * @return whether the environment has finished processing.
     */
    public boolean done();
    
    /**
     * Returns the last action performed in the environment.  Used for property checking during verification.
     * 
     * @return  The last action performed in the environement.
     */
    public Action lastAction();
    
    /**
     * Returns the name of the agent who performed the last action in the environment.  Used for property checking
     * during verification.
     * 
     * @return  The agent who  performed the last action.
     */
   public String lastActionby();
          
   /**
    * Allows for environments to be configured by a user based on key/value pairs of inputs from
    * a configuration file.      * 
    * @param config
    */
   public void configure(AILConfig config);
    
   /**
    * Adds a listener to the environment that will be notified when perceptibles change.
    * @param p
    */
   public void addPerceptListener(PerceptListener p);
    
   /**
    * Adds an agent to the environment.
    * @param a
    */
   public void addAgent(AILAgent a);
    
   /**
    * Returns the scheduler which determines which agent gets to reason next.
    * @return
    */
   public MCAPLScheduler getScheduler();
    
   /**
    * Sets the scheduler which determines which agent gets to reason next.
    * @param s
    */
   public void setScheduler(MCAPLScheduler s);
   
   /**
    * Perform any final cleanup needed after the system stops.
    */
   public void cleanup();
   
   /**
    * Perform any initialisation of the environment.  If the set up of the environment object depends
    * at all on the configuration, or parameters, then the set up should be done with this method and
    * not with a constructor.  This is to assist with the assisting classes for MAS building like ail.mas.AIL. 
    */
   public void init_before_adding_agents();
   
   public void init_after_adding_agents();
   
   /**
    * This is for use when actions may take time to execute, specifically when other agents should be
    * allowed to do some execution during the action duration.  This should return true if the environement
    * is currently in the process of executing Action act for agent agName.  In all other circumstances it
    * should return false.
    * @param agName
    * @param act
    * @return
    */
   public boolean executing(String agName, Action act);
   
   /**
    * This is called when the multi-agent system actually starts executing, after all initialisation has
    * taken place.
    */
   public void begin();
   
   /**
    * This is for use when actions may take time to execute, specifically when other agents should be
    * allowed to do some execution during the action duration.  If this is not the case this should return
    * null, similarly if the environment has not processed Action act for String agName then this should return null.
    * It should only return a result if the environment has processed act for agName and the result has
    * not yet been collected.
    * @param agName
    * @param act
    * @return
    */
    public Unifier actionResult(String agName, Action act);
    
    /**
     * Returns true if there are no pending new perceptions or messages for the agent.  Should allow quick
     * updating of perception and message rules.
     * @param agName
     * @return
     */
    public boolean agentIsUpToDate(String agName);
    
    /**
     * Set the mas that this environment is part of.
     * @param m
     */
    public void setMAS(MAS m);
    
    /**
     * Notify percept listeners that something has happened.
     */
    public void notifyListeners();
    
    /**
     * Notify listeners with a particular name that something has happened.
     * @param name
     */
    public void notifyListeners(String name);
    
    /**
     * Return a list of agents in the environment.
     * @return
     */
    public List<AILAgent> getAgents();
}
