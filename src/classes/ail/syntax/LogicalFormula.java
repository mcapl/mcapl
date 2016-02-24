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

package ail.syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;

/**
 * Represents a logical formula (p, p & q, not p, 3 > X, ...) which can be 
 * evaluated into a truth value against some base - e.g., the belief base or
 * goal base.  Heavily based on the Jason implementation.
 * 
 * @author Jomi
 */
public interface LogicalFormula extends Cloneable, Unifiable {
    /**
     * Checks whether the formula is a
     * logical consequence of the belief base.
     * 
     * Returns an iterator for all unifiers that are consequence.
     */
    public Iterator<Unifier> logicalConsequence(EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so);
    
    /**
     * Clone this Formula
     * @return
     */
    public LogicalFormula clone();
     
}
