// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher
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
//----------------------------------------------------------------------------

package ail.syntax;

import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;

/**
 * Represents a logical formula  (a single atom, negation of an atom or a conjunct)
 * that can appear in plan guards and so refers explicitly to beliefs and goals rather
 * than logical predicates.
 * 
 */
public interface GLogicalFormula extends Cloneable, Unifiable {
    /**
     * Checks whether the formula is a
     * logical consequence of the belief base.
     * 
     * Returns an iterator for all unifiers that are consequence.
     */
    public Iterator<Unifier> logicalConsequence(AgentMentalState ag, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so);

    //public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> eb, final RuleBase rb, final Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so);
    //public Iterator<Unifier> logicalConsequence(EvaluationBase, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so);
   
    /**
     * Clone this Formula
     * @return
     */
    public GLogicalFormula clone();
    
}
