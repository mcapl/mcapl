// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package goal;

import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import goal.syntax.ast.Abstract_GOALAgent;
import goal.semantics.GOALAgent;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.CommonTokenStream;
import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;
import ail.mas.MAS;

public class GOALAgentBuilder implements AgentBuilder {
	GOALAgent agent;
	
	Abstract_GOALAgent abs_agent;
	
	public GOALAgentBuilder() {}

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		agent = abs_agent.toMCAPL();

		return agent;
	}

	
	public void parsefile(String masstring) {
		try {
			GOALLexer lexer = new GOALLexer(new ANTLRFileStream(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GOALParser parser = new GOALParser(tokens);
    		abs_agent = parser.goalagent();
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

}
