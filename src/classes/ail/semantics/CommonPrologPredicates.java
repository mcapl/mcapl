// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, and  Michael Fisher 
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

package ail.semantics;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.Rule;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

public class CommonPrologPredicates {
	
	public static List<Rule> nth0() {
		List<Rule> rules = new ArrayList<Rule>();
		
		Rule nth0_0 = gwendolen_parsed_rule("nth0(0, [H|_], H);");
		// missing nonvar check on N
		Rule nth_nonvar = gwendolen_parsed_rule("nth0(N, [_|Tail], Elem):- M is N - 1, nth0(M, Tail, Elem);");
		/*
		 * Missing
		 * nth0(N, [_|Tail], Elem) :-
		 *  var(N)
		 *  nth0(M, T, Elem),
		 *  N is M + 1.
		 */
		rules.add(nth0_0);
		rules.add(nth_nonvar);
		
		return rules;
	}
	
	public static List<Rule> member() {
		List<Rule> rules = new ArrayList<Rule>();
		
		Rule nil_rule = gwendolen_parsed_rule("member(X, []):- false;");
		Rule cons_hd_rule = gwendolen_parsed_rule("member(H, [H | T]);");
		Rule cons_tl_rule = gwendolen_parsed_rule("member(H, [X | T]):- member(H, T);");
		
		rules.add(nil_rule);
		rules.add(cons_hd_rule);
		rules.add(cons_tl_rule);
		
		return rules;
	}
	
	
	private static Rule gwendolen_parsed_rule(String s) {
		GwendolenLexer lexer = new GwendolenLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		try {
			return (Rule) (parser.brule().toMCAPL());
		} catch (Exception e) {
			return null;
		}
	}

	

}
