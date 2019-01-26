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

import hera.language.Formula;

/**
 * Abstract class for checkers of Hera models.
 * @author louisedennis
 *
 */
public abstract class Checker {
	
	/**
	 * Does formula f hold in model model?
	 * @param model
	 * @param f
	 * @return
	 */
	public abstract boolean models(Model model, Formula f);
	
	public boolean _trueInEveryAlternative(Model model, Formula f) {
		for (Model m : model.epistemic) {
			if (!m.models(f)) {
				return false;
			}
		}
		return true;
	}

}
