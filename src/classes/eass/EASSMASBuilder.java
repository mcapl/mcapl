// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass;

import ail.mas.MAS;
import ail.mas.MASBuilder;
import ail.syntax.ast.Abstract_MAS;
import eass.parser.EASSAILVisitor;
import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Utility class.  Builds an EASS MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class EASSMASBuilder implements MASBuilder {
	MAS mas;
	
	Abstract_MAS amas;
	
	public EASSMASBuilder() {
	}
	
	public MAS getMAS(String filename, String tracedir) {
		parsefile(filename);
		mas = amas.toMCAPL(tracedir);
		// System.err.println("got MAS");
		return mas;
	}

	public EASSMASBuilder(String masstring, boolean filename) {
		if (filename) {
			parsefile(masstring);
		} else {
			parse(masstring);
		}
		mas = amas.toMCAPL(null);
	}
	
	public void parsefile(String masstring) {
		try {
			EASSLexer lexer = new EASSLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			EASSParser parser = new EASSParser(tokens);
			EASSAILVisitor visitor = new EASSAILVisitor();

    		amas = (Abstract_MAS) visitor.visitMas(parser.mas());
 
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

	public void parse(String masstring) {
    	try {
			EASSLexer lexer = new EASSLexer(CharStreams.fromString(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			EASSParser parser = new EASSParser(tokens);

			EASSAILVisitor visitor = new EASSAILVisitor();
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
	

}
