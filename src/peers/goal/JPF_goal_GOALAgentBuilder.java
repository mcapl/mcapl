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

import ail.syntax.ast.Abstract_MAS;
import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import goal.syntax.ast.Abstract_GOALAgent;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.CommonTokenStream;

public class JPF_goal_GOALAgentBuilder extends NativePeer {


	@MJI
	public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
		//System.err.println("GOAL AGEMT BUILDER PEER B");
 		try {
			//GOALLexer lexer = new GOALLexer(new ANTLRFileStream(masstring));
			//CommonTokenStream tokens = new CommonTokenStream(lexer);
			//GOALParser parser = new GOALParser(tokens);
			//abs_agent = parser.goalagent();

 			GOALLexer lexer = new GOALLexer(new ANTLRFileStream(masstring));
 	    	CommonTokenStream tokens = new CommonTokenStream(lexer);
 	    	GOALParser parser = new GOALParser(tokens);
			Abstract_GOALAgent abs_agent = (Abstract_GOALAgent) parser.goalagent();
			int ref = abs_agent.newJPFObject(env);
			env.setReferenceField(objref, "abs_agent", ref);
		} catch (ClinitRequired e) {
			env.repeatInvocation();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
