// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal;

import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.mas.MASBuilder;
import ail.syntax.ast.Abstract_MAS;

import goal.parser.GOALLexer;
import goal.parser.GOALParser;

/**
 * Utility class.  Builds a GOALC MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class GOALMASBuilder implements MASBuilder {
	MAS mas;
	
	Abstract_MAS amas;
	
	public GOALMASBuilder() {}
	
	public GOALMASBuilder(String masstring, boolean filename) {
		if (filename) {
			parsefile(masstring);
		} else {
			parse(masstring);
		}
		mas = amas.toMCAPL();
	}

		
	public void parse(String masstring) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(masstring));
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	GOALParser parser = new GOALParser(tokens);
    	try {
    		amas = parser.mas();
    	} catch (Exception e) {
    		System.err.println(e);
    	}
    }
	
	public void parsefile(String filename) {
		try {
			GOALLexer lexer = new GOALLexer(new ANTLRFileStream(filename));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GOALParser parser = new GOALParser(tokens);
			amas = parser.mas();
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	public MAS getMAS(String filename) {
		parsefile(filename);
		mas = amas.toMCAPL();
		return mas;
	}
	
	/**
	 * Getter method for the resulting MAS.
	 * @return
	 */
	public MAS getMAS() {
		return mas;
	}
	

}
