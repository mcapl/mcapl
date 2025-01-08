// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
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

package eass;

import eass.parser.EASSAILVisitor;
import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import eass.syntax.ast.Abstract_EASSAgent;
import eass.semantics.EASSAgent;
import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class EASSAgentBuilder implements AgentBuilder {
	EASSAgent agent;
	
	Abstract_EASSAgent abs_agent;
	
	public EASSAgentBuilder() {}

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		agent = abs_agent.toMCAPL();

		return agent;
	}

	
	public void parsefile(String masstring) {
		try {
			EASSLexer lexer = new EASSLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			EASSParser parser = new EASSParser(tokens);

			EASSAILVisitor visitor = new EASSAILVisitor();
    		abs_agent = (Abstract_EASSAgent) visitor.visitEassagent(parser.eassagent());
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

}
