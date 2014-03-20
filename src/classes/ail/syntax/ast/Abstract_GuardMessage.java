package ail.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.GMessage;
import ail.syntax.Term;
import ail.syntax.StringTerm;

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
 * Abstract version of an interface for References to messages appearing within Guards.
 * @author lad
 *
 */
public class Abstract_GuardMessage implements Abstract_GuardAtom {
	Abstract_StringTerm sender;
	Abstract_StringTerm receiver;
	int ilf;
	Abstract_Term content;
	byte type;
	

	/**
	 * Constructor.
	 * @param t
	 * @param s
	 * @param r
	 * @param i
	 * @param c
	 */
	public Abstract_GuardMessage(byte t, Abstract_StringTerm s, Abstract_StringTerm r, int i, Abstract_Term c) {
		type = t;
		sender = s;
		receiver = r;
		ilf = i;
		content = c;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_GuardAtom#toMCAPL()
	 */
	public GMessage toMCAPL() {
		return new GMessage(type, ilf, (StringTerm) sender.toMCAPL(), (StringTerm) receiver.toMCAPL(), (Term) content.toMCAPL());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_GuardAtom#newJPFObject(gov.nasa.jpf.vm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ail.syntax.ast.Abstract_GuardMessage");
		env.setReferenceField(objref, "sender", sender.newJPFObject(env));
		env.setReferenceField(objref, "receiver", receiver.newJPFObject(env));
		env.setIntField(objref, "ilf", ilf);
		int contentref = content.newJPFObject(env);
		env.setReferenceField(objref, "content", contentref);
		env.setByteField(objref, "type", type);
		return objref;
	}

}
