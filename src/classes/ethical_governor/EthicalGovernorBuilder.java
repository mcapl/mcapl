// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
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

package ethical_governor;

import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.CommonTokenStream;
import ail.mas.AgentBuilder;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Agent;

import ethical_governor.parser.EthicalGovernorLexer;
import ethical_governor.parser.EthicalGovernorParser;
import ethical_governor.semantics.EthicalGovernor;
import ethical_governor.syntax.ast.Abstract_EthicalGovernor;

/**
 * A class to build an ethical governor from a progrma file.
 * @author lad
 *
 */
public class EthicalGovernorBuilder implements AgentBuilder {
	AILAgent agent;
	
	Abstract_Agent abs_agent;
	
	public EthicalGovernorBuilder() {}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AgentBuilder#getAgent(java.lang.String)
	 */
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		try {
			EthicalGovernor agent = new EthicalGovernor(abs_agent.getAgName());
	    	((Abstract_EthicalGovernor) abs_agent).addStructures(agent);
	    	
	    	return agent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Parse the file.
	 * @param masstring
	 */
	public void parsefile(String masstring) {
		try {
			EthicalGovernorLexer lexer = new EthicalGovernorLexer(new ANTLRFileStream(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			EthicalGovernorParser parser = new EthicalGovernorParser(tokens);
    		abs_agent = parser.degagent();
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

}
