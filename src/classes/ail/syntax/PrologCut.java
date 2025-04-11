// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher 
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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * Note that a Prolog Cut is not a Logical Formula, but appears in the position of one in Prolog programs so I'm hoping this will not cause too
 * much trouble.
 * @author louiseadennis
 *
 */
public class PrologCut implements LogicalFormula {

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {

	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		return new HashSet<String>();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	@Override
	public boolean isGround() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	@Override
	public boolean apply(Unifier theta) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	@Override
	public void makeVarsAnnon() {
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	@Override
	public Unifiable strip_varterm() {
		return new PrologCut();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	@Override
	public Unifiable resolveVarsClusters() {
		return new PrologCut();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(
			EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un,
			Set<String> varnames, AILAgent.SelectionOrder so) {
		return LogExpr.createUnifIterator(un);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public LogicalFormula clone() {
		return new PrologCut();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "!";
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		return this;
	}

	@Override
    public String toString(PredicateDescriptions descriptions ) {
    	return toString();
    }
}
