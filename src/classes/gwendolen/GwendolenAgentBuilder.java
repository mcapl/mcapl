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

package gwendolen;

import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;
import gwendolen.semantics.GwendolenAgent;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStreams;

import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;

public class GwendolenAgentBuilder implements AgentBuilder {
	GwendolenAgent agent;
	
	Abstract_GwendolenAgent abs_agent;
	
	public GwendolenAgentBuilder() {}

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		agent = abs_agent.toMCAPL();

		return agent;
	}

	
	public void parsefile(String masstring) {
		try {
			GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GwendolenParser parser = new GwendolenParser(tokens);
			
			GwendolenAILVisitor visitor = new GwendolenAILVisitor();
    		abs_agent = (Abstract_GwendolenAgent) visitor.visitGwendolenagent(parser.gwendolenagent());
     	} catch (Exception e) {
     		e.printStackTrace(); 
    	}
		
	}

}
