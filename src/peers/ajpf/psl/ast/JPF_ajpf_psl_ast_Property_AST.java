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

import ajpf.psl.MCAPLProperty;
import ajpf.psl.parser.A_PSLParser;
import ajpf.psl.parser.AJPF_PSLVisitor;
import ajpf.psl.parser.A_PSLLexer;

import ajpf.MCAPLmas;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ajpf.MCAPLcontroller;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Interface for formulas in the MCAPL Property Specification Language.
 * 
 * @author louiseadennis
 *
 */
public class JPF_ajpf_psl_ast_Property_AST extends NativePeer {
//	static Abstract_Property property;
		
	  @MJI
	public static void parse__Ljava_lang_String_2__ (MJIEnv env, int objref, int propertyRef) {
		String propertystring = env.getStringObject(propertyRef);
		A_PSLLexer psllexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		CommonTokenStream psltokens = new CommonTokenStream(psllexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		try {
			Abstract_Property property = visitor.visitSpec(pslparser.spec()); 
			Abstract_Property np = property.toNormalForm();
			createProperty(env, objref, np);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createProperty (MJIEnv env, int objref, Abstract_Property property) {
		int ref = property.newJPFObject(env);
		env.setReferenceField(objref, "property", ref);
	}

}