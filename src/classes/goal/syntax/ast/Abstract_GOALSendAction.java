package goal.syntax.ast;

import java.util.ArrayList;
import java.util.List;

import goal.syntax.GOALSendAction;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Action;
import ail.syntax.SendAction;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_NumberTermImpl;
import ail.syntax.ast.Abstract_SendAction;
import ail.syntax.ast.Abstract_Term;

public class Abstract_GOALSendAction extends Abstract_Action {
	int type = 0;
	
	/**
	 * Illocutionary force.
	 */
	protected int ilf;
		
	/**
	 * The thId of the message.
	 */
	protected String thId;

	public Abstract_GOALSendAction(int i) {
		super("send");
		setActionType(Abstract_Action.sendAction);
		type = i;
	}
	
	public GOALSendAction toMCAPL() {
		Action s = super.toMCAPL();
		GOALSendAction a = new GOALSendAction(s, ilf, type);
		return a;
		
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

	
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Action#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_GOALSendAction");
		env.setReferenceField(objref, "functor", env.newString(getFunctor()));
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "actiontype", actiontype);
		env.setIntField(objref, "ilf", ilf);
		env.setReferenceField(objref, "thId", env.newString(thId));
		return objref;
	}


}
