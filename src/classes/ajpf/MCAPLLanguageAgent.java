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

import ajpf.psl.MCAPLFormula;

/**
 * Interface to be implemented by agents in specific APLs.
 * 
 * @author louiseadennis
 *
 */
public interface MCAPLLanguageAgent {
	/**
	 * One reasoning step.  This defines the transition between which
	 * properties should be checked.  In AIL this is one full reasoning
	 * cycle, but this need not be the case.
	 */
	public void MCAPLreason();   
	
	/**
	 * Indicates whether the agent should continue reasoning or not.
	 * 
	 * @return whether or not the agent should continue reasoning.
	 */
	public boolean MCAPLcontinueRunning();
	
	/**
	 * The name of the agent.
	 * 
	 * @return the name of the agent.
	 */
	public String getMCAPLAgName();
	
	/**
	 * Whether the agent believes a formula phi.  The implementation
	 * of this method defines the semantics of belief in the 
	 * Property Specification Language.
	 * 
	 * @param phi	The formula to be checked for belief.
	 * @return		whether the agent believes the formula.
	 */
	public boolean MCAPLbelieves(MCAPLFormula phi);
	
	/**
	 * Succeeds if the agent has a goal phi.  The implementation of this
	 * method defines the semantics of goals in the Property Specification
	 * Language.
	 * 
	 * @param phi the goal.
	 * @return whether the agent has the goal.
	 */
	public boolean MCAPLhasGoal(MCAPLFormula phi);
	
	/**
	 * Succeeds if the agent has an intention phi.  The implementation of this
	 * method defines the semantics of intentions in the Property Specificaiton
	 * Language.
	 * @param phi the intention.
	 * @return
	 */
	public boolean MCAPLhasIntention(MCAPLFormula phi);
	
	/**
	 * Succeeds if the agent intends to perform some action phi.  The implementation
	 * of this method defines the semantics of intends to do in the Property Specification
	 * Language.
	 * @param phi
	 * @return
	 */
	public boolean MCAPLintendsToDo(MCAPLFormula phi);
	
	/**
	 * Succeeds if the agent "wants to sleep" - typically envisaged for when the 
	 * agent has nothing left to do.
	 * @return
	 */
	public boolean MCAPLwantstosleep();
	
	/**
	 * Tells the agent it is now awake.
	 *
	 */
	public void MCAPLtellawake();
	
}
