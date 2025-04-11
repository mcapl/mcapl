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

package gwendolen.verifiableautonomoussystems.chapter3;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.util.AILexception;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ajpf.util.choice.UniformBoolChoice;

import java.util.Random;

/**
 * Environment for a simple example involving picking up blocks.
 * WARNING: This environment can not be used with record and replay because of the use of Random.
 * 
 * @author louiseadennis
 *
 */
public class SimpleEnv extends DefaultEnvironment {
	//Random r = new Random();
	UniformBoolChoice r;
	
	/**
	 * Constructor.
	 */
	public SimpleEnv() {
		super();
	}
	
		
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
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
        		addPercept(new Predicate("block1"));
        	}
        	if (r.nextBoolean()) {
        		addPercept(new Predicate("block2"));
        	}
       }
	   	
	   	try {
	   		theta = super.executeAction(agName, act);
    	} catch (AILexception e) {
    		throw e;
    	}

    	return theta;
   }

	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}
   

 
}
