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

import com.igormaznitsa.prologparser.terms.PrologStructure;

import eis.iilang.Percept;

import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;

public class EISPercept {
	Percept percept;
	
	public EISPercept(Percept p) {
		percept = p;
	}
	
	public Predicate toPredicate() {
		String percept_prolog_string = arg1.toString();
		try {
			
			// Need to do proper prolog parsing.
			PrologStructure plg = (PrologStructure) parser.nextSentence(percept_prolog_string);
	
			Predicate p = new Predicate(plg.getFunctor().toString());
			for (int i = 1; i <= plg.getArity(); i++) {
				p.addTerm(new Predicate(plg.getElement(i).toString()));
			}
			(agentpercepts.get(arg0)).add(p);
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}

	}
	
	
	

}
