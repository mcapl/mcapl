// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis,  and Michael Fisher
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

import ail.syntax.ast.Abstract_MAS;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.NativePeer;
import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

/**
 * Utility class.  Builds a Gwendolen MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class JPF_gwendolen_GwendolenMASBuilder extends NativePeer {
	
	  @MJI
	public static void parse__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
		GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(masstring));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
    	try {
    		Abstract_MAS amas = (Abstract_MAS) visitor.visitMas(parser.mas());
    		int ref = amas.newJPFObject(env);
			env.setReferenceField(objref, "amas", ref);
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

	  @MJI
	public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
 		try {
  			GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromFileName(masstring));
 			CommonTokenStream tokens = new CommonTokenStream(lexer);
 			GwendolenParser parser = new GwendolenParser(tokens);
 			GwendolenAILVisitor visitor = new GwendolenAILVisitor();
 	   		Abstract_MAS amas = (Abstract_MAS) visitor.visitMas(parser.mas());
 	   		// System.err.println("done parsing");
			int ref = amas.newJPFObject(env);
			env.setReferenceField(objref, "amas", ref);
		} catch (ClinitRequired e) {
			env.repeatInvocation();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
