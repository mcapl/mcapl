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

import ail.semantics.AILAgent;
import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Literal;
import ail.syntax.Term;
import ail.syntax.Predicate;
import ail.syntax.Goal;

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
 * Implements a class for Abstract AIL Deeds.  This may contain a term (Actions) or a 
 * literal (add/delete goals, add/delete beliefs).  They may also be the 
 * no-plan-yet Deed, a backtrack Deed, or a add/delete lock.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Deed extends Abstract_BaseAILStructure {

    /**
	 * The possible categories of Deed, represened as bytes.
	 */
	@FilterField
	public static final byte	DAction 	= AILAction;
	@FilterField
    public static final byte	Dnpy = 10;
	@FilterField
    public static final byte	Dbacktrack = 11;
	@FilterField
    public static final byte 	Dlock = 12;
	@FilterField
    public static final byte	Dwaitfor = 13;
	@FilterField
    public static final byte	DNull = 14;
	@FilterField
	public static final byte 	DPlan = 15;
	
	/**
	 * The logical content of the deed.
	 */
	Abstract_Term content;
	
	/**
	 * Does the deed have a trigger.  If so of what type?
	 */
	private int trigtype = 0;
	private boolean hastrigtype = false;

	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 */
	private Abstract_StringTerm DBnum = new Abstract_StringTermImpl(AILAgent.AILdefaultBBname);

	/**
	 * Setter for DBnum.
	 * @param n
	 */
    public void setDBnum(String n) {
    	DBnum = new Abstract_StringTermImpl(n);
    }
    
    /**
     * Setter for DBnum
     * @param n
     */
    public void setDBnum(Abstract_StringTerm n) {
    	DBnum = n;
    }
     
    /**
     * Getter for DBnum.
     * @return
     */
    public String getDBnum() {
    	return DBnum.getString();
    }
    

    /**
     * Construct a deed from a term, must be an action.
     * 
     * @param t the action.
     */
    public Abstract_Deed(Abstract_Predicate t) {
    	super(DAction);
    	content = t;
     }
    
    /**
     * Construct a Deed from an addition/deletion flag, Category and literal.
     * 
     * @param t whether the deed is an addition or deletion.
     * @param b the category of the deed.
     * @param l the literal contained in the deed.
     */
    public Abstract_Deed(int t, byte b, Abstract_Literal l) {
    	super(b);
    	content = l;
    	trigtype = t;
    	hastrigtype = true;
    }
        
    /**
     * Construct a Deed from an addition/deletion flag, Category and predicate.
     * 
     * @param t whether the deed is an addition or deletion.
     * @param b the category of the deed.
     * @param l the literal contained in the deed.
     */
    public Abstract_Deed(int t, byte b, Abstract_Predicate l) {
    	super(b);
    	content = l;
    	trigtype = t;
    	hastrigtype = true;
    }

    /**
     * Construct a Deed from an addition/deletion flag and a goal.  The
     * Category is determined to be a Goal category automatically.
     * 
     * @param t whether this is an add goal or delete goal Deed.
     * @param g the goal to be added or deleted.
     */
    public Abstract_Deed(int t, Abstract_Goal g) {
    	super(AILGoal);
    	content = g;
    	setDBnum(g.getGoalBase());
       	trigtype = t;
    	hastrigtype = true;
  }
    
    /**
     * Construct a Deed just from a Category.  To be used for no-plan-yet
     * and backtrack.
     * 
     * @param b the Category of the Deed.
     */
    public Abstract_Deed(byte b) {
    	super(b);
    }
    
    /**
     * Construct a Deed from an addition/deletion flag and a Category.
     * @param b whether the deed is an addition or a deletion.
     * @param by the category of the deed.
     */
    public Abstract_Deed(int b, byte by) {
    	super(by);
    	trigtype = b;
    	hastrigtype = true;
    }
    
    /**
     * Does this deed have a trigger type?
     * @return
     */
    public boolean hasTrigType() {
    	return hastrigtype;
    }
    
    /**
     * Is this deed an addition deed.
     * @return
     */
    public boolean isAddition() {
    	return trigtype == AILAddition;
    }
    
    /**
     * Is this deed a deletion deed.
     * @return
     */
    public boolean isDeletion() {
    	return trigtype == AILDeletion;
    }
    
    /**
     * Is this deed an update deed? i.e. it overwrites some previous value.
     * @return
     */
    public boolean isUpdate() {
    	return trigtype == AILUpdate;
    }
    
    /**
     * What is the logical content of this deed?
     * @return
     */
	public Abstract_Term getContent() {
		return content;
	}

	/**
	 * Convert the deed to a string for printing.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (hasTrigType()) {
			if (isAddition())	
				s.append("+");
			else if (isDeletion())
				s.append("-");
			else if (isUpdate())
				s.append("+-");
		}
					
		if (content != null & content instanceof Abstract_Goal) {
			s.append("!");
			s.append(getContent().toString());
		} else if (getCategory() == Dwaitfor) {
			s.append("*...");
			s.append(getContent().toString());
		} else if (content != null) {
			s.append(getContent().toString());
		} else if (getCategory() == Dnpy) {
			s.append("npy");
		} else if (isNull()) {
			s.append("null");
		} else {
			s.append("lock");
		}
		
		String num = getDBnum().toString();
		if (num.length() > 2) { // more than just quotes
			s.append("(").append(num).append(")");
		}
		
		return s.toString();
	}
	
    
    /**
     * Is this a null deed?
     */
    public boolean isNull() {
    	return (getCategory() == DNull);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_AILStructure#toMCAPL()
     */
    public Deed toMCAPL() {
		if (content != null) {
    		Term content_term = (Term) content.toMCAPL();
			if (content_term instanceof Goal) {
    			return new Deed(trigtype, (Goal) content_term);
    		}
    		if (content_term instanceof Literal) {
    			return new Deed(trigtype, getCategory(), (Literal) content_term);
    		}
    		if (content_term instanceof Predicate) {
    			if (getCategory() == DAction) {
    				return new Deed((Action) content_term);
    			} else if (hasTrigType()) {
    				return new Deed(trigtype, getCategory(), new Literal((Predicate) content_term));
    			}
    		}
    	}
		Deed d = new Deed(getCategory());
    	if (hastrigtype) {
			d.setTrigType(trigtype);
    	}
    	return d;

    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_AILStructure#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
     */
    public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_Deed");
		if (content != null) {
			env.setReferenceField(ref, "content", getContent().newJPFObject(env));
		}
		env.setByteField(ref,  "category", getCategory());
		env.setReferenceField(ref, "DBnum", DBnum.newJPFObject(env));
		env.setIntField(ref, "trigtype", trigtype);
		env.setBooleanField(ref, "hastrigtype", hastrigtype);
		return ref;

    }
    
    public void addParams(ArrayList<Abstract_Term> tl) {
    	if (content != null) {
    		getContent().addParams(tl);
    		
    	//	???? Need to sort into negative and positive params at some point;
    	} else {
    		if (getCategory() == Abstract_BaseAILStructure.AILGoal) {
    			if (tl.size() > 1) {
	    			content = new Abstract_Predicate("tuple");
	    			ArrayList<Abstract_Goal> ps = new ArrayList<Abstract_Goal>();
	    			for (Abstract_Term t: tl) {
	    				ps.add(new Abstract_Goal((Abstract_Predicate) t, Abstract_Goal.achieveGoal));
	    			}
	    			content.addParams(tl);
    			} else {
    				content = new Abstract_Goal((Abstract_Predicate) tl.get(0), Abstract_Goal.achieveGoal);
    			}
    		} else {
    			if (tl.size() > 1) {
	    			content = new Abstract_Predicate("tuple");
	    			content.addParams(tl);
    			} else {
    				content = tl.get(0);
    			}
    		}
    	}
    }
    
    public int getTrigType() {
    	return trigtype;
    }
    
    public void setTrigType(int t) {
    	trigtype = t;
    }
    
    public void setContent(Abstract_Term t) {
    	content = t;
    }
    

}
