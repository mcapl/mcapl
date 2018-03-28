// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.simple;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.util.AILexception;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

/**
 * A Simple Blocks' World Environment.
 * 
 * @author louiseadennis
 *
 */
public class SimpleEnv extends DefaultEnvironment {
	static String logname = "gwendolen.simple.SimpleEnv";
	
	UniformBoolChoice r;
	
	public SimpleEnv() {
		super();
	}		
	
	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();

	   	if (act.getFunctor().equals("pickup")) {
	   		Predicate object = (Predicate) act.getTerm(0);
     		removePercept(object);
	   	} else if (act.getFunctor().equals("putdown")) {
	   		Predicate object = (Predicate) act.getTerm(0);
	   		addPercept(object);
        } else if (act.getFunctor().equals("pickup1")) {
        	if (r.nextBoolean()) {
        		addPercept(new Predicate("block1"));
        	}
           	if (r.nextBoolean()) {
        		addPercept(new Predicate("block2"));
        	}
        } else if (act.getFunctor().equals("pickup2")) {
        	if (r.nextBoolean()) {
        		addPercept(new Predicate("block1"));
        	}
        	if (r.nextBoolean()) {
        		addPercept(new Predicate("block2"));
        	}
        } else if (act.getFunctor().equals("random")) {
        	if (r.nextBoolean()) {
        		AJPFLogger.info(logname, "Block 1 is visible");
        		addPercept(new Predicate("block1"));
        	} else {
        		AJPFLogger.info(logname, "Block 1 is not visible");
        	}
        	if (r.nextBoolean()) {
        		AJPFLogger.info(logname, "Block 2 is visible");
        		addPercept(new Predicate("block2"));
        	} else {
        		AJPFLogger.info(logname, "Block 2 is not visible");
        	}
       }
	   	
	   	try {
	   		theta = super.executeAction(agName, act);
    	} catch (AILexception e) {
    		throw e;
    	}

    	return theta;
   }
   
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}

 
}
