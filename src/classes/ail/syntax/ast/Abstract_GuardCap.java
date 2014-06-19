package ail.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.GMessage;
import ail.syntax.Term;
import ail.syntax.StringTerm;
import ail.syntax.GCapability;

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
 * Abstract version of an interface for References to capabilities appearing within Guards.
 * @author lad
 *
 */
public class Abstract_GuardCap implements Abstract_GuardAtom {
	Abstract_LogicalFormula pre;
	Abstract_LogicalFormula post;
	Abstract_Predicate cap;
	
	public Abstract_GuardCap(Abstract_LogicalFormula p, Abstract_Predicate c, Abstract_LogicalFormula pt) {
		pre = p;
		cap = c;
		post = pt;
	}
	
	public boolean isTrivial() {
		return false;
	}
	

	public GCapability toMCAPL() {
		return new GCapability(pre.toMCAPL(), cap.toMCAPL(), post.toMCAPL());
	}

	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ail.syntax.ast.Abstract_GuardCap");
		env.setReferenceField(objref, "pre", pre.newJPFObject(env));
		env.setReferenceField(objref, "post", post.newJPFObject(env));
		env.setReferenceField(objref, "cap", cap.newJPFObject(env));
		return objref;
	}

}
