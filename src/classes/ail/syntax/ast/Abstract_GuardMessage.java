package ail.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.GuardAtom;
import ail.syntax.GMessage;
import ail.syntax.Term;
import ail.syntax.StringTerm;

public class Abstract_GuardMessage implements Abstract_GuardAtom {
	Abstract_StringTerm sender;
	Abstract_StringTerm receiver;
	int ilf;
	Abstract_Term content;
	byte type;
	

	public Abstract_GuardMessage(byte t, Abstract_StringTerm s, Abstract_StringTerm r, int i, Abstract_Term c) {
		type = t;
		sender = s;
		receiver = r;
		ilf = i;
		content = c;
	}

	@Override
	public GMessage toMCAPL() {
		return new GMessage(type, ilf, (StringTerm) sender.toMCAPL(), (StringTerm) receiver.toMCAPL(), (Term) content.toMCAPL());
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
