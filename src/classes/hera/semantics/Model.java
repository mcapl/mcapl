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
package hera.semantics;

import java.util.ArrayList;

import hera.language.Formula;

/**
 * A Hera model.
 * @author louisedennis
 *
 */
public class Model {
	Double probability;
	public ArrayList<Model> alternatives = new ArrayList<Model>();
	ArrayList<Model> epistemic = new ArrayList<Model>();
	protected Checker checker;
	
	// Introducing caches of formulae known to be true or false in the model in an attempt to improve efficiency.
	// NB.  Did not seem to improve efficiency much but can not, at this point, be bothered to remove them.
	protected ArrayList<Formula> cache = new ArrayList<Formula>();
	protected ArrayList<Formula> falsecache = new ArrayList<Formula>();
	
	public boolean models(Formula f) {
		return checker.models(this, f);
	}
	
	public double degBelief(Formula f) {
		double p = 0;
		for (Model e : epistemic) {
			if (e.models(f)) {
				p = p + e.probability;
			}
		}
		return p;
	}
	
	public void setAlternatives(ArrayList<Model> alternatives) {
		this.alternatives = alternatives;
	}
	
	public ArrayList<Model> getAlternatives(Formula f) {
		if (f == null) {
			return alternatives;
		}
		
		ArrayList<Model> r = new ArrayList<Model>();
		for (Model w: alternatives) {
			if (w.models(f)) {
				r.add(w);
			}
		}
		return r;
	}
	
	public void setEpistemicAlternatives(ArrayList<Model> alternatives) {
		this.epistemic = alternatives;
	}
	
	public ArrayList<Model> getEpistemicAlternatives(Formula f) {
		if (f == null) {
			return epistemic;
		}

		ArrayList<Model> r = new ArrayList<Model>();
		for (Model w: epistemic) {
			if (w.models(f)) {
				r.add(w);
			}
		}
		return r;
	}
	
	public void setProbability(double p) {
		probability = p;
	}
	
	/**
	 * Cache a formula as either true or false.  By default this does nothing.
	 * @param b
	 * @param f
	 */
	public void cacheFormula(boolean b, Formula f) {};

}
