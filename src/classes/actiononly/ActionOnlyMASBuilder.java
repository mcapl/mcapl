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

package actiononly;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import actiononly.parser.ActionOnlyAILVisitor;
import actiononly.parser.ActionOnlyLexer;
import actiononly.parser.ActionOnlyParser;
import ail.mas.MAS;
import ail.mas.MASBuilder;
import ail.syntax.ast.Abstract_MAS;

/**
 * Utility class.  Builds an Action Only MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class ActionOnlyMASBuilder implements MASBuilder {
	MAS mas;
	
	Abstract_MAS amas;
	
	public ActionOnlyMASBuilder() {};
	
	public ActionOnlyMASBuilder(String masstring, boolean filename) {
		if (filename) {
			parsefile(masstring);
		} else {
			parse(masstring);
		}
		mas = amas.toMCAPL(null);
     }
	
	
	public void parsefile(String masstring) {
		try {
			ActionOnlyLexer lexer = new ActionOnlyLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ActionOnlyParser parser = new ActionOnlyParser(tokens);
			ActionOnlyAILVisitor visitor = new ActionOnlyAILVisitor();
			
    		amas = (Abstract_MAS) visitor.visitMas(parser.mas());
      	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

	public void parse(String masstring) {
	   	ActionOnlyLexer lexer = new ActionOnlyLexer(CharStreams.fromString(masstring));
	   	CommonTokenStream tokens = new CommonTokenStream(lexer);
	   	ActionOnlyParser parser = new ActionOnlyParser(tokens);
	   	ActionOnlyAILVisitor visitor = new ActionOnlyAILVisitor();
		
		amas = (Abstract_MAS) visitor.visitMas(parser.mas());
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
