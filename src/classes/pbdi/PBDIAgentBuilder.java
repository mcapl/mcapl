// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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

package pbdi;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Agent;
import pbdi.parser.P3BDIVisitor;
import pbdi.parser.Python3Lexer;
import pbdi.parser.Python3Parser;

public class PBDIAgentBuilder implements AgentBuilder {
	
	AILAgent agent;
	
	Abstract_Agent abs_agent;

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		return new AILAgent("dummy");
	}

	public void parsefile(String masstring) {
		try {
			Python3Lexer lexer = new Python3Lexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			tokens.fill();
	        
	        System.out.println("[TOKENS]");
	        
	        for (Token t : tokens.getTokens()) {
	            System.out.printf("  %-20s %s\n", Python3Lexer.VOCABULARY.getSymbolicName(t.getType()), t.getText());
	        } 

			Python3Parser parser = new Python3Parser(tokens);
			P3BDIVisitor visitor = new P3BDIVisitor();
			
    		abs_agent = (Abstract_Agent) visitor.visitFile_input(parser.file_input());
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
	}
	

}
