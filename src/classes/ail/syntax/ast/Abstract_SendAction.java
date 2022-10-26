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

package ail.syntax.ast;

import java.util.ArrayList;
import java.util.List;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.SendAction;
import ail.syntax.Action;

/**
 * Generic Description of Abstract Classes in AIL and AJPF
 * -------------------------------------------------------
 * 
 * We use "Abstract" versions of syntax items for all bits of state that we sometimes wish to store in the native
 * java VM as well in the JavaPathfinder VM.  In particular files are parsed into the native VM and then the relevant
 * initial state of the multi-agent system is reconstructed in the model-checking VM.  This is done to improve
 * efficiency of parsing (the native VM is faster).  We also represent properties for model checking in the native VM 
 * and, indeed the property automata is stored only in the native VM.  We used Abstract classes partly because less
 * computational content is needed for these objects in the native VM and so a smaller representation can be used
 * but also because specific support is needed for transferring information between the two virtual machines both
 * in terms of methods and in terms of the data types chosen for the various fields.  It was felt preferable to 
 * separate these things out from the classes used for the objects that determine the run time behaviour of a MAS.
 * 
 * Abstract classes all have a method (toMCAPL) for creating a class for the equivalent concrete object used
 * when executing the MAS.  They also have a method (newJPFObject) that will create an equivalent object in the 
 * model-checking virtual machine from one that is held in the native VM.  At the start of execution the agent
 * program is parsed into abstract classes in the native VM.  An equivalent structure is then created in the JVM
 * using calls to newJPFObject and this structure is then converted into the structures used for executing the MAS
 * by calls to toMCAPL.
 * 
 */

/**
 * A class for AIL Send Actions.  These are actions with addition fields for 
 * performatives and ids.  It is assumed that the basic action is a term
 * with two arguments, the content and the receiver (as a StringTerm).
 * 
 * @author louiseadennis
 *
 */
public class Abstract_SendAction extends Abstract_Action {
	
	/**
	 * Illocutionary force.
	 */
	protected int ilf;
		
	/**
	 * The thId of the message.
	 */
	protected String thId;
	
	/**
	 * Create a send action froma recipient, ilf and content.
	 * 
	 * @param r The receiver
	 * @param i the illocutionary force of the message.
	 * @param c the content of the message.
	 */
	public Abstract_SendAction(Abstract_Term r, int i, Abstract_Term c) {
		super("send");
		// we add the unifiable bits of the content to the term.
		this.addTerm(c);
		this.addTerm(r);
		ilf = i;
		setActionType(Abstract_Action.sendAction);
	}
	
	public Abstract_SendAction(Abstract_Predicate a) {
		super("send");
		this.addTerm(a.getTerm(2));
		this.addTerm(a.getTerm(0));
		Double d = ((Abstract_NumberTermImpl) a.getTerm(1)).getValue();
		ilf = d.intValue();
		setActionType(Abstract_Action.sendAction);
	}
	
	public Abstract_SendAction() {
		super("send");
		setActionType(Abstract_Action.sendAction);
	}
	
	@Override
	 public void addParams(ArrayList<Abstract_Term> tl) {
		 Abstract_Term receiver = tl.get(0);
		 Abstract_NumberTermImpl i = (Abstract_NumberTermImpl) tl.get(1);
		 ilf = (int) i.getValue();
		 this.addTerm(receiver);
		 List<Abstract_Term> content = tl.subList(2, tl.size());
		 for (Abstract_Term t: content) {
			 this.addTerm(t);
		 }
	 }
		
	/**
	 * Getter for the illocutionary force.
	 * @return
	 */
	public int getILF() {
		return ilf;
	}
	
	/**
	 * getter for the recipeint.
	 * 
	 * @return
	 */
	public Abstract_Term getReceiver() {
		return this.getTerm(1);
	}
	
	/**
	 * Getter for the thread id.
	 * @return
	 */
	public String getThId() {
		return thId;
	}
	
	/**
	 * Getter for the message content.
	 * @return
	 */
	public Abstract_Term getContent() {
		return this.getTerm(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Action#toMCAPL()
	 */
	public SendAction toMCAPL() {
		Action s = super.toMCAPL();
		SendAction a = new SendAction(s, ilf);
		return a;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Predicate#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append(ilf);
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Action#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_SendAction");
		env.setReferenceField(objref, "functor", env.newString(getFunctor()));
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "actiontype", actiontype);
		env.setIntField(objref, "ilf", ilf);
		env.setReferenceField(objref, "thId", env.newString(thId));
		return objref;
	}

}
