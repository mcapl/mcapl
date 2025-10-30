// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.syntax.ast;

import java.util.ArrayList;
import java.util.List;

import goal.syntax.GOALSendAction;
import goal.syntax.GOALSendAction.RECEIVER;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Action;
import ail.syntax.SendAction;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_NumberTermImpl;
import ail.syntax.ast.Abstract_SendAction;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;

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
	
	protected GOALSendAction.RECEIVER receiver;
	protected int receiver_int;
	protected Abstract_Term receiver_term;


	public Abstract_GOALSendAction(int i) {
		super("send");
		setActionType(Abstract_Action.sendAction);
		type = i;
	}
	
	public GOALSendAction toMCAPL() {
		Action s = super.toMCAPL();
		
		GOALSendAction a = new GOALSendAction(s, receiver, ilf, type);
		a.setReceiverEnum(GOALSendAction.RECEIVER.fromInt(receiver_int));
		if (receiver_term != null) {
			if (receiver_term instanceof Abstract_VarTerm) {
				a.setReceiver(((Abstract_VarTerm) receiver_term).toMCAPL());
			} else {
				a.setReceiver(((Abstract_StringTermImpl) receiver_term).toMCAPL());
			}
		}
		return a;
		
	}
		
	@Override
	 public void addParams(ArrayList<Abstract_Term> tl) {
		 Abstract_Term rec = tl.get(0);
		 if (rec instanceof Abstract_NumberTermImpl) {
			 receiver = RECEIVER.fromInt((int)((Abstract_NumberTermImpl) rec).getValue());
		 } else {
			 receiver = RECEIVER.TERM;
			 receiver_term = rec;
		 }
		 Abstract_NumberTermImpl i = (Abstract_NumberTermImpl) tl.get(1);
		 ilf = (int) i.getValue();
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
		int objref = env.newObject("goal.syntax.ast.Abstract_GOALSendAction");
		env.setReferenceField(objref, "functor", env.newString(getFunctor()));
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "actiontype", actiontype);
		env.setIntField(objref, "ilf", ilf);
		env.setReferenceField(objref, "thId", env.newString(thId));
		env.setIntField(objref, "receiver_int", receiver.ordinal());
		if (receiver_term != null) {
			env.setReferenceField(objref, "receiver_term", receiver_term.newJPFObject(env));
		}



		return objref;
	}


}
