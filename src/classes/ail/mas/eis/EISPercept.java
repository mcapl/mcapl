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

import com.igormaznitsa.prologparser.terms.*;
import com.igormaznitsa.prologparser.PrologParser;

import eis.iilang.Percept;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;
import ail.syntax.VarTerm;
import ail.syntax.Term;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ajpf.util.AJPFLogger;
import ail.syntax.NumberTermImpl;

public class EISPercept {
	Percept percept;
	PrologParser parser = new PrologParser(null);
	String logname = "ail.mas.eis.EISPercept";
	
	public EISPercept(Percept p) {
		percept = p;
	}
	
	public Predicate toPredicate() {
		String percept_prolog_string = percept.toProlog() + ".";
		try {
			
			// Need to do proper prolog parsing.
			AbstractPrologTerm plg = parser.nextSentence(percept_prolog_string);
	
			Predicate p = (Predicate) prologToAIL(plg);
			return p;
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		
		return null;

	}
	
	private Term prologToAIL(AbstractPrologTerm plg) {
		PrologTermType type = plg.getType();
		switch ( type ) {
				// NB. Not handling numbers
			case ATOM:
				if (plg instanceof AbstractPrologNumericTerm) {
					return new NumberTermImpl(plg.getText());
				}
				return new Predicate(plg.getText());
			case VAR:
				PrologVariable var = (PrologVariable) plg;
				// Variables make no sense in percepts I _think_ the EIS is supposed to treat them a strings.
				return new StringTermImpl(var.getText());
				// NB. not handling arith expressions
			case STRUCT:
				PrologStructure struct = (PrologStructure) plg;
				Predicate p = new Predicate(struct.getFunctor().getText());
				for (int i = 0; i < struct.getArity(); i++) {
					p.addTerm(prologToAIL(struct.getElement(i)));
				}
				return p;
			case OPERATOR:
			case OPERATORS:
			case LIST:
				PrologList list = (PrologList) plg;
				ListTerm aillist = new ListTermImpl();
				if (! list.isNullList()) {
					aillist.setHead(prologToAIL(list.getHead()));
					aillist.setTail((ListTerm) prologToAIL(list.getTail()));
				}
				return aillist;
			default:
				return new Predicate("none");
		}
		
	}
	
	
	

}
