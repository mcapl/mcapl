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
package hera.language;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import hera.parser.HeraLanguageVisitor;
import hera.parser.HeraLexer;
import hera.parser.HeraParser;

/**
 * Intercept create formula from string method because JPF doesn't support all functions used by antlr4.
 * @author louisedennis
 *
 */
public class JPF_hera_language_Formula extends NativePeer {
	@MJI
	public static void createFormulaFromString__Ljava_lang_String_2__(MJIEnv env, int objref, int sRef) {
		String s = env.getStringObject(sRef);
		HeraLexer lexer = new HeraLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HeraParser parser = new HeraParser(tokens);
		HeraLanguageVisitor visitor = new HeraLanguageVisitor();
		Formula formula = visitor.visitFormula(parser.formula());
		int formula_ref = formula.newJPFObject(env);
				
		env.setReferenceField(objref, "fromStringFormula", formula_ref);
	}

}
