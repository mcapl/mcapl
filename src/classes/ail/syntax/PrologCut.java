// ----------------------------------------------------------------------------
// Copyright (C) Louise A. Dennis and Michael Fisher 
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Note that a Prolog Cut is not a Logical Formula, but appears in the position of one in Prolog programs so I'm hoping this will not cause too
 * much trouble.
 * @author louiseadennis
 *
 */
public class PrologCut implements LogicalFormula {

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {

	}

	@Override
	public List<String> getVarNames() {
		return new ArrayList<String>();
	}

	@Override
	public void renameVar(String oldname, String newname) {
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof PrologCut) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isGround() {
		return true;
	}

	@Override
	public boolean apply(Unifier theta) {
		return true;
	}

	@Override
	public void makeVarsAnnon() {
	}

	@Override
	public Unifiable strip_varterm() {
		return new PrologCut();
	}

	@Override
	public Unifiable resolveVarsClusters() {
		return new PrologCut();
	}

	@Override
	public Iterator<Unifier> logicalConsequence(
			EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un,
			List<String> varnames) {
		return LogExpr.createUnifIterator(un);
	}

	@Override
	public LogicalFormula clone() {
		return new PrologCut();
	}
	
	@Override
	public String toString() {
		return "!";
	}

}
