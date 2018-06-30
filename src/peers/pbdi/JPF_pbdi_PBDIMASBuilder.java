// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and Michael Fisher 
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

package pbdi;

import ail.syntax.ast.Abstract_MAS;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.NativePeer;
import pbdi.parser.P3BDIVisitor;
import pbdi.parser.Python3Lexer;
import pbdi.parser.Python3Parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Utility class.  Builds an Action Only MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class JPF_pbdi_PBDIMASBuilder extends NativePeer {
	
	@MJI
	public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
 		try {
 			Python3Lexer lexer = new Python3Lexer(CharStreams.fromFileName(masstring));
 			CommonTokenStream tokens = new CommonTokenStream(lexer);
 			Python3Parser parser = new Python3Parser(tokens);
 			P3BDIVisitor visitor = new P3BDIVisitor();

 			Abstract_MAS amas = (Abstract_MAS) visitor.visitFile_input(parser.file_input());
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
