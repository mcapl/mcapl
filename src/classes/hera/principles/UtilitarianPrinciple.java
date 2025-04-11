// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
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

package hera.principles;

import java.util.ArrayList;

import hera.language.And;
import hera.language.BooleanFormula;
import hera.language.Formula;
import hera.language.Geq;
import hera.language.Term;
import hera.language.U;
import hera.semantics.CausalModel;
import hera.semantics.Model;

/**
 * Formulation of the Utilitarian principle for use in Hera Reasoning.
 * @author louisedennis
 *
 */
public class UtilitarianPrinciple extends Principle {
	
	/**
	 * Constructor.
	 */
	public UtilitarianPrinciple() {
		label = "Utilitarianism";
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#_check()
	 */
	@Override
	public ArrayList<Boolean> _check() {
		// CausalModel cmodel = (CausalModel) model;
		Term u = new U(Formula.makeConjunction(((CausalModel) model).getAllConsequences()));
		//System.err.println(u);
		ArrayList<Term> v = new ArrayList<Term>();
		for (Model w: model.alternatives) {
			if (! model.equals(w)) {
				v.add(new U(Formula.makeConjunction(((CausalModel) w).getAllConsequences())));
			}
		}
		
		Formula f = null;
		for (Term w: v) {
			// System.err.println(w);
			if (f == null ) {
				f = new Geq(u, w);
			} else {
				f = new And(f, new Geq(u, w));
			}
		}
		
		if (f == null) {
			f = new BooleanFormula(true);
		}
		
		formulae.add(f);
		result.add(model.models(f));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#permissible()
	 */
	@Override
	public int permissible() {
		_check();
		boolean perm = result.get(result.size() - 1);
		if (perm) {
			return PERMISSIBLE;
		} else {
			return NOT_PERMISSIBLE;
		}
	}

}
