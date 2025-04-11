// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.mas.eis;

import eis.iilang.Action;
import ail.syntax.Term;
import eis.iilang.Parameter;

import java.util.ArrayList;

public class EISAction {
	Action action;
	
	public EISAction(ail.syntax.Action a) {
		String functor = a.getFunctor();
		ArrayList parameters = new ArrayList<Parameter>();
		if (a.getTerms() != null) {
			for (Term t: a.getTerms()) {
				parameters.add(t.toEISParameter());
			}
		}
		action = new Action(functor, parameters);
	}
	
	public Action getAction() {
		return action;
	}

}
