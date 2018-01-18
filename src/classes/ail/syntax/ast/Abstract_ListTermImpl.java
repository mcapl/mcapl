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

import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.Verify;
import ail.syntax.ListTermImpl;
import ail.syntax.ListTerm;
import ail.syntax.Term;

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
 * Abstract Syntax version of an implementation of list terms.
 * @author lad
 *
 */
public class Abstract_ListTermImpl implements Abstract_ListTerm {
	/**
	 * Head of the list.
	 */
	private Abstract_Term term;
	/**
	 * Tail of the list.
	 */
	private Abstract_ListTerm next;

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_ListTerm#append(ail.syntax.ast.Abstract_Term)
	 */
	public Abstract_ListTerm append(Abstract_Term t) {
		if (isEmpty()) {
			term = t;
			next = new Abstract_ListTermImpl();
			return this;
		} else if (isTail()) {
			// What to do?
			return null;
		} else {
			return getNext().append(t);
		}
	}
	
	/**
	 * Add a list of terms to the head of this list.
	 * @param tl
	 */
	@Override
	public void addAll(ArrayList<Abstract_Term> tl) {
		for (int i = tl.size() -1 ; i > -1; i--) {
			addHead(tl.get(i));
		}
	}

	/**
	 * Is this the empty list.
	 * @return
	 */
	public boolean isEmpty() {
		return term == null;
	}

	/** make a hard copy of the terms */
	public Abstract_ListTermImpl clone() {
		Abstract_ListTermImpl t = new Abstract_ListTermImpl();
		if (term != null) {
			t.term = this.term.clone();
		}
		if (next != null) {
			t.next = (Abstract_ListTerm)this.next.clone();
		}
		return t;
	}

	/**
	 * Does this list have no tail?  Should be mal-formed in this case, to be honest.
	 * @return
	 */
	public boolean isTail() {
		return next == null;
	}

	/**
	 * Return the tail of the list.
	 * @return
	 */
	public Abstract_ListTerm getNext() {
		return next;
	}

	@Override
	public Abstract_Term getTerm(int i) {
			if (i == 0) {
				return term;
			}
			if (i == 1) {
				return next;
			}
			return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_ListTerm#addHead(ail.syntax.ast.Abstract_Term)
	 */
	public void addHead(Abstract_Term h) {
		if (isEmpty()) {
			term = h;
			next = new Abstract_ListTermImpl();
		} else if (isTail()) {
			// What to do?
		} else {
			next = this.clone();
			term = h;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_ListTerm#addTail(ail.syntax.ast.Abstract_ListTerm)
	 */
	public void addTail(Abstract_ListTerm t) {
		Abstract_ListTermImpl tl = (Abstract_ListTermImpl) getNext();
		if (tl.isEmpty()) {
			next = t;
		} else {
			tl.addTail(t);
		}
	}

	@Override
	public int createInJPF(VM vm) {
		Verify.log("ail.syntax.ast.Abstract_ListTermImpl", Verify.WARNING, "Abstract_ListTermImpl should not be being created from Listener");
		return 0;
	}

	@Override
	public ListTermImpl toMCAPL() {
		ListTermImpl list = new ListTermImpl();
		if (term != null) {
		list.setHead((Term) term.toMCAPL());
		}
		if (next != null) {
		list.setTail((ListTerm) next.toMCAPL());
		}
		return list;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_ListTermImpl");
		if (term != null) {
			env.setReferenceField(objref, "term", term.newJPFObject(env));
		}
		if (next != null) {
			env.setReferenceField(objref, "next", next.newJPFObject(env));
		}
		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#unifies(ail.syntax.ast.Abstract_Term, ail.syntax.ast.Abstract_Unifier)
	 */
	public void unifies(Abstract_Term t, Abstract_Unifier u) {
		Abstract_ListTermImpl l = (Abstract_ListTermImpl) t;
		next.unifies(l.getNext(), u);
		term.unifies(l.term, u);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#apply(ail.syntax.ast.Abstract_Unifier)
	 */
	public Abstract_Term applyu(Abstract_Unifier u) {
		Abstract_ListTermImpl l = new Abstract_ListTermImpl();
		
		if (! isEmpty()) {
			l.addHead(term.applyu(u));
			l.addTail((Abstract_ListTerm) next.applyu(u));
		}
		
		return l;
	}
	
	public Abstract_ListTerm getTail() {
		return next;
	}
	
	public Abstract_Term getHead() {
		return term;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else if (getTail().isEmpty()) {
			return "[" + term.toString() + "]";
		} else if (getTail() instanceof Abstract_VarTerm) {
			return "[" + term.toString() + "|" + getTail().toString() + "]";
		} else {
			String tailstring = getTail().toString();
			String tailstringchomp = tailstring.substring(1, tailstring.length() - 1);
			return "[" + term.toString() + "," + tailstringchomp + "]";
		}
	}

	@Override
	public void addParams(ArrayList<Abstract_Term> tl) {
		System.err.println("WARNING: Do not add params to a listterm");
		
	}

}
