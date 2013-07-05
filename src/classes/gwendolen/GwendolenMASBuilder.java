// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen;

import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_VarTerm;
import ail.mas.MASBuilder;

import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

/**
 * Utility class.  Builds a Gwendolen MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class GwendolenMASBuilder implements MASBuilder {
	MAS mas;
	
	Abstract_MAS amas;
	
	public GwendolenMASBuilder() {};
	
	public GwendolenMASBuilder(String masstring, boolean filename) {
		if (filename) {
			parsefile(masstring);
		} else {
			parse(masstring);
		}
		mas = amas.toMCAPL();
     }
	
	
	public void parsefile(String masstring) {
		try {
			GwendolenLexer lexer = new GwendolenLexer(new ANTLRFileStream(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GwendolenParser parser = new GwendolenParser(tokens);
    		amas = parser.mas();
      	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

	public void parse(String masstring) {
	   	GwendolenLexer lexer = new GwendolenLexer(new ANTLRStringStream(masstring));
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	GwendolenParser parser = new GwendolenParser(tokens);
    	try {
    		amas = parser.mas();
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}
	/**
	 * Getter method for the resulting MAS.
	 * @return
	 */
	public MAS getMAS() {
		return mas;
	}
	
	public MAS getMAS(String filename) {
		parsefile(filename);

		return amas.toMCAPL();
	}
	

}
