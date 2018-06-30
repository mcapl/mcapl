// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.ast;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ajpf.psl.MCAPLProperty;
import ajpf.psl.parser.A_PSLParser;
import ajpf.psl.parser.AJPF_PSLVisitor;
import ajpf.psl.parser.A_PSLLexer;

/**
 * This is wrapper class for the Abstract Syntax Tree for some property.  It basically provides support for parsing 
 * the property.
 * 
 * @author louiseadennis
 *
 */
public class Property_AST {
	Abstract_Property property;
		
	/**
	 * Parse a string into an abstract property.
	 * @param propertystring
	 */
	public void parse(String propertystring) {
		A_PSLLexer psllexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(psllexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		try {
			Abstract_Property prop = visitor.visitSpec(pslparser.spec()); 
			// Drive all the Not's inwards to the propositions.
			property = prop.toNormalForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
			
	/**
	 * Convert the abstract property into a concrete property in the native java virtual machine.
	 * @return
	 */
	public MCAPLProperty toMCAPLNative() {
		return property.toMCAPLNative();
	}
	
}