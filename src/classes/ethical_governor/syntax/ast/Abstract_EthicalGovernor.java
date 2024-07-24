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
package ethical_governor.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ethical_governor.semantics.EthicalGovernor;
import ail.mas.MAS;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Predicate;

/**
 * An abstract class for Ethical Governors.  To be used in parsing.
 * @author louiseadennis
 *
 */
public class Abstract_EthicalGovernor extends Abstract_Agent {
	
	private String governed;
	
	private StringTuple[] scores = new StringTuple[0];
	
	private Abstract_Predicate[] precedence = new Abstract_Predicate[0];
	
	/**
	 * Constructor.
	 * @param s
	 */
	public Abstract_EthicalGovernor(String s) {
		super(s);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Agent#toMCAPL(ail.mas.MAS)
	 */
	public EthicalGovernor toMCAPL(MAS mas) {
		try {
			EthicalGovernor eg = new EthicalGovernor(mas, fAgName);
			addStructures(eg);
			return eg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Set the name of the governed agent.
	 * @param s
	 */
	public void setGoverned(String s) {
		governed = s;
	}
	
	/**
	 * Add a new score.
	 * @param p
	 * @param number
	 */
	public void addScore(String p, String number) {
       	int newsize = scores.length + 1;
    	StringTuple[] newscores = new StringTuple[newsize];
    	for (int i = 0; i < scores.length; i++) {
    		newscores[i] = scores[i];
    	}
    	newscores[scores.length] = new StringTuple(p, number);
    	scores = newscores;
	}
	
	/**
	 * Add a predicate to the precedence order.
	 * @param p
	 */
	public void addPrec(Abstract_Predicate p) {
		int newsize = precedence.length + 1;
		Abstract_Predicate[] newprecedence = new Abstract_Predicate[newsize];
		for (int i = 0; i < precedence.length; i++) {
			newprecedence[i] = precedence[i];
		}
		newprecedence[precedence.length] = p;
		precedence = newprecedence;
	}
	
	/**
	 * Helper method for constructing a concrete Ethical Governor from an abstract one.  Separated
	 * out from toMCAPL since this one does not need a MAS as an argument so can be used by
	 * Agent Builders.
	 * @param ag
	 */
	public void addStructures(EthicalGovernor ag) {
				ag.setGoverned(governed);

		    	for (StringTuple score: scores) {
		    		ag.setScore(score.getS1(), Integer.parseInt(score.getS2()));
		    	}
		    	
		    	for (Abstract_Predicate p: precedence) {
		    		ag.addPrec(p.toMCAPL());
		    	}

		    	try {
		    		ag.initAg();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		   

	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Agent#newJPFObject(gov.nasa.jpf.vm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ethical_governor.syntax.ast.Abstract_EthicalGovernor");
    	int gRef = env.newString(governed);
    	env.setReferenceField(objref, "governed", gRef);
    	
    	int sRef = env.newObjectArray("ethical_governor.syntax.ast.StringTuple", scores.length);
    	for (int i = 0; i < scores.length; i++) {
    		env.setReferenceArrayElement(sRef, i, scores[i].newJPFObject(env));
    	}
    	env.setReferenceField(objref, "scores", sRef);
    	
    	int pRef = env.newObjectArray("ethical_governor.syntax.ast.Abstract_Predicate", precedence.length);
    	for (int i = 0; i < precedence.length; i++) {
    		env.setReferenceArrayElement(pRef, i, precedence[i].newJPFObject(env));
    	}
    	env.setReferenceField(objref, "precedence", pRef);

		env.setReferenceField(objref, "fAgName", env.newString(fAgName));
		int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
		int goalRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
		int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
		int planRef = env.newObjectArray("ail.syntax.ast.Abstract_Plan", plans.length);
		int cRef = env.newObjectArray("ail.syntax.ast.Abstract_Capability", capabilities.length);
		for (int i = 0; i < beliefs.length; i++) {
			env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
		}
		for (int i = 0; i < goals.length; i++) {
			env.setReferenceArrayElement(goalRef, i, goals[i].newJPFObject(env));
		}
		for (int i = 0; i < rules.length; i++) {
			env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
		}
		for (int i = 0; i < plans.length; i++) {
			env.setReferenceArrayElement(planRef, i, plans[i].newJPFObject(env));
		}
		for (int i = 0; i < capabilities.length; i++) {
			env.setReferenceArrayElement(cRef, i, capabilities[i].newJPFObject(env));
		}
		env.setReferenceField(objref, "beliefs", bRef);
		env.setReferenceField(objref, "goals", goalRef);
		env.setReferenceField(objref, "rules", rRef);
		env.setReferenceField(objref, "plans", planRef);
		env.setReferenceField(objref, "capabilities", cRef);

    	return objref;
   	
    }
	

}
