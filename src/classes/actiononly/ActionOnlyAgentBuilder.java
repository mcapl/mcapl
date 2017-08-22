// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
import org.antlr.v4.runtime.Token;

import actiononly.parser.ActionOnlyAILVisitor;
import actiononly.parser.ActionOnlyLexer;
import actiononly.parser.ActionOnlyParser;
import actiononly.semantics.ActionOnlyAgent;
import actiononly.syntax.ast.Abstract_ActionOnlyAgent;
import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Agent;
import ajpf.MCAPLcontroller;

/**
 * A class to build action only agents from files.
 * @author lad
 *
 */
public class ActionOnlyAgentBuilder implements AgentBuilder {
	AILAgent agent;
	
	Abstract_Agent abs_agent;
	
	public ActionOnlyAgentBuilder() {}

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		try {
			abs_agent.getAgName();
		} catch (Exception e) {
		}
		
		try {
			ActionOnlyAgent agent = new ActionOnlyAgent(abs_agent.getAgName());
			((Abstract_ActionOnlyAgent) abs_agent).addStructures(agent);
	    	try {
	    		agent.initAg();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return agent;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("returning null");
			return null;
		}
	}

	
	public void parsefile(String masstring) {
		try {
//			String input = MCAPLcontroller.getStringFromFile(masstring);
			ActionOnlyLexer lexer = new ActionOnlyLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			tokens.fill();
	        
/*	        System.out.println("[TOKENS]");
	        
	        for (Token t : tokens.getTokens()) {
	            System.out.printf("  %-20s %s\n", ActionOnlyLexer.VOCABULARY.getSymbolicName(t.getType()), t.getText());
	        } */

			ActionOnlyParser parser = new ActionOnlyParser(tokens);
			ActionOnlyAILVisitor visitor = new ActionOnlyAILVisitor();
			
    		abs_agent = (Abstract_Agent) visitor.visitAoagent(parser.aoagent());
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

}
