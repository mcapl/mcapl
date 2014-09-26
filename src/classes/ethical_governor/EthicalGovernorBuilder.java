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
import ail.mas.MAS;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Plan;
import ail.syntax.ast.Abstract_Rule;


public class EthicalGovernorBuilder implements AgentBuilder {
	AILAgent agent;
	
	Abstract_Agent abs_agent;
	
	public EthicalGovernorBuilder() {}

	@Override
	public AILAgent getAgent(String filename) {
		parsefile(filename);
		
		try {
			AILAgent agent = new AILAgent(abs_agent.getAgName());
	    	for (Abstract_Literal l: abs_agent.beliefs) {
	    		agent.addInitialBel(l.toMCAPL());
	    	}
	    	for (Abstract_Rule r: abs_agent.rules) {
	    		agent.addRule(r.toMCAPL());
	    	}
	    	try {
	    		agent.initAg();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return agent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public void parsefile(String masstring) {
		try {
			ActionOnlyLexer lexer = new ActionOnlyLexer(new ANTLRFileStream(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ActionOnlyParser parser = new ActionOnlyParser(tokens);
    		abs_agent = parser.aoagent();
     	} catch (Exception e) {
     		e.printStackTrace();
    	}
		
	}

}
