// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
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
		//System.err.println("GOALAGENTBUILDER: A");
		parsefile(filename);
		//System.err.println("GOALAGENTBUILDER: b");
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
