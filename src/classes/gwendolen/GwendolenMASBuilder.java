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

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.mas.MASBuilder;
import ail.syntax.ast.Abstract_MAS;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.parser.GwendolenAILVisitor;


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
		mas = amas.toMCAPL(null);
     }
	
	
	public void parsefile(String masstring) {
		try {
			//System.out.println(masstring);
			GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GwendolenParser parser = new GwendolenParser(tokens);
			GwendolenAILVisitor visitor = new GwendolenAILVisitor();
			
    		amas = (Abstract_MAS) visitor.visitMas(parser.mas());
      	} catch (Exception e) {
     		e.printStackTrace();
    	}
		 
	}

	public void parse(String masstring) {
		GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(masstring));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
    	try {
    		amas = (Abstract_MAS) visitor.visitMas(parser.mas());
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
	
	public MAS getMAS(String filename, String tracedir) {
		parsefile(filename);

		return amas.toMCAPL(tracedir);
	}
	

}
